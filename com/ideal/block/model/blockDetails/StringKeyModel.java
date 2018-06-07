package com.ideal.block.model.blockDetails;

import com.ideal.block.type.BlockType;

public class StringKeyModel extends AbstractBlockModel implements KeyModel{
    private String key;

    public StringKeyModel(String key) {
        this.key = key;
        this.setBlockType(BlockType.STRINGKEY);
    }
    @Override
    public String getKey() {
        return key;
    }
}
