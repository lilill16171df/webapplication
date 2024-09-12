<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>

<form action="/webapplication/create" method="POST">
	<table>
		<tr>
			<td>이름</td><td><input type="text" name="name">
		</tr>
		
		<tr>
			<td>전화번호</td><td><input type="text" name="hp"></td>
		</tr>
		
		<tr>
			<td>메모</td><td><input type="text" name="memo"></td>
		</tr>
	</table>
	<input type="submit" value="전화번호 입력">
</form>

검색 <input type="text" name="search"> <hr>
<c:forEach var="phonebook" items="${phonebookList}">
	<div onclick="showDetails">
		<div>${phonebook.name}</div>
		<div>${phonebook.hp}</div> <hr>
	</div>
</c:forEach>


<form>
	<div>길동이</div>
	<div>010-1111-1111</div>
	<div>메모없음</div>
	<div>길동이</div>
	<div>2021-08-01</div>
	<input type="submit" value="수정">
	<input type="submit" value="삭제">
</form>
		
</body>
</html>