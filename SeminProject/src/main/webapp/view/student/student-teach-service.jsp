<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교육 봉사 </title>
</head>
<body>
<br>
<h2 class="breadcrumb-item active  mx-5">  봉사 일지 제출</h2>
  <div class="card mb-4  mx-5">
     <div class="card-header">
         <i class="fas fa-table me-1"></i>
              봉사 일지 제출
     </div>
     <div class="card-body">
     	<form action="servicesubmit"  method="post" accept-charset="UTF-8"  name="f" enctype="multipart/form-data"  onsubmit="return inputcheck();">
	    	<table  border="1" >
	    		<tr>
	    			<th style="background-color: #2c3e50 !important;">날짜</th>
	    			<td><input type="text" name="date" class="form-control"></td>
	    		</tr>
	    		<tr>
	    			<th style="background-color: #2c3e50 !important;">봉사 활동명</th>
	    			<td><input type="text" name="servicename" class="form-control"></td>
	    		</tr>
	    		<tr>
	    			<th style="background-color: #2c3e50 !important;">봏사 단체명</th>
	    			<td><input type="text" name="groupname" class="form-control"></td>
	    		</tr>
	    		<tr>
	    			<th style="background-color: #2c3e50 !important;">봏사 시간</th>
	    			<td><input type="text" name="time" class="form-control"></td>
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
					   <button type="submit" class="btn btn-secondary text-center">일지 제출</button>
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
		return false;
	}
	if(f.time.value==""){
		alert("봉사 시간을 입력하세요");
		f.name.focus();
		return false;
	}
	if(isNaN(f.time.value)){
		alert("봉사 시간은 숫자로 입력하세요");
		f.time.focus();
		return false;
	}
	if(f.groupname.value==""){
		alert("단체명을 입력하세요");
		f.pass.focus();
		return false;
	}
	if(f.servicename.value==""){
		alert("활동명을 입력하세요");
		f.pass.focus();
		return false;
	}
	if(f.content.value==""){
		alert("내용을 입력하세요");
		f.title.focus();
		return false;
	}
	if(f.emotion.value==""){
		alert("내용을 입력하세요");
		f.title.focus();
		return false;
	}
	f.submit();
}

</script>
  
  
</body>
</html>