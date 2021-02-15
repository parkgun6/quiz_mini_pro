<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<%@ include file="../includes/header.jsp" %>
	<!-- Page Heading -->
<h1 class="h3 mb-4 text-gray-800">챌린지</h1>
    
<form class="form-horizontal" action="/mgr/challenge/submit" method="post">
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="mid">mid : ${dto.mid}</label>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="difficulty">난이도 : ${question.difficulty}</label>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="quiz">문제 : ${question.quiz}</label>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="memberAnswer">정답 :</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="memberAnswer" placeholder="정답을 적으세요.">
    </div>
  </div>
 
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-danger">제출하기</button>
    </div>
  </div>

</form>
    

<form class="form-horizontal" action="/mgr/question/list" method="get">
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-primary">홈으로 돌아가기</button>
    </div>
  </div>
</form>
    
    	<!-- Page Footer -->
    
<%@ include file="../includes/footer.jsp" %>