<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../includes/userheader.jsp" %>

     <!-- Page Heading -->
<h1 class="h3 mb-4 text-gray-800">회원 가입</h1>


   
<form class="form-horizontal" action="/user/member/signup" method="post"> 
  <div class="form-group">
    <label class="control-label col-sm-2" for="mid">ID : </label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="mid" placeholder="Insert ID" >
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="mpw">PW : </label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="mpw" placeholder="Password">
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="checkpw">CONFIRM PW :</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="checkpw" placeholder="Confirm your password">
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="mname">NAME :</label>
    <div class="col-sm-10">
      <input type="number" class="form-control" name="mname" placeholder="your name">
    </div>
  </div>
  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-danger">등록</button>
    </div>
  </div>

</form>
    



<%@include file="../includes/userfooter.jsp" %>
