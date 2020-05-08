<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="${pageContext.request.contextPath}/img/user2-160x160.jpg"
					class="img-circle" alt="User Image">
			</div>
			<div class="pull-left info">
				<p>
					<security:authentication property="principal.username"></security:authentication>
				</p>
				<a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
			</div>
		</div>

		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="header">菜单</li>
			<li id="admin-index"><a
				href="${pageContext.request.contextPath}/pages/main2.jsp"><i
					class="fa fa-dashboard"></i> <span>首页</span></a></li>

			<li class="treeview"><a href="#"> <i class="fa fa-cogs"></i>
					<span>系统管理</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>


			</a>
				<ul class="treeview-menu">

					<li id="system-setting">
						<%--只有ADMIN权限才可以显示  hasAnyRole('ADMIN','USER') --%>
						<security:authorize access="hasAnyRole('ADMIN','USER','TEST')">
						<a
						href="${pageContext.request.contextPath}/user/findAll.do?page=1&size=4"> <i
							class="fa fa-circle-o"></i> 用户管理
						</a>
						</security:authorize>
					</li>
					<li id="system-setting">
						<security:authorize access="hasAnyRole('ADMIN','ROLE','TEST')">
						<a
						href="${pageContext.request.contextPath}/role/findAll.do?page=1&size=4"> <i
							class="fa fa-circle-o"></i> 角色管理
					</a>
						</security:authorize>
					</li>
					<li id="system-setting">
						<security:authorize access="hasAnyRole('ADMIN','PERMISSION','TEST')">
						<a
						href="${pageContext.request.contextPath}/permission/findAll.do?page=1&size=4">
							<i class="fa fa-circle-o"></i> 资源权限管理
					</a>
						</security:authorize>
					</li>
				</ul></li>
			<li class="treeview"><a href="#"> <i class="fa fa-cube"></i>
					<span>基础数据</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">

					<li id="system-setting">
						<security:authorize access="hasAnyRole('ADMIN','PRODUCT','TEST')">
						<a
						href="${pageContext.request.contextPath}/product/findAll.do?page=1&size=4">
							<i class="fa fa-circle-o"></i> 产品管理
					</a>
						</security:authorize>
					</li>
					<li id="system-setting">
						<security:authorize access="hasAnyRole('ADMIN','ORDERS','TEST')">
						<a
						href="${pageContext.request.contextPath}/orders/findAll.do?page=1&size=4"> <i
							class="fa fa-circle-o"></i> 订单管理
					</a>
						</security:authorize>
					</li>

				</ul></li>

			<li class="treeview"><a href="#"> <i class="fa fa-folder"></i>
				<span>客户管理</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">

					<li id="system-setting">
						<security:authorize access="hasAnyRole('ADMIN','MEMBER','TEST')">
						<a
							href="${pageContext.request.contextPath}/member/findAll.do"> <i
							class="fa fa-circle-o"></i> 会员管理
					</a>
						</security:authorize>
					</li>
					<li id="system-setting">
						<security:authorize access="hasAnyRole('ADMIN','TRAVELLER','TEST')">
						<a
							href="${pageContext.request.contextPath}/traveller/findAll.do"> <i
							class="fa fa-circle-o"></i> 游客管理
					</a>
						</security:authorize>
					</li>

				</ul></li>

			<li class="treeview"><a href="#"> <i class="fa fa-laptop"></i>
				<span>游记管理</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">

					<li id="system-setting">
						<security:authorize access="hasAnyRole('ADMIN','DIARY','TEST')">
						<a
							href="${pageContext.request.contextPath}/diary/findAll.do"> <i
							class="fa fa-circle-o"></i> 游记管理
					</a>
						</security:authorize>
					</li>
					<li id="system-setting">
						<security:authorize access="hasAnyRole('ADMIN','COMMENT','TEST')">
						<a
							href="${pageContext.request.contextPath}/comment/findAll.do"> <i
							class="fa fa-circle-o"></i> 评论管理
					</a>
						</security:authorize>
					</li>

				</ul></li>

			<li class="treeview"><a href="#"> <i class="fa fa-book"></i>
				<span>系统日志</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">

					<li id="system-setting">
						<security:authorize access="hasAnyRole('ADMIN','SYSLOG','TEST')">
						<a
							href="${pageContext.request.contextPath}/sysLog/findAll.do?page=1&size=15"> <i
							class="fa fa-circle-o"></i> 访问日志
					</a>
						</security:authorize>
					</li>

				</ul></li>

		</ul>
	</section>
	<!-- /.sidebar -->
</aside>