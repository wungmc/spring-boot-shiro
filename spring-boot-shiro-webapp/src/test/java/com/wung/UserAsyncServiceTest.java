/*
 * Copyright (C), 2011-2018.
 */
package com.wung;

import com.wung.shiro.model.User;
import com.wung.shiro.service.UserAsyncService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.concurrent.Future;

/**
 * @author wung 2018/9/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserAsyncServiceTest {
	
	@Autowired
	private UserAsyncService userAsyncService;
	
	@Test
	public void asynFindAll() {
		System.out.println("第一次调用asynFindAll()");
		Future<List<User>> list1 = userAsyncService.asynFindAll();
		System.out.println("第二次调用asynFindAll()");
		Future<List<User>> list2 = userAsyncService.asynFindAll();
		System.out.println("第三次调用asynFindAll()");
		Future<List<User>> list3 = userAsyncService.asynFindAll();

		while (true) {
			if (list1.isDone() && list2.isDone() && list3.isDone()) {
				System.out.println("三次调用全部返回结果！");
				break;
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
