/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package vn.giakhanhvn.skysim;

import vn.giakhanhvn.skysim.util.SkyEncryption;

public class ServerVersion {
    private String z;
    private int a;
    private int b;
    private int c;
    private int d;
    private byte[] finalResult;

    public ServerVersion(String stage, int a2, int b2, int c2, int d2) {
        this.a = a2;
        this.b = b2;
        this.c = c2;
        this.d = d2;
        this.z = stage;
        try {
            this.finalResult = new SkyEncryption().encrypt(this.z + "-" + this.a + "." + this.b + "." + this.c + "." + this.d).getBytes();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public String readableString() throws Exception {
        return new SkyEncryption().decrypt(new String(this.finalResult));
    }

    public byte[] getEncryptedByteArray() {
        return this.finalResult;
    }

    public byte[] getDecryptedByteArray() throws Exception {
        return new SkyEncryption().decrypt(new String(this.finalResult)).getBytes();
    }
}

