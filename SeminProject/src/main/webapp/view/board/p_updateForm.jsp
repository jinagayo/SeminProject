<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>과목공지사항 수정</title>
</head>
<body>
	<form action="update?num=${b.num}&subcode=${s.subcode}&boardid=${b.boardid}" method="post" enctype="multipart/form-data" name="f">
		<input type="hidden" name="num" value="${b.num}">
		<input type="hidden" name="file2" value="${b.file1}">
		<div class="container">
			<h2 align="center">과목공지사항 수정</h2>
			<table class="table">
				<tr>
					<td>제목</td>
					<td><input type="text" name="title" value="${b.title}" class="form-control"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea rows="15" name="content" id="summernote" class="form-control">${b.content}</textarea></td>
				</tr>
				<tr>
					<td>첨부파일</td><td style="text-align: left">
					<c:if test="${!empty b.file1}">
						<div id="file_desc">${b.file1}
							<a href="javascript:file_delete()">[첨부파일 삭제]</a>
						</div>
					</c:if>
					<input type="file" name="file1"></td>
				</tr>
				<tr>
					<td colspan="2"><a href="javascript:document.f.submit()" class="btn btn-primary">수정</a></td>
				</tr>
			</table>
		</div>	
	</form>
	<script>
		function file_delete(){
			document.f.file2.value="";
			file_desc.style.display="none";
		}
	</script>
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
	})
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