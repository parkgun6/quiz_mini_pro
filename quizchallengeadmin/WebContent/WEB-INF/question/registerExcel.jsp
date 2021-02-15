<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<%@ include file="../includes/header.jsp" %>
	<!-- Page Heading -->
<h1 class="h3 mb-4 text-gray-800">Excel로 문제 등록</h1>
    
<form action="/mgr/question/registerExcel" method="post" enctype="multipart/form-data">
	<input type='file' name='file'><button>문제 등록</button>
</form>

<br></br>

<form class="form-horizontal" action="/mgr/mgr/question/list" method="get">
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-primary">문제 목록</button>
    </div>
  </div>
</form>
    
<%@ include file="../includes/footer.jsp" %>