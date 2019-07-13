<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="fieldformat.TradingCostTypeSelectCheckResult" %>

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