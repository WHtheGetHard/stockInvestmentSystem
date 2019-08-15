<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<link rel="shortcut icon" href="./img/common-icon.jpg">
	<link rel="stylesheet" type="text/css" href="./css/common-style.css">
	<title>企業情報の確認</title>
</head>
<body>
	<%@ include file="./common.jsp" %>
	<div class="contents-area">
		<form action="SearchTypeSelect" method="post">
			検索方法を検索してください。<br>
			<select name="selectedSearchType">
				<option value="1">会社名</option>
				<option value="2">証券コード</option>
				<option value="3">上場市場</option>
			</select>

			<input type="submit" value="選択">
		</form>
	</div>
</body>
</html>