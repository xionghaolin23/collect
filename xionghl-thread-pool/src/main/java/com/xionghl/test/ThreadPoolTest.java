package com.xionghl.test;

import com.xionghl.config.ThreadPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author:xionghl
 * @Date:2022/10/8 22:19
 */
public class ThreadPoolTest {


    public static void main(String[] args) throws InterruptedException {

        StopWatch watch = new StopWatch();
        watch.start();
        final Random random = new Random();
        ExecutorService executorService = ThreadPoolConfig.executorService();
        final List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            executorService.execute(() -> {
                list.add(random.nextInt());
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
        watch.stop();
        System.out.println("运行时间：" + watch.getTotalTimeSeconds());
        System.out.println("数组大小：" + list.size());
    }
}
