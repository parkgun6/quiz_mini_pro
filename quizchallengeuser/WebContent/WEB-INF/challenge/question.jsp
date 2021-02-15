<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<%@include file="../includes/userheader.jsp" %>

     <!-- Page Heading -->
     <h1 class="h3 mb-4 text-gray-800">Question</h1>
     
 <form class="form-horizontal" action="/user/challenge/question" method="post">
 
  <div class="form-group">
    <label class="control-label col-sm-2" for="qno">QUESTION NUMBER</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="qno" value='${q.qno}' readonly="readonly">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="difficulty">DIFFICULTY</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="difficulty" value='${q.difficulty}' readonly="readonly">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="quiz">QUIZ</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="quiz" value='${q.quiz}' readonly="readonly">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="userAnswer">ANSWER</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="userAnswer">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <input type="hidden" name="grade" value="${grade}">
      <button type="submit" class="btn btn-danger">Submit</button>
    </div>
  </div>
</form>

<%@include file="../includes/userfooter.jsp" %>
