<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" import="java.util.*"%>
<%String path = request.getContextPath();%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>注册</title>
    <link href="<%=path%>/static/source/css/registerPage.css" rel='stylesheet' type='text/css' />
</head>

<body>
<form class="reg" action="registerprocess">
    <h2>用户注册</h2>
    <font color="red">${requestScope.message }</font>
    <section>
        <span class="username">用户名</span>
        <input type="text" required="required" name="regname" pattern="^[a-zA-Z].*" placeholder="请以英文字母开头">
    </section>
    <section>
        <span class="username">密码</span>
        <input type="password" required="required" name="password" pattern="[a-zA-Z0-9]{8,16}" placeholder="英文或数字 8-16 位">
    </section>
    <section>
        <span class="username">邮箱</span>
        <input type="email" required="required" name="email" placeholder="邮箱">
    </section>
    <section>
        <span class="username">性别</span>
        <input type="radio" value="man" name="sex" checked> 男
        <input type="radio" value="woman" name="sex"> 女
    </section>
    <section>
        <span class="username">电话</span>
        <input type="tel" required="required" name="tel" pattern="^1[34578][0-9]{9}$" placeholder="电话">
    </section>
    <button class="button" type="submit">注册</button>
</form>
</body>
</html>