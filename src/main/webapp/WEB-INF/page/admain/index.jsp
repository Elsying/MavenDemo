<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="wrap">
    <!-- 头部 -->
    <div id="header">
        <c:import url="header.jsp"/>
    </div>
    <!-- 左侧菜单和主体内容 -->
    <div class="grid-1-7" style="flex: 1;margin:0;">
        <!-- 左侧菜单 -->
        <c:import url="menu.jsp"/>
    </div>
</div>
</body>
</html>
