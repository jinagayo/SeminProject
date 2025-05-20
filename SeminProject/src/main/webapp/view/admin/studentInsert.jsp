<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
  	<link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" />
    <title>학생 등록</title>
  </head>
  <body>
  <br>
  <h2 class="breadcrumb-item active  mx-5">  학생 등록</h2>
  <div class="card mb-4  mx-5">
     <div class="card-header">
         <i class="fas fa-table me-1"></i>
              학생 등록
     </div>
     <div class="card-body">
     <form action="studentInsertaction" name="f" method="post"  enctype="multipart/form-data" onsubmit="return input_check(this)" accept-charset="UTF-8">
    	<table id="datatablesSimple" border="1" style="width: 100%;height:100%;text-align:left;">
       		<tr class="text-center">
       			<th style="background-color: #2c3e50 !important;">이름</th>
       			<td><input type="text" name="name" style="width:100%;" class="input-group-text"></td>
       		</tr>
       		<tr class="text-center">
       			<th style="background-color: #2c3e50 !important;">생년월일</th>
       			<td><input type="text" name="birth" style="width:100%;" class="input-group-text"></td>
       		</tr>
       		<tr class="text-center">	
       			<th style="background-color: #2c3e50 !important;">전화번호</th>
       			<td><input type="text" name="phone" style="width:100%;" class="input-group-text"></td>
       		</tr>
       		<tr class="text-center">
       			<th style="background-color: #2c3e50 !important;">주소</th>
       			<td><input type="text" name="address" style="width:100%;" class="input-group-text"></td>
       		</tr>
       		<tr class="text-center">
       			<th style="background-color: #2c3e50 !important;">이메일</th>
       			<td><input type="email" name="email" style="width:100%;" class="input-group-text"></td>
       		</tr>
       		<tr class="text-center">
       			<th style="background-color: #2c3e50 !important;">입학년도</th>
       			<td><input type="text" name="entry" style="width:100%;" class="input-group-text"></td>
       		</tr>
       		<tr class="text-center">
       			<th style="background-color: #2c3e50 !important;">학과코드</th>
       			<td><input type="text" name="majorcode" style="width:100%;" class="input-group-text"></td>
       		</tr>
       		<tr class="text-center">
       			<th style="background-color: #2c3e50 !important;">지도교수코드</th>
       			<td><input type="text" name="profcode" style="width:100%;" class="input-group-text"></td>
       		</tr>
				<tr>
					<th style="background-color: #2c3e50 !important; text-align:center;">사진</th>
					<td>
					    <input type="file" name="file1" />
					</td>
				</tr>
       		<tr>
       			<td colspan="2">
       				<button type="submit" class="btn btn-primary text-center">등록</button>
       			</td>
       		</tr>
    	</table>
    	
    	</form>
    </div>
 </div>
  </body>
<script type="text/javascript">
function inputcheck(){
	f=document.f;
	if(f.name.value==""){
		alert("이름을 입력하세요");
		f.name.focus();
		return false;
	}
	if(f.birth.value==""){
		alert("생년월일을 입력하세요");
		f.birth.focus();
		return false;
	}
	if(f.phone.value==""){
		alert("전화번호를 입력하세요");
		f.phone.focus();
		return false;
	}
	if(f.address.value==""){
		alert("주소를 입력하세요");
		f.address.focus();
		return false;
	}
	if(f.email.value==""){
		alert("이메일을 입력하세요");
		f.email.focus();
		return false;
	}
	if(f.entry.value==""){
		alert("이메일을 입력하세요");
		f.entry.focus();
		return false;
	}
	if(f.majorcode.value==""){
		alert("학과코드를 입력하세요");
		f.majorcode.focus();
		return false;
	}
	if(f.profcode.value==""){
		alert("교수번호를 입력하세요");
		f.profcode.focus();
		return false;
	}
	return true;
}

</script>
  
</html>>