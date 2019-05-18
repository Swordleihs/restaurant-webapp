<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Gerechten</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="/css/bootstrap.min.css">
    </head>
    <body>
        <header>
            <div class="mt-4">
                <h1 class="ml-3">Gerechten Veranderen</h1>
            </div>
            <div class="my-3">
                <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav">
                            <li class="nav-item"><a class="nav-link" href="/home">Home</a></li>
                            <li class="nav-item active"><a class="nav-link" href="/gerechten">Gerechten</a></li>
                            <li class="nav-item"><a class="nav-link" href="/weekmenu">Weekmenu</a></li>
                        </ul>
                    </div>
                </nav>
            </div>
        </header>
        <main class="mx-3">
            <c:choose>
                <c:when test="${empty meals}">
                    <div class="alert alert-danger" role="alert">
                        Er staan geen gerechten op het menu!
                    </div>
                </c:when>
                <c:otherwise>
                    <table class="table">
                        <thead class="thead-light">
                            <th scope="col">Gerecht</th>
                        </thead>
                        <tbody>
                        <c:forEach items="${meals}" var="meal">
                            <tr scope="row">
                                <td><c:out value="${meal.name}"/></td>
                                <td>
                                    <a class="btn btn-dark btn-sm" href="/gerechten/update?name=${meal.name}">update</a>
                                    <a class="btn btn-dark btn-sm" href="/gerechten/delete?name=${meal.name}">verwijder</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:otherwise>
            </c:choose>
            <a class="btn btn-dark" href="/gerechten/add">voeg gerecht toe</a>
        </main>
        <footer class="m-3">
            <small><p>Ruben Claes, Internet Programmeren</p></small>
        </footer>
        <script src="/js/jquery.js"></script>
        <script src="/js/bootstrap.bundle.js"></script>
    </body>
</html>