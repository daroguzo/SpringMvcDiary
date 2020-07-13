<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Search Result</title>

    <!-- Bootstrap core CSS -->
    <link href="../resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="../resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
    <link href="../resources/vendor/simple-line-icons/css/simple-line-icons.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template -->
    <link href="../resources/css/landing-page.min.css" rel="stylesheet">

</head>

<body>

<!-- Navigation -->
<nav class="navbar navbar-light bg-light static-top">
    <div class="container">
        <a class="navbar-brand" href="#">My Diary</a>
        <a class="navbar-brand" href="#">2015301027 김진우</a>
    </div>
</nav>

<!-- Masthead -->
<header class="masthead text-white text-center">
    <div class="overlay"></div>
    <div class="container">
        <div class="row">
            <div class="col-xl-9 mx-auto">
                <h1 class="mb-5">다이어리 검색 결과</h1>
                <c:if test="${sessionScope.id == null}">
                    <h3 class="mb-5">로그인부터 해주세요.</h3>
                </c:if>
                <c:if test="${sessionScope.id != null}">
                    <h3 class="mb-5">${sessionScope.id}님의 다이어리 검색 결과</h3>
                </c:if>
                <c:if test="${message != null}">
                    <h3 class="mb-5">${message}</h3>
                </c:if>
            </div>
            <div class="col-md-10 col-lg-8 col-xl-7 mx-auto">
                <ul>
                    <c:forEach var="diary" items="${searchList}" varStatus="status">
                        <li>
                            <div align="left">
                                    ${status.index+1} : ${diary.name}<br> ${diary.content}<br> ${diary.date}<br>
                            </div>
                            <div align="right">
                                <c:set var="image" value="${diary.imageFile}"/>
                                <c:if test="${!empty image}">
                                    <img src="${diary.imageFile}" height="200" alt="Image"/><br>
                                </c:if>
                                <c:if test="${empty image}">
                                    사진이 없습니다.<br>
                                </c:if>
                            </div>
                            <hr color="white">
                            <br>
                        </li>
                    </c:forEach>
                </ul>
                <input type="button" value="돌아가기" class="form-control form-control-lg" onclick="location.href='main'">
            </div>
        </div>
    </div>
</header>

<!-- Bootstrap core JavaScript -->
<script src="../resources/vendor/jquery/jquery.min.js"></script>
<script src="../resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>