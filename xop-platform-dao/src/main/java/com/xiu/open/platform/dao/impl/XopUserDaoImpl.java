package com.xiu.open.platform.dao.impl;

import org.springframework.stereotype.Repository;

import com.xiu.open.platform.dao.BaseDao;
import com.xiu.open.platform.dao.XopUserDao;

@Repository(value="xopUserDao")
public class XopUserDaoImpl extends BaseDao implements XopUserDao {

	@Override
	public String getNameSpace() {
		return NAME_SPACE;
	}

}
