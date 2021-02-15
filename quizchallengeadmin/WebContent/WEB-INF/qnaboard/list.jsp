<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../includes/header.jsp"%>

<!-- Page Heading -->
<h1 class="h3 mb-4 text-gray-800">QnABoard List Page</h1>





<div class="list-group">
  <a href="/mgr/qnaboard/list" class="list-group-item list-group-item-action">전체 게시판</a>
  <a href="/mgr/qnaboard/list?category=1" class="list-group-item list-group-item-action">QnA게시판</a>
  <a href="/mgr/qnaboard/list?category=2" class="list-group-item list-group-item-action">중복 답 게시판</a>
  <a href="/mgr/qnaboard/list?category=3" class="list-group-item list-group-item-action">오탈자 게시판</a>
  <a href="/mgr/qnaboard/list?category=4" class="list-group-item list-group-item-action">건의사항</a>
</div>
<form action = "/mgr/qnaboard/register" method = 'get'>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-dark">QnA 등록</button>
    </div>
  </div>
</form>
	게시글 수 조정
<select
	onChange="self.location='/mgr/qnaboard/list?category=${category }&page=1&state=${state}&perSheet='+this.value">
	<!-- <option value="--">----</option> -->
	<option value="10" ${pageMaker.pageInfo.perSheet ==10? "selected":"" }>10개씩열기</option>
	<option value="20" ${pageMaker.pageInfo.perSheet ==20? "selected":"" }>20개씩열기</option>
	<option value="30" ${pageMaker.pageInfo.perSheet ==30? "selected":"" }>30개씩열기</option>
	<option value="40" ${pageMaker.pageInfo.perSheet ==40? "selected":"" }>40개씩열기</option>
	<option value="50" ${pageMaker.pageInfo.perSheet ==50? "selected":"" }>50개씩열기</option>

</select>
	   답변 여부
<select
	onChange="self.location='/mgr/qnaboard/list?category=${category }&${pageMaker.getLink(num)}&state='+this.value">
	<!-- <option value="--">----</option> -->
	<option value="0" ${state==0 ? "selected":"" }>전체보기</option>
	<option value="1" ${state==1 ? "selected":"" }>답변완료</option>
	<option value="2" ${state==2 ? "selected":"" }>답변대기</option>

</select>
	   <%-- 카테고리 이동
	<select
	onChange="self.location='/ /qnaboard/list?category='+this.value">
	<option value="--">----</option>
	<option value="1" ${category == 1? "selected":"" }>QnA게시판</option>
	<option value="2" ${category == 2? "selected":"" }>중복 답 게시판</option>
	<option value="3" ${category == 3? "selected":"" }>오탈자 게시판</option>
	<option value="4" ${category == 4? "selected":"" }>건의사항</option>

</select> --%>
<table class="table">
	<thead>
		<tr>
			<th scope="col">카테고리</th>
			<th scope="col">게시글번호</th>
			<th scope="col">상태</th>
			<th scope="col">제목</th>
			<th scope="col">글쓴이</th>
			<th scope="col">글쓴시간</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="list">
			<tr>
				<td>
				<c:if test="${list.category eq 1}">
				QnA 게시판
				</c:if>
				<c:if test="${list.category eq 2}">
				중복 답 게시판
				</c:if>
				<c:if test="${list.category eq 3}">
				오탈자 게시판
				</c:if>
				<c:if test="${list.category eq 4}">
				건의사항
				</c:if>
				</td>
				<td>${list.bno}</td>
				<td>
				<c:if test="${list.state eq 2}">
				[----답변대기중----]
				</c:if>
				<c:if test="${list.state eq 1}">
				[답변완료]
				</c:if>
				</td>
				<td><a href="/mgr/qnaboard/view?bno=${list.bno}">${list.title}</a></td>
				<td>${list.mid}</td>
				<td>${list.regdate}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>


<ul class="pagination">
    <c:if test="${pageMaker.prev }">
    <li class="page-item">
      <a class="page-link" href="/mgr/qnaboard/list?${pageMaker.getLink(pageMaker.start -1)}&state=${state}" tabindex="-1"style="color: rgb(0,0,0)">Previous</a>
    </li>
    </c:if>
    
    <c:forEach begin="${pageMaker.start}" end="${pageMaker.end}" var="num">
    <li class="page-item ${num == pageMaker.pageInfo.page ? 'active' :''}"><a class="page-link" href="/mgr/qnaboard/list?${pageMaker.getLink(num)}&state=${state}"style="color: rgb(0,0,0)">${num}</a></li>
    </c:forEach>
    
    <c:if test="${pageMaker.next }">
    <li class="page-item">
      <a class="page-link" href="/mgr/qnaboard/list?${pageMaker.getLink(pageMaker.end+1)}&state=${state}"style="color: rgb(0,0,0)">Next</a>
    </li>
    </c:if>
  </ul>

	


<%@include file="../includes/footer.jsp"%>
