package com.sxw.learn.design.factory.product;

public class CangSmallMovie implements SmallMovie{
    @Override
    public void watch() {
        System.out.println("苍井空老师 为你表演");
    }
}
