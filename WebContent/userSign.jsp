<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">

	<link rel="shortcut icon" href="./img/common-icon.jpg">
	<link rel="stylesheet" type="text/css" href="./css/common-style.css">

	<title>ログイン・ユーザ情報登録</title>
</head>
<body>
	<%@ include file="./common.jsp" %>

	<article>
		<form action="UserInfoSign" method="post">
			<table>
				<tr>
					<td>ユーザ名 : </td>
					<td>
						<input type="text" name="user-name" autocomplete="off" placeholder="User1" title="ユーザ名">
					</td>
				</tr>

				<tr>
					<td>パスワード : </td>
					<td>
						<input type="text" name="user-password" autocomplete="off" placeholder="password" title="パスワード">
					</td>
				</tr>

				<%
					String type = request.getParameter("type");
					if ("regist".equals(type)) {
				%>
					<tr>
						<td>メールアドレス : </td>
						<td>
							<input type="text" name="user-mail" autocomplete="off" placeholder="XXX@xx.com" title="メールアドレス">
							<input type="hidden" name="type" value="regist">
						</td>
					</tr>
				<%} else if ("login".equals(type)) {%>
					<tr>
						<td>
							<input type="hidden" name="type" value="login">
						</td>
					</tr>
				<%} %>

				<tr>
					<td>
						<input type="submit" value="登録" disabled>
					</td>
				</tr>
			</table>
		</form>
	</article>
	<script type="text/javascript" src="./js/user-sign-check.js"></script>
	<script type="text/javascript" src="./js/input-check-common-handling.js"></script>
	<script type="text/javascript" src="./js/common-sub-display.js"></script>
</body>
</html>