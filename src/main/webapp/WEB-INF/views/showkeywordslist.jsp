<%--
  Created by IntelliJ IDEA.
  User: pan
  Date: 16/8/23
  Time: 下午6:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Success</title>
    <link href="<c:url value='/static/bootstrap.css' />" rel="stylesheet">
    <link href="<c:url value='/static/app.css' />" rel="stylesheet">
</head>
<body>
<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">专题列表</span></div>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>专题名称</th>
                <th>关键词</th>
                <%--<th></th>--%>
                <%--<th>SSO ID</th>--%>
                <%--<th width="100"></th>--%>
                <%--<th width="100"></th>--%>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${keywordsList}" var="keywords">
                <tr>
                    <td>${keywords.title}</td>
                    <td>${keywords.content}</td>
                        <%--<td>${user.email}</td>--%>
                        <%--<td>${user.ssoId}</td>--%>
                        <%--<td><a href="<c:url value='/edit-user-${user.ssoId}' />" class="btn btn-success--%>

                        <%--custom-width">edit</a></td>--%>
                        <%--<td><a href="<c:url value='/delete-user-${user.ssoId}' />" class="btn btn-danger--%>

                        <%--custom-width">delete</a></td>--%>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <%--<div class="well">--%>
    <%--<a href="<c:url value='/newuser' />">Add New User</a>--%>
    <%--</div>--%>
</div>
</body>
</html>
