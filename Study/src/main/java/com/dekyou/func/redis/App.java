package com.dekyou.func.redis;

import redis.clients.jedis.Jedis;

/**
 * @author GaoJing
 * @date 2018年4月24日
 * 
 */
public class App {
    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
        
        jedis.set("test", "name");
        System.out.println(jedis.get("test"));
    }
}

