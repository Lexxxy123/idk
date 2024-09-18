/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javax.xml.bind;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.DatatypeConverterInterface;
import javax.xml.bind.WhiteSpaceProcessor;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;

final class DatatypeConverterImpl
implements DatatypeConverterInterface {
    public static final DatatypeConverterInterface theInstance = new DatatypeConverterImpl();
    private static final char[] hexCode = "0123456789ABCDEF".toCharArray();
    private static final byte[] decodeMap = DatatypeConverterImpl.initDecodeMap();
    private static final byte PADDING = 127;
    private static final char[] encodeMap = DatatypeConverterImpl.initEncodeMap();
    private static final DatatypeFactory datatypeFactory;

    protected DatatypeConverterImpl() {
    }

    @Override
    public String parseString(String lexicalXSDString) {
        return lexicalXSDString;
    }

    @Override
    public BigInteger parseInteger(String lexicalXSDInteger) {
        return DatatypeConverterImpl._parseInteger(lexicalXSDInteger);
    }

    public static BigInteger _parseInteger(CharSequence s2) {
        return new BigInteger(DatatypeConverterImpl.removeOptionalPlus(WhiteSpaceProcessor.trim(s2)).toString());
    }

    @Override
    public String printInteger(BigInteger val) {
        return DatatypeConverterImpl._printInteger(val);
    }

    public static String _printInteger(BigInteger val) {
        return val.toString();
    }

    @Override
    public int parseInt(String s2) {
        return DatatypeConverterImpl._parseInt(s2);
    }

    public static int _parseInt(CharSequence s2) {
        int len = s2.length();
        int sign = 1;
        int r2 = 0;
        for (int i2 = 0; i2 < len; ++i2) {
            char ch = s2.charAt(i2);
            if (WhiteSpaceProcessor.isWhiteSpace(ch)) continue;
            if ('0' <= ch && ch <= '9') {
                r2 = r2 * 10 + (ch - 48);
                continue;
            }
            if (ch == '-') {
                sign = -1;
                continue;
            }
            if (ch == '+') continue;
            throw new NumberFormatException("Not a number: " + s2);
        }
        return r2 * sign;
    }

    @Override
    public long parseLong(String lexicalXSLong) {
        return DatatypeConverterImpl._parseLong(lexicalXSLong);
    }

    public static long _parseLong(CharSequence s2) {
        return Long.parseLong(DatatypeConverterImpl.removeOptionalPlus(WhiteSpaceProcessor.trim(s2)).toString());
    }

    @Override
    public short parseShort(String lexicalXSDShort) {
        return DatatypeConverterImpl._parseShort(lexicalXSDShort);
    }

    public static short _parseShort(CharSequence s2) {
        return (short)DatatypeConverterImpl._parseInt(s2);
    }

    @Override
    public String printShort(short val) {
        return DatatypeConverterImpl._printShort(val);
    }

    public static String _printShort(short val) {
        return String.valueOf(val);
    }

    @Override
    public BigDecimal parseDecimal(String content) {
        return DatatypeConverterImpl._parseDecimal(content);
    }

    public static BigDecimal _parseDecimal(CharSequence content) {
        if ((content = WhiteSpaceProcessor.trim(content)).length() <= 0) {
            return null;
        }
        return new BigDecimal(content.toString());
    }

    @Override
    public float parseFloat(String lexicalXSDFloat) {
        return DatatypeConverterImpl._parseFloat(lexicalXSDFloat);
    }

    public static float _parseFloat(CharSequence _val) {
        String s2 = WhiteSpaceProcessor.trim(_val).toString();
        if (s2.equals("NaN")) {
            return Float.NaN;
        }
        if (s2.equals("INF")) {
            return Float.POSITIVE_INFINITY;
        }
        if (s2.equals("-INF")) {
            return Float.NEGATIVE_INFINITY;
        }
        if (s2.length() == 0 || !DatatypeConverterImpl.isDigitOrPeriodOrSign(s2.charAt(0)) || !DatatypeConverterImpl.isDigitOrPeriodOrSign(s2.charAt(s2.length() - 1))) {
            throw new NumberFormatException();
        }
        return Float.parseFloat(s2);
    }

    @Override
    public String printFloat(float v2) {
        return DatatypeConverterImpl._printFloat(v2);
    }

    public static String _printFloat(float v2) {
        if (Float.isNaN(v2)) {
            return "NaN";
        }
        if (v2 == Float.POSITIVE_INFINITY) {
            return "INF";
        }
        if (v2 == Float.NEGATIVE_INFINITY) {
            return "-INF";
        }
        return String.valueOf(v2);
    }

    @Override
    public double parseDouble(String lexicalXSDDouble) {
        return DatatypeConverterImpl._parseDouble(lexicalXSDDouble);
    }

    public static double _parseDouble(CharSequence _val) {
        String val = WhiteSpaceProcessor.trim(_val).toString();
        if (val.equals("NaN")) {
            return Double.NaN;
        }
        if (val.equals("INF")) {
            return Double.POSITIVE_INFINITY;
        }
        if (val.equals("-INF")) {
            return Double.NEGATIVE_INFINITY;
        }
        if (val.length() == 0 || !DatatypeConverterImpl.isDigitOrPeriodOrSign(val.charAt(0)) || !DatatypeConverterImpl.isDigitOrPeriodOrSign(val.charAt(val.length() - 1))) {
            throw new NumberFormatException(val);
        }
        return Double.parseDouble(val);
    }

    @Override
    public boolean parseBoolean(String lexicalXSDBoolean) {
        Boolean b2 = DatatypeConverterImpl._parseBoolean(lexicalXSDBoolean);
        return b2 == null ? false : b2;
    }

    public static Boolean _parseBoolean(CharSequence literal) {
        char ch;
        if (literal == null) {
            return null;
        }
        int i2 = 0;
        int len = literal.length();
        boolean value = false;
        if (literal.length() <= 0) {
            return null;
        }
        while (WhiteSpaceProcessor.isWhiteSpace(ch = literal.charAt(i2++)) && i2 < len) {
        }
        int strIndex = 0;
        switch (ch) {
            case '1': {
                value = true;
                break;
            }
            case '0': {
                value = false;
                break;
            }
            case 't': {
                String strTrue = "rue";
                do {
                    ch = literal.charAt(i2++);
                } while (strTrue.charAt(strIndex++) == ch && i2 < len && strIndex < 3);
                if (strIndex == 3) {
                    value = true;
                    break;
                }
                return false;
            }
            case 'f': {
                String strFalse = "alse";
                do {
                    ch = literal.charAt(i2++);
                } while (strFalse.charAt(strIndex++) == ch && i2 < len && strIndex < 4);
                if (strIndex == 4) {
                    value = false;
                    break;
                }
                return false;
            }
        }
        if (i2 < len) {
            while (WhiteSpaceProcessor.isWhiteSpace(ch = literal.charAt(i2++)) && i2 < len) {
            }
        }
        if (i2 == len) {
            return value;
        }
        return null;
    }

    @Override
    public String printBoolean(boolean val) {
        return val ? "true" : "false";
    }

    public static String _printBoolean(boolean val) {
        return val ? "true" : "false";
    }

    @Override
    public byte parseByte(String lexicalXSDByte) {
        return DatatypeConverterImpl._parseByte(lexicalXSDByte);
    }

    public static byte _parseByte(CharSequence literal) {
        return (byte)DatatypeConverterImpl._parseInt(literal);
    }

    @Override
    public String printByte(byte val) {
        return DatatypeConverterImpl._printByte(val);
    }

    public static String _printByte(byte val) {
        return String.valueOf(val);
    }

    @Override
    public QName parseQName(String lexicalXSDQName, NamespaceContext nsc) {
        return DatatypeConverterImpl._parseQName(lexicalXSDQName, nsc);
    }

    public static QName _parseQName(CharSequence text, NamespaceContext nsc) {
        String prefix;
        String localPart;
        String uri;
        int idx;
        int end;
        int start;
        int length = text.length();
        for (start = 0; start < length && WhiteSpaceProcessor.isWhiteSpace(text.charAt(start)); ++start) {
        }
        for (end = length; end > start && WhiteSpaceProcessor.isWhiteSpace(text.charAt(end - 1)); --end) {
        }
        if (end == start) {
            throw new IllegalArgumentException("input is empty");
        }
        for (idx = start + 1; idx < end && text.charAt(idx) != ':'; ++idx) {
        }
        if (idx == end) {
            uri = nsc.getNamespaceURI("");
            localPart = text.subSequence(start, end).toString();
            prefix = "";
        } else {
            prefix = text.subSequence(start, idx).toString();
            localPart = text.subSequence(idx + 1, end).toString();
            uri = nsc.getNamespaceURI(prefix);
            if (uri == null || uri.length() == 0) {
                throw new IllegalArgumentException("prefix " + prefix + " is not bound to a namespace");
            }
        }
        return new QName(uri, localPart, prefix);
    }

    @Override
    public Calendar parseDateTime(String lexicalXSDDateTime) {
        return DatatypeConverterImpl._parseDateTime(lexicalXSDDateTime);
    }

    public static GregorianCalendar _parseDateTime(CharSequence s2) {
        String val = WhiteSpaceProcessor.trim(s2).toString();
        return datatypeFactory.newXMLGregorianCalendar(val).toGregorianCalendar();
    }

    @Override
    public String printDateTime(Calendar val) {
        return DatatypeConverterImpl._printDateTime(val);
    }

    public static String _printDateTime(Calendar val) {
        return CalendarFormatter.doFormat("%Y-%M-%DT%h:%m:%s%z", val);
    }

    @Override
    public byte[] parseBase64Binary(String lexicalXSDBase64Binary) {
        return DatatypeConverterImpl._parseBase64Binary(lexicalXSDBase64Binary);
    }

    @Override
    public byte[] parseHexBinary(String s2) {
        int len = s2.length();
        if (len % 2 != 0) {
            throw new IllegalArgumentException("hexBinary needs to be even-length: " + s2);
        }
        byte[] out = new byte[len / 2];
        for (int i2 = 0; i2 < len; i2 += 2) {
            int h2 = DatatypeConverterImpl.hexToBin(s2.charAt(i2));
            int l2 = DatatypeConverterImpl.hexToBin(s2.charAt(i2 + 1));
            if (h2 == -1 || l2 == -1) {
                throw new IllegalArgumentException("contains illegal character for hexBinary: " + s2);
            }
            out[i2 / 2] = (byte)(h2 * 16 + l2);
        }
        return out;
    }

    private static int hexToBin(char ch) {
        if ('0' <= ch && ch <= '9') {
            return ch - 48;
        }
        if ('A' <= ch && ch <= 'F') {
            return ch - 65 + 10;
        }
        if ('a' <= ch && ch <= 'f') {
            return ch - 97 + 10;
        }
        return -1;
    }

    @Override
    public String printHexBinary(byte[] data) {
        StringBuilder r2 = new StringBuilder(data.length * 2);
        for (byte b2 : data) {
            r2.append(hexCode[b2 >> 4 & 0xF]);
            r2.append(hexCode[b2 & 0xF]);
        }
        return r2.toString();
    }

    @Override
    public long parseUnsignedInt(String lexicalXSDUnsignedInt) {
        return DatatypeConverterImpl._parseLong(lexicalXSDUnsignedInt);
    }

    @Override
    public String printUnsignedInt(long val) {
        return DatatypeConverterImpl._printLong(val);
    }

    @Override
    public int parseUnsignedShort(String lexicalXSDUnsignedShort) {
        return DatatypeConverterImpl._parseInt(lexicalXSDUnsignedShort);
    }

    @Override
    public Calendar parseTime(String lexicalXSDTime) {
        return datatypeFactory.newXMLGregorianCalendar(lexicalXSDTime).toGregorianCalendar();
    }

    @Override
    public String printTime(Calendar val) {
        return CalendarFormatter.doFormat("%h:%m:%s%z", val);
    }

    @Override
    public Calendar parseDate(String lexicalXSDDate) {
        return datatypeFactory.newXMLGregorianCalendar(lexicalXSDDate).toGregorianCalendar();
    }

    @Override
    public String printDate(Calendar val) {
        return DatatypeConverterImpl._printDate(val);
    }

    public static String _printDate(Calendar val) {
        return CalendarFormatter.doFormat("%Y-%M-%D" + "%z", val);
    }

    @Override
    public String parseAnySimpleType(String lexicalXSDAnySimpleType) {
        return lexicalXSDAnySimpleType;
    }

    @Override
    public String printString(String val) {
        return val;
    }

    @Override
    public String printInt(int val) {
        return DatatypeConverterImpl._printInt(val);
    }

    public static String _printInt(int val) {
        return String.valueOf(val);
    }

    @Override
    public String printLong(long val) {
        return DatatypeConverterImpl._printLong(val);
    }

    public static String _printLong(long val) {
        return String.valueOf(val);
    }

    @Override
    public String printDecimal(BigDecimal val) {
        return DatatypeConverterImpl._printDecimal(val);
    }

    public static String _printDecimal(BigDecimal val) {
        return val.toPlainString();
    }

    @Override
    public String printDouble(double v2) {
        return DatatypeConverterImpl._printDouble(v2);
    }

    public static String _printDouble(double v2) {
        if (Double.isNaN(v2)) {
            return "NaN";
        }
        if (v2 == Double.POSITIVE_INFINITY) {
            return "INF";
        }
        if (v2 == Double.NEGATIVE_INFINITY) {
            return "-INF";
        }
        return String.valueOf(v2);
    }

    @Override
    public String printQName(QName val, NamespaceContext nsc) {
        return DatatypeConverterImpl._printQName(val, nsc);
    }

    public static String _printQName(QName val, NamespaceContext nsc) {
        String prefix = nsc.getPrefix(val.getNamespaceURI());
        String localPart = val.getLocalPart();
        String qname = prefix == null || prefix.length() == 0 ? localPart : prefix + ':' + localPart;
        return qname;
    }

    @Override
    public String printBase64Binary(byte[] val) {
        return DatatypeConverterImpl._printBase64Binary(val);
    }

    @Override
    public String printUnsignedShort(int val) {
        return String.valueOf(val);
    }

    @Override
    public String printAnySimpleType(String val) {
        return val;
    }

    public static String installHook(String s2) {
        DatatypeConverter.setDatatypeConverter(theInstance);
        return s2;
    }

    private static byte[] initDecodeMap() {
        int i2;
        byte[] map = new byte[128];
        for (i2 = 0; i2 < 128; ++i2) {
            map[i2] = -1;
        }
        for (i2 = 65; i2 <= 90; ++i2) {
            map[i2] = (byte)(i2 - 65);
        }
        for (i2 = 97; i2 <= 122; ++i2) {
            map[i2] = (byte)(i2 - 97 + 26);
        }
        for (i2 = 48; i2 <= 57; ++i2) {
            map[i2] = (byte)(i2 - 48 + 52);
        }
        map[43] = 62;
        map[47] = 63;
        map[61] = 127;
        return map;
    }

    private static int guessLength(String text) {
        int padSize;
        int j2;
        int len = text.length();
        for (j2 = len - 1; j2 >= 0; --j2) {
            byte code = decodeMap[text.charAt(j2)];
            if (code == 127) continue;
            if (code != -1) break;
            return text.length() / 4 * 3;
        }
        if ((padSize = len - ++j2) > 2) {
            return text.length() / 4 * 3;
        }
        return text.length() / 4 * 3 - padSize;
    }

    public static byte[] _parseBase64Binary(String text) {
        int buflen = DatatypeConverterImpl.guessLength(text);
        byte[] out = new byte[buflen];
        int o2 = 0;
        int len = text.length();
        byte[] quadruplet = new byte[4];
        int q2 = 0;
        for (int i2 = 0; i2 < len; ++i2) {
            char ch = text.charAt(i2);
            byte v2 = decodeMap[ch];
            if (v2 != -1) {
                quadruplet[q2++] = v2;
            }
            if (q2 != 4) continue;
            out[o2++] = (byte)(quadruplet[0] << 2 | quadruplet[1] >> 4);
            if (quadruplet[2] != 127) {
                out[o2++] = (byte)(quadruplet[1] << 4 | quadruplet[2] >> 2);
            }
            if (quadruplet[3] != 127) {
                out[o2++] = (byte)(quadruplet[2] << 6 | quadruplet[3]);
            }
            q2 = 0;
        }
        if (buflen == o2) {
            return out;
        }
        byte[] nb = new byte[o2];
        System.arraycopy(out, 0, nb, 0, o2);
        return nb;
    }

    private static char[] initEncodeMap() {
        int i2;
        char[] map = new char[64];
        for (i2 = 0; i2 < 26; ++i2) {
            map[i2] = (char)(65 + i2);
        }
        for (i2 = 26; i2 < 52; ++i2) {
            map[i2] = (char)(97 + (i2 - 26));
        }
        for (i2 = 52; i2 < 62; ++i2) {
            map[i2] = (char)(48 + (i2 - 52));
        }
        map[62] = 43;
        map[63] = 47;
        return map;
    }

    public static char encode(int i2) {
        return encodeMap[i2 & 0x3F];
    }

    public static byte encodeByte(int i2) {
        return (byte)encodeMap[i2 & 0x3F];
    }

    public static String _printBase64Binary(byte[] input) {
        return DatatypeConverterImpl._printBase64Binary(input, 0, input.length);
    }

    public static String _printBase64Binary(byte[] input, int offset, int len) {
        char[] buf = new char[(len + 2) / 3 * 4];
        int ptr = DatatypeConverterImpl._printBase64Binary(input, offset, len, buf, 0);
        assert (ptr == buf.length);
        return new String(buf);
    }

    public static int _printBase64Binary(byte[] input, int offset, int len, char[] buf, int ptr) {
        int remaining = len;
        int i2 = offset;
        while (remaining >= 3) {
            buf[ptr++] = DatatypeConverterImpl.encode(input[i2] >> 2);
            buf[ptr++] = DatatypeConverterImpl.encode((input[i2] & 3) << 4 | input[i2 + 1] >> 4 & 0xF);
            buf[ptr++] = DatatypeConverterImpl.encode((input[i2 + 1] & 0xF) << 2 | input[i2 + 2] >> 6 & 3);
            buf[ptr++] = DatatypeConverterImpl.encode(input[i2 + 2] & 0x3F);
            remaining -= 3;
            i2 += 3;
        }
        if (remaining == 1) {
            buf[ptr++] = DatatypeConverterImpl.encode(input[i2] >> 2);
            buf[ptr++] = DatatypeConverterImpl.encode((input[i2] & 3) << 4);
            buf[ptr++] = 61;
            buf[ptr++] = 61;
        }
        if (remaining == 2) {
            buf[ptr++] = DatatypeConverterImpl.encode(input[i2] >> 2);
            buf[ptr++] = DatatypeConverterImpl.encode((input[i2] & 3) << 4 | input[i2 + 1] >> 4 & 0xF);
            buf[ptr++] = DatatypeConverterImpl.encode((input[i2 + 1] & 0xF) << 2);
            buf[ptr++] = 61;
        }
        return ptr;
    }

    public static int _printBase64Binary(byte[] input, int offset, int len, byte[] out, int ptr) {
        byte[] buf = out;
        int remaining = len;
        int i2 = offset;
        while (remaining >= 3) {
            buf[ptr++] = DatatypeConverterImpl.encodeByte(input[i2] >> 2);
            buf[ptr++] = DatatypeConverterImpl.encodeByte((input[i2] & 3) << 4 | input[i2 + 1] >> 4 & 0xF);
            buf[ptr++] = DatatypeConverterImpl.encodeByte((input[i2 + 1] & 0xF) << 2 | input[i2 + 2] >> 6 & 3);
            buf[ptr++] = DatatypeConverterImpl.encodeByte(input[i2 + 2] & 0x3F);
            remaining -= 3;
            i2 += 3;
        }
        if (remaining == 1) {
            buf[ptr++] = DatatypeConverterImpl.encodeByte(input[i2] >> 2);
            buf[ptr++] = DatatypeConverterImpl.encodeByte((input[i2] & 3) << 4);
            buf[ptr++] = 61;
            buf[ptr++] = 61;
        }
        if (remaining == 2) {
            buf[ptr++] = DatatypeConverterImpl.encodeByte(input[i2] >> 2);
            buf[ptr++] = DatatypeConverterImpl.encodeByte((input[i2] & 3) << 4 | input[i2 + 1] >> 4 & 0xF);
            buf[ptr++] = DatatypeConverterImpl.encodeByte((input[i2 + 1] & 0xF) << 2);
            buf[ptr++] = 61;
        }
        return ptr;
    }

    private static CharSequence removeOptionalPlus(CharSequence s2) {
        int len = s2.length();
        if (len <= 1 || s2.charAt(0) != '+') {
            return s2;
        }
        char ch = (s2 = s2.subSequence(1, len)).charAt(0);
        if ('0' <= ch && ch <= '9') {
            return s2;
        }
        if ('.' == ch) {
            return s2;
        }
        throw new NumberFormatException();
    }

    private static boolean isDigitOrPeriodOrSign(char ch) {
        if ('0' <= ch && ch <= '9') {
            return true;
        }
        return ch == '+' || ch == '-' || ch == '.';
    }

    static {
        try {
            datatypeFactory = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException e2) {
            throw new Error(e2);
        }
    }

    private static final class CalendarFormatter {
        private CalendarFormatter() {
        }

        public static String doFormat(String format, Calendar cal) throws IllegalArgumentException {
            int fidx = 0;
            int flen = format.length();
            StringBuilder buf = new StringBuilder();
            block9: while (fidx < flen) {
                char fch;
                if ((fch = format.charAt(fidx++)) != '%') {
                    buf.append(fch);
                    continue;
                }
                switch (format.charAt(fidx++)) {
                    case 'Y': {
                        CalendarFormatter.formatYear(cal, buf);
                        continue block9;
                    }
                    case 'M': {
                        CalendarFormatter.formatMonth(cal, buf);
                        continue block9;
                    }
                    case 'D': {
                        CalendarFormatter.formatDays(cal, buf);
                        continue block9;
                    }
                    case 'h': {
                        CalendarFormatter.formatHours(cal, buf);
                        continue block9;
                    }
                    case 'm': {
                        CalendarFormatter.formatMinutes(cal, buf);
                        continue block9;
                    }
                    case 's': {
                        CalendarFormatter.formatSeconds(cal, buf);
                        continue block9;
                    }
                    case 'z': {
                        CalendarFormatter.formatTimeZone(cal, buf);
                        continue block9;
                    }
                }
                throw new InternalError();
            }
            return buf.toString();
        }

        private static void formatYear(Calendar cal, StringBuilder buf) {
            int year = cal.get(1);
            String s2 = year <= 0 ? Integer.toString(1 - year) : Integer.toString(year);
            while (s2.length() < 4) {
                s2 = '0' + s2;
            }
            if (year <= 0) {
                s2 = '-' + s2;
            }
            buf.append(s2);
        }

        private static void formatMonth(Calendar cal, StringBuilder buf) {
            CalendarFormatter.formatTwoDigits(cal.get(2) + 1, buf);
        }

        private static void formatDays(Calendar cal, StringBuilder buf) {
            CalendarFormatter.formatTwoDigits(cal.get(5), buf);
        }

        private static void formatHours(Calendar cal, StringBuilder buf) {
            CalendarFormatter.formatTwoDigits(cal.get(11), buf);
        }

        private static void formatMinutes(Calendar cal, StringBuilder buf) {
            CalendarFormatter.formatTwoDigits(cal.get(12), buf);
        }

        private static void formatSeconds(Calendar cal, StringBuilder buf) {
            int n2;
            CalendarFormatter.formatTwoDigits(cal.get(13), buf);
            if (cal.isSet(14) && (n2 = cal.get(14)) != 0) {
                String ms = Integer.toString(n2);
                while (ms.length() < 3) {
                    ms = '0' + ms;
                }
                buf.append('.');
                buf.append(ms);
            }
        }

        private static void formatTimeZone(Calendar cal, StringBuilder buf) {
            TimeZone tz = cal.getTimeZone();
            if (tz == null) {
                return;
            }
            int offset = tz.getOffset(cal.getTime().getTime());
            if (offset == 0) {
                buf.append('Z');
                return;
            }
            if (offset >= 0) {
                buf.append('+');
            } else {
                buf.append('-');
                offset *= -1;
            }
            CalendarFormatter.formatTwoDigits((offset /= 60000) / 60, buf);
            buf.append(':');
            CalendarFormatter.formatTwoDigits(offset % 60, buf);
        }

        private static void formatTwoDigits(int n2, StringBuilder buf) {
            if (n2 < 10) {
                buf.append('0');
            }
            buf.append(n2);
        }
    }
}

