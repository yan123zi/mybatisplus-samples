package com.atguigu.controller;


import com.atguigu.service.MpService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

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

