package com.bftcom.activities.server.dao;

import com.bftcom.activities.common.dto.Dto;
import com.bftcom.activities.common.util.BeanMapper;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SysUserDaoImpl extends BaseDao implements SysUserDao {

  @Override
  public <D extends Dto> D loadByName(Class<D> dtoClass, String name) {
    Criteria cr = getSession().createCriteria(getEntityClass());
    cr.add(Restrictions.eq("userName", name));
    List rows = cr.list();
    if (!rows.isEmpty()) {
      Object entity = rows.get(0);
      return BeanMapper.map(entity, dtoClass);
    }

    return null;
  }
}
