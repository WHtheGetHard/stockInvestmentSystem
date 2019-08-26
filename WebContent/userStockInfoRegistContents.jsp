<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="fieldformat.CompanyStockBaseInfo" %>
<%@ page import="java.util.ArrayList" %>

<%
	ArrayList<CompanyStockBaseInfo> companyStockBaseInfoList = new ArrayList<CompanyStockBaseInfo>();
	companyStockBaseInfoList = (ArrayList<CompanyStockBaseInfo>) request.getAttribute("companyStockBaseInfoList");

	if (companyStockBaseInfoList != null) {
		if (companyStockBaseInfoList.size() > 0) {
%>
			<table class="list-table">
				<tr class="list-table">
					<td class="list-table">会社名</td>
				</tr>
<%
				for (int i = 0; i < companyStockBaseInfoList.size(); i++) {
%>
					<tr class="list-table">
						<td class="list-table">
							<%= companyStockBaseInfoList.get(i).getCompanyName() %>
						</td>
					</tr>
<%
				}
%>
			</table>
<%
		}
%>
	<p>上記の検索結果に表示されていない場合は、</p>
	<a href="companyInfoRegist.jsp">企業情報(登録)</a>で企業情報を検索・登録してください。
<%
 	}
%>