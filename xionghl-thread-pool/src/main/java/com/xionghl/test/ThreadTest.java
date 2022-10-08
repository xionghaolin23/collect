package com.xionghl.test;

import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 线程运行速度测试
 * @Author:xionghl
 * @Date:2022/10/8 22:09
 */

public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
        StopWatch watch =  new StopWatch();
        watch.start();
        final Random random = new Random();
        final List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
                Thread thread = new Thread(){
                    @Override
                    public void run(){
                        list.add(random.nextInt());
                    }
                };

                thread.start();
                thread.join();
        }
        watch.stop();
        System.out.println("运行时间："+watch.getTotalTimeSeconds());
        System.out.println("数组大小："+list.size());
    }
}
