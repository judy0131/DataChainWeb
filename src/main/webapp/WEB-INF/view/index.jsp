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
<div class="col-lg-12" style="height: 500px">
    <div class="no-padding form-pannel" align="center" style="height: 500px">
        <div class="form-group" align="center" style="width:200px;padding-top: 350px">
            <button onclick="javascript:action()" class="btn btn-primary btn-lg btn-block">生成日志</button>
        </div>

    </div>
</div>
</body>

<script src="${ctx}/resources/bootstrap/js/jquery.min.js"></script>
<script src="${ctx}/resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/pgwmodal.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/global.js"></script>
<script type="text/javascript">
    function action(){
        $.ajax({
            url:'${ctx}/doAction',
            success: function(data){
                alert("Successful!")
            },
            error: function(){
                alert("Error!");
            }
        });
    }

</script>


</html>
