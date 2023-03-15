package com.sxw.learn.design.template;

public abstract class AbstractSetting {
    public String getSetting(String key) {
        String value = lookupCache(key);
        if (value == null) {
            value = readFromDatabase(key);
            putIntoCache(key, value);
        }
        return value;
    }

    protected abstract String lookupCache(String key);

    protected abstract void putIntoCache(String key, String value);

    private String readFromDatabase(String key) {
        // TODO: 从数据库读取
        return "数据库读取的值";
    }
}
