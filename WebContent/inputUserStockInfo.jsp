<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="fieldformat.CompanyStockBaseInfo " %>
<%@ page import="fieldformat.Companies" %>
<%@ page import="fieldformat.UserStockInfo" %>

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

		Companies companies = new Companies();
		companies = (Companies) request.getAttribute("companies");

		if (companyStockBaseInfo != null && companies != null && userInformation != null) {
			if (companyStockBaseInfo.getCompanyName() != null && companies.getId() > 0 && userInformation.getUserId() > 0) {
%>
				<p>
					<%= companyStockBaseInfo.getCompanyName() %>について以下の情報を入力してください。
					<img src="./img/howto.jpg" class="howto" title="使い方を見る">
				</p>

				<form action="RegistUserStockInformation" method="post">
					<input type="hidden" name="userId" value="<%= userInformation.getUserId() %>">
					<input type="hidden" name="compId" value="<%= companies.getId() %>">
					<input type="hidden" name="compName" value="<%= companyStockBaseInfo.getCompanyName() %>">
					<div id="stockInfoInput">
						<table>
							<tr>
								<td>保有数</td>
								<td>
									<input type="number" name="numStock" title="保有数">
								</td>
							</tr>

							<tr>
								<td>買値</td>
								<td>
									<input type="number" name="buyingPrice" title="買値">
								</td>
							</tr>

							<tr>
								<td>売値</td>
								<td>
									<input type="number" name="sellingPrice" title="売値">
								</td>
							</tr>
						</table>
					</div>

					<input type="submit" value="登録" disabled>
				</form>
<%
			}
		}

		UserStockInfo userStockInfo = new UserStockInfo();
		userStockInfo = (UserStockInfo) request.getAttribute("userStockInfo");

		MessageAreaDisplayContents messageAreaDisplayContentsShow = new MessageAreaDisplayContents();
		messageAreaDisplayContentsShow = (MessageAreaDisplayContents) request.getAttribute("messageAreaDisplayContents");

		if (userStockInfo != null && messageAreaDisplayContentsShow != null) {
			if (userStockInfo.getUserId() > 0 && !messageAreaDisplayContentsShow.isError()) {
				String registedCompanyName = (String) request.getAttribute("registedCompanyName");
%>
				<%= registedCompanyName %>の保有株情報を以下の通り登録しました。
				<table>
					<tr>
						<td>保有数</td>
						<td><%= userStockInfo.getNumStock() %></td>
					</tr>

					<tr>
						<td>買値</td>
						<td><%= userStockInfo.getBuyingPrice() %></td>
					</tr>

					<tr>
						<td>売値</td>
						<td><%= userStockInfo.getSellingPrice() %></td>
					</tr>
				</table>
<%
			}
		}
%>
	</div>

	<script type="text/javascript" src="./js/input-check-common-handling.js"></script>
	<script type="text/javascript" src="./js/common-sub-display.js"></script>
	<script type="text/javascript" src="./js/user-stock-info-check.js"></script>
</body>
</html>