package com.bftcom.activities.server.entity;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntity implements Entity {

  private Long id;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(nullable = false)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
