package com.ymatou.demo1.domain.service;

import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ymatou.demo1.domain.model.UserInfo;
import com.ymatou.demo1.infrastructure.db.mapper.UserInfoPoMapper;
import com.ymatou.demo1.infrastructure.db.po.UserInfoPo;

import lombok.extern.slf4j.Slf4j;

/**
 */
@Service
@Transactional
@Slf4j
public class UserInfoService {

	/*
	 * @Autowired private RedisTemplate redisTemplate;
	 */
	
	@Autowired
	private UserInfoPoMapper userInfoMapper;
	
	@Autowired
	private Mapper dozer;
	

    /**
     * 鏂板notice
     * @param
     * @return
     */
    public UserInfo addUser(UserInfo userInfo){
    	
    	UserInfoPo po = dozer.map(userInfo, UserInfoPo.class);
    	userInfoMapper.insertSelective(po);
    	String userName = userInfo.getUserName();
    	//redisTemplate.opsForValue().set("test-user-"+userName, userName, 30000, TimeUnit.MILLISECONDS);
  
    	return userInfo;
    }
    
    public void updateBatch(List<UserInfo> userList) {
    	log.info("updateBatch");
    }
}
