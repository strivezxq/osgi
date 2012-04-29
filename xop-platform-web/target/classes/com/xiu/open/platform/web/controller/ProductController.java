package com.xiu.open.platform.web.controller;

import org.springframework.osgi.extensions.annotation.ServiceReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xiu.open.platform.api.service.ProductService;
import com.xiu.open.platform.api.service.XopUserService;
import com.xiu.open.platform.domain.XopUser;


@Controller
@RequestMapping("/product")
public class ProductController {
	// @Autowired
	// BundleContext bundleContext;

	
	private ProductService productService;
	
	@ServiceReference
	public void setProdutService(ProductService productService) {
		// 通过springdm注入service
		this.productService = productService;
	}
	private XopUserService xopUserService;
	
	@ServiceReference
	public void setXopuSerService(XopUserService xopUserService) {
		// 通过springdm注入service
		this.xopUserService = xopUserService;
	}

	@RequestMapping(value="/test/{str}",method = RequestMethod.GET)
	public ModelAndView compute(@PathVariable("str") String str) {
		productService.test("hello World........"+str);
		ModelAndView mv = new ModelAndView("test");
		mv.addObject("result", "hello World");
		
		
		return mv;
	}
	
	@RequestMapping(value="/user/{userId}/{userName}/{age}",method = RequestMethod.GET)
	public ModelAndView compute(@PathVariable("userId") Integer userId,@PathVariable("userName") String userName,@PathVariable("age") Integer age) {
		
		XopUser xopUser = new XopUser();
		xopUser.setUserId(userId);
		xopUser.setUserName(userName);
		xopUser.setAge(age);
		
		xopUserService.insertXopUsere(xopUser);

		ModelAndView mv = new ModelAndView("test");
		mv.addObject("result", "hello World");
		
		
		return mv;
	}

}
