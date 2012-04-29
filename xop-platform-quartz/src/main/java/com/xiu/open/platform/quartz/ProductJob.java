package com.xiu.open.platform.quartz;

import org.springframework.osgi.extensions.annotation.ServiceReference;

import com.xiu.open.platform.api.service.ProductService;

public class ProductJob{
	
	private ProductService productService;

	@ServiceReference
	public void setComputeService(ProductService productService) {
		// 通过springdm注入service
		this.productService = productService;
	}
	
	public void test(){
		System.out.println("ProductJob");
		productService.test("哈哈");
	}

}
