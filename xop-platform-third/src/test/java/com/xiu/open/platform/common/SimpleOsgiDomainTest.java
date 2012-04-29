package com.xiu.open.platform.common;

import org.osgi.framework.Constants;
import org.springframework.osgi.test.AbstractConfigurableBundleCreatorTests;
import org.springframework.osgi.test.platform.Platforms;

public class SimpleOsgiDomainTest extends AbstractConfigurableBundleCreatorTests {

//	@Override
//	protected String[] getTestBundlesNames() {
//		return new String[] {
//				"org.springframework, spring-core, 3.1.0.RELEASE",
//				"org.springframework, spring-aop, 3.1.0.RELEASE",
//				"org.springframework, spring-beans, 3.1.0.RELEASE",
//				"org.springframework, spring-context, 3.1.0.RELEASE",
//				"org.springframework, spring-context-support, 3.1.0.RELEASE",
//				"org.springframework,spring-expression, 3.1.0.RELEASE",
//				"org.springframework.osgi,spring-osgi-annotation, 3.1.0.RELEASE",
//				"org.springframework.osgi,spring-osgi-extender, 3.1.0.RELEASE",
//				"org.springframework.osgi,spring-osgi-core, 3.1.0.RELEASE",
//				
//				
//				"org.springframework.osgi,spring-osgi-test, 3.1.0.RELEASE",
//				"org.springframework, spring-test, 3.1.0.RELEASE"
//				};
//	}
	
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
		
		getPlatformName();
	}

}
