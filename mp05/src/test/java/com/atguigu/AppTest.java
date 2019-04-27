package com.atguigu;

import static org.junit.Assert.assertTrue;

import com.atguigu.beans.User;
import com.atguigu.mapper.MpMapper;
import com.atguigu.mapper.UserMapper;
import com.baomidou.mybatisplus.annotation.TableField;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
    MpMapper mpMapper=ioc.getBean("mpMapper",MpMapper.class);
    UserMapper userMapper=ioc.getBean("userMapper",UserMapper.class);
    /**
     * 测试自定义全局操作
     */
    @Test
    public void testMySqlInjector(){
        int i = mpMapper.deleteAll();
        System.out.println(i);
    }
    /**
     * 测试逻辑删除
     */
    @Test
    public void testLogicDelete(){
//        int i = userMapper.deleteById(1);
//        System.out.println(i);
        User user = userMapper.selectById(1);
        System.out.println(user);
    }
    /**
     * 测试字段自动填充功能
     */
    @Test
    public void testAutoup(){
        User user = new User();
        user.setLogicFlag(1);
//        user.setName("tom");
        user.setId(6);
        userMapper.updateById(user);
    }
}
