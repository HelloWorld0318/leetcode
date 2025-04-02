package com.hjx.leetcode.data.structure.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyLinkedHashMap<K, V> {

    private static class Node<K, V> {
        K key;
        V val;
        Node<K, V> next, prev;

        Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    private final Node<K, V> headDummy, tailDummy;

    private final HashMap<K, Node<K, V>> map = new HashMap<>();

    public MyLinkedHashMap() {
        headDummy = new Node<>(null, null);
        tailDummy = new Node<>(null, null);
        headDummy.next = tailDummy;
        tailDummy.prev = headDummy;
    }

    public V get(K key) {
        Node<K, V> node = map.get(key);
        if (node != null) {
            return node.val;
        }
        return null;
    }

    public void put(K key, V val) {
        // 若为新插入的节点，则同时插入链表和 map
        if (!map.containsKey(key)) {
            // 插入新的 Node
            Node<K, V> node = new Node<>(key, val);
            addLastNode(node);
            map.put(key, node);
            return;
        }
        // 若存在，则替换之前的 val
        map.get(key).val = val;
    }

    public void remove(K key) {
        // 若 key 本不存在，直接返回
        if (!map.containsKey(key)) {
            return;
        }
        // 若 key 存在，则需要同时在哈希表和链表中删除
        Node<K, V> node = map.get(key);
        map.remove(key);
        removeNode(node);
    }

    public boolean containsKey(K key) {
        return map.containsKey(key);
    }

    public List<K> keys() {
        List<K> keyList = new ArrayList<>();
        for (Node<K, V> p = headDummy.next; p != tailDummy; p = p.next) {
            keyList.add(p.key);
        }
        return keyList;
    }

    public int size() {
        return map.size();
    }

    private void addLastNode(Node<K, V> x) {
        Node<K, V> temp = tailDummy.prev;
        // temp <-> tail

        x.next = tailDummy;
        x.prev = temp;
        // temp <- x -> tail

        temp.next = x;
        tailDummy.prev = x;
        // temp <-> x <-> tail
    }

    private void removeNode(Node<K, V> x) {
        Node<K, V> prev = x.prev;
        Node<K, V> next = x.next;
        // prev <-> x <-> next

        prev.next = next;
        next.prev = prev;

        x.next = x.prev = null;
    }
}
