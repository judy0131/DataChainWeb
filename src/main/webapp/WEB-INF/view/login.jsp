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

<body id="login">

<header id="header">
  <div id="logo-group">
    <span id="logo"> <img alt="" src="${ctx}/resources/img/login-logo.png"> </span>
  </div>
		<span id="header-space">&nbsp;
			<a class="btn btn-danger" href="#">返回首页</a>
		</span>
</header>

<div id="main" role="main">
  <div class="container" id="content">
    <div class="row">
      <div class="col-lg-8 hidden-xs hidden-sm hidden-md">
        <img class="display-image"  alt="" src="${ctx}/resources/img/login-banner.png">
      </div>

      <div class="col-lg-4">
        <div class="no-padding form-pannel">
          <form action="${ctx}/doLogin" method="get">

            <div class="form-group text-field" >
              <input type="text" class="form-control" name="username" placeholder="用户名" >
              <i class="glyphicon glyphicon-user" ></i>
            </div>

            <div class="form-group text-field" >
              <input type="password" class="form-control" name="password" placeholder="密码">
              <i class="glyphicon glyphicon-lock" ></i>
            </div>

            <div class="form-group">
              <button type="submit" class="btn btn-primary btn-lg btn-block">登录</button>
            </div>

            <div class="form-group other-btns">
              <a href="${ctx}/register" style="float: left;">立即注册</a>
              <a href="#" style="float: right;">忘记密码</a>
            </div>
          </form>
        </div>
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
    $('.text-field input').mouseover(function() {
      var input = $(this);
      var i = input.parent().find('i');
      if(i){
        i.css('color','rgb(102,175,233)');
        input.css('border-color','rgb(102,175,233)');
      }
    }).mouseout(function() {
      var input = $(this);
      var i = input.parent().find('i');
      if(i){
        i.css('color','rgb(153,153,153)');
        input.css('border-color','rgb(229,229,229)');
      }
    });
  });
</script>
</HTML>
