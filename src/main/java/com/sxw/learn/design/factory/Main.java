package com.sxw.learn.design.factory;

import com.sxw.learn.design.factory.product.SmallMovie;
import com.sxw.learn.design.factory.simple.SimpleSmallMovieFactory;

public class Main {
    public static void main(String[] args) {
        // 简单工厂使用
        com.sxw.learn.design.factory.simple.SmallMovieFactory smallMovieFactory = new SimpleSmallMovieFactory();
        SmallMovie movie = smallMovieFactory.createMovie("波多野结衣老师");
        movie.watch();

        // 工厂模式使用 业务复杂的时候用，也更加符合生活场景，看仓老师去苍老师的发行公司买片，看波老师就去波老师的买片
        SmallMovieFactory movieFactory = new CangSmallMovieFactory();
        SmallMovie movie1 = movieFactory.createMovie();
        movie1.watch();
    }
}
