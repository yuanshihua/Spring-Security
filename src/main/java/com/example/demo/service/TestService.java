package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;

@Service
public class TestService {

	@Secured("ROLE_USER")
	public String test() {
		return "aa";
	}

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	public void test2() {
		System.out.println("拥有ADMIN或USER权限");
	}

	/*
	 * 需要拥有ADMIN或USER权限才能访问， ADMIN缺陷的话返回所有数据， USER权限的话只返回和登录用户相同用户名的数据
	 * 
	 * @return
	 */
	@PreAuthorize("hasAnyRole({'ROLE_ADMIN','ROLE_USER'})")
	@PostFilter("hasRole('ROLE_ADMIN') || "
			+ "filterObject.username == principal.username")
	public List<User> test1() {
		User u1 = new User("user");
		User u2 = new User("root");
		User u3 = new User("xueqiang");
		List<User> list = new ArrayList<User>();
		list.add(u1);
		list.add(u2);
		list.add(u3);
		return list;
	}
}
