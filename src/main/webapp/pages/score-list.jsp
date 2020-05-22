<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>

<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">


    <title>课程总成绩</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta
            content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
            name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <!-- Font Awesome -->
    <!-- Ionicons -->
    <!-- iCheck -->
    <!-- Morris chart -->
    <!-- jvectormap -->
    <!-- Date Picker -->
    <!-- Daterange picker -->
    <!-- Bootstrap time Picker -->
    <!--<link rel="stylesheet" href="${pageContext.request.contextPath}/${pageContext.request.contextPath}/${pageContext.request.contextPath}/plugins/timepicker/bootstrap-timepicker.min.css">-->
    <!-- bootstrap wysihtml5 - text editor -->
    <!--数据表格-->
    <!-- 表格树 -->
    <!-- select2 -->
    <!-- Bootstrap Color Picker -->
    <!-- bootstrap wysihtml5 - text editor -->
    <!--bootstrap-markdown-->
    <!-- Theme style -->
    <!-- AdminLTE Skins. Choose a skin from the css/skins
           folder instead of downloading all of them to reduce the load. -->
    <!-- Ion Slider -->
    <!-- ion slider Nice -->
    <!-- bootstrap slider -->
    <!-- bootstrap-datetimepicker -->

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->


    <!-- jQuery 2.2.3 -->
    <!-- jQuery UI 1.11.4 -->
    <!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
    <!-- Bootstrap 3.3.6 -->
    <!-- Morris.js charts -->
    <!-- Sparkline -->
    <!-- jvectormap -->
    <!-- jQuery Knob Chart -->
    <!-- daterangepicker -->
    <!-- datepicker -->
    <!-- Bootstrap WYSIHTML5 -->
    <!-- Slimscroll -->
    <!-- FastClick -->
    <!-- iCheck -->
    <!-- AdminLTE App -->
    <!-- 表格树 -->
    <!-- select2 -->
    <!-- bootstrap color picker -->
    <!-- bootstrap time picker -->
    <!--<script src="${pageContext.request.contextPath}/${pageContext.request.contextPath}/${pageContext.request.contextPath}/plugins/timepicker/bootstrap-timepicker.min.js"></script>-->
    <!-- Bootstrap WYSIHTML5 -->
    <!--bootstrap-markdown-->
    <!-- CK Editor -->
    <!-- InputMask -->
    <!-- DataTables -->
    <!-- ChartJS 1.0.1 -->
    <!-- FLOT CHARTS -->
    <!-- FLOT RESIZE PLUGIN - allows the chart to redraw when the window is resized -->
    <!-- FLOT PIE PLUGIN - also used to draw donut charts -->
    <!-- FLOT CATEGORIES PLUGIN - Used to draw bar charts -->
    <!-- jQuery Knob -->
    <!-- Sparkline -->
    <!-- Morris.js charts -->
    <!-- Ion Slider -->
    <!-- Bootstrap slider -->
    <!-- bootstrap-datetimepicker -->
    <!-- 页面meta /-->

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
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">
</head>

<body class="hold-transition skin-purple sidebar-mini">

<div class="wrapper">

    <!-- 页面头部 -->
    <jsp:include page="header.jsp"></jsp:include>
    <!-- 页面头部 /-->
    <!-- 导航侧栏 -->
    <jsp:include page="aside.jsp"></jsp:include>
    <!-- 导航侧栏 /-->

    <!-- 内容区域 -->
    <!-- @@master = admin-layout.html-->
    <!-- @@block = content -->

    <div class="content-wrapper">

        <!-- 内容头部 -->
        <section class="content-header">
            <h1>
                课程总成绩 <small>成绩列表</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <security:authorize access="hasRole('ROLE_STUDENT')">
                    <li>
                        <a href="${pageContext.request.contextPath}/score/findBySno?sno=t${scoreList.get(0).sno}">课程总成绩</a>
                    </li>
                </security:authorize>
                <li class="active">成绩列表</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域 -->
        <section class="content">

            <!-- .box-body -->
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">列表</h3>
                </div>

                <div class="box-body">

                    <!-- 数据表格 -->
                    <div class="table-box">

                        <!--工具栏-->
                        <div class="">
                            <div class="form-group form-inline">
                                <div class="btn-group">
                                    <security:authorize access="hasRole('ROLE_STUDENT')">
                                        <button type="button" id="sx" class="btn btn-default" title="刷新"
                                                onclick="location.href='${pageContext.request.contextPath}/score/findBySno?sno=t${scoreList.get(0).sno}'">
                                            <i class="fa fa-refresh"></i> 刷新
                                        </button>
                                    </security:authorize>
                                    <security:authorize access="hasRole('ROLE_TEACHER')">
                                        <button type="button" id="sx" class="btn btn-default" title="刷新"
                                                onclick="location.href='${pageContext.request.contextPath}/score/findByCono?id=${scoreList.get(0).cono}'">
                                            <i class="fa fa-refresh"></i> 刷新
                                        </button>
                                    </security:authorize>
                                </div>
                            </div>
                        </div>
                        <%--<div class="box-tools pull-right">
                            <div class="has-feedback">
                                <input type="text" class="form-control input-sm"
                                    placeholder="搜索"> <span
                                    class="glyphicon glyphicon-search form-control-feedback"></span>
                            </div>
                        </div>--%>
                        <security:authorize access="hasRole('ROLE_STUDENT')">
                            <div class="">
                                <b>按学期查询:</b>
                                <select class="form-control select2 " style="width: 220px" id="changeTime"
                                        onchange="changeTime()">
                                    <option style='display: none'></option>
                                    <c:forEach items="${timeList}" var="time">
                                        <option value="${time}">${time}</option>
                                    </c:forEach>
                                </select>
                            </div>

                            <!--工具栏/-->

                            <!--数据列表-->
                            <table id="dataList"
                                   class="table table-bordered table-striped table-hover dataTable">
                                <thead>
                                <tr>
                                    <th class="text-center">课程</th>
                                    <th class="text-center">学分</th>
                                    <th class="text-center">任课教师</th>
                                    <th class="text-center">开课学期</th>
                                    <th class="text-center">考勤分数</th>
                                    <th class="text-center ">作业分数</th>
                                    <th class="text-center ">卷面分数</th>
                                    <th class="text-center">课程总成绩分数</th>

                                </tr>
                                </thead>
                                <tbody>


                                <c:forEach items="${scoreList}" var="all">
                                    <tr>
                                        <td class="text-center">${all.course.coname}</td>
                                        <td class="text-center">${all.course.xf}</td>
                                        <td class="text-center">${all.course.teacher.name}</td>
                                        <td class="text-center">${all.course.time}</td>
                                        <td class="text-center">${all.kq}</td>
                                        <td class="text-center">${all.work}</td>
                                        <td class="text-center">${all.sj}</td>
                                        <td class="text-center">${all.score}</td>

                                    </tr>
                                </c:forEach>
                                </tbody>
                                <!--
                            <tfoot>
                            <tr>
                            <th>Rendering engine</th>
                            <th>Browser</th>
                            <th>Platform(s)</th>
                            <th>Engine version</th>
                            <th>CSS grade</th>
                            </tr>
                            </tfoot>-->
                            </table>
                            <!--数据列表/-->
                        </security:authorize>

                        <security:authorize access="hasRole('ROLE_TEACHER')">
                            <!--工具栏/-->

                            <!--数据列表-->
                            <table id="dataList"
                                   class="table table-bordered table-striped table-hover dataTable">
                                <thead>
                                <tr>
                                    <th class="text-center">学号</th>
                                    <th class="text-center">姓名</th>
                                    <th class="text-center">班级</th>
                                    <th class="text-center">专业</th>
                                    <th class="text-center">学院</th>
                                    <th class="text-center">考勤分数</th>
                                    <th class="text-center ">作业分数</th>
                                    <th class="text-center ">卷面分数</th>
                                    <th class="text-center">课程总成绩分数</th>
                                    <c:if test="${scoreList.get(0).course.status==0}">
                                        <th class="text-center">操作</th>
                                    </c:if>
                                </tr>
                                </thead>
                                <tbody>


                                <c:forEach items="${scoreList}" var="all">

                                    <tr>
                                        <td class="text-center">${all.sno}</td>
                                        <td class="text-center">${all.student.sName}</td>
                                        <td class="text-center">${all.student.classn.cname}</td>
                                        <td class="text-center">${all.student.zy.zyname}</td>
                                        <td class="text-center">${all.student.yx.yxname}</td>
                                        <td class="text-center">${all.kq}</td>
                                        <td class="text-center">${all.work}</td>
                                        <c:if test="${all.sj!=0}">
                                            <td class="text-center">${all.sj}</td>
                                        </c:if>
                                        <c:if test="${all.sj==0}">
                                            <td class="text-center">未录入</td>
                                        </c:if>
                                        <c:if test="${all.score==0}">
                                            <td class="text-center">未录入</td>
                                        </c:if>
                                        <c:if test="${all.score==-1}">
                                            <td class="text-center">无考试资格</td>
                                        </c:if>
                                        <c:if test="${all.score!=0&&all.score!=-1}">
                                            <td class="text-center">${all.score}</td>
                                        </c:if>
                                        <c:if test="${scoreList.get(0).course.status==0}">
                                        <td class="text-center">
                                            <c:if test="${all.score==-1}">
                                                <a href="#" disabled
                                                   class="btn bg-red btn-xs">不可录入</a>
                                            </c:if>
                                            <c:if test="${all.score!=-1}">
                                                <a href="${pageContext.request.contextPath}/score/findById/?id=${all.id}"
                                                   class="btn bg-olive btn-xs">录入成绩</a>
                                            </c:if>
                                        </td>
                                        </c:if>
                                    </tr>
                                </c:forEach>
                                </tbody>

                            </table>
                            <!--数据列表/-->
                        </security:authorize>

                        <security:authorize access="hasAnyRole('ROLE_YXZR,ROLE_YZ,ROLE_ADMIN')">
                            <!--工具栏/-->

                            <!--数据列表-->
                            <table id="dataList"
                                   class="table table-bordered table-striped table-hover dataTable">
                                <thead>
                                <tr>
                                    <th class="text-center">学号</th>
                                    <th class="text-center">姓名</th>
                                    <th class="text-center">班级</th>
                                    <th class="text-center">专业</th>
                                    <th class="text-center">学院</th>
                                    <th class="text-center">考勤分数</th>
                                    <th class="text-center ">作业分数</th>
                                    <th class="text-center ">卷面分数</th>
                                    <th class="text-center">课程总成绩分数</th>
                                </tr>
                                </thead>
                                <tbody>


                                <c:forEach items="${scoreList}" var="all">

                                    <tr>
                                        <td class="text-center">${all.sno}</td>
                                        <td class="text-center">${all.student.sName}</td>
                                        <td class="text-center">${all.student.classn.cname}</td>
                                        <td class="text-center">${all.student.zy.zyname}</td>
                                        <td class="text-center">${all.student.yx.yxname}</td>
                                        <td class="text-center">${all.kq}</td>
                                        <td class="text-center">${all.work}</td>
                                        <c:if test="${all.sj!=0}">
                                            <td class="text-center">${all.sj}</td>
                                        </c:if>
                                        <c:if test="${all.sj==0}">
                                            <td class="text-center">未录入</td>
                                        </c:if>
                                        <c:if test="${all.score==0}">
                                            <td class="text-center">未录入</td>
                                        </c:if>
                                        <c:if test="${all.score==-1}">
                                            <td class="text-center">无考试资格</td>
                                        </c:if>
                                        <c:if test="${all.score!=0&&all.score!=-1}">
                                            <td class="text-center">${all.score}</td>
                                        </c:if>

                                    </tr>
                                </c:forEach>
                                </tbody>
                                <!--
                            <tfoot>
                            <tr>
                            <th>Rendering engine</th>
                            <th>Browser</th>
                            <th>Platform(s)</th>
                            <th>Engine version</th>
                            <th>CSS grade</th>
                            </tr>
                            </tfoot>-->
                            </table>
                            <!--数据列表/-->
                        </security:authorize>


                    </div>
                    <!-- 数据表格 /-->


                </div>

            </div>
            <!-- /.box-footer-->


        </section>
        <!-- 正文区域 /-->

    </div>
    <!-- @@close -->
    <!-- 内容区域 /-->


</div>


<script
        src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/jQueryUI/jquery-ui.min.js"></script>
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/raphael/raphael-min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/morris/morris.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/sparkline/jquery.sparkline.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/knob/jquery.knob.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/daterangepicker/moment.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/datepicker/bootstrap-datepicker.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/fastclick/fastclick.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/adminLTE/js/app.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/select2/select2.full.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/markdown.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/to-markdown.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/ckeditor/ckeditor.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.extensions.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/datatables/jquery.dataTables.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/chartjs/Chart.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.resize.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.pie.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.categories.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-slider/bootstrap-slider.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<script>
    function changeTime() {
        var time = $("#changeTime").val();
        location.href = "${pageContext.request.contextPath}/score/findByTime?sno=${scoreList.get(0).sno}&time=" + time;
    }

    $(document).ready(function () {
        // 选择框
        $(".select2").select2();

        $("sx").click(function () {
            location.href = "${pageContext.request.contextPath}/score/findAll";
        });

        // WYSIHTML5编辑器
        $(".textarea").wysihtml5({
            locale: 'zh-CN'
        });
    });

    // 设置激活菜单
    function setSidebarActive(tagUri) {
        var liObj = $("#" + tagUri);
        if (liObj.length > 0) {
            liObj.parent().parent().addClass("active");
            liObj.addClass("active");
        }
    }

    $(document).ready(function () {


        <security:authorize access="hasRole('ROLE_STUDENT')">
        $(function () {
            $('#dataList').DataTable({
                "paging": false,
                "lengthChange": false,
                "searching": true,
                "ordering": true,
                "info": false,
                "autoWidth": false
            });
        });
        </security:authorize>

        <security:authorize access="hasAnyRole('ROLE_TEACHER,ROLE_YZ,ROLE_YXZR,ROLE_ADMIN')">
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
        </security:authorize>


        // 激活导航位置
        setSidebarActive("admin-datalist");

        // 列表按钮 
        $("#dataList td input[type='checkbox']").iCheck({
            checkboxClass: 'icheckbox_square-blue',
            increaseArea: '20%'
        });
        // 全选操作 
        $("#selall").click(function () {
            var clicks = $(this).is(':checked');
            if (!clicks) {
                $("#dataList td input[type='checkbox']").iCheck("uncheck");
            } else {
                $("#dataList td input[type='checkbox']").iCheck("check");
            }
            $(this).data("clicks", !clicks);
        });
    });
</script>
</body>

</html>