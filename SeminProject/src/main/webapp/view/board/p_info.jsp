<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<style>

.notice-container {
  max-width: 800px ;
  margin: 40px auto ;
  padding: 30px ;
  border-top: 2px solid #000 ;
  border-bottom: 2px solid #000 ;
  font-family: 'Segoe UI', sans-serif ;
  background-color: #fff ;
  color: #333 ;
}

.notice-title {
  font-size: 22px ;
  font-weight: bold ;
  margin-bottom: 15px ;
}

.notice-meta {
  font-size: 14px ;
  color: #777 ;
  border-bottom: 1px solid #ddd ;
  padding-bottom: 10px ;
  margin-bottom: 20px ;
}

.notice-content p {
  margin-bottom: 15px ;
  line-height: 1.6 ;
}

.notice-content ul {
  list-style-type: circle ;
  padding-left: 20px ;
  line-height: 1.8 ;
}

.notice-file {
  border-top: 1px solid #ccc ;
  padding-top: 15px ;
  margin-top: 20px ;
  display: flex ;
  align-items: center ;
  gap: 10px ;
  font-size: 16px ;
}

.notice-file a {
  text-decoration: none ;
  color: #007bff ;
}

.preview-btn {
  background-color: #e7f1ff ;
  border: 1px solid #007bff ;
  color: #007bff ;
  padding: 6px 10px ;
  border-radius: 4px ;
  cursor: pointer ;
  font-size: 14px ;
}

.notice-footer {
  text-align: right ;
  margin-top: 30px ;
}

.btn-back {
  background-color: #0d6efd ;
  color: white ;
  padding: 10px 20px ;
  border-radius: 50px ;
  text-decoration: none ;
  font-weight: bold ;
  display: inline-block ;
  transition: background-color 0.2s ease ;
}

.btn-back:hover {
  background-color: #084cdf ;
}
</style>
<meta charset="UTF-8">
<title>과목공지사항</title>
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
		
	</table>
	</div>
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
	
	 <!-- 댓글 등록 폼 -->
   <span id="comment"></span>
   <form action="comment?num=${b.num}&subcode=${s.subcode}&boardid=${b.boardid}" method="post" style="width: 600px; margin-left: 5%;">

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
         

	</c:if>
	
	 <div class="notice-file">
    <c:if test="${empty b.file1}">&nbsp;</c:if>
	<c:if test="${!empty b.file1}">
		<a href="../upload/board/${b.file1}">${b.file1}</a>
	</c:if>
  </div>

  <div class="notice-footer">
    
		<c:if test="${user.position==2 && b.boardid==1}">
			
			<a href="p_updateForm?num=${b.num}&subcode=${s.subcode}&boardid=${b.boardid}">수정</a>
			<a href="javascript:deleteA(${b.num})">삭제</a>

		</c:if>
			<a href="../professor/professor-subject-Mboard?num=${b.num}&subcode=${s.subcode}&boardid=${b.boardid}">목록</a>

  </div>
</div>
<script>
function deleteA(num){
	if(confirm("삭제하시겠습니까?")){
		location.href = "delete?num=" + num + "&subcode=" + ${s.subcode} + "&boardid=" + ${b.boardid};
	}
}
</script>
	
</body>
</html>
