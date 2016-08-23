<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: pan
  Date: 16/8/20
  Time: 上午11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link>
<title>Title</title>
<link href="<c:url value="/static/bootstrap.css"/>" rel="stylesheet"/>
<link href="<c:url value="/static/app.css" />" rel="stylesheet"/>
</head>
<body>
<div class="generic-container">
    <div class="well lead">User Registration Form</div>
    <form:form method="POST" modelAttribute="keywords" cssClass="form-horizontal">
        <form:input type="hidden" path="id" id="id"/>
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="content">关键词</label>
                <div class="col-md-7">
                    <form:input type="text" path="content" id="content" class="form-control input-sm"/>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-actions floatRight">
                <input type="submit" value="提交" class="btn btn-primary btn-sm"/>
            </div>
        </div>
    </form:form>
</div>
</body>
</html>
