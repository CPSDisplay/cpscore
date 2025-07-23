package fr.dams4k.cpscore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CPSCore {
    public void testGson() {
        final GsonBuilder builder = new GsonBuilder();
        final Gson gson = builder.create();
        System.out.println(gson.toJson(1));
    }

    public String getGsonValue() {
        final GsonBuilder builder = new GsonBuilder();
        final Gson gson = builder.create();
        return gson.toJson(new String[] {"hello", "world", "gson"});
    }
}
