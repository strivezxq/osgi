package com.xiu.open.platform.admin;



import org.osgi.framework.Bundle;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceReference;
import org.springframework.osgi.test.AbstractConfigurableBundleCreatorTests;
import org.springframework.osgi.test.platform.Platforms;

import com.xiu.open.platform.api.service.ProductService;

/**
 * OSGi integration test (inside OSGi).
 * @see AbstractConfigurableBundleCreatorTests
 */
public class ProductServiceTest extends AbstractConfigurableBundleCreatorTests {

	@Override
	protected String[] getTestBundlesNames() {
				return new String[] {
						"net.sourceforge.cglib,com.springsource.net.sf.cglib,2.2.0",
						"com.jolbox,bonecp_oracle,0.7.1",
						"guava,com.google.common,0.8",
						"com.oracle,ojdbc14,10.2.0",
						"org.apache.ibatis,com.springsource.com.ibatis,2.3.4.726",
						"commons-pool,commons-pool,1.5.4",
						"commons-dbcp,commons-dbcp,1.4",
						"org.mybatis,mybatis,3.0.6",
						"org.mybatis,mybatis-spring,1.0.2",
						"org.springframework,spring-tx,3.1.0.RELEASE",
						"org.springframework,spring-asm,3.1.0.RELEASE",
						"org.springframework,spring-expression,3.1.0.RELEASE",
						"org.springframework,spring-jdbc,3.1.0.RELEASE",
						"org.springframework,spring-orm,3.1.0.RELEASE",
						"org.springframework,spring-beans,3.1.0.RELEASE",
						"org.springframework,spring-context,3.1.0.RELEASE",
						"org.springframework,spring-core,3.1.0.RELEASE",
						"org.springframework,spring-aop,3.1.0.RELEASE",
						"org.springframework,spring-aspects,3.1.0.RELEASE",
						"org.aspectj,com.springsource.org.aspectj.weaver,1.6.8.RELEASE",
					"com.xiu.open.platform,  xop-platform-api, 2.5.0",
						"com.xiu.open.platform,  xop-platform-dao, 2.5.0",
					"com.xiu.open.platform,  xop-platform-domain, 2.5.0",
					"com.xiu.open.platform,  xop-platform-service, 2.5.0"
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
		ServiceReference  serviceReference  = bundleContext.getServiceReference(ProductService.class.getName());
		ProductService productService = (ProductService)bundleContext.getService(serviceReference);
		System.out.println("starting ........");
		productService.test("ffffffff");
	}
	
	
//	private ProductService productService;
//
//	@ServiceReference
//	public void setComputeService(ProductService productService) {
//		// 通过springdm注入service
//		this.productService = productService;
//	}
	
	
	public void testProduct(){
		System.out.println("========================================================");
//		productService.test("ddddd");
	}

}