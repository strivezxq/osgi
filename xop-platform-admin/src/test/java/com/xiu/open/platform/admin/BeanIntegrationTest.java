package com.xiu.open.platform.admin;

import org.springframework.test.AbstractDependencyInjectionSpringContextTests;


public class BeanIntegrationTest extends AbstractDependencyInjectionSpringContextTests {
//AbstractDependencyInjectionSpringContextTests
	
	protected String[] getConfigLocations() {
	  return new String[] {"META-INF/spring/bundle-context.xml"};
	}
	

}
