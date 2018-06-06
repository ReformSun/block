package com.ideal.block.model.blockDetails;

import com.ideal.block.type.BlockType;

public class DateKeyModel extends BlockModel implements KeyModel{
    private String key;
    private String dateType;

    public DateKeyModel() {
        this.setBlockType(BlockType.DATEKEY);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDateType() {
        return dateType;
    }

    public void setDateType(String dateType) {
        this.dateType = dateType;
    }
}
