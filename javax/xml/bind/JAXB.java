/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javax.xml.bind;

import java.beans.Introspector;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import javax.xml.bind.DataBindingException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.namespace.QName;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public final class JAXB {
    private static volatile WeakReference<Cache> cache;

    private JAXB() {
    }

    private static <T> JAXBContext getContext(Class<T> type) throws JAXBException {
        Cache d2;
        WeakReference<Cache> c2 = cache;
        if (c2 != null && (d2 = (Cache)c2.get()) != null && d2.type == type) {
            return d2.context;
        }
        d2 = new Cache(type);
        cache = new WeakReference<Cache>(d2);
        return d2.context;
    }

    public static <T> T unmarshal(File xml, Class<T> type) {
        try {
            JAXBElement<T> item = JAXB.getContext(type).createUnmarshaller().unmarshal(new StreamSource(xml), type);
            return item.getValue();
        } catch (JAXBException e2) {
            throw new DataBindingException(e2);
        }
    }

    public static <T> T unmarshal(URL xml, Class<T> type) {
        try {
            JAXBElement<T> item = JAXB.getContext(type).createUnmarshaller().unmarshal(JAXB.toSource(xml), type);
            return item.getValue();
        } catch (JAXBException e2) {
            throw new DataBindingException(e2);
        } catch (IOException e3) {
            throw new DataBindingException(e3);
        }
    }

    public static <T> T unmarshal(URI xml, Class<T> type) {
        try {
            JAXBElement<T> item = JAXB.getContext(type).createUnmarshaller().unmarshal(JAXB.toSource(xml), type);
            return item.getValue();
        } catch (JAXBException e2) {
            throw new DataBindingException(e2);
        } catch (IOException e3) {
            throw new DataBindingException(e3);
        }
    }

    public static <T> T unmarshal(String xml, Class<T> type) {
        try {
            JAXBElement<T> item = JAXB.getContext(type).createUnmarshaller().unmarshal(JAXB.toSource(xml), type);
            return item.getValue();
        } catch (JAXBException e2) {
            throw new DataBindingException(e2);
        } catch (IOException e3) {
            throw new DataBindingException(e3);
        }
    }

    public static <T> T unmarshal(InputStream xml, Class<T> type) {
        try {
            JAXBElement<T> item = JAXB.getContext(type).createUnmarshaller().unmarshal(JAXB.toSource(xml), type);
            return item.getValue();
        } catch (JAXBException e2) {
            throw new DataBindingException(e2);
        } catch (IOException e3) {
            throw new DataBindingException(e3);
        }
    }

    public static <T> T unmarshal(Reader xml, Class<T> type) {
        try {
            JAXBElement<T> item = JAXB.getContext(type).createUnmarshaller().unmarshal(JAXB.toSource(xml), type);
            return item.getValue();
        } catch (JAXBException e2) {
            throw new DataBindingException(e2);
        } catch (IOException e3) {
            throw new DataBindingException(e3);
        }
    }

    public static <T> T unmarshal(Source xml, Class<T> type) {
        try {
            JAXBElement<T> item = JAXB.getContext(type).createUnmarshaller().unmarshal(JAXB.toSource(xml), type);
            return item.getValue();
        } catch (JAXBException e2) {
            throw new DataBindingException(e2);
        } catch (IOException e3) {
            throw new DataBindingException(e3);
        }
    }

    private static Source toSource(Object xml) throws IOException {
        if (xml == null) {
            throw new IllegalArgumentException("no XML is given");
        }
        if (xml instanceof String) {
            try {
                xml = new URI((String)xml);
            } catch (URISyntaxException e2) {
                xml = new File((String)xml);
            }
        }
        if (xml instanceof File) {
            File file = (File)xml;
            return new StreamSource(file);
        }
        if (xml instanceof URI) {
            URI uri = (URI)xml;
            xml = uri.toURL();
        }
        if (xml instanceof URL) {
            URL url = (URL)xml;
            return new StreamSource(url.toExternalForm());
        }
        if (xml instanceof InputStream) {
            InputStream in = (InputStream)xml;
            return new StreamSource(in);
        }
        if (xml instanceof Reader) {
            Reader r2 = (Reader)xml;
            return new StreamSource(r2);
        }
        if (xml instanceof Source) {
            return (Source)xml;
        }
        throw new IllegalArgumentException("I don't understand how to handle " + xml.getClass());
    }

    public static void marshal(Object jaxbObject, File xml) {
        JAXB._marshal(jaxbObject, xml);
    }

    public static void marshal(Object jaxbObject, URL xml) {
        JAXB._marshal(jaxbObject, xml);
    }

    public static void marshal(Object jaxbObject, URI xml) {
        JAXB._marshal(jaxbObject, xml);
    }

    public static void marshal(Object jaxbObject, String xml) {
        JAXB._marshal(jaxbObject, xml);
    }

    public static void marshal(Object jaxbObject, OutputStream xml) {
        JAXB._marshal(jaxbObject, xml);
    }

    public static void marshal(Object jaxbObject, Writer xml) {
        JAXB._marshal(jaxbObject, xml);
    }

    public static void marshal(Object jaxbObject, Result xml) {
        JAXB._marshal(jaxbObject, xml);
    }

    private static void _marshal(Object jaxbObject, Object xml) {
        try {
            JAXBContext context;
            if (jaxbObject instanceof JAXBElement) {
                context = JAXB.getContext(((JAXBElement)jaxbObject).getDeclaredType());
            } else {
                Class<?> clazz = jaxbObject.getClass();
                XmlRootElement r2 = clazz.getAnnotation(XmlRootElement.class);
                context = JAXB.getContext(clazz);
                if (r2 == null) {
                    jaxbObject = new JAXBElement<Object>(new QName(JAXB.inferName(clazz)), clazz, jaxbObject);
                }
            }
            Marshaller m2 = context.createMarshaller();
            m2.setProperty("jaxb.formatted.output", true);
            m2.marshal((Object)jaxbObject, JAXB.toResult(xml));
        } catch (JAXBException e2) {
            throw new DataBindingException(e2);
        } catch (IOException e3) {
            throw new DataBindingException(e3);
        }
    }

    private static String inferName(Class clazz) {
        return Introspector.decapitalize(clazz.getSimpleName());
    }

    private static Result toResult(Object xml) throws IOException {
        if (xml == null) {
            throw new IllegalArgumentException("no XML is given");
        }
        if (xml instanceof String) {
            try {
                xml = new URI((String)xml);
            } catch (URISyntaxException e2) {
                xml = new File((String)xml);
            }
        }
        if (xml instanceof File) {
            File file = (File)xml;
            return new StreamResult(file);
        }
        if (xml instanceof URI) {
            URI uri = (URI)xml;
            xml = uri.toURL();
        }
        if (xml instanceof URL) {
            URL url = (URL)xml;
            URLConnection con = url.openConnection();
            con.setDoOutput(true);
            con.setDoInput(false);
            con.connect();
            return new StreamResult(con.getOutputStream());
        }
        if (xml instanceof OutputStream) {
            OutputStream os = (OutputStream)xml;
            return new StreamResult(os);
        }
        if (xml instanceof Writer) {
            Writer w2 = (Writer)xml;
            return new StreamResult(w2);
        }
        if (xml instanceof Result) {
            return (Result)xml;
        }
        throw new IllegalArgumentException("I don't understand how to handle " + xml.getClass());
    }

    private static final class Cache {
        final Class type;
        final JAXBContext context;

        public Cache(Class type) throws JAXBException {
            this.type = type;
            this.context = JAXBContext.newInstance(type);
        }
    }
}

