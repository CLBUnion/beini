package com.beini.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.beini.Application;
import com.beini.model.SimpleTable;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class SimpleTableServiceTest {
	@Autowired
	private SimpleTableService simpleTableService;

	@Test
	public void getListDatas() throws Exception {
		List<SimpleTable> list = new ArrayList<>();
		SimpleTable otype = null;
		long begin =0,end = 0;
		begin = new Date().getTime();
		for (int i = 1; i <= 100000; i++) {
			otype = new SimpleTable();
			otype.setRunType(i);
			otype.setName("名称" + i);
			otype.setNameEn("nameEn" + i);
			list.add(otype);
		}
		simpleTableService.insertBatch(list);
		end = new Date().getTime();
		System.out.println(end-begin);
	}
	
	@Test
	public void insertDB() throws Exception {
		List<SimpleTable> list = new ArrayList<>();
		SimpleTable otype = null;
		long begin =0,end = 0;
		begin = new Date().getTime();
		for (int i = 1; i <= 100000; i++) {
			otype = new SimpleTable();
			otype.setRunType(i);
			otype.setName("名称" + i);
			otype.setNameEn("nameEn" + i);
			list.add(otype);
		}
		simpleTableService.insertBatch(list);
		end = new Date().getTime();
		System.out.println(end-begin);
	}
}
