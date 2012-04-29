package com.xiu.open.platform.dao;

import java.util.Dictionary;
import java.util.Map;

public class SelfManagedBean {
	 // update callback
	  public void updateCallback(Map<String,?> properties) {
		System.out.println("Received properties " + properties);
		System.out.println("Props can be used as a Dictionary " + (Dictionary) properties);
		// do more work ... 
	  
	  }
}
