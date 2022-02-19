<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script>
function edit(){
	pwd = prompt("비밀번호확인")
	if(pwd=='${m.pwd}'){
		f.submit();
	}else{
		alert('패스워드 불일치\n정보수정 취소');
	}
}
</script>
</head>
<body>
<h3>edit form</h3>
<form name="f" action="${pageContext.request.contextPath }/member/edit" method="post">
id:<input type="text" name="id" value=${m.id } readonly><br>
pwd:<input type="text" name="pwd" value=${m.pwd }><br>
name:<input type="text" name="name" value=${m.name } readonly><br>
email:<input type="text" name="email" value=${m.email }><br>
<input type="button" value="edit" onclick="edit()"><br>
</form>
</body>
</html>