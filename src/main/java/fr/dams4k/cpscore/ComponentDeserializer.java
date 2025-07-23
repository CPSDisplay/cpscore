package fr.dams4k.cpscore;

import com.google.gson.*;

import java.lang.reflect.Type;

public class ComponentDeserializer implements JsonDeserializer<Component> {
    @Override
    public Component deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject object = jsonElement.getAsJsonObject();

        Component component = new Component();
        component.text = object.get(ComponentSerializer.TEXT_PATH).getAsString();

        return component;
    }
}
