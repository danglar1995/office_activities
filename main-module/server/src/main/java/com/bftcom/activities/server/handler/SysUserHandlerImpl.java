package com.bftcom.activities.server.handler;

import com.bftcom.activities.common.dto.SysUserDto;
import com.bftcom.activities.common.handler.SysUserHandler;
import com.bftcom.activities.server.dao.Dao;
import com.bftcom.activities.server.dao.SysUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

@Component
public class SysUserHandlerImpl extends BaseHandler implements SysUserHandler {

  @Autowired
  private SysUserDao dao;

  @Value("${mail.host}")
  private String host;  // хост с которого отправляется почта

  @Value("${mail.from}")
  private String from;  // отправитель

  @Override
  protected Dao getDao() {
    return dao;
  }

  @Transactional
  @Override
  public void sendPassword(String userName) {
    SysUserDto userDto = (SysUserDto) dao.loadByName(getDtoClass(), userName);
    send(userName, userDto.getEmail(), userDto.getPassword());
  }

  private void send(String userName, String email, String password) {
    Properties props = new Properties(System.getProperties());
    props.put("mail.smtp.host", host);
    Session session = Session.getInstance(props);
    try {
      MimeMessage msg = new MimeMessage(session);
      msg.setFrom(new InternetAddress(from));
      InternetAddress[] address = InternetAddress.parse(email, false);
      msg.setRecipients(Message.RecipientType.TO, address);
      msg.setSubject("office activities");

      StringBuilder bodyMsg = new StringBuilder();
      bodyMsg.append("Dear ").append(userName).append("!").append('\n').
              append("Your password is ").append(password);
      msg.setText(bodyMsg.toString());
      msg.setSentDate(new Date());
      Transport.send(msg);
    } catch (MessagingException e) {
      throw new RuntimeException("Почтовый сервер не доступен", e);
    }
  }
}
