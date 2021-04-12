function login(form) {
    //校验用户名密码，如果通过表单提交，否则不提交并提示
    if(form.oninvalid){
        alert("用户名为空")
        return false;
    }
    /**
     *
     * ajax请求，需要抓包查看内容：
     * 1.请求：url，method，Content-type（请求数据类型），data（请求数据）
     * 2.响应：status，Content——Type(响应数据类型)，data（相应数据）
     *
     * */
    $.ajax({
        url: "../data/login.ok.json",//静态json文件模拟后端servlet返回
        type: "POST",
        success: function (r) {//r={ok:true}
            if(r.ok){
                //登录操作，用户名密码校验通过
                $("#login_error").hide();
                //相对路径写法，是以引入js的html文件作为相对路径的参照点
                window.location.href = "main.html";
            }else{//r={ok:false,code:xxx,msg:xxx}
                // alert("错误码："+r.code+"\n错误消息："+r.msg)
                $("#login_error").html(r.msg)
                $("#login_error").show();
            }
            // if("a" === r.username && "123" === r.password){
            //     alert("密码正确，登录成功")
            // }
        }
    })
    return false;
//     var xhr = new XMLHttpRequest();
//
//     xhr.onload = function () {
//         // 输出接收到的文字数据
//         alert(xhr.responseText)
//         // document.getElementById("demo").innerHTML=xhr.responseText;
//     }
//
//     xhr.onerror = function () {
//         alert("请求出错")
//         // document.getElementById("demo").innerHTML="请求出错";
//     }
//
// // 发送异步 GET 请求
//     //第三个参数async：是否是发起异步请求
//     xhr.open("POST", "../data/login.ok.json", true);
//     xhr.send();
//     return false;
}