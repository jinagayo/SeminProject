<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- /webapp/member/picture.jsp--%>    
<script>
   img = opener.document.getElementById("pic"); 
   img.src = "../picture/${fname}";
   /*
      info.jsp : picture => ../picture
      updateForm.jsp : picture => ../picture
   */

   window.close();  // 창이 로드되자마자 닫힘
</script>