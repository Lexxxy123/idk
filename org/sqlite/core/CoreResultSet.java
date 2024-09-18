/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package org.sqlite.core;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import org.sqlite.SQLiteConnectionConfig;
import org.sqlite.core.Codes;
import org.sqlite.core.CoreStatement;
import org.sqlite.core.DB;

public abstract class CoreResultSet
implements Codes {
    protected final CoreStatement stmt;
    public boolean emptyResultSet = false;
    public boolean open = false;
    public long maxRows;
    public String[] cols = null;
    public String[] colsMeta = null;
    protected boolean[][] meta = null;
    protected int limitRows;
    protected int row = 0;
    protected boolean pastLastRow = false;
    protected int lastCol;
    public boolean closeStmt;
    protected Map<String, Integer> columnNameToIndex = null;

    protected CoreResultSet(CoreStatement stmt) {
        this.stmt = stmt;
    }

    protected DB getDatabase() {
        return this.stmt.getDatabase();
    }

    protected SQLiteConnectionConfig getConnectionConfig() {
        return this.stmt.getConnectionConfig();
    }

    public boolean isOpen() {
        return this.open;
    }

    protected void checkOpen() throws SQLException {
        if (!this.open) {
            throw new SQLException("ResultSet closed");
        }
    }

    public int checkCol(int col) throws SQLException {
        if (this.colsMeta == null) {
            throw new SQLException("SQLite JDBC: inconsistent internal state");
        }
        if (col < 1 || col > this.colsMeta.length) {
            throw new SQLException("column " + col + " out of bounds [1," + this.colsMeta.length + "]");
        }
        return --col;
    }

    protected int markCol(int col) throws SQLException {
        this.checkCol(col);
        this.lastCol = col--;
        return col;
    }

    public void checkMeta() throws SQLException {
        this.checkCol(1);
        if (this.meta == null) {
            this.meta = this.stmt.pointer.safeRun(DB::column_metadata);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void close() throws SQLException {
        DB db;
        this.cols = null;
        this.colsMeta = null;
        this.meta = null;
        this.limitRows = 0;
        this.row = 0;
        this.pastLastRow = false;
        this.lastCol = -1;
        this.columnNameToIndex = null;
        this.emptyResultSet = false;
        if (this.stmt.pointer.isClosed() || !this.open && !this.closeStmt) {
            return;
        }
        DB dB = db = this.stmt.getDatabase();
        synchronized (dB) {
            if (!this.stmt.pointer.isClosed()) {
                this.stmt.pointer.safeRunInt(DB::reset);
                if (this.closeStmt) {
                    this.closeStmt = false;
                    ((Statement)((Object)this.stmt)).close();
                }
            }
        }
        this.open = false;
    }

    protected Integer findColumnIndexInCache(String col) {
        if (this.columnNameToIndex == null) {
            return null;
        }
        return this.columnNameToIndex.get(col);
    }

    protected int addColumnIndexInCache(String col, int index) {
        if (this.columnNameToIndex == null) {
            this.columnNameToIndex = new HashMap<String, Integer>(this.cols.length);
        }
        this.columnNameToIndex.put(col, index);
        return index;
    }
}

