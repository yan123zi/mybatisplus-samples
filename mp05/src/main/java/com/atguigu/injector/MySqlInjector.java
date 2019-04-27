package com.atguigu.injector;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.AbstractSqlInjector;
import java.util.List;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

/**
 * @author YZJ
 * @date 2019/4/21 - 9:49
 * 自定义全局操作
 */
public class MySqlInjector extends AbstractSqlInjector {
    @Override
    public List<AbstractMethod> getMethodList() {
        return Stream.of(new DeleteAll()).collect(toList());
    }

}
