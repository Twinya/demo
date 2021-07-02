package com.ymatou.demo1.facade.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @author shaoqing.liu
 * @date 2018/10/13 18:25
 */
@ApiModel(description = "添加用户响应模型",value = "AddUserResult")
@Data
@ToString
public class AddUserResult implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6512382274851399649L;
	@ApiModelProperty("用户名称")
    /**请求号 **/
    private String userName;
}
