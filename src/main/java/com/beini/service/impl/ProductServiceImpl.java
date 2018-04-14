package com.beini.service.impl;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.beini.service.ProductService;
import com.beini.vo.ProductVo;

import lombok.extern.slf4j.Slf4j;

@Service("productService")
@Slf4j
@CacheConfig(cacheNames="product")
public class ProductServiceImpl implements ProductService {

	@Override
	@Cacheable(key="#id")
	//@Cacheable(key="123")
	public ProductVo getProductById(Integer id) {
		log.info("==>从数据库取数据ProductServiceImpl.getProductById(id)"+System.currentTimeMillis());
		ProductVo p = new ProductVo(id, id + "getProductById"+System.currentTimeMillis());
		System.out.println(p);
		 return p;
	}

	@Override
	@Cacheable(key = "#id")
	public String getProductById2(Integer id) {
		log.info("==>从数据库取数据ProductServiceImpl.getProductById2(id)" + System.currentTimeMillis());
		ProductVo p = new ProductVo(id, id + "getProductById2" + System.currentTimeMillis());
		System.out.println(p.toString());
		return p.toString();
	}

//	@Override
//	@CachePut(key="#id")
//	//@CachePut(key="123")
//	/*剔除数据缓存*/
//	//@CacheEvict(key="123")
//	public ProductVo updateProductById(Integer id) {
//		log.info("==>从数据库更新数据ProductServiceImpl.updateProductById(id)"+System.currentTimeMillis());
//		
//		
//		return new ProductVo(id, id + "updateProductById"+System.currentTimeMillis());
//	}
//
//	@Override
//	/*切记对象返回一致*/
//	@CachePut(key="#id")
//	public ProductEntity updateProductById2(Integer id) {
//		log.info("==>XXXXXXXXXXProductServiceImpl.updateProductById2(id)"+System.currentTimeMillis());
//		
//		ProductEntity p = new ProductEntity(id, id + "XXXXXXXXXX"+System.currentTimeMillis());
//		System.out.println(p);
//		return p;
//	}
//
//	@Override
//	public ProductVo getProductByMap(Map<String, Object> map) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String getCache(Integer id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
