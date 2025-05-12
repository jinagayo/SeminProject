<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>폼 입력 팝업</title>
</head>
<body>
    <h2>입력 폼</h2>
    <form action="submitForm.jsp" method="post">
        <label for="name">이름:</label>
        <input type="text" id="name" name="name"><br><br>

        <label for="email">이메일:</label>
        <input type="email" id="email" name="email"><br><br>

        <input type="submit" value="제출">
    </form>
</body>
</html>