package com.sxw.learn.design.factory.simple;

import com.sxw.learn.design.factory.simple.product.CangSmallMovie;
import com.sxw.learn.design.factory.simple.product.BoSmallMovie;
import com.sxw.learn.design.factory.simple.product.SmallMovie;

public class SimpleSmallMovieFactory implements SmallMovieFactory{
    @Override
    public SmallMovie createMovie(String actorName) {
        SmallMovie smallMovie = null;
        if (actorName.equals("苍井空老师")){
            smallMovie = new CangSmallMovie();
        } else if(actorName.equals("波多野结衣老师")){
            smallMovie = new BoSmallMovie();
        }
        return smallMovie;
    }

    // 当然上面的代码也可以通过反射进行优化
    public <T> T createMovieNew(Class<? extends T> clazz) {
        T obj = null;
        try {
            // clazz.getName() com.sxw.learn.design.factory.simple.product.CangSmallMovie
            obj = (T) Class.forName(clazz.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}
