<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Meals</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="/css/bootstrap.min.css">
    </head>
    <body>
        <header>
            <div class="mt-4">
                <h1 class="ml-3"><spring:message code="title.text.meals" text="default"/></h1>
            </div>
            <div class="my-3">
                <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav">
                            <li class="nav-item"><a class="nav-link" href="/home"><spring:message code="navbar.home" text="default"/></a></li>
                            <li class="nav-item active"><a class="nav-link" href="/gerechten"><spring:message code="navbar.meals" text="default"/></a></li>
                            <li class="nav-item"><a class="nav-link" href="/weekmenu"><spring:message code="navbar.weekmenu" text="default"/></a></li>
                        </ul>
                    </div>
                </nav>
            </div>
        </header>
        <main class="mx-3">
            <c:choose>
                <c:when test="${empty meals}">
                    <div class="alert alert-danger" role="alert">
                        <spring:message code="menu.alert" text="default"/>
                    </div>
                </c:when>
                <c:otherwise>
                    <table class="table">
                        <thead class="thead-light">
                            <th scope="col"><spring:message code="meals.head.meal" text="default"/></th>
                            <th scope="col"><spring:message code="meals.head.price" text="default"/></th>
                        </thead>
                        <tbody>
                        <c:forEach items="${meals}" var="meal">
                            <tr scope="row">
                                <td><c:out value="${meal.name}"/></td>
                                <td><c:out value="€${meal.price}"/></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:otherwise>
            </c:choose>
            <div class="my-3">
                <a class="btn btn-dark" href="/gerechten/add"><spring:message code="meals.add" text="default"/></a>
                <a class="btn btn-dark" href="/gerechten/change"><spring:message code="meals.change" text="default"/></a>
            </div>
        </main>
        <footer class="m-3">
            <small><p>Ruben Claes, <spring:message code="footer" text="default"/></p></small>
        </footer>
        <script src="/js/jquery.js"></script>
        <script src="/js/bootstrap.bundle.js"></script>
    </body>
</html>