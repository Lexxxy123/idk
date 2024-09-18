/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.java_websocket.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.GZIPOutputStream;
import javassist.orgs.java_websocket.util.b;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class a {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 8;
    public static final int e = 16;
    public static final int f = 32;
    private static final int g = 76;
    private static final byte a = 61;
    private static final byte b = 10;
    private static final String a = "US-ASCII";
    private static final byte c = -5;
    private static final byte[] a = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] b;
    private static final byte[] c;
    private static final byte[] d;
    private static final byte[] e;
    private static final byte[] f;

    static {
        byte[] byArray = new byte[256];
        byArray[0] = -9;
        byArray[1] = -9;
        byArray[2] = -9;
        byArray[3] = -9;
        byArray[4] = -9;
        byArray[5] = -9;
        byArray[6] = -9;
        byArray[7] = -9;
        byArray[8] = -9;
        byArray[9] = -5;
        byArray[10] = -5;
        byArray[11] = -9;
        byArray[12] = -9;
        byArray[13] = -5;
        byArray[14] = -9;
        byArray[15] = -9;
        byArray[16] = -9;
        byArray[17] = -9;
        byArray[18] = -9;
        byArray[19] = -9;
        byArray[20] = -9;
        byArray[21] = -9;
        byArray[22] = -9;
        byArray[23] = -9;
        byArray[24] = -9;
        byArray[25] = -9;
        byArray[26] = -9;
        byArray[27] = -9;
        byArray[28] = -9;
        byArray[29] = -9;
        byArray[30] = -9;
        byArray[31] = -9;
        byArray[32] = -5;
        byArray[33] = -9;
        byArray[34] = -9;
        byArray[35] = -9;
        byArray[36] = -9;
        byArray[37] = -9;
        byArray[38] = -9;
        byArray[39] = -9;
        byArray[40] = -9;
        byArray[41] = -9;
        byArray[42] = -9;
        byArray[43] = 62;
        byArray[44] = -9;
        byArray[45] = -9;
        byArray[46] = -9;
        byArray[47] = 63;
        byArray[48] = 52;
        byArray[49] = 53;
        byArray[50] = 54;
        byArray[51] = 55;
        byArray[52] = 56;
        byArray[53] = 57;
        byArray[54] = 58;
        byArray[55] = 59;
        byArray[56] = 60;
        byArray[57] = 61;
        byArray[58] = -9;
        byArray[59] = -9;
        byArray[60] = -9;
        byArray[61] = -1;
        byArray[62] = -9;
        byArray[63] = -9;
        byArray[64] = -9;
        byArray[66] = 1;
        byArray[67] = 2;
        byArray[68] = 3;
        byArray[69] = 4;
        byArray[70] = 5;
        byArray[71] = 6;
        byArray[72] = 7;
        byArray[73] = 8;
        byArray[74] = 9;
        byArray[75] = 10;
        byArray[76] = 11;
        byArray[77] = 12;
        byArray[78] = 13;
        byArray[79] = 14;
        byArray[80] = 15;
        byArray[81] = 16;
        byArray[82] = 17;
        byArray[83] = 18;
        byArray[84] = 19;
        byArray[85] = 20;
        byArray[86] = 21;
        byArray[87] = 22;
        byArray[88] = 23;
        byArray[89] = 24;
        byArray[90] = 25;
        byArray[91] = -9;
        byArray[92] = -9;
        byArray[93] = -9;
        byArray[94] = -9;
        byArray[95] = -9;
        byArray[96] = -9;
        byArray[97] = 26;
        byArray[98] = 27;
        byArray[99] = 28;
        byArray[100] = 29;
        byArray[101] = 30;
        byArray[102] = 31;
        byArray[103] = 32;
        byArray[104] = 33;
        byArray[105] = 34;
        byArray[106] = 35;
        byArray[107] = 36;
        byArray[108] = 37;
        byArray[109] = 38;
        byArray[110] = 39;
        byArray[111] = 40;
        byArray[112] = 41;
        byArray[113] = 42;
        byArray[114] = 43;
        byArray[115] = 44;
        byArray[116] = 45;
        byArray[117] = 46;
        byArray[118] = 47;
        byArray[119] = 48;
        byArray[120] = 49;
        byArray[121] = 50;
        byArray[122] = 51;
        byArray[123] = -9;
        byArray[124] = -9;
        byArray[125] = -9;
        byArray[126] = -9;
        byArray[127] = -9;
        byArray[128] = -9;
        byArray[129] = -9;
        byArray[130] = -9;
        byArray[131] = -9;
        byArray[132] = -9;
        byArray[133] = -9;
        byArray[134] = -9;
        byArray[135] = -9;
        byArray[136] = -9;
        byArray[137] = -9;
        byArray[138] = -9;
        byArray[139] = -9;
        byArray[140] = -9;
        byArray[141] = -9;
        byArray[142] = -9;
        byArray[143] = -9;
        byArray[144] = -9;
        byArray[145] = -9;
        byArray[146] = -9;
        byArray[147] = -9;
        byArray[148] = -9;
        byArray[149] = -9;
        byArray[150] = -9;
        byArray[151] = -9;
        byArray[152] = -9;
        byArray[153] = -9;
        byArray[154] = -9;
        byArray[155] = -9;
        byArray[156] = -9;
        byArray[157] = -9;
        byArray[158] = -9;
        byArray[159] = -9;
        byArray[160] = -9;
        byArray[161] = -9;
        byArray[162] = -9;
        byArray[163] = -9;
        byArray[164] = -9;
        byArray[165] = -9;
        byArray[166] = -9;
        byArray[167] = -9;
        byArray[168] = -9;
        byArray[169] = -9;
        byArray[170] = -9;
        byArray[171] = -9;
        byArray[172] = -9;
        byArray[173] = -9;
        byArray[174] = -9;
        byArray[175] = -9;
        byArray[176] = -9;
        byArray[177] = -9;
        byArray[178] = -9;
        byArray[179] = -9;
        byArray[180] = -9;
        byArray[181] = -9;
        byArray[182] = -9;
        byArray[183] = -9;
        byArray[184] = -9;
        byArray[185] = -9;
        byArray[186] = -9;
        byArray[187] = -9;
        byArray[188] = -9;
        byArray[189] = -9;
        byArray[190] = -9;
        byArray[191] = -9;
        byArray[192] = -9;
        byArray[193] = -9;
        byArray[194] = -9;
        byArray[195] = -9;
        byArray[196] = -9;
        byArray[197] = -9;
        byArray[198] = -9;
        byArray[199] = -9;
        byArray[200] = -9;
        byArray[201] = -9;
        byArray[202] = -9;
        byArray[203] = -9;
        byArray[204] = -9;
        byArray[205] = -9;
        byArray[206] = -9;
        byArray[207] = -9;
        byArray[208] = -9;
        byArray[209] = -9;
        byArray[210] = -9;
        byArray[211] = -9;
        byArray[212] = -9;
        byArray[213] = -9;
        byArray[214] = -9;
        byArray[215] = -9;
        byArray[216] = -9;
        byArray[217] = -9;
        byArray[218] = -9;
        byArray[219] = -9;
        byArray[220] = -9;
        byArray[221] = -9;
        byArray[222] = -9;
        byArray[223] = -9;
        byArray[224] = -9;
        byArray[225] = -9;
        byArray[226] = -9;
        byArray[227] = -9;
        byArray[228] = -9;
        byArray[229] = -9;
        byArray[230] = -9;
        byArray[231] = -9;
        byArray[232] = -9;
        byArray[233] = -9;
        byArray[234] = -9;
        byArray[235] = -9;
        byArray[236] = -9;
        byArray[237] = -9;
        byArray[238] = -9;
        byArray[239] = -9;
        byArray[240] = -9;
        byArray[241] = -9;
        byArray[242] = -9;
        byArray[243] = -9;
        byArray[244] = -9;
        byArray[245] = -9;
        byArray[246] = -9;
        byArray[247] = -9;
        byArray[248] = -9;
        byArray[249] = -9;
        byArray[250] = -9;
        byArray[251] = -9;
        byArray[252] = -9;
        byArray[253] = -9;
        byArray[254] = -9;
        byArray[255] = -9;
        b = byArray;
        c = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        byte[] byArray2 = new byte[256];
        byArray2[0] = -9;
        byArray2[1] = -9;
        byArray2[2] = -9;
        byArray2[3] = -9;
        byArray2[4] = -9;
        byArray2[5] = -9;
        byArray2[6] = -9;
        byArray2[7] = -9;
        byArray2[8] = -9;
        byArray2[9] = -5;
        byArray2[10] = -5;
        byArray2[11] = -9;
        byArray2[12] = -9;
        byArray2[13] = -5;
        byArray2[14] = -9;
        byArray2[15] = -9;
        byArray2[16] = -9;
        byArray2[17] = -9;
        byArray2[18] = -9;
        byArray2[19] = -9;
        byArray2[20] = -9;
        byArray2[21] = -9;
        byArray2[22] = -9;
        byArray2[23] = -9;
        byArray2[24] = -9;
        byArray2[25] = -9;
        byArray2[26] = -9;
        byArray2[27] = -9;
        byArray2[28] = -9;
        byArray2[29] = -9;
        byArray2[30] = -9;
        byArray2[31] = -9;
        byArray2[32] = -5;
        byArray2[33] = -9;
        byArray2[34] = -9;
        byArray2[35] = -9;
        byArray2[36] = -9;
        byArray2[37] = -9;
        byArray2[38] = -9;
        byArray2[39] = -9;
        byArray2[40] = -9;
        byArray2[41] = -9;
        byArray2[42] = -9;
        byArray2[43] = -9;
        byArray2[44] = -9;
        byArray2[45] = 62;
        byArray2[46] = -9;
        byArray2[47] = -9;
        byArray2[48] = 52;
        byArray2[49] = 53;
        byArray2[50] = 54;
        byArray2[51] = 55;
        byArray2[52] = 56;
        byArray2[53] = 57;
        byArray2[54] = 58;
        byArray2[55] = 59;
        byArray2[56] = 60;
        byArray2[57] = 61;
        byArray2[58] = -9;
        byArray2[59] = -9;
        byArray2[60] = -9;
        byArray2[61] = -1;
        byArray2[62] = -9;
        byArray2[63] = -9;
        byArray2[64] = -9;
        byArray2[66] = 1;
        byArray2[67] = 2;
        byArray2[68] = 3;
        byArray2[69] = 4;
        byArray2[70] = 5;
        byArray2[71] = 6;
        byArray2[72] = 7;
        byArray2[73] = 8;
        byArray2[74] = 9;
        byArray2[75] = 10;
        byArray2[76] = 11;
        byArray2[77] = 12;
        byArray2[78] = 13;
        byArray2[79] = 14;
        byArray2[80] = 15;
        byArray2[81] = 16;
        byArray2[82] = 17;
        byArray2[83] = 18;
        byArray2[84] = 19;
        byArray2[85] = 20;
        byArray2[86] = 21;
        byArray2[87] = 22;
        byArray2[88] = 23;
        byArray2[89] = 24;
        byArray2[90] = 25;
        byArray2[91] = -9;
        byArray2[92] = -9;
        byArray2[93] = -9;
        byArray2[94] = -9;
        byArray2[95] = 63;
        byArray2[96] = -9;
        byArray2[97] = 26;
        byArray2[98] = 27;
        byArray2[99] = 28;
        byArray2[100] = 29;
        byArray2[101] = 30;
        byArray2[102] = 31;
        byArray2[103] = 32;
        byArray2[104] = 33;
        byArray2[105] = 34;
        byArray2[106] = 35;
        byArray2[107] = 36;
        byArray2[108] = 37;
        byArray2[109] = 38;
        byArray2[110] = 39;
        byArray2[111] = 40;
        byArray2[112] = 41;
        byArray2[113] = 42;
        byArray2[114] = 43;
        byArray2[115] = 44;
        byArray2[116] = 45;
        byArray2[117] = 46;
        byArray2[118] = 47;
        byArray2[119] = 48;
        byArray2[120] = 49;
        byArray2[121] = 50;
        byArray2[122] = 51;
        byArray2[123] = -9;
        byArray2[124] = -9;
        byArray2[125] = -9;
        byArray2[126] = -9;
        byArray2[127] = -9;
        byArray2[128] = -9;
        byArray2[129] = -9;
        byArray2[130] = -9;
        byArray2[131] = -9;
        byArray2[132] = -9;
        byArray2[133] = -9;
        byArray2[134] = -9;
        byArray2[135] = -9;
        byArray2[136] = -9;
        byArray2[137] = -9;
        byArray2[138] = -9;
        byArray2[139] = -9;
        byArray2[140] = -9;
        byArray2[141] = -9;
        byArray2[142] = -9;
        byArray2[143] = -9;
        byArray2[144] = -9;
        byArray2[145] = -9;
        byArray2[146] = -9;
        byArray2[147] = -9;
        byArray2[148] = -9;
        byArray2[149] = -9;
        byArray2[150] = -9;
        byArray2[151] = -9;
        byArray2[152] = -9;
        byArray2[153] = -9;
        byArray2[154] = -9;
        byArray2[155] = -9;
        byArray2[156] = -9;
        byArray2[157] = -9;
        byArray2[158] = -9;
        byArray2[159] = -9;
        byArray2[160] = -9;
        byArray2[161] = -9;
        byArray2[162] = -9;
        byArray2[163] = -9;
        byArray2[164] = -9;
        byArray2[165] = -9;
        byArray2[166] = -9;
        byArray2[167] = -9;
        byArray2[168] = -9;
        byArray2[169] = -9;
        byArray2[170] = -9;
        byArray2[171] = -9;
        byArray2[172] = -9;
        byArray2[173] = -9;
        byArray2[174] = -9;
        byArray2[175] = -9;
        byArray2[176] = -9;
        byArray2[177] = -9;
        byArray2[178] = -9;
        byArray2[179] = -9;
        byArray2[180] = -9;
        byArray2[181] = -9;
        byArray2[182] = -9;
        byArray2[183] = -9;
        byArray2[184] = -9;
        byArray2[185] = -9;
        byArray2[186] = -9;
        byArray2[187] = -9;
        byArray2[188] = -9;
        byArray2[189] = -9;
        byArray2[190] = -9;
        byArray2[191] = -9;
        byArray2[192] = -9;
        byArray2[193] = -9;
        byArray2[194] = -9;
        byArray2[195] = -9;
        byArray2[196] = -9;
        byArray2[197] = -9;
        byArray2[198] = -9;
        byArray2[199] = -9;
        byArray2[200] = -9;
        byArray2[201] = -9;
        byArray2[202] = -9;
        byArray2[203] = -9;
        byArray2[204] = -9;
        byArray2[205] = -9;
        byArray2[206] = -9;
        byArray2[207] = -9;
        byArray2[208] = -9;
        byArray2[209] = -9;
        byArray2[210] = -9;
        byArray2[211] = -9;
        byArray2[212] = -9;
        byArray2[213] = -9;
        byArray2[214] = -9;
        byArray2[215] = -9;
        byArray2[216] = -9;
        byArray2[217] = -9;
        byArray2[218] = -9;
        byArray2[219] = -9;
        byArray2[220] = -9;
        byArray2[221] = -9;
        byArray2[222] = -9;
        byArray2[223] = -9;
        byArray2[224] = -9;
        byArray2[225] = -9;
        byArray2[226] = -9;
        byArray2[227] = -9;
        byArray2[228] = -9;
        byArray2[229] = -9;
        byArray2[230] = -9;
        byArray2[231] = -9;
        byArray2[232] = -9;
        byArray2[233] = -9;
        byArray2[234] = -9;
        byArray2[235] = -9;
        byArray2[236] = -9;
        byArray2[237] = -9;
        byArray2[238] = -9;
        byArray2[239] = -9;
        byArray2[240] = -9;
        byArray2[241] = -9;
        byArray2[242] = -9;
        byArray2[243] = -9;
        byArray2[244] = -9;
        byArray2[245] = -9;
        byArray2[246] = -9;
        byArray2[247] = -9;
        byArray2[248] = -9;
        byArray2[249] = -9;
        byArray2[250] = -9;
        byArray2[251] = -9;
        byArray2[252] = -9;
        byArray2[253] = -9;
        byArray2[254] = -9;
        byArray2[255] = -9;
        d = byArray2;
        e = new byte[]{45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};
        byte[] byArray3 = new byte[257];
        byArray3[0] = -9;
        byArray3[1] = -9;
        byArray3[2] = -9;
        byArray3[3] = -9;
        byArray3[4] = -9;
        byArray3[5] = -9;
        byArray3[6] = -9;
        byArray3[7] = -9;
        byArray3[8] = -9;
        byArray3[9] = -5;
        byArray3[10] = -5;
        byArray3[11] = -9;
        byArray3[12] = -9;
        byArray3[13] = -5;
        byArray3[14] = -9;
        byArray3[15] = -9;
        byArray3[16] = -9;
        byArray3[17] = -9;
        byArray3[18] = -9;
        byArray3[19] = -9;
        byArray3[20] = -9;
        byArray3[21] = -9;
        byArray3[22] = -9;
        byArray3[23] = -9;
        byArray3[24] = -9;
        byArray3[25] = -9;
        byArray3[26] = -9;
        byArray3[27] = -9;
        byArray3[28] = -9;
        byArray3[29] = -9;
        byArray3[30] = -9;
        byArray3[31] = -9;
        byArray3[32] = -5;
        byArray3[33] = -9;
        byArray3[34] = -9;
        byArray3[35] = -9;
        byArray3[36] = -9;
        byArray3[37] = -9;
        byArray3[38] = -9;
        byArray3[39] = -9;
        byArray3[40] = -9;
        byArray3[41] = -9;
        byArray3[42] = -9;
        byArray3[43] = -9;
        byArray3[44] = -9;
        byArray3[46] = -9;
        byArray3[47] = -9;
        byArray3[48] = 1;
        byArray3[49] = 2;
        byArray3[50] = 3;
        byArray3[51] = 4;
        byArray3[52] = 5;
        byArray3[53] = 6;
        byArray3[54] = 7;
        byArray3[55] = 8;
        byArray3[56] = 9;
        byArray3[57] = 10;
        byArray3[58] = -9;
        byArray3[59] = -9;
        byArray3[60] = -9;
        byArray3[61] = -1;
        byArray3[62] = -9;
        byArray3[63] = -9;
        byArray3[64] = -9;
        byArray3[65] = 11;
        byArray3[66] = 12;
        byArray3[67] = 13;
        byArray3[68] = 14;
        byArray3[69] = 15;
        byArray3[70] = 16;
        byArray3[71] = 17;
        byArray3[72] = 18;
        byArray3[73] = 19;
        byArray3[74] = 20;
        byArray3[75] = 21;
        byArray3[76] = 22;
        byArray3[77] = 23;
        byArray3[78] = 24;
        byArray3[79] = 25;
        byArray3[80] = 26;
        byArray3[81] = 27;
        byArray3[82] = 28;
        byArray3[83] = 29;
        byArray3[84] = 30;
        byArray3[85] = 31;
        byArray3[86] = 32;
        byArray3[87] = 33;
        byArray3[88] = 34;
        byArray3[89] = 35;
        byArray3[90] = 36;
        byArray3[91] = -9;
        byArray3[92] = -9;
        byArray3[93] = -9;
        byArray3[94] = -9;
        byArray3[95] = 37;
        byArray3[96] = -9;
        byArray3[97] = 38;
        byArray3[98] = 39;
        byArray3[99] = 40;
        byArray3[100] = 41;
        byArray3[101] = 42;
        byArray3[102] = 43;
        byArray3[103] = 44;
        byArray3[104] = 45;
        byArray3[105] = 46;
        byArray3[106] = 47;
        byArray3[107] = 48;
        byArray3[108] = 49;
        byArray3[109] = 50;
        byArray3[110] = 51;
        byArray3[111] = 52;
        byArray3[112] = 53;
        byArray3[113] = 54;
        byArray3[114] = 55;
        byArray3[115] = 56;
        byArray3[116] = 57;
        byArray3[117] = 58;
        byArray3[118] = 59;
        byArray3[119] = 60;
        byArray3[120] = 61;
        byArray3[121] = 62;
        byArray3[122] = 63;
        byArray3[123] = -9;
        byArray3[124] = -9;
        byArray3[125] = -9;
        byArray3[126] = -9;
        byArray3[127] = -9;
        byArray3[128] = -9;
        byArray3[129] = -9;
        byArray3[130] = -9;
        byArray3[131] = -9;
        byArray3[132] = -9;
        byArray3[133] = -9;
        byArray3[134] = -9;
        byArray3[135] = -9;
        byArray3[136] = -9;
        byArray3[137] = -9;
        byArray3[138] = -9;
        byArray3[139] = -9;
        byArray3[140] = -9;
        byArray3[141] = -9;
        byArray3[142] = -9;
        byArray3[143] = -9;
        byArray3[144] = -9;
        byArray3[145] = -9;
        byArray3[146] = -9;
        byArray3[147] = -9;
        byArray3[148] = -9;
        byArray3[149] = -9;
        byArray3[150] = -9;
        byArray3[151] = -9;
        byArray3[152] = -9;
        byArray3[153] = -9;
        byArray3[154] = -9;
        byArray3[155] = -9;
        byArray3[156] = -9;
        byArray3[157] = -9;
        byArray3[158] = -9;
        byArray3[159] = -9;
        byArray3[160] = -9;
        byArray3[161] = -9;
        byArray3[162] = -9;
        byArray3[163] = -9;
        byArray3[164] = -9;
        byArray3[165] = -9;
        byArray3[166] = -9;
        byArray3[167] = -9;
        byArray3[168] = -9;
        byArray3[169] = -9;
        byArray3[170] = -9;
        byArray3[171] = -9;
        byArray3[172] = -9;
        byArray3[173] = -9;
        byArray3[174] = -9;
        byArray3[175] = -9;
        byArray3[176] = -9;
        byArray3[177] = -9;
        byArray3[178] = -9;
        byArray3[179] = -9;
        byArray3[180] = -9;
        byArray3[181] = -9;
        byArray3[182] = -9;
        byArray3[183] = -9;
        byArray3[184] = -9;
        byArray3[185] = -9;
        byArray3[186] = -9;
        byArray3[187] = -9;
        byArray3[188] = -9;
        byArray3[189] = -9;
        byArray3[190] = -9;
        byArray3[191] = -9;
        byArray3[192] = -9;
        byArray3[193] = -9;
        byArray3[194] = -9;
        byArray3[195] = -9;
        byArray3[196] = -9;
        byArray3[197] = -9;
        byArray3[198] = -9;
        byArray3[199] = -9;
        byArray3[200] = -9;
        byArray3[201] = -9;
        byArray3[202] = -9;
        byArray3[203] = -9;
        byArray3[204] = -9;
        byArray3[205] = -9;
        byArray3[206] = -9;
        byArray3[207] = -9;
        byArray3[208] = -9;
        byArray3[209] = -9;
        byArray3[210] = -9;
        byArray3[211] = -9;
        byArray3[212] = -9;
        byArray3[213] = -9;
        byArray3[214] = -9;
        byArray3[215] = -9;
        byArray3[216] = -9;
        byArray3[217] = -9;
        byArray3[218] = -9;
        byArray3[219] = -9;
        byArray3[220] = -9;
        byArray3[221] = -9;
        byArray3[222] = -9;
        byArray3[223] = -9;
        byArray3[224] = -9;
        byArray3[225] = -9;
        byArray3[226] = -9;
        byArray3[227] = -9;
        byArray3[228] = -9;
        byArray3[229] = -9;
        byArray3[230] = -9;
        byArray3[231] = -9;
        byArray3[232] = -9;
        byArray3[233] = -9;
        byArray3[234] = -9;
        byArray3[235] = -9;
        byArray3[236] = -9;
        byArray3[237] = -9;
        byArray3[238] = -9;
        byArray3[239] = -9;
        byArray3[240] = -9;
        byArray3[241] = -9;
        byArray3[242] = -9;
        byArray3[243] = -9;
        byArray3[244] = -9;
        byArray3[245] = -9;
        byArray3[246] = -9;
        byArray3[247] = -9;
        byArray3[248] = -9;
        byArray3[249] = -9;
        byArray3[250] = -9;
        byArray3[251] = -9;
        byArray3[252] = -9;
        byArray3[253] = -9;
        byArray3[254] = -9;
        byArray3[255] = -9;
        byArray3[256] = -9;
        f = byArray3;
    }

    private static final byte[] b(int n2) {
        if ((n2 & 0x10) == 16) {
            return c;
        }
        if ((n2 & 0x20) == 32) {
            return e;
        }
        return a;
    }

    private static final byte[] c(int n2) {
        if ((n2 & 0x10) == 16) {
            return d;
        }
        if ((n2 & 0x20) == 32) {
            return f;
        }
        return b;
    }

    private a() {
    }

    private static byte[] b(byte[] byArray, byte[] byArray2, int n2, int n3) {
        javassist.orgs.java_websocket.util.a.a(byArray2, 0, n2, byArray, 0, n3);
        return byArray;
    }

    private static byte[] a(byte[] byArray, int n2, int n3, byte[] byArray2, int n4, int n5) {
        byte[] byArray3 = javassist.orgs.java_websocket.util.a.b(n5);
        int n6 = (n3 > 0 ? byArray[n2] << 24 >>> 8 : 0) | (n3 > 1 ? byArray[n2 + 1] << 24 >>> 16 : 0) | (n3 > 2 ? byArray[n2 + 2] << 24 >>> 24 : 0);
        switch (n3) {
            case 3: {
                byArray2[n4] = byArray3[n6 >>> 18];
                byArray2[n4 + 1] = byArray3[n6 >>> 12 & 0x3F];
                byArray2[n4 + 2] = byArray3[n6 >>> 6 & 0x3F];
                byArray2[n4 + 3] = byArray3[n6 & 0x3F];
                return byArray2;
            }
            case 2: {
                byArray2[n4] = byArray3[n6 >>> 18];
                byArray2[n4 + 1] = byArray3[n6 >>> 12 & 0x3F];
                byArray2[n4 + 2] = byArray3[n6 >>> 6 & 0x3F];
                byArray2[n4 + 3] = 61;
                return byArray2;
            }
            case 1: {
                byArray2[n4] = byArray3[n6 >>> 18];
                byArray2[n4 + 1] = byArray3[n6 >>> 12 & 0x3F];
                byArray2[n4 + 2] = 61;
                byArray2[n4 + 3] = 61;
                return byArray2;
            }
        }
        return byArray2;
    }

    public static String a(byte[] byArray) {
        String string;
        block3: {
            string = null;
            try {
                string = javassist.orgs.java_websocket.util.a.a(byArray, 0, byArray.length, 0);
            } catch (IOException iOException) {
                if (a) break block3;
                throw new AssertionError((Object)iOException.getMessage());
            }
        }
        assert (string != null);
        return string;
    }

    public static String a(byte[] byArray, int n2, int n3, int n4) {
        byte[] byArray2 = javassist.orgs.java_websocket.util.a.a(byArray, n2, n3, n4);
        try {
            return new String(byArray2, a);
        } catch (UnsupportedEncodingException unsupportedEncodingException) {
            return new String(byArray2);
        }
    }

    public static byte[] a(byte[] byArray, int n2, int n3, int n4) {
        if (byArray == null) {
            throw new IllegalArgumentException("Cannot serialize a null array.");
        }
        if (n2 < 0) {
            throw new IllegalArgumentException("Cannot have negative offset: " + n2);
        }
        if (n3 < 0) {
            throw new IllegalArgumentException("Cannot have length offset: " + n3);
        }
        if (n2 + n3 > byArray.length) {
            throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", n2, n3, byArray.length));
        }
        if ((n4 & 2) != 0) {
            ByteArrayOutputStream byteArrayOutputStream = null;
            DeflaterOutputStream deflaterOutputStream = null;
            b b2 = null;
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                b2 = new b(byteArrayOutputStream, 1 | n4);
                deflaterOutputStream = new GZIPOutputStream(b2);
                ((GZIPOutputStream)deflaterOutputStream).write(byArray, n2, n3);
                deflaterOutputStream.close();
            } finally {
                try {
                    if (deflaterOutputStream != null) {
                        deflaterOutputStream.close();
                    }
                } catch (Exception exception) {}
                try {
                    if (b2 != null) {
                        b2.close();
                    }
                } catch (Exception exception) {}
                try {
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                } catch (Exception exception) {}
            }
            return byteArrayOutputStream.toByteArray();
        }
        boolean bl2 = (n4 & 8) != 0;
        int n5 = n3 / 3 * 4 + (n3 % 3 > 0 ? 4 : 0);
        if (bl2) {
            n5 += n5 / 76;
        }
        byte[] byArray2 = new byte[n5];
        int n6 = 0;
        int n7 = 0;
        int n8 = n3 - 2;
        int n9 = 0;
        while (n6 < n8) {
            javassist.orgs.java_websocket.util.a.a(byArray, n6 + n2, 3, byArray2, n7, n4);
            if (bl2 && (n9 += 4) >= 76) {
                byArray2[n7 + 4] = 10;
                ++n7;
                n9 = 0;
            }
            n6 += 3;
            n7 += 4;
        }
        if (n6 < n3) {
            javassist.orgs.java_websocket.util.a.a(byArray, n6 + n2, n3 - n6, byArray2, n7, n4);
            n7 += 4;
        }
        if (n7 <= byArray2.length - 1) {
            byte[] byArray3 = new byte[n7];
            System.arraycopy(byArray2, 0, byArray3, 0, n7);
            return byArray3;
        }
        return byArray2;
    }

    private static int b(byte[] byArray, int n2, byte[] byArray2, int n3, int n4) {
        if (byArray == null) {
            throw new IllegalArgumentException("Source array was null.");
        }
        if (byArray2 == null) {
            throw new IllegalArgumentException("Destination array was null.");
        }
        if (n2 < 0 || n2 + 3 >= byArray.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", byArray.length, n2));
        }
        if (n3 < 0 || n3 + 2 >= byArray2.length) {
            throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", byArray2.length, n3));
        }
        byte[] byArray3 = javassist.orgs.java_websocket.util.a.c(n4);
        if (byArray[n2 + 2] == 61) {
            int n5 = (byArray3[byArray[n2]] & 0xFF) << 18 | (byArray3[byArray[n2 + 1]] & 0xFF) << 12;
            byArray2[n3] = (byte)(n5 >>> 16);
            return 1;
        }
        if (byArray[n2 + 3] == 61) {
            int n6 = (byArray3[byArray[n2]] & 0xFF) << 18 | (byArray3[byArray[n2 + 1]] & 0xFF) << 12 | (byArray3[byArray[n2 + 2]] & 0xFF) << 6;
            byArray2[n3] = (byte)(n6 >>> 16);
            byArray2[n3 + 1] = (byte)(n6 >>> 8);
            return 2;
        }
        int n7 = (byArray3[byArray[n2]] & 0xFF) << 18 | (byArray3[byArray[n2 + 1]] & 0xFF) << 12 | (byArray3[byArray[n2 + 2]] & 0xFF) << 6 | byArray3[byArray[n2 + 3]] & 0xFF;
        byArray2[n3] = (byte)(n7 >> 16);
        byArray2[n3 + 1] = (byte)(n7 >> 8);
        byArray2[n3 + 2] = (byte)n7;
        return 3;
    }

    static /* synthetic */ byte[] a(int n2) {
        return javassist.orgs.java_websocket.util.a.c(n2);
    }

    static /* synthetic */ byte[] a(byte[] byArray, byte[] byArray2, int n2, int n3) {
        return javassist.orgs.java_websocket.util.a.b(byArray, byArray2, n2, n3);
    }

    static /* synthetic */ int a(byte[] byArray, int n2, byte[] byArray2, int n3, int n4) {
        return javassist.orgs.java_websocket.util.a.b(byArray, n2, byArray2, n3, n4);
    }
}

