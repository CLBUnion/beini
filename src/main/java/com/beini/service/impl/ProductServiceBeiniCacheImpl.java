package com.beini.service.impl;

import org.springframework.stereotype.Service;

import com.beini.cache.annotation.CacheKey;
import com.beini.cache.annotation.Cacheable;
import com.beini.cache.annotation.Cacheable.KeyMode;
import com.beini.service.ProductService;
import com.beini.vo.ProductVo;
@Service("productServiceBeiniCache")
public class ProductServiceBeiniCacheImpl implements ProductService{
	
	@Override
	public ProductVo getProductById(Integer id) {
		return null;
	}

	@Override
	@Cacheable(expire=360,keyMode=KeyMode.DEFAULT)
	public String getProductById2(@CacheKey Integer id) {
		String result = "刚才设置的ID为 : "+id;
		return result;
	}

}
