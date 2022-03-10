package com.sxw.learn.design.factory.simple;

import com.sxw.learn.design.factory.normal.CangSmallMovieFactory;
import com.sxw.learn.design.factory.normal.SmallMovieFactory;
import com.sxw.learn.design.factory.simple.product.CangSmallMovie;
import com.sxw.learn.design.factory.simple.product.SmallMovie;
import com.sxw.learn.design.factory.simple.SimpleSmallMovieFactory;

public class Main {
    public static void main(String[] args) {
        // 简单工厂使用
        com.sxw.learn.design.factory.simple.SmallMovieFactory smallMovieFactory = new SimpleSmallMovieFactory();
        SmallMovie movie = smallMovieFactory.createMovie("波多野结衣老师");
        movie.watch();

        SmallMovie movieNew = smallMovieFactory.createMovieNew(CangSmallMovie.class);
        movieNew.watch();
    }
}
