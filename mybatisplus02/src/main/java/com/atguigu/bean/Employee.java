package com.atguigu.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * mp表对应的Javabean
 * @author YZJ
 * @date 2019/4/17 - 22:28
 * mybatis plus会默认使用实体类的类名到数据中找对应的表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "mp")
public class Employee extends Model<Employee> {
    /**
     * @TableId:
     *  value:指定表中的主键的列名，如果实体属性名与列名一致，可以省略不写
     *  type:指定主键策略
     */
//    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /**
     * 指定对应表中哪个字段
     */
//    @TableField(value = "last_name")
    private String lastName;
    private String Email;
    private Integer gender;
    private Integer age;
    //指定该属性将不会映射到数据库表的字段中去
    @TableField(exist = false)
    private Double salary;

    @Override
    protected Serializable pkVal() {
        return id;
    }
}
