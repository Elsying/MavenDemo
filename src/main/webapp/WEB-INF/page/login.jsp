<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/12
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页</title>
</head>
<body>
<form id="loginForm" action="login.action" method="post">
    登录名:<input type="text" name="login_name" />
    密码:<input type="password" name="pass_word" />
    <input type="submit" value="登录" />
</form>
</body>
</html>
