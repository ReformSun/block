package com.ideal.block.model.blockDetails;

import com.ideal.block.type.BlockType;

import java.util.ArrayList;
import java.util.List;

public class ListsModel extends BlockModel{
    private int items;
    private List<BlockModel> blockModelList;

    public ListsModel(int items) {
        this.items = items;
        this.setBlockType(BlockType.lISTS_CREATE_WITH);
    }

    public int getItems() {
        return items;
    }

    public List<BlockModel> getBlockModelList() {
        return blockModelList;
    }

    public boolean addBlockModel(BlockModel blockModel){
        if (this.blockModelList == null){
            this.blockModelList = new ArrayList<>();
        }
        return this.blockModelList.add(blockModel);
    }
}
