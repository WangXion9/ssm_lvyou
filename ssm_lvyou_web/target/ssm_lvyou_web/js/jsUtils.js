function openStatus(url) {
    var ids = document.getElementsByName("ids");
    var a = 0;
    var str = "";
    var str1 = "";
    for (i = 0;i<ids.length;i++){
        //判断是否为选中的
        if(ids[i].checked){
            //alert(ids[i].value);
            a=a+1;
            str+="id="+ids[i].value+"&";
            str1+=ids[i].value+",\n";
        }
    };
    //去掉字符串末尾的‘&’
    str=str.substring(0, str.length-1);
    str1=str1.substring(0, str1.length-2);
    //alert(str);
    if (a == 0){
        alert("没有选中！");
    } else {
        if(window.confirm('确定开启id为：\n'+str1)){
            //alert("确定");
            location.href=url+"?ids="+str1;
            //return true;
        }
    }
}

function deleteByIds(url) {
    //alert("你好");
    var ids = document.getElementsByName("ids");
    var a = 0;
    var str = "";
    var str1 = "";
    for (i = 0;i<ids.length;i++){
        //判断是否为选中的删除
        if(ids[i].checked){
            //alert(ids[i].value);
            a=a+1;
            str+="id="+ids[i].value+"&";
            str1+=ids[i].value+",";
        }
    };
    //去掉字符串末尾的‘&’
    str=str.substring(0, str.length-1);
    str1=str1.substring(0, str1.length-1);
    //alert(str);
    if (a == 0){
        alert("没有选中！");
    }else {
        if(window.confirm('确定删除id为：'+str1)){
            //alert("确定");
            location.href=url+"?ids="+str1;
            //return true;
        }
    }
}

function shutStatus(url) {
    //alert("你好");
    var ids = document.getElementsByName("ids");
    var a = 0;
    var str = "";
    var str1 = "";
    for (i = 0;i<ids.length;i++){
        //判断是否为选中的删除
        if(ids[i].checked){
            //alert(ids[i].value);
            a=a+1;
            str+="id="+ids[i].value+"&";
            str1+=ids[i].value+",";
        }
    };
    //去掉字符串末尾的‘&’
    str=str.substring(0, str.length-1);
    str1=str1.substring(0, str1.length-1);
    //alert(str);
    if (a == 0){
        alert("没有选中！");
    }else {
        if(window.confirm('确定关闭id为：'+str1)){
            //alert("确定");
            location.href=url+"?ids="+str1;
            //return true;
        }
    }
}