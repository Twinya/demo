package com.ymatou.demo1.domain.service;

import java.util.Date;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.ymatou.demo1.domain.model.UserInfo;
import com.ymatou.demo1.domain.model.UserQueryInfo;
import com.ymatou.demo1.infrastructure.db.mapper.UserInfoPoMapper;
import com.ymatou.demo1.infrastructure.db.po.UserInfoPo;
import com.ymatou.demo1.infrastructure.db.po.UserInfoPoExample;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserInfoQueryService {
	@Autowired
	private UserInfoPoMapper userInfoMapper;
	/*
	 * @Autowired private RedisTemplate redisTemplate;
	 */
	@Autowired
	private Mapper dozer;

	public List<UserInfo> queryUsers(UserQueryInfo queryInfo) {
		
		Date startTime = queryInfo.getStartTime();
		Date endTime = queryInfo.getEndTime();
		int pageNo = 1;
		int pageSize = 10;
		Page<UserInfoPo> page = PageHelper.startPage(pageNo, pageSize, true).doSelectPage(new ISelect() {
			@Override
			public void doSelect() {
				UserInfoPoExample example = new UserInfoPoExample();
				example.setOrderByClause(" create_time desc");
				example.createCriteria().andCreateTimeBetween(startTime, endTime);
				userInfoMapper.selectByExample(example);
			}
		});
		
		
		//log.info("user is "+redisTemplate.opsForValue().get("test-user-test"));
	
		List<UserInfo> userList = copy(page.getResult());
	
		return userList;
	}
	
	private List<UserInfo> copy(List<UserInfoPo> poList) {
		List<UserInfo> userList = Lists.newArrayList();
		
		if(poList != null) {
			for(UserInfoPo po:poList) {
				UserInfo user = dozer.map(po, UserInfo.class);
				userList.add(user);
			}
		}
		
		return userList;
	}
}
