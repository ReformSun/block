package com.ideal.block.model.gsonDes;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.ideal.block.model.blockDetails.DateKeyModel;
import com.ideal.block.model.blockDetails.KeyModel;
import com.ideal.block.model.blockDetails.LongKeyModel;
import com.ideal.block.model.blockDetails.StringKeyModel;

import java.lang.reflect.Type;

public class KeyModelDes implements JsonDeserializer<KeyModel> {
    @Override
    public KeyModel deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        if (jsonElement.getAsJsonObject().get("blockType").getAsString().equals("STRINGKEY")){
            return new StringKeyModel(jsonElement.getAsJsonObject().get("key").toString());
        }else if (jsonElement.getAsJsonObject().get("blockType").getAsString().equals("DATEKEY")){
            DateKeyModel dateKeyModel = new DateKeyModel();
            dateKeyModel.setKey(jsonElement.getAsJsonObject().get("key").getAsString());
            dateKeyModel.setDateType(jsonElement.getAsJsonObject().get("dateType").getAsString());
            return new DateKeyModel();
        }else if (jsonElement.getAsJsonObject().get("blockType").getAsString().equals("LONGKEY")){
            LongKeyModel longKeyModel = new LongKeyModel(jsonElement.getAsJsonObject().get("key").getAsString());
            return longKeyModel;
        }
        return null;

    }
}
