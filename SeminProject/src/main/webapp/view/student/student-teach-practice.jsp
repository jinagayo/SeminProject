<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교육 실습</title>
</head>
<body>
	
  <div class="card mb-4">
     <div class="card-header">
         <i class="fas fa-table me-1"></i>
              실습 일지 작성
     </div>
     <div class="card-body">
     	<form action="praticesubmit" method="post" accept-charset="UTF-8"  name="f">
	    	<table  border="1" >
	    		<tr>
	    			<th>날짜</th>
	    			<td><input type="text" name="date" class="form-control"></td>
	    		</tr>
	    		<tr>
	    			<th>활동명</th>
	    			<td><input type="text" name="activename" class="form-control"></td>
	    		</tr>
	    		<tr style="width:50px;">
	    			<th>활동 내역</th>
	    			<td>
	    				 <textarea name="content" class="form-control" rows="5" cols="50" style="resize: none;"></textarea>
	    			</td>
	    		</tr>
	    		<tr>
	    			<th>활동 소감</th>
	    			<td>
	    				 <textarea name="emotion" class="form-control" rows="15" cols="50" style="resize: none;"></textarea>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td colspan="2">
					   <button type="submit" class="btn btn-primary text-center">일지 제출</button>
				</tr>
	    	</table>
    	</form>
    </div>
  </div>
  
<script type="text/javascript">
function inputcheck(){
	f=document.f;
	if(f.date.value==""){
		alert("날짜를 입력하세요");
		f.name.focus();
		return;
	}
	if(f.activename.value==""){
		alert("활동명을 입력하세요");
		f.pass.focus();
		return;
	}
	if(f.content.value==""){
		alert("내용을 입력하세요");
		f.title.focus();
		return;
	}
	if(f.emotion.value==""){
		alert("내용을 입력하세요");
		f.title.focus();
		return;
	}
	f.submit();
}

</script>
  
  
  
</body>
</html>