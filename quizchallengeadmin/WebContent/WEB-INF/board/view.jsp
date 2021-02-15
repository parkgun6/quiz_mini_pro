<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<%@ include file="../includes/header.jsp" %>
<!-- Page Heading -->
<h1 class="h3 mb-4 text-gray-800">게시글</h1>
    
<form class="form-horizontal" action="/board/post" method="post">
<table class="table">
  <thead>
    <tr>
		<th scope="col">제목 : ${board.title}</th>  
    </tr>
  </thead>
  
  <tbody>
  
	<tr>
      <td>${board.content}</td>
      </tr>  
      <tr>
   <td>게시번호 : ${board.bno}</td>
      </tr>
      <tr>
   <td>등록일 : ${board.regdate}</td>
      </tr>
    <tr>
   <td>수정일 : ${board.updatedate}</td>
      </tr>
   </tbody>
</table>
</form>
                   
<form class="form-horizontal" action="/board/modify" method="get">
      <div class="form-group">
    	 <div class="col-sm-offset-2 col-sm-10">
    		<input type='hidden' name='bno' value='${bno}'>
      		<button type="submit" class="btn btn-warning">수정/삭제</button>
    	 </div>
  	 </div>
</form>
  
    
<form class="form-horizontal" action="/board/list" method="get">
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <input type='hidden' name='page' value='${page}'>
      <button type="submit" class="btn btn-primary">게시판 목록으로 돌아가기</button>
    </div>
  </div>
</form>
 
    
    
<!-- Page Footer -->    
<%@ include file="../includes/footer.jsp" %>