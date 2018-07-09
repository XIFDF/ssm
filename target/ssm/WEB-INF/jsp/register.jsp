<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" import="java.util.*"%>
<%String path = request.getContextPath();%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>注册</title>
    <link rel="stylesheet" href="<%=path%>/static/source/css/amazeui.min.css" />
    <link rel="stylesheet" href="<%=path%>/static/source/css/amazeui.datatables.min.css" />
    <link rel="stylesheet" href="<%=path%>/static/source/css/app.css">
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
            <div class="tpl-login-title">注册用户</div>
            <span class="tpl-login-content-info">
                  创建一个新的用户
              </span>


            <form id="register-form" class="am-form tpl-form-line-form">
                <div class="am-form-group">
                    <input type="text" class="tpl-form-input" id="email" placeholder="邮箱">

                </div>

                <div class="am-form-group">
                    <input type="text" class="tpl-form-input" id="username" placeholder="用户名">
                </div>

                <div class="am-form-group">
                    <input type="password" class="tpl-form-input" id="password" placeholder="请输入密码">
                </div>

                <div class="am-form-group">
                    <input type="password" class="tpl-form-input" id="cpassword" placeholder="再次输入密码">
                </div>

                <div class="am-form-group tpl-login-remember-me">
                    <input id="remember-me" type="checkbox">
                    <label for="remember-me">

                        我已阅读并同意 <a href="javascript:;">《用户注册协议》</a>
                    </label>

                </div>

                <div class="am-form-group">

                    <button type="button" class="am-btn am-btn-primary  am-btn-block tpl-btn-bg-color-success  tpl-login-btn">提交</button>

                </div>
            </form>
        </div>
    </div>
</div>
<script src="assets/js/amazeui.min.js"></script>
<script src="assets/js/app.js"></script>

</body>

</html>