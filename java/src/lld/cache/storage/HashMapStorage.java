package lld.cache.storage;

import java.util.HashMap;

public class HashMapStorage<K, V> implements Storage<K, V> {

    private HashMap<K, V> map = new HashMap<K, V>();

    @Override
    public void add(K key, V value) {
        map.put(key, value);
    }

    @Override
    public V remove(K key) {
        return map.remove(key);
    }

    @Override
    public V get(K key) {
        return map.get(key);
    }

}
