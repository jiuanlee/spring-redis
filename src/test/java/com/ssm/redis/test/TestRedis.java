/**
 * 
 */
package com.ssm.redis.test;

import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import com.ssm.dao.UserMapper;
import com.ssm.pojo.User;

/**
 * @author Administrator
 *
 */

public class TestRedis extends BaseTest {
	@Resource(name = "redisTemplate")
	private RedisTemplate<String, String> template; // inject the template as
													// ListOperations
	// 至于这个为什么可以注入。需要参考AbstractBeanFactory doGetBean
	// super.setValue(((RedisOperations) value).opsForValue());就这一行代码 依靠一个editor
	@Resource(name = "redisTemplate")
	private ValueOperations<String, Object> vOps;
	@Resource(name = "redisTemplate")
	private HashOperations<String, String, Object> hOps;
	@Autowired
	private UserMapper userServiceImpl;

	// private

	@Test
	public void testSet() {
		template.execute(new RedisCallback<Boolean>() {
			@Override
			public Boolean doInRedis(RedisConnection connection)
					throws DataAccessException {
				byte[] key = "tempkey".getBytes();
				byte[] value = "tempvalue".getBytes();
				connection.set(key, value);
				return true;
			}
		});
	}

	@Test
	public void testSet1() {
		 vOps.set("jdkSer22", "jdkSer");
		// System.out.println(vOps.get("jdkSer"));
		// template.delete("jdkSer");
		// System.out.println(vOps.get("jdkSer"));

//		User user = userServiceImpl.selectByPrimaryKey(2);
//		vOps.set("user1", user);
		// hash
//		template.delete("myHash");
		hOps.put("myHash", "BJ", "北京");
		hOps.put("myHash", "SH", "上海");
		hOps.put("myHash", "HN", "河南");
//		Map<Object, Object> hashCache = template.opsForHash().entries("myHash");
//		for (Map.Entry entry : hashCache.entrySet()) {
//			System.out.println(entry.getKey() + " - " + entry.getValue());
//		}
//		System.out.println("---------------");

	}

}
