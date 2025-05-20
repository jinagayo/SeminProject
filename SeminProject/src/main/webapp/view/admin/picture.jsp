<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html ; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%-- /webapp/member/picture.jsp
    1.request 객체로 이미지 업로드 불가 => cos.jar 
    2. 이미지 업로드 폴더 : 현재폴더/picture 설정
    3. opener 화면에 이미지 볼 수 있도록 결과 전달 => javascript
    4. 현재 화면 close 하기		=> javascript
     --%>

<script>
	img = opener.document.getElementById("pic") ;//<img id ="pic"...이미지 객체>
	img.src = "../picture/${fname}" ; //=>opener 페이지의 이미지 보임
	opener.document.f.img.value="${fname}" ;
	//self : 현재페이지의 window 객체
	window.close() ;

</script>