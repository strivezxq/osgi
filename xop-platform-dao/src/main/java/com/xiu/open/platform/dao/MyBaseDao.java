package com.xiu.open.platform.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.dao.DataAccessException;

import com.xiu.open.platform.domain.BaseDomain;

public abstract class MyBaseDao extends SqlSessionDaoSupport implements IDao {

	public <T> Long insert(T t) throws DataAccessException {
		Long keyId = Long.valueOf(this.getSqlSession().insert(
				getNameSpace(), t));
		return keyId;
	}

	public Integer delete(String keyId) throws DataAccessException {
		return null;
	}

	public <T> Integer update(T t) throws DataAccessException {
		return this.getSqlSession().update(this.getNameSpace() + ".update", t);
	}

	public <T> T find(String keyId) throws DataAccessException {
		T t = (T) this.getSqlSession().selectOne(this.getNameSpace() + ".find",
				keyId);
		return t;
	}

	public <T> List<T> listForObject(T t) throws DataAccessException {
		return null;
	}

	public <T> Integer countForObject(T t) throws DataAccessException {
		return null;
	}

	public <T extends BaseDomain> List<T> insertBatch(List<T> t) {
		return null;
	}

	public <T extends BaseDomain> List<T> updateBatch(List<T> t) {
		return null;
	}

	public <T extends BaseDomain> List<T> updateBatch(List<T> t,
			String updateSqlId) {
		return null;
	}

	public abstract String getNameSpace();
}
