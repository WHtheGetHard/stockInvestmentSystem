<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList" %>
<%@ page import="fieldformat.CompanyDetails" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/common-style.css">
<title>企業情報詳細</title>
</head>
<body>

<%
	int listIndex = Integer.parseInt(request.getParameter("listIndex"));

	ArrayList<CompanyDetails> companyDetailsList = new ArrayList<CompanyDetails>();
	companyDetailsList = (ArrayList<CompanyDetails>) session.getAttribute("companyDetailsList");

	if (companyDetailsList != null) {
		if (companyDetailsList.size() > 0) {
%>
			<%= companyDetailsList.get(listIndex).getTargetDate() %>期の<%= companyDetailsList.get(listIndex).getCompanyName() %>の損益計算書(単位[100万円])
			<table class="list-table">
				<tr class="list-table">
					<th class="list-table">項目名</th>
					<th class="list-table">最新</th>
					<th class="list-table">業界平均</th>
				<tr>

				<tr class="list-table">
					<td class="list-table">売上高</td>
					<td class="list-table"><%= companyDetailsList.get(listIndex).getAmountOfSales() %></td>
					<td class="list-table"><%= companyDetailsList.get(listIndex).getAmoutOfSales_fieldMeans() %></td>
				</tr>

				<tr class="list-table">
					<td class="list-table">売上総利益</td>
					<td class="list-table"><%= companyDetailsList.get(listIndex).getGrossProfit() %></td>
					<td class="list-table"><%= companyDetailsList.get(listIndex).getGrossProfit_fieldMeans() %></td>
				</tr>

				<tr class="list-table">
					<td class="list-table">営業利益</td>
					<td class="list-table"><%= companyDetailsList.get(listIndex).getOperatingIncome() %></td>
					<td class="list-table"><%= companyDetailsList.get(listIndex).getOperatingIncome_fieldMeans() %></td>
				</tr>

				<tr class="list-table">
					<td class="list-table">経営利益</td>
					<td class="list-table"><%= companyDetailsList.get(listIndex).getManagementProfit() %></td>
					<td class="list-table"><%= companyDetailsList.get(listIndex).getManagementProfit_fieldMeans() %></td>
				</tr>

				<tr class="list-table">
					<td class="list-table">税引前当期純利益</td>
					<td class="list-table"><%= companyDetailsList.get(listIndex).getNetIncomeBeforeTax() %></td>
					<td class="list-table"><%= companyDetailsList.get(listIndex).getNetIncomeBeforeTax_fieldMeans() %></td>

				<tr  class="list-table">
					<td class="list-table">当期純利益</td>
					<td class="list-table"><%= companyDetailsList.get(listIndex).getNetIncome() %></td>
					<td class="list-table"><%= companyDetailsList.get(listIndex).getNetIncome_fieldMeans() %></td>
				</tr>
			</table>
			<strong>※()書きはマイナスを表す</strong>
<%
		}
	}
%>

</body>
</html>