<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" import="java.util.*"%>
<%String path = request.getContextPath();%>

<!DOCTYPE html>
<script src="http://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
<link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="http://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>bootstrap</title>
</head>
<body>

  <h1>${requestScope.message}</h1>
  <h1>Hello World!</h1>
  <button class="btn btn-success">测试按钮</button>

</body>
</html>