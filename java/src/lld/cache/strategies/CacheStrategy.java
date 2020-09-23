package lld.cache.strategies;

public interface CacheStrategy<K> {

    K evict(); //cache full

    void reshuffle(K key); //reordering, get
}
