package com.bftcom.activities.server.handler;

import com.bftcom.activities.common.handler.SysUserHandler;
import com.bftcom.activities.server.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SysUserHandlerImpl extends BaseHandler implements SysUserHandler {

  @Autowired
  private Dao dao;

  @Override
  protected Dao getDao() {
    return dao;
  }

}
