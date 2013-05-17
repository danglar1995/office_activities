package com.bftcom.activities.server.dao;

import com.bftcom.activities.common.dto.Dto;

public interface Dao {

  <D extends Dto> D load(Class<D> dtoClass, Long id);

  <D extends Dto> void insert(D dto);

  <D extends Dto> D update(D dto);
}
