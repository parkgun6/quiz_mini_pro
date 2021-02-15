<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<%@ include file="../includes/header.jsp" %>

<!-- Page Heading -->
<h1 class="h3 mb-4 text-gray-800">문제 목록</h1>
     

<form class="form-horizontal" action="/mgr/admin/home" method="get">
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-primary">HOME</button>
    </div>
  </div>
</form>
    
<form class="form-horizontal" action="/mgr/question/register" method="get">
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-warning">문제 등록하기</button>
    </div>
  </div>
</form>

    
<table class="table">
  <thead>
    <tr>
      <th scope="col">QNO</th>
      <th scope="col">AID</th>
      <th scope="col">QUIZ</th>
      <th scope="col">ANSWER</th>
      <th scope="col">DIFFICULTY</th>
      <th scope="col">DEPRECATED</th>     
      <th scope="col">REG DATE</th>
      <th scope="col">UPDATE DATE</th>
    </tr>
  </thead>
<tbody>

<!-- loop start -->
	<c:forEach items="${questions}" var="question">
	
	<!--  <td><a href = '/board/view?bno=${board.bno}&page=${pageMaker.pageInfo.page}'
	 target="_blank">${board.title}</a></td> -->
    <tr>
      <td><a href = '/mgr/question/view?qno=${question.qno}'>${question.qno}</a></td>
      <td>${question.aid}</td>
      <td>${question.quiz}</td>
      <td>${question.answer}</td>
      <td>${question.difficulty}</td>
      <td>${question.deprecated}</td>
      <td>${question.regdate}</td>
      <td>${question.updatedate}</td>
    </tr>   

	</c:forEach>
<!-- loop end -->

	</tbody>
</table>


<!-- paging start -->
  <ul class="pagination justify-content-center">
    <c:if test="${1 != pageMaker.pageInfo.page}">
    <li class="page-item">
      <a class="page-link" href="/mgr/question/list?page=1&perSheet=${pageMaker.pageInfo.perSheet}" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    </c:if>
    
  	<c:if test="${pageMaker.prev == true}">
    <li class="page-item">
      <a class="page-link" href="/mgr/question/list?page=${pageMaker.start - 1}&perSheet=${pageMaker.pageInfo.perSheet}">Previous</a>
    </li>
    </c:if>

    <c:forEach begin="${pageMaker.start}" end="${pageMaker.end}" var="num"> 
    <li class="page-item ${num == pageMaker.pageInfo.page?'active':'' }">   
    <a class="page-link" href="/mgr/question/list?page=${num}&perSheet=${pageMaker.pageInfo.perSheet}">${num}</a></li>
 	</c:forEach>
 	
 	<c:if test="${pageMaker.next == true}">
    <li class="page-item">
      <a class="page-link" href="/mgr/question/list?page=${pageMaker.end + 1}&perSheet=${pageMaker.pageInfo.perSheet}">Next</a>
    </li>
    </c:if>
   
   <c:if test="${pageMaker.lastPage > pageMaker.pageInfo.page}">
    <li class="page-item">
      <a class="page-link" href="/mgr/question/list?page=${pageMaker.lastPage}&perSheet=${pageMaker.pageInfo.perSheet}" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </c:if>
  </ul>

<select
	onChange="self.location='/mgr/question/list?page=1&perSheet='+this.value">
	<option value="--">----</option>
	<option value="10" ${pageMaker.pageInfo.perSheet ==10? "selected":"" }>10개씩 열기</option>
	<option value="20" ${pageMaker.pageInfo.perSheet ==20? "selected":"" }>20개씩 열기</option>
	<option value="30" ${pageMaker.pageInfo.perSheet ==30? "selected":"" }>30개씩 열기</option>
	<option value="40" ${pageMaker.pageInfo.perSheet ==40? "selected":"" }>40개씩 열기</option>
	<option value="50" ${pageMaker.pageInfo.perSheet ==50? "selected":"" }>50개씩 열기</option>

</select>


    
<!-- Page Footer -->
<%@ include file="../includes/footer.jsp" %>