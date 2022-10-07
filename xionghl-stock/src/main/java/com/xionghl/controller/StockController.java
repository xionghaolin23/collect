package com.xionghl.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:xionghl
 * @Date:2022/10/7 14:39
 */
@RestController
@RequestMapping("/stock")
public class StockController {


    @PostMapping("reduct")
    public String reduct(){

        return "扣件库存成功";
    }
}
