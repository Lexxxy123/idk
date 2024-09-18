/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.slf4j.helpers;

import java.util.HashMap;
import java.util.Map;
import javassist.orgs.slf4j.helpers.f;
import javassist.orgs.slf4j.helpers.o;
import javassist.orgs.slf4j.helpers.s;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class i {
    static final char a = '{';
    static final char b = '}';
    static final String a = "{}";
    private static final char c = '\\';

    public static final f a(String string, Object object) {
        return i.a(string, new Object[]{object});
    }

    public static final f a(String string, Object object, Object object2) {
        return i.a(string, new Object[]{object, object2});
    }

    public static final f a(String string, Object[] objectArray) {
        Throwable throwable = i.a(objectArray);
        Object[] objectArray2 = objectArray;
        if (throwable != null) {
            objectArray2 = i.a(objectArray);
        }
        return i.a(string, objectArray2, throwable);
    }

    public static final String a(String string, Object[] objectArray) {
        f f2 = i.a(string, objectArray, null);
        return f2.a();
    }

    public static String a(o o2) {
        return i.a(o2.a(), o2.a());
    }

    public static final f a(String string, Object[] objectArray, Throwable throwable) {
        if (string == null) {
            return new f(null, objectArray, throwable);
        }
        if (objectArray == null) {
            return new f(string);
        }
        int n2 = 0;
        StringBuilder stringBuilder = new StringBuilder(string.length() + 50);
        int n3 = 0;
        while (n3 < objectArray.length) {
            int n4 = string.indexOf(a, n2);
            if (n4 == -1) {
                if (n2 == 0) {
                    return new f(string, objectArray, throwable);
                }
                stringBuilder.append(string, n2, string.length());
                return new f(stringBuilder.toString(), objectArray, throwable);
            }
            if (i.a(string, n4)) {
                if (!i.b(string, n4)) {
                    --n3;
                    stringBuilder.append(string, n2, n4 - 1);
                    stringBuilder.append('{');
                    n2 = n4 + 1;
                } else {
                    stringBuilder.append(string, n2, n4 - 1);
                    i.a(stringBuilder, objectArray[n3], new HashMap<Object[], Object>());
                    n2 = n4 + 2;
                }
            } else {
                stringBuilder.append(string, n2, n4);
                i.a(stringBuilder, objectArray[n3], new HashMap<Object[], Object>());
                n2 = n4 + 2;
            }
            ++n3;
        }
        stringBuilder.append(string, n2, string.length());
        return new f(stringBuilder.toString(), objectArray, throwable);
    }

    static final boolean a(String string, int n2) {
        if (n2 == 0) {
            return false;
        }
        char c2 = string.charAt(n2 - 1);
        return c2 == '\\';
    }

    static final boolean b(String string, int n2) {
        return n2 >= 2 && string.charAt(n2 - 2) == '\\';
    }

    private static void a(StringBuilder stringBuilder, Object object, Map<Object[], Object> map) {
        if (object == null) {
            stringBuilder.append("null");
            return;
        }
        if (!object.getClass().isArray()) {
            i.a(stringBuilder, object);
        } else if (object instanceof boolean[]) {
            i.a(stringBuilder, (boolean[])object);
        } else if (object instanceof byte[]) {
            i.a(stringBuilder, (byte[])object);
        } else if (object instanceof char[]) {
            i.a(stringBuilder, (char[])object);
        } else if (object instanceof short[]) {
            i.a(stringBuilder, (short[])object);
        } else if (object instanceof int[]) {
            i.a(stringBuilder, (int[])object);
        } else if (object instanceof long[]) {
            i.a(stringBuilder, (long[])object);
        } else if (object instanceof float[]) {
            i.a(stringBuilder, (float[])object);
        } else if (object instanceof double[]) {
            i.a(stringBuilder, (double[])object);
        } else {
            i.a(stringBuilder, (Object[])object, map);
        }
    }

    private static void a(StringBuilder stringBuilder, Object object) {
        try {
            String string = object.toString();
            stringBuilder.append(string);
        } catch (Throwable throwable) {
            s.a("SLF4J: Failed toString() invocation on an object of type [" + object.getClass().getName() + "]", throwable);
            stringBuilder.append("[FAILED toString()]");
        }
    }

    private static void a(StringBuilder stringBuilder, Object[] objectArray, Map<Object[], Object> map) {
        stringBuilder.append('[');
        if (!map.containsKey(objectArray)) {
            map.put(objectArray, null);
            int n2 = objectArray.length;
            int n3 = 0;
            while (n3 < n2) {
                i.a(stringBuilder, objectArray[n3], map);
                if (n3 != n2 - 1) {
                    stringBuilder.append(", ");
                }
                ++n3;
            }
            map.remove(objectArray);
        } else {
            stringBuilder.append("...");
        }
        stringBuilder.append(']');
    }

    private static void a(StringBuilder stringBuilder, boolean[] blArray) {
        stringBuilder.append('[');
        int n2 = blArray.length;
        int n3 = 0;
        while (n3 < n2) {
            stringBuilder.append(blArray[n3]);
            if (n3 != n2 - 1) {
                stringBuilder.append(", ");
            }
            ++n3;
        }
        stringBuilder.append(']');
    }

    private static void a(StringBuilder stringBuilder, byte[] byArray) {
        stringBuilder.append('[');
        int n2 = byArray.length;
        int n3 = 0;
        while (n3 < n2) {
            stringBuilder.append(byArray[n3]);
            if (n3 != n2 - 1) {
                stringBuilder.append(", ");
            }
            ++n3;
        }
        stringBuilder.append(']');
    }

    private static void a(StringBuilder stringBuilder, char[] cArray) {
        stringBuilder.append('[');
        int n2 = cArray.length;
        int n3 = 0;
        while (n3 < n2) {
            stringBuilder.append(cArray[n3]);
            if (n3 != n2 - 1) {
                stringBuilder.append(", ");
            }
            ++n3;
        }
        stringBuilder.append(']');
    }

    private static void a(StringBuilder stringBuilder, short[] sArray) {
        stringBuilder.append('[');
        int n2 = sArray.length;
        int n3 = 0;
        while (n3 < n2) {
            stringBuilder.append(sArray[n3]);
            if (n3 != n2 - 1) {
                stringBuilder.append(", ");
            }
            ++n3;
        }
        stringBuilder.append(']');
    }

    private static void a(StringBuilder stringBuilder, int[] nArray) {
        stringBuilder.append('[');
        int n2 = nArray.length;
        int n3 = 0;
        while (n3 < n2) {
            stringBuilder.append(nArray[n3]);
            if (n3 != n2 - 1) {
                stringBuilder.append(", ");
            }
            ++n3;
        }
        stringBuilder.append(']');
    }

    private static void a(StringBuilder stringBuilder, long[] lArray) {
        stringBuilder.append('[');
        int n2 = lArray.length;
        int n3 = 0;
        while (n3 < n2) {
            stringBuilder.append(lArray[n3]);
            if (n3 != n2 - 1) {
                stringBuilder.append(", ");
            }
            ++n3;
        }
        stringBuilder.append(']');
    }

    private static void a(StringBuilder stringBuilder, float[] fArray) {
        stringBuilder.append('[');
        int n2 = fArray.length;
        int n3 = 0;
        while (n3 < n2) {
            stringBuilder.append(fArray[n3]);
            if (n3 != n2 - 1) {
                stringBuilder.append(", ");
            }
            ++n3;
        }
        stringBuilder.append(']');
    }

    private static void a(StringBuilder stringBuilder, double[] dArray) {
        stringBuilder.append('[');
        int n2 = dArray.length;
        int n3 = 0;
        while (n3 < n2) {
            stringBuilder.append(dArray[n3]);
            if (n3 != n2 - 1) {
                stringBuilder.append(", ");
            }
            ++n3;
        }
        stringBuilder.append(']');
    }

    public static Throwable a(Object[] objectArray) {
        return o.a(objectArray);
    }

    public static Object[] a(Object[] objectArray) {
        return o.a(objectArray);
    }
}

