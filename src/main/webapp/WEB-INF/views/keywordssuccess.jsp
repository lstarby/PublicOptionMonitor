<%--
  Created by IntelliJ IDEA.
  User: pan
  Date: 16/8/23
  Time: 下午6:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Success</title>
    <link href="<c:url value='/static/bootstrap.css' />" rel="stylesheet">
    <link href="<c:url value='/static/app.css' />" rel="stylesheet">
</head>
<body>
<div class="generic-container">
    <div class="alert alert-success lead">
        ${success}
    </div>
</div>
</body>
</html>
