package com.Blogging;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.Blogging.Repository.UserRepo;
import com.Blogging.Service.UserService;

@SpringBootTest
class BlogApiApplicationTests {

	@Test
	void contextLoads() {
	}

	
	@Autowired
	public UserRepo urepo;
	@Autowired
	public UserService uservice;
	@Test
	public void testcase()
	{
		String clssanem=uservice.getClass().getName();
		String packagename=uservice.getClass().getPackageName();
		
		System.out.println(clssanem);
		System.out.println(packagename);
	}
}
