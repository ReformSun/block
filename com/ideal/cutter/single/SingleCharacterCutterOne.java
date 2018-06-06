package com.ideal.cutter.single;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ideal.block.model.blockDetails.BlockModel;
import com.ideal.block.model.blockDetails.KeyModel;
import com.ideal.block.model.blockDetails.SingleCharacterModel;
import com.ideal.block.model.gsonDes.BlockModelDes;
import com.ideal.block.model.gsonDes.KeyModelDes;
import com.ideal.model.StreamModel;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;


/**
 * 不需要对数据进行二次处理的情况
 */
public class SingleCharacterCutterOne implements FlatMapFunction<String,StreamModel> {
    private SingleCharacterModel singleCharacterModel;

    public SingleCharacterCutterOne(String jsonString) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(BlockModel.class,new BlockModelDes());
        gsonBuilder.registerTypeAdapter(KeyModel.class, new KeyModelDes());
        Gson gson = gsonBuilder.create();
        this.singleCharacterModel = gson.fromJson(jsonString,SingleCharacterModel.class);
    }

    @Override
    public void flatMap(String s, Collector<StreamModel> collector) throws Exception {

    }
}
