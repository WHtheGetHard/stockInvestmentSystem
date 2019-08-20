<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="fieldformat.UserInformation" %>
<%@ page import="fieldformat.MessageAreaDisplayContents" %>


	<header>
<%
		UserInformation userInformation = new UserInformation();
		userInformation = (UserInformation) session.getAttribute("userInformation");
%>
		<h1>株式投資システム</h1>

		<nav>
			<ul class="parents">
				<li class="parents" data-contents="home">
					<a href="./home.jsp">ホーム</a>
				</li>

				<li class="parents" data-contents="basic-knowledge">
					基礎知識
					<ul class="child" data-contents="basic-knowledge" style="display: none">
						<li class="child">
							<a href="./aboutStock.jsp">株とは</a>
						</li>
						<li class="child">専門用語</li>
						<li class="child">企業分析指標</li>
						<li class="child">経済分析指標</li>
						<li class="child">銘柄選択参考指標</li>
					</ul>
				</li>

				<li class="parents" data-contents="info-regist">
					情報登録
					<ul class="child" data-contents="info-regist" style="display: none">
						<li class="child">
						<%
							if (userInformation != null) {
						%>
							<a href="./tradingCost.jsp">売買関連費用</a>
						<%
							} else {
						%>
							売買関連費用
						<%
							}
						%>
						</li>
						<li class="child">
						<%
							if (userInformation != null) {
						%>
							<a href="./companyInfoRegist.jsp">企業情報</a>
						<%
							} else {
						%>
							企業情報
						<%
							}
						%>
						</li>
						<li class="child">保有株情報</li>
					</ul>
				</li>

				<li class="parents" data-contents="info-ref">
					登録情報確認
					<ul class="child" data-contents="info-ref" style="display: none">
						<li class="child">
							<a href="./refTradingCost.jsp">売買関連費用</a>
						</li>
						<li class="child">
							<a href="./refCompanyInfo.jsp">企業情報</a>
						</li>
						<li class="child">保有株情報</li>
					</ul>
				</li>

				<li class="parents" data-contents="user-info" class="user-info-area">
					ユーザ情報
					<ul class="child" data-contents="user-info" style="display: none">
						<%
							if (userInformation == null) {
						%>
							<li class="child">
								<a href="./userSign.jsp?type=login">ログイン</a>
							</li>
							<li class="child">
								<a href="./userSign.jsp?type=regist">ユーザ登録</a>
							</li>
						<%} else {
%>
							<li class="child">
								<form action="Logout" method="post">
									<input type="submit" id="logout" value="ログアウト">
								</form>
							</li>
<%
							}
						%>
					</ul>
				</li>
			</ul>

		</nav>
	</header>

	<div class="message-area">

<%
		MessageAreaDisplayContents messageAreaDisplayContents = new MessageAreaDisplayContents();
		messageAreaDisplayContents = (MessageAreaDisplayContents) request.getAttribute("messageAreaDisplayContents");

		if (messageAreaDisplayContents != null) {
			if (messageAreaDisplayContents.isError()) {
%>
				<strong class="wrong"><%= messageAreaDisplayContents.getMessage() %></strong>
<%
			} else {
				if (messageAreaDisplayContents.getMessage() != null) {
%>
					<strong class="okay"><%= messageAreaDisplayContents.getMessage() %></strong>
<%
				}
			}
		}
%>


	</div>

	<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="./js/common-effect.js"></script>