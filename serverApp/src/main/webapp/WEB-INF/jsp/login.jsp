<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div>
  <h2>Авторизация</h2>
  <form:form method="POST" modelAttribute="login">
    <fieldset>
      <table cellspacing="0">
        <tr>
          <th><label for="userName">Логин:</label></th>
          <td><form:input path="userName" size="30" maxlength="15" id="userName"/></td>
        </tr>

        <tr>
          <th><label for="password">Пароль:</label></th>
          <td><form:password path="password" size="30" id="password"/></td>
        </tr>

        <tr>
          <td><input type="submit" name="signUp" value="Войти"/></td>
          <td><input type="submit" name="register" value="Зарегистрироваться"/></td>
          <td><input type="submit" name="forgotPass" value="Забыли пароль?"/></td>
        </tr>
      </table>
    </fieldset>
  </form:form>
</div>
