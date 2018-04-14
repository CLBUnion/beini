package com.beini.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beini.service.ProductService;
import com.beini.vo.ProductVo;

@RestController
@RequestMapping("/")
public class ProductController {
	@Qualifier
	@Resource(name="productServiceBeiniCache")
	private ProductService productService;
	@GetMapping("get/{id}")
	public ProductVo getProduct(@PathVariable(name="id") Integer id) {
		return productService.getProductById(id);
	}

	@GetMapping("get2/{id}")
	public String get2(@PathVariable(name="id") Integer id) {
		return productService.getProductById2(id);
	}
}
