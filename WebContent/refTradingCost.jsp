<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">

	<link rel="shortcut icon" href="./img/common-icon.jpg">
	<link rel="stylesheet" type="text/css" href="./css/common-style.css">

	<title>売買関連費用（確認）</title>
</head>
<body>
	<%@ include file="./common.jsp" %>
	<article>
		<form action="TradingCostTypeSelect" method="post">
			<select name="tradingCostType">
				<option value="1">売買委託手数料</option>
				<option value="2">キャピタルゲイン課税</option>
				<option value="3">消費税</option>
			</select>

			<input type="hidden" name="caller" value="ref">
			<input type="submit" value="選択">
		</form>
	</article>

	<%@ include file="./tradingCostRefContents.jsp" %>
</body>
</html>