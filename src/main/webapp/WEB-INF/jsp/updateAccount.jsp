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

    <title>계정정보 수정</title>

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
                <c:if test="${sessionScope.id == null}">
                    <h1 class="mb-5">로그인부터 해주세요.</h1>
                </c:if>
                <c:if test="${sessionScope.id != null}">
                    <h1 class="mb-5">${sessionScope.id}님의 계정정보 수정</h1>
                </c:if>

                <c:if test="${message == null}">
                    <h1 class="mb-5">수정할 정보를 선택하세요.</h1>
                </c:if>
                <c:if test="${message != null}">
                    <h1 class="mb-5">${message}</h1>
                </c:if>
            </div>
            <div class="col-md-10 col-lg-8 col-xl-7 mx-auto">
                <input type="button" value="이름 변경" class="form-control form-control-lg"
                       onclick="location.href='nameForm'"><br>
                <input type="button" value="전화번호 변경" class="btn btn-block btn-lg btn-primary"
                       onclick="location.href='phoneForm'"><br>
                <input type="button" value="주소 변경" class="form-control form-control-lg"
                       onclick="location.href='addressForm'"><br>
                <input type="button" value="돌아가기" class="btn btn-block btn-lg btn-primary"
                       onclick="location.href='account'"><br>
            </div>
        </div>
    </div>
</header>

<!-- Bootstrap core JavaScript -->
<script src="../resources/vendor/jquery/jquery.min.js"></script>
<script src="../resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
