<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<!-- 页面头部 -->
<header class="main-header">
	<!-- Logo -->
	<a href="#" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
		<span class="logo-mini"><b>数据</b></span> <!-- logo for regular state and mobile devices -->
		<span class="logo-lg"><b>数据</b>后台管理</span>
	</a>
	<!-- Header Navbar: style can be found in header.less -->
	<nav class="navbar navbar-static-top">
		<!-- Sidebar toggle button-->
		<a href="#" class="sidebar-toggle" data-toggle="offcanvas"
			role="button"> <span class="sr-only">Toggle navigation</span>
		</a>

		<div class="navbar-custom-menu">
			<ul class="nav navbar-nav">

				<li class="dropdown user user-menu"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown" onclick="getOutTime()"> <img
						src="${pageContext.request.contextPath}/img/user2-160x160.jpg"
						class="user-image" alt="User Image">
					<span id="span" class="hidden-xs">
							<security:authentication property="principal.username"></security:authentication>
					</span>

				</a>
					<ul class="dropdown-menu">
						<!-- User image -->
						<li class="user-header"><img
							src="${pageContext.request.contextPath}/img/user2-160x160.jpg"
							class="img-circle" alt="User Image">
							<p>
								<security:authentication property="principal.username"></security:authentication> - 数据管理员
								<small id="outTime">最后登录 11:20AM</small>
							</p>
						</li>

						<!-- Menu Footer-->
						<li class="user-footer">
							<div class="pull-left">
								<a href="${pageContext.request.contextPath}/user/editBeforePasswordByUsereName.do?username=<security:authentication property='principal.username'/>" class="btn btn-default btn-flat">修改密码</a>
							</div>
							<div class="pull-right">
								<a
									class="btn btn-default btn-flat" onclick="logout()">注销</a>
							</div>
						</li>
					</ul></li>

			</ul>

		</div>

	</nav>
</header>
<script>
	//注销
	function logout() {
        if ( window.confirm("是否注销用户 <security:authentication property='principal.username'></security:authentication> ？")){
            var time = '${sessionScope.get("loginTime")}';
            $.get({
                url:'${pageContext.request.contextPath}/out/editOutTimeByName.do?name=<security:authentication property="principal.username"></security:authentication>&time='+time,
                dataType:"json",
                async:false,
                success:function (data) {
                    location.href="${pageContext.request.contextPath}/logout.do";
                }
            });
		}
    }
    //加载最后登录时间
    function getOutTime() {
		//alert("time");
		$.get({
			url:"${pageContext.request.contextPath}/user/getUserByName.do?name=<security:authentication property='principal.username'></security:authentication>",
			dataType:"json",
            async:false,
			success:function (data) {
				var time = data.outTimeStr;
				$("#outTime").text("最后登录  "+time);
            }
		});
    }
</script>
<!-- 页面头部 /-->
