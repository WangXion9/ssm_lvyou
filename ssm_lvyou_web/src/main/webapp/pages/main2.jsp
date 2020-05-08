<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<!-- 页面meta -->
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">




	<title>数据 - AdminLTE2定制版</title>
	<meta name="description" content="AdminLTE2定制版">
	<meta name="keywords" content="AdminLTE2定制版">




	<!-- Tell the browser to be responsive to screen width -->
	<meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
	<!-- Bootstrap 3.3.6 -->
	<!-- Font Awesome -->
	<!-- Ionicons -->
	<!-- iCheck -->
	<!-- Morris chart -->
	<!-- jvectormap -->
	<!-- Date Picker -->
	<!-- Daterange picker -->
	<!-- Bootstrap time Picker -->
	<!--<link rel="stylesheet" href="/../../plugins/timepicker/bootstrap-timepicker.min.css">-->
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
	<!--<script src=="/../../plugins/timepicker/bootstrap-timepicker.min.js"></script>-->
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

	<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/morris/morris.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/datepicker/datepicker3.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.theme.default.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/select2/select2.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/adminLTE/css/skins/_all-skins.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.skinNice.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap-slider/slider.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">
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
				控制面板
				<small>首页</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/pages/main2.jsp"><i class="fa fa-dashboard"></i> 首页</a></li>
			</ol>
		</section>
		<!-- 内容头部 /-->

		<!-- 正文区域 -->
		<section class="content">


			<!-- 统计数值 -->
			<div class="row">
				<div class="col-lg-3 col-xs-6">
					<!-- small box -->
					<div class="small-box bg-aqua">
						<div class="inner">
							<h3 id="newOrders">0</h3>

							<p>今日新订单</p>
						</div>
						<div class="icon">
							<i class="ion ion-bag"></i>
						</div>
						<a href="${pageContext.request.contextPath}/orders/findOrdersByNew.do" class="small-box-footer">详细 <i class="fa fa-arrow-circle-right"></i></a>
					</div>
				</div>
				<!-- ./col -->
				<div class="col-lg-3 col-xs-6">
					<!-- small box -->
					<div class="small-box bg-green">
						<div class="inner">
							<h3 id="transition">0<sup style="font-size: 20px">%</sup></h3>

							<p>退款率</p>
						</div>
						<div class="icon">
							<i class="ion ion-stats-bars"></i>
						</div>
						<a href="${pageContext.request.contextPath}/orders/findOrdersByRefund.do" class="small-box-footer">详细 <i class="fa fa-arrow-circle-right"></i></a>
					</div>
				</div>
				<!-- ./col -->
				<div class="col-lg-3 col-xs-6">
					<!-- small box -->
					<div class="small-box bg-yellow">
						<div class="inner">
							<h3 id="newMember">0</h3>

							<p>今日新注册用户</p>
						</div>
						<div class="icon">
							<i class="ion ion-person-add"></i>
						</div>
						<a href="${pageContext.request.contextPath}/member/findMemberByNew.do" class="small-box-footer">详细 <i class="fa fa-arrow-circle-right"></i></a>
					</div>
				</div>
				<!-- ./col -->
				<div class="col-lg-3 col-xs-6">
					<!-- small box -->
					<div class="small-box bg-red">
						<div class="inner">
							<h3 id="price">0</h3>

							<p>今日订单总金额</p>
						</div>
						<div class="icon">
							<i class="ion ion-pie-graph"></i>
						</div>
						<a href="${pageContext.request.contextPath}/orders/findOrdersByNew.do" class="small-box-footer">详细 <i class="fa fa-arrow-circle-right"></i></a>
					</div>
				</div>
				<!-- ./col -->
			</div>
			<!-- /.row -->


			<!-- 待处理订单 -->
			<div class="box box-primary">
				<div class="box-header with-border">
					<i class="fa fa-cube"></i>
					<h3 class="box-title" id="orderTitle">待处理订单</h3>
					<div class="box-tools pull-right">
						<button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
						<%--<button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>--%>
					</div>
				</div>


				<div class="box-body">

					<!-- 数据表格 -->
					<div class="table-box">

						<!--数据列表-->
						<table id="ordersList" class="table table-bordered table-striped table-hover dataTable">
							<thead>
							<tr>
								<th class="">订单号</th>
								<th class="">产品名称</th>
								<th class="">会员</th>
								<th class="">价格</th>
								<th class="">状态</th>
								<th class="text-center">操作</th>
							</tr>
							</thead>
							<tbody>

							<tr id="ordersNone"  style="display: none">
								<td>2017020200001</td>
								<td>西安3日自由行·超级自由行</td>
								<td>bi'peng0405</td>
								<td>￥500</td>
								<td>已取消</td>
								<td class="text-center">
									<button type="button" class="btn bg-olive btn-xs" onclick='location.href="${pageContext.request.contextPath}/orders/editById.do?id="'>编辑</button>
								</td>
							</tr>

							</tbody>
						</table>
						<!--数据列表/-->
						
					</div>
					<!-- 数据表格 /-->

				</div>
				<!-- /.box-body -->

			</div>
			<!-- 待处理订单 /-->

			<!-- 待处理游记 -->
			<div class="box box-success">
				<div class="box-header with-border">
					<i class="fa fa-book"></i>
					<h3 class="box-title" id="diaryTitle">待处理游记</h3>
					<div class="box-tools pull-right">
						<button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
						<%--<button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>--%>
					</div>
				</div>


				<div class="box-body">

					<!-- 数据表格 -->
					<div class="table-box">

						<!--数据列表-->
						<table id="diaryList" class="table table-bordered table-striped table-hover dataTable">
							<thead>
							<tr >
								<th class="">会员昵称</th>
								<th class="">游记标题</th>
								<th class="">发布时间</th>
								<th class="">状态</th>
								<th class="text-center">操作</th>
							</tr>
							</thead>
							<tbody>

							<tr  style="display: none">
								<td>大王叫我来巡山</td>
								<td>毕大爷带你游西安（附详细攻略）</td>
								<td>2017-03-07 17:45</td>
								<td>待审核</td>
								<td class="text-center">
									<button type="button" class="btn bg-olive btn-xs" onclick='location.href="all-travellog-manage-edit.html"'>编辑</button>
								</td>
							</tr>

							</tbody>
						</table>
						<!--数据列表/-->

					</div>
					<!-- 数据表格 /-->

				</div>
				<!-- /.box-body -->

			</div>
			<!-- 待处理游记 /-->

		</section>
		<!-- 正文区域 /-->

	</div>
	<!-- 内容区域 /-->

	<!-- 底部导航 -->
	<footer class="main-footer">
		<div class="pull-right hidden-xs">
			<b>Version</b> 1.0.8
		</div>
		<strong>Copyright &copy; 2014-2017 <a href="http://www.itcast.cn">研究院研发部</a>.</strong> All rights reserved.
	</footer>
	<!-- 底部导航 /-->

</div>


<script src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/jQueryUI/jquery-ui.min.js"></script>
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/raphael/raphael-min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/morris/morris.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/sparkline/jquery.sparkline.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script src="${pageContext.request.contextPath}/plugins/knob/jquery.knob.js"></script>
<script src="${pageContext.request.contextPath}/plugins/daterangepicker/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.js"></script>
<script src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
<script src="${pageContext.request.contextPath}/plugins/datepicker/bootstrap-datepicker.js"></script>
<script src="${pageContext.request.contextPath}/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/fastclick/fastclick.js"></script>
<script src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/adminLTE/js/app.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.js"></script>
<script src="${pageContext.request.contextPath}/plugins/select2/select2.full.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/markdown.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/to-markdown.js"></script>
<script src="${pageContext.request.contextPath}/plugins/ckeditor/ckeditor.js"></script>
<script src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.js"></script>
<script src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.extensions.js"></script>
<script src="${pageContext.request.contextPath}/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/chartjs/Chart.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.resize.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.pie.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.categories.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-slider/bootstrap-slider.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<script>

	//页面加载时触发
	$(function () {
        //getDiary();
        //getOrders();
        getOther();
	});

    //游记ajax请求
	function getDiary(){
        $.get({
            url:"${pageContext.request.contextPath}/diary/getDiaryByStatusZero.do",
            dataType:"json",
            success:function (data) {
                var list = data.list;
                for (var i = 0; i < list.length; i++) {
                    var html = '<tr >\n' +
                        '\t\t\t\t\t\t\t\t<td>'+list[i].member.name+'</td>\n' +
                        '\t\t\t\t\t\t\t\t<td>'+list[i].title+'</td>\n' +
                        '\t\t\t\t\t\t\t\t<td>'+list[i].createTimeStr+'</td>\n' +
                        '\t\t\t\t\t\t\t\t<td>'+list[i].diaryStatusStr+'</td>\n' +
                        '\t\t\t\t\t\t\t\t<td class="text-center">\n' +
                        '\t\t\t\t\t\t\t\t\t<button type="button" class="btn bg-olive btn-xs" onclick=\'location.href="${pageContext.request.contextPath}/diary/editBeforeDiary.do?id='+list[i].id+'"\'>编辑</button>\n' +
                        '\t\t\t\t\t\t\t\t</td>\n' +
                        '\t\t\t\t\t\t\t</tr>';
                    $("#diaryList").append(html);
                }
                $("#diaryTitle").text("待处理的游记（ "+data.total+" 条）");

            }
        });
    }

    //订单ajax请求
    function getOrders(){
        $.get({
            url:"${pageContext.request.contextPath}/orders/getOrdersByStatusZero.do",
            dataType:"json",
            success:function (data) {
                var list = data.list;
                for (var i = 0; i < list.length; i++) {
                    var html = '<tr >\n' +
                        '\t\t\t\t\t\t\t\t<td>'+list[i].orderNum+'</td>\n' +
                        '\t\t\t\t\t\t\t\t<td>'+list[i].product.productName+'</td>\n' +
                        '\t\t\t\t\t\t\t\t<td>'+list[i].member.name+'</td>\n' +
                        '\t\t\t\t\t\t\t\t<td>￥'+list[i].product.productPrice+'</td>\n' +
                        '\t\t\t\t\t\t\t\t<td>'+list[i].orderStatusStr+'</td>\n' +
                        '\t\t\t\t\t\t\t\t<td class="text-center">\n' +
                        '\t\t\t\t\t\t\t\t\t<button type="button" class="btn bg-olive btn-xs" onclick=\'location.href="${pageContext.request.contextPath}/orders/editById.do?id='+list[i].id+'"\'>编辑</button>\n' +
                        '\t\t\t\t\t\t\t\t</td>\n' +
                        '\t\t\t\t\t\t\t</tr>';
                    $("#ordersList").append(html);
                }
                $("#orderTitle").text("待处理的订单（ "+data.total+" 条）")

            }
        });
    }

    //页面其他ajax请求
    function getOther(){
        $.get({
            url:"${pageContext.request.contextPath}/orders/getOtherByNew.do",
            dataType:"json",
            success:function (data) {
                var scale = data["successScale"];
                scale = parseFloat(scale);
                scale = scale*100;
                scale = scale + "%";
                $("#newOrders").text(data["ordersAddByNew"]);
                $("#newMember").text(data["memberAddByNew"]);
                $("#price").text(data["ordersMoneyByNew"]);
                $("#transition").text(scale);

                //订单的处理
                var list = data["ordersPageInfo"].list;
                for (var i = 0; i < list.length; i++) {
                    var html = '<tr >\n' +
                        '\t\t\t\t\t\t\t\t<td>'+list[i].orderNum+'</td>\n' +
                        '\t\t\t\t\t\t\t\t<td>'+list[i].product.productName+'</td>\n' +
                        '\t\t\t\t\t\t\t\t<td>'+list[i].member.name+'</td>\n' +
                        '\t\t\t\t\t\t\t\t<td>￥'+list[i].product.productPrice+'</td>\n' +
                        '\t\t\t\t\t\t\t\t<td>'+list[i].orderStatusStr+'</td>\n' +
                        '\t\t\t\t\t\t\t\t<td class="text-center">\n' +
                        '\t\t\t\t\t\t\t\t\t<button type="button" class="btn bg-olive btn-xs" onclick=\'location.href="${pageContext.request.contextPath}/orders/editById.do?id='+list[i].id+'"\'>编辑</button>\n' +
                        '\t\t\t\t\t\t\t\t</td>\n' +
                        '\t\t\t\t\t\t\t</tr>';
                    $("#ordersList").append(html);
                }
                $("#orderTitle").text("待处理的订单（ "+data["ordersPageInfo"].total+" 条）")

				//游记的处理
                var dlist = data["diaryPageInfo"].list;
                for (var i = 0; i < dlist.length; i++) {
                    var html = '<tr >\n' +
                        '\t\t\t\t\t\t\t\t<td>'+dlist[i].member.name+'</td>\n' +
                        '\t\t\t\t\t\t\t\t<td>'+dlist[i].title+'</td>\n' +
                        '\t\t\t\t\t\t\t\t<td>'+dlist[i].createTimeStr+'</td>\n' +
                        '\t\t\t\t\t\t\t\t<td>'+dlist[i].diaryStatusStr+'</td>\n' +
                        '\t\t\t\t\t\t\t\t<td class="text-center">\n' +
                        '\t\t\t\t\t\t\t\t\t<button type="button" class="btn bg-olive btn-xs" onclick=\'location.href="${pageContext.request.contextPath}/diary/editBeforeDiary.do?id='+dlist[i].id+'"\'>编辑</button>\n' +
                        '\t\t\t\t\t\t\t\t</td>\n' +
                        '\t\t\t\t\t\t\t</tr>';
                    $("#diaryList").append(html);
                }
                $("#diaryTitle").text("待处理的游记（ "+data["diaryPageInfo"].total+" 条）");
            }
        });
    }


    $(document).ready(function() {
        // 选择框
        $(".select2").select2();

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


    $(document).ready(function() {
        // 激活导航位置
        setSidebarActive("admin-index");
    });
</script>
</body>

</html>
<!---->