/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.java_websocket.util;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import javassist.orgs.java_websocket.exceptions.c;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class d {
    private static final CodingErrorAction a = CodingErrorAction.REPORT;
    private static final int[] a;

    static {
        int[] nArray = new int[400];
        nArray[128] = 1;
        nArray[129] = 1;
        nArray[130] = 1;
        nArray[131] = 1;
        nArray[132] = 1;
        nArray[133] = 1;
        nArray[134] = 1;
        nArray[135] = 1;
        nArray[136] = 1;
        nArray[137] = 1;
        nArray[138] = 1;
        nArray[139] = 1;
        nArray[140] = 1;
        nArray[141] = 1;
        nArray[142] = 1;
        nArray[143] = 1;
        nArray[144] = 9;
        nArray[145] = 9;
        nArray[146] = 9;
        nArray[147] = 9;
        nArray[148] = 9;
        nArray[149] = 9;
        nArray[150] = 9;
        nArray[151] = 9;
        nArray[152] = 9;
        nArray[153] = 9;
        nArray[154] = 9;
        nArray[155] = 9;
        nArray[156] = 9;
        nArray[157] = 9;
        nArray[158] = 9;
        nArray[159] = 9;
        nArray[160] = 7;
        nArray[161] = 7;
        nArray[162] = 7;
        nArray[163] = 7;
        nArray[164] = 7;
        nArray[165] = 7;
        nArray[166] = 7;
        nArray[167] = 7;
        nArray[168] = 7;
        nArray[169] = 7;
        nArray[170] = 7;
        nArray[171] = 7;
        nArray[172] = 7;
        nArray[173] = 7;
        nArray[174] = 7;
        nArray[175] = 7;
        nArray[176] = 7;
        nArray[177] = 7;
        nArray[178] = 7;
        nArray[179] = 7;
        nArray[180] = 7;
        nArray[181] = 7;
        nArray[182] = 7;
        nArray[183] = 7;
        nArray[184] = 7;
        nArray[185] = 7;
        nArray[186] = 7;
        nArray[187] = 7;
        nArray[188] = 7;
        nArray[189] = 7;
        nArray[190] = 7;
        nArray[191] = 7;
        nArray[192] = 8;
        nArray[193] = 8;
        nArray[194] = 2;
        nArray[195] = 2;
        nArray[196] = 2;
        nArray[197] = 2;
        nArray[198] = 2;
        nArray[199] = 2;
        nArray[200] = 2;
        nArray[201] = 2;
        nArray[202] = 2;
        nArray[203] = 2;
        nArray[204] = 2;
        nArray[205] = 2;
        nArray[206] = 2;
        nArray[207] = 2;
        nArray[208] = 2;
        nArray[209] = 2;
        nArray[210] = 2;
        nArray[211] = 2;
        nArray[212] = 2;
        nArray[213] = 2;
        nArray[214] = 2;
        nArray[215] = 2;
        nArray[216] = 2;
        nArray[217] = 2;
        nArray[218] = 2;
        nArray[219] = 2;
        nArray[220] = 2;
        nArray[221] = 2;
        nArray[222] = 2;
        nArray[223] = 2;
        nArray[224] = 10;
        nArray[225] = 3;
        nArray[226] = 3;
        nArray[227] = 3;
        nArray[228] = 3;
        nArray[229] = 3;
        nArray[230] = 3;
        nArray[231] = 3;
        nArray[232] = 3;
        nArray[233] = 3;
        nArray[234] = 3;
        nArray[235] = 3;
        nArray[236] = 3;
        nArray[237] = 4;
        nArray[238] = 3;
        nArray[239] = 3;
        nArray[240] = 11;
        nArray[241] = 6;
        nArray[242] = 6;
        nArray[243] = 6;
        nArray[244] = 5;
        nArray[245] = 8;
        nArray[246] = 8;
        nArray[247] = 8;
        nArray[248] = 8;
        nArray[249] = 8;
        nArray[250] = 8;
        nArray[251] = 8;
        nArray[252] = 8;
        nArray[253] = 8;
        nArray[254] = 8;
        nArray[255] = 8;
        nArray[257] = 1;
        nArray[258] = 2;
        nArray[259] = 3;
        nArray[260] = 5;
        nArray[261] = 8;
        nArray[262] = 7;
        nArray[263] = 1;
        nArray[264] = 1;
        nArray[265] = 1;
        nArray[266] = 4;
        nArray[267] = 6;
        nArray[268] = 1;
        nArray[269] = 1;
        nArray[270] = 1;
        nArray[271] = 1;
        nArray[272] = 1;
        nArray[273] = 1;
        nArray[274] = 1;
        nArray[275] = 1;
        nArray[276] = 1;
        nArray[277] = 1;
        nArray[278] = 1;
        nArray[279] = 1;
        nArray[280] = 1;
        nArray[281] = 1;
        nArray[282] = 1;
        nArray[283] = 1;
        nArray[284] = 1;
        nArray[285] = 1;
        nArray[286] = 1;
        nArray[287] = 1;
        nArray[288] = 1;
        nArray[290] = 1;
        nArray[291] = 1;
        nArray[292] = 1;
        nArray[293] = 1;
        nArray[294] = 1;
        nArray[296] = 1;
        nArray[298] = 1;
        nArray[299] = 1;
        nArray[300] = 1;
        nArray[301] = 1;
        nArray[302] = 1;
        nArray[303] = 1;
        nArray[304] = 1;
        nArray[305] = 2;
        nArray[306] = 1;
        nArray[307] = 1;
        nArray[308] = 1;
        nArray[309] = 1;
        nArray[310] = 1;
        nArray[311] = 2;
        nArray[312] = 1;
        nArray[313] = 2;
        nArray[314] = 1;
        nArray[315] = 1;
        nArray[316] = 1;
        nArray[317] = 1;
        nArray[318] = 1;
        nArray[319] = 1;
        nArray[320] = 1;
        nArray[321] = 1;
        nArray[322] = 1;
        nArray[323] = 1;
        nArray[324] = 1;
        nArray[325] = 1;
        nArray[326] = 1;
        nArray[327] = 2;
        nArray[328] = 1;
        nArray[329] = 1;
        nArray[330] = 1;
        nArray[331] = 1;
        nArray[332] = 1;
        nArray[333] = 1;
        nArray[334] = 1;
        nArray[335] = 1;
        nArray[336] = 1;
        nArray[337] = 2;
        nArray[338] = 1;
        nArray[339] = 1;
        nArray[340] = 1;
        nArray[341] = 1;
        nArray[342] = 1;
        nArray[343] = 1;
        nArray[344] = 1;
        nArray[345] = 2;
        nArray[346] = 1;
        nArray[347] = 1;
        nArray[348] = 1;
        nArray[349] = 1;
        nArray[350] = 1;
        nArray[351] = 1;
        nArray[352] = 1;
        nArray[353] = 1;
        nArray[354] = 1;
        nArray[355] = 1;
        nArray[356] = 1;
        nArray[357] = 1;
        nArray[358] = 1;
        nArray[359] = 3;
        nArray[360] = 1;
        nArray[361] = 3;
        nArray[362] = 1;
        nArray[363] = 1;
        nArray[364] = 1;
        nArray[365] = 1;
        nArray[366] = 1;
        nArray[367] = 1;
        nArray[368] = 1;
        nArray[369] = 3;
        nArray[370] = 1;
        nArray[371] = 1;
        nArray[372] = 1;
        nArray[373] = 1;
        nArray[374] = 1;
        nArray[375] = 3;
        nArray[376] = 1;
        nArray[377] = 3;
        nArray[378] = 1;
        nArray[379] = 1;
        nArray[380] = 1;
        nArray[381] = 1;
        nArray[382] = 1;
        nArray[383] = 1;
        nArray[384] = 1;
        nArray[385] = 3;
        nArray[386] = 1;
        nArray[387] = 1;
        nArray[388] = 1;
        nArray[389] = 1;
        nArray[390] = 1;
        nArray[391] = 1;
        nArray[392] = 1;
        nArray[393] = 1;
        nArray[394] = 1;
        nArray[395] = 1;
        nArray[396] = 1;
        nArray[397] = 1;
        nArray[398] = 1;
        nArray[399] = 1;
        a = nArray;
    }

    private d() {
    }

    public static byte[] a(String string) {
        try {
            return string.getBytes("UTF8");
        } catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new javassist.orgs.java_websocket.exceptions.d(unsupportedEncodingException);
        }
    }

    public static byte[] b(String string) {
        try {
            return string.getBytes("ASCII");
        } catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new javassist.orgs.java_websocket.exceptions.d(unsupportedEncodingException);
        }
    }

    public static String a(byte[] byArray) {
        return d.a(byArray, 0, byArray.length);
    }

    public static String a(byte[] byArray, int n2, int n3) {
        try {
            return new String(byArray, n2, n3, "ASCII");
        } catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new javassist.orgs.java_websocket.exceptions.d(unsupportedEncodingException);
        }
    }

    public static String b(byte[] byArray) {
        return d.a(ByteBuffer.wrap(byArray));
    }

    public static String a(ByteBuffer byteBuffer) {
        String string;
        CharsetDecoder charsetDecoder = Charset.forName("UTF8").newDecoder();
        charsetDecoder.onMalformedInput(a);
        charsetDecoder.onUnmappableCharacter(a);
        try {
            byteBuffer.mark();
            string = charsetDecoder.decode(byteBuffer).toString();
            byteBuffer.reset();
        } catch (CharacterCodingException characterCodingException) {
            throw new c(1007, (Throwable)characterCodingException);
        }
        return string;
    }

    public static boolean a(ByteBuffer byteBuffer, int n2) {
        int n3 = byteBuffer.remaining();
        if (n3 < n2) {
            return false;
        }
        int n4 = 0;
        int n5 = n2;
        while (n5 < n3) {
            if ((n4 = a[256 + (n4 << 4) + a[0xFF & byteBuffer.get(n5)]]) == 1) {
                return false;
            }
            ++n5;
        }
        return true;
    }

    public static boolean a(ByteBuffer byteBuffer) {
        return d.a(byteBuffer, 0);
    }
}

