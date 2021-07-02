package com.ymatou.demo1.domain.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liuqiu
 */
@Data
@ToString
public class UserInfo implements Serializable {
	private String userName;

    private Integer age;

    private String realName;
    
    
    public String changeName(String newName) {
    	this.userName = newName;
    	return this.userName;
    }
}
