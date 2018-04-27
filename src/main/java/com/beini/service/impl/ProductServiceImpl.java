package com.beini.service.impl;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.beini.gen_entity.ProductEntity;
import com.beini.service.ProductService;
import com.beini.vo.ProductVo;

import lombok.extern.slf4j.Slf4j;
/**
 * spring boot data redis 的缓存组件
 * @author lb_chen
 */
@Service("productService")
@Slf4j
@CacheConfig(cacheNames="product",cacheManager="",cacheResolver="",keyGenerator="")
public class ProductServiceImpl implements ProductService {

	@Override
	/*key值为：product_id值*/
	@Cacheable(key="'product_'+#id")
	/*key值为：类名.方法名:参数值-*/
	//@Cacheable
	public ProductVo getProductById(Integer id) {
		log.info("==>从数据库取数据ProductServiceImpl.getProductById(id)" + System.currentTimeMillis());
		ProductVo p = new ProductVo(id, id + "getProductById" + System.currentTimeMillis());
		System.out.println(p);
		return p;
	}

	@Override
	@CacheEvict(key="'product_'+#id")
	public ProductVo updateProductById(Integer id) {
		log.info("==>从数据库更新数据ProductServiceImpl.updateProductById(id)" + System.currentTimeMillis());
		return new ProductVo(id, id + "updateProductById" + System.currentTimeMillis());
	}
	
	@Override
	@CachePut(key="'product_'+#id")
	public ProductVo updateProductById2(Integer id) {
		log.info("==>从数据库取数据ProductServiceImpl.getProductById2(id)" + System.currentTimeMillis());
		ProductVo p = new ProductVo(id, id + "getProductById2" + System.currentTimeMillis());
		return p;
	}
	/**
	 * 一般不使用此方式
	 */
	@Override
	@CachePut
	public ProductEntity updateProductById3(Integer id) {
		log.info("==>XXXXXXXXXXProductServiceImpl.updateProductById2(id)" + System.currentTimeMillis());
		ProductEntity p = new ProductEntity(id, id + "XXXXXXXXXX" + System.currentTimeMillis());
		System.out.println(p);
		return p;
	}

}
