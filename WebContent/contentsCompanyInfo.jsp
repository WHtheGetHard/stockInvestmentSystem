<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="fieldformat.CompanyStockBaseInfo"%>
<%@ page import="fieldformat.RefCompanyInfoCondition" %>

<%
	RefCompanyInfoCondition refCompanyInfoCondition = new RefCompanyInfoCondition();
	refCompanyInfoCondition = (RefCompanyInfoCondition) request.getAttribute("refCompanyInfoCondition");

	if (refCompanyInfoCondition != null) {

		String searchTypeString = null;
		if (refCompanyInfoCondition.getSearchWord() != null) {
			if ("1".equals(refCompanyInfoCondition.getSelectedSearchType())) {
				searchTypeString = "会社名";
			} else if ("2".equals(refCompanyInfoCondition.getSelectedSearchType())) {
				searchTypeString = "証券コード";
			} else if ("3".equals(refCompanyInfoCondition.getSelectedSearchType())) {
				searchTypeString = "上場市場";
			}
%>
			<div class="searchConditionArea">
				検索方法：<%= searchTypeString %>, 検索条件：<%= refCompanyInfoCondition.getSearchWord() %>
			</div>
<%
		}
	}
%>




<%
	ArrayList<CompanyStockBaseInfo> companyStockBaseInfoList = new ArrayList<CompanyStockBaseInfo>();
	companyStockBaseInfoList = (ArrayList<CompanyStockBaseInfo>) request.getAttribute("companyStockBaseInfoList");

	CompanyStockBaseInfo companyStockBaseInfo = new CompanyStockBaseInfo();
	companyStockBaseInfo = (CompanyStockBaseInfo) request.getAttribute("companyStockBaseInfo");

	if (companyStockBaseInfoList != null || companyStockBaseInfo != null) {

%>
		<table class="list-table">
			<tr class="list-table">
				<th class="list-table">会社名</th>
				<th class="list-table">証券コード</th>
				<th class="list-table">上場市場</th>
				<th class="list-table">詳細</th>
			</tr>
<%
	}

	if (companyStockBaseInfoList != null) {
		if (companyStockBaseInfoList.size() > 0) {
			for (int i = 0; i < companyStockBaseInfoList.size(); i++) {
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
					<td class="list-table">
						<input type="button" value="詳細" name="<%=  i %>">
					</td>
				</tr>
<%
			}
		}
	} else if (companyStockBaseInfo != null) {
		if (companyStockBaseInfo.getCompanyName() != null) {
%>
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
				<td class="list-table">
					<input type="button" value="詳細" name="-1">
				</td>
			</tr>
<%
		}
	}

%>
		</table>


<script type="text/javascript" src="./js/show-company-detail.js"></script>