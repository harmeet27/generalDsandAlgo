package lld.cache.storage;

public interface Storage<K, V> {

    void add(K key, V value);

    V remove(K key);

    V get(K key);
}
