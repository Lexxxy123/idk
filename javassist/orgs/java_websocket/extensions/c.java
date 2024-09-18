/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.java_websocket.extensions;

import java.util.LinkedHashMap;
import java.util.Map;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class c {
    public static String a = "";
    private Map<String, String> a = new LinkedHashMap();
    private String b;

    private c() {
    }

    public static c a(String string) {
        c c2 = new c();
        String[] stringArray = string.split(";");
        c2.b = stringArray[0].trim();
        int n2 = 1;
        while (n2 < stringArray.length) {
            String[] stringArray2 = stringArray[n2].split("=");
            String string2 = a;
            if (stringArray2.length > 1) {
                String string3 = stringArray2[1].trim();
                if (string3.startsWith("\"") && string3.endsWith("\"") || string3.startsWith("'") && string3.endsWith("'") && string3.length() > 2) {
                    string3 = string3.substring(1, string3.length() - 1);
                }
                string2 = string3;
            }
            c2.a.put(stringArray2[0].trim(), string2);
            ++n2;
        }
        return c2;
    }

    public String a() {
        return this.b;
    }

    public Map<String, String> a() {
        return this.a;
    }
}

