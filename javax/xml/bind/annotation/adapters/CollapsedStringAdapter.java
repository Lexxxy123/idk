/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javax.xml.bind.annotation.adapters;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class CollapsedStringAdapter
extends XmlAdapter<String, String> {
    @Override
    public String unmarshal(String text) {
        int s2;
        if (text == null) {
            return null;
        }
        int len = text.length();
        for (s2 = 0; s2 < len && !CollapsedStringAdapter.isWhiteSpace(text.charAt(s2)); ++s2) {
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
            boolean b2 = CollapsedStringAdapter.isWhiteSpace(ch);
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
        return result.toString();
    }

    @Override
    public String marshal(String s2) {
        return s2;
    }

    protected static boolean isWhiteSpace(char ch) {
        if (ch > ' ') {
            return false;
        }
        return ch == '\t' || ch == '\n' || ch == '\r' || ch == ' ';
    }
}

