package com.beini.service.impl;

import org.springframework.stereotype.Service;

import com.beini.cache.annotation.CacheKey;
import com.beini.cache.annotation.Cacheable;
import com.beini.cache.annotation.Cacheable.KeyMode;
import com.beini.gen_entity.ProductEntity;
import com.beini.service.ProductService;
import com.beini.vo.ProductVo;

import lombok.extern.slf4j.Slf4j;
@Service("productServiceBeiniCache")
@Slf4j
@SuppressWarnings("deprecation")
public class ProductServiceBeiniCacheImpl implements ProductService{
	
	@Override
	@Cacheable(clazz = ProductVo.class)
	public ProductVo getProductById(@CacheKey Integer id) {
		log.info("==>从数据库取数据ProductServiceBeiniCacheImpl.getProductById(id)" + System.currentTimeMillis());
		ProductVo p = new ProductVo(id, id + "getProductById" + System.currentTimeMillis());
		System.out.println(p);
		return p;
	}

	@Override
	public ProductVo updateProductById(Integer id) {
		return null;
	}

	@Override
	public ProductVo updateProductById2(Integer id) {
		return null;
	}

	@Override
	@Cacheable(expire=360,keyMode=KeyMode.DEFAULT, clazz = ProductEntity.class)
	public ProductEntity updateProductById3(Integer id) {
		return null;
	}

}
