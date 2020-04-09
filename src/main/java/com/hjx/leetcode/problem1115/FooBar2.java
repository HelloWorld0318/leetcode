package com.hjx.leetcode.problem1115;

import java.util.concurrent.atomic.AtomicInteger;

public class FooBar2 {

    private int n;

    public FooBar2(int n) {
        this.n = n;
    }

    private AtomicInteger atomicInteger = new AtomicInteger(1);

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (!atomicInteger.compareAndSet(1, 2)) {
                Thread.yield();
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            atomicInteger.incrementAndGet();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (!atomicInteger.compareAndSet(3, 4)) {
                Thread.yield();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            atomicInteger.compareAndSet(4, 1);
        }
    }

}
