package com.xionghl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xionghl.entity.User;

/**
 * @Author:xionghl
 * @Date:2022/9/27 21:02
 */
public interface IUserService extends IService<User> {

    /**
     *
     * @return
     */
    Boolean savaUserOne();

    Boolean savaUserBatch();

    Boolean savaUserBatchWithThread();

    Boolean user();


    void updateStudentWithThreads();
}
