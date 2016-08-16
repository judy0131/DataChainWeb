<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE>
<html lang="zh-CN">
<HEAD>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Login</title>

    <!-- Bootstrap -->
    <link href="${ctx}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/resources/css/extend.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="/n.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="/n.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</HEAD>
<body>
<%--<h2>User Action!</h2>--%>
<div class="col-lg-3" >
    <div class="no-padding form-pannel" style="padding-top: 250px; padding-left: 250px">
        <form action="${ctx}/doAction" method="get">

            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-lg btn-block">点击</button>
            </div>

            <div style="float:left;padding-top: 25px;width: 80%">
                ${status}
            </div>

        </form>
    </div>
</div>
</body>


</html>
