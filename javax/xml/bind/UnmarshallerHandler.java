/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javax.xml.bind;

import javax.xml.bind.JAXBException;
import org.xml.sax.ContentHandler;

public interface UnmarshallerHandler
extends ContentHandler {
    public Object getResult() throws JAXBException, IllegalStateException;
}

