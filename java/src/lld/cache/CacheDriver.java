package lld.cache;

import lld.cache.storage.HashMapStorage;
import lld.cache.storage.Storage;
import lld.cache.strategies.CacheStrategy;
import lld.cache.strategies.LRUCachingStrategy;

public class CacheDriver {

    public static void main(String... s) {
        Storage<Integer, Integer> storage = new HashMapStorage<>();
        CacheStrategy<Integer> cacheStrategy = new LRUCachingStrategy<>();

        CacheImpl<Integer, Integer> cacheImpl = new CacheImpl<>(2, cacheStrategy, storage);

        cacheImpl.put(1, 1);
        cacheImpl.put(2, 2);
        System.out.println(cacheImpl.get(1));
        cacheImpl.put(3,3);
        System.out.println(cacheImpl.get(2));
        cacheImpl.put(4,4);
        System.out.println(cacheImpl.get(1));
        System.out.println(cacheImpl.get(3));
        System.out.println(cacheImpl.get(4));

    }
}
