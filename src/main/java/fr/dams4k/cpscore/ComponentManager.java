package fr.dams4k.cpscore;

import com.google.gson.Gson;
import fr.dams4k.cpscore.component.Component;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ComponentManager {
    public static final String COMPONENTS_SUBFOLDER = "components";
    public static final List<Component> components = new ArrayList<>();

    public static Gson gson;

    public static void load() {
        gson = CPSCore.getGson();

        File componentsFolder = folderPath().toFile();
        File[] componentFiles = componentsFolder.listFiles(pathname -> pathname.isFile() && pathname.getName().endsWith(".json") && pathname.canRead());
        if (componentFiles == null) return;

        for (File componentFile : componentFiles) {
            if (componentFile == null) continue;

            try {
                FileReader reader = new FileReader(componentFile);
                Component component = gson.fromJson(reader, Component.class);
                if (component != null) {
                    components.add(component);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static void saveComponent(Component component) {
        String filename = String.format("%s.json", component.getName());
        Path filepath = folderPath().resolve(filename);

        Writer writer;
        try {
            Files.createDirectories(filepath.getParent());

            writer = new FileWriter(filepath.toString());
            gson.toJson(component, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Path folderPath() {
        return CPSCore.MOD_FOLDER.resolve(COMPONENTS_SUBFOLDER);
    }
}
