package com.atguigu.service.impl;

import com.atguigu.beans.Mp;
import com.atguigu.mapper.MpMapper;
import com.atguigu.service.MpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yzj
 * @since 2019-04-20
 */
@Service
public class MpServiceImpl extends ServiceImpl<MpMapper, Mp> implements MpService {
    //不再进行mapper的注入
    /**
     * MpServiceImpl继承了ServiceImpl
     * 1，在ServiceImpl已经完成Mapper对象的注入，直接在ServiceImpl中进行使用
     * 在ServiceImpl中也帮我们提供了常用的CRUD方法，基本的一些CRUD方法在Service中不需要我们自己定义
     */
}
