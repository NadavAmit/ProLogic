package com.amitnadav.mywarehousemanager.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Context {
    private HashMap<String,Object> map = new HashMap<String,Object>();
    public Object getValue(String key)
    {
        return map.get(key);
    }
    public void setValue(String key, Object value)
    {
        map.put(key,value);
    }
}
