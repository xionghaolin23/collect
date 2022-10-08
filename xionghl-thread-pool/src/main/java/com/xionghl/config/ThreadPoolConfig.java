package com.xionghl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

/**
 * @Author:xionghl
 * @Date:2022/10/8 21:49
 */
public class ThreadPoolConfig {


    /**
     * 获取当前运行机器的可用CPU核心数
     */
    private final static int POLLER_THREAD_COUNT = Runtime.getRuntime().availableProcessors();


    public static ExecutorService executorService() {

        return new ThreadPoolExecutor(
                POLLER_THREAD_COUNT,
                POLLER_THREAD_COUNT * 8,
                10L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(64),
                threadFactory,
                new ThreadPoolExecutor.CallerRunsPolicy());
    }

    /**
     * 创建线程工厂
     */
    static ThreadFactory threadFactory = new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            // 创建线程池中的线程
            Thread thread = new Thread(r);
            // 设置线程名称
            thread.setName("xionghl-" + r.hashCode());
            // 设置线程优先级
            thread.setPriority(Thread.MAX_PRIORITY);
            // 设置线程类型（守护线程、用户线程）, false-用户线程
            thread.setDaemon(false);
            return thread;
        }
    };

}
