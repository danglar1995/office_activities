package com.bftcom.activities.web;

import com.bftcom.activities.common.appobj.AppObj;
import com.bftcom.activities.common.appobj.AppObjDict;
import com.bftcom.activities.common.handler.SysUserHandler;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ForgotPassController {

  @Autowired
  private BeanFactory beanFactory;

  @RequestMapping(params="forgotPass", method=RequestMethod.POST)
  public String forgotPass(Login loginObj) {
    AppObjDict dict = AppObjDict.getInstance();
    AppObj sysUserObj = dict.getAppObj("sysUser");

    SysUserHandler handler = beanFactory.getBean(SysUserHandler.class);
    handler.init(sysUserObj);

    handler.sendPassword(loginObj.getUserName());

    return "redirect:forgotPass";
  }

  @RequestMapping(value="/forgotPass", method=RequestMethod.GET)
  public String getPage() {
    return "forgotPass";
  }
}
