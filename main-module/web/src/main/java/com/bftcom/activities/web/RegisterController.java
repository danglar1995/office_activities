package com.bftcom.activities.web;

import com.bftcom.activities.common.appobj.AppObj;
import com.bftcom.activities.common.appobj.AppObjDict;
import com.bftcom.activities.common.dto.SysUserDto;
import com.bftcom.activities.common.handler.SysUserHandler;
import com.bftcom.activities.common.util.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class RegisterController {

  @Autowired
  private AutowireCapableBeanFactory beanFactory;

  @RequestMapping(value="/register", method=RequestMethod.GET)
  public String getRegisterPage(HttpServletRequest request, ModelMap model) {
    Register register = new Register();
    register.setUserName(request.getParameter("userNameParam"));

    model.addAttribute("register", register);

    return "register";
  }

  @RequestMapping(value="/register", method=RequestMethod.POST)
  public String register(ModelMap model, @Valid Register registerObj, BindingResult result) {
    if (result.hasErrors()) {
      return "register";
    }

    AppObjDict dict = AppObjDict.getInstance();
    AppObj sysUserObj = dict.getAppObj("sysUser");

    SysUserHandler handler = beanFactory.getBean(SysUserHandler.class);
    handler.init(sysUserObj);

    SysUserDto dto = (SysUserDto) BeanMapper.map(registerObj, sysUserObj.getProperty(AppObj.EDIT_DTO));

    handler.insert(dto);

    return "redirect:login";
  }
}