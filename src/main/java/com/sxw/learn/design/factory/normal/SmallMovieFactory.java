package com.sxw.learn.design.factory.normal;

import com.sxw.learn.design.factory.simple.product.SmallMovie;

/**
 * 工厂模式
 * 业务复杂的时候用，也更加符合生活场景，看仓老师去苍老师的发行公司买片，看波老师就去波老师发行厂商买片
 * 符合单一原则，开闭原则，来了新业务 就再加一个新的工厂类
 */
public interface SmallMovieFactory {
    SmallMovie createMovie();
}
