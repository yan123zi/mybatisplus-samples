package com.atguigu;

import static org.junit.Assert.assertTrue;

import com.atguigu.beans.Mp;
import com.atguigu.mapper.MpMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.velocity.shaded.commons.io.IOCase;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
    MpMapper mpMapper=ioc.getBean("mpMapper",MpMapper.class);

    /**
     * 测试分页插件
     */
    @Test
    public void testPage(){
        IPage<Mp> mpIPage = mpMapper.selectPage(new Page<>(1, 2), null);
        System.out.println(mpIPage.getRecords());
    }
    /**
     * 测试sql执行分析插件
     */
    @Test
    public void testSQLExplain(){
        mpMapper.delete(null);//全表删除操作
    }
    /**
     * 测试性能分析插件
     */
    @Test
    public void testPerform(){
        Mp mp = new Mp();
        mp.setAge(30);
        mp.setEmail("5498789@fef.com");
        mp.setGender("1");
        mp.setLastName("ffwef");
        mpMapper.insert(mp);
    }
    /**
     * 测试乐观锁
     */
    @Test
    public void testOptimisticLocker(){
        //更新操作
        Mp mp = new Mp();
        mp.setId(3);
        mp.setLastName("Jack1");
        mp.setEmail("98f9weg@qq.com");
        mp.setAge(22);
        mp.setVersion(2);
        mpMapper.updateById(mp);
    }
}
