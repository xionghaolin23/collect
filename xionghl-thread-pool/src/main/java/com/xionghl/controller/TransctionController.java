package com.xionghl.controller;

import com.xionghl.service.IUserService;
import com.xionghl.transaction.TransctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:xionghl
 * @Date:2022/11/7 20:57
 */
@RestController
public class TransctionController {

    @Autowired
    private TransctionService transctionService;



    @GetMapping("testTransaction")
    public void savaUserOtestTransactionne() {
        transctionService.testTransaction();
    }

}
