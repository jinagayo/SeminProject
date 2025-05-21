<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>

<body class="qna-page">  	
	<h2 class="  mx-5">${s.subname}</h2>
	
	<div class="card mb-4  mx-5">
     <div class="card-header ">
         <i class="fas fa-table me-1"></i>
			    <c:if test="${b.boardid=='1'}">공지사항</c:if>
				<c:if test="${b.boardid=='2'}">Q&A</c:if>
     </div>

     <!-- 게시판 전용 테이블 -->
     <table>
		<tr>
			<th style="background-color: #2c3e50 !important;" width="10%" >제목</th>
			<td width="80%" style="text-align:left;  padding:10px;"><h5>${b.title}</h5></td>
		</tr>
		<tr>
			<th style="background-color: #2c3e50 !important;" width="10%">글쓴이</th>
			<td width="80%" style="text-align:left; padding:10px;">${b.writer}</td>
		</tr>
		<tr>
			<th style="background-color: #2c3e50 !important;">내용</th>
			<td>
				<table style="width:100%; height:250px;">
					<tr>
						<td style="border-width: 0px; vertical-align: top; text-align: left; margin:0px; padding:10px">
							${b.content}
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<th style="background-color: #2c3e50 !important;">첨부파일</th>
			<td>
				<c:if test="${empty b.file1}">&nbsp;</c:if>
				<c:if test="${!empty b.file1}">
					<a href="../upload/board/${b.file1}">${b.file1}</a>
				</c:if>
			</td>
		</tr>
		<tr>
		</tr>
	</table>
	<c:if test="${b.boardid==2}">
	

	<!-- 댓글 목록 -->
	<div class="container">
		<table class="table">
			<c:forEach var="c" items="${commlist}">
				<tr>
					<td>${c.seq}</td><td>${c.writer}</td>
					<td>${c.content}</td><td>${c.regdate}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	</c:if>    <button onclick = "history.back()" class="btn btn-secondary" style="width:50px">←</button>
</body>
</html>
