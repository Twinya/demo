package com.ymatou.demo1.facade;

import com.ymatou.demo1.facade.model.AddUserDTO;
import com.ymatou.demo1.facade.model.AddUserResult;
import com.ymatou.demo1.facade.model.QueryUserDto;
import com.ymatou.demo1.facade.model.QueryUserResult;


public interface DemoFacade {
	public AddUserResult addUser(AddUserDTO addUserDto) ;
	
	public QueryUserResult queryUsers(QueryUserDto queryUserDto) ;
}
