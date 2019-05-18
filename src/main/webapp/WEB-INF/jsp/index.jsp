<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="/css/bootstrap.min.css">
        <title>Home</title>
    </head>
    <body>
        <header>
            <div class="mt-4">
                <h1 class="ml-3"><spring:message code="title.text" text="default"/></h1>
            </div>
            <div class="my-3">
                <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav">
                            <li class="nav-item active"><a class="nav-link" href="/home"><spring:message code="navbar.home" text="default"/></a></li>
                            <li class="nav-item"><a class="nav-link" href="/gerechten"><spring:message code="navbar.meals" text="default"/></a></li>
                            <li class="nav-item"><a class="nav-link" href="/weekmenu"><spring:message code="navbar.weekmenu" text="default"/></a></li>
                        </ul>
                    </div>
                </nav>
            </div>
        </header>
        <main class="mx-3">
            <div class="form-row align-items-center">
                <div class="col-auto my-1">
                    <label class="mr-sm-2"><spring:message code="lang.change" text="default"/></label>
                    <select id="locales" class="form-control form-control-sm">
                        <option value=""></option>
                        <option value="en"><spring:message code="lang.eng" text="default"/></option>
                        <option value="nl"><spring:message code="lang.nl" text="default"/></option>
                        <option value="fr"><spring:message code="lang.fr" text="default"/></option>
                    </select>
                </div>
            </div>
        </main>
        <footer class="m-3">
            <small><p>Ruben Claes, <spring:message code="footer" text="default"/></p></small>
        </footer>
        <script src="/js/jquery.js"></script>
        <script src="/js/bootstrap.bundle.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                $("#locales").change(function () {
                    var selectedOption = $('#locales').val();
                    if (selectedOption != ''){
                        window.location.replace('home?language=' + selectedOption);
                    }
                });
            });
        </script>
    </body>
</html>