package com.sxw.learn.reflect;

import lombok.Data;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-01-29 4:59 下午
 */
@Data
public class Person {
    private String userName = "Tom";

    private void playGame() {
        System.out.println(userName+ "悄悄玩儿游戏");
    }

}
