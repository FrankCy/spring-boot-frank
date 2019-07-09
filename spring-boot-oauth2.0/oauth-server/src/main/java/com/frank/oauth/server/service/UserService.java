package com.frank.oauth.server.service;

import com.frank.oauth.entity.po.User;

public interface UserService {

	/**
	 * 根据用户主键查询用户
	 * @param id
	 * @return
	 */
	User selectByPrimaryKey(String id);

	/**
	 * 根据用户名字查询用户
	 * @param name
	 * @return
	 */
	User selectByName(String name);
}