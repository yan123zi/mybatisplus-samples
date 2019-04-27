package com.atguigu.injector;

import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

import javax.xml.soap.SAAJResult;

/**
 * @author YZJ
 * @date 2019/4/21 - 10:49
 */
public class DeleteAll extends AbstractMethod {
    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        /*String sql;
        SqlMethod sqlMethod = SqlMethod.LOGIC_DELETE;
        if (tableInfo.isLogicDelete()) {
            sql = String.format(sqlMethod.getSql(), tableInfo.getTableName(), sqlLogicSet(tableInfo),
                    sqlWhereEntityWrapper(true, tableInfo));
        } else {
            sqlMethod = SqlMethod.DELETE;
            sql = String.format(sqlMethod.getSql(), tableInfo.getTableName(),
                    sqlWhereEntityWrapper(true, tableInfo));
        }
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);*/
         //将mpMapper中定义的deleteAll，处理成对应的MappedStatement对象，加入到configuration对象中
        //注入的sql语句
        String sql="delete from "+tableInfo.getTableName();
        //注入的方法名 一定要与mpMapper接口中的方法名一致
        String method="deleteAll";
        //构造sqlSource对象
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);
        //构造一个删除的MappedStatement
        return addDeleteMappedStatement(mapperClass,method,sqlSource);
    }
}
