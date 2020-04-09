package com.hjx.leetcode.problem1114;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Foo4 {

    public Foo4() {

    }

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private volatile int num = 0;

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();

        try {
            while (num != 0) {
                condition.await();
            }
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            num++;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try {
            while (num != 1) {
                condition.await();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            num++;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();

        try {
            while (num != 2) {
                condition.await();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            num++;
            num = num % 3;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
