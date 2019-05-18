<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
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
                <h1 class="ml-3" th:text = "#{title.text}"></h1>
            </div>
            <div class="my-3">
                <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav">
                            <li class="nav-item active"><a class="nav-link" href="/home">Home</a></li>
                            <li class="nav-item"><a class="nav-link" href="/gerechten">Gerechten</a></li>
                            <li class="nav-item"><a class="nav-link" href="/weekmenu">Weekmenu</a></li>
                        </ul>
                    </div>
                </nav>
            </div>

            <span th:text="#{lang.change}"></span>:
            <select id="locales">
                <option value=""></option>
                <option value="en" th:text="#{lang.eng}"></option>
                <option value="nl" th:th:text="#{lang.nl}"></option>
            </select>

        </header>
        <main class="mx-3"></main>
        <footer class="m-3">
            <small><p>Ruben Claes, Internet Programmeren</p></small>
        </footer>
        <script src="/js/jquery.js"></script>
        <script src="/js/bootstrap.bundle.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                $("#locales").change(function () {
                    var selectedOption = $('#locales').val();
                    if (selectedOption != ''){
                        window.location.replace('international?language=' + selectedOption);
                    }
                });
            });
        </script>
    </body>
</html>