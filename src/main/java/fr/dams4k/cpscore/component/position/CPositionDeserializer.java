package fr.dams4k.cpscore.component.position;

import com.google.gson.*;

import java.lang.reflect.Type;

public class CPositionDeserializer implements JsonDeserializer<CPosition> {
    @Override
    public CPosition deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject object = jsonElement.getAsJsonObject();
        return new CPosition(object.get(CPositionSerializer.X_PATH).getAsInt(), object.get(CPositionSerializer.Y_PATH).getAsInt(), object.get(CPositionSerializer.SIZE_PATH).getAsFloat());
    }
}
