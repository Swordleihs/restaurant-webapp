<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete</title>
    <link rel="stylesheet" href="/resources/static/css/style.css">
</head>
<body>
<header>
    <h1>Gerecht Verwijderen</h1>
    <ul>
        <li><a href="/home/">Home</a></li>
        <li><a href="/gerechten/">Gerechten</a></li>
    </ul>
</header>
<main>
    <p>Weet u zeker dat u het gerecht: "<c:out value="${meal.name}"/>" wilt verwijderen?</p>
    <form method="get" action="/gerechten/confirmdelete"><input type="text" name="beschrijving" value="${meal.name}" hidden/><input type="submit" value="ja"/></form>
    <a href="/gerechten/change">nee</a>
</main>
<footer></footer>
</body>
</html>