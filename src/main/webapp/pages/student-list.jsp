<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>学生信息管理</title>


    <!-- Tell the browser to be responsive to screen width -->
    <meta
            content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
            name="viewport">

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/morris/morris.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/datepicker/datepicker3.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.theme.default.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/select2/select2.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.skinNice.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-slider/slider.css">
</head>

<body class="hold-transition skin-blue sidebar-mini">

<div class="wrapper">

    <!-- 页面头部 -->
    <jsp:include page="header.jsp"></jsp:include>
    <!-- 页面头部 /-->

    <!-- 导航侧栏 -->
    <jsp:include page="aside.jsp"></jsp:include>
    <!-- 导航侧栏 /-->

    <!-- 内容区域 -->
    <div class="content-wrapper">

        <!-- 内容头部 -->
        <section class="content-header">
            <h1>
                学生管理 <small>全部学生</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/pages/main.jsp"><i
                        class="fa fa-dashboard"></i> 首页</a></li>
                <li><a
                        href="${pageContext.request.contextPath}/student/findAll">学生信息管理</a></li>

                <li class="active">全部学生</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域 -->
        <section class="content"> <!-- .box-body -->
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">列表</h3>
                </div>

                <div class="box-body">
                    <security:authorize access="hasAnyRole('ROLE_ADMIN')">
                    <!-- 数据表格 -->
                    <div class="table-box">

                        <!--工具栏-->
                        <div class="">
                            <div class="form-group form-inline">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default" title="新建"
                                            onclick="location.href='${pageContext.request.contextPath}/student/page'">
                                        <i class="fa fa-file-o"></i> 新建
                                    </button>
                                    <button type="button" class="btn btn-default" data-toggle="modal"
                                            data-target="#myModal" title="删除">
                                        <i class="fa fa-file-o"></i> 删除
                                    </button>

                                    <button type="button" class="btn btn-default" title="刷新"
                                            onclick="location.href='${pageContext.request.contextPath}/student/findAll'">
                                        <i class="fa fa-refresh"></i> 刷新
                                    </button>
                                </div>
                            </div>
                        </div>

                        <!--工具栏/-->

                        <!--数据列表-->

                        <form action="${pageContext.request.contextPath}/student/del" id="form">
                            <table id="dataList"
                                   class="table table-bordered table-striped table-hover dataTable">
                                <thead>
                                <tr>
                                    <th class="" style="padding-right: 0px"><input
                                            id="selall" type="checkbox" class="icheckbox_square-blue">
                                    </th>
                                    <th class="sorting_asc">学号</th>
                                    <th class="sorting_desc">姓名</th>
                                    <th class="sorting">班级</th>
                                    <th class="text-center">性别</th>
                                    <th class="text-center">年龄</th>
                                    <th class="text-center">联系电话</th>
                                    <th class="text-center">专业</th>
                                    <th class="text-center">院系</th>
                                    <th class="text-center">操作</th>
                                </tr>
                                </thead>

                                <tbody>
                                <c:forEach items="${studentList}" var="student">
                                    <tr>

                                        <td><input name="ids" type="checkbox" value="${student.id}"></td>
                                        <td class="text-center">${student.sNo}</td>
                                        <td class="text-center">${student.sName }</td>
                                        <td class="text-center">${student.classn.cname }</td>
                                        <td class="text-center">${student.sSex }</td>
                                        <td class="text-center">${student.age }</td>
                                        <td class="text-center">${student.phone}</td>
                                        <td class="text-center">${student.zy.zyname}</td>
                                        <td class="text-center">${student.yx.yxname}</td>
                                        <td class="text-center">
                                            <a href="${pageContext.request.contextPath}/student/findById/?id=${student.id}"
                                               class="btn bg-olive btn-xs">修改</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            </security:authorize>
                            <%--学生界面--%>
                            <security:authorize access="hasRole('ROLE_STUDENT')">
                            <form>
                                <table
                                        class="table table-bordered table-striped table-hover dataTable">
                                    <thead>
                                    <tr>
                                        <th class="text-center">学号</th>
                                        <th class="text-center">姓名</th>
                                        <th class="text-center">班级</th>
                                        <th class="text-center">性别</th>
                                        <th class="text-center">年龄</th>
                                        <th class="text-center">联系电话</th>
                                        <th class="text-center">专业</th>
                                        <th class="text-center">院系</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td class="text-center">${student.sNo}</td>
                                        <td class="text-center">${student.sName }</td>
                                        <td class="text-center">${student.classn.cname }</td>
                                        <td class="text-center">${student.sSex }</td>
                                        <td class="text-center">${student.age }</td>
                                        <td class="text-center">${student.phone}</td>
                                        <td class="text-center">${student.zy.zyname}</td>
                                        <td class="text-center">${student.yx.yxname}</td>
                                        <td class="text-center">
                                            <a href="${pageContext.request.contextPath}/student/findById/?id=${student.id}"
                                               class="btn bg-olive btn-xs">修改</a>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>

                            </form>
                            </security:authorize>
                            <%--学生界面 /--%>
                            <%--教师界面--%>
                            <security:authorize access="hasAnyRole('ROLE_TEACHER,ROLE_YXZR,ROLE_YZ')">
                            <form action="${pageContext.request.contextPath}/student/del" id="form">
                                <table id="dataList"
                                       class="table table-bordered table-striped table-hover dataTable">
                                    <thead>
                                    <tr>
                                        <th class="text-center">学号</th>
                                        <th class="text-center">姓名</th>
                                        <th class="text-center">班级</th>
                                        <th class="text-center">性别</th>
                                        <th class="text-center">年龄</th>
                                        <th class="text-center">联系电话</th>
                                        <th class="text-center">专业</th>
                                        <th class="text-center">院系</th>

                                    </tr>
                                    </thead>

                                    <tbody>
                                    <c:forEach items="${studentList}" var="student">
                                        <tr>


                                            <td class="text-center">${student.sNo}</td>
                                            <td class="text-center">${student.sName }</td>
                                            <td class="text-center">${student.classn.cname }</td>
                                            <td class="text-center">${student.sSex }</td>
                                            <td class="text-center">${student.age }</td>
                                            <td class="text-center">${student.phone}</td>
                                            <td class="text-center">${student.zy.zyname}</td>
                                            <td class="text-center">${student.yx.yxname}</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                                </security:authorize>
                                <%--教师界面 /--%>

                                <!--数据列表/-->

                    </div>
                    <!-- 数据表格 /-->

                </div>

                <!-- 模态框（Modal） -->
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                    &times;
                                </button>
                                <h4 class="modal-title" id="myModalLabel">
                                    删除学生
                                </h4>
                            </div>
                            <div class="modal-body">
                                确定要删除吗？
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">取消
                                </button>
                                <button type="button" id="delete" class="btn btn-primary">
                                    确定
                                </button>
                            </div>
                        </div><!-- /.modal-content -->
                    </div><!-- /.modal -->
                </div>
                <!-- 模态框（Modal） /-->
                <!-- /.box-body -->

                <!-- .box-footer-->
                <!-- .box-footer-->
                <%-- <security:authorize access="hasRole('ROLE_ADMIN')">
                 <div class="box-footer">
                     <div class="pull-left">
                         <div class="form-group form-inline">
                             总共${pageInfo.pages}页，共${pageInfo.total} 条数据。 每页
                             <select class="form-control" id="changePageSize" onchange="changePageSize()">
                                 <c:forEach begin="1" end="5" varStatus="status">
                                     <c:if test="${status.count==pageInfo.pageSize}">
                                         <option selected>${status.count}</option>

                                     </c:if>
                                     <c:if test="${status.count!=pageInfo.pageSize}">
                                         <option>${status.count}</option>
                                     </c:if>

                                 </c:forEach>
                             </select> 条
                         </div>
                     </div>

                     <div class="box-tools pull-right">
                         <ul class="pagination">

                             <li>
                                 <a href="${pageContext.request.contextPath}/student/findAll?page=${pageInfo.firstPage}&pageSize=${pageInfo.pageSize}" aria-label="Previous">首页</a>
                             </li>
                             <li><a href="${pageContext.request.contextPath}/student/findAll?page=${pageInfo.pageNum-1}&pageSize=${pageInfo.pageSize}">上一页</a></li>
                             <c:forEach begin="1" end="${pageInfo.pages}" varStatus="status"  >
                                 <c:if test="${pageInfo.pageNum==status.count}">
                                     <li ><a style="background-color: #8ca4ff" href="${pageContext.request.contextPath}/student/findAll">${status.count}</a></li>

                                 </c:if>
                                 <c:if test="${pageInfo.pageNum!=status.count}">
                                     <li class="lis"><a href="${pageContext.request.contextPath}/student/findAll?page=${status.count}&pageSize=${pageInfo.pageSize}">${status.count}</a></li>
                                 </c:if>
                             </c:forEach>
                             <li><a href="${pageContext.request.contextPath}/student/findAll?page=${pageInfo.pageNum+1}&pageSize=${pageInfo.pageSize}">下一页</a></li>
                             <li>
                                 <a href="${pageContext.request.contextPath}/student/findAll?page=${pageInfo.lastPage}&pageSize=${pageInfo.pageSize}" aria-label="Next">尾页</a>
                             </li>
                         </ul>
                     </div>

                 </div>

                 </security:authorize>
                 <!-- /.box-footer-->
 --%>


            </div>
            <!-- /.box-footer-->


        </section>
        <!-- 正文区域 /-->

    </div>
    <!-- @@close -->
    <!-- 内容区域 /-->


</div>

<script src="../plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="../plugins/jQueryUI/jquery-ui.min.js"></script>
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<script src="../plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="../plugins/raphael/raphael-min.js"></script>
<script src="../plugins/morris/morris.min.js"></script>
<script src="../plugins/sparkline/jquery.sparkline.min.js"></script>
<script src="../plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="../plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script src="../plugins/knob/jquery.knob.js"></script>
<script src="../plugins/daterangepicker/moment.min.js"></script>
<script src="../plugins/daterangepicker/daterangepicker.js"></script>
<script src="../plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
<script src="../plugins/datepicker/bootstrap-datepicker.js"></script>
<script
        src="../plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
<script
        src="../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script src="../plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="../plugins/fastclick/fastclick.js"></script>
<script src="../plugins/iCheck/icheck.min.js"></script>
<script src="../plugins/adminLTE/js/app.min.js"></script>
<script src="../plugins/treeTable/jquery.treetable.js"></script>
<script src="../plugins/select2/select2.full.min.js"></script>
<script src="../plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<script
        src="../plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
<script src="../plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
<script
        src="../plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
<script src="../plugins/bootstrap-markdown/js/markdown.js"></script>
<script src="../plugins/bootstrap-markdown/js/to-markdown.js"></script>
<script src="../plugins/ckeditor/ckeditor.js"></script>
<script src="../plugins/input-mask/jquery.inputmask.js"></script>
<script
        src="../plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script src="../plugins/input-mask/jquery.inputmask.extensions.js"></script>
<script src="../plugins/datatables/jquery.dataTables.min.js"></script>
<script src="../plugins/datatables/dataTables.bootstrap.min.js"></script>
<script src="../plugins/chartjs/Chart.min.js"></script>
<script src="../plugins/flot/jquery.flot.min.js"></script>
<script src="../plugins/flot/jquery.flot.resize.min.js"></script>
<script src="../plugins/flot/jquery.flot.pie.min.js"></script>
<script src="../plugins/flot/jquery.flot.categories.min.js"></script>
<script src="../plugins/ionslider/ion.rangeSlider.min.js"></script>
<script src="../plugins/bootstrap-slider/bootstrap-slider.js"></script>
<script>

    $(document).ready(function () {

        // 选择框
        $(".select2").select2();
        deleteById();
        // WYSIHTML5编辑器
        $(".textarea").wysihtml5({
            locale: 'zh-CN'
        });

        $(function () {
            $('#dataList').DataTable({
                "pagingType": "full_numbers",

                "language": {
                    //"info": "当前第_PAGE_页，共 _PAGES_页",
                    "sInfo": "当前显示第 _START_ 到第 _END_ 条，共 _TOTAL_ 条",
                    "sInfoFiltered": "(从_MAX_条筛选 )",
                    "sInfoEmpty": "共筛选到0条",
                    "sSearch": "搜索:",
                    "sLengthMenu": "每页显示 _MENU_ 条",
                    "sZeroRecords": "未筛选到相关内容",
                    "paginate": {
                        "sFirst": "首页",  //首页和尾页必须在pagingType设为full_numbers时才可以
                        "sLast": "尾页",
                        "sPrevious": "上一页",
                        "sNext": "下一页",
                        "first": "First page",
                        "last": "Last page",
                        "next": "Next page",
                        "previous": "Previous page"
                    }

                }

            });
        });

    });

    //删除操作
    function deleteById() {
        $("#delete").click(function () {
            $("#form").submit();

        });
    };

    // 设置激活菜单
    function setSidebarActive(tagUri) {
        var liObj = $("#" + tagUri);
        if (liObj.length > 0) {
            liObj.parent().parent().addClass("active");
            liObj.addClass("active");
        }
    }

    $(document)
        .ready(
            function () {

                // 激活导航位置
                setSidebarActive("admin-datalist");

                // 列表按钮
                $("#dataList td input[type='checkbox']")
                    .iCheck(
                        {
                            checkboxClass: 'icheckbox_square-blue',
                            increaseArea: '20%'
                        });
                // 全选操作
                $("#selall")
                    .click(
                        function () {
                            var clicks = $(this).is(
                                ':checked');
                            if (!clicks) {
                                $(
                                    "#dataList td input[type='checkbox']")
                                    .iCheck(
                                        "uncheck");
                            } else {
                                $(
                                    "#dataList td input[type='checkbox']")
                                    .iCheck("check");
                            }
                            $(this).data("clicks",
                                !clicks);
                        });
            });
</script>
</body>

</html>