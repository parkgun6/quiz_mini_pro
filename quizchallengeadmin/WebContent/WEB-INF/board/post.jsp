<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<%@ include file="../includes/header.jsp" %>
	<!-- Page Heading -->
	<h1 class="h3 mb-4 text-gray-800">게시글 작성</h1>
    
<form class="form-horizontal" action="/board/post" method="post">
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="title">게시글 제목 : </label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="title" placeholder="제목">
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="writer">ID : </label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="writer" placeholder="ID">
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="content">게시글 내용:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="content" placeholder="내용">
    </div>
  </div>

  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-danger">등록</button>
    </div>
  </div>

</form>
    
    

<form class="form-horizontal" action="/board/list" method="get">
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-primary">게시글 목록</button>
    </div>
  </div>
</form>
    
    	<!-- Page Footer -->
    
<%@ include file="../includes/footer.jsp" %>