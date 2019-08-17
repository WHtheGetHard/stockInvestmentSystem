<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<link rel="shortcut icon" href="./img/common-icon.jpg">
	<link rel="stylesheet" type="text/css" href="./css/common-style.css">
	<link rel="stylesheet" type="text/css" href="./css/ref-companyinfo-style.css">
	<title>企業情報の確認</title>
</head>
<body>
	<%@ include file="./common.jsp" %>
	<div class="contents-area">
		<form action="SearchTypeSelect" method="post">
			検索方法を検索してください。<br>
			<select name="selectedSearchType">
				<option value=""></option>
				<option value="1">会社名</option>
				<option value="2">証券コード</option>
				<option value="3">上場市場</option>
			</select>

			<table>
				<tr>
					<td id="searchType"></td>
					<td>
						<input type="text" name="searchWord" autocomplete="off">
					</td>
				</tr>
			</table>
			<input type="submit" name="searchbutton" value="検索" disabled>
		</form>

		<%@ include file="./contentsCompanyInfo.jsp" %>
	</div>

	<script type="text/javascript" src="./js/input-check-common-handling.js"></script>
	<script type="text/javascript" src="./js/search-type-change.js"></script>
</body>
</html>