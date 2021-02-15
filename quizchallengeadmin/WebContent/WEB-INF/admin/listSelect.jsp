<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../includes/header.jsp" %>

     <!-- Page Heading -->
     <h1 class="h3 mb-4 text-gray-800">Admin ListSelect Page</h1>

  
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

    <tr>
      <td><a href='/mgr/admin/info?aid=${admin.aid }'>${admin.aid}</a></td>
      <td>${admin.apw}</td>
      <td>${admin.regdate}</td>
      <td>${admin.updateDate}</td>
    </tr>
    
  </tbody>
</table>

<form action='/mgr/admin/listSelect' placeholder="관리자 ID를 입력하세요" method="get">
	<div class="form-group">
		<input type="${admin.aid}" name="aid">
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


<%@include file="../includes/footer.jsp" %>