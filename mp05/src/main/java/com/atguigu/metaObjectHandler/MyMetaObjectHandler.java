package com.atguigu.metaObjectHandler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

/**
 * @author YZJ
 * @date 2019/4/21 - 13:50
 */
public class MyMetaObjectHandler implements MetaObjectHandler {
    /**
     * 插入操作自动填充
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        //获取到需要被填充的字段的值
        Object fieldValue = this.getFieldValByName("name", metaObject);
        if(fieldValue==null){
            System.out.println("插入操作满足填充条件");
            setFieldValByName("name","yzj",metaObject);
        }
    }



    /**
     * 修改操作自动填充
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        //获取到需要被填充的字段的值
        Object fieldValue = this.getFieldValByName("name", metaObject);
        if(fieldValue==null){
            System.out.println("修改操作满足填充条件");
            setFieldValByName("name","yzjxg",metaObject);
        }
    }
}
