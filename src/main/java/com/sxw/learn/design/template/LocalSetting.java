package com.sxw.learn.design.template;

public class LocalSetting extends AbstractSetting{
    @Override
    protected String lookupCache(String key) {
        return "lookupCache value:1";
    }

    @Override
    protected void putIntoCache(String key, String value) {

    }

//    public String getSetting(String key) {
//        return "LocalSetting getSetting:" + key;
//    }
}
