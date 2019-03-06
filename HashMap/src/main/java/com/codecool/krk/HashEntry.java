package com.codecool.krk;

public class HashEntry<K, V> {
    private final K key;
    private V value;

    public HashEntry(K key, V value) {
        this.value = value;
        this.key = key;
    }

    public V getValue() {
        return this.value;
    }

    public K getKey() {
        return this.key;
    }

    public Class getTypeOfValue() {
        return this.value.getClass();
    }

    public void setValue(V value) {
        this.value = value;
    }
}
