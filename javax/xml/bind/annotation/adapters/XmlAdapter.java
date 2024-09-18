/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javax.xml.bind.annotation.adapters;

public abstract class XmlAdapter<ValueType, BoundType> {
    protected XmlAdapter() {
    }

    public abstract BoundType unmarshal(ValueType var1) throws Exception;

    public abstract ValueType marshal(BoundType var1) throws Exception;
}

