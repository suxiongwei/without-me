package com.sxw.learn.design.template;

public class Main {
    public static void main(String[] args) {
        AbstractSetting setting = new LocalSetting();
        System.out.println("test = " + setting.getSetting("test"));
    }
}
