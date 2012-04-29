package com.xiu.open.platform.api.service;

import com.xiu.open.platform.domain.XopUser;

public interface XopUserService {
	
	XopUser queryXopUser(int userId);
	
	void insertXopUsere(XopUser xopUser);
}
