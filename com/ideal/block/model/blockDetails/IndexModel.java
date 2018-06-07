package com.ideal.block.model.blockDetails;

import com.ideal.block.type.BlockType;

public class IndexModel extends AbstractBlockModel{
    private  int index;
    private  KeyModel keyModel;


    public IndexModel() {
        this.setBlockType(BlockType.INDEX);
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public KeyModel getKeyModel() {
        return keyModel;
    }

    public void setKeyModel(KeyModel keyModel) {
        this.keyModel = keyModel;
    }
}
