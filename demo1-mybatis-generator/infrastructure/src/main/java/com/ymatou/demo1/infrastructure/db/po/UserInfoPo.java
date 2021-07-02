package com.ymatou.demo1.infrastructure.db.po;

import java.io.Serializable;
import java.util.Date;

public class UserInfoPo implements Serializable {
    /**
     * BIGINT(19) 必填<br>
     * 
     */
    private Long id;

    /**
     * VARCHAR(45)<br>
     * 
     */
    private String userName;

    /**
     * VARCHAR(45)<br>
     * 
     */
    private String realName;

    /**
     * INTEGER(10)<br>
     * 
     */
    private Integer age;

    /**
     * TIMESTAMP(19)<br>
     * 
     */
    private Date createTime;

    /**
     * TIMESTAMP(19)<br>
     * 
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user_info
     *
     * @mbggenerated Wed Dec 23 11:48:53 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * BIGINT(19) 必填<br>
     * 获得 
     */
    public Long getId() {
        return id;
    }

    /**
     * BIGINT(19) 必填<br>
     * 设置 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * VARCHAR(45)<br>
     * 获得 
     */
    public String getUserName() {
        return userName;
    }

    /**
     * VARCHAR(45)<br>
     * 设置 
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * VARCHAR(45)<br>
     * 获得 
     */
    public String getRealName() {
        return realName;
    }

    /**
     * VARCHAR(45)<br>
     * 设置 
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * INTEGER(10)<br>
     * 获得 
     */
    public Integer getAge() {
        return age;
    }

    /**
     * INTEGER(10)<br>
     * 设置 
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * TIMESTAMP(19)<br>
     * 获得 
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * TIMESTAMP(19)<br>
     * 设置 
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * TIMESTAMP(19)<br>
     * 获得 
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * TIMESTAMP(19)<br>
     * 设置 
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbggenerated Wed Dec 23 11:48:53 CST 2020
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        UserInfoPo other = (UserInfoPo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getRealName() == null ? other.getRealName() == null : this.getRealName().equals(other.getRealName()))
            && (this.getAge() == null ? other.getAge() == null : this.getAge().equals(other.getAge()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbggenerated Wed Dec 23 11:48:53 CST 2020
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getRealName() == null) ? 0 : getRealName().hashCode());
        result = prime * result + ((getAge() == null) ? 0 : getAge().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbggenerated Wed Dec 23 11:48:53 CST 2020
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userName=").append(userName);
        sb.append(", realName=").append(realName);
        sb.append(", age=").append(age);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}