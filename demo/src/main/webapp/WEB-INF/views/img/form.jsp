<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>사진 올리기</h3>
<form action="${pageContext.request.contextPath }/img/write" 
method="post" enctype="multipart/form-data">
제목:<input type="text" name="title"><br/>
사진:<input type="file" name="file">
<input type="hidden" name="writer_id" value="${sessionScope.id }">
<input type="submit" value="올리기">
</form>
</body>
</html>