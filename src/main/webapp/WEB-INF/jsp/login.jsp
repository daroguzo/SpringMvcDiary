<%@ page contentType="text/html;charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head> <meta charset="utf-8"> <title>다이어리 로그인</title>
</head>
<body>
<h1>My Diary</h1><br>
<h3>로그인해주세요</h3>
<form method="post" action="loginCheck">
    <input type="text" name="id"><br>
    <input type="password" name="password"><br>
    <input type="submit" name="로그인"><br>
</form>


</body>
</html>