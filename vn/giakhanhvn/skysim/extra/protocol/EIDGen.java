/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package vn.giakhanhvn.skysim.extra.protocol;

class EIDGen {
    private static int lastIssuedEID = 2000000000;

    EIDGen() {
    }

    static int generateEID() {
        return lastIssuedEID++;
    }
}

