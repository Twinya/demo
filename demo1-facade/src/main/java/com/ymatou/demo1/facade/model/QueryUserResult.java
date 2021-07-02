package com.ymatou.demo1.facade.model;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@ApiModel(description = "查询用户结果模型",value = "QueryUserResult")
@Data
@ToString
public class QueryUserResult implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5654343157238821031L;
	@ApiModelProperty("用户信息列表")
	private List<UserInfoDto> users;
	
}
