<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../includes/header.jsp"%>
<!-- Page Heading -->
<h1 class="h3 mb-4 text-gray-800">조회 페이지</h1>

<form action="/mgr/qnaboard/list">
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-dark">목록</button>
		</div>
	</div>
</form>
<form action="/mgr/qnaboard/modify" method="get" class="form-horizontal">
	<input type="hidden" name="action">
	<!-- action -->
	<table class="table table-striped table-bordered">

		<tr>
			<th>게시글번호</th>
			<td><input type="number" class="form-control" name="bno"
				value="${board.bno }" readonly="readonly"></td>
		</tr>
		<tr>
			<th>작성자</th>
			<!-- 작성자 입력 -->
			<td><input type="text" class="form-control" name="mid"
				value="${board.mid}" readonly="readonly"></td>
		</tr>
		<tr>
			<th>퀴즈번호</th>
			<td><input type="number" class="form-control" name="qno"
				value='${board.qno}' readonly="readonly"></td>
		</tr>
		<tr>
			<th>난이도</th>
			<td><input type="number" class="form-control" name="difficulty"
				value='${board.difficulty}' readonly="readonly"></td>
		</tr>
		<tr>
			<th>퀴즈</th>
			<!-- 내용 입력 -->
			<td><textarea rows="6" class="form-control" name="quiz"
					readonly="readonly">${board.quiz}</textarea></td>
		</tr>
		<tr>
			<th>정답</th>
			<td><input type="text" class="form-control" name="answer"
				value='${board.answer}' readonly="readonly"></td>
		</tr>
		<tr>
		<tr>
			<th>카테고리</th>
			<td><input type="number" class="form-control" name="category"
				placeholder="1" value='${board.category}' readonly="readonly"></td>
		</tr>
		<tr>
			<th>제목</th>
			<!-- 제목 입력 -->
			<td><input type="text" class="form-control" name="title"
				value='${board.title}' readonly="readonly"></td>
		</tr>
		<tr>
			<th>내용</th>
			<!-- 내용 입력 -->
			<td><textarea rows="10" class="form-control" name="content"
					readonly="readonly">${board.content}</textarea></td>
		</tr>
		<tr>
			<th>날짜</th>
			<!-- 제목 입력 -->
			<td><input type="Date" class="form-control" name="regdate"
				value='${board.regdate}' readonly="readonly"></td>
		</tr>

	</table>
	<button class="btn btn-dark" type="submit">수정하기</button>
</form>


<form action="/mgr/qnaboard/remove" method='post'>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<input type="hidden" name="bno" value="${board.bno }">
			<button type="submit" class="btn btn-dark">게시글 삭제</button>
		</div>
	</div>
</form>
<!-- 답변완료창에서 보이는 답변 -->
<c:if test="${board.state eq 1}">
	<form action="/mgr/qnaboard/answerModify" method="get"
		class="form-horizontal">
		<input type="hidden" name="action">
		<!-- action -->
		<table class="table table-striped table-bordered">
			<tr>
				<th>작성자</th>
				<!-- 작성자 입력 -->
				<td><input type="text" class="form-control" name="aid"
					value="${answer.aid}" readonly="readonly"></td>
			</tr>
			<tr>
				<th>내용</th>
				<!-- 내용 입력 -->
				<td><textarea rows="10" class="form-control" name="answer"
						readonly="readonly">${answer.answer}</textarea></td>
			</tr>
			<tr>
				<th>날짜</th>
				<!-- 제목 입력 -->
				<td><input type="Date" class="form-control" name="regdate"
					value='${answer.regdate}' readonly="readonly"></td>
			</tr>
		</table>
		<button class="btn btn-dark" type="submit">수정하기</button>
	</form>
</c:if>
<!-- 답변 대기인 화면에서만 나오는 화면 -->
<c:if test="${board.state eq 2}">
	<form action="/mgr/qnaboard/addAnswer" method='post'>
		<table class="table table-striped table-bordered">
			<tr>
				<th>게시글번호</th>
				<td><input type="hidden" class="form-control" name="bno"
					style="width: 50px; height: 30px;" value="${board.bno }"
					readonly="readonly"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<!-- 작성자 입력 -->
				<td><input type="text" class="form-control" name="aid"
					style="width: 100px; height: 30px;"></td>
			</tr>
			<tr>
				<th>내용</th>
				<!-- 내용 입력 -->
				<td><textarea rows="10" class="form-control" name="answer"></textarea></td>
			</tr>
		</table>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-dark">답변 완료 처리</button>
			</div>
		</div>
	</form>
</c:if>

<br>
<br>
<br>

<table class="table">
	<thead>
		<tr>
			<th scope="col">아이디</th>
			<th scope="col">댓글</th>
			<th scope="col">작성일</th>
			<th scope="col"></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${replyList}" var="replyList">
			<tr>
				<td>${replyList.mid}</td>
				<td style="word-break: break-all; white-space: pre;9"><c:out
						value="${replyList.reply}"></c:out></td>
				<td>${replyList.regdate}</td>
				<td><form action="/mgr/qnaboard/removeReply" method='post'>
						<input type="hidden" name="rno" value="${replyList.rno }">
						<input type="hidden" name="bno" value="${board.bno }">
						<button>삭제</button>
					</form></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<form class="form-horizontal"
	action="/mgr/qnaboard/view?bno=${board.bno}" method="post">

	<div class="form-group">
		<label class="control-label col-sm-2" for="bno"></label>
		<div class="col-sm-10">
			<input type="hidden" class="form-control" name="bno"
				value='${board.bno}' readonly="readonly">
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-sm-2" for="mid">작성자</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="mid"
				style="width: 200px; height: 30px;">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="reply">내용</label>
		<div class="col-sm-10">
			<textarea rows="3" class="form-control" name="reply"></textarea>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-dark">등록하기</button>
		</div>
	</div>
</form>


<%@include file="../includes/footer.jsp"%>
