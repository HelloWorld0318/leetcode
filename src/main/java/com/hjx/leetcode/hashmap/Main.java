package com.hjx.leetcode.hashmap;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        HashMap map = new HashMap(32);

        MyObject myObject1 = new MyObject(1);
        MyObject myObject2 = new MyObject(2);
        MyObject myObject3 = new MyObject(3);

        map.put(myObject1,1);
        map.put(myObject2,2);
        map.put(myObject3,3);

        System.out.println(map);
    }
}


class MyObject {

    private int value;
    public MyObject(int value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return 34;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}