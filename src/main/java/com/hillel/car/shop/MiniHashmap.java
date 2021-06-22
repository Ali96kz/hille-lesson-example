package com.hillel.car.shop;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class MiniHashmap<K, V> implements Map<K, V> {

    private MyEntry<K, V>[] entries = new MyEntry[16];

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        return entries[key.hashCode() % 16].getValue();
    }

    @Override
    public V put(K key, V value) {
        MyEntry<K, V> entry = new MyEntry<>(key, value);

        entries[entry.hashCode() % 16] = entry;

        return entry.getValue();
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return null;
    }

    public class MyEntry<K, V> implements Map.Entry<K, V> {

        private K key;
        private V v;

        public MyEntry(K key, V v) {
            this.key = key;
            this.v = v;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return v;
        }

        @Override
        public V setValue(V value) {
            this.v = value;
            return v;
        }
    }

}
