package com.xiu.open.platform.common;

import java.util.HashMap;
import java.util.Map;

public class BaseDomain implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 动态字段. 在ibatis文件中可用“dynamicFields.xxx”方式读取动态字段值
	 */
	protected Map<String, Object> dynamicFields = new HashMap<String, Object>();

	/** 最大行数. */
	private static final int MAX_ROWS = 9999999;

	Integer id;
	/**
	 * 返回结果
	 */
	Integer result;

	/** 起始行数（oracle物理行号从1开始）. */
	private int start = 1;

	/**
	 * 结束行数（如果不设置结束行，缺省查所有满足条件记录）.
	 */
	private int end = MAX_ROWS;

	/**
	 * 排序字段(例sp.spCode).
	 */
	private String sort;

	/**
	 * 正序|反序(例ASC).
	 */
	private String order;

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 设置动态字段值.
	 * 
	 * @param fieldName
	 *            字段名称
	 * @param value
	 *            字段值
	 */
	public void setField(String fieldName, Object value) {
		dynamicFields.put(fieldName, value);
	}

	/**
	 * 返回动态字段值.
	 * 
	 * @param fieldName
	 *            字段名称
	 * @return 对象
	 */
	public Object getField(String fieldName) {
		if (dynamicFields == null) {
			return null;
		}
		return dynamicFields.get(fieldName);
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

}
