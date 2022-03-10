package com.sxw.learn.singleton;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-02-24 5:29 下午
 */
public class SingletonWithoutMe {
    private static volatile SingletonWithoutMe singleton;

    private SingletonWithoutMe(){
    }

    public SingletonWithoutMe getSingleton(){
        if (singleton == null){
            synchronized (SingletonWithoutMe.class){
                if (singleton == null){
                    singleton = new SingletonWithoutMe();
                }
            }
        }
        return singleton;
    }
}
