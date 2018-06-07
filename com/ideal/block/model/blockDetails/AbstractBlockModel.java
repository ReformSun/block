package com.ideal.block.model.blockDetails;

import com.ideal.block.type.BlockType;
import java.io.Serializable;

public abstract class AbstractBlockModel implements BlockModel,Serializable {
    private BlockType blockType;
    @Override
    public BlockType getBlockType() {
        return blockType;
    }

    @Override
    public void setBlockType(BlockType blockType) {
        this.blockType = blockType;
    }
}
