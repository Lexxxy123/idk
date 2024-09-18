/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package org.sqlite;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.Executor;
import org.sqlite.SQLiteCommitListener;
import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteConnectionConfig;
import org.sqlite.SQLiteLimits;
import org.sqlite.SQLiteUpdateListener;
import org.sqlite.core.CoreDatabaseMetaData;
import org.sqlite.core.DB;
import org.sqlite.core.NativeDB;
import org.sqlite.jdbc4.JDBC4DatabaseMetaData;

public abstract class SQLiteConnection
implements Connection {
    private static final String RESOURCE_NAME_PREFIX = ":resource:";
    private final DB db;
    private CoreDatabaseMetaData meta = null;
    private final SQLiteConnectionConfig connectionConfig;
    private SQLiteConfig.TransactionMode currentTransactionMode;
    private boolean firstStatementExecuted = false;

    public SQLiteConnection(DB db) {
        this.db = db;
        this.connectionConfig = db.getConfig().newConnectionConfig();
    }

    public SQLiteConnection(String url, String fileName) throws SQLException {
        this(url, fileName, new Properties());
    }

    public SQLiteConnection(String url, String fileName, Properties prop) throws SQLException {
        DB newDB = null;
        try {
            this.db = newDB = SQLiteConnection.open(url, fileName, prop);
            SQLiteConfig config = this.db.getConfig();
            this.connectionConfig = this.db.getConfig().newConnectionConfig();
            config.apply(this);
            this.currentTransactionMode = this.getDatabase().getConfig().getTransactionMode();
            this.firstStatementExecuted = false;
        } catch (Throwable t2) {
            try {
                if (newDB != null) {
                    newDB.close();
                }
            } catch (Exception e2) {
                t2.addSuppressed(e2);
            }
            throw t2;
        }
    }

    public SQLiteConfig.TransactionMode getCurrentTransactionMode() {
        return this.currentTransactionMode;
    }

    public void setCurrentTransactionMode(SQLiteConfig.TransactionMode currentTransactionMode) {
        this.currentTransactionMode = currentTransactionMode;
    }

    public void setFirstStatementExecuted(boolean firstStatementExecuted) {
        this.firstStatementExecuted = firstStatementExecuted;
    }

    public boolean isFirstStatementExecuted() {
        return this.firstStatementExecuted;
    }

    public SQLiteConnectionConfig getConnectionConfig() {
        return this.connectionConfig;
    }

    public CoreDatabaseMetaData getSQLiteDatabaseMetaData() throws SQLException {
        this.checkOpen();
        if (this.meta == null) {
            this.meta = new JDBC4DatabaseMetaData(this);
        }
        return this.meta;
    }

    @Override
    public DatabaseMetaData getMetaData() throws SQLException {
        return this.getSQLiteDatabaseMetaData();
    }

    public String getUrl() {
        return this.db.getUrl();
    }

    @Override
    public void setSchema(String schema) throws SQLException {
    }

    @Override
    public String getSchema() throws SQLException {
        return null;
    }

    @Override
    public void abort(Executor executor) throws SQLException {
    }

    @Override
    public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
    }

    @Override
    public int getNetworkTimeout() throws SQLException {
        return 0;
    }

    protected void checkCursor(int rst, int rsc, int rsh) throws SQLException {
        if (rst != 1003) {
            throw new SQLException("SQLite only supports TYPE_FORWARD_ONLY cursors");
        }
        if (rsc != 1007) {
            throw new SQLException("SQLite only supports CONCUR_READ_ONLY cursors");
        }
        if (rsh != 2) {
            throw new SQLException("SQLite only supports closing cursors at commit");
        }
    }

    protected void setTransactionMode(SQLiteConfig.TransactionMode mode) {
        this.connectionConfig.setTransactionMode(mode);
    }

    @Override
    public int getTransactionIsolation() {
        return this.connectionConfig.getTransactionIsolation();
    }

    @Override
    public void setTransactionIsolation(int level) throws SQLException {
        this.checkOpen();
        switch (level) {
            case 2: 
            case 4: 
            case 8: {
                this.getDatabase().exec("PRAGMA read_uncommitted = false;", this.getAutoCommit());
                break;
            }
            case 1: {
                this.getDatabase().exec("PRAGMA read_uncommitted = true;", this.getAutoCommit());
                break;
            }
            default: {
                throw new SQLException("Unsupported transaction isolation level: " + level + ". Must be one of TRANSACTION_READ_UNCOMMITTED, TRANSACTION_READ_COMMITTED, TRANSACTION_REPEATABLE_READ, or TRANSACTION_SERIALIZABLE in java.sql.Connection");
            }
        }
        this.connectionConfig.setTransactionIsolation(level);
    }

    private static DB open(String url, String origFileName, Properties props) throws SQLException {
        Properties newProps = new Properties();
        newProps.putAll(props);
        String fileName = SQLiteConnection.extractPragmasFromFilename(url, origFileName, newProps);
        SQLiteConfig config = new SQLiteConfig(newProps);
        if (!(fileName.isEmpty() || ":memory:".equals(fileName) || fileName.startsWith("file:") || fileName.contains("mode=memory"))) {
            if (fileName.startsWith(RESOURCE_NAME_PREFIX)) {
                String resourceName = fileName.substring(RESOURCE_NAME_PREFIX.length());
                ClassLoader contextCL = Thread.currentThread().getContextClassLoader();
                URL resourceAddr = contextCL.getResource(resourceName);
                if (resourceAddr == null) {
                    try {
                        resourceAddr = new URL(resourceName);
                    } catch (MalformedURLException e2) {
                        throw new SQLException(String.format("resource %s not found: %s", resourceName, e2));
                    }
                }
                try {
                    fileName = SQLiteConnection.extractResource(resourceAddr).getAbsolutePath();
                } catch (IOException e3) {
                    throw new SQLException(String.format("failed to load %s: %s", resourceName, e3));
                }
            }
            File file = new File(fileName).getAbsoluteFile();
            File parent = file.getParentFile();
            if (parent != null && !parent.exists()) {
                for (File up = parent; up != null && !up.exists(); up = up.getParentFile()) {
                    parent = up;
                }
                throw new SQLException("path to '" + fileName + "': '" + parent + "' does not exist");
            }
            try {
                if (!file.exists() && file.createNewFile()) {
                    file.delete();
                }
            } catch (Exception e4) {
                throw new SQLException("opening db: '" + fileName + "': " + e4.getMessage());
            }
            fileName = file.getAbsolutePath();
        }
        NativeDB db = null;
        try {
            NativeDB.load();
            db = new NativeDB(url, fileName, config);
        } catch (Exception e5) {
            SQLException err = new SQLException("Error opening connection");
            err.initCause(e5);
            throw err;
        }
        db.open(fileName, config.getOpenModeFlags());
        return db;
    }

    private static File extractResource(URL resourceAddr) throws IOException {
        if (resourceAddr.getProtocol().equals("file")) {
            try {
                return new File(resourceAddr.toURI());
            } catch (URISyntaxException e2) {
                throw new IOException(e2.getMessage());
            }
        }
        String tempFolder = new File(System.getProperty("java.io.tmpdir")).getAbsolutePath();
        String dbFileName = String.format("sqlite-jdbc-tmp-%s.db", UUID.randomUUID());
        File dbFile = new File(tempFolder, dbFileName);
        if (dbFile.exists()) {
            long tmpFileLastModified;
            long resourceLastModified = resourceAddr.openConnection().getLastModified();
            if (resourceLastModified < (tmpFileLastModified = dbFile.lastModified())) {
                return dbFile;
            }
            boolean deletionSucceeded = dbFile.delete();
            if (!deletionSucceeded) {
                throw new IOException("failed to remove existing DB file: " + dbFile.getAbsolutePath());
            }
        }
        URLConnection conn = resourceAddr.openConnection();
        conn.setUseCaches(false);
        try (InputStream reader = conn.getInputStream();){
            Files.copy(reader, dbFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            File file = dbFile;
            return file;
        }
    }

    public DB getDatabase() {
        return this.db;
    }

    @Override
    public boolean getAutoCommit() throws SQLException {
        this.checkOpen();
        return this.connectionConfig.isAutoCommit();
    }

    @Override
    public void setAutoCommit(boolean ac2) throws SQLException {
        this.checkOpen();
        if (this.connectionConfig.isAutoCommit() == ac2) {
            return;
        }
        this.connectionConfig.setAutoCommit(ac2);
        if (this.getConnectionConfig().isAutoCommit()) {
            this.db.exec("commit;", ac2);
            this.currentTransactionMode = null;
        } else {
            this.db.exec(this.transactionPrefix(), ac2);
            this.currentTransactionMode = this.getConnectionConfig().getTransactionMode();
        }
    }

    public int getBusyTimeout() {
        return this.db.getConfig().getBusyTimeout();
    }

    public void setBusyTimeout(int timeoutMillis) throws SQLException {
        this.db.getConfig().setBusyTimeout(timeoutMillis);
        this.db.busy_timeout(timeoutMillis);
    }

    public void setLimit(SQLiteLimits limit, int value) throws SQLException {
        if (value >= 0) {
            this.db.limit(limit.getId(), value);
        }
    }

    public void getLimit(SQLiteLimits limit) throws SQLException {
        this.db.limit(limit.getId(), -1);
    }

    @Override
    public boolean isClosed() throws SQLException {
        return this.db.isClosed();
    }

    @Override
    public void close() throws SQLException {
        if (this.isClosed()) {
            return;
        }
        if (this.meta != null) {
            this.meta.close();
        }
        this.db.close();
    }

    protected void checkOpen() throws SQLException {
        if (this.isClosed()) {
            throw new SQLException("database connection closed");
        }
    }

    public String libversion() throws SQLException {
        this.checkOpen();
        return this.db.libversion();
    }

    @Override
    public void commit() throws SQLException {
        this.checkOpen();
        if (this.connectionConfig.isAutoCommit()) {
            throw new SQLException("database in auto-commit mode");
        }
        this.db.exec("commit;", this.getAutoCommit());
        this.db.exec(this.transactionPrefix(), this.getAutoCommit());
        this.firstStatementExecuted = false;
        this.setCurrentTransactionMode(this.getConnectionConfig().getTransactionMode());
    }

    @Override
    public void rollback() throws SQLException {
        this.checkOpen();
        if (this.connectionConfig.isAutoCommit()) {
            throw new SQLException("database in auto-commit mode");
        }
        this.db.exec("rollback;", this.getAutoCommit());
        this.db.exec(this.transactionPrefix(), this.getAutoCommit());
        this.firstStatementExecuted = false;
        this.setCurrentTransactionMode(this.getConnectionConfig().getTransactionMode());
    }

    public void addUpdateListener(SQLiteUpdateListener listener) {
        this.db.addUpdateListener(listener);
    }

    public void removeUpdateListener(SQLiteUpdateListener listener) {
        this.db.removeUpdateListener(listener);
    }

    public void addCommitListener(SQLiteCommitListener listener) {
        this.db.addCommitListener(listener);
    }

    public void removeCommitListener(SQLiteCommitListener listener) {
        this.db.removeCommitListener(listener);
    }

    protected static String extractPragmasFromFilename(String url, String filename, Properties prop) throws SQLException {
        int parameterDelimiter = filename.indexOf(63);
        if (parameterDelimiter == -1) {
            return filename;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(filename.substring(0, parameterDelimiter));
        int nonPragmaCount = 0;
        String[] parameters = filename.substring(parameterDelimiter + 1).split("&");
        for (int i2 = 0; i2 < parameters.length; ++i2) {
            String parameter = parameters[parameters.length - 1 - i2].trim();
            if (parameter.isEmpty()) continue;
            String[] kvp = parameter.split("=");
            String key = kvp[0].trim().toLowerCase();
            if (SQLiteConfig.pragmaSet.contains(key)) {
                if (kvp.length == 1) {
                    throw new SQLException(String.format("Please specify a value for PRAGMA %s in URL %s", key, url));
                }
                String value = kvp[1].trim();
                if (value.isEmpty() || prop.containsKey(key)) continue;
                prop.setProperty(key, value);
                continue;
            }
            sb.append(nonPragmaCount == 0 ? (char)'?' : '&');
            sb.append(parameter);
            ++nonPragmaCount;
        }
        String newFilename = sb.toString();
        return newFilename;
    }

    protected String transactionPrefix() {
        return this.connectionConfig.transactionPrefix();
    }

    public byte[] serialize(String schema) throws SQLException {
        return this.db.serialize(schema);
    }

    public void deserialize(String schema, byte[] buff) throws SQLException {
        this.db.deserialize(schema, buff);
    }
}

