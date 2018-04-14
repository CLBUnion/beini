package com.beini.controller;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beini.gen_entity.ProductBrand;
/**
 * 基本的控制器类
 * @author lb_chen
 */
@RestController
public class BaseController {
	@GetMapping("/demo")
	public String demo2(@Valid ProductBrand productBrand, BindingResult result) {
		StringBuffer bf = new StringBuffer();
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				bf.append(error.getDefaultMessage());
				bf.append("<br>");
			}
		}
		return bf.toString();
	}
}
