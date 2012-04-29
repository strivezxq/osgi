package com.xiu.open.platform.service;

import org.springframework.stereotype.Service;

import com.xiu.open.platform.api.service.ProductService;

@Service(value="productService")
public class ProductServiceImpl implements ProductService {

	public void test(String str) {
		System.out.println("打印："+str);
	}
	

}
