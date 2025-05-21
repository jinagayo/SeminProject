<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교육 실습</title>
</head>
<body>
<br>
<h2 class="breadcrumb-item active  mx-5">  실습 일지 작성</h2>
  <div class="card mb-4  mx-5">
     <div class="card-header">
         <i class="fas fa-table me-1"></i>
              실습 일지 작성
     </div>
     <div class="card-body">
     	<form action="praticesubmit" method="post" accept-charset="UTF-8"  name="f" enctype="multipart/form-data" onsubmit="return inputcheck();">
	    	<table  border="1" >
	    		<tr>
	    			<th style="background-color: #2c3e50 !important;">날짜</th>
	    			<td><input type="text" name="date" class="form-control"></td>
	    		</tr>
	    		<tr>
	    			<th style="background-color: #2c3e50 !important;">활동명</th>
	    			<td><input type="text" name="activename" class="form-control"></td>
	    		</tr>
	    		<tr style="width:50px;">
	    			<th style="background-color: #2c3e50 !important;">활동 내역</th>
	    			<td>
	    				 <textarea name="content" class="form-control" rows="5" cols="50" style="resize: none;"></textarea>
	    			</td>
	    		</tr>
	    		<tr>
	    			<th style="background-color: #2c3e50 !important;">활동 소감</th>
	    			<td>
	    				 <textarea name="emotion" class="form-control" rows="15" cols="50" style="resize: none;"></textarea>
	    			</td>
	    		</tr>
				<tr>
					<th style="background-color: #2c3e50 !important;">활동 증명서</th>
					<td>
					    <input type="file" name="file1" />
					</td>
				</tr>
	    		<tr>
	    			<td colspan="2">
					   <button type="submit" class="btn btn-primary text-center">일지 제출</button>
	    	</table>
    	</form>
    </div>
  </div>
  
<script type="text/javascript">
function inputcheck(){
	f=document.f;
	if(f.date.value==""){
		alert("날짜를 입력하세요");
		f.date.focus();
		return false;
	}
	if(f.activename.value==""){
		alert("활동명을 입력하세요");
		f.activename.focus();
		return false;
	}
	if(f.content.value==""){
		alert("내용을 입력하세요");
		f.content.focus();
		return false;
	}
	if(f.emotion.value==""){
		alert("내용을 입력하세요");
		f.emotion.focus();
		return false;
	}
	if(f.file1.value==""){
		alert("증명서를 제출하세요");
		f.file1.focus();
		return false;
	}
	return true;
}

</script>
  
</body>
</html>