<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList" %>
<%@ page import="fieldformat.CompanyStockBaseInfoWithDistance" %>
<%@ page import="fieldformat.CompanyStockBaseInfo" %>
<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">

	<link rel="shortcut icon" href="./img/common-icon.jpg">
	<link rel="stylesheet" type="text/css" href="./css/common-style.css">

	<title>企業情報(登録)</title>
</head>
<body>
	<%@ include file="./common.jsp" %>

	<div class="contents-area">
		<form action="SearchCompanyName" method="post">
			<table>
				<tr>
					<td>社名</td>
					<td>
						<input type="text" name="companyName" autocomplete="off">
					</td>
				</tr>
			</table>

			<input type="submit" value="確認">
		</form>

<%
	ArrayList<CompanyStockBaseInfoWithDistance> companyStockBaseInfoWithDistanceList = new ArrayList<CompanyStockBaseInfoWithDistance>();
	companyStockBaseInfoWithDistanceList = (ArrayList<CompanyStockBaseInfoWithDistance>) session.getAttribute("companyStockBaseInfoWithDistanceList");

	if (companyStockBaseInfoWithDistanceList != null) {
%>
		<form action="RegistCompanyBaseInfo" method="post">
			<table class="list-table">
				<tr class="list-table">
					<th class="list-table">会社名</th>
					<th class="list-table">証券コード</th>
					<th class="list-table">上場市場</th>
					<th class="list-table">チェック</th>
				</tr>
<%
			for (int i = 0; i < companyStockBaseInfoWithDistanceList.size(); i++) {
%>
				<tr class="list-table">
					<td class="list-table">
						<%= companyStockBaseInfoWithDistanceList.get(i).getCompanyName() %>
					</td>
					<td class="list-table">
						<%= companyStockBaseInfoWithDistanceList.get(i).getSecuritiesCode() %>
					</td>
					<td class="list-table">
						<%= companyStockBaseInfoWithDistanceList.get(i).getMarket() %>
					</td>
					<td class="list-table">
						<input type="checkbox" name="listNumber" value="<%= i %>">
					</td>
				</tr>
<%
			}
%>
			</table>
			<input type="submit" value="登録">
		</form>
<%
	}
%>

<%
	CompanyStockBaseInfo companyStockBaseInfo = new CompanyStockBaseInfo();
	companyStockBaseInfo = (CompanyStockBaseInfo) request.getAttribute("companyStockBaseInfo");

	if (companyStockBaseInfo != null) {
%>
		選択した企業情報
		<table>
			<tr>
				<th>会社名</th>
				<th>証券コード</th>
				<th>上場市場</th>
			</tr>
			<tr>
				<td><%= companyStockBaseInfo.getCompanyName() %></td>
				<td><%= companyStockBaseInfo.getSecuritiesCode() %></td>
				<td><%= companyStockBaseInfo.getMarket() %></td>
			</tr>
		</table>
<%
	}
%>
	</div>
</body>
</html>