package com.sxw.learn.spring.common;

public class Woman {
    private String name = "the woman";

    private Child child;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }
}
