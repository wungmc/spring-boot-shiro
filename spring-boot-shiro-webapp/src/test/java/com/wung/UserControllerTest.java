/*
 * Copyright (C), 2011-2018.
 */
package com.wung;

import com.wung.shiro.model.User;
import com.wung.shiro.service.UserService;
import com.wung.shiro.web.controller.UserController;
import javafx.beans.binding.When;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.mockito.Mockito.when;

/**
 * mock 测试单个 Controller
 *
 * @author wung 2018/9/12.
 */
@RunWith(SpringRunner.class)
// 表示这是一个 Mvc 测试，可以传入多个带测试的 Controller 类
@WebMvcTest(UserController.class)
public class UserControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	// 模拟对象，因为在 Spring MVC 测试中，Spring 容器并不会初始化 @Service、@Component 注解的类。
	// 所以，需要模拟 Controller 里使用到的 Service 类。
	@MockBean
	private UserService userService;
	
	@Test
	public void query() throws Exception {
		User expectedUser =  new User();
		expectedUser.setUserName("jack");
		
		Optional<User> opt = Optional.of(expectedUser);
		when(this.userService.findByUserName("jack")).thenReturn(opt);
		
		ResultActions resultActions = mockMvc.perform(
				MockMvcRequestBuilders.get("/user/query")
						.param("userName", "jack")
			.accept(MediaType.APPLICATION_JSON));
		
		MvcResult mvnResult = resultActions.andReturn();
		String result = mvnResult.getResponse().getContentAsString();
		System.out.println(result);
	}
	
}
