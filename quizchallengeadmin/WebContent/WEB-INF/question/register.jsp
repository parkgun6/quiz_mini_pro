<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<%@ include file="../includes/header.jsp" %>
	<!-- Page Heading -->
<h1 class="h3 mb-4 text-gray-800">문제 등록</h1>
    
<form class="form-horizontal" action="/mgr/question/register" method="post"> 
  <div class="form-group">
    <label class="control-label col-sm-2" for="aid">ADMIN ID : </label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="aid" placeholder="mingyuAdmin" value="mingyuAdmin" readonly="readonly">
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="quiz">QUIZ : </label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="quiz" placeholder="QUIZ">
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="answer">ANSWER :</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="answer" placeholder="ANSWER">
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="difficulty">DFC :</label>
    <div class="col-sm-10">
      <input type="number" class="form-control" name="difficulty" placeholder="DIFFICULTY">
    </div>
  </div>
  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-danger">등록</button>
    </div>
  </div>

</form>
    
<form class="form-horizontal" action="/mgr/question/registerExcel" method="get">
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-warning">Excel로 파일 등록</button>
    </div>
  </div>
</form> 

<form class="form-horizontal" action="/mgr/question/list" method="get">
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-primary">문제 목록</button>
    </div>
  </div>
</form>
    
    	<!-- Page Footer -->
    
<%@ include file="../includes/footer.jsp" %>