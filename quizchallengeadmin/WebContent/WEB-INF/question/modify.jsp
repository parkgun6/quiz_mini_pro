<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<%@ include file="../includes/header.jsp" %>
	<!-- Page Heading -->
<h1 class="h3 mb-4 text-gray-800">문제 수정</h1>
    
<form class="form-horizontal" action="/mgr/question/modify" method="post">
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="qno">QNO : </label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="qno" placeholder="${question.qno}" readonly="readonly" value="${question.qno}">
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="aid">ADMIN ID : </label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="aid" placeholder="${question.aid}" readonly="readonly" value="${question.aid}">
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="quiz">QUIZ : ${question.quiz}</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="quiz" placeholder="QUIZ">
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="answer">ANSWER : ${question.answer}</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="answer" placeholder="ANSWER">
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="difficulty">DFC : ${question.difficulty}</label>
    <div class="col-sm-10">
      <input type="number" class="form-control" name="difficulty" placeholder="DIFFICULTY"  >
    </div>
  </div>
  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-danger">수정 제출</button>
    </div>
  </div>

</form>
 

<form class="form-horizontal" action="/mgr/question/list" method="get">
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-primary">돌아가기</button>
    </div>
  </div>
</form>
    
    	<!-- Page Footer -->
    
<%@ include file="../includes/footer.jsp" %>