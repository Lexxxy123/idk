/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javax.xml.bind;

abstract class WhiteSpaceProcessor {
    WhiteSpaceProcessor() {
    }

    public static String replace(String text) {
        return WhiteSpaceProcessor.replace((CharSequence)text).toString();
    }

    public static CharSequence replace(CharSequence text) {
        int i2;
        for (i2 = text.length() - 1; i2 >= 0 && !WhiteSpaceProcessor.isWhiteSpaceExceptSpace(text.charAt(i2)); --i2) {
        }
        if (i2 < 0) {
            return text;
        }
        StringBuilder buf = new StringBuilder(text);
        buf.setCharAt(i2--, ' ');
        while (i2 >= 0) {
            if (WhiteSpaceProcessor.isWhiteSpaceExceptSpace(buf.charAt(i2))) {
                buf.setCharAt(i2, ' ');
            }
            --i2;
        }
        return new String(buf);
    }

    public static CharSequence trim(CharSequence text) {
        int end;
        int start;
        int len = text.length();
        for (start = 0; start < len && WhiteSpaceProcessor.isWhiteSpace(text.charAt(start)); ++start) {
        }
        for (end = len - 1; end > start && WhiteSpaceProcessor.isWhiteSpace(text.charAt(end)); --end) {
        }
        if (start == 0 && end == len - 1) {
            return text;
        }
        return text.subSequence(start, end + 1);
    }

    public static String collapse(String text) {
        return WhiteSpaceProcessor.collapse((CharSequence)text).toString();
    }

    public static CharSequence collapse(CharSequence text) {
        int s2;
        int len = text.length();
        for (s2 = 0; s2 < len && !WhiteSpaceProcessor.isWhiteSpace(text.charAt(s2)); ++s2) {
        }
        if (s2 == len) {
            return text;
        }
        StringBuilder result = new StringBuilder(len);
        if (s2 != 0) {
            for (int i2 = 0; i2 < s2; ++i2) {
                result.append(text.charAt(i2));
            }
            result.append(' ');
        }
        boolean inStripMode = true;
        for (int i3 = s2 + 1; i3 < len; ++i3) {
            char ch = text.charAt(i3);
            boolean b2 = WhiteSpaceProcessor.isWhiteSpace(ch);
            if (inStripMode && b2) continue;
            inStripMode = b2;
            if (inStripMode) {
                result.append(' ');
                continue;
            }
            result.append(ch);
        }
        len = result.length();
        if (len > 0 && result.charAt(len - 1) == ' ') {
            result.setLength(len - 1);
        }
        return result;
    }

    public static final boolean isWhiteSpace(CharSequence s2) {
        for (int i2 = s2.length() - 1; i2 >= 0; --i2) {
            if (WhiteSpaceProcessor.isWhiteSpace(s2.charAt(i2))) continue;
            return false;
        }
        return true;
    }

    public static final boolean isWhiteSpace(char ch) {
        if (ch > ' ') {
            return false;
        }
        return ch == '\t' || ch == '\n' || ch == '\r' || ch == ' ';
    }

    protected static final boolean isWhiteSpaceExceptSpace(char ch) {
        if (ch >= ' ') {
            return false;
        }
        return ch == '\t' || ch == '\n' || ch == '\r';
    }
}

