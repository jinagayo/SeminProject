<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교직 적성 검사</title>
</head>
<body>
<br>
<h2 class="breadcrumb-item active  mx-5">  교직 적성 자가검사</h2>
  <div class="card mb-4  mx-5">
     <div class="card-header">
         <i class="fas fa-table me-1"></i>
              교직 적성 자가검사
     </div>
     <div class="card-body">
     	<form action="persubmit" method="post" accept-charset="UTF-8"  name="f">
	    	<table  border="1" >
	    		<tr><th colspan=3  style="background-color: #2c3e50 !important;">나는 학생들과 효과적으로 의사소통하고 공감하는 데 자신이 있다.</th></tr>
	    		<tr>
	    			<td><input type="radio" name="num1" value="1">아니다</td>
	    			<td><input type="radio" name="num1" value="2">보통이다</td>
	    			<td><input type="radio" name="num1" value="3">그렇다</td>
	    		</tr>
	    		<tr><th colspan=3 style="background-color: #2c3e50 !important;">교육자로서의 책임감과 윤리 의식을 항상 중요하게 생각한다.</th></tr>
	    		<tr>
	    			<td><input type="radio" name="num2" value="1">아니다</td>
	    			<td><input type="radio" name="num2" value="2">보통이다</td>
	    			<td><input type="radio" name="num2" value="3">그렇다</td>
	    		</tr>
	    		<tr><th colspan=3 style="background-color: #2c3e50 !important;">다양한 상황에서도 차분하게 문제를 해결하고 학생들을 지도할 수 있다.</th></tr>
	    		<tr>
	    			<td><input type="radio" name="num3" value="1">아니다</td>
	    			<td><input type="radio" name="num3" value="2">보통이다</td>
	    			<td><input type="radio" name="num3" value="3">그렇다</td>
	    		</tr>
	    		<tr>
	    			<td colspan="3">
					   <button type="submit" class="btn btn-primary text-center">제출</button>
				</tr>
	    	</table>
	    </form>
	</div>
	
 </div>
<script type="text/javascript">
function inputcheck(){
	f=document.f;
	if(f.num1.value==""||f.num2.value==""||f.num3.value==""){
		alert("모든 항목을 선택하세요");
		f.name.focus();
		return;
	}
</script>
</body>
</html>