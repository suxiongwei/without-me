package com.sxw.learn.design.decorator;

public class ConcreteDecorator1 extends Decorator{
    public ConcreteDecorator1(Component component) {
        super(component);
    }

    @Override
    public void operator() {
        method1();
        super.operator();
    }


    // 定义自己的修饰方法
    public void method1(){
        System.out.println("修饰方法 method1");
    }
}
