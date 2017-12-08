package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.User;
import com.example.demo.service.TestService;

@Controller
public class SecurityController {
	
	@Autowired
	private TestService service;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/home")
	public String suc() {
		return "index";
	}
	
	@RequestMapping("/index")
	public String sucess() {
		return "index";
	}
	/**
	 * 
	 * @Description: 测试不同角色的方法的方法访问限制（不同角色返回的数据不一样）
	 * @return List<User>  
	 * @throws
	 * @author yuanshihua
	 * @date 2017年12月8日
	 */
	@RequestMapping("/test1")
	@ResponseBody
	public List<User> testMethod(){
		return service.test1();
	}
	
	@RequestMapping("/test")
	@ResponseBody
	public String testMethod2(){
		return service.test();
	}
	
	@RequestMapping("/test2")
	@ResponseBody
	public String testMethod3(){
		service.test2();
		return "ok";
	}
}
