<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Gerechten</title>
    </head>
    <body>
        <header>
            <h1>Gerechten</h1>
            <ul>
                <li><a href="/home">Home</a></li>
                <li><a href="/weekmenu">Weekmenu</a></li>
            </ul>
        </header>
        <main>
            <c:choose>
                <c:when test="${empty meals}">
                    <p>Er staan geen gerechten op het menu.</p>
                </c:when>
                <c:otherwise>
                    <table>
                        <thead>
                        <th>Gerecht</th>
                        <th>Prijs</th>
                        </thead>
                        <tbody>
                        <c:forEach items="${meals}" var="meal">
                            <tr>
                                <td><c:out value="${meal.name}"/></td>
                                <td><c:out value="€${meal.price}"/></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:otherwise>
            </c:choose>
            <a href="/gerechten/add">voeg gerecht toe</a>
            <a href="/gerechten/change">verander gerechten</a>
        </main>
        <footer>
            <p>Ruben Claes, Internet Programmeren</p>
        </footer>
    </body>
</html>