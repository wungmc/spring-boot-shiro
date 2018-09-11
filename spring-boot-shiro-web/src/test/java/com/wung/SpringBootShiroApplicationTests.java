package com.wung;

import com.wung.shiro.model.User;
import com.wung.shiro.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

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
		Optional<User> userOptional = userService.findByUserName("wung");
		userOptional.ifPresent(System.out::println);
	}
}
