<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>登录</h1>
	<form action="http://127.0.0.1:8080/servlet/loginServlet" method="post">
		用户 <input name="username" type="text"/>
		密码 <input name="password" type="password"/>
		记住密码 <input name="isAutoLogin" type="checkbox"/>
		<input type="submit" value="登录"/>
	</form>
</body>
</html>