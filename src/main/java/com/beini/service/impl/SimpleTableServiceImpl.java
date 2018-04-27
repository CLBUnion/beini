package com.beini.service.impl;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import com.beini.mapper.SimpleTableMapper;
import com.beini.model.SimpleTable;
import com.beini.service.SimpleTableService;

@Service
@CacheConfig(cacheNames = "simpleTable")
public class SimpleTableServiceImpl implements SimpleTableService {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public boolean insertBatch(List<SimpleTable> members) throws Exception {
		int result = 1;
		SqlSession batchSqlSession = null;
		try {
			// 获取批量方式的sqlsession
			batchSqlSession = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);
			// 通过新的session获取mapper
			SimpleTableMapper mapper = batchSqlSession.getMapper(SimpleTableMapper.class);
			// 每批commit的个数
			int batchCount = 800;
			// 每批最后一个的下标
			int batchLastIndex = batchCount;
			for (int index = 0; index < members.size();) {
				if (batchLastIndex >= members.size()) {
					batchLastIndex = members.size();
					result = result + mapper.insertBatch(members.subList(index, batchLastIndex));
					batchSqlSession.commit();
					// 清理缓存，防止溢出
					batchSqlSession.clearCache();
					System.out.println("index:" + index + " batchLastIndex:" + batchLastIndex);
					// 数据插入完毕，退出循环
					break;
				} else {
					result = result + mapper.insertBatch(members.subList(index, batchLastIndex));
					batchSqlSession.commit();
					// 清理缓存，防止溢出
					batchSqlSession.clearCache();
					System.out.println("index:" + index + " batchLastIndex:" + batchLastIndex);
					// 设置下一批下标
					index = batchLastIndex;
					batchLastIndex = index + (batchCount - 1);
				}
				System.out.println("=============>result=[" + result + "] begin=[" + index + "] end=[" + batchLastIndex + "]");
			}
			batchSqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			batchSqlSession.close();
		}
		return true;
	}
}
