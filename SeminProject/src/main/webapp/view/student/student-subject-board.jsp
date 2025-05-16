<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>과목 홈</title>
</head>
<body>

	<h2 class=" mx-5">${s.subname}</h2>
  <div class="card mb-4  mx-5">
     <div class="card-header">
         <i class="fas fa-table me-1"></i>
              ${boardName }
     </div>
     <div style="display: flex;align-items: center;justify-content: space-between;flex-direction: column;">
	
<table style="padding-top:100px;">
	<c:if test="${boardCount==0}">
		<tr>
			<td colspan="5">등록된 게시글이 없습니다.</td>
		</tr>
	</c:if>
		<tr>
			<th width="50%">제목</th>
			<th width="%">등록일</th>
			<th width="20%" >작성자</th>
		</tr>
	<c:forEach var="b" items="${list}" varStatus="status">
		<tr>
			<td>
			
			<a href="student-subject-board-info?num=${b.num}">
			${b.title}</a></td>

			<td><fmt:formatDate value="${b.regdate}" pattern="yyyy-MM-dd" var="rdate" />
			<fmt:formatDate value="${today}" pattern="yyyy-MM-dd HH:mm:ss" var="tdate" />
			<c:if test="${rdate==tdate}">
				<fmt:formatDate value="${b.regdate}" pattern="HH:mm:ss"/>
			</c:if>
			<c:if test="${rdate!=today}">
				<fmt:formatDate value="${b.regdate}" pattern="yyyy-MM-dd"/>
			</c:if></td>
			<td>
				${b.writer }
			</td>
		</tr>
	
	</c:forEach>
	<%--페이지 처리하기 --%>
	<tr>
		<td colspan="5" align="center">
		<c:if test="${pageNum <=1 }">[이전]</c:if>
		<c:if test="${pageNum > 1 }"><a href="list?pageNum=${pageNum-1}">[이전]</a></c:if>
		<c:forEach var="a" begin="${startpage}" end="${endpage}">
			<c:if test="${a==pageNum}">[${a}]</c:if>
			<c:if test="${a!=pageNum}">
				<a href="javascript:listsubmit(${a})">[${a}]</a>
			</c:if>
		</c:forEach>
		<c:if test="${pageNum>=maxpage}">다음</c:if>
		<c:if test="${pageNum<maxpage}">
			<a href="javascript:listsubmit(${pageNum+1})">다음</a>
		</c:if>
		</td>
	</tr>
		<c:if test="${boardid=='2'}">
			<tr>
				<td colspan="5" style="text-align:right">
				<form action="student-subject-board-writeForm" method="get" accept-charset="UTF-8"  name="f" >
					<button type="submit" class="btn-primary text-center">글쓰기</button>
					<input type="hidden" name="subcode" value="${param.subcode}"/>
					<input type="hidden" name="boardid" value="${boardid}"/>
				</form>
				
				</td>
			</tr>
		</c:if>
</table>
</div>    <button onclick = "history.back()" class="btn btn-secondary" style="width:50px">←</button>
</div>
<script type="text/javascript">
	function listsubmit(page){
		f=document.sf;
		f.pageNum.value=page;
		f.submit();
	}
</script>
</body>
</html>