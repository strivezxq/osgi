package com.xiu.open.platform.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

import org.osgi.framework.Constants;
import org.osgi.framework.ServiceReference;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.osgi.test.AbstractConfigurableBundleCreatorTests;
import org.springframework.osgi.test.platform.Platforms;

public class XopUserDaoOsgiTest extends AbstractConfigurableBundleCreatorTests {

	@Override
	protected String[] getTestBundlesNames() {
				return new String[] {
						"com.jolbox,bonecp_oracle,0.7.1",
						"guava,com.google.common,0.8",
						"com.oracle,ojdbc14,10.2.0",
						"org.apache.ibatis,com.springsource.com.ibatis,2.3.4.726",
						"commons-pool,commons-pool,1.5.4",
						"commons-dbcp,commons-dbcp,1.4",
						"org.mybatis,mybatis,3.0.6",
						"org.mybatis,mybatis-spring,1.0.2",
						"org.springframework.osgi,spring-osgi-annotation,2.0.0.M1",
						"org.springframework,spring-tx,3.1.0.RELEASE",
						"org.springframework,spring-jdbc,3.1.0.RELEASE",
						"org.springframework,spring-orm,3.1.0.RELEASE",
						"org.springframework,spring-beans,3.1.0.RELEASE",
						"org.springframework,spring-context,3.1.0.RELEASE",
						"org.springframework,spring-core,3.1.0.RELEASE",
						"org.springframework,spring-aop,3.1.0.RELEASE",
						"org.springframework,spring-aspects,3.1.0.RELEASE",
						"org.aspectj,aspectjweaver,1.6.8.bundle",
					"com.xiu.open.platform,  xop-platform-api, 2.5.0",
						"com.xiu.open.platform,  xop-platform-dao, 2.5.0",
					"com.xiu.open.platform,  xop-platform-domain, 2.5.0"
					};
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
	
//	public void testIntegration() {
//		boolean bundleIsHereAndStarted = false;
//		for(Bundle currentBundle :		bundleContext.getBundles()) {
//			if("com.xiu.open.platform.dao".equals(currentBundle.getSymbolicName()) 
//					&& currentBundle.getState() == Bundle.ACTIVE) {
//				bundleIsHereAndStarted = true;
//				break;
//			}
//		}
//		assertTrue("xop-platform-dao is not installed nor activated!",bundleIsHereAndStarted);
//	}

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
//		ServiceReference  serviceReference  = bundleContext.getServiceReference(XopUserDao.class.getName());
//		XopUserDao xopUserDao = (XopUserDao)bundleContext.getService(serviceReference);
//		System.out.println("starting ........");
//		XopUser xopUser = xopUserDao.find("1");
//		System.out.println("xopUser="+xopUser);
	}
	
	
	public void testService() throws SQLException{
		ServiceReference  serviceReference  = bundleContext.getServiceReference(DataSourceTransactionManager.class.getName());
		DataSourceTransactionManager manager = (DataSourceTransactionManager)bundleContext.getService(serviceReference);
		System.out.println("====");
//		 Connection  connection = manager.getDataSource().getConnection();
	}
	
}
