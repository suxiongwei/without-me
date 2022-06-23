package com.sxw.learn.design.decorator;

public class ConcreteComponent extends Component{
    @Override
    public void operator() {
        System.out.println("doSomething");
    }
}
