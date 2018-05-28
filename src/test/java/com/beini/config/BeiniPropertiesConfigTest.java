package com.beini.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.beini.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class BeiniPropertiesConfigTest {
	@Autowired
	private BeiniPropertiesConfig beiniPropertiesConfig;
	@Test
	public void readName() {
		System.out.println(beiniPropertiesConfig.getName());
	}
}
