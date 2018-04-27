package com.beini.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.beini.cache.utils.BeiniAllRedisUtil;
import com.beini.thread.SendThread;

@Controller
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
}
