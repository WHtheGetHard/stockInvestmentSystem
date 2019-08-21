<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList" %>
<%@ page import="fieldformat.CompanyDetails" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
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

<%
		}
	}
%>

</body>
</html>