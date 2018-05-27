<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%
    pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<script>
    window.location.href = "${APP_PATH}/user_info/index.action";
</script>