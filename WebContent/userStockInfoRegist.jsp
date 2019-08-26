<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">

	<link rel="shortcut icon" href="./img/common-icon.jpg">
	<link rel="stylesheet" type="text/css" href="./css/common-style.css">
<title>保有株情報（登録）</title>
</head>
<body>
	<%@ include file="./common.jsp" %>
	<div class="contents-area">
		<form action="SearchRegistComp" method="post">
			<table>
				<tr>
					<td>会社名</td>
					<td>
						<input type="text" name="searchCompName">
					</td>
				</tr>

				<tr>
					<td>
						<input type="submit" value="検索">
					</td>
				</tr>
			</table>
		</form>

		<%@ include file="./userStockInfoRegistContents.jsp"%>
	</div>
</body>
</html>