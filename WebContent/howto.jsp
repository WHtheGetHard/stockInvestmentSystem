<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>入力説明</title>
</head>
<body>
	<%
		String openDisp = request.getParameter("openDisp");
		String hasError = request.getParameter("hasError");
		String msg = request.getParameter("msg");

		if ("inputUserStockInfo".equals(openDisp)) {
			if ("true".equals(hasError) && !"".equals(msg)) {
	%>
			<p>
				入力項目にミスがあります。：<%= msg %>
			</p>
	<%
			}
	%>
			信用売りを実施している場合：保有数と売値を入力してください。<br>
			それ以外の場合：保有数と買値を入力してください。<br>
	<%
		}
	%>
</body>
</html>