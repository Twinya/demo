package com.ymatou.demo1.facade.model;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@ApiModel(description = "查询用户请求模型",value = "QueryUserDto")
@Data
@ToString
public class QueryUserDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9041029952257414448L;

	@ApiModelProperty("开始时间")
	@NotNull
	private String startTime;
	
	@ApiModelProperty("结束时间")
	@NotEmpty
	private String endTime;
	
}
