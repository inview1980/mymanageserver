package com.boot.pojo;


import com.baomidou.mybatisplus.annotation.TableName;
import com.boot.enums.Sex;
import lombok.Data;

@Data
@TableName(value = "sys_user")//指定表名
public class SysUser {
  private long id;
  private String username;
  private String nickname;
  private String password;
  private String salt;
  private String phone;
  private Sex gender;
  private String head;
  private String remark;
  private long state;
  private long departmentId;
  private long roleId;
  private long deleted;
  private long version;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;

}
