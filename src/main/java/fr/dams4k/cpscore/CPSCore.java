package fr.dams4k.cpscore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;

public class CPSCore {
    public static Path modFolder;

    public static void init(Path modFolder) {
        CPSCore.modFolder = modFolder;
    }

    public static void main(String [] args) throws IOException {
        Gson gson = getGson();

        Component component = new Component();
        component.text = "[{0} | {1}] CPS";

        Writer writer = new FileWriter("./0.json");
        gson.toJson(component, writer);
        writer.flush();
        writer.close();
    }

    public static Gson getGson() {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        builder.registerTypeAdapter(Component.class, new ComponentSerializer());
        builder.registerTypeAdapter(Component.class, new ComponentDeserializer());

        return builder.create();
    }
}
