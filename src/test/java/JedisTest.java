import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @author EnochStar
 * @title: JedisTest
 * @projectName jedis_use
 * @description: TODO
 * @date 2021/3/4 16:04
 */

public class JedisTest {
    @Test
    public void testJedis(){
        // 连接Redis
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        // 操作
        jedis.set("name","enoch");
        System.out.println(jedis.get("name"));
        // 关闭
        jedis.close();
    }
}
