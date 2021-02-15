<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../includes/header.jsp"%>

<!-- Page Heading -->
<h1 class="h3 mb-4 text-gray-800">게시글 등록</h1>

<form action="/mgr/qnaboard/register" method="post"
	class="form-horizontal">
	<input type="hidden" name="action">
	<!-- action -->
	<table class="table table-striped table-bordered">
		<tr>
			<th>퀴즈번호</th>
			<td><input type="number" class="form-control" name="qno"></td>
		</tr>
		<tr>
			<th>카테고리</th>
			<td><input type="number" class="form-control" name="category"
				placeholder="1"></td>
		</tr>
		<tr>
			<th>제목</th>
			<!-- 제목 입력 -->
			<td><input type="text" class="form-control" name="title"></td>
		</tr>
		<tr>
			<th>내용</th>
			<!-- 내용 입력 -->
			<td><textarea rows="10" class="form-control" name="content"></textarea></td>
		</tr>
		<tr>
			<th>작성자</th>
			<!-- 작성자 입력 -->
			<td><input type="text" class="form-control" name="mid"></td>
		</tr>
	</table>

	<button class="btn btn-dark" type="submit">게시글 저장</button>
</form>
<%@include file="../includes/footer.jsp"%>
