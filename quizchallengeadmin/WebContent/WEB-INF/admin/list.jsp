<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../includes/header.jsp" %>

     <!-- Page Heading -->
     <h1 class="h3 mb-4 text-gray-800">Admin List Page</h1>

<form class="form-horizontal" action="/mgr/admin/home" method="get">
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-primary">HOME</button>
    </div>
  </div>
</form>

<select
	onChange="self.location='/mgr/member/list?page=1&perSheet='+this.value">
	<option value="--">----</option>
	<option value="10" ${pageMaker.pageInfo.perSheet ==10? "selected":"" }>10개씩열기</option>
	<option value="20" ${pageMaker.pageInfo.perSheet ==20? "selected":"" }>20개씩열기</option>
	<option value="30" ${pageMaker.pageInfo.perSheet ==30? "selected":"" }>30개씩열기</option>
	<option value="40" ${pageMaker.pageInfo.perSheet ==40? "selected":"" }>40개씩열기</option>
	<option value="50" ${pageMaker.pageInfo.perSheet ==50? "selected":"" }>50개씩열기</option>
</select>  
<table class="table">
  <thead>
    <tr>
      <th scope="col">AID</th>
      <th scope="col">APW</th>
      <th scope="col">REGDATE</th>
      <th scope="col">UPDATE DATE</th>
    </tr>
  </thead>
  <tbody>

<c:forEach items="${adminList}" var="admin">
    <tr>
      <td><a href='/mgr/admin/info?aid=${admin.aid }'>${admin.aid}</a></td>
      <td>${admin.apw}</td>
      <td>${admin.regdate}</td>
      <td>${admin.updateDate}</td>

    </tr>
</c:forEach>
  </tbody>
</table>

<form action='/mgr/admin/listSelect' method="get">
	<div class="form-group">
		<input type="${admin.mid}" placeholder="관리자 ID를 입력하세요" name="aid">
		<button>검색</button>
	</div>
</form>


<form class="form-horizontal" action="/mgr/admin/home" method="get">
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-0">
      <button type="submit" class="btn btn-primary">홈</button>
    </div>
  </div>
</form>

  <ul class="pagination">
    <c:if test="${pageMaker.prev }">
    <li class="page-item">
      <a class="page-link" href="/mgr/admin/list?page=${pageMaker.start -10}" tabindex="-1">Previous</a>
    </li>
    </c:if>
    
    <c:forEach begin="${pageMaker.start}" end="${pageMaker.end}" var="num">
    <li class="page-item ${num == pageMaker.pageInfo.page ? "active" : ""}">
    <a class="page-link" href="/mgr/admin/list?page=${num}">${num}</a></li>
    </c:forEach>
    
    <c:if test="${pageMaker.next }">
    <li class="page-item">
      <a class="page-link" href="/mgr/admin/list?page=${pageMaker.end  + 1}">Next</a>
    </li>
    </c:if>
  </ul>

<%@include file="../includes/footer.jsp" %>