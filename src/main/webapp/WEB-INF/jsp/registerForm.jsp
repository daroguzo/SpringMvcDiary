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

    <title>회원가입</title>

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
                <h1 class="mb-5">회원가입</h1>
                <c:set var="msg" value="${errorMessage}"/>
                <c:if test="${!empty msg}">
                    <h3 class="mb-5">${errorMessage}</h3>
                </c:if>
                <c:if test="${empty msg}">
                    <h3 class="mb-5">아이디와 비밀번호 입력!</h3>
                </c:if>
            </div>
            <div class="col-md-10 col-lg-8 col-xl-7 mx-auto">
                <form method="post" action="register">
                    <div class="form-row">
                        아이디: <input type="text" class="form-control form-control-lg" placeholder="ID 입력" name="id"><br>
                        비밀번호: <input type="password" class="form-control form-control-lg" placeholder="비밀번호 입력"
                                     name="password"><br>
                        비밀번호 확인: <input type="password" class="form-control form-control-lg" placeholder="비밀번호 확인"
                                        name="password2">
                        <div class="col-5 col-md-6 mb-2 mb-md-0">
                            <input type="submit" class="form-control form-control-lg" value="제출">
                        </div>
                        <div class="col-5 col-md-6 mb-2 mb-md-0">
                            <input type="reset" class="btn btn-block btn-lg btn-primary" value="취소">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</header>

<!-- Bootstrap core JavaScript -->
<script src="../resources/vendor/jquery/jquery.min.js"></script>
<script src="../resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
