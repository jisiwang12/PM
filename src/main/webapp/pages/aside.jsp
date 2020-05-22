<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="${pageContext.request.contextPath}/img/F.png"
                     class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p></p>
                <security:authentication property="principal.username" var="name"></security:authentication>
                <p>${name}</p>
                <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>


            </div>


        </div>


        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
            <li class="header">菜单</li>
            <li id="admin-index"><a
                    href="${pageContext.request.contextPath}/pages/main.jsp"><i
                    class="fa fa-dashboard"></i> <span>首页</span></a></li>

            <%--学生用户--%>
            <security:authorize access="hasRole('ROLE_STUDENT')">
                <li class="treeview"><a href="${pageContext.request.contextPath}/student/findBySno?sno=${name}"> <i
                        class="fa fa-user"></i>
                    <span>个人信息维护</span> <span class="pull-right-container"> <i class=" pull-right"></i>
				</span>
                </a>
                </li>
                <li class="treeview"><a href="${pageContext.request.contextPath}/kq/findBySno?sno=${name}"> <i
                        class="fa fa-search"></i>
                    <span>查看考勤成绩</span> <span class="pull-right-container"> <i class=" pull-right"></i>
				</span>
                </a>
                </li>
                <li class="treeview"><a href="${pageContext.request.contextPath}/work/findBySno?sno=${name}"> <i
                        class="fa fa-cube"></i>
                    <span>查看课程作业成绩</span> <span class="pull-right-container"> <i
                            class="pull-right"></i>
				</span>
                </a>
                </li>
                <li class="treeview"><a href="${pageContext.request.contextPath}/score/findBySno?sno=${name}"> <i
                        class="fa fa-columns"></i>
                    <span>查看课程总成绩</span> <span class="pull-right-container"> <i class=" pull-right"></i>
				</span>
                </a>
                </li>
            </security:authorize>
            <%--学生用户 /--%>

            <%--系主任用户--%>
            <security:authorize access="hasRole('ROLE_YXZR')">
                <li class="treeview"><a href="${pageContext.request.contextPath}/yxzr/findByName?name=${name}"> <i
                        class="fa fa-user"></i>
                    <span>个人信息维护</span> <span class="pull-right-container"> <i class=" pull-right"></i>
				</span>
                </a>
                </li>
                <li class="treeview"><a href="${pageContext.request.contextPath}/student/findAll"> <i
                        class="fa fa-search"></i>
                    <span>查看学生信息</span> <span class="pull-right-container"> <i class=" pull-right"></i>
				</span>
                </a>
                </li>
                <li class="treeview"><a href="${pageContext.request.contextPath}/teacher/findAll"> <i
                        class="fa fa-cube"></i>
                    <span>查看教师信息</span> <span class="pull-right-container"> <i
                            class=" pull-right"></i>
				</span>
                </a>
                </li>
                <li class="treeview"><a href="${pageContext.request.contextPath}/course/findAll"> <i
                        class="fa fa-columns"></i>
                    <span>成绩审核</span> <span class="pull-right-container"> <i
                            class=" pull-right"></i>
				</span>
                </a>
                </li>fa fa-columns
            </security:authorize>
            <%--系主任用户 /--%>
            <%--院长用户--%>
            <security:authorize access="hasRole('ROLE_YZ')">
                <li class="treeview"><a href="${pageContext.request.contextPath}/yz/findByName?name=${name}"> <i
                        class="fa fa-user"></i>
                    <span>个人信息维护</span> <span class="pull-right-container"> <i class="pull-right"></i>
				</span>
                </a>
                </li>
                <li class="treeview"><a href="${pageContext.request.contextPath}/student/findAll"> <i
                        class="fa fa-search"></i>
                    <span>查看学生信息</span> <span class="pull-right-container"> <i class="pull-right"></i>
				</span>
                </a>
                </li>
                <li class="treeview"><a href="${pageContext.request.contextPath}/teacher/findAll"> <i
                        class="fa fa-cube"></i>
                    <span>查看教师信息</span> <span class="pull-right-container"> <i
                            class="pull-right"></i>
				</span>
                </a>
                </li>
                <li class="treeview"><a href="${pageContext.request.contextPath}/course/findAll"> <i
                        class="fa fa-columns"></i>
                    <span>成绩审核</span> <span class="pull-right-container"> <i
                            class="pull-right"></i>
				</span>
                </a>
                </li>fa fa-columns
            </security:authorize>
            <%--院长用户 /--%>
            <%--教学秘书用户--%>
            <security:authorize access="hasRole('ROLE_ADMIN')">
                <%--用户管理--%>
                <li class="treeview"><a href="#"> <i class="fa fa-user"></i>
                    <span>用户管理</span> <span class="pull-right-container"> <i class="fa fa-angle-left pull-right"></i>
				</span>
                </a>
                    <ul class="treeview-menu">
                        <li><a
                                href="${pageContext.request.contextPath}/user/findAll"> <i
                                class="fa fa-circle-o"></i> 查看用户列表
                        </a></li>
                    </ul>
                </li>
                <%--用户管理 /--%>
                <%--个人信息管理--%>
                <li class="treeview"><a href="${pageContext.request.contextPath}/yxms/findByName?name=${name}"> <i
                        class="fa fa-reorder"></i>
                    <span>个人信息管理</span> <span class="pull-right-container"> <i class=" pull-right"></i>
				</span>
                </a>
                </li>
                <%--个人信息管理 /--%>
                <%--课程管理--%>
                <li class="treeview"><a href="${pageContext.request.contextPath}/course/findAll"> <i
                        class="fa fa-check-square-o"></i>
                    <span>课程管理</span> <span class="pull-right-container"> <i class=" pull-right"></i>
				</span>
                </a>
                </li>
                <%--课程管理 /--%>
                <%--信息维护--%>
                <li class="treeview"><a href="#"> <i class="fa fa-cube"></i>
                    <span>信息维护</span> <span class="pull-right-container"> <i
                            class="fa fa-angle-left pull-right"></i>
				</span>
                </a>
                    <ul class="treeview-menu">

                        <li><a
                                href="${pageContext.request.contextPath}/student/findAll">
                            <i class="fa fa-circle-o"></i> 学生信息维护
                        </a></li>
                        <li><a
                                href="${pageContext.request.contextPath}/teacher/findAll"> <i
                                class="fa fa-circle-o"></i> 任课教师信息维护
                        </a></li>

                        <li><a
                                href="${pageContext.request.contextPath}/yxzr/findAll"> <i
                                class="fa fa-circle-o"></i> 系主任信息维护
                        </a></li>
                        <li><a
                                href="${pageContext.request.contextPath}/yz/findAll"> <i
                                class="fa fa-circle-o"></i> 院长信息维护
                        </a></li>

                    </ul>
                </li>
                <%--信息维护 /--%>
                <%--成绩审核--%>
                <li class="treeview"><a href="${pageContext.request.contextPath}/course/findAll_admin"> <i
                        class="fa fa-columns"></i>
                    <span>成绩审核</span> <span class="pull-right-container"> <i class="pull-right"></i>
				</span>
                </a>
                </li>
                <%--成绩审核 /--%>

            </security:authorize>

            <%--教学秘书用户 /--%>
            <%--教师用户--%>
            <security:authorize access="hasRole('ROLE_TEACHER')">
                <%--个人信息管理--%>
                <li class="treeview"><a href="${pageContext.request.contextPath}/teacher/findByName?name=${name}"> <i
                        class="fa  fa-child"></i>
                    <span>个人信息管理</span> <span class="pull-right-container"> <i class=" pull-right"></i>
				</span>
                </a>
                </li>
                <%--查看学生信息--%>
                <li class="treeview"><a href="${pageContext.request.contextPath}/student/findAll"> <i
                        class="fa   fa-slack"></i>
                    <span>查看学生信息</span> <span class="pull-right-container"> <i class=" pull-right"></i>
				</span>
                </a>
                </li>
                <%--查看学生信息 /--%>

                <%--个人信息管理 /--%>
                <%--课程作业成绩管理--%>
                <li class="treeview"><a href="${pageContext.request.contextPath}/work/findByName?name=${name}"> <i
                        class="fa fa-book"></i>
                    <span>课程作业成绩管理</span> <span class="pull-right-container"> <i class=" pull-right"></i>
				</span>
                </a>
                </li>
                <%--考勤成绩管理--%>
                <li class="treeview"><a href="${pageContext.request.contextPath}/kq/findByName?name=${name}"> <i
                        class="fa fa-search"></i>
                    <span>考勤成绩管理</span> <span class="pull-right-container"> <i class=" pull-right"></i>
				</span>
                </a>
                </li>
                <%--总成绩管理--%>
                <li class="treeview"><a href="${pageContext.request.contextPath}/score/findByName?name=${name}"> <i
                        class="fa fa-server"></i>
                    <span>总成绩管理</span> <span class="pull-right-container"> <i class=" pull-right"></i>
				</span>
                </a>
                </li>
                <%--成绩分析--%>
                <li class="treeview"><a href="${pageContext.request.contextPath}/cj/findByName?name=${name}"> <i
                        class="fa  fa-bar-chart-o (alias)"></i>
                    <span>成绩分析</span> <span class="pull-right-container"> <i class=" pull-right"></i>
				</span>
                </a>
                </li>
                <%--试卷分析--%>
                <li class="treeview"><a href="${pageContext.request.contextPath}/sj/findByName?name=${name}"> <i
                        class="fa fa-map-o"></i>
                    <span>试卷分析</span> <span class="pull-right-container"> <i class=" pull-right"></i>
				</span>
                </a>
                </li>
            </security:authorize>
            <%--教师用户 /--%>
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>