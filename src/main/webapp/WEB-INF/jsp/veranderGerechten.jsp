<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Gerechten</title>
        <link rel="stylesheet" href="/resources/static/css/style.css">
    </head>
    <body>
        <header>
            <h1>Verander Gerechten</h1>
            <ul>
                <li><a href="/home/">Home</a></li>
                <li><a href="/gerechten">Gerechten</a></li>
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
                        </thead>
                        <tbody>
                        <c:forEach items="${meals}" var="meal">
                            <tr>
                                <td><c:out value="${meal.name}"/></td>
                                <td><a href="/gerechten/update?name=${meal.name}">update</a></td>
                                <td><a href="/gerechten/delete?name=${meal.name}">verwijder</a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:otherwise>
            </c:choose>
            <a href="/gerechten/add">voeg gerecht toe</a>
        </main>
        <footer>
            <p>Ruben Claes, Internet Programmeren</p>
        </footer>
    </body>
</html>