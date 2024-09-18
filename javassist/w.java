/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import javassist.V;
import javassist.X;
import javassist.d;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class W
implements d {
    V[] a;

    W(String string) {
        File[] fileArray = new File(string).listFiles(new X(this));
        if (fileArray != null) {
            this.a = new V[fileArray.length];
            for (int i2 = 0; i2 < fileArray.length; ++i2) {
                this.a[i2] = new V(fileArray[i2].getPath());
            }
        }
    }

    @Override
    public InputStream a(String string) {
        if (this.a != null) {
            for (int i2 = 0; i2 < this.a.length; ++i2) {
                InputStream inputStream = this.a[i2].a(string);
                if (inputStream == null) continue;
                return inputStream;
            }
        }
        return null;
    }

    @Override
    public URL a(String string) {
        if (this.a != null) {
            for (int i2 = 0; i2 < this.a.length; ++i2) {
                URL uRL = this.a[i2].a(string);
                if (uRL == null) continue;
                return uRL;
            }
        }
        return null;
    }
}

