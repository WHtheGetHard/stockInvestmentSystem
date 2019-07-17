<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">

	<link rel="shortcut icon" href="./img/common-icon.jpg">
	<link rel="stylesheet" type="text/css" href="./css/common-style.css">

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

	<div>
		<table>
			<tr class="1">
				<th class="topic">株</th><th class="showbutton">⊕</th>
			</tr>
			<tr class="1">
				<td colspan="2" class="description">
					株の発行は出資を募るための手段で、株式とは、株式会社における出資者の持ち分を明らかにする有価証券。<br>
				</td>
			</tr>

			<tr class="2">
				<th class="topic">出資</th><th class="showbutton">⊕</th>
			</tr>
			<tr class="2">
				<td colspan="2" class="description">
					会社に資金を提供し、その提供した金額に応じて会社の権利の一部を譲り受ける。この権利の証明書が株。<br>
					銀行などから借りる「借入」とことなり、出資されたものに対しては返済が不要となる。
				</td>
			</tr>

			<tr class="3">
				<th class="topic">上場</th><th class="showbutton">⊕</th>
			</tr>
			<tr class="3">
				<td colspan="2" class="description">
					会社が資金を広く集めやすくするために、証券取引所という株などの有価証券を売買する施設を設けている。<br>
					その証券取引所で株を売買可能にする行為を、上場という。
				</td>
			</tr>
		</table>
	</div>

	<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="./js/about-stock.js"></script>
</body>
</html>