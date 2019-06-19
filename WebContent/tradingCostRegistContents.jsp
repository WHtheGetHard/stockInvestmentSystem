<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="fieldformat.RegistTradingCostTypeSelectCheckResult" %>

<%
RegistTradingCostTypeSelectCheckResult registTradingCostTypeSelectCheckResult
	= new RegistTradingCostTypeSelectCheckResult();

registTradingCostTypeSelectCheckResult
	= (RegistTradingCostTypeSelectCheckResult) request.getAttribute("registTradingCostTypeSelectCheckResult");

if (registTradingCostTypeSelectCheckResult != null) {
	if (registTradingCostTypeSelectCheckResult.isValidValue()) {
		if ("1".equals(registTradingCostTypeSelectCheckResult.getTradingCostType())) {
%>
			<h2>売買委託手数料情報の登録</h2>

			<form action="RegistContentsExec" method="post">
				<table>
					<tr>
						<td>証券会社名</td>

						<td>
							<input type="text" name="companyName" autocomplete="off" title="証券会社名">
						</td>
					</tr>

					<tr>
						<td>売買委託手数料</td>

						<td>
							<input type="text" name="braokerageCommission" autocomplete="off" data-type="currency" title="売買委託手数料">
						</td>
					</tr>

					<tr>
						<td>適用開始日</td>

						<td>
							<input type="text" name="startDate" autocomplete="off" data-type="yyyymmdd" title="適用開始日">
						</td>
					</tr>

					<tr>
						<td>適用終了日</td>

						<td>
							<input type="text" name="startDate" autocomplete="off" data-type="yyyymmdd" title="適用終了日">
						</td>
					</tr>
				</table>

				<input type="submit" value="登録" class="regist" disabled>
			</form>

<%
		} else if ("2".equals(registTradingCostTypeSelectCheckResult.getTradingCostType())) {
%>
			<h2>キャピタルゲイン課税情報の登録</h2>

			<form action="RegistContentsExec" method="post">
				<table>
					<tr>
						<td>キャピタルゲイン課税</td>

						<td>
							<input type="text" name="capitalGainsTax" autocomplete="off" data-type="percentage" title="キャピタルゲイン課税">
						</td>
					</tr>

					<tr>
						<td>適用開始日</td>

						<td>
							<input type="text" name="startDate" autocomplete="off" data-type="yyyymmdd" title="適用開始日">
						</td>
					</tr>

					<tr>
						<td>適用終了日</td>

						<td>
							<input type="text" name="startDate" autocomplete="off" data-type="yyyymmdd" title="適用終了日">
						</td>
					</tr>
				</table>

				<input type="submit" value="登録" class="regist" disabled>
			</form>
<%
		} else if ("3".equals(registTradingCostTypeSelectCheckResult.getTradingCostType())) {
%>
			<h2>消費税の登録</h2>

			<form action="RegistContentsExec" method="post">
				<table>
					<tr>
						<td>消費税</td>

						<td>
							<input type="text" name="comsumptionTax" autocomplete="off" data-type="percentage" title="消費税">
						</td>
					</tr>

					<tr>
						<td>適用開始日</td>

						<td>
							<input type="text" name="startDate" autocomplete="off" data-type="yyyymmdd" title="適用開始日">
						</td>
					</tr>

					<tr>
						<td>適用終了日</td>

						<td>
							<input type="text" name="startDate" autocomplete="off" data-type="yyyymmdd" title="適用終了日">
						</td>
					</tr>
				</table>

				<input type="submit" value="登録" class="regist" disabled>
			</form>
<%
		}
	} else {
%>
		<%= registTradingCostTypeSelectCheckResult.getErrorMessage()%>
<%
	}
}
%>

<script type="text/javascript" src="./js/trading-cost-input-check.js"></script>
<script type="text/javascript" src="./js/input-check-common-handling.js"></script>