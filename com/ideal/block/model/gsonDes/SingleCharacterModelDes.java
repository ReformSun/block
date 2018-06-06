package com.ideal.block.model.gsonDes;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.ideal.block.model.blockDetails.SingleCharacterModel;

import java.lang.reflect.Type;

public class SingleCharacterModelDes implements JsonDeserializer<SingleCharacterModel> {
    @Override
    public SingleCharacterModel deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return null;
    }
}
