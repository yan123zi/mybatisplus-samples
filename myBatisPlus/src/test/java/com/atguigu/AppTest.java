package com.atguigu;

import static org.junit.Assert.assertTrue;

import com.atguigu.bean.Employee;
import com.atguigu.mapper.EmployeeMapper;
import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.kotlin.AbstractKtWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Condition;

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
    private EmployeeMapper employeeMapper=ioc.getBean("employeeMapper",EmployeeMapper.class);
    /**
     * 通用插入操作
     */
    @Test
    public void testCommonInsert(){
        Employee employee=new Employee();
        employee.setLastName("yan");
//        employee.setAge(20);
//        employee.setGender(1);
        employee.setEmail("6579879879@qq.com");
        employee.setSalary(20000.0);
        //insert在插入时，会根据实体类的每个属性进行非空判断，只有非空的属性对应的字段才会出现到SQL语句中
        int i = employeeMapper.insert(employee);
//        employeeMapper.
        //获取当前时间在数据库中的主键值
        System.out.println(i);
        System.out.println("key:"+employee.getId());
    }
    /**
     * 通用更新操作
     */
    @Test
    public void testCommonUpdate(){
        Employee employee = new Employee();
        employee.setId(27);
        employee.setLastName("zijiang");
        employee.setEmail("8787987@qq.com");
        employee.setGender(1);
        employeeMapper.updateById(employee);
    }
    /**
     * 通用的查询操作
     */
    @Test
    public void testCommonSelect(){
        //通过id查询
        Employee employee = employeeMapper.selectById(3);
        System.out.println(employee);
        //通过多个列进行查询


//        Employee employee = employeeMapper.selectOne(new Wrapper<Employee>() {
//            @Override
//            public Employee getEntity() {
//                Employee employee = new Employee();
//                employee.setLastName("White");
//                return employee;
//            }
//
//            @Override
//            public MergeSegments getExpression() {
//                return null;
//            }
//
//            @Override
//            public String getCustomSqlSegment() {
//                return null;
//            }
//
//            @Override
//            public String getSqlSegment() {
//                return null;
//            }
//        });
//        System.out.println(employee);
        //通过多个id进行查询
//        ArrayList<Integer> idlist = new ArrayList<>();
//        idlist.add(26);
//        idlist.add(27);
//        idlist.add(28);
//        idlist.add(29);
//        List<Employee> employees = employeeMapper.selectBatchIds(idlist);
//        System.out.println(employees);
        //通过Map封装条件查询
//        Map<String,Object> columnMap=new HashMap<>();
//        columnMap.put("last_name","yan");
//        List<Employee> employees = employeeMapper.selectByMap(columnMap);
//        System.out.println(employees);
        //分页查询
//        IPage<Employee> employeeIPage = employeeMapper.selectPage(new Page<>(1,2), null);
//        System.out.println(employeeIPage.getRecords());


//        9、分页查询

//            Integer count = employeeMapper.selectCount(new QueryWrapper<Employee>().between("age", 0, 100)
//                    .eq("gender", 0));

//            IPage<Employee> employeeIPage = new Page<Employee>(1, 3);

            IPage<Employee>  employeeList = employeeMapper.selectPage(new Page<>(1,3),new QueryWrapper<>());
        System.out.println(employeeList.getRecords());
//            if (!employeeList.getRecords().isEmpty()) {
//                logger.info("++一个员工信息+++++" + gson.toJson(employeeList));
//            }
    }
    @Test
    public void testCommonDelete(){
        //根据id进行删除
        int i = employeeMapper.deleteById(4);
        System.out.println(i);
        //根据条件进行删除
//        Map<String,Object> columnMap=new HashMap<>();
//        columnMap.put("last_name","yan");
//        columnMap.put("gender","1");
//        int i = employeeMapper.deleteByMap(columnMap);
//        System.out.println(i);
        //批量删除
//        List<Integer> ids=new ArrayList<>();
//        ids.add(29);
//        ids.add(30);
//        ids.add(31);
//        employeeMapper.deleteBatchIds(ids);
    }

    /**
     * 条件构造器查询操作
     */
    @Test
    public void testAbstractWrapperSelect(){
//        IPage<Employee> employeeIPage = employeeMapper.selectPage(new Page<>(1, 2), new QueryWrapper<Employee>().between("age", 20, 30)
//        .eq("gender","1").eq("last_name","Tom"));
//        System.out.println(employeeIPage.getPages());
//        System.out.println(employeeIPage.getRecords());
        //查询mp表中
//        List<Employee> employees = employeeMapper.selectList(new QueryWrapper<Employee>().eq("gender", "1").like("last_name", "T").or().like("email", "e"));
//        System.out.println(employees);
//        List<Employee> gender = employeeMapper.selectList(new QueryWrapper<Employee>().eq("gender", 1)
////                .orderByAsc("age")
//                .orderByDesc("age")
//        );
//        System.out.println(gender);
//        employeeMapper.selectPage(new Page<>(1,2), );
    }
    /**
     * 条件构造器修改操作
     */
    @Test
    public void testAbstractWrapperUpdate(){
        Employee employee = new Employee();
        employee.setLastName("what are you doing");
        employee.setEmail("123456@qq.com");
        employee.setGender(1);
        employeeMapper.update(employee,new QueryWrapper<Employee>().eq("last_name","Tom").eq("age","20"));
    }
    /**
     * 条件构造器删除操作
     */
    @Test
    public void testAbstractWrapperDelete(){
        employeeMapper.delete(new QueryWrapper<Employee>().eq("last_name","Tom").eq("age","30"));
    }
}
