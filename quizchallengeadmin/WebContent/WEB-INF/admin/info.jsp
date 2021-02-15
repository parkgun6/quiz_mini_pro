<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@include file="../includes/header.jsp" %>

     <!-- Page Heading -->
     <h1 class="h3 mb-4 text-gray-800">Admin Info Page</h1>

<form class="form-horizontal" >
  <div class="form-group">
    <label class="control-label col-sm-2" for="aid">AID</label>
    <div class="col-sm-10">
      <input name="aid" type="text" class="form-control" value='${admin.aid}' readonly="readonly">
    </div>
  </div>
    <div class="form-group">
    <label class="control-label col-sm-2" for="apw">APW</label>
    <div class="col-sm-10">
      <input name="apw" type="text" class="form-control" value='${admin.apw}' readonly="readonly">
    </div>
  </div>
    <div class="form-group">
    <label class="control-label col-sm-2" for="regdate">REGDATE</label>
    <div class="col-sm-10">
      <input name="regdate" type="text" class="form-control"value='${admin.regdate}' readonly="readonly">
    </div>
  </div>
    <div class="form-group">
    <label class="control-label col-sm-2" for="updateDate">UPDATEDATE</label>
    <div class="col-sm-10">
      <input name="updateDate" type="text" class="form-control"value='${admin.updateDate}' readonly="readonly">
    </div>
  </div>
</form>

<form class="form-horizontal" action="/mgr/admin/modify?aid=${admin.aid }" method="get">
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-danger">수정/삭제</button>
    </div>
  </div>
</form>

<form class="form-horizontal" action="/mgr/admin/list" method="get">
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-primary">관리자 목록</button>
    </div>
  </div>
</form>

<%@include file="../includes/footer.jsp" %>