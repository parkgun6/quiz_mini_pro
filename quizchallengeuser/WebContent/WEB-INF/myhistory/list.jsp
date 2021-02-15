<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<%@ include file="../includes/userheader.jsp" %>

<!-- Page Heading -->
<h1 class="h3 mb-4 text-gray-800">나의 챌린지 목록</h1>
      
    
<table class="table">
  <thead>
    <tr>
      <th scope="col">QNO</th>
      <th scope="col">DIFFICULTY</th>
      <th scope="col">QUIZ</th>
      <th scope="col">ANSWER</th>
      <th scope="col">MEMBER ANSWER</th>     
      <th scope="col">RESULT</th>
      <th scope="col">REG DATE</th>
      <th scope="col">QNA</th>
    </tr>
  </thead>
<tbody>

<!-- loop start -->
	<c:forEach items="${list}" var="question">
	
	<!--  <td><a href = '/board/view?bno=${board.bno}&page=${pageMaker.pageInfo.page}'
	 target="_blank">${board.title}</a></td> -->
    <tr>
      <td>${question.qno}</td>
      <td>${question.difficulty}</td>
      <td>${question.quiz}</td>
      <td>${question.answer}</td>
      <td>${question.memberAnswer}</td>
      <td>${question.checkAnswer}</td>
      <td>${question.regDate}</td>
 <td>
 <form class="form-horizontal" action="/user/qnaboard/register" method="get">
      	<input type="hidden" name="qno" value="${question.qno}">
      <button type="submit" class="btn btn-warning">이의 제기</button>   
</form>
</td>
    </tr>   

	</c:forEach>
<!-- loop end -->

	</tbody>
</table>


<!-- paging start -->
  <ul class="pagination justify-content-center">
    <c:if test="${1 != pageMaker.pageInfo.page}">
    <li class="page-item">
      <a class="page-link" href="/user/myhistory/list?page=1&perSheet=${pageMaker.pageInfo.perSheet}" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    </c:if>
    
  	<c:if test="${pageMaker.prev == true}">
    <li class="page-item">
      <a class="page-link" href="/user/myhistory/list?page=${pageMaker.start - 1}&perSheet=${pageMaker.pageInfo.perSheet}">Previous</a>
    </li>
    </c:if>

    <c:forEach begin="${pageMaker.start}" end="${pageMaker.end}" var="num"> 
    <li class="page-item ${num == pageMaker.pageInfo.page?'active':'' }">   
    <a class="page-link" href="/user/myhistory/list?page=${num}&perSheet=${pageMaker.pageInfo.perSheet}">${num}</a></li>
 	</c:forEach>
 	
 	<c:if test="${pageMaker.next == true}">
    <li class="page-item">
      <a class="page-link" href="/user/myhistory/list?page=${pageMaker.end + 1}&perSheet=${pageMaker.pageInfo.perSheet}">Next</a>
    </li>
    </c:if>
   
   <c:if test="${pageMaker.lastPage > pageMaker.pageInfo.page}">
    <li class="page-item">
      <a class="page-link" href="/user/myhistory/list?page=${pageMaker.lastPage}&perSheet=${pageMaker.pageInfo.perSheet}" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </c:if>
  </ul>

<select
	onChange="self.location='/user/myhistory/list?page=1&perSheet='+this.value">
	<option value="--">----</option>
	<option value="10" ${pageMaker.pageInfo.perSheet ==10? "selected":"" }>10개씩 열기</option>
	<option value="20" ${pageMaker.pageInfo.perSheet ==20? "selected":"" }>20개씩 열기</option>
	<option value="30" ${pageMaker.pageInfo.perSheet ==30? "selected":"" }>30개씩 열기</option>
	<option value="40" ${pageMaker.pageInfo.perSheet ==40? "selected":"" }>40개씩 열기</option>
	<option value="50" ${pageMaker.pageInfo.perSheet ==50? "selected":"" }>50개씩 열기</option>

</select>


    
<!-- Page Footer -->
<%@ include file="../includes/userfooter.jsp" %>