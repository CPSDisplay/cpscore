package fr.dams4k.cpscore.component;

import com.google.gson.*;
import fr.dams4k.cpscore.CPSCore;

import java.lang.reflect.Type;

public class ComponentSerializer implements JsonSerializer<Component> {
    public static final String TEXT_PATH = "text";

    @Override
    public JsonElement serialize(Component component, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject object = new JsonObject();
//        object.add

        return object;
    }
}
