<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<div>
  <h2>Авторизация</h2>
  <sf:form method="POST" modelAttribute="login">
    <fieldset>
      <table cellspacing="0">
        <tr>
          <th><label for="userName">Логин:</label></th>
          <td><sf:input path="userName" size="30" maxlength="15" id="userName"/></td>
        </tr>

        <tr>
          <th><label for="password">Пароль:</label></th>
          <td><sf:password path="password" size="30" id="password"/></td>
        </tr>

        <tr>
          <td><input type="submit" value="Войти"/></td>
        </tr>
      </table>
    </fieldset>
  </sf:form>
</div>
