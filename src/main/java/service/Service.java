package service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisDataException;
import util.JedisUtils;

/**
 * @author EnochStar
 * @title: Service
 * @projectName jedis_use
 * @description: TODO
 * @date 2021/3/4 16:14
 */
public class Service {
    String id;
    int num;
    public Service(String id,int num) {
        this.id = id;
        this.num = num;
    }

    // 控制执行次数
    public void service() {
        // Jedis jedis = new Jedis("127.0.0.1", 6379);
        Jedis jedis = JedisUtils.getJedis();
        String value = jedis.get("comid:" + id);
        try {
            if (value == null) {
                //创建
                jedis.setex("comid:" + id, 20, Long.MAX_VALUE - num + "");
            } else {
                // 自增，调用业务
                long val = jedis.incr("comid:" + id);
                business(id,num - (Long.MAX_VALUE - val));
            }
        } catch (JedisDataException e) {
            System.out.println("使用已达上限，请升级会员");
            return;
        } finally {
            jedis.close();
        }
    }

    public void business(String id,long val) {
        System.out.println("用户:" + id + "业务操作执行" + val + "次");
    }
}
