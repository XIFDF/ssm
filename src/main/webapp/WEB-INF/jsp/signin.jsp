<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" import="java.util.*"%>
<%String path = request.getContextPath();%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>登录</title>
    <link href="<%=path%>/static/source/css/signinPage.css" rel='stylesheet' type='text/css' />
</head>

<body>
<form class="log" action="login">
    <h2>用户登录</h2>
    <font color="red">${requestScope.message }</font>
    <section>
        <span class="username">用户名</span>
        <input type="text" required="required" id="loginname" pattern="^[a-zA-Z].*" placeholder="请以英文字母开头" name="loginname">
    </section>
    <section>
        <span class="username">密码</span>
        <input type="password" required="required" id="password" pattern="[a-zA-Z0-9]{8,16}" placeholder="英文或数字 8-16 位" name="password">
    </section>
    <button class="button" type="submit">登录</button>
    <button class="button2" onclick="window.location.href='register'" >注册</button>
</form>
</body>
</html>