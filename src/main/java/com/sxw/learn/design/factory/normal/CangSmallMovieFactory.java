package com.sxw.learn.design.factory.normal;

import com.sxw.learn.design.factory.simple.product.CangSmallMovie;
import com.sxw.learn.design.factory.simple.product.SmallMovie;

/**
 * 工厂模式
 */
public class CangSmallMovieFactory implements SmallMovieFactory {
    @Override
    public SmallMovie createMovie() {
        return new CangSmallMovie();
    }
}
