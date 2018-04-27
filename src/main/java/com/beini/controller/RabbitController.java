package com.beini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beini.util.rabbitSender.RabbitSender1;

@RestController
@RequestMapping("/rabbit")
public class RabbitController {
	@Autowired
	private RabbitSender1 helloSender1;

	@GetMapping("/hello")
	public void hello() {
		helloSender1.send();
	}
}
