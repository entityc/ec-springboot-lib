package ${domain.namespace};

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LRUCache<K, V> {

    private final LinkedHashMap<K, V> cache;

    public LRUCache(int maxCacheSize) {
        cache = new LinkedHashMap<K, V>(maxCacheSize, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > maxCacheSize;
            }
        };
    }

    public boolean containsKey(K key) {
        return cache.containsKey(key);
    }

    public V get(K key) {
        return cache.get(key);
    }

    public void put(K key, V value) {
        cache.put(key, value);
    }

    public int size() {
        return cache.size();
    }

    public Set<K> getKeys() {
        return cache.keySet();
    }

    public void clear() {
        cache.clear();
    }

    public void putAll(Map<K, V> map) {
        cache.putAll(map);
    }

    public void invalidate(K key) {
        cache.remove(key);
    }
}
