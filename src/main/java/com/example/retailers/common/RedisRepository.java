package com.example.retailers.common;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Redis操作封装
 *
 * @author created by Singer email:313402703@qq.com
 * @time 2018/10/11
 * @description
 */
@Service
public class RedisRepository {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private JedisPool jedisPool;

    /**
     * 使用spring-data-redis实现incr自增
     *
     * @param key      存储的Key
     * @param liveTime 存活时间
     * @return
     */
    public Long incr(String key, long liveTime) {
        RedisAtomicLong entityIdCounter = new RedisAtomicLong(key, stringRedisTemplate.getConnectionFactory());
        Long increment = entityIdCounter.getAndIncrement();

        if ((null == increment || increment.longValue() == 0) && liveTime > 0) {// 初始设置过期时间
            entityIdCounter.expire(liveTime, TimeUnit.SECONDS);
        }

        return increment;
    }

    /**
     * 疯转Redis的get操作
     *
     * @param key
     * @return
     */
    public String get(Object key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    /**
     * 设置值
     *
     * @param key
     * @param value
     * @param liveTime
     */
    public void set(String key, String value, Long liveTime) {
        stringRedisTemplate.opsForValue().set(key, value, liveTime, TimeUnit.SECONDS);
    }

    /**
     * 设置永久值,先删再设置
     *
     * @param key
     * @param value
     */
    public void setForever(String key, String value) {
        stringRedisTemplate.delete(key);
        stringRedisTemplate.opsForValue().set(key, value);
    }

    /**
     * @description: 设置分布式锁
     * @auth: linqiang 544715485@qq.com
     * @date: 2018年12月12日 上午10:44:56
     * @param: NX，意思是SET IF NOT EXIST，即当key不存在时，我们进行set操作；若key已经存在，则不做任何操作；
     * @param: PX，意思是我们要给这个key加一个过期的设置，具体时间由第五个参数决定。
     * @return:
     */
    public Boolean setByLock(String key, String value, Long liveTime) {
        String result = jedisPool.getResource().set(key, value, "NX", "PX", liveTime);
        if ("OK".equals(result))
            return true;
        return false;
    }

    /**
     * @description: 用jedis删除
     * @auth: linqiang 544715485@qq.com
     * @date: 2018年12月20日 上午10:28:43
     * @param: @param key
     * @return: void
     */
    public void deleteLock(String key) {
        jedisPool.getResource().del(key);
    }
}
