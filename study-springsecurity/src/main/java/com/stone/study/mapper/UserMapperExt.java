package com.stone.study.mapper;

import com.stone.study.model.UserExt;

public interface UserMapperExt extends UserMapper {
	/**
	 * 根据用户名获取用户信息
	 * 
	 * @param uname
	 * @return
	 */
	UserExt findByUname(String uname);
}
