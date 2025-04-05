package com.hjx.leetcode.data.structure.hashmap;

import java.util.HashMap;

public class DuplexMap<K, V> {

    private HashMap<K, Entry> kEntyMap;
    private HashMap<V, Entry> vEntyMap;

    public DuplexMap() {
        kEntyMap = new HashMap<K, Entry>();
        vEntyMap = new HashMap<V, Entry>();
    }

    class Entry {
        K k;
        V v;

        public Entry(K k, V v) {
            this.k = k;
            this.v = v;
        }

        public K getK() {
            return k;
        }

        public V getV() {
            return v;
        }

        public void setK(K k) {
            this.k = k;
        }

        public void setV(V v) {
            this.v = v;
        }
    }


    public V getByKey(K k) {
        Entry e = kEntyMap.get(k);
        if (e == null) {
            return null;
        }
        return e.getV();
    }

    public K getbyValue(V v) {
        Entry e = vEntyMap.get(v);
        if (e == null) {
            return null;
        }
        return e.getK();
    }

}
