<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update</title>
</head>
<body>
    <header>
        <h1>Gerecht Updaten</h1>
        <ul>
            <li><a href="/home/">Home</a></li>
            <li><a href="/gerechten/">Gerechten</a></li>
            <li><a href="/weekmenu">Weekmenu</a></li>
        </ul>
    </header>
    <main>
        <c:forEach var="error" items="${errors}">
            <c:out value="${error}" />
        </c:forEach>
        <form method="post" action="/gerechten/update">
            <input type="hidden" name="id" value="${meal.id}">
            <p><label for="name">Beschrijving: </label><input type="text" name="name" id="name" value="${meal.name}"/></p>
            <p><label for="price">Prijs: </label><input type="number" id="price" step="0.01" name="price" value="${meal.price}" required></p>
            <p>
                <label for="mealType">Type: </label>
                <select name="mealType" id="mealType">
                    <c:forEach var="mealType" items="${mealTypes}">
                        <option value="${mealType}"> ${mealType}</option>
                    </c:forEach>
                </select>
            </p>
            <p><input type="submit" id="addGerecht" value="update"/></p>
        </form>
        <p><a href="/gerechten">stop</a></p>
    </main>
    <footer>
        <p>Ruben Claes, Internet Programmeren</p>
    </footer>
</body>
</html>