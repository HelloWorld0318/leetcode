package com.hjx.leetcode.problem0641;

import java.util.NoSuchElementException;

public class MyCircularDeque {

    private MyArrayDeque<Integer> myArrayDeque;
    private int maxCap;

    public MyCircularDeque(int k) {
        myArrayDeque = new MyArrayDeque<>(k);
        maxCap = k;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        this.myArrayDeque.addFirst(value);
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        this.myArrayDeque.addLast(value);
        return true;
    }

    public boolean deleteFront() {
        if (this.isEmpty()) {
            return false;
        }
        this.myArrayDeque.removeFirst();
        return true;
    }

    public boolean deleteLast() {
        if (this.isEmpty()) {
            return false;
        }
        this.myArrayDeque.removeLast();
        return true;
    }

    public int getFront() {
        if (this.isEmpty()) {
            return -1;
        }
        return this.myArrayDeque.getFirst();
    }

    public int getRear() {
        if (this.isEmpty()) {
            return -1;
        }
        return this.myArrayDeque.getLast();
    }

    public boolean isEmpty() {
        return this.myArrayDeque.isEmpty();
    }

    public boolean isFull() {
        return this.maxCap == this.myArrayDeque.size();
    }
}

class MyArrayDeque<E> {
    private int size;
    private E[] data;
    private final static int INIT_CAP = 2;

    private int first, last;

    public MyArrayDeque(int initCap) {
        size = 0;
        data = (E[]) new Object[initCap];
        first = 0;
        last = 0;
    }

    public MyArrayDeque() {
        this(INIT_CAP);
    }

    public E getFirst() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        return data[first];
    }

    // 从尾部获取元素
    public E getLast() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        if (last == 0) {
            return data[data.length - 1];
        }
        return data[last - 1];
    }

    // 从头部插入元素
    public void addFirst(E e) {
        if (this.size == data.length) {
            resize(this.size * 2);
        }
        if (first == 0) {
            first = data.length - 1;
        } else {
            first--;
        }
        this.data[first] = e;
        size++;
    }

    // 从尾部插入元素
    public void addLast(E e) {
        if (this.size == data.length) {
            resize(this.size * 2);
        }
        this.data[last] = e;
        last++;
        if (last == data.length) {
            last = 0;
        }
        size++;
    }

    // 从头部删除元素
    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (size == data.length << 2) {
            resize(data.length << 1);
        }
        E old = data[first];
        data[first] = null;
        first++;
        if (first == data.length) {
            first = 0;
        }
        size--;
        return old;
    }

    // 从尾部删除元素
    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (size == data.length << 2) {
            resize(data.length << 1);
        }
        if (last == 0) {
            last = data.length - 1;
        } else {
            last--;
        }
        E old = data[last];
        data[last] = null;
        size--;
        return old;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
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
}
