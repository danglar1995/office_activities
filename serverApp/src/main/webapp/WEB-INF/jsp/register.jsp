<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div>
  <h2>Регистрация</h2>
  <form:form method="POST" modelAttribute="register">
    <fieldset>

      <table cellspacing="0">
        <tr>
          <th><label for="userFullName">Ф.И.О:</label></th>
          <td>
            <form:input path="userFullName" size="50" maxlength="100" id="userFullName"/>
            <form:errors path="userFullName"/>
          </td>
        </tr>

        <tr>
          <th><label for="department">Отдел:</label></th>
          <td>
            <form:select path="department" id="department">
              <form:option value="1" label="Аналитика"/>
              <form:option value="2" label="Разработка"/>
              <form:option value="3" label="Тестирование"/>
            </form:select>
          </td>
        </tr>

        <tr>
          <th><label for="email">Почта:</label></th>
          <td>
            <form:input path="email" size="50" maxlength="30" id="email"/>
            <form:errors path="email"/>
          </td>
        </tr>

        <tr>
          <th><label for="userName">Логин:</label></th>
          <td>
            <form:input path="userName" size="50" maxlength="15" id="userName"/>
            <form:errors path="userName"/>
          </td>
        </tr>

        <tr>
          <th><label for="password">Пароль:</label></th>
          <td>
            <form:password path="password" size="50" maxlength="20" id="password"/>
            <form:errors path="password"/>
          </td>
        </tr>

        <tr>
          <td><input type="submit" name="register" value="Зарегистрировать"/></td>
        </tr>
      </table>
    </fieldset>
  </form:form>
</div>
