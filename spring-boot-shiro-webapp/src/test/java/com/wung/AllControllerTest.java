/*
 * Copyright (C), 2011-2018.
 */
package com.wung;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * 对整个环境做测试，包括Interceptor。
 *
 * @author wung 2018/9/12.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AllControllerTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext context;
	
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void index() throws Exception {
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/index")
			.param("id", "1")
			.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print())
				;
		
		MvcResult mvcResult = resultActions.andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();
		
		System.out.println(response.containsHeader("Content-Type"));
		System.out.println(response.getContentType());
		System.out.println(response.getCharacterEncoding());
		System.out.println(response.getContentAsString());
		System.out.println(response.getContentLength());
		System.out.println(response.getStatus());
		
		// out
		// true
		// application/json;charset=UTF-8
		// UTF-8
		// id=1
		// 4
		// 200
	}
	
}
