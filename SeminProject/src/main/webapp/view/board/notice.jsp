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
<h2 class="text-center"  onclick="location.href='../board/notice'">알림마당</h2>
<form action="notice" method="post" name="sf">
	<input type="hidden" name="pageNum" value="1">
		<div style="position:relative;align-items:center;">
		<select class="form-select form-select-m mb-3" name="column" style="position:absolute;align-items:center;width:150px">
			<option value="">선택하시오</option>
			<option value="title">제목</option>
			<option value="content">내용</option>
			<option value="title,content">제목+내용</option>
		</select>
		<script type="text/javascript">
			document.sf.column.value='${param.column}'
		</script>
		<div class="container-fluid">
			<input class="form-control" type="text"
				placeholder="Search" name="find" value="${param.find}" style="position:absolute;left:15%;width:850px;">
			<button class="btn btn-primary" type="submit" style="position:absolute;left:93%;height:35px;text-align: center">Search</button>
		</div>
	</div>
</form>

<table class="table" style="margin-top: 5%">
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
			<td colspan="2"></td>
		</tr>
		<tr>
			<th width="80%"style="padding-left: 50px;">제목</th>
			<th width="%">등록일</th>
		</tr>
	<c:forEach var="b" items="${list}">
		<tr>
			<td style="text-align:left; padding-left: 50px;">
			
			<a href="info?num=${b.num}">
			${b.title}</a></td>
			<td><fmt:formatDate value="${b.regdate}" pattern="yyyy-MM-dd" var="rdate" />
			<fmt:formatDate value="${today}" pattern="yyyy-MM-dd HH:mm:ss" var="tdate" />
			<c:if test="${rdate==tdate}">
				<fmt:formatDate value="${b.regdate}" pattern="HH:mm:ss"/>
			</c:if>
			<c:if test="${rdate!=today}">
				<fmt:formatDate value="${b.regdate}" pattern="yyyy-MM-dd"/>
			</c:if></td>
		</tr>
	</c:forEach>
	<%--페이지 처리하기 --%>
	<tr>
		<td colspan="5" align="center">
		<c:if test="${pageNum <=1 }">[이전]</c:if>
		<c:if test="${pageNum > 1 }"><a href="javascript:listsubmit(${pageNum-1})">[이전]</a></c:if>
		<c:forEach var="a" begin="${startpage}" end="${endpage}">
			<c:if test="${a==pageNum}">[${a}]</c:if>
			<c:if test="${a!=pageNum}">
				<a href="javascript:listsubmit(${a})">[${a}]</a>
			</c:if>
		</c:forEach>
		<c:if test="${pageNum>=maxpage}">다음</c:if>
		<c:if test="${pageNum<maxpage}">
			<a href="javascript:listsubmit(${pageNum+1})">[다음]</a>
		</c:if>
		</td>
	</tr>
	<%-- 공지사항 게시판의 경우 관리자 로그인인 경우에만 글쓰기 출력 --%>
		<c:if test="${user.position==3}">
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