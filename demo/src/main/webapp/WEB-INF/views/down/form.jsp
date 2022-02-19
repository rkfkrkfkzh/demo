<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>자료올리기</h3>
<form action="${pageContext.request.contextPath }/down/upload"
method="post" enctype="multipart/form-data">
<table border="1" cellspacing="0">
<tr>
<th>title</th><td><input type="text" name="title" size="35"></td>
</tr>
<tr>
<th>file</th><td><input type="file" name="file"></td>
</tr>
<tr>
<th>content</th><td><textarea rows="5" cols="35" name="content"></textarea></td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="올리기"></td>
</tr>
</table>
<input type="hidden" name="writer_id" value="${sessionScope.id }">
</form>
</body>
</html>








