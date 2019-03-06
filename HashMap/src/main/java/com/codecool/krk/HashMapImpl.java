package com.codecool.krk;

import com.codecool.krk.exceptions.ObjectNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class HashMapImpl<K, V> {
    private static final int DEFAULT_SIZE = 0;
    private int bucket_size = 65000;
    private LinkedList<HashEntry>[] linkedLists;
    private Map<Integer, Integer> hashMapping;
    private int size = DEFAULT_SIZE;


    public HashMapImpl() {
        this.linkedLists = new LinkedList[bucket_size];
        this.hashMapping = new HashMap<>();
    }

    public <targetClass> targetClass get(K key) {
        int hash = getHash(key);
        if (hashMapping.containsKey(hash)) {
            LinkedList<HashEntry> list = linkedLists[hashMapping.get(hash)];
            if (list.size() > 1) {
                for (int i = 0; i <= list.size() - 1; i++) {
                    if (list.get(i).getKey().equals(key)) {
                        Class targetClass = list.get(i).getTypeOfValue();
                        return (targetClass) list.get(i).getValue();
                    }
                }
            } else {
                Class targetClass = list.getFirst().getTypeOfValue();
                return (targetClass) list.getFirst().getValue();
            }
        } else {
            throw new ObjectNotFoundException("There is no key like that");
        }
        return null;
    }


    public void add(K key, V value) {
        HashEntry hashEntry = new HashEntry<>(key, value);
        //Get Hash
        int hash = getHash(key);
        //Check if Hash exists in HashMapping
        if (hashMapping.containsKey(hash)) {
            int index = hashMapping.get(hash);
            LinkedList<HashEntry> destinationList = this.linkedLists[index];
            destinationList.add(hashEntry);
        } else {
            hashMapping.put(hash, size);
            LinkedList<HashEntry> newLinkedList = new LinkedList<>();
            newLinkedList.add(hashEntry);
            linkedLists[size] = newLinkedList;
            incrementSize();
        }
    }

    private void incrementSize() {
        this.size++;
    }

    private void decrementSize() {
        this.size--;
    }

    public int size() {
        return this.size;
    }

    public int getHash(K key) {
        int hash = 0;

        for (char c : String.valueOf(key).toCharArray()) {
            hash *= c;
            hash += c;
        }

        if (hash < 0) {
            hash = hash * -1 / 4;
        }
        return hash;
    }

    public String toString() {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= this.size - 1; i++) {
            for (int j = 0; j <= linkedLists[i].size() - 1; j++) {
                sb.append("Index: " + i + " " + "Value: " + linkedLists[i].get(j).getValue());
            }
        }
        return sb.toString();
    }
}
