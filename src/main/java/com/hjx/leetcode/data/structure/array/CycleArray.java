package com.hjx.leetcode.data.structure.array;

public class CycleArray<T> {
    /**
     * 环形数组的底层数组
     */
    private T[] arr;

    /**
     * 环形数组的起始位置 [start,end)
     */
    private int start;

    /**
     * 环形数组的结束位置 [start,end) 当start=end的时候，环形数组中没有任何元素存储
     */
    private int end;

    /**
     * 环形数组里面元素的个数
     */
    private int size;

    /**
     * 环形数组的容量
     */
    private int capacity;

    public CycleArray() {
        this(1);
    }

    @SuppressWarnings("unchecked")
    public CycleArray(int cap) {
        this.capacity = cap;
        // 因为Java不支持直接创建泛型数组，所以这里使用了类型转换
        this.arr = (T[]) new Object[cap];
        // start 指向第一个有效元素的索引，闭区间
        this.start = 0;
        // 切记 end 是一个开区间，
        // 即 end 指向最后一个有效元素的下一个位置索引
        this.end = 0;
        this.size = 0;
    }

    // 自动扩缩容辅助函数
    @SuppressWarnings("unchecked")
    private void resize(int newCap) {
        // 创建新的数组
        T[] newArr = (T[]) new Object[newCap];
        // 将旧数组的元素复制到新数组中
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[(start + i) % capacity];
        }
        arr = newArr;
        // 重置 start 和 end 指针
        start = 0;
        end = size;
        capacity = newCap;
    }

    // 在数组头部添加元素，时间复杂度 O(1)
    public void addFirst(T val) {
        // 当数组满时，扩容为原来的两倍
        if (isFull()) {
            resize(capacity * 2);
        }
        // 因为 start 是闭区间，所以先左移，再赋值
        start = (start - 1 + capacity) % capacity;
        arr[start] = val;
        size++;
    }

    // 删除数组头部元素，时间复杂度 O(1)
    public void removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Array is empty");
        }
        // 因为 start 是闭区间，所以先赋值，再右移
        arr[start] = null;
        start = (start + 1) % capacity;
        size--;
        // 如果数组元素数量减少到原大小的四分之一，则减小数组大小为一半
        if (size > 0 && size == capacity / 4) {
            resize(capacity / 2);
        }
    }

    // 在数组尾部添加元素，时间复杂度 O(1)
    public void addLast(T val) {
        if (isFull()) {
            resize(capacity * 2);
        }
        // 因为 end 是开区间，所以是先赋值，再右移
        arr[end] = val;
        end = (end + 1) % capacity;
        size++;
    }

    // 删除数组尾部元素，时间复杂度 O(1)
    public void removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("Array is empty");
        }
        // 因为 end 是开区间，所以先左移，再赋值
        end = (end - 1 + capacity) % capacity;
        arr[end] = null;
        size--;
        // 缩容
        if (size > 0 && size == capacity / 4) {
            resize(capacity / 2);
        }
    }

    // 获取数组头部元素，时间复杂度 O(1)
    public T getFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Array is empty");
        }
        return arr[start];
    }

    // 获取数组尾部元素，时间复杂度 O(1)
    public T getLast() {
        if (isEmpty()) {
            throw new IllegalStateException("Array is empty");
        }
        // end 是开区间，指向的是下一个元素的位置，所以要减 1
        return arr[(end - 1 + capacity) % capacity];
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
