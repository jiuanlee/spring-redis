/**
 * 
 */
package com.ssm.redis.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.ssm.pojo.User;
import com.ssm.service.IUserService;

/**
 * @author login
 *
 */
public class Test1 extends BaseTest {
	@Resource
	private IUserService userService;

	@Test
	public void gerUser() {

		// userService.evictAll();
//		List<User> users = userService.getAllUser();
//		for (User user : users)
//			System.out.println(user);

		// // 清空缓存
		 userService.evictAll();

		 User user = userService.getUserById(2);
		 System.out.println(user.toString());
		//
		// //userService.evictById(2);
		//
		// User user1 = userService.getUserById(2);
		// System.out.println(user1.toString());

	}

	// @Test
	public void testAllUser() {
		User user = new User();
		user.setSex("male");
		user.setUserName("lomBok");
		user.setAge(2);
		userService.insertUser(user);
	}

}
