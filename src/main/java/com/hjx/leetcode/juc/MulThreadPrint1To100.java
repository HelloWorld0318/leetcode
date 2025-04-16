package com.hjx.leetcode.juc;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author houjinxiang
 * 多线程循环打印1到100
 */
public class MulThreadPrint1To100 {

    private volatile int i = 0;
    private volatile int flag = 0;

    public static void main(String[] args) {
        MulThreadPrint1To100 test = new MulThreadPrint1To100();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        Runnable r1 = test.new Thread1();
        Runnable r2 = test.new Thread2();
        Runnable r3 = test.new Thread3();
        executor.execute(r1);
        executor.execute(r2);
        executor.execute(r3);
        System.out.println("hello");
        executor.shutdown();
    }

    class Thread1 implements Runnable {
        @Override
        public void run() {
            while (i < 101) {
                if (flag == 0) {
                    System.out.println("Thread1-" + i);
                    i++;
                    flag = 1;
                }
            }
        }
    }

    class Thread2 implements Runnable {
        @Override
        public void run() {
            while (i < 101) {
                if (flag == 1) {
                    System.out.println("Thread2-" + i);
                    i++;
                    flag = 2;
                }
            }
        }
    }

    class Thread3 implements Runnable {
        @Override
        public void run() {
            while (i < 101) {
                if (flag == 2) {
                    System.out.println("Thread3-" + i);
                    i++;
                    flag = 0;
                }
            }
        }
    }
}

