package com.bftcom.activities.server.dao;

import com.bftcom.activities.common.dto.Dto;
import com.bftcom.activities.common.util.BeanMapper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BaseDao implements Dao {

  private Class entityClass;

  @Autowired
  private SessionFactory sessionFactory;

  protected Class getEntityClass() {
    return entityClass;
  }

  public void setEntityClass(Class entityClass) {
    this.entityClass = entityClass;
  }

  protected Session getSession() {
    return sessionFactory.getCurrentSession();
  }

  @Override
  public <D extends Dto> D load(Class<D> dtoClass, Long id) {
    return null;
  }

  @Override
  public <D extends Dto> void insert(D dto) {
    Object entity = BeanMapper.map(dto, entityClass);
    getSession().save(entity);
  }

  @Override
  public <D extends Dto> D update(D dto) {
    return null;
  }
}
