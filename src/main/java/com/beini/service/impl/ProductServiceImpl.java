package com.beini.service.impl;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.beini.gen_entity.ProductEntity;
import com.beini.service.ProductService;
import com.beini.vo.ProductVo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@CacheConfig(cacheNames="product")
public class ProductServiceImpl implements ProductService {

	@Override
	@Cacheable(key="#id")
	//@Cacheable(key="123")
	public ProductVo getProductById(Integer id) {
		log.info("==>从数据库取数据ProductServiceImpl.getProductById(id)"+System.currentTimeMillis());
		return new ProductVo(id, id + "getProductById"+System.currentTimeMillis());
	}

	@Override
	@CachePut(key="#id")
	//@CachePut(key="123")
	/*剔除数据缓存*/
	//@CacheEvict(key="123")
	public ProductVo updateProductById(Integer id) {
		log.info("==>从数据库更新数据ProductServiceImpl.updateProductById(id)"+System.currentTimeMillis());
		return new ProductVo(id, id + "updateProductById"+System.currentTimeMillis());
	}

	@Override
	/*切记对象返回一致*/
	//@CachePut(key="123")
	public ProductEntity updateProductById2(Integer id) {
		log.info("==>XXXXXXXXXXProductServiceImpl.updateProductById2(id)"+System.currentTimeMillis());
		return new ProductEntity(id, id + "XXXXXXXXXX"+System.currentTimeMillis());
	}

}
