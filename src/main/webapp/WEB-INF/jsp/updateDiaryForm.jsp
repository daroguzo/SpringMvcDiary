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

    <title>다이어리 수정</title>

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
                    <h1 class="mb-5">${sessionScope.id}님의 다이어리 수정</h1>
                </c:if>
            </div>
            <div class="col-md-10 col-lg-8 col-xl-7 mx-auto">
                <form method="post" action="updateDiary" enctype="multipart/form-data">
                    <div class="form-row">
                        제목<input type="text" class="form-control form-control-lg" placeholder="제목 입력" name="name" value="${param.name}">
                        내용<textarea name="content" class="form-control form-control-lg" cols="50" rows="10">${param.content}</textarea>
                        이미지 파일<input type="file" name="file" accept="image/*" value="${param.imageFile}">
                        <input type="hidden" name="diaryId" value="${param.diaryId}"><br><br><br>
                        <div class="col-5 col-md-6 mb-2 mb-md-0">
                            <input type="submit" class="form-control form-control-lg" value="수정">
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
