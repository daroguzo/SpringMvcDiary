<%@ page contentType="text/html;charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head> <meta charset="utf-8">
</head>
<body>
<h1>Account List</h1><br>
<ul>
    <c:forEach var="account" items="${accounts}" varStatus="status">
        <li>
                ${status.index+1} : ${account.name}, ${account.password}, ${account.userName}, ${account.phoneNumber}, ${account.address}
        </li>
    </c:forEach>
</ul>

</body>
</html>