package lld.cache.factories;

import lld.cache.CacheImpl;
import lld.cache.storage.HashMapStorage;
import lld.cache.strategies.CacheStrategy;
import lld.cache.strategies.LRUCachingStrategy;

import java.util.HashMap;

public class CacheFactory<K, V> {

    HashMap<String, CacheStrategy>  strategies;

    public CacheImpl<K, V> defaultCache(int size) {
        return new CacheImpl(size, new LRUCachingStrategy<K>(), new HashMapStorage<K, V>());
    }

}
