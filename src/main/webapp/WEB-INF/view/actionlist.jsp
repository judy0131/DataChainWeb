<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE>
<HTML lang="zh-CN">
<HEAD>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>日志列表</title>

    <%--<link rel="stylesheet" type="text/css"  href="${ctx}/resources/bootstrap/css/ace.min.css" />--%>
    <!-- Bootstrap -->
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/bootstrap/css/bootstrap.min.css" >
    <link rel="stylesheet" type="text/css"  href="${ctx}/resources/css/extend.css" >
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/css/jquery-ui-1.10.3.custom.min.css">
    <link rel="stylesheet" type="text/css"  href="${ctx}/resources/css/font-awesome.min.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/css/jquery.dataTables.min.css"/>


    <%--<script src="${ctx}/resources/bootstrap/js/ace-extra.min.js"></script>--%>
    <script src="${ctx}/resources/bootstrap/js/jquery.min.js"></script>
    <script src="${ctx}/resources/bootstrap/js/bootstrap.min.js"></script>
    <%--<script src="${ctx}/resources/bootstrap/js/ace-elements.min.js"></script>
    <script src="${ctx}/resources/bootstrap/js/ace.min.js"></script>--%>
    <script src="${ctx}/resources/js/jquery-ui-1.10.3.custom.min.js"></script>
    <script src="${ctx}/resources/js/jquery.dataTables.min.js"></script>
    <script src="${ctx}/resources/js/jquery.dataTables.bootstrap.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="/n.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="/n.bootcss.com/respond.js/1.4.2/respond.min.js"></script>

    <![endif]-->
</HEAD>

<BODY>

<div class="row well" style="border:none;">
    <div class="col-xs-12 col-md-12 inner" >

        <form action="#" method="get" class="dx-form form-horizontal">
            <div class="form-group form-group-lg dx-form-fieldset" >
                <label class="col-sm-12 col-xs-12">日志列表</label>
            </div>

            <div class="form-group ">
                <div class="col-sm-12 col-xs-12">
                    <table id="action-table" class="table table-bordered table-hover dataTable" >
                        <thead>
                        <tr>
                            <th>日期</th>
                            <th>时间</th>
                            <th>级别</th>
                            <th>类名</th>
                            <th>行数</th>
                            <th>方法</th>
                            <th>消息</th>
                        </tr>
                        </thead>
                        <tbody>

                        </tbody>
                    </table>

                </div>
            </div>

        </form>
    </div>
</div>

</BODY>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${ctx}/resources/bootstrap/js/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script type="text/javascript" src="${ctx}/resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/pgwmodal.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/global.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/jquery.dataTables.bootstrap.js"></script>

<script type="text/javascript">

    var datatable;
    var ctx = '${ctx}';
    $(document).ready(function() {
        datatable = $('#action-table').dataTable({

            "bSort": false,   //是否启用排序功能
            "bPaginate": true,
            "bLengthChange": true,
            "bFilter": false,
            "bInfo": true,
            "bAutoWidth": false,
            "aoColumns": [
                {
                    "sDefaultContent": "",
                    "fnRender": function (obj) {
                        return obj.aData.logDate;
                    },
                    "sClass": "center",
                    "bSortable": false
                },
                {
                    "sDefaultContent": "",
                    "fnRender": function (obj) {
                        return obj.aData.logTime;
                    },
                    "sClass": "center",
                    "bSortable": false
                },
                {
                    "sDefaultContent": "",
                    "fnRender": function (obj) {
                        return obj.aData.logPriority;
                    },
                    "sClass": "center",
                    "bSortable": false
                },
                {
                    "sDefaultContent": "",
                    "fnRender": function (obj) {
                        return obj.aData.logClass;
                    },
                    "sClass": "center",
                    "bSortable": false
                },
                {
                    "sDefaultContent": "",
                    "fnRender": function (obj) {
                        return obj.aData.logLineNumber;
                    },
                    "sClass": "center",
                    "bSortable": false
                },
                {
                    "sDefaultContent": "",
                    "fnRender": function (obj) {
                        return obj.aData.logMethod;
                    },
                    "sClass": "center",
                    "bSortable": false
                },
                {
                    "sDefaultContent": "",
                    "fnRender": function (obj) {
                        return obj.aData.logMessage;
                    },
                    "sClass": "center",
                    "bSortable": false
                }

            ],
            "bSort": true,
            "bProcessing": true,
            "oLanguage": {
                "sProcessing": "正在加载中......",
                "sLengthMenu": "每页显示 _MENU_ 条记录",
                "sZeroRecords": "对不起，查询不到相关数据！",
                "sEmptyTable": "表中无数据存在！",
                "sInfo": "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录",
                "sInfoFiltered": "数据表中共为 _MAX_ 条记录",
                "sInfoEmpty": "",
                "sSearch": "搜索",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上一页",
                    "sNext": "下一页",
                    "sLast": "末页"
                }
            },
            "bProcessing": false,
            "bServerSide": true,
            "sAjaxSource": '${ctx}' + "/result/actionList",

            "fnServerData": function (sSource, aoData, fnCallback) {

                aoData = JSON.stringify(aoData);
                $.ajax({
                    "type": "get",
                    "contentType": "application/json",
                    "url": sSource + "?rand=" + Math.random(),
                    "dataType": "json",
                    "data": {"aoData": aoData},
                    "success": function (resp) {
                        fnCallback(resp);
                    }});
            }
        });

    });


    function getFormatDay(date) {
        if(!date) {
            return "";
        } else {
            var formatDate = new Date(date);
            var year = formatDate.getFullYear();
            var month = formatDate.getMonth()+1;
            var day = formatDate.getDate();

            return year + "-" + month + "-" +day ;
        }
    }
</script>
</HTML>