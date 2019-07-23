package com.ssm.service;

import java.util.List;

import com.ssm.framework.International;
import com.ssm.pojo.User;

/**
 * user表的操作接口
 * 
 * @author lijiuan
 */
public interface IUserService {

	/**
	 * 通过id查询user接口方法
	 * 
	 * @param userId
	 * @return
	 */
	public User getUserById(int userId);

	/**
	 * 查询�?��的user
	 * 
	 * @return 返回userList
	 */
	@International("User")
	public List<User> getAllUser();

	/**
	 * 添加�?��user
	 * 
	 * @param user
	 */
	public void insertUser(User user);

	/**
	 * 通过ID删除用户
	 * 
	 * @param id
	 */
	public void deleteUser(int id);

	/**
	 * 通过关键字查询用�?
	 * 
	 * @param keyWords
	 * @return
	 */
	public List<User> findUsers(String keyWords);

	/**
	 * 更新用户
	 * 
	 * @param user
	 */
	public void editUser(User user);

	/**
	 * 清除所有缓存
	 */
	public void evictAll();

	/**
	 * 清楚某個Id的緩存
	 * 
	 * @param id
	 *            标识id,not null。
	 */
	public void evictById(int id);
}