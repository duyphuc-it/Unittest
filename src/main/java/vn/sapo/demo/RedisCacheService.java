package vn.sapo.demo;

import redis.clients.jedis.Jedis;

public class RedisCacheService implements CacheService {

    Jedis jedis;

    public RedisCacheService() {
        jedis = new Jedis("localhost", 6379);
    }

    public void set(String key, int value) {
        jedis.set(key, String.valueOf(value));
    }

    public Integer get(String key) {
        var data = jedis.get(key);
        if (data == null)
            return null;
        return Integer.parseInt(jedis.get(key));
    }
}
