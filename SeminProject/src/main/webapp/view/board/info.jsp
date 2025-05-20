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
<title>알림마당</title>
</head>
<body>
	<h2 class="text-center"  onclick="location.href='../board/notice'">알림마당</h2>
	
	<div class="notice-container" >
  <h2 class="notice-title" >${b.title}</h2>
  
  <div class="notice-meta">

  </div>

  <div class="notice-content">
   ${b.content}
  </div>

  <div class="notice-file">
    <c:if test="${empty b.file1}">&nbsp;</c:if>
	<c:if test="${!empty b.file1}">
		<a href="../upload/board/${b.file1}">${b.file1}</a>
	</c:if>
  </div>

  <div class="notice-footer">
    
		<c:if test="${user.position==3}">
			
			<a href="updateForm?num=${b.num}">수정</a>
			<a href="javascript:deleteA(${b.num})">삭제</a>

		</c:if>
			<a href="notice">목록</a>
  </div>
</div>
	

	
<script>
function deleteA(num){
	if(confirm("삭제하시겠습니까?")){
		location.href = "delete?num=" + num;
	}
}
</script>
</body>
</html>