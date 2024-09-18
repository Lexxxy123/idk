/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javax.xml.bind;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

public abstract class JAXBIntrospector {
    public abstract boolean isElement(Object var1);

    public abstract QName getElementName(Object var1);

    public static Object getValue(Object jaxbElement) {
        if (jaxbElement instanceof JAXBElement) {
            return ((JAXBElement)jaxbElement).getValue();
        }
        return jaxbElement;
    }
}

