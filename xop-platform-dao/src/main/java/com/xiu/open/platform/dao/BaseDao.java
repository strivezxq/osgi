package com.xiu.open.platform.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.xiu.open.platform.domain.BaseDomain;


public abstract class BaseDao extends SqlMapClientDaoSupport implements com.xiu.open.platform.dao.IDao{
	
	private final static String SQL_ID_UPDATE = "update";
	
	@Autowired
	public void setSqlMapClientBase(SqlMapClient sqlMapClient) {
		super.setSqlMapClient(sqlMapClient); 
	} 
	
	public <T> Integer countForObject(T t) throws DataAccessException {
		Integer count=(Integer)getSqlMapClientTemplate().queryForObject(getNameSpace() + ".countForObject", t);
		return count;
	}
	
	public Integer delete() throws DataAccessException {
		return getSqlMapClientTemplate().delete(getNameSpace() + ".delete");
	}

	public Integer delete(String keyId) throws DataAccessException {
		return getSqlMapClientTemplate().delete(getNameSpace() + ".delete", keyId);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T find(String keyId) throws DataAccessException {
		T t=  (T)getSqlMapClientTemplate().queryForObject(getNameSpace() + ".find", keyId);
		return t;
	}

	public <T> Long insert(T t) throws DataAccessException {
		return (Long)getSqlMapClientTemplate().insert(getNameSpace() + ".insert", t);
	}
	
    @SuppressWarnings("unchecked")
	public <T> List<T> listForObject(T t) throws DataAccessException {
		List<T> list=  getSqlMapClientTemplate().queryForList(getNameSpace() + ".listForObject", t);
		return list;
	}

	public <T> Integer update(T t) throws DataAccessException {
		return getSqlMapClientTemplate().update(getNameSpace() + ".update", t);

	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T  extends BaseDomain> List<T> insertBatch(final List<T>  t){
		final int size = t.size();
		return null;
	}
	
	public <T  extends BaseDomain> List<T> updateBatch(final List<T>  t){
		return  updateBatch(t, SQL_ID_UPDATE);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T  extends BaseDomain> List<T> updateBatch(final List<T>  t, final String updateSqlId){
		return (List<T>)getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
			public List<T> doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
				int div = 1000;
				int count = 0;
				executor.startBatch();
				for (BaseDomain baseDomain: t) {
					int result = executor.update(getNameSpace()+"."+updateSqlId, baseDomain);
					baseDomain.setResult(result);
					count++;
					if (count == div) {
						executor.executeBatch();
						executor.startBatch();
						count = 0;
					}
				}
				executor.executeBatch();
				return t;
			}
		});
	}

	public abstract String getNameSpace();
	
}
