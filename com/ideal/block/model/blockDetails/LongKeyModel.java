package com.ideal.block.model.blockDetails;

import com.ideal.block.type.BlockType;

public class LongKeyModel extends BlockModel implements KeyModel{
    private String key;

    public LongKeyModel(String key) {
        this.key = key;
        this.setBlockType(BlockType.LONGKEY);
    }

    public String getKey() {
        return key;
    }

}
