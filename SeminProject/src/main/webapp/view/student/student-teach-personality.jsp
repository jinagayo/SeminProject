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
     	<form action="praticesubmit" method="post" accept-charset="UTF-8"  name="f">
	    	<table  border="1" >
	    		<tr><th colspan=3>나는 학생들과 효과적으로 의사소통하고 공감하는 데 자신이 있다.</th></tr>
	    		<tr>
	    			<td><input type="radio" name="num1" value="1">아니다</td>
	    			<td><input type="radio" name="num1" value="2">보통이다</td>
	    			<td><input type="radio" name="num1" value="3">그렇다</td>
	    			
	    		</tr>
	    	</table>
	    </form>
	</div>
	
 </div>

</body>
</html>