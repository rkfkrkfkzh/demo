<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>�ڷ��</h3>
<a href="${pageContext.request.contextPath }/down/form">
�ڷ�ø���</a><br>
<c:if test="${empty list }">
�ڷ� ����.
</c:if>
<c:if test="${not empty list }">
<table border="1" cellspacing="0">
<tr><th>num</th><th>title</th><th>date</th><th>�ٿ��</th></tr>
<c:forEach var="f" items="${list }">
<tr><td>${f.num }</td>
<td><a href="${pageContext.request.contextPath}/down/read?
num=${f.num }">${f.title }</a></td>
<td>${f.up_date }</td><td>${f.hit }</td></tr>
</c:forEach>
</table>
</c:if>
</body>
</html>




