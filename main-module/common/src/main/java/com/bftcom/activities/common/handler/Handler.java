package com.bftcom.activities.common.handler;

import com.bftcom.activities.common.appobj.AppObj;
import com.bftcom.activities.common.dto.Dto;

public interface Handler {
  void init(AppObj appObj);

  Dto loadById(Long id);

  void update(Dto dto);

  void insert(Dto dto);
}