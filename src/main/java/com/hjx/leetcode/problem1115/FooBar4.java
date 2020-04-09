package com.hjx.leetcode.problem1115;

public class FooBar4 {

    private int n;

    public FooBar4(int n) {
        this.n = n;
    }

    private boolean isPrintFoo = true;
    private Object lock = new Object();

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                if (!isPrintFoo) {
                    lock.wait();
                }
                printFoo.run();
                isPrintFoo = false;
                lock.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                if (isPrintFoo) {
                    lock.wait();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                isPrintFoo = true;
                lock.notifyAll();
            }
        }
    }
}
