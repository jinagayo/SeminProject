<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
.detail-table {
  width: 100%;
  max-width: 800px;
  border-collapse: separate;  /* 선을 분리하여 간격과 둥근 모서리를 표현하기 위함 */
  border-spacing: 0 12px;     /* tr 사이의 간격 */
  margin: 30px auto;
  font-family: 'Segoe UI', sans-serif;
  background-color: transparent;
}

.detail-table th {
  text-align: left;
  padding: 16px 20px;
  background-color: #f0f0f0;
  border-radius: 12px 0 0 12px;
  color: #333;
  font-weight: 600;
  width: 20%;
  vertical-align: top;
}

.detail-table td {
  padding: 16px 20px;
  background-color: #ffffff;
  border-radius: 0 12px 12px 0;
  box-shadow: 0 1px 4px rgba(0,0,0,0.08);
  color: #444;
  line-height: 1.5;
  vertical-align: top;
}

	
</style>
<meta charset="UTF-8">
<title>알림마당</title>
</head>
<body>
	<h2 class="">알림마당</h2>
	<table class="table">
		<tr>
			<td><table style="width:100%; height:250px;" class="detail-table">
					<tr>
						<th>제목</th>
						<td>${b.title}</td>
					</tr>
					<tr>
						<th>내용</th>
						<td style="border-width: 0px; vertical-align :top;text-align:left;margin:0px;padding:0px">
						${b.content}</td>
					</tr>
			</table></td>
		<tr>
			<th>첨부파일</th>
			<td><c:if test="${empty b.file1}">&nbsp;</c:if>
			<c:if test="${!empty b.file1}">
			<a href="../upload/board/${b.file1}">${b.file1}</a>
			</c:if></td></tr>
		<tr><td colspan="2" class="w3-center">
			<a href="updateForm?num=${b.num}">수정</a>
			<a href="deleteForm?num=${b.num}">삭제</a>
			<a href="notice">목록</a></td></tr>
	</table>
	
</body>
</html>