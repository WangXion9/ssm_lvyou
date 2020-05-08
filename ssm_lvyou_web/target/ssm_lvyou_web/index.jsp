<%@ page import="java.util.Date" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<html>
<body>
<%--<h2>Hello World!</h2>--%>
<%--<a href="${pageContext.request.contextPath}/product/findAll.do">查询所有</a>--%>
<%--<jsp:forward page="pages/main.jsp"></jsp:forward>--%>
<% session.setAttribute("loginTime", LocalDateTime.now()); %>
<script
        src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script>

    $(function () {
        location.href="${pageContext.request.contextPath}/pages/main2.jsp";
    });
</script>
</body>
</html>
