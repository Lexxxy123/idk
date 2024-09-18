/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javax.xml.bind.attachment;

import javax.activation.DataHandler;

public abstract class AttachmentUnmarshaller {
    public abstract DataHandler getAttachmentAsDataHandler(String var1);

    public abstract byte[] getAttachmentAsByteArray(String var1);

    public boolean isXOPPackage() {
        return false;
    }
}

