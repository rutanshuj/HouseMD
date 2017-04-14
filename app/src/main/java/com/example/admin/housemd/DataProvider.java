package com.example.admin.housemd;

/**
 * Created by Adm on 14-Apr-17.
 */

public class DataProvider {

    public DataProvider(String attribute, String value) {
        this.setAttribute(attribute);
        this.setValue(value);
    }

    String attribute,value;

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}