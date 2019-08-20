<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="fieldformat.CompanyStockBaseInfo"%>

<%
	ArrayList<CompanyStockBaseInfo> companyStockBaseInfoList = new ArrayList<CompanyStockBaseInfo>();
	companyStockBaseInfoList = (ArrayList<CompanyStockBaseInfo>) request.getAttribute("companyStockBaseInfoList");

	CompanyStockBaseInfo companyStockBaseInfo = new CompanyStockBaseInfo();
	companyStockBaseInfo = (CompanyStockBaseInfo) request.getAttribute("companyStockBaseInfo");

	if (companyStockBaseInfoList != null) {
		if (companyStockBaseInfoList.size() > 0) {
%>
		<table class="list-table">
			<tr class="list-table">
				<th class="list-table">会社名</th>
				<th class="list-table">証券コード</th>
				<th class="list-table">上場市場</th>
			</tr>
<%
			for (int i= 0; i < companyStockBaseInfoList.size(); i++) {
%>

				<tr class="list-table">
					<td class="list-table">
						<%= companyStockBaseInfoList.get(i).getCompanyName() %>
					</td>
					<td class="list-table">
						<%= companyStockBaseInfoList.get(i).getSecuritiesCode() %>
					</td>
					<td class="list-table">
						<%= companyStockBaseInfoList.get(i).getMarket() %>
					</td>
				</tr>

<%
			}
		}
%>
		</table>
<%
	} else if (companyStockBaseInfo != null) {
		if (companyStockBaseInfo.getCompanyName() != null) {
%>
		<table class="list-table">
				<tr class="list-table">
					<th class="list-table">会社名</th>
					<th class="list-table">証券コード</th>
					<th class="list-table">上場市場</th>
				</tr>

				<tr class="list-table">
					<td class="list-table">
						<%= companyStockBaseInfo.getCompanyName() %>
					</td>
					<td class="list-table">
						<%= companyStockBaseInfo.getSecuritiesCode() %>
					</td>
					<td class="list-table">
						<%= companyStockBaseInfo.getMarket() %>
					</td>
				</tr>
		</table>
<%
		}
	}
%>