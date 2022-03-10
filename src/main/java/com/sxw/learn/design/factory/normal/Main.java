package com.sxw.learn.design.factory.normal;

import com.sxw.learn.design.factory.simple.SimpleSmallMovieFactory;
import com.sxw.learn.design.factory.simple.product.CangSmallMovie;
import com.sxw.learn.design.factory.simple.product.SmallMovie;

public class Main {
    public static void main(String[] args) {
        // 工厂模式使用 业务复杂的时候用，也更加符合生活场景，看仓老师去苍老师的发行公司买片，看波老师就去波老师的买片
        SmallMovieFactory movieFactory = new CangSmallMovieFactory();
        SmallMovie movie1 = movieFactory.createMovie();
        movie1.watch();
    }
}
