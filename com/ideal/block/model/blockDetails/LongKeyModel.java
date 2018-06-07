package com.ideal.block.model.blockDetails;

import com.ideal.block.type.BlockType;

public class LongKeyModel extends AbstractBlockModel implements KeyModel{
    private String key;

    public LongKeyModel(String key) {
        this.key = key;
        this.setBlockType(BlockType.LONGKEY);
    }

    @Override
    public String getKey() {
        return key;
    }

}
