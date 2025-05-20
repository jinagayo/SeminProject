
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 정보 수정</title>
</head>
<body>
  <br>
  <h2 class="breadcrumb-item active  mx-5">  학적 정보 조회</h2>
  <div class="card mb-4  mx-5">
     <div class="card-header">
         <i class="fas fa-table me-1"></i>
              학적 정보 조회
     </div>
     <div class="card-body">
		<div class="container">
			<table class="table">
	<form action="updateStudent" method="post" name="f">
    <input type="hidden" name="img" value="${user_std.img}">
    <input type="hidden" name="studno" value="${user_std.id}">
       		<tr>
	    		<td rowspan=7>
					<img id="pic"  src="${pageContext.request.contextPath}/picture/${user_std.img}" width="100" height="120">
<br>
					<font size="1"><a href="javascript:win_upload()">사진수정</a></font>	
	    		</td>
       			<th style="background-color: #2c3e50 !important;">이름</th>
       			<td><input type="text" name="name" value="${user_std.name}" class="form-control"></td>
       			<th style="background-color: #2c3e50 !important;">계열</th>
       			<td>
       				<select name="college" id="college" >
       					<option value="${std.college}">${std.college}</option>
       					<c:forEach var="col" items="${college }" varStatus="status">
       						<option value="${col.mcode}">${col.mname }</option>
       					</c:forEach>
       				</select>
       			</td>
       		</tr>
       		<tr>
       			<th style="background-color: #2c3e50 !important;">학번</th>
       			<td>${user_std.id}</td>
       			<th style="background-color: #2c3e50 !important;">전공</th>
       			<td>
				  <!-- 사용자에게 보여질 전공 select -->
				  <select id="major" name="major" class="form-control">
				    <option value="${std.mcode }">${std.major}</option>
				  </select>
				
				  <!-- 모든 전공 데이터를 숨겨둔 select (자바스크립트가 참조) -->
				  <select name="major" id="allMajors" style="display: none;">
					  <option value="${std.mcode}" data-ccode="${std.ccode}" data-selected="true">${std.major}</option>
					  <c:forEach var="maj" items="${major}">
					    <option 
					      value="${maj.mcode}" 
					      data-ccode="${maj.ccode}" 
					      <c:if test="${maj.mcode == std.mcode}">data-selected="true"</c:if>>
					      ${maj.mname}
					    </option>
					  </c:forEach>
					</select>

				</td>
       		</tr>
       		<tr>
       			<th style="background-color: #2c3e50 !important;">생년월일</th>
       			<td>${user_std.birth}</td>
       			<th style="background-color: #2c3e50 !important;">학년</th>
       			<td><input type="text" name="grade" value="${std.grade}" class="form-control"></td>
       		</tr>
       		<tr>
       			<th style="background-color: #2c3e50 !important;">전화번호</th>
       			<td><input type="text" name="phone" value="${user_std.phone}" class="form-control"></td>
       			<th style="background-color: #2c3e50 !important;">학점</th>
       			<td>${std.tograde}</td>
       		</tr>
       		<tr>
       			<th style="background-color: #2c3e50 !important;">이메일</th>
       			<td><input type="text" name="email" value="${user_std.email}" class="form-control"></td>
       			<th style="background-color: #2c3e50 !important;">졸업 요건 충족</th>
       			<td>x</td>
       		</tr>
       			<th style="background-color: #2c3e50 !important;">주소</th>
       			<td colspan=3><input type="text" name="address" value="${user_std.address}" class="form-control"></td>
       		</tr>
			<tr>
			  <td colspan=4>
			    <button type="submit" class="btn btn-secondary">수정</button>
			  </td>
			</tr>
			
	

	</form>			
		</table> 
<script>
const collegeSelect = document.getElementById('college');
const majorSelect = document.getElementById('major');
const allMajors = document.getElementById('allMajors');

function updateMajorOptions(selectedCollegeCode) {

  for (const option of allMajors.options) {
    if (option.dataset.ccode === selectedCollegeCode) {
      const newOption = document.createElement('option');
      newOption.value = option.value;
      newOption.textContent = option.textContent;

      // 전공 초기값이 있을 경우 선택되도록
      if (option.dataset.selected === "true") {
        newOption.selected = true;
      }

      majorSelect.appendChild(newOption);
    }
  }
}

// 페이지 로딩 시 한 번 초기화 (수정폼이라서 std.college 기준)
window.addEventListener('DOMContentLoaded', function () {
  updateMajorOptions(collegeSelect.value);
});

// 단과대학 선택 시 전공 필터링
collegeSelect.addEventListener('change', function () {
	  majorSelect.innerHTML = '';
	  updateMajorOptions(this.value);
});
	function win_upload(){
		let op="width=500,height=500,left=50,top=150" ;
		open("pictureForm","",op) ;
	}
</script>
</body>
</html>