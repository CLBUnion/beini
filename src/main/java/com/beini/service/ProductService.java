package com.beini.service;

import com.beini.gen_entity.ProductEntity;
import com.beini.vo.ProductVo;

public interface ProductService {
	
	ProductVo getProductById(Integer id);
	ProductVo updateProductById(Integer id);
	ProductEntity updateProductById2(Integer id);
}
