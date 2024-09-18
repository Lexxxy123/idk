/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javax.xml.bind;

import java.net.URL;
import org.w3c.dom.Node;

public interface ValidationEventLocator {
    public URL getURL();

    public int getOffset();

    public int getLineNumber();

    public int getColumnNumber();

    public Object getObject();

    public Node getNode();
}

