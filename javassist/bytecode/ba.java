/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode;

import java.io.PrintWriter;
import javassist.bytecode.aV;
import javassist.bytecode.bf;
import javassist.bytecode.i;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
class ba
extends bf {
    private PrintWriter a;
    private int a;

    public static void a(aV aV2, PrintWriter printWriter) {
        try {
            new ba(aV2.a(), printWriter).b();
        } catch (i i2) {
            printWriter.println(i2.getMessage());
        }
    }

    ba(byte[] byArray, PrintWriter printWriter) {
        super(byArray);
        this.a = printWriter;
        this.a = -1;
    }

    @Override
    public void a(int n2, int n3) {
        this.a += n3 + 1;
        this.a.println(this.a + " same frame: " + n3);
    }

    @Override
    public void a(int n2, int n3, int n4, int n5) {
        this.a += n3 + 1;
        this.a.println(this.a + " same locals: " + n3);
        this.b(n4, n5);
    }

    @Override
    public void b(int n2, int n3, int n4) {
        this.a += n3 + 1;
        this.a.println(this.a + " chop frame: " + n3 + ",    " + n4 + " last locals");
    }

    @Override
    public void a(int n2, int n3, int[] nArray, int[] nArray2) {
        this.a += n3 + 1;
        this.a.println(this.a + " append frame: " + n3);
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            this.b(nArray[i2], nArray2[i2]);
        }
    }

    @Override
    public void a(int n2, int n3, int[] nArray, int[] nArray2, int[] nArray3, int[] nArray4) {
        int n4;
        this.a += n3 + 1;
        this.a.println(this.a + " full frame: " + n3);
        this.a.println("[locals]");
        for (n4 = 0; n4 < nArray.length; ++n4) {
            this.b(nArray[n4], nArray2[n4]);
        }
        this.a.println("[stack]");
        for (n4 = 0; n4 < nArray3.length; ++n4) {
            this.b(nArray3[n4], nArray4[n4]);
        }
    }

    private void b(int n2, int n3) {
        String string = null;
        switch (n2) {
            case 0: {
                string = "top";
                break;
            }
            case 1: {
                string = "integer";
                break;
            }
            case 2: {
                string = "float";
                break;
            }
            case 3: {
                string = "double";
                break;
            }
            case 4: {
                string = "long";
                break;
            }
            case 5: {
                string = "null";
                break;
            }
            case 6: {
                string = "this";
                break;
            }
            case 7: {
                string = "object (cpool_index " + n3 + ")";
                break;
            }
            case 8: {
                string = "uninitialized (offset " + n3 + ")";
            }
        }
        this.a.print("    ");
        this.a.println(string);
    }
}

