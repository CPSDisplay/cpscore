package fr.dams4k.cpscore;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class ComponentSerializer implements JsonSerializer<Component> {
    public static final String TEXT_PATH = "text";

    @Override
    public JsonElement serialize(Component component, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject object = new JsonObject();
        object.addProperty(TEXT_PATH, component.text);

        return object;
    }
}
