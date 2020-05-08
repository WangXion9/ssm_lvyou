<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 页面meta -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>商品修改</title>
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
				产品管理 <small>产品表单</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/index.jsp"><i
						class="fa fa-dashboard"></i> 首页</a></li>
				<li><a
					href="${pageContext.request.contextPath}/product/findAll.do">产品管理</a></li>
				<li class="active">产品表单</li>
			</ol>
			</section>
			<!-- 内容头部 /-->

			<form id="form" action="${pageContext.request.contextPath}/product/updateById.do"
				method="post">
				<!-- 正文区域 -->
				<section class="content"> <!--产品信息-->

				<div class="panel panel-default">
					<div class="panel-heading">产品信息</div>
					<div class="row data-type">

						<%--向后台传递id值--%>
						<input name="id" type="hidden" value="${product.id}">

						<div class="col-md-2 title">产品编号</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control checkNum" name="productNum"
								placeholder="产品编号" value="${product.productNum}" onblur="checkNum()">
						</div>
						<div class="col-md-2 title">产品名称</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control checkName" name="productName"
								placeholder="产品名称" value="${product.productName}" onblur="checkName()">
						</div>
						<div class="col-md-2 title">出发时间</div>
						<div class="col-md-4 data">
							<div class="input-group date">
								<div class="input-group-addon">
									<i class="fa fa-calendar"></i>
								</div>
								<input type="text" class="form-control pull-right checkTime"
									id="datepicker-a3" name="departureTime" value="${product.departureTimeStr}" onblur="checkTime()">
							</div>
						</div>

						<div class="col-md-2 title">产品价格</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control checkPrice" placeholder="产品价格"
								   name="productPrice" value="${product.productPrice}" onblur="checkPrice()">
						</div>


						<div class="col-md-2 title">出发城市</div>
						<div class="col-md-4 data">
							<select id="startCity" class="form-control select2 checkStartCity" style="width: 100%"
									name="startCity.id">
								<option value="" selected="selected">请选择</option>
								<c:forEach items="${cityList}" var="city">
									<option value="${city.id}" >${city.cityName}</option>
								</c:forEach>
							</select>
						</div>

						<div class="col-md-2 title">目的城市</div>
						<div class="col-md-4 data">
							<select id="endCity" class="form-control select2 checkEndCity" style="width: 100%"
									name="endCity.id">
								<option value="" selected="selected">请选择</option>
								<c:forEach items="${cityList}" var="city">
									<option value="${city.id}" >${city.cityName}</option>
								</c:forEach>
							</select>
						</div>



						<div class="col-md-2 title">产品状态</div>
						<div class="col-md-4 data">
							<select class="form-control select2 checkProductStatus" style="width: 100%"
								name="productStatus" id="selectStatus">
									<option  value="0"  >关闭</option>
									<option  value="1">开启</option>
							</select>
						</div>

						<div class="col-md-2 title"></div>
						<div class="col-md-4 data">
						</div>

						<div class="col-md-2 title rowHeight2x">其他信息</div>
						<div class="col-md-10 data rowHeight2x">
							<textarea class="form-control checkDesc" rows="3" placeholder="其他信息"
								name="productDesc" onblur="checkDesc()" >${product.productDesc}</textarea>
						</div>

					</div>
				</div>
				<!--订单信息/--> <!--工具栏-->
				<div class="box-tools text-center">
					<button type="button" class="btn bg-maroon" onclick="save()">修改</button>
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

		//给产品是否开启下拉框回显数据
        $(function(){
            <%--alert("${product.productStatus}");--%>
            $("#selectStatus").find("option[value='${product.productStatus}']").attr("selected",'selected');
            $("#startCity").find("option[value='${product.startCity.id}']").attr("selected",'selected');
            $("#endCity").find("option[value='${product.endCity.id}']").attr("selected",'selected');
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

		$(document).ready(function() {
			$('#datepicker-a3').datetimepicker({
				format : "yyyy-mm-dd hh:ii",
				autoclose : true,
				todayBtn : true,
				language : "zh-CN"
			});
		});

		$(document).ready(function() {
			// 激活导航位置
			setSidebarActive("order-manage");
			$("#datepicker-a3").datetimepicker({
				format : "yyyy-mm-dd hh:ii",

			});

		});


        // 校验账号  不能为空
        function checkNum() {
            var username = $(".checkNum").val();
            if("" == username){
                $(".checkNum")[0].style.border="2px solid red";
                return false;
            }else {
                var flag;
                $.get({
                    url:"${pageContext.request.contextPath}/product/finProductByName.do?id=${product.id}&name="+username,
                    dataType:"json",
                    async:false,
                    success:function (data) {
                        if (!data ){
                            alert("产品编号已存在！");
                            $(".checkNum")[0].style.border="2px solid red";
                            flag =  false;
                        }else {
                            $(".checkNum")[0].style.border="1px solid #d2d6de";
                            flag = true;
                        }
                    }
                });
                return flag;
            }
        }

        // 校验名称  不能为空
        function checkName() {
            var username = $(".checkName").val();
            if("" == username){
                $(".checkName")[0].style.border="2px solid red";
                return false;
            }else {
                $(".checkName")[0].style.border="1px solid #d2d6de";
                return true;
            }

        }

        // 校验时间  不能为空
        function checkTime() {
            var username = $(".checkTime").val();
            if("" == username){
                $(".checkTime")[0].style.border="2px solid red";
                return false;
            }else {
                var reg = /^(?:19|20)[0-9][0-9]-(?:(?:0[1-9])|(?:1[0-2]))-(?:(?:[0-2][1-9])|(?:[1-3][0-1])) (?:(?:[0-2][0-3])|(?:[0-1][0-9])):[0-5][0-9]$/;
                if (reg.test(username) == false){
                    $(".checkTime")[0].style.border="2px solid red";
                    return false;
                } else {
                    $(".checkTime")[0].style.border="1px solid #d2d6de";
                    return true;
                }

            }

        }

        //验证金额
        function checkPrice() {
            var email = $(".checkPrice").val();
            var reg = /(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/;;
            if (reg.test(email) == false){
                $(".checkPrice")[0].style.border="2px solid red";
                return false;
            }else {
                $(".checkPrice")[0].style.border="1px solid #d2d6de";
                return true;
            }

        }

        // 校验名称  不能为空
        function checkDesc() {
            var username = $(".checkDesc").val();
            if("" == username){
                $(".checkDesc")[0].style.border="2px solid red";
                return false;
            }else {
                $(".checkDesc")[0].style.border="1px solid #d2d6de";
                return true;
            }

        }

        //检验下拉框
        function checkSelect() {
            var startCity = $(".checkStartCity").val();
            var endCity = $(".checkEndCity").val();
            var productStatus = $(".checkProductStatus").val();
            if (startCity == "" || endCity == "" || productStatus == ""){
                return false;
            }else {
                return true;
            }

        }

        //保存按钮
        function save() {
            if ( checkNum() && checkName() && checkTime() && checkPrice() &&checkDesc() && checkSelect() ){
                $("#form").submit();
            } else {
                alert("表单请填写完整！");
            }

        }



	</script>


</body>

</html>