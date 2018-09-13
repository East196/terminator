package com.github.east196.xcode.common;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MongoSpecificationExecutor {

	<T> List<T> findAll(List<SearchFilter> searchFilters, Class<T> entityClass);

	<T> Page<T> findAll(List<SearchFilter> searchFilters, Pageable pageable, Class<T> entityClass);
}
