<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update</title>
</head>
<body>

<form action="update">
<pre>
<input type="hidden" name="rollno" value="${stu.rollno}">
Name: <input type="text" name="name" value="${stu.name}">

username: <input type="text" name="username" value="${stu.username}">

password: <input type="text" name="password" value="${stu.password}">

<input type="submit" value="update">

</pre>

</form>

</body>
</html>