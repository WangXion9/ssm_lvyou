<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 页面meta -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>数据 - AdminLTE2定制版</title>
<meta name="description" content="AdminLTE2定制版">
<meta name="keywords" content="AdminLTE2定制版">

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
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">
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
				游客管理 <small>游客信息修改</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/index.jsp"><i
						class="fa fa-dashboard"></i> 首页</a></li>
				<li><a
					href="${pageContext.request.contextPath}/traveller/findAll.do">游客管理</a></li>
				<li class="active">游客信息修改</li>
			</ol>
			</section>
			<!-- 内容头部 /-->

			<form id="form" action="${pageContext.request.contextPath}/traveller/edit.do"
				method="post">
				<!-- 正文区域 -->
				<section class="content"> <!--产品信息-->

				<div class="panel panel-default">
					<div class="panel-heading">游客信息修改</div>
					<div class="row data-type">
						<input type="hidden" name="id" value="${traveller.id}">

						<div class="col-md-2 title">游客姓名</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control checkName" name="name"
								placeholder="游客姓名" value="${traveller.name}" onblur="checkName()">
						</div>
						<div class="col-md-2 title">性别</div>
						<div class="col-md-4 data">
							<select id="sex" class="form-control select2 checkSex" style="width: 100%"
									name="sex" >
								<option value="" selected="selected checkSex">请选择</option>
								<option value="男" >男</option>
								<option value="女">女</option>
							</select>
						</div>
						<div class="col-md-2 title">联系电话</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control checkPhone" name="phoneNum"
								   placeholder="联系电话 11位" value="${traveller.phoneNum}" onblur="checkPhone()">
						</div>
						<div class="col-md-2 title">游客类别</div>
						<div class="col-md-4 data">
							<select class="form-control select2 checkTravellerType" style="width: 100%"
									name="travellerType" id="travellerType">
								<option value="" selected="selected">请选择</option>
								<option value="0" >成人</option>
								<option value="1">儿童</option>
							</select>
						</div>
						<div class="col-md-2 title">证件类别</div>
						<div class="col-md-4 data">
							<select class="form-control select2 checkCredentialsType" style="width: 100%"
									name="credentialsType" id="credentialsType">
								<option value="" selected="selected">请选择</option>
								<option value="0" >身份证</option>
								<option value="1">护照</option>
								<option value="2">军官证</option>
							</select>
						</div>
						<div class="col-md-2 title">证件号码</div>
						<div class="col-md-4 data" >
							<input type="text" class="form-control checkNum" name="credentialsNum"
								   placeholder="证件号码" value="${traveller.credentialsNum}" onblur="checkNum()">
						</div>

						<%--<div class="col-md-2 title">用户状态</div>--%>
						<%--<div class="col-md-4 data">--%>
							<%--<select class="form-control select2" style="width: 100%"--%>
								<%--name="status">--%>
								<%--<option value="0" selected="selected">关闭</option>--%>
								<%--<option value="1">开启</option>--%>
							<%--</select>--%>
						<%--</div>--%>

					</div>
				</div>
				<!--订单信息/-->
					<!--工具栏-->
				<div class="box-tools text-center">
					<button type="button" class="btn bg-maroon" onclick="save()">保存</button>
					<button type="button" class="btn bg-default"
						onclick="history.back(-1);">返回</button>
				</div>
				<!--工具栏/--> </section>
				<!-- 正文区域 /-->
			</form>
		</div>
		<!-- 内容区域 /-->

		<!-- 底部导航 -->
		<footer class="main-footer">
		<div class="pull-right hidden-xs">
			<b>Version</b> 1.0.8
		</div>
		<strong>Copyright &copy; 2014-2017 <a
			href="http://www.itcast.cn">研究院研发部</a>.
		</strong> All rights reserved. </footer>
		<!-- 底部导航 /-->

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
		src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.min.js"></script>

	<script>

        $(function () {
            //回显游客类型
            $("#travellerType").find("option[value='${traveller.travellerType}']").attr("selected",'selected');
            //回显游客证件类型
            $("#credentialsType").find("option[value='${traveller.credentialsType}']").attr("selected",'selected');
            //回显性别
            $("#sex").find("option[value='${traveller.sex}']").attr("selected",'selected');

        });

		$(document).ready(function() {
			// 选择框
			$(".select2").select2();

			// WYSIHTML5编辑器
			$(".textarea").wysihtml5({
				locale : 'zh-CN'
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


        // 校验账号  不能为空
        function checkName() {
            var username = $(".checkName").val();
            if("" == username){
                $(".checkName")[0].style.border="2px solid red";
                return false;
            }else {
                var flag;
                $.get({
                    url:"${pageContext.request.contextPath}/traveller/findTravellerByTravellerName.do?id=${traveller.id}&name="+username,
                    dataType:"json",
                    async:false,
                    success:function (data) {
                        if (!data){
                            alert("会员已存在！");
                            $(".checkName")[0].style.border="2px solid red";
                            flag = false;
                        }else {
                            $(".checkName")[0].style.border="1px solid #d2d6de";
                            flag = true;
                        }
                    }
                });
                return flag;
            }
        }

        //验证电话
        function checkPhone() {
            var phone = $(".checkPhone").val();
            var reg = /^1[3-9]+\d{9}$/;
            if (reg.test(phone) == false){
                $(".checkPhone")[0].style.border="2px solid red";
                return false;
            }else {
                $(".checkPhone")[0].style.border="1px solid #d2d6de";
                return true;
            }
        }

        // 校验号码  不能为空
        function checkNum() {
            var username = $(".checkNum").val();
            if("" == username){
                $(".checkNum")[0].style.border="2px solid red";
                return false;
            }else {
                $(".checkName")[0].style.border="1px solid #d2d6de";
                return true;
            }
        }

        //检验下拉框
        function checkSelect() {
            var sex = $(".checkSex").val();
            var travellerType = $(".checkTravellerType").val();
            var credentialsType = $(".checkCredentialsType").val();
            if (sex == "" || travellerType == "" || credentialsType == ""){
                return false;
            }else {
                return true;
            }

        }

        //保存按钮
        function save() {
            if (checkName() && checkPhone() && checkNum() && checkSelect() ){
                $("#form").submit();
            } else {
                alert("表单请填写完整！");
            }

        }

	</script>


</body>

</html>