package com.sxw.learn.design.factory.simple.product;

public class CangSmallMovie implements SmallMovie{
    @Override
    public void watch() {
        System.out.println("苍井空老师 为你表演");
    }
}
