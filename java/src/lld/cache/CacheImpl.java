package lld.cache;

import lld.cache.storage.Storage;
import lld.cache.strategies.CacheStrategy;

public class CacheImpl<K, V> implements ICache<K, V> {
    private final Storage<K, V> storage; //cache
    private final CacheStrategy<K> cacheStrategy; //ordering  //multiple Algo :
    private int size = 0;
    private int MAX_CAPCACITY;

    public CacheImpl(int maxCapacity, CacheStrategy cacheStrategy, Storage storage) {
        this.MAX_CAPCACITY = maxCapacity;
        this.cacheStrategy = cacheStrategy;
        this.storage = storage;
    }

    public V get(K key) {
        V cached = storage.get(key);
        if (cached != null) {
            cacheStrategy.reshuffle(key);
            return cached;
        }

        return null;
    }


    public void put(K key, V value) {
        V cached = this.get(key);
        if (cached != null) {
            return;
        }

        if (size < MAX_CAPCACITY) {
            size++;
            storage.add(key, value);
            cacheStrategy.reshuffle(key);
        } else {
            K evictedKey = cacheStrategy.evict();
            storage.remove(evictedKey);
            storage.add(key, value);
            cacheStrategy.reshuffle(key);
        }
    }
}
