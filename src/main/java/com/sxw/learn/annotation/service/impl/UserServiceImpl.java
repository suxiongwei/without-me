package com.sxw.learn.annotation.service.impl;

import com.sxw.learn.annotation.DoSomething;
import com.sxw.learn.annotation.model.User;
import com.sxw.learn.annotation.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2020-08-23 1:24 下午
 */
@Service
public class UserServiceImpl implements IUserService {

    @Override
    @DoSomething(key = "#id", cacheName = "redis-user", needLog = true)
    public User getUserById(String id) {
        System.out.println("==============进入getUserById方法===============");
        // 集成了缓存、日志等功能，但是单一职责原则和迪米特法则，需要优化，因此可以使用自定义注解进行优化
        // 1、从缓存中获取用户

        // 2、记录日志

        // 3、业务功能真正的逻辑代码
        User user = getUserFromDB(id);
        return user;
    }

    /**
     * 模仿从DB查询用户数据
     * @param id
     * @return
     */
    private User getUserFromDB(String id) {
        return User.builder()
                .id(id)
                .name(id + "-name")
                .build();
    }
}
