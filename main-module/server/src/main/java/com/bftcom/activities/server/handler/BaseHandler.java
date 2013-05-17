package com.bftcom.activities.server.handler;

import com.bftcom.activities.common.appobj.AppObj;
import com.bftcom.activities.common.dto.Dto;
import com.bftcom.activities.common.handler.Handler;
import com.bftcom.activities.server.dao.BaseDao;
import com.bftcom.activities.server.dao.Dao;
import com.bftcom.activities.server.entity.Entity;
import org.springframework.transaction.annotation.Transactional;

public abstract class BaseHandler implements Handler {
  private AppObj appObj;

  protected abstract Dao getDao();

  protected Class<? extends Entity> getEntityClass() {
    try {
      return (Class<? extends Entity>) Class.forName(appObj.getProperty(AppObj.ENTITY));
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  protected Class<? extends Dto> getDtoClass() {
    try {
      return (Class<? extends Dto>) Class.forName(appObj.getProperty(AppObj.EDIT_DTO));
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void init(AppObj appObj) {
    this.appObj = appObj;

    Dao dao = getDao();
    if (dao instanceof BaseDao) {
      ((BaseDao) dao).setEntityClass(getEntityClass());
    }
  }

  @Transactional
  @Override
  public Dto loadById(Long id) {
    return getDao().load(getDtoClass(), id);
  }

  @Transactional
  @Override
  public void update(Dto dto) {
    getDao().update(dto);
  }

  @Transactional
  @Override
  public void insert(Dto dto) {
    getDao().insert(dto);
  }

}
