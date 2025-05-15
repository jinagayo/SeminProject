<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교직 적성 검사</title>
</head>
<body>
  <div class="card mb-4">
     <div class="card-header">
         <i class="fas fa-table me-1"></i>
              교직 적성 자가검사
     </div>
     <div class="card-body">
     	<form action="persubmit?studno=${studno}" method="post" accept-charset="UTF-8"  name="f">
	    	<table  border="1" >
	    		<tr><th colspan=3>해당 학생은 교직에 필요한 인성과 소통 능력을 갖추고 있다.</th></tr>
	    		<tr>
	    			<td><input type="radio" name="num1" value="1">아니다</td>
	    			<td><input type="radio" name="num1" value="2">보통이다</td>
	    			<td><input type="radio" name="num1" value="3">그렇다</td>
	    		</tr>
	    		<tr><th colspan=3>해당 학생은 수업, 실습 등에서 책임감 있게 임하며 성실한 태도를 보인다.</th></tr>
	    		<tr>
	    			<td><input type="radio" name="num2" value="1">아니다</td>
	    			<td><input type="radio" name="num2" value="2">보통이다</td>
	    			<td><input type="radio" name="num2" value="3">그렇다</td>
	    		</tr>
	    		<tr><th colspan=3>해당 학생은 교사로서의 자질과 성장 가능성이 높다고 판단된다.</th></tr>
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