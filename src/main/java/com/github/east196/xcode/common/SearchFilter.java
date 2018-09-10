package com.github.east196.xcode.common;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class SearchFilter {

	public enum Operator {
		EQ,

		LIKE,

		GT,

		LT,

		GTE,

		LTE,

		IN;
	}

	public String fieldName;

	public Object value;

	public SearchFilter.Operator operator;

	public SearchFilter(final String fieldName, final SearchFilter.Operator operator, final Object value) {
		this.fieldName = fieldName;
		this.value = value;
		this.operator = operator;
	}

	public static Map<String, SearchFilter> parse(final Map<String, Object> searchParams) {
		final HashMap<String, SearchFilter> filters = Maps.<String, SearchFilter> newHashMap();
		Set<Map.Entry<String, Object>> _entrySet = searchParams.entrySet();
		for (final Map.Entry<String, Object> entry : _entrySet) {
			final String key = entry.getKey();
			final Object value = entry.getValue();
			boolean _isNotBlank = StringUtils.isNotBlank(((String) value));
			if (_isNotBlank) {
				final String[] names = StringUtils.split(key, "_");
				int _length = names.length;
				boolean _notEquals = (_length != 2);
				if (_notEquals) {
					throw new IllegalArgumentException((key + " is not a valid search filter name"));
				}
				final String filedName = names[1];
				String _get = names[0];
				final SearchFilter.Operator operator = SearchFilter.Operator.valueOf(_get);
				final SearchFilter filter = new SearchFilter(filedName, operator, value);
				filters.put(key, filter);
			}
		}
		return filters;
	}

	public static <T> List<SearchFilter> from(final Map<String, String[]> requestParameterMap,
			final Class<T> entityClass) {
		Map<String, String[]> parameterMap = new HashMap<String, String[]>();
		for (java.util.Map.Entry<String, String[]> e : requestParameterMap.entrySet()) {
			// 筛选搜索条件
			if (!e.getKey().equals("_") && e.getKey().contains("_")) {
				parameterMap.put(e.getKey(), e.getValue());
			}
		}

		// 获取类属性名称与类型
		final Map<String, Type> fieldTypes = new HashMap<>();
		Field[] fields = entityClass.getDeclaredFields();
		for (Field field : fields) {
			fieldTypes.put(field.getName().toLowerCase(), field.getGenericType());
		}

		List<SearchFilter> _xblockexpression = null;
		{
			Set<Map.Entry<String, String[]>> _entrySet = parameterMap.entrySet();
			final Function<Map.Entry<String, String[]>, SearchFilter> _function = new Function<Map.Entry<String, String[]>, SearchFilter>() {
				@Override
				public SearchFilter apply(final Map.Entry<String, String[]> entry) {
					SearchFilter filter = null;
					final String key = entry.getKey();
					String[] _value = entry.getValue();
					String value = _value[0];
					boolean _isNotBlank = StringUtils.isNotBlank(value);
					if (_isNotBlank) {
						final String[] names = StringUtils.split(key, "_");
						int _length = names.length;
						boolean _notEquals = (_length != 2);
						if (_notEquals) {
							throw new IllegalArgumentException((key + " is not a valid search filter name"));
						}
						Object object = value;
						Type type = fieldTypes.get(names[0].toLowerCase());
						if (null != type) {
							if (type.toString().equals("class java.util.Date")) {
								object = Easy.praseDate(value);
							} else if (type.toString().equals("class java.lang.Boolean")) {
								object = Boolean.parseBoolean(value);
							} else if (type.toString().equals("class java.lang.Integer") && !"null".equals(value)) {
								object = Integer.parseInt(value);
							} else if (type.toString().equals("class java.lang.Double")) {
								object = Double.parseDouble(value);
							} else if (type.toString().equals("class java.lang.Long")) {
								object = Long.parseLong(value);
							}
						}
						final String filedName = names[0];
						String _get = names[1];
						String _upperCase = _get.toUpperCase();
						final SearchFilter.Operator operator = SearchFilter.Operator.valueOf(_upperCase);
						SearchFilter _searchFilter = new SearchFilter(filedName, operator, object);
						filter = _searchFilter;
					}
					return filter;
				}
			};
			Collection<SearchFilter> _map = Collections2.<Map
					.Entry<String, String[]>, SearchFilter> transform(_entrySet, _function);
			Predicate<SearchFilter> nullFilter = new Predicate<SearchFilter>() {
				@Override
				public boolean apply(SearchFilter input) {
					return input != null;
				}
			};
			Collection<SearchFilter> _filterNull = Collections2.<SearchFilter> filter(_map, nullFilter);
			_xblockexpression = Lists.newArrayList(_filterNull);
		}
		return _xblockexpression;
	}

	public static <T> List<SearchFilter> fromQueryMap(final Map<String, String> queryMap, final Class<T> entityClass) {
		Map<String, String> parameterMap = new HashMap<String, String>();
		for (java.util.Map.Entry<String, String> e : queryMap.entrySet()) {
			// 筛选搜索条件
			if (!e.getKey().equals("_") && e.getKey().contains("_")) {
				parameterMap.put(e.getKey(), e.getValue());
			}
		}

		// 获取类属性名称与类型
		final Map<String, Type> fieldTypes = new HashMap<>();
		Field[] fields = entityClass.getDeclaredFields();
		for (Field field : fields) {
			fieldTypes.put(field.getName().toLowerCase(), field.getGenericType());
		}

		List<SearchFilter> _xblockexpression = null;
		{
			Set<Map.Entry<String, String>> _entrySet = parameterMap.entrySet();
			final Function<Map.Entry<String, String>, SearchFilter> _function = new Function<Map.Entry<String, String>, SearchFilter>() {
				@Override
				public SearchFilter apply(final Map.Entry<String, String> entry) {
					SearchFilter filter = null;
					final String key = entry.getKey();
					String value = entry.getValue();
					boolean _isNotBlank = StringUtils.isNotBlank(value);
					if (_isNotBlank) {
						final String[] names = StringUtils.split(key, "_");
						int _length = names.length;
						boolean _notEquals = (_length != 2);
						if (_notEquals) {
							throw new IllegalArgumentException((key + " is not a valid search filter name"));
						}
						Object object = value;
						Type type = fieldTypes.get(names[0].toLowerCase());
						if (null != type) {
							if (type.toString().equals("class java.util.Date")) {
								object = Easy.praseDate(value);
							} else if (type.toString().equals("class java.lang.Boolean")) {
								object = Boolean.parseBoolean(value);
							} else if (type.toString().equals("class java.lang.Integer") && !"null".equals(value)) {
								object = Integer.parseInt(value);
							} else if (type.toString().equals("class java.lang.Double")) {
								object = Double.parseDouble(value);
							} else if (type.toString().equals("class java.lang.Long")) {
								object = Long.parseLong(value);
							}
						}
						final String filedName = names[0];
						String _get = names[1];
						String _upperCase = _get.toUpperCase();
						final SearchFilter.Operator operator = SearchFilter.Operator.valueOf(_upperCase);
						SearchFilter _searchFilter = new SearchFilter(filedName, operator, object);
						filter = _searchFilter;
					}
					return filter;
				}
			};
			Collection<SearchFilter> _map = Collections2.<Map.Entry<String, String>, SearchFilter> transform(_entrySet,
					_function);
			Predicate<SearchFilter> nullFilter = new Predicate<SearchFilter>() {
				@Override
				public boolean apply(SearchFilter input) {
					return input != null;
				}
			};
			Collection<SearchFilter> _filterNull = Collections2.<SearchFilter> filter(_map, nullFilter);
			_xblockexpression = Lists.newArrayList(_filterNull);
		}
		return _xblockexpression;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	public static Query bySearchFilter(final Collection<SearchFilter> filters) {
		Query query = new Query();
		Map<String, Criteria> criteriaMap = new HashMap<>();
		if (Easy.notEmpty(filters)) {
			Criteria criteria = null;
			Criteria old = null;
			for (SearchFilter filter : filters) {
				// 查询空值
				if ("null".equals(filter.value)) {
					filter.value = null;
					filter.operator = Operator.EQ;
				}

				switch (filter.operator) {
				case EQ:
					criteria = Criteria.where(filter.fieldName).is(filter.value);
					criteriaMap.put(criteria.getKey(), criteria);
					break;
				case LIKE:
					criteria = Criteria.where(filter.fieldName).regex(String.valueOf(filter.value));
					criteriaMap.put(criteria.getKey(), criteria);
					break;
				case GT:
					criteria = Criteria.where(filter.fieldName).gt(filter.value);
					old = criteriaMap.get(criteria.getKey());
					if (null != old) {
						criteriaMap.put(criteria.getKey(), new Criteria().andOperator(criteria, old));
					} else {
						criteriaMap.put(criteria.getKey(), criteria);
					}
					break;
				case LT:
					criteria = Criteria.where(filter.fieldName).lt(filter.value);
					old = criteriaMap.get(criteria.getKey());
					if (null != old) {
						criteriaMap.put(criteria.getKey(), new Criteria().andOperator(criteria, old));
					} else {
						criteriaMap.put(criteria.getKey(), criteria);
					}
					break;
				case GTE:
					criteria = Criteria.where(filter.fieldName).gte(filter.value);
					old = criteriaMap.get(criteria.getKey());
					if (null != old) {
						criteriaMap.put(criteria.getKey(), new Criteria().andOperator(criteria, old));
					} else {
						criteriaMap.put(criteria.getKey(), criteria);
					}
					break;
				case LTE:
					criteria = Criteria.where(filter.fieldName).lte(filter.value);
					old = criteriaMap.get(criteria.getKey());
					if (null != old) {
						criteriaMap.put(criteria.getKey(), new Criteria().andOperator(criteria, old));
					} else {
						criteriaMap.put(criteria.getKey(), criteria);
					}
					break;
				case IN:
					if (Easy.notEmpty(filter.value)) {
						if (filter.value instanceof Collection) {
							criteria = Criteria.where(filter.fieldName).in((Collection<?>) filter.value);
							old = criteriaMap.get(criteria.getKey());
							if (null != old) {
								criteriaMap.put(criteria.getKey(), new Criteria().andOperator(criteria, old));
							} else {
								criteriaMap.put(criteria.getKey(), criteria);
							}

						}
					}
					break;
				}
			}

			for (Entry<String, Criteria> entry : criteriaMap.entrySet()) {
				query.addCriteria(entry.getValue());
				System.out.println("key=" + entry.getKey() + ",value=" + entry.getValue());
			}
			System.out.println(query.getQueryObject().toString());
		}
		return query;
	}

	public static PageRequest sort(final Map<String, String[]> requestParameterMap, Integer start, Integer length) {
		PageRequest pageRequest = null;
		if (requestParameterMap.containsKey("order[0][dir]")) {
			String[] sorts = requestParameterMap.get("order[0][dir]");
			String[] columns = requestParameterMap.get("order[0][column]");
			String columName = requestParameterMap.get("columns[" + columns[0] + "][data]")[0];
			pageRequest = new PageRequest(start / length, length,
					sorts[0].equals("asc") ? Direction.ASC : Direction.DESC, columName);
		} else {
			pageRequest = new PageRequest(start / length, length);
		}
		return pageRequest;
	}

	public static PageRequest sortQueryMap(final Map<String, String> queryMap, Integer start, Integer length) {
		PageRequest pageRequest = null;
		if (queryMap.containsKey("order[0][dir]")) {
			String sort = queryMap.get("order[0][dir]");
			String column = queryMap.get("order[0][column]");
			String columName = queryMap.get("columns[" + column + "][data]");
			pageRequest = new PageRequest(start / length, length, sort.equals("asc") ? Direction.ASC : Direction.DESC,
					columName);
		} else {
			pageRequest = new PageRequest(start / length, length);
		}
		return pageRequest;
	}

}
