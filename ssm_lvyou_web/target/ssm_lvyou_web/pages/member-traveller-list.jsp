<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				会员管理 <small>会员添加游客</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/index.jsp"><i
						class="fa fa-dashboard"></i> 首页</a></li>
				<li><a
					href="${pageContext.request.contextPath}/user/findAll.do">会员管理</a></li>

				<li class="active">会员添加游客</li>
			</ol>
			</section>
			<!-- 内容头部 /-->

				<!-- 正文区域 -->
				<section class="content"> <!-- .box-body -->
				<div class="box box-primary">
					<div class="box-header with-border">
						<h3 class="box-title">${member.name} 会员添加游客</h3>
					</div>

					<form  id="saveButton" action="${pageContext.request.contextPath}/member/editTravellerMemberId.do" method="post">
						<input type="hidden" name="memberId" value="${member.id}">
					<div class="box-body">

						<!-- 数据表格 -->
						<div class="table-box">

							<!--工具栏-->
							<div class="pull-left">
								<div class="form-group form-inline">
									<div class="btn-group">
										<%--<button type="button" class="btn btn-default" title="新建" onclick="location.href='${pageContext.request.contextPath}/pages/traveller-add.jsp'">--%>
											<%--<i class="fa fa-file-o"></i> 新建--%>
										<%--</button>--%>
										<%--<button type="button" class="btn btn-default" title="开启" onclick="openStatus('${pageContext.request.contextPath}/user/editUserStatusByIds.do')">--%>
											<%--<i class="fa fa-check"></i> 开启--%>
										<%--</button>--%>
										<%--<button type="button" class="btn btn-default" title="删除"  onclick="deleteByIds('${pageContext.request.contextPath}/traveller/deleteByOrdersIds.do')">--%>
											<%--<i class="fa fa-trash-o"></i> 删除--%>
										<%--</button>--%>
										<button type="button" class="btn btn-default" title="刷新" onclick="location.reload()">
											<i class="fa fa-refresh"></i> 刷新
										</button>
										<button type="button" class="btn btn-default" title="搜索" onclick="searchLike()">
											<i class="fa fa-search"></i> 搜索
										</button>
									</div>
								</div>
							</div>
							<div class="box-tools pull-right">
								<div class="has-feedback">
									<input  id="searchText"   type="text" class="form-control input-sm"
										placeholder="按游客姓名搜索"  value="${title}"> <span
										class="glyphicon glyphicon-search form-control-feedback"></span>
								</div>
							</div>
							<!--工具栏/-->

							<!--数据列表-->
							<table id="dataList"
								class="table table-bordered table-striped table-hover dataTable">
								<thead>
									<tr>
										<th class="" style="padding-right: 0px"><input
											id="selall" type="checkbox" class="icheckbox_square-blue">
										</th>
										<th class="sorting_asc">ID</th>
										<th class="sorting_desc">姓名</th>
										<th class="sorting_asc sorting_asc_disabled">性别</th>
										<th class="sorting_desc sorting_desc_disabled">联系电话</th>
										<th class="sorting">游客类型</th>
										<th class="sorting">证件类型</th>
										<th class="sorting">证件号码</th>
										<th class="text-center">操作</th>
									</tr>
								</thead>
								<tbody>

									<c:forEach items="${pageInfo.list}" var="traveller">
										<tr>
											<td><input name="ids" type="checkbox" value="${traveller.id}"></td>
											<td>${traveller.id }</td>
											<td>${traveller.name }</td>
											<td>${traveller.sex }</td>
											<td>${traveller.phoneNum }</td>
											<td>${traveller.travellerTypeStr }</td>
											<td>${traveller.credentialsTypeStr }</td>
											<td>${traveller.credentialsNum }</td>
											<td class="text-center">
												<a href="${pageContext.request.contextPath}/traveller/findById.do?id=${traveller.id}" class="btn bg-olive btn-xs">详情</a>
												<%--<a href="${pageContext.request.contextPath}/traveller/editBeforeById.do?id=${traveller.id}" class="btn bg-olive btn-xs">修改</a>--%>
												<%--<a href="${pageContext.request.contextPath}/traveller/findUserByIdAndAllRole.do?id=${traveller.id}" class="btn bg-olive btn-xs">添加角色</a>--%>
											</td>
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

						</div>
						<!-- 数据表格 /-->

					</div>
					<!-- /.box-body -->
					<!--工具栏-->
					<div class="box-tools text-center">
						<button type="button" class="btn bg-maroon" onclick="save()">保存</button>
						<button type="button" class="btn bg-default"
								onclick="history.back(-1);">返回</button>
					</div>
					<!--工具栏/-->
					</form>

					<!-- .box-footer-->
					<div class="box-footer">
						<div class="pull-left">
							<div class="form-group form-inline">
								<h3>总共${pageInfo.pages} 页，共${pageInfo.total} 条数据。
							</div>
						</div>

						<div class="box-tools pull-right">
							<ul class="pagination">
								<li><a href="${pageContext.request.contextPath}/member/findTravellerByOne.do?id=${member.id}&page=1&size=${pageInfo.pageSize}&title=${title}" aria-label="Previous">首页</a></li>
								<li><a href="${pageContext.request.contextPath}/member/findTravellerByOne.do?id=${member.id}&page=${pageInfo.pageNum - 1}&size=${pageInfo.pageSize}&title=${title}">上一页</a></li>
								<c:forEach begin="1" end="${pageInfo.pages}" var="pageNum">
									<c:if test="${pageInfo.pageNum == pageNum}">
										<li ><a style="background-color: #0d6aad;color: #FFF" href="${pageContext.request.contextPath}/member/findTravellerByOne.do?id=${member.id}&page=${pageNum}&size=${pageInfo.pageSize}&title=${title}">${pageNum}</a></li>
									</c:if>
									<c:if test="${pageInfo.pageNum != pageNum}">
										<li ><a href="${pageContext.request.contextPath}/member/findTravellerByOne.do?id=${member.id}&page=${pageNum}&size=${pageInfo.pageSize}&title=${title}">${pageNum}</a></li>
									</c:if>
								</c:forEach>
								<li><a href="${pageContext.request.contextPath}/member/findTravellerByOne.do?id=${member.id}&page=${pageInfo.pageNum + 1}&size=${pageInfo.pageSize}&title=${title}">下一页</a></li>
								<li><a href="${pageContext.request.contextPath}/member/findTravellerByOne.do?id=${member.id}&page=${pageInfo.pages}&size=${pageInfo.pageSize}&title=${title}" aria-label="Next">尾页</a></li>
							</ul>
						</div>

					</div>
					<!-- /.box-footer-->

				</div>

				</section>
				<!-- 正文区域 /-->

			</div>
			<!-- @@close -->
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
	<script type="text/javascript" src="../js/jsUtils.js"></script>
		<script>

			function save() {
                var ids = document.getElementsByName("ids");
                var a = 0;
                for (i = 0;i<ids.length;i++){
                    //判断是否为选中的
                    if(ids[i].checked){
                        //alert(ids[i].value);
                        a=a+1;
                    }
                };
                if (a != 0){
                    $("#saveButton").submit();
				} else {
                    alert("请选择");
				}
            }

            function searchLike(){
                event.stopPropagation();
                var text = $("#searchText").val();
                location.href="${pageContext.request.contextPath}/member/findTravellerByOne.do?id=${member.id}&size=${pageInfo.pageSize}&title="+text;
            }

            $(function () {
                <%--alert("${pageInfo.pageSize}");--%>
                $("#select").find("option[value='${pageInfo.pageSize}']").attr("selected","selected");
            });

            function changePageSize(){
                var pageSize = $("#select").val();
                location.href="${pageContext.request.contextPath}/traveller/findAll.do?page=1&size="+pageSize;
                //alert(pageSize);
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

			$(document)
					.ready(
							function() {

								// 激活导航位置
								setSidebarActive("admin-datalist");

								// 列表按钮 
								$("#dataList td input[type='checkbox']")
										.iCheck(
												{
													checkboxClass : 'icheckbox_square-blue',
													increaseArea : '20%'
												});
								// 全选操作 
								$("#selall")
										.click(
												function() {
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