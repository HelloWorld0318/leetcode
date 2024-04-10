package com.hjx.leetcode.juc.threadlocal;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyTheadLocalMemoryLeak {

    public static final Integer SIZE = 100;

    static ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 1, TimeUnit.MINUTES, new LinkedBlockingDeque<>());

    static ThreadLocal<String> local = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        try {
            for (int i = 0; i < SIZE; i++) {
                int finalI = i;
                executor.execute(() -> {
                    local.set("finalI:" + finalI);
                    System.out.println("开始执行" + finalI + "-" + local.get());
                    //添加remove不会造成内存泄漏
                });
                Thread.sleep(100);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(local);
        System.out.println(local.get());


        System.out.println("-----------------------------");

        for (int i = 0; i < SIZE; i++) {
            int finalI = i;
            executor.execute(() -> {
//                local.set(new Stu());
                System.out.println("开始执行" + finalI + "-" + local.get());
                //添加remove不会造成内存泄漏
            });
            Thread.sleep(100);
        }

    }
}
