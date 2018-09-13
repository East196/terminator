package com.github.east196.xcode.common;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;

public class MongoSpecificationExecutorImpl implements MongoSpecificationExecutor {
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public <T> List<T> findAll(List<SearchFilter> searchFilters, Class<T> entityClass) {
		return mongoTemplate.find(SearchFilter.bySearchFilter(searchFilters), entityClass);
	}

	@Override
	public <T> Page<T> findAll(List<SearchFilter> searchFilters, Pageable pageable, Class<T> entityClass) {
		Long total = mongoTemplate.count(SearchFilter.bySearchFilter(searchFilters), entityClass);
		List<T> content = total > pageable.getOffset()
				? mongoTemplate.find(SearchFilter.bySearchFilter(searchFilters).with(pageable), entityClass)
				: Collections.<T> emptyList();
		return new PageImpl<T>(content, pageable, total);
	}

}
