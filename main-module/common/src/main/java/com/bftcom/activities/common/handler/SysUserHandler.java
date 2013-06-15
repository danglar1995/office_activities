package com.bftcom.activities.common.handler;

import com.bftcom.activities.common.dto.SysUserDto;

/**
 * Хэндлер справочника пользователей
 */
public interface SysUserHandler extends Handler {

  SysUserDto loadByName(String userName);

  /**
   * Отправляет пользователю письмо с его паролем
   * @param userName логин пользователя
   */
  void sendPassword(String userName);
}
