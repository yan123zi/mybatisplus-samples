package com.atguigu;

import static org.junit.Assert.assertTrue;

import com.atguigu.bean.Employee;
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
    private ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
    /**
     * AR插入操作
     */
    @Test
    public void testARInsert(){
        Employee employee = new Employee();
        employee.setLastName("fewfr");
        employee.setEmail("fweftgwerg@qq.com");
        employee.setGender(1);
        employee.setAge(20);
        employee.insert();
    }
    /**
     * AR修改操作
     */
    @Test
    public void testARUpdate(){
        Employee employee = new Employee();
        employee.setId(34);
        employee.setLastName("abc");
        employee.setGender(0);
        boolean b = employee.updateById();
        System.out.println(b);
    }
    /**
     * AR查询操作
     */
    @Test
    public void testARSelect(){
        Employee employee = new Employee();
        Employee employee1 = employee.selectById(34);
        System.out.println(employee1);
    }
}
