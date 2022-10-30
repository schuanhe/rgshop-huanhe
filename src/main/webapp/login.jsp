<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2022/10/29
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="css/login.css">
    <script src="js/jquery-3.6.1.min.js"></script>
</head>
<body>


<div class="content">
    <div class="box">
        <div class="left">
            <img class="login-img" alt="Login" src="images/ydsc.svg"/>
        </div>
        <div class="right">
            <h1 class="title">用户 登录</h1>

            <div class="username">
                <label for="username">用 户 名：</label>
                <input
                        type="text"
                        id="username"
                        name="username"
                        autocomplete="off"
                        placeholder="Username"
                        required="required"
                />
            </div>
            <div class="password">
                <label for="password">密 码：</label>
                <input
                        type="password"
                        id="password"
                        name="password"
                        autocomplete="off"
                        placeholder="Password"
                        required="required"
                />
            </div>
            <button id="login" class="submit">登 录</button>

        </div>
    </div>
</div>


<script>

    $(document).ready(function () {
        $("#login").click(function () {

            if ($("#username").val() === "" || $("#password").val() === "") {
                alert("请填写完整")
            } else {
                $.post("LoginServlet",
                    {
                        username: $("#username").val(),
                        password: $("#password").val()
                    }, function (data, status) {
                        var parseJSON = jQuery.parseJSON(data);//返回的数据
                        if (parseJSON.code) {
                            window.location.replace("AllShangPinServlet");
                        } else {
                            alert(parseJSON.msg);
                        }
                    });
            }

        });
    });
</script>


</body>
</html>
