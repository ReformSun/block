package com.ideal.block.model.blockDetails;

import com.ideal.block.type.BlockType;

public class StringKeyModel extends BlockModel implements KeyModel{
    private String key;

    public StringKeyModel(String key) {
        this.key = key;
        this.setBlockType(BlockType.STRINGKEY);
    }

    public String getKey() {
        return key;
    }
}
