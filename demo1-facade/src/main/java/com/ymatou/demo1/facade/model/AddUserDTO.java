package com.ymatou.demo1.facade.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.ymatou.common.lang.service.AbstractRequest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @author 
 * @date 2018/10/13 22:01
 */
@ApiModel(description = "添加用户请求模型",value = "AddUserDTO")
@Data
@ToString
public class AddUserDTO extends AbstractRequest{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1364216780915401536L;

	@ApiModelProperty("用户名称")
	@NotEmpty
	private String userName;
	
	@ApiModelProperty("年龄")
	@NotEmpty
    private Integer age = 0;
    
	@ApiModelProperty("真实名称")
	@NotNull
    private String realName;


}
