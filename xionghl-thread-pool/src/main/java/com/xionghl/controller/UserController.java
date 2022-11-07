package com.xionghl.controller;

import com.xionghl.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:xionghl
 * @Date:2022/9/27 21:07
 */
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("savaUserOne")
    public void savaUserOne(){
        userService.savaUserOne();
    }

    @GetMapping("savaUserBatch")
    public void savaUserBatch(){
        userService.savaUserBatch();
    }

    @GetMapping("savaUserBatchWithThread")
    public void savaUserBatchWithThread(){
        userService.savaUserBatchWithThread();
    }

    @GetMapping("user")
    public void user(){
        userService.user();
    }
}
