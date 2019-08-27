<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="fieldformat.CompanyStockBaseInfo " %>
<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">

	<link rel="shortcut icon" href="./img/common-icon.jpg">
	<link rel="stylesheet" type="text/css" href="./css/common-style.css">

	<title>保有株の詳細登録</title>
</head>
<body>
	<%@ include file="common.jsp" %>

	<div class="contents-area">
<%
		CompanyStockBaseInfo companyStockBaseInfo = new CompanyStockBaseInfo();
		companyStockBaseInfo = (CompanyStockBaseInfo) request.getAttribute("companyStockBaseInfo");
		if (companyStockBaseInfo != null) {
			if (companyStockBaseInfo.getCompanyName() != null) {
%>
				<p><%= companyStockBaseInfo.getCompanyName() %>について以下の情報を入力してください。</p>
				<form action="RegistUserStockInfo" method="post">
					<input type="hidden" name="userId">
					<input type="hidden" name="compId">
					<table>
						<tr>
							<td>保有数</td>
							<td>
								<input type="number" name="numStock">
							</td>
						</tr>

						<tr>
							<td>買値</td>
							<td>
								<input type="number" name="buyingPrice">
							</td>
						</tr>

						<tr>
							<td>売値</td>
							<td>
								<input type="number" name="sellingPrice">
							</td>
						</tr>
					</table>

					<input type="submit" value="登録">
				</form>
<%
			}
		}
%>
	</div>
</body>
</html>