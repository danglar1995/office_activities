package com.bftcom.activities.common.dto;

public class SysUserDto extends BaseDto {
  private String userFullName;
  private Integer department;
  private String email;
  private String userName;
  private String password;

  public String getUserFullName() {
    return userFullName;
  }

  public void setUserFullName(String userFullName) {
    this.userFullName = userFullName;
  }

  public Integer getDepartment() {
    return department;
  }

  public void setDepartment(Integer department) {
    this.department = department;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
