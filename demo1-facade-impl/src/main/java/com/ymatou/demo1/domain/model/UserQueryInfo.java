package com.ymatou.demo1.domain.model;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserQueryInfo {
	private Date startTime;
	
	private Date endTime;
}
