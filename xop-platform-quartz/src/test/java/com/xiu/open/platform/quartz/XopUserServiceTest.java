package com.xiu.open.platform.quartz;



import org.osgi.framework.Bundle;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceReference;
import org.springframework.osgi.test.AbstractConfigurableBundleCreatorTests;
import org.springframework.osgi.test.platform.Platforms;

import com.xiu.open.platform.api.service.XopUserService;
import com.xiu.open.platform.common.XopConfigurableBundleContant;
import com.xiu.open.platform.domain.XopUser;


/**
 * OSGi integration test (inside OSGi).
 * @see AbstractConfigurableBundleCreatorTests
 */
public class XopUserServiceTest extends AbstractConfigurableBundleCreatorTests {

	@Override
	protected String[] getTestBundlesNames() {
		 String[] xopNames = {	
				"com.xiu.open.platform,  xop-platform-dao, 2.5.0",
				"com.xiu.open.platform,  xop-platform-service, 2.5.0"};
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
			if("com.xiu.open.platform.service".equals(currentBundle.getSymbolicName()) 
					&& currentBundle.getState() == Bundle.ACTIVE) {
				bundleIsHereAndStarted = true;
				break;
			}
		}
		assertTrue("xop-platform-service is not installed nor activated!",bundleIsHereAndStarted);
	}

	public void testProductService(){
		ServiceReference  serviceReference  = bundleContext.getServiceReference(XopUserService.class.getName());
		XopUserService xopUserService = (XopUserService)bundleContext.getService(serviceReference);
		System.out.println("starting ........");
		XopUser xopUser = new XopUser();
		xopUser.setAge(20);
		xopUser.setUserId(100);
		xopUser.setUserName("zhou");
		xopUserService.insertXopUsere(xopUser);
	}
	

}