<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>파일 업로드</h3>
<form action="/file/upload" method="post" enctype="multipart/form-data">
title:<input type="text" name="title"><br>
upload file:<input type="file" name="file"><br>
<input type="submit" value="upload">
</form>
</body>
</html>