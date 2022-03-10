package com.sxw.learn.design.factory.simple;

import com.sxw.learn.design.factory.simple.product.SmallMovie;

/**
 * 简单工厂
 * 优点：客户端免除了创建对象的责任，而仅仅负责调用，解藕
 * 缺点：不符合单一原则 开闭原则
 */
public interface SmallMovieFactory {
    SmallMovie createMovie(String actorName);

    /**
     * 反射的方式创建对象
     * @param clazz
     * @param <T>
     * @return
     */
    <T> T createMovieNew(Class<? extends T> clazz);
}
