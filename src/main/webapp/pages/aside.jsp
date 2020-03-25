<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
				<p href="#">${user.uName}</p>
				<security:authentication property="principal.username"></security:authentication>
				<a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
			</div>



		</div>


		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="header">菜单</li>
			<li id="admin-index"><a
				href="${pageContext.request.contextPath}/pages/main.jsp"><i
					class="fa fa-dashboard"></i> <span>首页</span></a></li>


<%--用户管理--%>
			<li class="treeview"><a href="#"> <i class="fa fa-user"></i>
					<span>用户管理</span> <span class="pull-right-container"> <i class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">
					<li><a
						href="${pageContext.request.contextPath}/user/findAll"> <i
							class="fa fa-circle-o"></i> 用户管理
					</a></li>
					<li><a
						href="${pageContext.request.contextPath}/role/findAll"> <i
							class="fa fa-circle-o"></i> 角色管理
					</a></li>
					<li><a
						href="${pageContext.request.contextPath}/permission/findAll">
							<i class="fa fa-circle-o"></i> 资源权限管理
					</a></li>
					<li><a
						href="${pageContext.request.contextPath}/sysLog/findAll"> <i
							class="fa fa-circle-o"></i> 访问日志
					</a></li>
				</ul></li>
<%--课程作业成绩管理--%>
			<li class="treeview"><a href="#"> <i class="fa fa-cube"></i>
					<span>课程作业成绩管理</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">

					<li><a
						href="${pageContext.request.contextPath}/product/findAll">
							<i class="fa fa-circle-o"></i> 产品管理
					</a></li>
					<li><a
						href="${pageContext.request.contextPath}/orders/findAll?page=1&pageSize=3"> <i
							class="fa fa-circle-o"></i> 订单管理
					</a></li>

				</ul></li>
<%--考勤成绩管理--%>
			<li class="treeview"><a href="#"> <i class="fa fa-search"></i>
				<span>考勤成绩管理</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">
					<li><a
							href="${pageContext.request.contextPath}/kq/findAll">
						<i class="fa fa-circle-o"></i> 成绩管理
					</a></li>
				</ul></li>

<%--总成绩管理--%>
			<li class="treeview"><a href="#"> <i class="fa fa-columns"></i>
				<span>总成绩管理</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">

					<li><a
							href="${pageContext.request.contextPath}/product/findAll">
						<i class="fa fa-circle-o"></i> 产品管理
					</a></li>
					<li><a
							href="${pageContext.request.contextPath}/orders/findAll?page=1&pageSize=3"> <i
							class="fa fa-circle-o"></i> 订单管理
					</a></li>

				</ul></li>

<%--成绩分析--%>
			<li class="treeview"><a href="#"> <i class="fa fa-bar-chart"></i>
				<span>成绩分析</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">

					<li><a
							href="${pageContext.request.contextPath}/product/findAll">
						<i class="fa fa-circle-o"></i> 产品管理
					</a></li>
					<li><a
							href="${pageContext.request.contextPath}/orders/findAll?page=1&pageSize=3"> <i
							class="fa fa-circle-o"></i> 订单管理
					</a></li>
				</ul></li>

<%--试卷分析--%>
			<li class="treeview"><a href="#"> <i class="fa  fa-book"></i>
				<span>试卷分析</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">

					<li><a
							href="${pageContext.request.contextPath}/product/findAll">
						<i class="fa fa-circle-o"></i> 产品管理
					</a></li>
					<li><a
							href="${pageContext.request.contextPath}/orders/findAll?page=1&pageSize=3"> <i
							class="fa fa-circle-o"></i> 订单管理
					</a></li>

				</ul></li>

		</ul>
	</section>
	<!-- /.sidebar -->
</aside>