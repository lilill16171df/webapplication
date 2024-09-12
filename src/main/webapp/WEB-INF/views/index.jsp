<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
<script>
	function showDetails(id, name, hp, memo) {
		document.getElementById('details-id').value = id;
	    document.getElementById('details-name').value = name;
	    document.getElementById('details-hp').value = hp;
	    document.getElementById('details-memo').value = memo;
	}
	
    function actionDelete() {
    	var form = document.getElementById('details-form');
    	
    	form.method="post";
    	form.action="/webapplication/delete";
    	form.target="_self";
    	
        form.submit();
    }
</script>
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

<form id="search-form" action="/webapplication/search" method="post">
    검색 <input type="text" name="search" placeholder="검색어를 입력하세요" onkeydown="if(event.key === 'Enter') submitSearch();">
</form>

<c:forEach var="phonebook" items="${phonebookList}">
	<div onclick="showDetails('${phonebook.id}', '${phonebook.name}', '${phonebook.hp}', '${phonebook.memo}')">
		<div>${phonebook.name}</div>
		<div>${phonebook.hp}</div> <hr>
	</div>
</c:forEach>


<form action="/webapplication/update" method="post" id="details-form">
	<input type="hidden" id="details-id" name="id"> <br>
	<input type="text" id="details-name" name="name"> <br>
	<input type="text" id="details-hp" name="hp"> <br>
	<input type="text" id="details-memo" name="memo"> <br>
	<input type="submit" value="수정">
	<input type="submit" value="삭제" onclick="actionDelete()">
</form>
<div>2021-08-01</div>

</body>
</html>