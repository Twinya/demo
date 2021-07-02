package com.ymatou.demo1.domain.service;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class CouponService {
	@Autowired
	private UserInfoService userService;
	
	public void addCoupon(String userName, Integer amount) {
		log.info("user {} add coupon {}",userName,amount);
	}
}
