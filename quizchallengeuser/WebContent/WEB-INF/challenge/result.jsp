<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<%@include file="../includes/userheader.jsp" %>

     <!-- Page Heading -->
      <c:if test="${history.checkAnswer == 'o'}">
          <h1 class="h3 mb-4 text-gray-800">정답입니다!</h1>
     </c:if>
 
      <c:if test="${history.checkAnswer == 'x'}">
           <h1 class="h3 mb-4 text-gray-800">오답입니다.</h1>
     </c:if>
     
 <form class="form-horizontal" action="/user/challenge/question" method="get">
  <div class="form-group">
    <label class="control-label col-sm-2" for="qno">QUESTION NUMBER</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="qno" placeholder='${history.qno}' readonly="readonly">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="difficulty">DIFFICULTY</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="difficulty" placeholder='${history.difficulty}' readonly="readonly">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="quiz">QUIZ</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="quiz" placeholder='${history.quiz}' readonly="readonly">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="memberAnswer">USER ANSWER</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="memberAnswer" placeholder='${history.memberAnswer}' readonly="readonly">
    </div>
  </div>
    <div class="form-group">
    <label class="control-label col-sm-2" for="userAnswer">ANSWER</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="userAnswer" placeholder='${history.answer}' readonly="readonly">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10"> 
    <input type="hidden" class="form-control" name="grade" value="${grade}">
      <button type="submit" class="btn btn-primary">NEXT CHALLENGE</button>
    </div>
  </div>
</form>

<form class="form-horizontal" action="/user/qnaboard/register" method="get">
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
    	<input type="hidden" name="qno" value="${history.qno}">
      <button type="submit" class="btn btn-secondary">QNA 건의</button>
    </div>
  </div>
</form>

<form class="form-horizontal" action="/user/home/main" method="get">
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-info">HOME으로 돌아가기</button>
    </div>
  </div>
</form>


<%@include file="../includes/userfooter.jsp" %>
