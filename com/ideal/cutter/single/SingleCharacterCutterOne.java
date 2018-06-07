package com.ideal.cutter.single;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ideal.block.model.blockDetails.*;
import com.ideal.block.model.gsonDes.BlockModelDes;
import com.ideal.block.model.gsonDes.KeyModelDes;
import com.ideal.block.type.BlockType;
import com.ideal.model.StreamModel;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SingleCharacterCutterOne implements FlatMapFunction<String,StreamModel> {
    private static String regEx = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
    private static Pattern specialCpattern = Pattern.compile(regEx);
    private SingleCharacterModel singleCharacterModel;
    private Pattern pattern;
    private Map<Integer,KeyModel> modelMap;

    public Map<Integer, KeyModel> getModelMap() {
        if (singleCharacterModel == null){
            return null;
        }else {
            if (modelMap == null){
                modelMap = new HashMap<>();
                BlockModel blockModel = singleCharacterModel.getBlockModel();
                if (blockModel.getBlockType() == BlockType.lISTS_CREATE_WITH){
                    ListsModel listsModel = (ListsModel)blockModel;
                    List<BlockModel> lists = listsModel.getBlockModelList();
                    Iterator<BlockModel> iterator = lists.iterator();
                    while (iterator.hasNext()){
                        BlockModel blockModel1 = iterator.next();
                        if (blockModel1.getBlockType() == BlockType.INDEX){
                            IndexModel indexModel = (IndexModel) blockModel1;
                            modelMap.put(indexModel.getIndex(),indexModel.getKeyModel());
                        }
                    }
                }
            }else {
                return modelMap;
            }
        }
        return modelMap;
    }


    public SingleCharacterCutterOne(String jsonString) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(BlockModel.class,new BlockModelDes());
        gsonBuilder.registerTypeAdapter(KeyModel.class, new KeyModelDes());
        Gson gson = gsonBuilder.create();
        this.singleCharacterModel = gson.fromJson(jsonString,SingleCharacterModel.class);
    }

    @Override
    public void flatMap(String s, Collector<StreamModel> collector) throws Exception {


        if (singleCharacterModel != null){
            StreamModel streamModel = new StreamModel();
            if (singleCharacterModel.getKeyModel() != null){
                KeyModel keyModel = singleCharacterModel.getKeyModel();
                if (keyModel != null){
                    if (keyModel.getBlockType() == BlockType.STRINGKEY ||
                            keyModel.getBlockType() == BlockType.LONGKEY){
                        streamModel.setKey(keyModel.getKey());
                    }else {
                        streamModel.setKey("_line");
                    }
                }else {
                    streamModel.setKey("_line");
                }

            }


            if (singleCharacterModel.isRegular()){

            }else {
                String separatorS = singleCharacterModel.getSingleCharacter();
                if (separatorS.length() != 1 && !specialCpattern.matcher(separatorS).find()){
                    System.out.println("积木块转代码编写错误,应选择多字符切分器");
                }else {
                    if (pattern == null){
                        StringBuilder stringBuilder = new StringBuilder("[\\w\\s]*");
                        if (specialCpattern.matcher(separatorS).find()){
                            stringBuilder.append("\\");
                        }
                        stringBuilder.append( separatorS + "{1}");
                        pattern = Pattern.compile(stringBuilder.toString());


                    }
                    Matcher matcher = pattern.matcher(s);
                    if (this.getModelMap() != null){
                        for (int i = 0; i < this.getModelMap().size() - 1; i++) {
                            String value = "";
                            if (matcher.find()){

                                value = matcher.group();
                                KeyModel keymodel = this.getModelMap().get(i);
                                if (value.length() == separatorS.length()){
                                    value = "";
                                }else {
                                    value = value.substring(0,value.length() - separatorS.length());
                                }

                                streamModel.add(keymodel.getKey(),this.getStringToValue
                                        (keymodel,value));
                            }
                        }

                        String value = s.substring(matcher.end(),s.length());
                        KeyModel keyModel = this.getModelMap().get(this.getModelMap().size() - 1);
                        streamModel.add(keyModel.getKey(),this.getStringToValue(keyModel,value));

                        collector.collect(streamModel);
                    }else {
                        System.out.println("切分器参数有问题，无法进行正常切分");
                    }
                }

            }
        }else {
            System.out.println("单子符切分器没有切分参数，无法实现切分");
        }
    }


    private Object getStringToValue(KeyModel keyModel,String value){

        if (keyModel.getBlockType() == BlockType.STRINGKEY){
            return value;
        }else if (keyModel.getBlockType() == BlockType.LONGKEY){
            return Long.valueOf(value);
        }else if (keyModel.getBlockType() == BlockType.DATEKEY){
            DateKeyModel dateKeyModel = (DateKeyModel)keyModel;
            if (dateKeyModel.getDateType() != null){
                String format = dateKeyModel.getDateType();
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                if (value.length() == 15){
                    return sdf.format(new Date(Long.valueOf(value + "000")));
                }else if (value.length() == 18){
                    return sdf.format(new Date(Long.valueOf(value)));
                }else {
                    return value;
                }

            }
        }

        return "";
    }


}
