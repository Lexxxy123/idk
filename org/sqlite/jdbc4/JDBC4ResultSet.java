/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package org.sqlite.jdbc4;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;
import org.sqlite.core.CoreStatement;
import org.sqlite.jdbc3.JDBC3ResultSet;
import org.sqlite.jdbc4.JDBC4Statement;

public class JDBC4ResultSet
extends JDBC3ResultSet
implements ResultSet,
ResultSetMetaData {
    public JDBC4ResultSet(CoreStatement stmt) {
        super(stmt);
    }

    @Override
    public void close() throws SQLException {
        boolean wasOpen = this.isOpen();
        super.close();
        if (wasOpen && this.stmt instanceof JDBC4Statement) {
            JDBC4Statement stat = (JDBC4Statement)this.stmt;
            if (stat.closeOnCompletion && !stat.isClosed()) {
                stat.close();
            }
        }
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws ClassCastException {
        return iface.cast(this);
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) {
        return iface.isInstance(this);
    }

    @Override
    public RowId getRowId(int columnIndex) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public RowId getRowId(String columnLabel) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateRowId(int columnIndex, RowId x2) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateRowId(String columnLabel, RowId x2) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public int getHoldability() throws SQLException {
        return 0;
    }

    @Override
    public boolean isClosed() throws SQLException {
        return !this.isOpen();
    }

    @Override
    public void updateNString(int columnIndex, String nString) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateNString(String columnLabel, String nString) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateNClob(int columnIndex, NClob nClob) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateNClob(String columnLabel, NClob nClob) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public NClob getNClob(int columnIndex) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public NClob getNClob(String columnLabel) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public SQLXML getSQLXML(int columnIndex) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public SQLXML getSQLXML(String columnLabel) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateSQLXML(int columnIndex, SQLXML xmlObject) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateSQLXML(String columnLabel, SQLXML xmlObject) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public String getNString(int columnIndex) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public String getNString(String columnLabel) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public Reader getNCharacterStream(int col) throws SQLException {
        String data = this.getString(col);
        return this.getNCharacterStreamInternal(data);
    }

    private Reader getNCharacterStreamInternal(String data) {
        if (data == null) {
            return null;
        }
        StringReader reader = new StringReader(data);
        return reader;
    }

    @Override
    public Reader getNCharacterStream(String col) throws SQLException {
        String data = this.getString(col);
        return this.getNCharacterStreamInternal(data);
    }

    @Override
    public void updateNCharacterStream(int columnIndex, Reader x2, long length) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateNCharacterStream(String columnLabel, Reader reader, long length) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateAsciiStream(int columnIndex, InputStream x2, long length) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateBinaryStream(int columnIndex, InputStream x2, long length) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateCharacterStream(int columnIndex, Reader x2, long length) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateAsciiStream(String columnLabel, InputStream x2, long length) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateBinaryStream(String columnLabel, InputStream x2, long length) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateCharacterStream(String columnLabel, Reader reader, long length) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateBlob(int columnIndex, InputStream inputStream, long length) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateBlob(String columnLabel, InputStream inputStream, long length) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateClob(int columnIndex, Reader reader, long length) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateClob(String columnLabel, Reader reader, long length) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateNClob(int columnIndex, Reader reader, long length) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateNClob(String columnLabel, Reader reader, long length) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateNCharacterStream(int columnIndex, Reader x2) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateNCharacterStream(String columnLabel, Reader reader) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateAsciiStream(int columnIndex, InputStream x2) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateBinaryStream(int columnIndex, InputStream x2) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateCharacterStream(int columnIndex, Reader x2) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateAsciiStream(String columnLabel, InputStream x2) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateBinaryStream(String columnLabel, InputStream x2) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateCharacterStream(String columnLabel, Reader reader) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateBlob(int columnIndex, InputStream inputStream) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateBlob(String columnLabel, InputStream inputStream) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateClob(int columnIndex, Reader reader) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateClob(String columnLabel, Reader reader) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateNClob(int columnIndex, Reader reader) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public void updateNClob(String columnLabel, Reader reader) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public <T> T getObject(int columnIndex, Class<T> type) throws SQLException {
        if (type == null) {
            throw new SQLException("requested type cannot be null");
        }
        if (type == String.class) {
            return type.cast(this.getString(columnIndex));
        }
        if (type == Boolean.class) {
            return type.cast(this.getBoolean(columnIndex));
        }
        if (type == BigDecimal.class) {
            return type.cast(this.getBigDecimal(columnIndex));
        }
        if (type == byte[].class) {
            return type.cast(this.getBytes(columnIndex));
        }
        if (type == Date.class) {
            return type.cast(this.getDate(columnIndex));
        }
        if (type == Time.class) {
            return type.cast(this.getTime(columnIndex));
        }
        if (type == Timestamp.class) {
            return type.cast(this.getTimestamp(columnIndex));
        }
        if (type == LocalDate.class) {
            try {
                Date date = this.getDate(columnIndex);
                if (date != null) {
                    return type.cast(date.toLocalDate());
                }
                return null;
            } catch (SQLException sqlException) {
                return type.cast(LocalDate.parse(this.getString(columnIndex)));
            }
        }
        if (type == LocalTime.class) {
            try {
                Time time = this.getTime(columnIndex);
                if (time != null) {
                    return type.cast(time.toLocalTime());
                }
                return null;
            } catch (SQLException sqlException) {
                return type.cast(LocalTime.parse(this.getString(columnIndex)));
            }
        }
        if (type == LocalDateTime.class) {
            try {
                Timestamp timestamp = this.getTimestamp(columnIndex);
                if (timestamp != null) {
                    return type.cast(timestamp.toLocalDateTime());
                }
                return null;
            } catch (SQLException e2) {
                return type.cast(LocalDateTime.parse(this.getString(columnIndex)));
            }
        }
        int columnType = this.safeGetColumnType(this.markCol(columnIndex));
        if (type == Double.class) {
            if (columnType == 1 || columnType == 2) {
                return type.cast(this.getDouble(columnIndex));
            }
            throw new SQLException("Bad value for type Double");
        }
        if (type == Long.class) {
            if (columnType == 1 || columnType == 2) {
                return type.cast(this.getLong(columnIndex));
            }
            throw new SQLException("Bad value for type Long");
        }
        if (type == Float.class) {
            if (columnType == 1 || columnType == 2) {
                return type.cast(Float.valueOf(this.getFloat(columnIndex)));
            }
            throw new SQLException("Bad value for type Float");
        }
        if (type == Integer.class) {
            if (columnType == 1 || columnType == 2) {
                return type.cast(this.getInt(columnIndex));
            }
            throw new SQLException("Bad value for type Integer");
        }
        throw this.unsupported();
    }

    @Override
    public <T> T getObject(String columnLabel, Class<T> type) throws SQLException {
        return this.getObject(this.findColumn(columnLabel), type);
    }

    protected SQLException unsupported() {
        return new SQLFeatureNotSupportedException("not implemented by SQLite JDBC driver");
    }

    @Override
    public Array getArray(int i2) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public Array getArray(String col) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public InputStream getAsciiStream(int col) throws SQLException {
        String data = this.getString(col);
        return this.getAsciiStreamInternal(data);
    }

    @Override
    public InputStream getAsciiStream(String col) throws SQLException {
        String data = this.getString(col);
        return this.getAsciiStreamInternal(data);
    }

    private InputStream getAsciiStreamInternal(String data) {
        ByteArrayInputStream inputStream;
        if (data == null) {
            return null;
        }
        try {
            inputStream = new ByteArrayInputStream(data.getBytes("ASCII"));
        } catch (UnsupportedEncodingException e2) {
            return null;
        }
        return inputStream;
    }

    @Override
    @Deprecated
    public BigDecimal getBigDecimal(int col, int s2) throws SQLException {
        throw this.unsupported();
    }

    @Override
    @Deprecated
    public BigDecimal getBigDecimal(String col, int s2) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public Blob getBlob(int col) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public Blob getBlob(String col) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public Clob getClob(int col) throws SQLException {
        String clob = this.getString(col);
        return clob == null ? null : new SqliteClob(clob);
    }

    @Override
    public Clob getClob(String col) throws SQLException {
        String clob = this.getString(col);
        return clob == null ? null : new SqliteClob(clob);
    }

    public Object getObject(int col, Map map) throws SQLException {
        throw this.unsupported();
    }

    public Object getObject(String col, Map map) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public Ref getRef(int i2) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public Ref getRef(String col) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public InputStream getUnicodeStream(int col) throws SQLException {
        return this.getAsciiStream(col);
    }

    @Override
    public InputStream getUnicodeStream(String col) throws SQLException {
        return this.getAsciiStream(col);
    }

    @Override
    public URL getURL(int col) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public URL getURL(String col) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public void insertRow() throws SQLException {
        throw new SQLException("ResultSet is TYPE_FORWARD_ONLY");
    }

    @Override
    public void moveToCurrentRow() throws SQLException {
        throw new SQLException("ResultSet is TYPE_FORWARD_ONLY");
    }

    @Override
    public void moveToInsertRow() throws SQLException {
        throw new SQLException("ResultSet is TYPE_FORWARD_ONLY");
    }

    @Override
    public boolean last() throws SQLException {
        throw new SQLException("ResultSet is TYPE_FORWARD_ONLY");
    }

    @Override
    public boolean previous() throws SQLException {
        throw new SQLException("ResultSet is TYPE_FORWARD_ONLY");
    }

    @Override
    public boolean relative(int rows) throws SQLException {
        throw new SQLException("ResultSet is TYPE_FORWARD_ONLY");
    }

    @Override
    public boolean absolute(int row) throws SQLException {
        throw new SQLException("ResultSet is TYPE_FORWARD_ONLY");
    }

    @Override
    public void afterLast() throws SQLException {
        throw new SQLException("ResultSet is TYPE_FORWARD_ONLY");
    }

    @Override
    public void beforeFirst() throws SQLException {
        throw new SQLException("ResultSet is TYPE_FORWARD_ONLY");
    }

    @Override
    public boolean first() throws SQLException {
        throw new SQLException("ResultSet is TYPE_FORWARD_ONLY");
    }

    @Override
    public void cancelRowUpdates() throws SQLException {
        throw this.unsupported();
    }

    @Override
    public void deleteRow() throws SQLException {
        throw this.unsupported();
    }

    @Override
    public void updateArray(int col, Array x2) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public void updateArray(String col, Array x2) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public void updateAsciiStream(int col, InputStream x2, int l2) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public void updateAsciiStream(String col, InputStream x2, int l2) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public void updateBigDecimal(int col, BigDecimal x2) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public void updateBigDecimal(String col, BigDecimal x2) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public void updateBinaryStream(int c2, InputStream x2, int l2) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public void updateBinaryStream(String c2, InputStream x2, int l2) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public void updateBlob(int col, Blob x2) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public void updateBlob(String col, Blob x2) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public void updateBoolean(int col, boolean x2) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public void updateBoolean(String col, boolean x2) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public void updateByte(int col, byte x2) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public void updateByte(String col, byte x2) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public void updateBytes(int col, byte[] x2) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public void updateBytes(String col, byte[] x2) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public void updateCharacterStream(int c2, Reader x2, int l2) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public void updateCharacterStream(String c2, Reader r2, int l2) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public void updateClob(int col, Clob x2) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public void updateClob(String col, Clob x2) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public void updateDate(int col, Date x2) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public void updateDate(String col, Date x2) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public void updateDouble(int col, double x2) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public void updateDouble(String col, double x2) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public void updateFloat(int col, float x2) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public void updateFloat(String col, float x2) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public void updateInt(int col, int x2) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public void updateInt(String col, int x2) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public void updateLong(int col, long x2) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public void updateLong(String col, long x2) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public void updateNull(int col) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public void updateNull(String col) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public void updateObject(int c2, Object x2) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public void updateObject(int c2, Object x2, int s2) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public void updateObject(String col, Object x2) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public void updateObject(String c2, Object x2, int s2) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public void updateRef(int col, Ref x2) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public void updateRef(String c2, Ref x2) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public void updateRow() throws SQLException {
        throw this.unsupported();
    }

    @Override
    public void updateShort(int c2, short x2) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public void updateShort(String c2, short x2) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public void updateString(int c2, String x2) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public void updateString(String c2, String x2) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public void updateTime(int c2, Time x2) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public void updateTime(String c2, Time x2) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public void updateTimestamp(int c2, Timestamp x2) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public void updateTimestamp(String c2, Timestamp x2) throws SQLException {
        throw this.unsupported();
    }

    @Override
    public void refreshRow() throws SQLException {
        throw this.unsupported();
    }

    class SqliteClob
    implements NClob {
        private String data;

        protected SqliteClob(String data) {
            this.data = data;
        }

        @Override
        public void free() throws SQLException {
            this.data = null;
        }

        @Override
        public InputStream getAsciiStream() throws SQLException {
            return JDBC4ResultSet.this.getAsciiStreamInternal(this.data);
        }

        @Override
        public Reader getCharacterStream() throws SQLException {
            return JDBC4ResultSet.this.getNCharacterStreamInternal(this.data);
        }

        @Override
        public Reader getCharacterStream(long arg0, long arg1) throws SQLException {
            return JDBC4ResultSet.this.getNCharacterStreamInternal(this.data);
        }

        @Override
        public String getSubString(long position, int length) throws SQLException {
            if (this.data == null) {
                throw new SQLException("no data");
            }
            if (position < 1L) {
                throw new SQLException("Position must be greater than or equal to 1");
            }
            if (length < 0) {
                throw new SQLException("Length must be greater than or equal to 0");
            }
            int start = (int)position - 1;
            return this.data.substring(start, Math.min(start + length, this.data.length()));
        }

        @Override
        public long length() throws SQLException {
            if (this.data == null) {
                throw new SQLException("no data");
            }
            return this.data.length();
        }

        @Override
        public long position(String arg0, long arg1) throws SQLException {
            JDBC4ResultSet.this.unsupported();
            return -1L;
        }

        @Override
        public long position(Clob arg0, long arg1) throws SQLException {
            JDBC4ResultSet.this.unsupported();
            return -1L;
        }

        @Override
        public OutputStream setAsciiStream(long arg0) throws SQLException {
            JDBC4ResultSet.this.unsupported();
            return null;
        }

        @Override
        public Writer setCharacterStream(long arg0) throws SQLException {
            JDBC4ResultSet.this.unsupported();
            return null;
        }

        @Override
        public int setString(long arg0, String arg1) throws SQLException {
            JDBC4ResultSet.this.unsupported();
            return -1;
        }

        @Override
        public int setString(long arg0, String arg1, int arg2, int arg3) throws SQLException {
            JDBC4ResultSet.this.unsupported();
            return -1;
        }

        @Override
        public void truncate(long arg0) throws SQLException {
            JDBC4ResultSet.this.unsupported();
        }
    }
}

