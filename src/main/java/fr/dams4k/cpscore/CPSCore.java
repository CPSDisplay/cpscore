package fr.dams4k.cpscore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.dams4k.cpscore.component.Component;
import fr.dams4k.cpscore.component.ComponentDeserializer;
import fr.dams4k.cpscore.component.ComponentSerializer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;

public class CPSCore {
    public static Path MOD_FOLDER;

    public static void init(Path modFolder) {
        CPSCore.MOD_FOLDER = modFolder;
    }

    public static void main(String [] args) throws IOException {
        Gson gson = getGson();

//        Component component = gson.fromJson(new FileReader("./0.json"), Component.class);
//        System.out.println(component.text);
        Component component = new Component();

        Writer writer = new FileWriter("./0.json");
        gson.toJson(component, writer);
        writer.flush();
        writer.close();
    }

    public static GsonBuilder setupBuilder(GsonBuilder builder) {
        builder.setPrettyPrinting();
//        builder.registerTypeAdapter(Component.class, new ComponentSerializer());
//        builder.registerTypeAdapter(Component.class, new ComponentDeserializer());
        return builder;
    }

    public static Gson getGson() {
        return setupBuilder(new GsonBuilder()).create();
    }
}
