package com.ymatou.demo1.facade.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;


@ApiModel(description = "查询用户模型",value = "UserInfoDto")
@Data
@ToString
public class UserInfoDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6157278758317381743L;

	@ApiModelProperty("用户id")
	private Long id;
	
	@ApiModelProperty("用户名称")
    private String userName;
	
	@ApiModelProperty("用户年龄")
    private Integer age;
	
	@ApiModelProperty("真实名称")
    private String realName;
}
