<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!DOCTYPE html>
<html>
<head>
  <style>

    .close-btn {
      position: absolute;
      top: 5px;
      right: 10px;
      cursor: pointer;
      font-size: 18px;
      color: #888;
    }

    .close-btn:hover {
      color: #000;
    }
  </style>
</head>
<body>

<div>
<span style="margin-left: 100px; margin-top: 50px; display: inline-block;">
  <button onclick="toggleForm1()">출석조회</button>
</span>

<span style="margin-left: 100px; margin-top: 50px; display: inline-block;">
  <button onclick="toggleForm2()">성적조회</button>
</span>
</div>
<div style="display: flex; gap: 20px; margin-top: 10px;">
<span id="attForm" style="border: 2px solid #ccc;  display: none; position: relative; margin-top: 10px; margin-left:20px; padding: 20px; width: 300px; height: 400px;">
  <span class="close-btn" onclick="closeForm1()">✖</span>
  <form>
    <label for="name">이름:</label>
    <input type="text" id="name" name="name"><br><br>

    <label for="email">이메일:</label>
    <input type="email" id="email" name="email"><br><br>

    <input type="submit" value="제출">
  </form>
</span>

<span id="gradeForm" style="border: 2px solid #ccc;  display: none; position: relative; margin-top: 10px; margin-left:20px; padding: 20px; width: 300px; height: 400px;">
  <span class="close-btn" onclick="closeForm2()">✖</span>
  <form>
    <label for="name">이름:</label>
    <input type="text" id="name" name="name"><br><br>

    <label for="email">이메일:</label>
    <input type="email" id="email" name="email"><br><br>

    <input type="submit" value="제출">
  </form>
</span>
</div>

<script>
  function toggleForm1() {
    const form = document.getElementById("attForm");
    form.style.display = "block"
  }

  function closeForm1() {
    document.getElementById("attForm").style.display = "none";
  }
  
  function toggleForm2() {
	    const form = document.getElementById("gradeForm");
	    form.style.display = "block"
	  }

	  function closeForm2() {
	    document.getElementById("gradeForm").style.display = "none";
	  }
</script>

</body>
</html>
