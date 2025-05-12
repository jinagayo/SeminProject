<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
  	<link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" />
    <title>학생 정보 조회</title>
  </head>
  <body>
  <br>
  <h2 class="breadcrumb-item active">  학생 등록</h2>
  <div class="card mb-4">
     <div class="card-header">
         <i class="fas fa-table me-1"></i>
              DataTable Example
     </div>
     <div class="card-body">
     <form action="studentInsert" name="f" method="post" onsubmit="return input_check(this)" accept-charset="UTF-8">
    	<table id="datatablesSimple" border="1" style="width: 100%;height:100%;text-align:left;">
       		<tr>
       			<th>이름</th>
       			<td><input type="text" name="name"></td>
       		</tr>
       		<tr>
       			<th>생년월일</th>
       			<td><input type="text" name="birth"></td>
       		</tr>
       		<tr>	
       			<th>전화번호</th>
       			<td><input type="text" name="phone"></td>
       		</tr>
       		<tr>
       			<th>주소</th>
       			<td><input type="text" name="address"></td>
       		</tr>
       		<tr>
       			<th>이메일</th>
       			<td><input type="email" name="email"></td>
       		</tr>
       		<tr>
       			<th>입학년도</th>
       			<td><input type="text" name="entry"></td>
       		</tr>
       		<tr>
       			<th>학과코드</th>
       			<td><input type="text" name="majorcode"></td>
       		</tr>
       		<tr>
       			<th>지도교수코드</th>
       			<td><input type="text" name="profcode"></td>
       		</tr>
    	</table>
    	<button type="submit" onclick="chk()">등록</button>
    	</form>
    	
    </div>
 </div>
  </body>
  <script type="text/javascript">
  	function chk(){
		if(document.f.name.value == ""){
			alert("이름을 입력하세요")
			document.f.name.focus()
		}
		else if(document.f.birth.value == ""){
			alert("생년월일을 입력하세요")
			document.f.birth.focus()
		}
		else if(document.f.phone.value == ""){
			alert("전화번호를 입력하세요");
			document.f.phone.focus();
		}
		else if(document.f.address.value == ""){
			alert("주소를 입력하세요");
			document.f.address.focus();
		}
		else if(document.f.email.value == ""){
			alert("이메일을 입력하세요");
			document.f.email.focus();
		}
		else if(document.f.entry.value == ""){
			alert("입학년도를 입력하세요");
			document.f.entry.focus();
		}
		else if(document.f.majorcode.value == ""){
			alert("학과코드를 입력하세요")
			document.f.majorcode.focus();
		}
		else{
			alert("지도교수 코드를 입력하세요");
			document.f.profcode.focus();
		}
  	}
  
  
  </script>
</html>>