<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
</head>

<body>  	
	<p class="fs-6" style="padding: 20px; font-weight:bold;">${s.subname}</p>
	
	<div>
     <div style="text-align:center">
			    <h1 class="display-3"><c:if test="${b.boardid=='1'}">공지사항</c:if></h1>
				<h1><c:if test="${b.boardid=='2'}">Q&A</c:if></h1>
     </div>
     <div class="container" style="padding: 40px;">
     <!-- 게시판 전용 테이블 -->
     <table class="table qna-table" style="width:800px%;">
		<tr>
			<th width="10%" style="color:black;">제목</th>
			<td width="80%" style="text-align:left; color:black; padding:10px;"><h5>${b.title}</h5></td>
		</tr>
		<tr>
			<th width="10%" style="color:black; white-space: nowrap;">글쓴이</th>
			<td width="80%" style="text-align:left; padding:10px;">${b.writer}</td>
		</tr>
		<tr>
			<th style="color:black;">내용</th>
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
			<th>첨부파일</th>
			<td>
				<c:if test="${empty b.file1}">&nbsp;</c:if>
				<c:if test="${!empty b.file1}">
					<a href="../upload/board/${b.file1}">${b.file1}</a>
				</c:if>
			</td>
		</tr>
		<tr>
			<td colspan="2" class="w3-center">
				<a href="professor-subject-board?subcode=${b.subcode }&boardid=${b.boardid}">[목록]</a>
			</td>
		</tr>
	</table>
	</div>
	<c:if test="${b.boardid==2}">
	 <!-- 댓글 등록 폼 -->
   <span id="comment"></span>
   <form action="comment" method="post" style="width: 700px; margin-left: 15%;">

      <input type="hidden" name="num" value="${b.num}">
      
      <div style="width: 100%; ">
         <p style="width: 100%;">댓글 :
            <input type="text" name="content" class="form-control" style="width: 170%;">
            
         </p>
      </div>
      
      <div style="text-align: right; margin-right:-70%; ">
         <p>            
         <button type="submit" class="btn btn-primary">댓글등록</button>
         </p>
      </div>
   </form>
         
	

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
	</c:if>
</body>
</html>
