package util;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Properties;
import java.util.ResourceBundle;

/**
 * @author EnochStar
 * @title: JedisUtils
 * @projectName jedis_use
 * @description: TODO
 * @date 2021/3/4 19:41
 */
public class JedisUtils {
    private static JedisPool jedisPool = null;
    private static String host = null;
    private static Integer port = null;
    private static Integer maxTotal = null;
    private static Integer maxIdle = null;

    static {
        ResourceBundle rb = ResourceBundle.getBundle("redis");
        host = rb.getString("redis.host");
        port = Integer.parseInt(rb.getString("redis.port"));
        maxTotal = Integer.parseInt(rb.getString("redis.maxTotal"));
        maxIdle = Integer.parseInt(rb.getString("redis.maxIdle"));

        GenericObjectPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(maxTotal);
        poolConfig.setMaxIdle(maxIdle);
        jedisPool = new JedisPool(poolConfig, host, port);
    }
    public static Jedis getJedis() {
        return jedisPool.getResource();
    }
}
