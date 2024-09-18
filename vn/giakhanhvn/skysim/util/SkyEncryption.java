/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package vn.giakhanhvn.skysim.util;

import java.security.spec.KeySpec;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

public class SkyEncryption {
    private static final String UNICODE_FORMAT = "UTF8";
    public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
    private KeySpec ks;
    private SecretKeyFactory skf;
    private Cipher cipher;
    byte[] arrayBytes;
    private final String myEncryptionKey = "ThisIsSpartaThisIsSparta";
    SecretKey key;

    public SkyEncryption() throws Exception {
        this.arrayBytes = this.myEncryptionKey.getBytes(UNICODE_FORMAT);
        this.myEncryptionKey = "ThisIsSpartaThisIsSparta";
        this.ks = new DESedeKeySpec(this.arrayBytes);
        String myEncryptionScheme = DESEDE_ENCRYPTION_SCHEME;
        this.skf = SecretKeyFactory.getInstance(myEncryptionScheme);
        this.cipher = Cipher.getInstance(myEncryptionScheme);
        this.key = this.skf.generateSecret(this.ks);
    }

    public String encrypt(String unencryptedString) {
        String encryptedString = null;
        try {
            this.cipher.init(1, this.key);
            byte[] plainText = unencryptedString.getBytes(UNICODE_FORMAT);
            byte[] encryptedText = this.cipher.doFinal(plainText);
            encryptedString = new String(Base64.getEncoder().encode(encryptedText));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return encryptedString;
    }

    public String decrypt(String encryptedString) {
        String decryptedText = null;
        try {
            this.cipher.init(2, this.key);
            byte[] encryptedText = Base64.getDecoder().decode(encryptedString);
            byte[] plainText = this.cipher.doFinal(encryptedText);
            decryptedText = new String(plainText);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return decryptedText;
    }
}

