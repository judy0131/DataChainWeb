<%--
  Created by IntelliJ IDEA.
  User: Qiu
  Date: 2015/11/5
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
  <title></title>
  <!-- Bootstrap -->
  <%--<link href="${ctx}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">--%>
  <link href="${ctx}/resources/css/extend.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-default"  role="navigation" >
  <div class="container-fluid" style="background-color: rgb(227, 232, 247);">
    <div class="row" style="margin-right:-15px;margin-left:-15px">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#dx-navbar-main-collapse" aria-expanded="false">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#" class="padding:0; margin:0;">
          <img src="${ctx}/resources/img/logo.png" style="margin-top:-15px;" height="50">
        </a>
      </div>
      <div class="collapse navbar-collapse" id="dx-navbar-main-collapse">
        <ul class="nav navbar-nav">
          <li class="active gl-font"><a href="${ctx}/index">总览<span class="sr-only">(current)</span></a></li>
          <li class="dropdown ">
            <a href="#" class="dropdown-toggle gl-font" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">产品服务<span class="caret"></span></a>
            <div class="dropdown-menu dx-nav-menu-dropdown dx-nav-menu-dropdown-gl" >
              <div class="row">
                <div class="col-md-4">
                  <ul class="list-group">
                    <li class="list-group-item">计算服务</li>
                    <li class="list-group-item"><a href="#"><span class="glyphicon glyphicon-cloud" aria-hidden="true"></span>云服务器</a></li>
                  </ul>
                </div>
                <div class="col-md-4">
                  <ul class="list-group">
                    <li class="list-group-item">存储服务</li>
                    <li class="list-group-item"><a href="#"><span class="glyphicon glyphicon-hdd" aria-hidden="true"></span>对象存储</a></li>
                    <li class="list-group-item"><a href="#"><span class="glyphicon glyphicon-hdd" aria-hidden="true"></span>块存储</a></li>
                  </ul>
                </div>
                <div class="col-md-4">
                  <ul class="list-group">
                    <li class="list-group-item">数据库服务</li>
                    <li class="list-group-item"><a href="#"><span class="glyphicon glyphicon-record" aria-hidden="true"></span>关系型数据库</a></li>
                    <li class="list-group-item"><a href="#"><span class="glyphicon glyphicon-record" aria-hidden="true"></span>非关系型数据库</a></li>
                  </ul>
                </div>
                <div class="col-md-4">
                  <ul class="list-group">
                    <li class="list-group-item">监控服务</li>
                    <li class="list-group-item"><a href="#"><span class="glyphicon glyphicon-dashboard" aria-hidden="true"></span>云监控</a></li>
                  </ul>
                </div>
              </div>
            </div>
          </li>

          <li class="dropdown">
            <a href="#" class="dropdown-toggle gl-font" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">文档与工具<span class="caret"></span></a>
            <div class="dropdown-menu dx-nav-menu-dropdown" >
              <div class="row" >
                <div class="col-md-6">
                  <ul class="list-group">
                    <li class="list-group-item">文档</li>
                    <li class="list-group-item"><a href="#"><span class="glyphicon glyphicon-book" aria-hidden="true"></span>产品文档</a></li>
                  </ul>
                </div>
                <div class="col-md-6">
                  <ul class="list-group">
                    <li class="list-group-item">产品</li>
                    <li class="list-group-item"><a href="#"><span class="glyphicon glyphicon-cog" aria-hidden="true"></span>SDK工具</a></li>
                  </ul>
                </div>
              </div>
            </div>
          </li>
        </ul>
        <!-- glyphicon-map-marker -->
        <ul class="nav navbar-nav navbar-right">

          <li class="dropdown" style="border-left:1px solid white;">
            <a href="#" class="dropdown-toggle sm-font" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
              <span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span>&nbsp;全局<span class="caret"></span>
            </a>
            <ul class="dropdown-menu" style="border-left:1px solid white;">
              <li><a href="#">Action</a></li>
              <li><a href="#">Another action</a></li>
              <li><a href="#">Something else here</a></li>
              <li role="separator" class="divider"></li>
              <li><a href="#">退出</a></li>
            </ul>
          </li>
          <li class="dropdown" style="border-left:1px solid white;">
            <a href="#" class="dropdown-toggle sm-font" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">jiaoming42<span class="caret"></span></a>
            <ul class="dropdown-menu">
              <li><a href="#">Action</a></li>
              <li><a href="#">Another action</a></li>
              <li><a href="#">Something else here</a></li>
              <li role="separator" class="divider"></li>
              <li><a href="#">退出</a></li>
            </ul>
          </li>
          <li class="dropdown" style="border-left:1px solid white;">
            <a href="#" class="dropdown-toggle sm-font" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">工单<span class="caret"></span></a>
            <ul class="dropdown-menu">
              <li><a href="#">我的工单</a></li>
              <li role="separator" class="divider"></li>
              <li><a href="#">Action</a></li>
              <li><a href="#">Another action</a></li>
            </ul>
          </li>
          <li class="sm-font" style="border-left:1px solid white;"><a href="#">站内信<span class="badge" style="background:#d44950;">2</span></a></li>

        </ul>

        <form class="navbar-form navbar-right" role="search">
          <div id="search_for">
            <input type="text" class="form-control" style="display: none;" placeholder="Search for..." >
            <i class="glyphicon glyphicon-search" ></i>
          </div>
        </form>
      </div><!-- /.navbar-collapse -->
    </div>
  </div>
</nav>
</body>
</html>
