package fr.dams4k.cpscore.component.position;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class CPositionSerializer implements JsonSerializer<CPosition> {
    public static String X_PATH = "x";
    public static String Y_PATH = "y";
    public static String SIZE_PATH = "size";

    @Override
    public JsonElement serialize(CPosition cPosition, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject object = new JsonObject();
        object.addProperty(X_PATH, cPosition.x);
        object.addProperty(Y_PATH, cPosition.y);
        object.addProperty(SIZE_PATH, cPosition.size);

        return object;
    }
}
