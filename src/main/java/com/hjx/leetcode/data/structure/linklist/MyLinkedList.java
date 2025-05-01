package com.hjx.leetcode.data.structure.linklist;

import java.util.NoSuchElementException;

/**
 * @author houjinxiang
 */
public class MyLinkedList<E> {
    /**
     * 虚拟头尾节点
     */
    final private Node<E> dummyHead, dummyTail;

    /**
     * 链表的大小
     */
    private int size;

    /**
     * 双链表的节点
     *
     * @param <E>
     */
    private static class Node<E> {
        E val;
        Node<E> next;
        Node<E> prev;

        Node(E val) {
            this.val = val;
        }
    }

    public MyLinkedList() {
        // 构造函数初始化虚拟头尾节点
        this.dummyHead = new Node<>(null);
        this.dummyTail = new Node<>(null);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
        this.size = 0;
    }

    /**
     * 增
     *
     * @param e 新增的元素e
     */
    public void addLast(E e) {
        Node<E> x = new Node<>(e);
        Node<E> temp = dummyTail.prev;
        // temp <-> x
        temp.next = x;
        x.prev = temp;

        x.next = dummyTail;
        dummyTail.prev = x;
        // temp <-> x <-> tail
        size++;
    }

    /**
     * 添加元素到首位置
     *
     * @param e 新增的元素e
     */
    public void addFirst(E e) {
        Node<E> x = new Node<>(e);
        Node<E> temp = dummyHead.next;
        // head <-> temp
        temp.prev = x;
        x.next = temp;

        dummyHead.next = x;
        x.prev = dummyHead;
        // head <-> x <-> temp
        size++;
    }

    /**
     * 在索引位置index处添加元素element
     *
     * @param index   索引index
     * @param element 添加的元素element
     */
    public void add(int index, E element) {
        checkPositionIndex(index);
        if (index == size) {
            addLast(element);
            return;
        }
        // 找到 index 对应的 Node
        Node<E> p = getNode(index);
        Node<E> temp = p.prev;
        // temp <-> p
        // 新要插入的 Node
        Node<E> x = new Node<>(element);
        // temp <-> x <-> p
        p.prev = x;
        x.next = p;

        temp.next = x;
        x.prev = temp;
        size++;
    }

    /**
     * 删除首位的元素
     *
     * @return 首位的元素E
     */
    public E removeFirst() {
        if (size < 1) {
            throw new NoSuchElementException();
        }
        //虚拟节点的存在使我们不用考虑空指针的问题
        Node<E> x = dummyHead.next;
        Node<E> temp = x.next;
        // head <-> x <-> temp
        dummyHead.next = temp;
        temp.prev = dummyHead;

        E val = x.val;
        x.prev = null;
        x.next = null;
        // head <-> temp
        size--;
        return val;
    }

    public E removeLast() {
        if (size < 1) {
            throw new NoSuchElementException();
        }
        Node<E> x = dummyTail.prev;
        Node<E> temp = dummyTail.prev.prev;
        // temp <-> x <-> tail

        dummyTail.prev = temp;
        temp.next = dummyTail;

        E val = x.val;
        x.prev = null;
        x.next = null;
        // temp <-> tail

        size--;
        return val;
    }

    public E remove(int index) {
        checkElementIndex(index);
        // 找到 index 对应的 Node
        Node<E> x = getNode(index);
        Node<E> prev = x.prev;
        Node<E> next = x.next;
        // prev <-> x <-> next
        prev.next = next;
        next.prev = prev;

        E val = x.val;
        x.prev = null;
        x.next = null;
        // prev <-> next

        size--;
        // 返回被删除节点的值
        return val;
    }

    /**
     * 查索引为值index处的值
     *
     * @param index 索引index
     * @return
     */
    public E get(int index) {
        checkElementIndex(index);
        // 找到 index 对应的 Node
        Node<E> p = getNode(index);
        return p.val;
    }

    public E getFirst() {
        if (size < 1) {
            throw new NoSuchElementException();
        }
        return dummyHead.next.val;
    }

    public E getLast() {
        if (size < 1) {
            throw new NoSuchElementException();
        }
        return dummyTail.prev.val;
    }

    /**
     * 修改索引位置index的值
     *
     * @param index 索引index
     * @param val   新的值
     * @return 旧的值
     */
    public E set(int index, E val) {
        checkElementIndex(index);
        // 找到 index 对应的 Node
        Node<E> p = getNode(index);

        E oldVal = p.val;
        p.val = val;
        return oldVal;
    }

    // ***** 其他工具函数 *****
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private Node<E> getNode(int index) {
        checkElementIndex(index);
        Node<E> p = dummyHead.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p;
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
     * @param index 索引index
     */
    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    /**
     * 检查 index 索引位置是否可以添加元素
     *
     * @param index 索引index
     */
    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private void display() {
        System.out.println("size = " + size);
        for (Node<E> p = dummyHead.next; p != dummyTail; p = p.next) {
            System.out.print(p.val + " <-> ");
        }
        System.out.println("null");
        System.out.println();
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addFirst(0);
        list.add(2, 100);

        list.display();
        // size = 5
        // 0 <-> 1 <-> 100 <-> 2 -> 3 -> null
    }
}
