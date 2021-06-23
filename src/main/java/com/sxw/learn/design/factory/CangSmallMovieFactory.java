package com.sxw.learn.design.factory;

import com.sxw.learn.design.factory.product.CangSmallMovie;
import com.sxw.learn.design.factory.product.SmallMovie;

/**
 * 工厂模式
 */
public class CangSmallMovieFactory implements SmallMovieFactory {
    @Override
    public SmallMovie createMovie() {
        return new CangSmallMovie();
    }
}
