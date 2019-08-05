<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/input-error-style.css">
<title>入力チェックエラー</title>
</head>
<body>
	<%
		String errorMsg = request.getParameter("message");
	%>
			<strong><%= errorMsg %></strong>

</body>
</html>