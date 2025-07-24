package fr.dams4k.cpscore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.dams4k.cpscore.component.Component;
import fr.dams4k.cpscore.descript.lexer.Token;
import fr.dams4k.cpscore.descript.lexer.TokenType;
import fr.dams4k.cpscore.descript.lexer.Tokenizer;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;

public class CPSCore {
    public static Path MOD_FOLDER;
    public static ComponentInterface INTERFACE;

    public static void init(Path modFolder, ComponentInterface componentInterface) {
        CPSCore.MOD_FOLDER = modFolder;
        CPSCore.INTERFACE = componentInterface;
    }

    public static void main(String [] args) throws IOException {
        init(Paths.get("."), new ComponentInterface() {
            @Override
            public int getFPS() {
                return 0;
            }

            @Override
            public int getClicks(int keycode) {
                return 0;
            }

            @Override
            public int getBPS() {
                return 0;
            }
        });
        ComponentManager.load();

        Component component = new Component();
        component.setName("cps");
        ComponentManager.saveComponent(component);

        String source = "{$attack:true=\"pressed\"}";
        System.out.println(Tokenizer.tokenize(source));
    }

    public static GsonBuilder setupBuilder(GsonBuilder builder) {
        builder.setPrettyPrinting();
        return builder;
    }

    public static Gson getGson() {
        return setupBuilder(new GsonBuilder()).create();
    }
}
