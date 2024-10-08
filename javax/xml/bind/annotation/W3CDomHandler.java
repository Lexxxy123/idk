/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javax.xml.bind.annotation;

import javax.xml.bind.ValidationEventHandler;
import javax.xml.bind.annotation.DomHandler;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class W3CDomHandler
implements DomHandler<Element, DOMResult> {
    private DocumentBuilder builder;

    public W3CDomHandler() {
        this.builder = null;
    }

    public W3CDomHandler(DocumentBuilder builder) {
        if (builder == null) {
            throw new IllegalArgumentException();
        }
        this.builder = builder;
    }

    public DocumentBuilder getBuilder() {
        return this.builder;
    }

    public void setBuilder(DocumentBuilder builder) {
        this.builder = builder;
    }

    @Override
    public DOMResult createUnmarshaller(ValidationEventHandler errorHandler) {
        if (this.builder == null) {
            return new DOMResult();
        }
        return new DOMResult(this.builder.newDocument());
    }

    @Override
    public Element getElement(DOMResult r2) {
        Node n2 = r2.getNode();
        if (n2 instanceof Document) {
            return ((Document)n2).getDocumentElement();
        }
        if (n2 instanceof Element) {
            return (Element)n2;
        }
        if (n2 instanceof DocumentFragment) {
            return (Element)n2.getChildNodes().item(0);
        }
        throw new IllegalStateException(n2.toString());
    }

    @Override
    public Source marshal(Element element, ValidationEventHandler errorHandler) {
        return new DOMSource(element);
    }
}

