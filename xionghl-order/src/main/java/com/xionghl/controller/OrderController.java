package com.xionghl.controller;

import com.xionghl.feign.OrderFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:xionghl
 * @Date:2022/10/7 14:39
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderFeignService orderFeignService;

    @PostMapping("add")
    public String addOrder(){
        orderFeignService.reduct();
        return "下单成功";
    }
}
