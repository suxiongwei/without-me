package com.sxw.learn;

import com.sxw.learn.annotation.model.User;
import com.sxw.learn.annotation.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2020-08-23 2:01 下午
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CommonRateReflectDecoratorDesignLambdaTest {
    @Autowired
    IUserService userService;

    @Test
    public void testAnnotation(){
        User user = userService.getUserById("su");
    }
}
