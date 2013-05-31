package com.bftcom.activities.common.handler;

/**
 * Хэндлер справочника пользователей
 */
public interface SysUserHandler extends Handler {

  /**
   * Отправляет пользователю письмо с его паролем
   * @param userName логин пользователя
   */
  void sendPassword(String userName);
}
