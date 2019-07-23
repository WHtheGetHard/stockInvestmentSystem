<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList" %>
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

	<article>
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
	</article>

<%
	ArrayList<CompanyStockBaseInfo> companyStockBaseInfoList = new ArrayList<CompanyStockBaseInfo>();
	companyStockBaseInfoList = (ArrayList<CompanyStockBaseInfo>) session.getAttribute("companyStockBaseInfoList");

	if (companyStockBaseInfoList != null) {
%>
		<form action="RegistCompanyBaseInfo" method="post">
			<table>
				<tr>
					<th>会社名</th>
					<th>証券コード</th>
					<th>上場市場</th>
					<th>チェック</th>
				</tr>
<%
			for (int i = 0; i < companyStockBaseInfoList.size(); i++) {
%>
				<tr>
					<td>
						<%= companyStockBaseInfoList.get(i).getCompanyName() %>
					</td>
					<td>
						<%= companyStockBaseInfoList.get(i).getSecuritiesCode() %>
					</td>
					<td>
						<%= companyStockBaseInfoList.get(i).getMarket() %>
					</td>
					<td>
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
</body>
</html>