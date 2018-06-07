package com.ideal.block.model.blockDetails;

import com.ideal.block.type.BlockType;

import java.util.ArrayList;
import java.util.List;

public class IfElseModel extends AbstractBlockModel {
    private List<ConditionsModel> judgeConditions;
    private List<String> logicalOperators;

    public IfElseModel() {
        this.setBlockType(BlockType.IF_ELSE);
    }

    public boolean addCondition(ConditionsModel conditionsModel){
        if (this.judgeConditions == null){
            this.judgeConditions = new ArrayList<>();
        }
        return this.judgeConditions.add(conditionsModel);
    }

    public boolean addlogicalOperators(String logicalOperators){

        if (this.logicalOperators == null){
            this.logicalOperators = new ArrayList<>();
        }
        return this.logicalOperators.add(logicalOperators);
    }

    public List<ConditionsModel> getJudgeConditions() {
        return judgeConditions;
    }

    public List<String> getLogicalOperators() {
        return logicalOperators;
    }
}
