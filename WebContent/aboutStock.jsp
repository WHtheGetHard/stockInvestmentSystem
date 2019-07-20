<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@ page import="java.util.ArrayList" %>
 <%@ page import="fieldformat.StockGlossary" %>

<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">

	<link rel="shortcut icon" href="./img/common-icon.jpg">
	<link rel="stylesheet" type="text/css" href="./css/common-style.css">
	<link rel="stylesheet" type="text/css" href="./css/about-stock-style.css">

	<title>株とは</title>
</head>
<body>
	<%@ include file="./common.jsp" %>

	<div class="about">
		<article>
		 　株について勉強して、自分なりのルールを確立し、上手に使えば、資産運用に良いツールとなる。<br>
		 また、社会・経済を理解する上でも株は必要不可欠なもの。<br>
		</article>
	</div>

	<div class="selectSection">
		学習する章を選択してください。
		<form action="SelectSection" method="post">
			<select name="selectedSection">
				<option value="1">1章</option>
				<option value="2">2章</option>
				<option value="3">3章</option>
				<option value="4">4章</option>
			</select>

			<input type="submit" value="選択">
		</form>
	</div>

	<div>
<%
		ArrayList<StockGlossary> stockGlossaryList = new ArrayList<StockGlossary>();

		stockGlossaryList = (ArrayList<StockGlossary>) request.getAttribute("stockGlossaryList");

		if (stockGlossaryList != null) {
%>
			<table>
<%
			for (int i = 0; i < stockGlossaryList.size(); i++) {
%>
				<tr>
					<th class="topic"><%= stockGlossaryList.get(i).getWord() %></th>
					<th class="showbutton">⊕</th>
				</tr>
				<tr>
					<td colspan="2" class="description" data-isvisible="false" hidden>
						<%= stockGlossaryList.get(i).getDescription() %>
					</td>
				</tr>
<%
			}
%>
			</table>
<%
		} else {
%>
<%
		}
%>
	</div>

	<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="./js/about-stock.js"></script>
</body>
</html>