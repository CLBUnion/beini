package com.beini.service;

import com.beini.vo.ProductVo;

public interface ProductService {
	
	ProductVo getProductById(Integer id);

	String getProductById2(Integer id);
}
