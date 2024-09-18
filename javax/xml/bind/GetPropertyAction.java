/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javax.xml.bind;

import java.security.PrivilegedAction;

final class GetPropertyAction
implements PrivilegedAction<String> {
    private final String propertyName;

    public GetPropertyAction(String propertyName) {
        this.propertyName = propertyName;
    }

    @Override
    public String run() {
        return System.getProperty(this.propertyName);
    }
}

