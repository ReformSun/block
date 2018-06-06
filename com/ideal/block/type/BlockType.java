package com.ideal.block.type;

public enum BlockType {

    INDEX("index"),
    DATEKEY("datekey"),
    STRINGKEY("stringkey"),
    LONGKEY("longkey"),
    lISTS_CREATE_WITH("lists_create_with"),
    SINGLECSCUTTER("singlecscutter"),
    MUTILCSCUTTER("mutilcscutter"),
    SEQUENTIALCSCUTTER("sequentialcscutter"),
    IF_THEN("if_then"),
    DISCARD_DATA("discard_data"),
    IF_ELSE("if_else");



    private String typeName;

    BlockType(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return this.typeName;
    }
}
