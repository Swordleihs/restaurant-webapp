<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="/css/bootstrap.min.css">
        <title>Login</title>
    </head>
    <body>
        <header>
            <div class="mt-4">
                <h1 class="ml-3"><spring:message code="login.title" text="default"/></h1>
            </div>
            <div class="my-3">
                <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav">
                            <li class="nav-item"><a class="nav-link disabled" href="/home"><spring:message code="navbar.home" text="default"/></a></li>
                            <li class="nav-item"><a class="nav-link disabled" href="/gerechten"><spring:message code="navbar.meals" text="default"/></a></li>
                            <li class="nav-item"><a class="nav-link disabled" href="/weekmenu"><spring:message code="navbar.weekmenu" text="default"/></a></li>
                        </ul>
                    </div>
                </nav>
            </div>
        </header>
        <main class="mx-3">
            <div class="alert alert-danger" role="alert">
                <spring:message code="login.alert" text="default"/>
            </div>
            <form action="/login" method="POST">
                <div class="form-group">
                    <label for="username"><spring:message code="login.username" text="default"/></label>
                    <input class="form-control" type="text" name="username" id="username" placeholder="<spring:message code="login.username.placeholder" text="default"/>">
                </div>
                <div class="form-group">
                    <label for="pw"><spring:message code="login.password" text="default"/></label>
                    <input class="form-control" type="password" name="password" id="pw" placeholder="<spring:message code="login.password.placeholder" text="default"/>">
                </div>
                <input class="btn btn-dark" type="submit" name="submit" value="<spring:message code="login.login" text="default"/>">
            </form>
        </main>
        <footer class="m-3">
            <small><p>Ruben Claes, <spring:message code="footer" text="default"/></p></small>
        </footer>
        <script src="/js/jquery.js"></script>
        <script src="/js/bootstrap.bundle.js"></script>
    </body>
</html>