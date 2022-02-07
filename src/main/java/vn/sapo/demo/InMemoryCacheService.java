package vn.sapo.demo;

import java.util.HashMap;
import java.util.Map;

public class InMemoryCacheService implements CacheService {

    Map<String, Integer> store = new HashMap<>();

    @Override
    public void set(String key, int value) {
        store.put(key, value);
    }

    @Override
    public Integer get(String key) {
        return store.get(key);
    }
}
