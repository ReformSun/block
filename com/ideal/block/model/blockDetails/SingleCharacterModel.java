package com.ideal.block.model.blockDetails;

import com.ideal.block.type.BlockType;

public class SingleCharacterModel extends BlockModel{
    private String singleCharacter;
    private boolean isRegular;
    private KeyModel keyModel;
    private BlockModel blockModel;

    public SingleCharacterModel() {
        this.setBlockType(BlockType.SINGLECSCUTTER);
    }

    public String getSingleCharacter() {
        return singleCharacter;
    }

    public void setSingleCharacter(String singleCharacter) {
        this.singleCharacter = singleCharacter;
    }

    public boolean isRegular() {
        return isRegular;
    }

    public void setRegular(boolean regular) {
        isRegular = regular;
    }

    public KeyModel getKeyModel() {
        return keyModel;
    }

    public void setKeyModel(KeyModel keyModel) {
        this.keyModel = keyModel;
    }

    public BlockModel getBlockModel() {
        return blockModel;
    }

    public void setBlockModel(BlockModel blockModel) {
        this.blockModel = blockModel;
    }
}
