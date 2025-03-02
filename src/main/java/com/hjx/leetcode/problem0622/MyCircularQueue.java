package com.hjx.leetcode.problem0622;

import java.util.NoSuchElementException;

public class MyCircularQueue {

    private ArrayQueue<Integer> arrayQueue;
    private int cap;

    public MyCircularQueue(int k) {
        this.arrayQueue = new ArrayQueue<>(k);
        this.cap = k;
    }

    public boolean enQueue(int value) {
        if (this.isFull()) {
            return false;
        }
        arrayQueue.enqueue(value);
        return true;
    }

    public boolean deQueue() {
        if (arrayQueue.isEmpty()) {
            return false;
        }
        arrayQueue.dequeue();
        return true;
    }

    public int Front() {
        if (arrayQueue.isEmpty()) {
            return -1;
        }
        return arrayQueue.peekFirst();
    }

    public int Rear() {
        if (arrayQueue.isEmpty()) {
            return -1;
        }
        return arrayQueue.peekLast();
    }

    public boolean isEmpty() {
        return arrayQueue.isEmpty();
    }

    public boolean isFull() {
        return arrayQueue.size() == cap;
    }

}

/**
 * 底层用数组实现队列
 *
 * @param <E>
 */
class ArrayQueue<E> {

    private int size;
    private E[] data;
    private final static int INIT_CAP = 2;

    //[first,last)
    private int first, last;

    public ArrayQueue(int initCap) {
        size = 0;
        data = (E[]) new Object[initCap];
        first = 0;
        last = 0;
    }

    public ArrayQueue() {
        this(INIT_CAP);
    }

    // 增
    public void enqueue(E e) {
        if (this.size == data.length) {
            resize(this.size * 2);
        }
        data[last] = e;
        last++;
        if (last == data.length) {
            last = 0;
        }
        size++;
    }

    // 删
    public E dequeue() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        if (this.size == data.length << 2) {
            resize(data.length << 1);
        }
        E oldData = this.data[first];
        this.data[first] = null;
        first++;

        if (first == data.length) {
            first = 0;
        }
        size--;
        return oldData;
    }

    private void resize(int newCap) {
        E[] temp = (E[]) new Object[newCap];
        // first ----- last
        // --- last    first ---

        for (int i = 0; i < size; i++) {
            temp[i] = data[(first + i) % data.length];
        }

        first = 0;
        last = size;
        data = temp;
    }

    // 查
    public E peekFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.data[first];
    }

    public E peekLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        //[first,last)
        if (last == 0) {
            return this.data[data.length - 1];
        }
        return this.data[last - 1];
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
}