<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="/css/bootstrap.min.css">
</head>
<body>
    <header>
        <div class="mt-4">
            <h1 class="ml-3"><spring:message code="update.title" text="default"/></h1>
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
        <c:forEach var="error" items="${errors}">
            <div class="alert alert-danger" role="alert">
                <c:out value="${error}" />
            </div>
        </c:forEach>
        <form method="post" action="/gerechten/update">
            <input type="hidden" name="id" value="${meal.id}">
            <div class="form-group">
                <label for="name"><spring:message code="add.name" text="default"/></label>
                <input class="form-control" type="text" name="name" id="name" value="${meal.name}" placeholder="<spring:message code="add.name.placeholder" text="default"/>"/>
            </div>
            <div class="row">
                <div class="col">
                    <div class="form-group">
                        <label for="price"><spring:message code="add.price" text="default"/></label>
                        <input class="form-control" type="number" id="price" step="0.01" name="price" value="${meal.price}" required placeholder="<spring:message code="add.price.placeholder" text="default"/>">
                        <small class="form-text text-muted"><spring:message code="add.price.help" text="default"/></small>
                    </div>
                </div>
                <div class="col">
                    <div class="form-group">
                        <label for="mealType"><spring:message code="add.type" text="default"/></label>
                        <select class="form-control" name="mealType" id="mealType">
                            <c:forEach var="mealType" items="${mealTypes}">
                                <option value="${mealType}"> ${mealType}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </div>
            <input class="btn btn-dark" type="submit" id="addGerecht" value="<spring:message code="update.update" text="default"/>"/>
            <a class="btn btn-dark" href="/gerechten/change"><spring:message code="add.stop" text="default"/></a>
        </form>
    </main>
    <footer class="m-3">
        <small><p>Ruben Claes, <spring:message code="footer" text="default"/></p></small>
    </footer>
    <script src="/js/jquery.js"></script>
    <script src="/js/bootstrap.bundle.js"></script>
</body>
</html>