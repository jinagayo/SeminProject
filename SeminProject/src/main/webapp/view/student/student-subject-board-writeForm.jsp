<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="student-subject-board-write" method="post" enctype="multipart/form-data" name="f">
	<h2 class="text-center">Q&A</h2>
	<input type="hidden" name="subcode" value="${param.subcode}">
	<input type="hidden" name="boardid" value="${param.boardid}">
	<table class="table">
		<tr><td>제목</td>
			<td><input type="text" name="title" class="form-control"></td></tr>
		<tr><td>내용</td>
			<td><textarea rows="15" name="content" id="summernote" class="form-control"></textarea></td></tr>
		<tr><td>첨부파일</td><td><input type="file" name="file1"></td></tr>
		<tr><td colspan="2">
			<a href="javascript:inputcheck()" class="btn btn-primary text-center">게시물등록</a></td></tr>
	</table>
</form>
<script type="text/javascript">
function inputcheck(){
	f=document.f;
	if(f.content.value==""){
		alert("내용을 입력하세요");
		f.content.focus();
		return;
	}
	if(f.title.value==""){
		alert("제목을 입력하세요");
		f.title.focus();
		return;
	}
	f.submit();//submit 발생 =>form의 action 페이지로 요청
}</script>

<%--summernote 관련 구현 --%>
<script type="text/javascript">
	$(function(){
		$("#summernote").summernote({
			height:300,
			callbacks :{
				//onImageUpload : 이미지 업로드 이벤트 발생
				//files : 한개 이상의 이미지 업로드 가능. 배열
				onImageUpload : function(files){
					for(let i=0;i<files.length;i++){
						sendFile(files[i]); //하나씩 ajax 이용하여 서버로 전송
					}
				}
			}
		})
	}
function sendFile(file){
	let data = new FormData(); //폼데이터를 수집하고 전송 가능한 객체. 파일 업로드에 사용됨
	data.append("file",file); //file : 이미지파일
	$.ajax({
		url:"${path}/uploadImage",
		type:"post",
		data:data,
		processData:false,
		contentType : false,
		success :function(url){
			//url: 업로드 된 이미지의 접근 url 정보
			$("#summernote").summernote("insertImage",url);
			//<img src="url">변경.
		},
		error : function(e){
			alert("이미지 업로드 실패 : "+e.status)
		}
	})
}

</script>
</body>
</html>