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
				<table class="list-table">
					<tr class="list-table">
						<th class="list-table">証券会社名</th>
						<th class="list-table">委託手数料</th>
						<th class="list-table">適用開始日</th>
						<th class="list-table">適用終了日</th>
					</tr>
<%
				for (int i = 0; i <displayContentsBrokerageCommissionsList.size(); i++ ){
%>
					<tr class="list-table">
						<td class="list-table"><%= displayContentsBrokerageCommissionsList.get(i).getCompanyName() %></td>
						<td class="list-table"><%= displayContentsBrokerageCommissionsList.get(i).getBraokerageCommission() %></td>
						<td class="list-table"><%= displayContentsBrokerageCommissionsList.get(i).getStartDate() %></td>
						<td class="list-table"><%= displayContentsBrokerageCommissionsList.get(i).getEndDate() %></td>
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
			ArrayList<CapitalGainsTaxes> capitalGainsTaxesList = new ArrayList<CapitalGainsTaxes>();

			capitalGainsTaxesList = (ArrayList<CapitalGainsTaxes>) request.getAttribute("capitalGainsTaxesList");

			if (capitalGainsTaxesList != null) {
%>
				<table class="list-table">
					<tr class="list-table">
						<th class="list-table">キャピタルゲイン課税</th>
						<th class="list-table">適用開始日</th>
						<th class="list-table">適用終了日</th>
					</tr>
<%
				for (int i = 0; i < capitalGainsTaxesList.size(); i++) {
%>
					<tr class="list-table">
						<td class="list-table"><%= capitalGainsTaxesList.get(i).getTaxRate() %></td>
						<td class="list-table"><%= capitalGainsTaxesList.get(i).getStartDay() %></td>
						<td class="list-table"><%= capitalGainsTaxesList.get(i).getEndDay() %></td>
					</tr>

<%
				}
%>
				</table>
<%
			}

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
			ArrayList<ConsumptionTaxes> consumptionTaxesList = new ArrayList<ConsumptionTaxes>();
			consumptionTaxesList = (ArrayList<ConsumptionTaxes>) request.getAttribute("consumptionTaxesList");

			if (consumptionTaxesList != null) {
%>
				<table class="list-table">
					<tr class="list-table">
						<th class="list-table">消費税</th>
						<th class="list-table">適用開始日</th>
						<th class="list-table">適用終了日</th>
					</tr>

<%
				for (int i = 0; i < consumptionTaxesList.size(); i++) {
%>
					<tr class="list-table">
						<td class="list-table"><%= consumptionTaxesList.get(i).getTaxRate() %></td>
						<td class="list-table"><%= consumptionTaxesList.get(i).getStartDay() %></td>
						<td class="list-table"><%= consumptionTaxesList.get(i).getEndDay() %></td>
					</tr>
<%
				}
%>
				</table>
<%
			}
		}
	} else {
%>
		<%= tradingCostTypeSelectCheckResult.getErrorMessage()%>
<%
	}
}
%>