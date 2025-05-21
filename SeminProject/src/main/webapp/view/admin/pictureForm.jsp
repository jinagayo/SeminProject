
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert 사진 등록</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>
<table>
<tr><td><img id="preview" src=""></td></tr>
<tr><td>
<form action="picture" method="post" enctype="multipart/form-data">
<%-- MIME 타입 : 문서의 형식 설정 문서유형/.세부종류. text/html,img/jpeg,img/gif ....
	accept ="img/*"=>img 문서 유형만 업로드 가능.
--%>
	<input type="file" name="picture" id="imageFile" accept="img/*">
	<input type="submit" value="사진등록">
</form></td></tr></table>
<script type="text/javascript">
//자바스크립트로 이미지 미리보기 구현
let imagefile= document.querySelector('#imageFile') ; //<input type="file"...>
let preview = document.querySelector('#preview') ;	//이미지태크 <img id="preview"
//change 이벤트 :  선택된 파일이 변경되었을 떄
imagefile.addEventListener('change',function(e){ //이벤트 핸들러 등록
	//e.target : file 객체
	//e.target.files : 선택된 파일들.
	let get_file = e.target.files ;
	let reader = new FileReader() ; //파일을 읽기위한 스트림 객체.
	reader.onload = (function(Img){ //reader 객체에 파일이 로드되는 경우 이벤트 등록
		//preview(이미지태그)를 매개변수값(인자)으로 호출
		//Img 매개변수 : preview 객체를 저장
		//자바스크립트에서는 함수객체를 리턴할 수 있음 
		return function(e){
			//e.target.result : 선택된 파일의 값. 파일의 이름
			Img.src = e.target.result ;
		}
	})(preview) ;
	//get_file :  선택된 파일이 존재?
	//reader.readAsDataURL(get_file[0]) : 첫번째 선택된 파일을 reader로 읽기.
	if(get_file){reader.readAsDataURL(get_file[0]) ;}
}) ;
</script>

</body>
</html>