<%@ page contentType="text/html;charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head> <meta charset="utf-8"> <title>메뉴</title>
</head>
<body>
<h1>메뉴 선택</h1><br>
<form >
    <input type="button" value="계정 관리" onclick="location.href='account'"><br>
    <input type="button" value="다이어리 관리" onclick="location.href='diary'"><br>
    <input type="button" value="검색" onclick="location.href='find'"><br>
</form>
</body>
</html>