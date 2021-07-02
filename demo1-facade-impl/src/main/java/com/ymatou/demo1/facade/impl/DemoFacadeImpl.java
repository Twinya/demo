package com.ymatou.demo1.facade.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.ymatou.demo1.domain.model.UserInfo;
import com.ymatou.demo1.domain.model.UserQueryInfo;
import com.ymatou.demo1.domain.service.UserInfoQueryService;
import com.ymatou.demo1.domain.service.UserInfoService;
import com.ymatou.demo1.facade.DemoFacade;
import com.ymatou.demo1.facade.model.AddUserDTO;
import com.ymatou.demo1.facade.model.AddUserResult;
import com.ymatou.demo1.facade.model.QueryUserDto;
import com.ymatou.demo1.facade.model.QueryUserResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

@Api(value = "demoFacade")
@Component("demoFacade")
@Produces("application/json; charset=UTF-8")
@Service(protocol = { "rest", "dubbo" })
@Path("/api")
@Slf4j
public class DemoFacadeImpl implements DemoFacade {

	@Autowired
	private UserInfoService userService;

	@Autowired
	private UserInfoQueryService userQueryService;

	@Autowired
	private Mapper dozer;

	private String testapp;

	@Override
	@ApiOperation(value = "addUser",
			produces = "application/json", 
			consumes = "application/json", 
			httpMethod = "POST", notes = "添加用户", 
			response = AddUserResult.class)
	@POST
	@Path("/demo/addUser")
	@Consumes("application/json")
	@Produces("application/json; charset=UTF-8")
	public AddUserResult addUser(@ApiParam AddUserDTO addUserDto) {
		UserInfo user = dozer.map(addUserDto, UserInfo.class);
		AddUserResult r = new AddUserResult();
		user = userService.addUser(user);
		String userName = user.getUserName();

		r.setUserName(userName);

		log.info(testapp);
		return r;
	}

	@Override
	@ApiOperation("queryUsers")
	@POST
	@Path("/demo/queryUsers")
	@Consumes("application/json")
	@Produces("application/json; charset=UTF-8")
	public QueryUserResult queryUsers(@ApiParam QueryUserDto queryUserDto) {
		log.info("" + queryUserDto);
		QueryUserResult r = new QueryUserResult();
		UserQueryInfo queryInfo = dozer.map(queryUserDto, UserQueryInfo.class);
		// PageResult<UserInfoPo> users = userQueryService.queryUsers(queryInfo);
		// r.setUsers(users);
		return r;
	}
}
