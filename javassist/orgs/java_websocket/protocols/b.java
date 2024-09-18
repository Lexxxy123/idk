/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.java_websocket.protocols;

import java.util.regex.Pattern;
import javassist.orgs.java_websocket.protocols.a;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class b
implements a {
    private static final Pattern a = Pattern.compile(" ");
    private static final Pattern b = Pattern.compile(",");
    private final String a;

    public b(String string) {
        if (string == null) {
            throw new IllegalArgumentException();
        }
        this.a = string;
    }

    @Override
    public boolean a(String string) {
        String[] stringArray;
        String string2 = a.matcher(string).replaceAll("");
        String[] stringArray2 = stringArray = b.split(string2);
        int n2 = stringArray.length;
        int n3 = 0;
        while (n3 < n2) {
            String string3 = stringArray2[n3];
            if (this.a.equals(string3)) {
                return true;
            }
            ++n3;
        }
        return false;
    }

    @Override
    public String a() {
        return this.a;
    }

    @Override
    public a a() {
        return new b(this.a());
    }

    @Override
    public String toString() {
        return this.a();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        b b2 = (b)object;
        return this.a.equals(b2.a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}

