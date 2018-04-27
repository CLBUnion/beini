package com.beini.thread;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.beini.cache.utils.BeiniAllRedisUtil;
@Component
public class SendThread {
	@Resource(name = "beiniRedisUtil")
	private BeiniAllRedisUtil redisUtil;
	
	public SendThread() {
		
	}
	public void execute() {
		new Worker().start();
	}
	
	 // 线程内部类，Thread或者Runnable均可
    private class Worker extends Thread {
        @Override
        public void run() {
        	for (int i = 1; i <= 1000; i++) {
    			redisUtil.lPush("mqs", "{'':"+i+",'':'中文名"+i+"','':englishName"+i+"}");
    		}
        }
    }
    
}
