/*
 * Copyright (C), 2011-2018.
 */
package com.wung;

import com.wung.shiro.web.IndexController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * mock 测试单个 Controller
 *
 * @author wung 2018/9/12.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class IndexControllerTest {
	private MockMvc mockMvc;
	
	@Autowired
	private IndexController indexController;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
	}
	
	
	@Test
	public void hello() throws Exception {
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/hello")
			.accept(MediaType.APPLICATION_JSON));
		
		MvcResult mvnResult = resultActions.andReturn();
		String result = mvnResult.getResponse().getContentAsString();
		System.out.println(result);
	}
	
	
	@Test
	public void index() throws Exception {
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/index")
			.param("id", "1")
			.accept(MediaType.APPLICATION_JSON));
		
		MvcResult mvnResult = resultActions.andReturn();
		String result = mvnResult.getResponse().getContentAsString();
		System.out.println(result);
	}
	
	
}
