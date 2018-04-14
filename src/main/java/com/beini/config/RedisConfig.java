package com.beini.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {
	@Bean  
    @ConfigurationProperties(prefix = "spring.redis.pool")  
    public JedisPoolConfig getRedisConfig() {  
        JedisPoolConfig config = new JedisPoolConfig();  
        return config;  
    }  
  
    @Bean  
    @ConfigurationProperties(prefix = "spring.redis")
    public JedisConnectionFactory getConnectionFactory() {  
        JedisConnectionFactory factory = new JedisConnectionFactory();  
        factory.setUsePool(true);  
        JedisPoolConfig config = getRedisConfig();  
        factory.setPoolConfig(config);  
        return factory;  
    }  
  
  
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean  
    public RedisTemplate<?, ?> getRedisTemplate() {  
        RedisTemplate<?, ?> template = new StringRedisTemplate(getConnectionFactory());
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        template.setKeySerializer(jackson2JsonRedisSerializer);
        template.setValueSerializer(jackson2JsonRedisSerializer);
        return template;  
    }  
}
