package com.wung;

import com.wung.shiro.model.Role;
import com.wung.shiro.model.User;
import com.wung.shiro.service.UserService;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootShiroApplicationTests {
	
	@Test
	public void contextLoads() {
	}

	@Autowired
	private UserService userService;
	
	@Test
	public void findUserByUserName() {
		User user = userService.findByUserName("wung");
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		user.getRoles().stream()
				.map(Role::getRoleName)
				.forEach(info::addRole);
		user.getRoles().stream()
				.map(Role::getResources)
				.flatMap(Collection::stream)
				.forEach(resource -> info.addStringPermission(resource.getPerm()));
		
		System.out.println(info);
	}
}
