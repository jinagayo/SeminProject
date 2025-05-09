<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>알림마당</title>
</head>
<body>
<h2>알림마당</h2>
<form action="list?boardid=${boardid}" method="post" name="sf">
	<input type="hidden" name="pageNum" value="1">
		<select class="w3-select" name="column">
			<option value="">선택하시오</option>
			<option value="title">제목</option>
			<option value="content">내용</option>
			<option value="title,content">제목+내용</option>
		</select>
		<script type="text/javascript">
			document.sf.column.value='${param.column}'
		</script>
		<input class="form-control" type="text"
			placeholder="Search" name="find" value="${param.find}">
		<button class="btn btn-primary" type="submit">Search</button>
</form>
<table class="talbe">
	<c:if test="${boardcount==0}">
		<tr>
			<td colspan="5">등록된 게시글이 없습니다.</td>
		</tr>
	</c:if>
	<c:if test="${boardcount>0}">
		<tr>
			<td colspan="5">등록된 게시글이 없습니다.</td>
		</tr>
	</c:if>
		<tr>	
			<td colspan="5" style="text-align:right">글개수 : ${boardcount}</td>
		</tr>
		<tr>
			<th width="8%">번호</th><th width="50%">제목</th>
			<th width="14%">작성자</th><th width="%">등록일</th>
			<th width="%">조회수</th>
		</tr>
	<c:forEach var="b" items="${list}">
		<tr>
			<td>${b.num}</td>
			<td style="text-align:left">
			<c:if test="${!empty b.file1}"><a href="../upload/board/${b.file1}">@</a></c:if>
			<c:if test="${empty b.file1}">&nbsp;&nbsp;&nbsp; </c:if>
			<%--답글인 경우 level만큼 공백주기 --%>
			<c:if test ="${b.grplevel>0}">
				<c:forEach var="i" begin="2" end="${b.grplevel}">
					&nbsp;&nbsp;&nbsp;
				</c:forEach>
				↳
			</c:if>
			
			<a href="info?num=${b.num}">
			${b.title}</a></td>
			<td>${b.writer}</td>
			<td><fmt:formatDate value="${b.regdate}" pattern="yyyy-MM-dd" var="rdate" />
			<fmt:formatDate value="${today}" pattern="yyyy-MM-dd HH:mm:ss" var="tdate" />
			<c:if test="${rdate==tdate}">
				<fmt:formatDate value="${b.regdate}" pattern="HH:mm:ss"/>
			</c:if>
			<c:if test="${rdate!=today}">
				<fmt:formatDate value="${b.regdate}" pattern="yyyy-MM-dd"/>
			</c:if></td>
			<td>${b.readcnt}</td>
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
	<%-- 공지사항 게시판의 경우 관리자 로그인인 경우에만 글쓰기 출력 --%>
		<c:if test="${boardid!=1 || sessionScope.login=='admin'}">
			<tr>
				<td colspan="5" style="text-align:right">
				<p align="right"> <a href="writeForm">글쓰기</a></p>
				</td>
			</tr>
		</c:if>
</table>

<script type="text/javascript">
	function listsubmit(page){
		f=document.sf;
		f.pageNum.value=page;
		f.submit();
	}
</script>
</body>
</html>