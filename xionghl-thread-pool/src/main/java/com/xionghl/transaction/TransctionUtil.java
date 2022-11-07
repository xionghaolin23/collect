package com.xionghl.transaction;

import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * 基于Spring事务扩展 写出优雅可靠事务
 * @Author:xionghl
 * @Date:2022/11/7 20:40
 */
public class TransctionUtil {

    public static void doAfterTransction(DoTransationCompleion doTransationCompleion){
        /**
         * 如果事务被激活 就把回调接口注册进去
         */
        if(TransactionSynchronizationManager.isActualTransactionActive()){
            TransactionSynchronizationManager.registerSynchronization(doTransationCompleion);
        }

    }


}


class DoTransationCompleion implements TransactionSynchronization{

    private Runnable runnable;

    public DoTransationCompleion(Runnable runnable) {
        this.runnable = runnable;
    }

    @Override
    public void afterCompletion(int status) {

        /**
         * 如果事务的状态是已提交的
         */
        if(status == TransactionSynchronization.STATUS_COMMITTED){

            //回调函数
            this.runnable.run();

        }
    }
}
