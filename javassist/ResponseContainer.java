/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 */
package javassist;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;
import javassist.ab;
import javassist.ac;

public final class ResponseContainer {
    private static final Gson gson = new GsonBuilder().serializeNulls().create();
    private static final Type rtoken = new ab().getType();
    private static final Type ptoken = new ac().getType();
    private String type;
    private String json;

    public ResponseContainer(String string, String string2) {
        this.type = string;
        this.json = string2;
    }

    public String getType() {
        return this.type;
    }

    public String getJson() {
        return this.json;
    }

    public static final String from(String string, Object object) {
        return gson.toJson((Object)new ResponseContainer(string, gson.toJson(object, ptoken)), rtoken);
    }
}

