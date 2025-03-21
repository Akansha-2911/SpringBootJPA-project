<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>


</head>
<body>

<table border="2">
<tr>
<th>ROLLNO</th>
<th>NAME</th>
<th>USERNAME</th>
<th>PASSWORD</th>
<th>Action</th>
</tr>

<c:forEach items="${data}" var="s">

<tr>
<td>${s.rollno}</td>
<td>${s.name}</td>
<td>${s.username}</td>
<td>${s.password}</td>
<td><a href="delete?rollno=${s.rollno }">DELETE</a>||<a href="edit?rollno=${s.rollno }">EDIT</a></td>

</tr>
</c:forEach>

</table>


</body>
</html>