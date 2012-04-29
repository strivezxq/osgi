package com.xiu.open.platform.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.osgi.framework.Bundle;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceReference;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.osgi.test.AbstractConfigurableBundleCreatorTests;
import org.springframework.osgi.test.platform.Platforms;

import com.xiu.open.platform.common.XopConfigurableBundleContant;
import com.xiu.open.platform.dao.XopUserDao;
import com.xiu.open.platform.domain.XopUser;

public class XopUserDaoOsgiTest extends AbstractConfigurableBundleCreatorTests {

	@Override
	protected String[] getTestBundlesNames() {
		 String[] xopNames = {	
				"com.xiu.open.platform,  xop-platform-dao, 2.5.0"};
		 String[] bundelesNames = new String[XopConfigurableBundleContant.bundlesNames.length+xopNames.length];
		 System.arraycopy(XopConfigurableBundleContant.bundlesNames, 0 ,bundelesNames, 0,  XopConfigurableBundleContant.bundlesNames.length); 
		 System.arraycopy(xopNames, 0 ,bundelesNames, XopConfigurableBundleContant.bundlesNames.length,  xopNames.length); 
		 return bundelesNames;
	}
	
	@Override
	protected String[] getConfigLocations() {
		  return new String[] {"META-INF/spring/*.xml"};
		}
	
	@Override
	protected String getPlatformName() {
	   return Platforms.EQUINOX;
	}
	
	public void testOsgiPlatformStarts() throws Exception {
		System.out.println(bundleContext
				.getProperty(Constants.FRAMEWORK_VENDOR));
		System.out.println(bundleContext
				.getProperty(Constants.FRAMEWORK_VERSION));
		System.out.println(bundleContext
				.getProperty(Constants.FRAMEWORK_EXECUTIONENVIRONMENT));
	}
	
	public void testIntegration() {
		boolean bundleIsHereAndStarted = false;
		for(Bundle currentBundle :		bundleContext.getBundles()) {
			if("com.xiu.open.platform.dao".equals(currentBundle.getSymbolicName()) 
					&& currentBundle.getState() == Bundle.ACTIVE) {
				bundleIsHereAndStarted = true;
				break;
			}
		}
		assertTrue("xop-platform-dao is not installed nor activated!",bundleIsHereAndStarted);
	}

	public void testFile() throws IOException {
		File directory = bundleContext.getDataFile("/data");
		if (!directory.exists()) {
			directory.mkdir();
		}
		File file = bundleContext.getDataFile("/data/test.txt");
		FileWriter writer = null;
		try {
			writer = new FileWriter(file, true);
			writer.write("my content");
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}
	
	public void testXopUserDao(){
		ServiceReference  serviceReference  = bundleContext.getServiceReference(XopUserDao.class.getName());
		XopUserDao xopUserDao = (XopUserDao)bundleContext.getService(serviceReference);
		System.out.println("starting ........");
		XopUser xopUser = xopUserDao.find("1");
		System.out.println("xopUser="+xopUser.getUserName());
	}
	
	public void testService() throws SQLException{
		ServiceReference  serviceReference  = bundleContext.getServiceReference(DataSourceTransactionManager.class.getName());
		DataSourceTransactionManager manager = (DataSourceTransactionManager)bundleContext.getService(serviceReference);
		System.out.println("====");
		 Connection  connection = manager.getDataSource().getConnection();
	}
}
