<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <!--<link rel="stylesheet" href="/plugins/timepicker/bootstrap-timepicker.min.css">-->
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
    <!--<script src="/plugins/timepicker/bootstrap-timepicker.min.js"></script>-->
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
                游记攻略管理
                <small>游记攻略表单</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="all-admin-index.html"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="all-travellog-manage-list.html">游记攻略管理</a></li>
                <li class="active">游记攻略表单</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域 -->
        <section class="content">

            <div class="box-body">

                <!--tab页-->
                <div class="nav-tabs-custom">

                    <!--tab头-->
                    <ul class="nav nav-tabs">
                        <li class="active">
                            <a href="#tab-form" data-toggle="tab">表单</a>
                        </li>
                    </ul>
                    <!--tab头/-->

                    <!--tab内容-->
                    <div class="tab-content">

                        <form id="save" action="${pageContext.request.contextPath}/diary/editByDiaryId.do" method="post">
                        <!--表单内容-->
                            <input type="hidden" name="id" value="${diary.id}">
                        <div class="tab-pane active" id="tab-form">
                            <div class="row data-type">

                                <div class="col-md-2 title">产品来源</div>
                                <div class="col-md-10 data">
                                    <select id="productId" class="form-control select2 checkProductId" style="width: 100%"
                                            name="product.id">
                                        <option value="" selected="selected">请选择</option>
                                        <c:forEach items="${productList}" var="product">
                                            <option value="${product.id}" >${product.productName}</option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <div class="col-md-2 title">作者</div>
                                <div class="col-md-10 data">
                                    <select id="memberId" class="form-control select2 checkMemberId" style="width: 100%"
                                            name="member.id">
                                        <option value="" selected="selected">请选择</option>
                                        <c:forEach items="${memberList}" var="member">
                                            <option value="${member.id}" >${member.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <div class="col-md-2 title">点赞数</div>
                                <div class="col-md-10 data">
                                    <input type="text" class="form-control checkLike" name="likeCount"
                                           placeholder="点赞数" value="${diary.likeCount}" onblur="checkLike()">
                                </div>

                                <div class="col-md-2 title">收藏数</div>
                                <div class="col-md-10 data">
                                    <input type="text" class="form-control checkCollect" name="collect"
                                           placeholder="收藏数" value="${diary.collect}" onblur="checkCollect()">
                                </div>


                                <div class="col-md-2 title">显示状态</div>
                                <div class="col-md-10 data">
                                    <select id="showStatus" name="showStatus" class="form-control checkShowStatus">
                                        <option value="">请选择</option>
                                        <option value="0">不显示</option>
                                        <option value="1">显示</option>
                                    </select>
                                </div>

                                <div class="col-md-2 title">处理状态</div>
                                <div class="col-md-10 data">
                                <select id="diaryStatus" name="diaryStatus" class="form-control checkDiaryStatus">
                                    <option value="">请选择</option>
                                    <option value="0">未处理</option>
                                    <option value="1">已处理</option>
                                </select>
                                </div>




                            </div>



                            <!--游记-->
                            <div class="panel panel-default">
                                <div class="panel-heading">游记</div>

                                <button type="button" class="btn bg-maroon btn-flat margin" id="btn-dayadd">添加游记</button>

                                <div id="dayslist" class="panel-body">

                                    <div class="box box-success">
                                        <div class="box-header with-border">
                                            <h3 class="box-title">第xx天游记</h3>

                                            <div class="box-tools pull-right">
                                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                            </div>
                                        </div>
                                        <div class="box-body">
                                            <input name="title" type="text" class="form-control checkTitle" placeholder="第xx天游记标题" value="${diary.title}" onblur="checkTitle()"><br>
                                            <textarea name="texts" class="textarea" placeholder="第xx天游记正文" style="width: 100%; height: 265px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;">${diary.texts}</textarea>
                                        </div>
                                    </div>

                                </div>
                            </div>
                            <!--游记/-->


                            <!--工具栏-->
                            <div class="box-tools text-center">
                                <button type="button" class="btn bg-maroon" onclick="saveDiary()">保存</button>
                                <button type="button" class="btn bg-default" onclick="history.back(-1);">返回</button>
                            </div>
                            <!--工具栏/-->



                            <!--游记输入模板-->
                            <div id="day-tpl" style="display:none">
                                <div class="box box-success">
                                    <div class="box-header with-border">
                                        <h3 class="box-title">第xx天游记</h3>

                                        <div class="box-tools pull-right">
                                            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                            <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                        </div>
                                    </div>
                                    <div class="box-body">
                                        <input type="text" class="form-control" placeholder="第xx天游记标题" value=""><br>
                                        <textarea class="" placeholder="第xx天游记正文" style="width: 100%; height: 265px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"></textarea>
                                    </div>
                                </div>
                            </div>
                            <!--游记输入模板/-->
                        </div>
                        <!--表单内容/-->
                        </form>

                    </div>
                    <!--tab内容/-->

                </div>
                <!--tab页/-->


                <!-- .box-footer
    <div class="box-footer"></div>
    -->
                <!-- /.box-footer-->

            </div>

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
    
    $(function () {
        $("#showStatus").find("option[value='${diary.showStatus}']").attr("selected",'selected');
        $("#diaryStatus").find("option[value='${diary.diaryStatus}']").attr("selected",'selected');
        $("#productId").find("option[value='${diary.product.id}']").attr("selected",'selected');
        $("#memberId").find("option[value='${diary.member.id}']").attr("selected",'selected');
    });



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



    // 添加每天的游记
    function addEditer() {
        var dayEditer = $('#day-tpl').html();
        $(".panel-body").append(dayEditer);

        $("#dayslist textarea:last").wysihtml5({
            locale: 'zh-CN'
        });
    }

    $(document).ready(function() {

        $("#btn-dayadd").click(function() {
            addEditer();
        });
    });


    $(document).ready(function() {
        // 激活导航位置
        setSidebarActive("travellog-manage");
    });


    // 校验游记标题  不能为空
    function checkTitle() {
        var username = $(".checkTitle").val();
        if("" == username){
            $(".checkTitle")[0].style.border="2px solid red";
            return false;
        }else {
            var flag;
            $.get({
                url:"${pageContext.request.contextPath}/diary/findDiaryByDiaryTitle.do?id=${diary.id}&name="+username,
                dataType:"json",
                async:false,
                success:function (data) {
                    if (!data ){
                        alert("游记标题已存在！");
                        $(".checkTitle")[0].style.border="2px solid red";
                        flag =  false;
                    }else {
                        $(".checkTitle")[0].style.border="1px solid #d2d6de";
                        flag = true;
                    }
                }
            });
            return flag;
        }
    }

    //验证喜欢数
    function checkLike() {
        var like = $(".checkLike").val();
        var reg = /^\d{1,9}$/;
        if (reg.test(like) == false){
            $(".checkLike")[0].style.border="2px solid red";
            return false;
        }else {
            $(".checkLike")[0].style.border="1px solid #d2d6de";
            return true;
        }
    }

    //验证收藏数
    function checkCollect() {
        var phone = $(".checkCollect").val();
        var reg =  /^\d{1,9}$/;
        if (reg.test(phone) == false){
            $(".checkCollect")[0].style.border="2px solid red";
            return false;
        }else {
            $(".checkCollect")[0].style.border="1px solid #d2d6de";
            return true;
        }
    }

    //检验下拉框
    function checkSelect() {
        var productId = $(".checkProductId").val();
        var memberId = $(".checkMemberId").val();
        var diaryStatus = $(".checkDiaryStatus").val();
        var showStatus = $(".checkShowStatus").val();
        if (productId == "" || memberId == "" || diaryStatus == "" || showStatus == ""){
            return false;
        }else {
            return true;
        }

    }

    function saveDiary(){
        if (checkLike() && checkCollect() && checkTitle() && checkSelect()){
            $("#save").submit();
        } else {
            alert("请表单填写完整");
        }

    }


</script>
</body>

</html>