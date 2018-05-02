package com.beini.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beini.cache.utils.BeiniAllRedisUtil;
import com.beini.model.SimpleTable;
import com.beini.thread.SendThread;

@RestController
public class MQController {
	@Autowired
	private SendThread sendThread;
	
	@Resource(name = "beiniRedisUtil")
	private BeiniAllRedisUtil redisUtil;

	@GetMapping("/mqs")
	public String mqs() {
		long begin = 0, end = 0;
		begin = new Date().getTime();
		for (int i = 1; i <= 100; i++) {
			sendThread.execute();
		}
		end = new Date().getTime();
		System.out.println((end - begin) + "---------------------------------------------------------------- s");
		return "success";
	}
	@GetMapping("/mqtest")
	public String mqtest() {
		redisUtil.hset("simpleTable","1", new SimpleTable(1,"张三","zhangsan"));
		return "mqtest";
	}
}
