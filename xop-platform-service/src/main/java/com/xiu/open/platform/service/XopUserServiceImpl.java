package com.xiu.open.platform.service;

import org.springframework.osgi.extensions.annotation.ServiceReference;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xiu.open.platform.api.service.XopUserService;
import com.xiu.open.platform.dao.XopUserDao;
import com.xiu.open.platform.domain.XopUser;

@Service(value="xopUserService")
public class XopUserServiceImpl  implements XopUserService{

	private XopUserDao xopUserDao;

	@ServiceReference
	public void setComputeService(XopUserDao xopUserDao) {
		// 通过springdm注入service
		this.xopUserDao = xopUserDao;
	}
	
	public XopUser queryXopUser(int userId) {
		
		return xopUserDao.find(String.valueOf(userId));
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public void insertXopUsere(XopUser xopUser) {
		xopUserDao.insert(xopUser);
//		if(1==1){
//			throw new IllegalArgumentException("手动抛异常，测试事务");
//		}
	}

}
