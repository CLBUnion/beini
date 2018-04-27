package com.beini.service;

import com.beini.gen_entity.ProductEntity;
import com.beini.vo.ProductVo;

public interface ProductService {

	ProductVo getProductById(Integer id);
	/**
	 * 有更新则删除缓存(下次需要再次查询数据库)
	 * @param id
	 * @return
	 */
	ProductVo updateProductById(Integer id);
	/**
	 * 直接重设缓存(下次不需要再次查询数据库)
	 * @param id
	 * @return
	 */
	ProductVo updateProductById2(Integer id);

	ProductEntity updateProductById3(Integer id);
}
