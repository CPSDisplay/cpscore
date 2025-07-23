package fr.dams4k.cpscore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.dams4k.cpscore.component.Component;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CPSCore {
    public static Path MOD_FOLDER;

    public static void init(Path modFolder) {
        CPSCore.MOD_FOLDER = modFolder;
    }

    public static void main(String [] args) throws IOException {
        init(Paths.get("."));
        ComponentManager.load();


        Component component = new Component();
        component.setName("cps");
        ComponentManager.saveComponent(component);
    }

    public static GsonBuilder setupBuilder(GsonBuilder builder) {
        builder.setPrettyPrinting();
        return builder;
    }

    public static Gson getGson() {
        return setupBuilder(new GsonBuilder()).create();
    }
}
