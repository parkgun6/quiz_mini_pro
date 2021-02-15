<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@include file="../includes/header.jsp" %>

     <!-- Page Heading -->
     <h1 class="h3 mb-4 text-gray-800">Admin Home Page</h1>

<form class="form-horizontal" action="/mgr/admin/list" method="get">
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-primary">관리자 목록</button>
    </div>
  </div>
</form>

<form class="form-horizontal" action="/mgr/member/list" method="get">
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-warning">회원목록</button>
    </div>
  </div>
</form>

<form class="form-horizontal" action="/mgr/question/list" method="get">
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-danger">문제</button>
    </div>
  </div>
</form>

<form class="form-horizontal" action="/mgr/qnaboard/list" method="get">
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-info">Q&A</button>
    </div>
  </div>
</form>

<form class="form-horizontal" action="/mgr/qhistory/list" method="get">
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-success">챌린지 현황</button>
    </div>
  </div>
</form>


<%@include file="../includes/footer.jsp" %>