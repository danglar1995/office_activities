package com.bftcom.activities.server.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@javax.persistence.Entity(name = "SysUser")
public class SysUserEntity extends BaseEntity {

  private String userFullName;
  private Integer department;
  private String email;
  private String userName;
  private String password;

  @Column(name = "FULL_NAME", nullable = false, length = 100)
  public String getUserFullName() {
    return userFullName;
  }

  public void setUserFullName(String userFullName) {
    this.userFullName = userFullName;
  }

  @Column(nullable = false, length = 15)
  public Integer getDepartment() {
    return department;
  }

  public void setDepartment(Integer department) {
    this.department = department;
  }

  @Column(nullable = false, length = 30)
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Column(name = "NAME", nullable = false, length = 15)
  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  @Column(nullable = false, length = 20)
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
