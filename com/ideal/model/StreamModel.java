package com.ideal.model;

import java.util.HashMap;
import java.util.Map;

public class StreamModel {
    private String key;
    private Map<String,Object> map;


    public boolean add(String key,Object value){
        if (map == null){
            this.map = new HashMap<>();
        }

        this.map.put(key,value);

        return true;
    }


    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public Object getValue(String key){
        if (this.map != null){
            return this.map.get(key);
        }

        return null;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
