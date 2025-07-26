package fr.dams4k.cpscore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.dams4k.cpscore.component.Component;
import fr.dams4k.cpscore.descript.Descript;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

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
            public Integer getFPS() {
                return 0;
            }

            @Override
            public Integer getClicks(int keycode) {
                return 0;
            }

            @Override
            public Integer getBPS() {
                return 0;
            }

            @Override
            public Integer getAttack() {
                return 0;
            }

            @Override
            public Integer getUseItem() {
                return 0;
            }
        });
        ComponentManager.load();

        Component component = new Component();
        component.setName("cps");
        ComponentManager.saveComponent(component);

//        String source = "{$attack:true=\"pressed\"}";
//        String source = "{$attack:true=[text:\"key is pressed\"; textColor:\"ffffff\"; backgroundColor:\"ffffff\"]; false=[text:\"key is not pressed\"; textColor:\"ffff00\"; backgroundColor:\"ff00ff\"]}";
//        System.out.println(Tokenizer.tokenize(source));
        String simpleSource = "{$useItem:true=[text:\"pressed\"]:false=[text:\"unpressed\"]:15=[text:\"Overstressed!!!\"]}";

        System.out.println(Descript.parse(simpleSource));

    }

    public static GsonBuilder setupBuilder(GsonBuilder builder) {
        builder.setPrettyPrinting();
        return builder;
    }

    public static Gson getGson() {
        return setupBuilder(new GsonBuilder()).create();
    }
}
