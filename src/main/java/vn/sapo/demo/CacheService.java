package vn.sapo.demo;

public interface CacheService {

    void set(String key, int value);

    Integer get(String key);

}
