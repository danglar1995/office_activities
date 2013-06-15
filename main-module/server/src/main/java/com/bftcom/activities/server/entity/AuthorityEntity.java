package com.bftcom.activities.server.entity;

@javax.persistence.Entity(name = "Authorities")
public class AuthorityEntity extends BaseEntity {

  private String authority;

  public String getAuthority() {
    return authority;
  }

  public void setAuthority(String authority) {
    this.authority = authority;
  }
}
