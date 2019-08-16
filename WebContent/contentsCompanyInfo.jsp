<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String selectedSearchType = (String) request.getAttribute("selectedSearchType");
	if (selectedSearchType != null) {
		if ("1".equals(selectedSearchType)) {
%>
			<p>検索したい会社名を入力してください。</p>
<%
		} else if ("2".equals(selectedSearchType)) {
%>
			<p>検索したい証券コードを入力してください。</p>
<%
		} else if ("3".equals(selectedSearchType)) {
%>
			<p>検索したい市場を入力してください。</p>
<%
		}
%>
		<form action="SearchCompanyInfo" method="post">
			<input type="text" name="searchWord" autocomplete="off">
			<input type="hidden" name="selectedSearchType" value="<%= selectedSearchType %>">
			<input type="submit" value="検索">
		</form>
<%
	}
%>