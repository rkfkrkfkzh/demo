<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>���� �ø���</h3>
<form action="${pageContext.request.contextPath }/img/write" 
method="post" enctype="multipart/form-data">
����:<input type="text" name="title"><br/>
����:<input type="file" name="file">
<input type="hidden" name="writer_id" value="${sessionScope.id }">
<input type="submit" value="�ø���">
</form>
</body>
</html>