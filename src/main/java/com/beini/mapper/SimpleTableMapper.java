package com.beini.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.beini.model.SimpleTable;

@Mapper
public interface SimpleTableMapper {
	int insertBatch(List<SimpleTable> list);
	
}
