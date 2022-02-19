<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%   
response.setHeader("Cache-Control","no-store");   
 response.setHeader("Pragma","no-cache");   
 response.setDateHeader("Expires",0);   
 if (request.getProtocol().equals("HTTP/1.1")) 
         response.setHeader("Cache-Control", "no-cache"); 
 %>   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
var num=0;
	$(document).ready(function() {
		$(".btn").click(function() {
			$.post( "/rep/write", 
					{ 
						img_num: $("#img_num"+num).val(),
						writer_id: $("#writer_id"+num).val(),
						content: $("#content"+num).val()
		    		} )
		    .done(function( data ) {
//		    	alter(data);
		    	var items = eval("("+data+")"); //JSON 파일을 객체로 변환 
		    	var str = "";
		    	for(i=0;i<items.length;i++){
		    		str+=items[i].content+"(작성자:"+items[i].writer_id+")<br>";
		    	}
	//	    	alert(str);
		    	$("#div_"+items[0].img_num).html(str);
		  });
		});
	});
</script>
</head>
<body>
<h3>사진 목록</h3>
<a href="${pageContext.request.contextPath }/img/form">사진 올리기</a>
<br>
<c:if test="${empty list }">
목록이 없다.
</c:if>


<c:if test="${not empty list }">
<c:forEach var="i" items="${list}">
<table border="1" cellspacing="0">
<tr>
<th>제목</th><td>${i.title }</td>
</tr>

<tr>
<th>작성자</th>
<td>${i.writer_id }
<c:if test="${sessionScope.id==i.writer_id }">
<form action="${pageContext.request.contextPath }/img/del?num=${i.num}" method="post">
<input type="submit" value="삭제">
</form>
</c:if>
</td>
</tr>

<tr>
<td colspan="2"><img src="${pageContext.request.contextPath }/img/img_read?num=${i.num }" style="width:200px;height:200px"></td>
</tr>
<tr>
<td colspan="2">
<form action="" method="post">
<input type="text" id="content${i.num }">
<input type="hidden" id="img_num${i.num }" value="${i.num }">
<input type="hidden" id="writer_id${i.num }" value="${sessionScope.id }">
<input type="button" class="btn" value="작성" 
onclick="javascript:num=${i.num }">
</form>

<div id="div_${i.num }">
<c:forEach var="r" items="${i.reps }">
${r.content }(작성자:${r.writer_id })<br>
</c:forEach>
</div>
</td>
</tr>
</table>
</c:forEach>
</c:if>
</body>
</html>