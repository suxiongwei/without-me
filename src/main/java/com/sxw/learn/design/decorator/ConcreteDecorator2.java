package com.sxw.learn.design.decorator;

public class ConcreteDecorator2 extends Decorator{
    public ConcreteDecorator2(Component component) {
        super(component);
    }

    @Override
    public void operator() {
        method2();
        super.operator();
    }


    // 定义自己的修饰方法
    public void method2(){
        System.out.println("修饰方法 method2");
    }
}
