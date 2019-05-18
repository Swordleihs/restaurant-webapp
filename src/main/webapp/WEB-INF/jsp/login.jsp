<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="/style.css">
</head>
<body>

<form action="/login" method="POST">
    <label for="username"><spring:message code="username"/>username</label>
    <input type="text" name="username" id="username">
    <br>
    <label for="pw"><spring:message code="pw"/>password</label>
    <input type="password" name="password" id="pw">
    <br>
    <input type="submit" name="submit" value="LOGIN">
</form>

</body>
</html>