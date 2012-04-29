package com.xiu.open.platform.common;




public class XopConfigurableBundleContant  {

	public static final String[]  bundlesNames= new String[] {
		"net.sourceforge.cglib,com.springsource.net.sf.cglib,2.2.0",
		"com.jolbox,com.jolbox.bonecp,0.7.1",
		"com.google.common,guava,0.8",
		"com.oracle,ojdbc14,10.2.0",
		"org.apache.ibatis,com.springsource.com.ibatis,2.3.4.726",
		"commons-pool,commons-pool,1.5.4",
		"commons-dbcp,commons-dbcp,1.4",
		"org.mybatis,mybatis,3.0.6",
		"org.mybatis,mybatis-spring,1.0.2",
		"javax.servlet,com.springsource.javax.servlet,2.5.0",
		"com.caucho,com.springsource.com.caucho,3.1.5",
		"org.eclipse.osgi,org.eclipse.osgi.services,3.1.200.v20071203",
		"org.springframework,spring-tx,3.1.0.RELEASE",
		"org.springframework,spring-asm,3.1.0.RELEASE",
		"org.springframework,spring-expression,3.1.0.RELEASE",
		"org.springframework,spring-jdbc,3.1.0.RELEASE",
		"org.springframework,spring-orm,3.1.0.RELEASE",
//		"org.springframework,spring-beans,3.1.0.RELEASE",
//		"org.springframework,spring-context,3.1.0.RELEASE",
//		"org.springframework,spring-core,3.1.0.RELEASE",
//		"org.springframework,spring-aop,3.1.0.RELEASE",
		"org.springframework,spring-aspects,3.1.0.RELEASE",
		"org.aspectj,com.springsource.org.aspectj.weaver,1.6.8.RELEASE",
		 "com.xiu.open.platform,  xop-platform-common, 2.5.0",
		 "com.xiu.open.platform,  xop-platform-api, 2.5.0",
		"com.xiu.open.platform,  xop-platform-domain, 2.5.0"
	};
	
	public static void main(String[] args) {
		int i =XopConfigurableBundleContant.bundlesNames.length;
		 String[] bundelesNames = new String[i+4];
		 System.arraycopy(XopConfigurableBundleContant.bundlesNames, 0 ,bundelesNames, 0,  i); 
		 bundelesNames[i++]="com.xiu.open.platform,  xop-platform-api, 2.5.0";
	     bundelesNames[i++]="com.xiu.open.platform,  xop-platform-dao, 2.5.0";
		 bundelesNames[i++]="com.xiu.open.platform,  xop-platform-domain, 2.5.0";
		 bundelesNames[i++]="com.xiu.open.platform,  xop-platform-service, 2.5.0";
		 
	}
	
}