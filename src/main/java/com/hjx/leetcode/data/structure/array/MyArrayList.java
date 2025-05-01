package com.hjx.leetcode.data.structure.array;

import java.util.NoSuchElementException;

/**
 * @author houjinxiang
 */
public class MyArrayList<E> {
    /**
     * 真正存储数据的底层数组
     */
    private E[] data;

    /**
     * 记录当前元素个数
     */
    private int size;

    /**
     * 默认初始容量
     */
    private static final int INIT_CAP = 1;

    public MyArrayList() {
        this(INIT_CAP);
    }

    public MyArrayList(int initCapacity) {
        data = (E[]) new Object[initCapacity];
        size = 0;
    }

    /**
     * 向列表中新增元素
     *
     * @param e 新增的元素e
     */
    public void addLast(E e) {
        int cap = data.length;
        // 看 data 数组容量够不够
        if (size == cap) {
            resize(2 * cap);
        }
        //在尾部插入元素
        data[size] = e;
        size++;
    }

    /**
     * 在位置index处添加元素e
     *
     * @param index 添加元素的位置
     * @param e     元素e
     */
    public void add(int index, E e) {
        // 检查索引越界
        checkPositionIndex(index);
        int cap = data.length;
        // 看 data 数组容量够不够
        if (size == cap) {
            resize(2 * cap);
        }
        // 搬移数据 data[index..] -> data[index+1..]
        // 给新元素腾出位置
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        // 插入新元素
        data[index] = e;
        size++;
    }

    /**
     * 向头部添加元素e
     *
     * @param e 添加的元素e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 删除最后一个元素的位置
     *
     * @return 最后一个元素的值e
     */
    public E removeLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        int cap = data.length;
        // 可以缩容，节约空间
        if (size == cap / 4) {
            resize(cap / 2);
        }
        E deletedVal = data[size - 1];
        // 删除最后一个元素
        // 必须给最后一个元素置为 null，否则会内存泄漏
        data[size - 1] = null;
        size--;
        return deletedVal;
    }

    /**
     * 删除索引位置index处的元素
     *
     * @param index 删除的索引位置index
     * @return 索引index位置的值
     */
    public E remove(int index) {
        // 检查索引越界
        checkElementIndex(index);
        int cap = data.length;
        // 可以缩容，节约空间
        if (size == cap / 4) {
            resize(cap / 2);
        }
        E deletedVal = data[index];
        // 搬移数据 data[index+1..] -> data[index..]
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        data[size - 1] = null;
        size--;
        return deletedVal;
    }

    /**
     * 删除第一个元素
     *
     * @return 被删除的值
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 查询index位置的值
     *
     * @param index 查询位置的索引
     * @return index位置的值
     */
    public E get(int index) {
        // 检查索引越界
        checkElementIndex(index);
        return data[index];
    }

    /**
     * 修改index位置的值为element
     *
     * @param index   索引位置
     * @param element 修改的新值
     * @return 替换位置的旧值
     */
    public E set(int index, E element) {
        // 检查索引越界
        checkElementIndex(index);
        // 修改数据
        E oldVal = data[index];
        data[index] = element;
        return oldVal;
    }

    /**
     * 工具方法
     *
     * @return
     */
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 将 data 的容量改为 newCap
     *
     * @param newCap
     */
    private void resize(int newCap) {
        E[] temp = (E[]) new Object[newCap];
        for (int i = 0; i < size; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    /**
     * 检查 index 索引位置是否可以存在元素
     *
     * @param index
     */
    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    /**
     * 检查 index 索引位置是否可以添加元素
     *
     * @param index
     */
    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
}