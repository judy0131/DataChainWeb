<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE>
<HTML lang="zh-CN">
<HEAD>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
  <title>Register</title>

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

<body id="login">

<header id="header">
  <div id="logo-group">
    <span id="logo"> <img alt="" src="${ctx}/resources/img/login-logo.png"> </span>
  </div>
		<span id="header-space">&nbsp;
			<a class="btn btn-danger" href="login.html">我已有账号</a>
		</span>
</header>

<div id="main" role="main">
  <div class="container" id="content">

    <div class="row">

      <div class="col-lg-4">
        <div class="no-padding form-pannel">
          <form action="${ctx}/doRegister" method="post" >

            <div class="form-group " >
              <label for="username">用户名：</label>
              <input type="text" class="form-control" name="username" placeholder="用户名" id="username" style="padding-left:12px;" data-toggle="popover" data-trigger="focus" data-placement="top" data-content="请输入合法用户名">
            </div>

            <div class="form-group" >
              <label for="password">密码：</label>
              <input type="password" class="form-control" name="password" placeholder="密码" id="password" style="padding-left:12px;" data-toggle="popover" data-trigger="focus" data-placement="top" data-content="长度为6~14个字符，支持数字，大小写字母和标点符号，不允许有空格">
            </div>

            <div class="form-group">
              <label for="email">邮箱：</label>
              <input type="text" class="form-control" name="email" placeholder="邮箱" id="email" style="padding-left:12px;" data-toggle="popover" data-trigger="focus" data-placement="top" data-content="请输入常用邮箱，可用于找回密码">
            </div>

            <div class="form-group" >
              <input type="checkbox" style="display: inline-block; vertical-align:middle; margin-right: 2px; padding: 0;" id="account_allowed">
              <label style="font-size: 12px; font-weight: 400; " for="account_allowed">阅读并接受<a href="#">《用户协议》</a></label>
            </div>

            <div class="form-group">
              <button class="btn btn-primary btn-lg btn-block" role="button">注册</button>
            </div>

          </form>
        </div>
      </div>

      <div class="col-lg-8 hidden-xs hidden-sm hidden-md">
        <img class="display-image"  alt="" src="${ctx}/resources/img/login-banner.png">
      </div>

    </div>

  </div>
</div>

<jsp:include page="foot.jsp"></jsp:include>
</body>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${ctx}/resources/bootstrap/js/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="${ctx}/resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
  $(document).ready(function() {
    $(function () {
      $('[data-toggle="popover"]').popover()
    });

  });
</script>
</HTML>
