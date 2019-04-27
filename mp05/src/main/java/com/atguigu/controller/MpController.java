package com.atguigu.controller;


import com.atguigu.service.MpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yzj
 * @since 2019-04-20
 */
@Controller
@RequestMapping("/mp")
public class MpController {
    @Autowired
    private MpService mpService;
    public String login(){
        return "";
    }
}

