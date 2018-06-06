package com.ideal.block.model.blockDetails;

import com.ideal.block.type.BlockType;

import java.io.Serializable;

public abstract class BlockModel implements Serializable{
    private BlockType blockType;

    public BlockType getBlockType() {
        return blockType;
    }

    public void setBlockType(BlockType blockType) {
        this.blockType = blockType;
    }
}
