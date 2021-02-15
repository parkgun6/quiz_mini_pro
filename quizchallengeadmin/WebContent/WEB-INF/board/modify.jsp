<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<%@ include file="../includes/header.jsp" %>
<!-- Page Heading -->
<h1 class="h3 mb-4 text-gray-800">게시글</h1>
    
<form class="form-horizontal" action="/board/modify" method="post">
  
   <div class="form-group">
    <label class="control-label col-sm-2" for="bno">게시번호 :</label>
    <div class="col-sm-10">
      <input type="number" class="form-control" name="bno" placeholder="${board.bno}" readonly="readonly" value="${board.bno}">
    </div>
  </div>
  
   <div class="form-group">
    <label class="control-label col-sm-2" for="writer">작성자 :</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="writer" placeholder="${board.writer}" readonly="readonly" value="${board.writer}">
    </div>
  </div>
  
   <div class="form-group">
    <label class="control-label col-sm-2" for="title">제목 :</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="title" placeholder="${board.title}" >
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="content">글 내용 : </label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="content" placeholder="${board.content}">
    </div>
  </div>
   
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-warning">수정</button>
    </div>
   
</form>

<form class="form-horizontal" action="/board/delete" method="get" >
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
    	<button type="submit" class="btn btn-danger" name="bno2" value="${board.bno}">삭제</button>
  </div>
  </div>
</form>
  
    
<form class="form-horizontal" action="/board/list" method="get">
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-primary">목록</button>
    </div>
  </div>
</form>
 
    
    
<!-- Page Footer -->    
<%@ include file="../includes/footer.jsp" %>