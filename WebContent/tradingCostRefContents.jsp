<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="fieldformat.TradingCostTypeSelectCheckResult" %>
<%@ page import="fieldformat.DisplayContentsBrokerageCommissions" %>
<%@ page import="fieldformat.CapitalGainsTaxes" %>
<%@ page import="fieldformat.ConsumptionTaxes" %>
<%@ page import="java.util.ArrayList" %>

<%
TradingCostTypeSelectCheckResult tradingCostTypeSelectCheckResult
	= new TradingCostTypeSelectCheckResult();

tradingCostTypeSelectCheckResult
	= (TradingCostTypeSelectCheckResult) request.getAttribute("tradingCostTypeSelectCheckResult");

if (tradingCostTypeSelectCheckResult != null) {
	if (tradingCostTypeSelectCheckResult.isValidValue()) {
		if ("1".equals(tradingCostTypeSelectCheckResult.getTradingCostType())) {
%>
			<h2>売買委託手数料情報の確認</h2>

			<form action="GetCostTypeList" method="post">
				<input type="hidden" name="tradingCostType" value="1">
				<input type="submit" value="一覧">
			</form>

			<form action="SearchCostType" method="post">
				<input type="hidden" name="tradingCostType" value="1">
				<input type="submit" value="検索">
			</form>
<%
			ArrayList<DisplayContentsBrokerageCommissions> displayContentsBrokerageCommissionsList = new ArrayList<DisplayContentsBrokerageCommissions>();

			displayContentsBrokerageCommissionsList = (ArrayList<DisplayContentsBrokerageCommissions>) request.getAttribute("displayContentsBrokerageCommissionsList");

			if (displayContentsBrokerageCommissionsList != null) {
%>
				<table>
					<tr>
						<th>証券会社名</th>
						<th>委託手数料</th>
						<th>適用開始日</th>
						<th>適用終了日</th>
					</tr>
<%
				for (int i = 0; i <displayContentsBrokerageCommissionsList.size(); i++ ){
%>
					<tr>
						<td><%= displayContentsBrokerageCommissionsList.get(i).getCompanyName() %></td>
						<td><%= displayContentsBrokerageCommissionsList.get(i).getBraokerageCommission() %></td>
						<td><%= displayContentsBrokerageCommissionsList.get(i).getStartDate() %></td>
						<td><%= displayContentsBrokerageCommissionsList.get(i).getEndDate() %></td>
					</tr>
<%
				}
%>
				</table>
<%
			}

		} else if ("2".equals(tradingCostTypeSelectCheckResult.getTradingCostType())) {
%>
			<h2>キャピタルゲイン課税情報の確認</h2>

			<form action="GetCostTypeList" method="post">
				<input type="hidden" name="tradingCostType" value="2">
				<input type="submit" value="一覧">
			</form>


			<form action="SearchCostType" method="post">
				<input type="hidden" name="tradingCostType" value="2">
				<input type="submit" value="検索">
			</form>
<%
		} else if ("3".equals(tradingCostTypeSelectCheckResult.getTradingCostType())) {
%>
			<h2>消費税の確認</h2>

			<form action="GetCostTypeList" method="post">
				<input type="hidden" name="tradingCostType" value="3">
				<input type="submit" value="一覧">
			</form>


			<form action="SearchCostType" method="post">
				<input type="hidden" name="tradingCostType" value="3">
				<input type="submit" value="検索">
			</form>
<%
		}
	} else {
%>
		<%= tradingCostTypeSelectCheckResult.getErrorMessage()%>
<%
	}
}
%>