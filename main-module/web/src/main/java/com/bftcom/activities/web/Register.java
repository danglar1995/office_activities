package com.bftcom.activities.web;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Size;

public class Register {

  private static final String SIZE_CONSTRAINT_MSG = "длина поля должна быть в пределах";

  @Size(min = 1, max = 100, message = SIZE_CONSTRAINT_MSG + " 1-100")
  private String userFullName;

  private Integer department;

  @Email(message = "некорректный адрес эл. почты")
  @Size(min = 3, max = 30, message = SIZE_CONSTRAINT_MSG + " 3-30")
  private String email;

  @Size(min = 1, max = 15, message = SIZE_CONSTRAINT_MSG + " 1-15")
  private String userName;

  @Size(min = 5, max = 20, message = SIZE_CONSTRAINT_MSG + " 5-20")
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