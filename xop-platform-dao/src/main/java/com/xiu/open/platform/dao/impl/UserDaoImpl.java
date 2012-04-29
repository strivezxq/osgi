package com.xiu.open.platform.dao.impl;

import com.xiu.open.platform.dao.MyBaseDao;
import com.xiu.open.platform.dao.XopUserDao;

public class UserDaoImpl extends MyBaseDao implements XopUserDao {

	public String getNameSpace() {
		return NAME_SPACE;
	}

}
