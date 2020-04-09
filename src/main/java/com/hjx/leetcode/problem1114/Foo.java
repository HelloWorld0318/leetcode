package com.hjx.leetcode.problem1114;

public class Foo {

    private boolean isFirstFinished = false;
    private boolean isSecondFinished = false;
    private Object lock = new Object();

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (lock) {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            isFirstFinished = true;
            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock) {
            while (!isFirstFinished) {
                lock.wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            isSecondFinished = true;
            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock) {
            // printThird.run() outputs "third". Do not change or remove this line.
            while (!isSecondFinished) {
                lock.wait();
            }
            printThird.run();
        }
    }

}
