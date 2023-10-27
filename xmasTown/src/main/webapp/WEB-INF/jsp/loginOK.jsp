<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Xmas Town</title>
</head>
<body>
<h3>ようこそ<c:out value="${users.userName}" />さん</h3>
<a href="WelcomeServlet">トップへ</a>
</body>
</html>