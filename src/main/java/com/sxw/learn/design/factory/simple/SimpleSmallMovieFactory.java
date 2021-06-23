package com.sxw.learn.design.factory.simple;

import com.sxw.learn.design.factory.product.CangSmallMovie;
import com.sxw.learn.design.factory.product.BoSmallMovie;
import com.sxw.learn.design.factory.product.SmallMovie;

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
}
