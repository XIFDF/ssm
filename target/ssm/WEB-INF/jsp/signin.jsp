<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" import="java.util.*"%>
<%String path = request.getContextPath();%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>系统登录</title>
    <link href="<%=path%>/static/source/css/amazeui.min.css" rel='stylesheet' type='text/css' />
    <link href="<%=path%>/static/source/css/amazeui.datatables.min.css" rel='stylesheet' type='text/css' />
    <link href="<%=path%>/static/source/css/app.css" rel='stylesheet' type='text/css' />
    <script src="<%=path%>/static/source/js/amaze/jquery.min.js"></script>

</head>

<body data-type="login">
<script src="<%=path%>/static/source/js/amaze/theme.js"></script>
<div class="am-g tpl-g">
    <!-- 风格切换 -->
    <div class="tpl-skiner">
        <div class="tpl-skiner-toggle am-icon-cog">
        </div>
        <div class="tpl-skiner-content">
            <div class="tpl-skiner-content-title">
                选择主题
            </div>
            <div class="tpl-skiner-content-bar">
                <span class="skiner-color skiner-white" data-color="theme-white"></span>
                <span class="skiner-color skiner-black" data-color="theme-black"></span>
            </div>
        </div>
    </div>
    <div class="tpl-login">
        <div class="tpl-login-content">
            <div class="tpl-login-logo">

            </div>

            <form id="login-form" action="/login" class="am-form tpl-form-line-form">
                <div class="am-form-group">
                    <input type="text" class="tpl-form-input" id="username" placeholder="请输入账号">

                </div>

                <div class="am-form-group">
                    <input type="password" class="tpl-form-input" id="password" placeholder="请输入密码">

                </div>
                <div class="am-form-group tpl-login-remember-me">
                    <input id="remember-me" type="checkbox">
                    <label for="remember-me">

                        记住密码
                    </label>

                </div>

                <div class="am-form-group">

                    <button type="submit" class="am-btn am-btn-primary  am-btn-block tpl-btn-bg-color-success  tpl-login-btn">登录</button>
                    <button type="button" class="am-btn am-btn-primary  am-btn-block tpl-btn-bg-color-success  tpl-login-btn"
                            onclick="window.location.href = 'http://localhost:8080/register'">注册</button>

                </div>
            </form>
        </div>
    </div>
</div>
<script src="<%=path%>/static/source/js/amaze/amazeui.min.js"></script>
<script src="<%=path%>/static/source/js/amaze/app.js"></script>

</body>

</html>