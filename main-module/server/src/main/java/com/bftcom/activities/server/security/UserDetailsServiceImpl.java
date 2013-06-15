package com.bftcom.activities.server.security;

import com.bftcom.activities.common.appobj.AppObjDict;
import com.bftcom.activities.common.dto.SysUserDto;
import com.bftcom.activities.common.handler.SysUserHandler;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private BeanFactory beanFactory;

  @Override
  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    SysUserHandler userHandler = beanFactory.getBean(SysUserHandler.class);
    userHandler.init(AppObjDict.getInstance().getAppObj("sysUser"));
    SysUserDto userDto = userHandler.loadByName(userName);

    return new UserAccount(userDto.getUserName(), userDto.getPassword(),
            Collections.singletonList(new Authority(userDto.getAuthorityName())));
  }

}
