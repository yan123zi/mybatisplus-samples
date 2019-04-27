package com.atguigu.mapper;

import com.atguigu.bean.Employee;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @author YZJ
 * @date 2019/4/18 - 21:17
 * Mapper接口
 * 基于mybatis：在Mapper接口中编写crud相关的方法，还得再提供mapper接口所对应的sql映射文件以及方法对应的sql语句
 * 基于mybatis plus：只需让XXXMapper接口去继承BaseMapper接口即可
 *                  BaseMapper<T>:泛型指定的就是当前Mapper接口所操作的实体类类型
 */
public interface EmployeeMapper extends BaseMapper<Employee> {
    // Integer insertEmployee(Employee employee);
    // <insert useGeneratedKeys="true" keyProperty="id">SQL...</insert
}
