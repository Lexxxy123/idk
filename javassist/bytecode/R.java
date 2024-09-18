/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javassist.bytecode.J;
import javassist.bytecode.T;
import javassist.bytecode.aL;
import javassist.bytecode.aV;
import javassist.bytecode.at;
import javassist.bytecode.h;
import javassist.bytecode.i;
import javassist.bytecode.q;
import javassist.bytecode.s;
import javassist.bytecode.t;
import javassist.bytecode.u;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class r
extends h
implements at {
    public static final String a = "Code";
    private int b;
    private int c;
    private T a;
    private List<h> a;

    public r(J j2, int n2, int n3, byte[] byArray, T t2) {
        super(j2, a);
        this.b = n2;
        this.c = n3;
        this.a = byArray;
        this.a = t2;
        this.a = new ArrayList();
    }

    private r(J j2, r r2, Map<String, String> map) {
        super(j2, a);
        this.b = r2.a();
        this.c = r2.d();
        this.a = r2.a().a(j2, map);
        this.a = new ArrayList();
        List<h> list = r2.a();
        int n2 = list.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            h h2 = list.get(i2);
            this.a.add(h2.a(j2, map));
        }
        this.a = r2.a(j2, map, this.a, this);
    }

    r(J j2, int n2, DataInputStream dataInputStream) {
        super(j2, n2, (byte[])null);
        int n3 = dataInputStream.readInt();
        this.b = dataInputStream.readUnsignedShort();
        this.c = dataInputStream.readUnsignedShort();
        int n4 = dataInputStream.readInt();
        this.a = new byte[n4];
        dataInputStream.readFully((byte[])this.a);
        this.a = new T(j2, dataInputStream);
        this.a = new ArrayList();
        int n5 = dataInputStream.readUnsignedShort();
        for (int i2 = 0; i2 < n5; ++i2) {
            this.a.add(h.a(j2, dataInputStream));
        }
    }

    @Override
    public h a(J j2, Map<String, String> map) {
        try {
            return new r(j2, this, map);
        } catch (i i2) {
            throw new t("bad bytecode. fatal?");
        }
    }

    @Override
    public int b() {
        return 18 + ((String)this.a).length + this.a.a() * 8 + h.a((List<h>)((Object)this.a));
    }

    @Override
    void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeShort((int)this.a);
        dataOutputStream.writeInt(this.b() - 6);
        dataOutputStream.writeShort(this.b);
        dataOutputStream.writeShort(this.c);
        dataOutputStream.writeInt(((String)this.a).length);
        dataOutputStream.write((byte[])this.a);
        this.a.a(dataOutputStream);
        dataOutputStream.writeShort(this.a.size());
        h.a((List<h>)((Object)this.a), dataOutputStream);
    }

    @Override
    public byte[] a() {
        throw new UnsupportedOperationException("CodeAttribute.get()");
    }

    @Override
    public void a(byte[] byArray) {
        throw new UnsupportedOperationException("CodeAttribute.set()");
    }

    @Override
    void a(String string, String string2) {
        h.a((List<h>)((Object)this.a), string, string2);
    }

    @Override
    void a(Map<String, String> map) {
        h.a((List<h>)((Object)this.a), map);
    }

    @Override
    void b(Map<String, String> map) {
        h.b((List<h>)((Object)this.a), map);
    }

    public String b() {
        J j2 = this.a();
        return j2.a();
    }

    public int a() {
        return this.b;
    }

    public void a(int n2) {
        this.b = n2;
    }

    public int c() {
        this.b = new q(this).a();
        return this.b;
    }

    public int d() {
        return this.c;
    }

    public void b(int n2) {
        this.c = n2;
    }

    public int e() {
        return ((String)this.a).length;
    }

    public byte[] b() {
        return this.a;
    }

    void b(byte[] byArray) {
        super.a(byArray);
    }

    public u a() {
        return new u(this);
    }

    public T a() {
        return this.a;
    }

    public List<h> a() {
        return this.a;
    }

    public h a(String string) {
        return h.a((List<h>)((Object)this.a), string);
    }

    public void a(aV aV2) {
        h.b((List<h>)((Object)this.a), "StackMapTable");
        if (aV2 != null) {
            this.a.add(aV2);
        }
    }

    public void a(aL aL2) {
        h.b((List<h>)((Object)this.a), "StackMap");
        if (aL2 != null) {
            this.a.add(aL2);
        }
    }

    private byte[] a(J j2, Map<String, String> map, T t2, r r2) {
        int n2 = this.e();
        byte[] byArray = new byte[n2];
        r2.a = byArray;
        s s2 = r.a((byte[])this.a, 0, n2, this.a(), byArray, j2, map);
        return s.a(byArray, s2, t2, r2);
    }

    private static s a(byte[] byArray, int n2, int n3, J j2, byte[] byArray2, J j3, Map<String, String> map) {
        s s2 = null;
        int n4 = n2;
        while (n4 < n3) {
            byte by;
            int n5 = u.a(byArray, n4);
            byArray2[n4] = by = byArray[n4];
            switch (by & 0xFF) {
                case 19: 
                case 20: 
                case 178: 
                case 179: 
                case 180: 
                case 181: 
                case 182: 
                case 183: 
                case 184: 
                case 187: 
                case 189: 
                case 192: 
                case 193: {
                    r.a(n4 + 1, byArray, j2, byArray2, j3, map);
                    break;
                }
                case 18: {
                    int n6 = byArray[n4 + 1] & 0xFF;
                    n6 = j2.a(n6, j3, map);
                    if (n6 < 256) {
                        byArray2[n4 + 1] = (byte)n6;
                        break;
                    }
                    byArray2[n4] = 0;
                    byArray2[n4 + 1] = 0;
                    s s3 = new s();
                    s3.a = n4;
                    s3.b = n6;
                    s3.a = s2;
                    s2 = s3;
                    break;
                }
                case 185: {
                    r.a(n4 + 1, byArray, j2, byArray2, j3, map);
                    byArray2[n4 + 3] = byArray[n4 + 3];
                    byArray2[n4 + 4] = byArray[n4 + 4];
                    break;
                }
                case 186: {
                    r.a(n4 + 1, byArray, j2, byArray2, j3, map);
                    byArray2[n4 + 3] = 0;
                    byArray2[n4 + 4] = 0;
                    break;
                }
                case 197: {
                    r.a(n4 + 1, byArray, j2, byArray2, j3, map);
                    byArray2[n4 + 3] = byArray[n4 + 3];
                    break;
                }
                default: {
                    while (++n4 < n5) {
                        byArray2[n4] = byArray[n4];
                    }
                    break block0;
                }
            }
            n4 = n5;
        }
        return s2;
    }

    private static void a(int n2, byte[] byArray, J j2, byte[] byArray2, J j3, Map<String, String> map) {
        int n3 = (byArray[n2] & 0xFF) << 8 | byArray[n2 + 1] & 0xFF;
        n3 = j2.a(n3, j3, map);
        byArray2[n2] = (byte)(n3 >> 8);
        byArray2[n2 + 1] = (byte)n3;
    }

    public void a(int n2, int n3) {
        u u2 = this.a();
        while (u2.a()) {
            r.a(u2, n2, n3);
        }
        this.b(this.d() + n3);
    }

    private static void a(u u2, int n2, int n3) {
        int n4 = u2.d();
        int n5 = u2.a(n4);
        if (n5 < 21) {
            return;
        }
        if (n5 < 79) {
            if (n5 < 26) {
                r.a(u2, n4, n5, n2, n3);
            } else if (n5 < 46) {
                r.a(u2, n4, n5, n2, n3, 26, 21);
            } else {
                if (n5 < 54) {
                    return;
                }
                if (n5 < 59) {
                    r.a(u2, n4, n5, n2, n3);
                } else {
                    r.a(u2, n4, n5, n2, n3, 59, 54);
                }
            }
        } else if (n5 == 132) {
            int n6 = u2.a(n4 + 1);
            if (n6 < n2) {
                return;
            }
            if ((n6 += n3) < 256) {
                u2.a(n6, n4 + 1);
            } else {
                byte by = (byte)u2.a(n4 + 2);
                int n7 = u2.g(3);
                u2.a(196, n7 - 3);
                u2.a(132, n7 - 2);
                u2.b(n6, n7 - 1);
                u2.b((int)by, n7 + 1);
            }
        } else if (n5 == 169) {
            r.a(u2, n4, n5, n2, n3);
        } else if (n5 == 196) {
            int n8 = u2.c(n4 + 2);
            if (n8 < n2) {
                return;
            }
            u2.b(n8 += n3, n4 + 2);
        }
    }

    private static void a(u u2, int n2, int n3, int n4, int n5) {
        int n6 = u2.a(n2 + 1);
        if (n6 < n4) {
            return;
        }
        if ((n6 += n5) < 256) {
            u2.a(n6, n2 + 1);
        } else {
            int n7 = u2.g(2);
            u2.a(196, n7 - 2);
            u2.a(n3, n7 - 1);
            u2.b(n6, n7);
        }
    }

    private static void a(u u2, int n2, int n3, int n4, int n5, int n6, int n7) {
        int n8 = (n3 - n6) % 4;
        if (n8 < n4) {
            return;
        }
        if ((n8 += n5) < 4) {
            u2.a(n3 + n5, n2);
        } else {
            n3 = (n3 - n6) / 4 + n7;
            if (n8 < 256) {
                int n9 = u2.g(1);
                u2.a(n3, n9 - 1);
                u2.a(n8, n9);
            } else {
                int n10 = u2.g(3);
                u2.a(196, n10 - 1);
                u2.a(n3, n10);
                u2.b(n8, n10 + 1);
            }
        }
    }
}

