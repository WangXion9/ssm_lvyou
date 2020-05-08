<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<link rel=“stylesheet”
	href="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.min.css">
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
				订单管理 <small>新建订单</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="all-admin-index.html"><i
						class="fa fa-dashboard"></i> 首页</a></li>
				<li><a href="all-order-manage-list.html">订单管理</a></li>
				<li class="active">新建订单</li>
			</ol>
			</section>
			<!-- 内容头部 /-->

			<!-- 正文区域 -->
			<section class="content">
				<form id="sub" action="${pageContext.request.contextPath}/orders/saveAll.do"  method="post">
					<!--订单信息-->
					<div class="panel panel-default">
						<div class="panel-heading">订单信息</div>
						<div class="row data-type">
							<input type="hidden" name="id" value="${orders.id}">

							<div class="col-md-2 title">订单编号</div>
							<div class="col-md-4 data">
								<input type="text" name="orderNum" class="form-control checkOrderNum" placeholder="订单编号"
									   value="${orders.orderNum}" onblur="checkOrderNum()" >
							</div>
							<div class="col-md-2 title">出游人数</div>
							<div class="col-md-4 data">
								<input type="text" class="form-control checkManNum" placeholder="出游人数"
									   name="peopleCount"  value="${orders.peopleCount}" onblur="checkManNum()" >
							</div>
							<div class="col-md-2 title">支付状态</div>
							<div class="col-md-4 data">
								<select class="form-control select2 checkPayStatus" style="width: 100%"
										name="payStatus" id="payStatus">
									<option value="" selected="selected">请选择</option>
									<option value="0" >未支付</option>
									<option value="1">已支付</option>
								</select>
							</div>
							<div class="col-md-2 title">支付方式</div>
							<div class="col-md-4 data">
								<select class="form-control select2 checkPayType" style="width: 100%"
										name="payType"  id="payType">
									<option value="" selected="selected">请选择</option>
									<option value="0" >支付宝</option>
									<option value="1">微信</option>
									<option value="2">其他</option>
								</select>
							</div>
							<div class="col-md-2 title">订单处理状态</div>
							<div class="col-md-4 data">
								<select class="form-control select2 checkOrderStatus" style="width: 100%"
										name="orderStatus" id="orderStatus">
									<option value="" selected="selected">请选择</option>
									<option value="0">未处理</option>
									<option value="1">已处理</option>
								</select>
							</div>
							<div class="col-md-2 title">订单完成状态</div>
							<div class="col-md-4 data">
                                <select class="form-control select2 checkOverStatus" style="width: 100%"
                                        name="overStatus" id="">
                                    <option value="" selected="selected">请选择</option>
                                    <option value="0">进行中</option>
                                    <option value="1">待出团</option>
                                    <option value="2">交易成功</option>
                                    <option value="3">退款</option>
                                </select>
							</div>
							<div class="col-md-2 title rowHeight2x">订单描述</div>
							<div class="col-md-10 data rowHeight2x">
							<textarea class="form-control checkDesc" rows="3" placeholder="订单描述"
									  name="orderDesc" onblur="checkDesc()" >${orders.orderDesc}</textarea>
							</div>

						</div>
					</div>
					<!--产品信息/-->
					<div class="panel panel-default">
						<div class="panel-heading">产品信息</div>
						<div class="row data-type">

							<table id="productlist"
								   class="table table-bordered table-striped table-hover dataTable">
								<thead>
								<tr>
									<th class="" style="padding-right:0px;">

									</th>
									<th class="sorting_desc">产品编号</th>
									<th class="sorting_asc sorting_asc_disabled">产品名称</th>
									<th class="sorting_desc sorting_desc_disabled">出发城市</th>
									<th class="sorting_desc sorting_desc_disabled">目标城市</th>
									<th class="sorting">出发时间</th>
									<th class="text-center sorting">产品价格</th>
									<th class="text-center sorting">状态</th>
									<th class="text-center">操作</th>
								</tr>
								</thead>
								<tbody id="delDataList">
								<%--<c:forEach items="${pageInfo.list}" var="product">--%>
									<%--<tr>--%>
										<%--<td><input name="ids" type="checkbox" value="${product.id}"></td>--%>
										<%--<td>${product.id}</td>--%>
										<%--<td>${product.productNum}</td>--%>
										<%--<td>${product.productName}</td>--%>
										<%--<td>${product.productPrice}</td>--%>
										<%--<td>${product.cityName}</td>--%>
										<%--<td>${product.departureTimeStr}</td>--%>
										<%--<td>${product.productStatusStr}</td>--%>
										<%--<td class="text-center">--%>
											<%--<button type="button" class="btn bg-olive btn-xs" onclick="location.href='${pageContext.request.contextPath}/product/findByIdShow.do?id=${product.id}'">详情</button>--%>
										<%--</td>--%>
									<%--</tr>--%>
								<%--</c:forEach>--%>
								</tbody>
							</table>
							<div class="box-footer">
								<div class="pull-left">
									<div class="form-group form-inline">
										<h3 id="pageId"></h3>
									</div>
								</div>

								<div class="box-tools pull-right">
									<ul id="pageIi" class="pagination">
										<%--<li>--%>
											<%--<a onclick="delPage(1)"  aria-label="Previous">首页</a>--%>
										<%--</li>--%>
										<%--<li><a onclick="delPage(data.pageNum+1)">上一页</a></li>--%>
										<%--<c:forEach end="data.pages" begin="1" var="pageNum">--%>
											<%--<c:if test="data.pageNum == pageNum">--%>
												<%--<li ><a style="background-color: #0d6aad;color: #FFF" onclick="delPage(data.pageNum)" >data.pageNum</a></li>--%>
											<%--</c:if>--%>
											<%--<c:if test="data.pageNum != pageNum">--%>
												<%--<li ><a onclick="delPage(data.pageNum)" >data.pageNum</a></li>--%>
											<%--</c:if>--%>
										<%--</c:forEach>--%>
										<%--<li><a href="${pageContext.request.contextPath}/product/findAllAjax.do?page=${pageInfo.pageNum+1}}">下一页</a></li>--%>
										<%--<li>--%>
											<%--<a href="${pageContext.request.contextPath}/product/findAllAjax.do?page=${pageInfo.pages}&size=}" aria-label="Next">尾页</a>--%>
										<%--</li>--%>
									</ul>
								</div>

							</div>


						</div>
					</div>
					<!--产品信息/-->
					<!--游客信息-->
					<div class="panel panel-default">
						<div class="panel-heading">游客信息</div>
						<!--数据列表-->
						<table id="dataList"
							class="table table-bordered table-striped table-hover dataTable">
							<thead>

								<tr>
									<th class="text-center">人群</th>
									<th class="text-center">姓名</th>
									<th class="text-center">性别</th>
									<th class="text-center">手机号码</th>
									<th class="text-center">证件类型</th>
									<th class="text-center">证件号码</th>
									<th class="text-center">操作</th>
								</tr>
							</thead>
							<tbody >

									<tr id="travellerList">
										<td><select class="form-control select2" style="width: 100%"
														name="travellers[0].travellerType">
													<option value="" selected="selected">请选择</option>
													<option value="0">成人</option>
													<option value="1">儿童</option>
												</select>
											</td>
											<td><input type="text" class="form-control" size="10" name="travellers[0].name"
											></td>
											<td>
												<select class="form-control select2" style="width: 100%"
														name="travellers[0].sex">
													<option value="" selected="selected">请选择</option>
													<option value="男">男</option>
													<option value="女">女</option>
												</select>
											</td>
											<td><input type="text" size="20"
													   name="travellers[0].phoneNum" class="form-control" ></td>
											<td>
												<select class="form-control select2" style="width: 100%"
														name="travellers[0].credentialsType">
													<option value="" selected="selected">请选择</option>
													<option value="0">身份证</option>
													<option value="1">护照</option>
													<option value="2">军官证</option>
												</select>
											</td>
											<td><input type="text" size="28"
													   name="travellers[0].credentialsNum" class="form-control"  ></td>
										<td class="text-center">
											<button type="button" class="btn bg-olive btn-xs" onclick="add_traveller()">追加</button>
											<button type="button" class="btn bg-olive btn-xs" onclick="del_traveller(this)">刪除</button>
										</td>
									</tr>


							</tbody>
						</table>
						<!--数据列表/-->
					</div>
					<!--游客信息/-->
					<!--联系人信息-->
					<div class="panel panel-default">
						<div class="panel-heading">会员信息</div>
						<div class="row data-type">

							<div class="col-md-2 title">姓名</div>
							<%--<div class="col-md-4 data text">${orders.member.nickname }</div>--%>
							<div class="col-md-4 data text">
								<input type="text" name="member.name" class="form-control checkName" onblur="checkName()">
							</div>


							<div class="col-md-2 title">昵称</div>
							<%--<div class="col-md-4 data text">${orders.member.name}</div>--%>
							<div class="col-md-4 data text">
								<input type="text" name="member.nickname" class="form-control checkNickName" onblur="checkNickName()">
							</div>

							<div class="col-md-2 title">手机号</div>
							<%--<div class="col-md-4 data text">${orders.member.phoneNum}</div>--%>
							<div class="col-md-4 data text">
								<input type="text" name="member.phoneNum" class="form-control checkPhone" onblur="checkPhone()">
							</div>

							<div class="col-md-2 title">邮箱</div>
							<%--<div class="col-md-4 data text">${orders.member.email}</div>--%>
							<div class="col-md-4 data text">
								<input type="text" name="member.email" class="form-control checkEmail" onblur="checkEmail()">
							</div>

						</div>
					</div>
					<!--联系人信息/-->
				</form>

			<!--工具栏-->
			<div class="box-tools text-center">

				<button type="button" class="btn bg-maroon"
						onclick="saveAll()">保存</button>
				<button type="button" class="btn bg-default"
					onclick="history.back(-1);">返回</button>
			</div>
			<!--工具栏/--> </section>
			<!-- 正文区域 /-->


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

		var travellerSize = 0;
        num = parseInt(travellerSize);



		//添加一行遊客行
		function add_traveller(){
            travellerSize = travellerSize +1 ;
            // alert(num);
            debugger

		    // var listhtml = $("#travellerList").clone();
		    // alert(listhtml);

			var html ='<tr>\n' +
                '\t\t\t\t\t\t\t\t<td><select class="form-control select2" style="width: 100%"\n' +
                '\t\t\t\t\t\t\t\t\t\t\t\tname="travellers['+travellerSize+'].travellerType">\n' +
                '\t\t\t\t\t\t\t\t\t\t\t<option value="" selected="selected">请选择</option>\n' +
                '\t\t\t\t\t\t\t\t\t\t\t<option value="0">成人</option>\n' +
                '\t\t\t\t\t\t\t\t\t\t\t<option value="1">儿童</option>\n' +
                '\t\t\t\t\t\t\t\t\t\t</select>\n' +
                '\t\t\t\t\t\t\t\t\t</td>\n' +
                '\t\t\t\t\t\t\t\t\t<td><input type="text" class="form-control" size="10" name="travellers['+travellerSize+'].name"\n' +
                '\t\t\t\t\t\t\t\t\t></td>\n' +
                '\t\t\t\t\t\t\t\t\t<td>\n' +
                '\t\t\t\t\t\t\t\t\t\t<select class="form-control select2" style="width: 100%"\n' +
                '\t\t\t\t\t\t\t\t\t\t\t\tname="travellers['+travellerSize+'].sex">\n' +
                '\t\t\t\t\t\t\t\t\t\t\t<option value="" selected="selected">请选择</option>\n' +
                '\t\t\t\t\t\t\t\t\t\t\t<option value="男" >男</option>\n' +
                '\t\t\t\t\t\t\t\t\t\t\t<option value="女">女</option>\n' +
                '\t\t\t\t\t\t\t\t\t\t</select>\n' +
                '\t\t\t\t\t\t\t\t\t</td>\n' +
                '\t\t\t\t\t\t\t\t\t<td><input type="text" size="20"\n' +
                '\t\t\t\t\t\t\t\t\t\t\t   name="travellers['+travellerSize+'].phoneNum" class="form-control" ></td>\n' +
                '\t\t\t\t\t\t\t\t\t<td>\n' +
                '\t\t\t\t\t\t\t\t\t\t<select class="form-control select2" style="width: 100%"\n' +
                '\t\t\t\t\t\t\t\t\t\t\t\tname="travellers['+travellerSize+'].credentialsType">\n' +
                '\t\t\t\t\t\t\t\t\t\t\t<option value="" selected="selected">请选择</option>\n' +
                '\t\t\t\t\t\t\t\t\t\t\t<option value="0" >身份证</option>\n' +
                '\t\t\t\t\t\t\t\t\t\t\t<option value="1">护照</option>\n' +
                '\t\t\t\t\t\t\t\t\t\t\t<option value="2">军官证</option>\n' +
                '\t\t\t\t\t\t\t\t\t\t</select>\n' +
                '\t\t\t\t\t\t\t\t\t</td>\n' +
                '\t\t\t\t\t\t\t\t\t<td><input type="text" size="28"\n' +
                '\t\t\t\t\t\t\t\t\t\t\t   name="travellers['+travellerSize+'].credentialsNum" class="form-control"  ></td>\n' +
                '\t\t\t\t\t\t\t\t<td class="text-center">\n' +
                '\t\t\t\t\t\t\t\t\t<button type="button"   class="btn bg-olive btn-xs" onclick="add_traveller()">追加</button>\n' +
                '\t\t\t\t\t\t\t\t\t<button  type="button" class="btn bg-olive btn-xs" onclick="del_traveller(this)">刪除</button>\n' +
                '\t\t\t\t\t\t\t\t</td>\n' +
                '\t\t\t\t\t\t\t</tr>';
            $("#dataList").append(html);

        }


        //加载产品数据
		function getPage(page) {
            $.get({
                url:"${pageContext.request.contextPath}/product/findAllAjax.do?page="+page,
                dataType:"json",
                success:function(data){
                    var list = data.list;
                    var length = list.length;
                    var pages = parseInt(data.pages);

					//封装显示的数据
                    var html = "";
                    for (var i = 0; i < length; i++) {
                        html += '<tr>\n' +
                            '\t\t\t\t\t\t\t\t<td><input name="productId" type="radio" class="icheckbox_square-blue" value="'+list[i].id+'"></td>\n' +
                            '\t\t\t\t\t\t\t\t<td>'+list[i].productNum+'</td>\n' +
                            '\t\t\t\t\t\t\t\t<td>'+list[i].productName+'</td>\n' +
                            '\t\t\t\t\t\t\t\t<td>'+list[i].startCity.cityName+'</td>\n' +
                            '\t\t\t\t\t\t\t\t<td>'+list[i].endCity.cityName+'</td>\n' +
                            '\t\t\t\t\t\t\t\t<td>'+list[i].departureTimeStr+'</td>\n' +
                            '\t\t\t\t\t\t\t\t<td class="text-center">'+list[i].productPrice+'元</td>\n' +
                            '\t\t\t\t\t\t\t\t<td class="text-center">'+list[i].productStatusStr+'</td>\n' +
                            '\t\t\t\t\t\t\t\t<td class="text-center">\n' +
                            '\t\t\t\t\t\t\t\t\t<button type="button" class="btn bg-olive btn-xs" onclick="location.href=\'${pageContext.request.contextPath}/product/findByIdShow.do?id='+list[i].id+'\'">详情</button>\n' +
                            '\t\t\t\t\t\t\t\t</td>\n' +
                            '\t\t\t\t\t\t\t</tr>';
                    }
					$("#productlist").append(html);
					//封装页面的条数也页数
					$("#pageId").text("总共"+pages+" 页，共"+data.total+" 条数据。");
                    var pageli = "";
                    pageli ='<li>\n' +
                        '\t\t\t\t\t\t\t\t\t<a onclick="delPage(1)"  aria-label="Previous">首页</a>\n' +
                        '\t\t\t\t\t\t\t\t</li>\n' +
                        '\t\t\t\t\t\t\t\t<li><a onclick="delPage('+(data.pageNum-1)+')">上一页</a></li>';

                    //----------------------------------------

					 // alert(pages);
                    for (var i = 1; i <= data.pages; i++) {
                        if (i == data.pageNum){
                            pageli += '<li ><a style="background-color: #0d6aad;color: #FFF"  onclick="delPage('+i+')" >'+i+'</a></li>';
                        }else {
                            pageli += '<li ><a onclick="delPage('+i+')" >'+i+'</a></li>';
                        }

                    }

					//----------------------------------------

                    pageli += '<li><a onclick="delPage('+(data.pageNum+1)+')">下一页</a></li>\n' +
                        '\t\t\t\t\t\t\t\t<li>\n' +
                        '\t\t\t\t\t\t\t\t\t<a onclick="delPage('+pages+')" aria-label="Next">尾页</a>\n' +
                        '\t\t\t\t\t\t\t\t</li>';

                    $("#pageIi").append(pageli);
                }
            });
        }

        //刷新后删除原来的产品数据
        function delPage(page) {
			//删除产品信息
			$("#delDataList").empty();
			//重新显示页码
			$("#pageId").empty();
			//重新显示分页信息
			$("#pageIi").empty();
			//重新请求，显示页面
            getPage(page);
        }


        //页面加载的时候动态加载产品数据
        $(function () {
            getPage(1);
        });


        //刪除一行遊客行
        function del_traveller(obj){
            travellerSize = travellerSize -1 ;
            // alert(num);
            $(obj).parent().parent().remove();
        }

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


			// 激活导航位置
			setSidebarActive("order-manage");

			// 列表按钮 
			$("#dataList td input[type='checkbox']").iCheck({
				checkboxClass : 'icheckbox_square-blue',
				increaseArea : '20%'
			});
			// 全选操作 
			$("#selall").click(function() {
				var clicks = $(this).is(':checked');
				if (!clicks) {
					$("#dataList td input[type='checkbox']").iCheck("uncheck");
				} else {
					$("#dataList td input[type='checkbox']").iCheck("check");
				}
				$(this).data("clicks", !clicks);
			});
		});



        // 校验账号  不能为空
        function checkName() {
            var username = $(".checkName").val();
            if("" == username){
                $(".checkName")[0].style.border="2px solid red";
                return false;
            }else {
                var flag;
                $.get({
                    url:"${pageContext.request.contextPath}/member/findMemberByMemberName.do?name="+username,
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

        // 校验昵称  不能为空
        function checkNickName() {
            var username = $(".checkNickName").val();
            if("" == username){
                $(".checkNickName")[0].style.border="2px solid red";
                return false;
            }else {
                $(".checkNickName")[0].style.border="1px solid #d2d6de";
                return true;
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

        //验证邮箱
        function checkEmail() {
            var email = $(".checkEmail").val();
            var reg = /^\w+@\w+(\.[a-zA-Z]{2,3}){1,2}$/;
            if (reg.test(email) == false){
                $(".checkEmail")[0].style.border="2px solid red";
                return false;
            }else {
                $(".checkEmail")[0].style.border="1px solid #d2d6de";
                return true;
            }

        }

        // 校验订单编号  不能为空
        function checkOrderNum() {
            var username = $(".checkOrderNum").val();
            if("" == username){
                $(".checkOrderNum")[0].style.border="2px solid red";
                return false;
            }else {
                var flag;
                $.get({
                    url:"${pageContext.request.contextPath}/orders/findOrderByOrderNum.do?name="+username,
                    dataType:"json",
                    async:false,
                    success:function (data) {
                        if (!data){
                            alert("订单编号已存在！");
                            $(".checkOrderNum")[0].style.border="2px solid red";
                            flag = false;
                        }else {
                            $(".checkOrderNum")[0].style.border="1px solid #d2d6de";
                            flag = true;
                        }
                    }
                });
                return flag;
            }
        }

        //验证订单人数
        function checkManNum() {
            var email = $(".checkManNum").val();
            var reg = /^[1-9]\d*$/;
            if (reg.test(email) == false){
                $(".checkManNum")[0].style.border="2px solid red";
                return false;
            }else {
                $(".checkManNum")[0].style.border="1px solid #d2d6de";
                return true;
            }

        }

        // 校验订单其他信息  不能为空
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
            var payStatus = $(".checkPayStatus").val();
            var payType = $(".checkPayType").val();
            var orderStatus = $(".checkOrderStatus").val();
            var overStatus = $(".checkOverStatus").val();
            if (payStatus == "" || payType == "" || orderStatus == "" || overStatus == ""){
                return false;
            }else {
                return true;
            }

        }
        
        //检验是否选择产品
		function checkProduct() {
            var product = $('input:radio[name="productId"]:checked').val();
            if($.type(product) === "undefined"){
                alert("请选择旅游产品！");
                return false;
			}else {
                return true;
			}
        }

        //保存提交表单
        function saveAll() {
            if (checkName()&&checkNickName()&&checkPhone()&&checkEmail()&&checkOrderNum()&&checkManNum()&&checkDesc()&&checkSelect()&&checkProduct()){
                $("#sub").submit();
			} else {
                alert("表单请填写完整!");
			}

        }




	</script>
</body>


</html>