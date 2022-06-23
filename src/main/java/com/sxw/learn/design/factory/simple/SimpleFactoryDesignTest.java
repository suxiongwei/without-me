package com.sxw.learn.design.factory.simple;

import com.sxw.learn.design.factory.simple.product.CangSmallMovie;
import com.sxw.learn.design.factory.simple.product.SmallMovie;

public class SimpleFactoryDesignTest {
    public static void main(String[] args) {
        // 简单工厂使用
        SmallMovieFactory smallMovieFactory = new SimpleSmallMovieFactory();
        SmallMovie movie = smallMovieFactory.createMovie("波多野结衣老师");
        movie.watch();

        SmallMovie movieNew = smallMovieFactory.createMovieNew(CangSmallMovie.class);
        movieNew.watch();
    }
}
