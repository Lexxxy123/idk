/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javax.xml.bind.annotation.adapters;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public final class NormalizedStringAdapter
extends XmlAdapter<String, String> {
    @Override
    public String unmarshal(String text) {
        int i2;
        if (text == null) {
            return null;
        }
        for (i2 = text.length() - 1; i2 >= 0 && !NormalizedStringAdapter.isWhiteSpaceExceptSpace(text.charAt(i2)); --i2) {
        }
        if (i2 < 0) {
            return text;
        }
        char[] buf = text.toCharArray();
        buf[i2--] = 32;
        while (i2 >= 0) {
            if (NormalizedStringAdapter.isWhiteSpaceExceptSpace(buf[i2])) {
                buf[i2] = 32;
            }
            --i2;
        }
        return new String(buf);
    }

    @Override
    public String marshal(String s2) {
        return s2;
    }

    protected static boolean isWhiteSpaceExceptSpace(char ch) {
        if (ch >= ' ') {
            return false;
        }
        return ch == '\t' || ch == '\n' || ch == '\r';
    }
}

