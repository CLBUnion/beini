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
	/* 自定义 的缓存组件 */
	//@Resource(name="productServiceBeiniCache")
	/* spring boot data redis 的缓存组件 */
	@Resource(name = "productService")
	private ProductService productService;

	@GetMapping("get/{id}")
	public ProductVo getProduct(@PathVariable(name = "id") Integer id) {
		return productService.getProductById(id);
	}

	@GetMapping("update2/{id}")
	public ProductVo update2(@PathVariable(name = "id") Integer id) {
		return productService.updateProductById2(id);
	}

	@GetMapping("update/{id}")
	public ProductVo update(@PathVariable(name = "id") Integer id) {
		return productService.updateProductById(id);
	}
}
