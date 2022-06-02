package com.sxw.learn.design.factory.decorator;

public class ConcreteComponent extends Component{
    @Override
    public void operator() {
        System.out.println("doSomething");
    }
}
