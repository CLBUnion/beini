package com.beini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beini.gen_entity.ProductEntity;
import com.beini.service.ProductService;
import com.beini.vo.ProductVo;

@RestController
@RequestMapping("/")
public class ProductController {
	@Autowired
	private ProductService productService;
	@GetMapping("get/{id}")
	public ProductVo getProduct(@PathVariable(name="id") Integer id) {
		return productService.getProductById(id);
	}
	@GetMapping("update/{id}")
	public ProductVo updateProduct(@PathVariable(name="id") Integer id) {
		return productService.updateProductById(id);
	}
	@GetMapping("update2/{id}")
	public ProductEntity updateProduct2(@PathVariable(name="id") Integer id) {
		return productService.updateProductById2(id);
	}
}
