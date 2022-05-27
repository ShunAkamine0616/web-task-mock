<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
	<div class="header">
		<h1 class="site_logo">
			<a href="menu.jsp">商品管理システム</a>
		</h1>
		<div class="user">
			<p class="user_name">佐藤さん、こんにちは</p>
			<form class="logout_form" action="Logout" method="get">
				<button class="logout_btn" type="submit">
					<img src="images/ドアアイコン.png">ログアウト
				</button>
			</form>
		</div>
	</div>

	<hr>

	<div class="insert">
		<div class="form_body">
			<p class="error">
				<c:if test="${not empty updateErrMsg}">
					<span>${fn:escapeXml(updateErrMsg)}</span>
				</c:if>
			</p>

			<form action="UpdateServlet" method="get">
				<fieldset class="label-130">
					<div>
						<label>商品ID</label> <input type="text" name="productId"
							value="${product.product_id}" class="base-text"> <span
							class="error"><c:if test="${not empty idErrMsg}">
								<span>${fn:escapeXml(idErrMsg)}</span>
							</c:if></span>
					</div>
					<div>
						<label>商品名</label> <input type="text" name="productName"
							value="${product.name}" class="base-text"> <span
							class="error"><c:if test="${not empty nameErrMsg}">
								<span>${fn:escapeXml(nameErrMsg)}</span>
							</c:if></span>
					</div>
					<div>
						<label>単価</label> <input type="text" name="price"
							value="${product.price}" class="base-text"> <span
							class="error"><c:if test="${not empty priceErrMsg}">
								<span>${fn:escapeXml(priceErrMsg)}</span>
							</c:if></span>
					</div>
					<div>
						<label>カテゴリ</label> <select name="category_id" class="base-text">
							<option value="1" selected>ペン</option>
							<option value="2">ノート</option>
							<option value="3">消しゴム</option>
							<option value="4">のり</option>
						</select>
					</div>
					<div>
						<label>商品説明</label>
						<textarea name="description" class="base-text">
						${product.description}
            </textarea>
					</div>
					<div>
						<label>画像</label> <input type="file" name="file"> <span
							class="error">エラーメッセージ</span>
					</div>
				</fieldset>
				<div class="btns">
					<button type="button" onclick="openModal()" class="basic_btn">更新</button>
					<input type="button" onclick="location.href='./menu.jsp'"
						value="メニューに戻る" class="cancel_btn">
				</div>
				<div id="modal">
					<p class="modal_message">更新しますか？</p>
					<div class="btns">
						<button type="submit" class="basic_btn">更新</button>
						<button type="button" onclick="closeModal()" class="cancel_btn">キャンセル</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div id="fadeLayer"></div>
</body>
</html>
<script src="./js/commons.js"></script>