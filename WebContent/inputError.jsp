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
		String title = request.getParameter("title");
		if ("ユーザ名".equals(title)) {
	%>
			<strong>ユーザ名を入力してください。</strong>
	<%
		} else if ("パスワード".equals(title)) {
	%>
			<strong>パスワードは半角英数字で入力してください。</strong>
	<%
		} else if ("メールアドレス".equals(title)) {
	%>
			<strong>メールアドレスはxxxx@xxx.xxx形式で入力してください。</strong>
	<%
		}
	%>
</body>
</html>