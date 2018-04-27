package com.beini.service;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.beini.Application;
import com.beini.cache.utils.BeiniAllRedisUtil;
import com.beini.model.SimpleTable;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class InsertCacheTest {
	@Resource(name = "beiniRedisUtil")
	private BeiniAllRedisUtil redisUtil;

	public void test1() {
		long begin = 0, end = 0;
		begin = new Date().getTime();
		for (int i = 1; i <= 100000; i++) {
			redisUtil.lPush("mqs", "" + (i + 300000));
		}
		end = new Date().getTime();
		System.out.println((end - begin) + "---------------------------------------------------------------- s");
	}

	@Test
	public void testJson() {
		int i = 10;
		String json = "{\"name\":\"zw"+i+"\",\"nameEn\":\"ew"+i+"\",\"runType\":"+i+"}";
		SimpleTable st = (SimpleTable) JSON.parse(json);
		System.out.println(st);
		
		SimpleTable st1 = new SimpleTable(10, "zw10", "ew10");
		System.out.println(JSON.toJSONString(st1));
	}
}
