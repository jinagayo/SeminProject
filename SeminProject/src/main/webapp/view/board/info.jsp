<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<style>

.notice-container {
  max-width: 800px !important;
  margin: 40px auto !important;
  padding: 30px !important;
  border-top: 2px solid #000 !important;
  border-bottom: 2px solid #000 !important;
  font-family: 'Segoe UI', sans-serif !important;
  background-color: #fff !important;
  color: #333 !important;
}

.notice-title {
  font-size: 22px !important;
  font-weight: bold !important;
  margin-bottom: 15px !important;
}

.notice-meta {
  font-size: 14px !important;
  color: #777 !important;
  border-bottom: 1px solid #ddd !important;
  padding-bottom: 10px !important;
  margin-bottom: 20px !important;
}

.notice-content p {
  margin-bottom: 15px !important;
  line-height: 1.6 !important;
}

.notice-content ul {
  list-style-type: circle !important;
  padding-left: 20px !important;
  line-height: 1.8 !important;
}

.notice-file {
  border-top: 1px solid #ccc !important;
  padding-top: 15px !important;
  margin-top: 20px !important;
  display: flex !important;
  align-items: center !important;
  gap: 10px !important;
  font-size: 16px !important;
}

.notice-file a {
  text-decoration: none !important;
  color: #007bff !important;
}

.preview-btn {
  background-color: #e7f1ff !important;
  border: 1px solid #007bff !important;
  color: #007bff !important;
  padding: 6px 10px !important;
  border-radius: 4px !important;
  cursor: pointer !important;
  font-size: 14px !important;
}

.notice-footer {
  text-align: right !important;
  margin-top: 30px !important;
}

.btn-back {
  background-color: #0d6efd !important;
  color: white !important;
  padding: 10px 20px !important;
  border-radius: 50px !important;
  text-decoration: none !important;
  font-weight: bold !important;
  display: inline-block !important;
  transition: background-color 0.2s ease !important;
}

.btn-back:hover {
  background-color: #084cdf !important;
}
</style>
<meta charset="UTF-8">
<title>알림마당</title>
</head>
<body>
	<h2 class="">알림마당</h2>
	
	<div class="notice-container">
  <h2 class="notice-title">${b.title}</h2>
  
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