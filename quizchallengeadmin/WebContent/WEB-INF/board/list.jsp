<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<%@ include file="../includes/header.jsp" %>

<!-- Page Heading -->
<h1 class="h3 mb-4 text-gray-800">게시판 목록</h1>
      
      
    
<form class="form-horizontal" action="/board/post" method="get">
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-warning">게시글 등록하기</button>
    </div>
  </div>
</form>

<form class="form-horizontal" action="/member/list" method="get">
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-primary">회원 목록</button>
    </div>
  </div>
</form>
    
<table class="table">
  <thead>
    <tr>
      <th scope="col">BNO</th>
      <th scope="col">TITLE</th>
      <th scope="col">WRITER</th>
      <th scope="col">REG DATE</th>
      <th scope="col">UPDATE DATE</th>
    </tr>
  </thead>
<tbody>

<!-- loop start -->
	<c:forEach items="${boards}" var="board">
	
    <tr>
      <td>${board.bno}</td>
      <td><a href = '/board/view?bno=${board.bno}&page=${pageMaker.pageInfo.page}' target="_blank">${board.title}</a></td>
      <td>${board.writer}</td>
      <td>${board.regdate}</td>
      <td>${board.updatedate}</td>
    </tr>   

	</c:forEach>
<!-- loop end -->

	</tbody>
</table>



  <ul class="pagination justify-content-center">
    <c:if test="${1 != pageMaker.pageInfo.page}">
    <li class="page-item">
      <a class="page-link" href="/board/list" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    </c:if>
    
  	<c:if test="${pageMaker.prev == true}">
    <li class="page-item">
      <a class="page-link" href="/board/list?page=${pageMaker.start - 1}">Previous</a>
    </li>
    </c:if>

    <c:forEach begin="${pageMaker.start}" end="${pageMaker.end}" var="num"> 
    <li class="page-item ${num == pageMaker.pageInfo.page?'active':'' }">   
    <a class="page-link" href="/board/list?page=${num}">${num}</a></li>
 	</c:forEach>
 	
 	<c:if test="${pageMaker.next == true}">
    <li class="page-item">
      <a class="page-link" href="/board/list?page=${pageMaker.end + 1}">Next</a>
    </li>
    </c:if>
   
   <c:if test="${pageMaker.lastPage > pageMaker.pageInfo.page}">
    <li class="page-item">
      <a class="page-link" href="/board/list?page=${pageMaker.lastPage}" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </c:if>
  </ul>

    
    	<!-- Page Footer -->
    
<%@ include file="../includes/footer.jsp" %>