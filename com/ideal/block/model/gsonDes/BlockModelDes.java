package com.ideal.block.model.gsonDes;

import com.google.gson.*;
import com.ideal.block.model.blockDetails.*;


import java.lang.reflect.Type;
import java.util.Iterator;

public class BlockModelDes implements JsonDeserializer<BlockModel> {
    @Override
    public BlockModel deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        if (jsonElement.getAsJsonObject().get("blockType").getAsString().equals
                ("LISTS_CREATE_WITH")){
            ListsModel listsModel = new ListsModel(jsonElement.getAsJsonObject().get("items").getAsInt());
            JsonArray s = jsonElement.getAsJsonObject().get("blockModelList").getAsJsonArray();
            Iterator<JsonElement> iterator = s.iterator();
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(KeyModel.class,new KeyModelDes());
            Gson gson = gsonBuilder.create();

            while (iterator.hasNext()){
                JsonElement jsonElement1 = iterator.next();
                IndexModel indexModel = gson.fromJson(jsonElement1, IndexModel.class);
                listsModel.addBlockModel(indexModel);
            }

            return listsModel;
        }
        return null;
    }
}
