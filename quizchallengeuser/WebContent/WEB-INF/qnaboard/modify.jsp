<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../includes/userheader.jsp"%>

<!-- Page Heading -->
<h1 class="h3 mb-4 text-gray-800">게시글 수정 페이지</h1>

<form class="form-horizontal" action="/user/qnaboard/modify" method="post">
<input type="hidden" name="sno" value="${board.bno }">
	<div class="form-group">
		<label class="control-label col-sm-2" for="bno"></label>
		<div class="col-sm-10">
			<input type="hidden" class="form-control" name="bno"
				value='${board.bno}' readonly="readonly">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="sno">QuizNumber</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="qno"
				value='${board.qno}' >
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="title">제목</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="title"
				value='${board.title}'>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="content">게시글내용</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="content"
				value='${board.content}'>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="category">카테고리</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="category"
				value='${board.category}'>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-dark">수정하기</button>
		</div>
	</div>
</form>

<%@include file="../includes/userfooter.jsp"%>
