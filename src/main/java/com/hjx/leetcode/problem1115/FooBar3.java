package com.hjx.leetcode.problem1115;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class FooBar3 {

    private int n;

    public FooBar3(int n) {
        this.n = n;
    }

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition isPrintFooCond = lock.newCondition();
    private boolean isPrintFoo = true;

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (!isPrintFoo) {
                    isPrintFooCond.await();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                isPrintFoo = false;
                isPrintFooCond.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (isPrintFoo) {
                    isPrintFooCond.await();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                isPrintFoo = true;
                isPrintFooCond.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

}
