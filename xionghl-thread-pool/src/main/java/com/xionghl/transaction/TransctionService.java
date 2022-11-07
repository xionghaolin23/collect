package com.xionghl.transaction;

import com.xionghl.entity.User;
import com.xionghl.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * 测试事务声明
 * @Author:xionghl
 * @Date:2022/11/7 20:48
 */

@Service
public class TransctionService {

    @Autowired
    private IUserService userService;

    @Transactional(rollbackFor = Exception.class)
    public void testTransaction(){

        /**
         * 事务执行成功之后 才会执行此回调函数
         */
        TransctionUtil.doAfterTransction(new DoTransationCompleion(
                ()->{
                    //doOther send MQ
                    System.out.println("事务成功后才会调用此方法执行");
                }
        ));
        User user = new User();
        user.setName("xionghl");
        user.setAge(25);
        user.setEmail("1445695649@qq.com");
        userService.save(user);
        int i = 1 / 0;
    }

    /**
     * 添加了@Transactional注解，返回true
     */
    @Transactional
    public void test1() {
        System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
    }

    /**
     * 没添加了@Transactional注解，返回false
     */
    public void test2() {
        System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
    }





}
