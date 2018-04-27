package com.beini.service;

import java.util.List;

import com.beini.model.SimpleTable;

public interface SimpleTableService {
	boolean insertBatch(List<SimpleTable> members) throws Exception;
}
