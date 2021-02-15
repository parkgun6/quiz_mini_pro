<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<%@ include file="../includes/header.jsp" %>

<!-- Page Heading -->
<h1 class="h3 mb-4 text-gray-800">회원 목록</h1>
      
      
    
<form class="form-horizontal" action="/member/register" method="get">
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-warning">회원 등록하기</button>
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

<table class="table">
  <thead>
    <tr>
      <th scope="col">MID</th>
      <th scope="col">MPW</th>
      <th scope="col">MNAME</th>
      <th scope="col">REG DATE</th>
      <th scope="col">UPDATE DATE</th>
    </tr>
  </thead>
<tbody>

<!-- loop start -->
	<c:forEach items="${members}" var="member">
	
    <tr>
      <td>${member.mid}</td>
      <td>${member.mpw}</td>
      <td>${member.mname}</td>
      <td>${member.regdate}</td>
      <td>${member.updatedate}</td>
    </tr>   

	</c:forEach>
<!-- loop end -->

	</tbody>
</table>



  <ul class="pagination justify-content-center">
  
  	<c:if test="${pageMaker.prev == true}">
    <li class="page-item">
      <a class="page-link" href="/member/list?page=${pageMaker.start - 1}">Previous</a>
    </li>
    </c:if>

    <c:forEach begin="${pageMaker.start}" end="${pageMaker.end}" var="num"> 
    <li class="page-item ${num == pageMaker.pageInfo.page?'active':'' }">   
    <a class="page-link" href="/member/list?page=${num}">${num}</a></li>
 	</c:forEach>
 	
 	<c:if test="${pageMaker.next == true}">
    <li class="page-item">
      <a class="page-link" href="/member/list?page=${pageMaker.end + 1}">Next</a>
    </li>
    </c:if>
   
      
  
  </ul>

    
    	<!-- Page Footer -->
    
<%@ include file="../includes/footer.jsp" %>