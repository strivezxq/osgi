package com.xiu.open.platform.api;

import org.osgi.framework.Constants;
import org.springframework.osgi.test.AbstractConfigurableBundleCreatorTests;
import org.springframework.osgi.test.platform.Platforms;

public class SimpleOsgiTest extends AbstractConfigurableBundleCreatorTests {

	@Override
	protected String[] getTestBundlesNames() {
		return new String[] {
				"com.xiu.open.platform,  xop-platform-domain, 2.5.0"
				};
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
		
		getPlatformName();
	}

}
