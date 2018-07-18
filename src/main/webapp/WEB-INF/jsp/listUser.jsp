<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
   pageEncoding="utf-8" import="java.util.*" %>

<html>
<head>
    <meta charset="utf-8">
    <title>用户管理</title>
</head>
<body>
    <div style="width:500px;margin:0px auto;text-align:center">
        <table id="listtable" align="center" border="1" cellpadding="0">
            <tr>
                <td>用户ID</td>
                <td>用户名</td>
                <td>邮箱</td>
                <td>性别</td>
                <td>电话</td>
                <td>编辑</td>
                <td>删除</td>
            </tr>

            <c:forEach items="${users}" var="c" varStatus="ct">
             <tr>
                 <td>${c.id}</td>
                 <td>${c.name}</td>
                 <td>${c.email}</td>
                 <td>${c.sex}</td>
                 <td>${c.tel}</td>
                 <td><button id="${ct.index}update" onclick="updateclick(this)">编辑</button></td>
                 <td><button id="${ct.index}delete" onclick="deleteclick(this)">删除</button></td>
             </tr>
            </c:forEach>
        </table>
        <button id="addbtn" onclick="addclick()">添加用户</button>
        <div style="text-align:center">
            <a href="?start=0">首  页</a>
            <c:if test="${page.start-page.count >= 0}">
                <a href="?start=${page.start-page.count}">上一页</a>
            </c:if>

            <c:if test="${page.start+page.count <= page.last}">
                <a href="?start=${page.start+page.count}">下一页</a>
            </c:if>
            <a href="?start=${page.last}">末  页</a>
        </div>
    </div>
    <div style="text-align: center">
        <form method="post" action="getuserbyname">
            <br>按照用户名查询
            <input name="name" type="text" placeholder="请输入要查询的用户名">
            <button type="submit">查询</button>
        </form>
    </div>
    <div id="edit" style="display: none; text-align: center">
        <form method="post" action="updateuser">
            <h3 id="h3"></h3>
            <input name="id" type="number" id="editid" style="display: none"/>
            用户名<input name="name" type="text" id="editname" placeholder="请输入修改后的用户名"><br>
            邮  箱<input name="email" type="text" id="editemail" placeholder="请输入修改后的邮箱"><br>
            性  别<input name="sex" type="text" id="editsex" placeholder="请输入修改后的性别"><br>
            电  话<input name="tel" type="text" id="edittel" placeholder="请输入修改后的电话"><br>
            <button type="submit">提交</button>
        </form>
    </div>
    <div id="adduser" style="display: none; text-align: center">
        <form method="post" action="adduser">
            ID<input name="id" type="number" value= id="addid""/><br>
            用户名<input name="name" type="text" id="addname" placeholder="添加的用户名" required="required"><br>
            邮  箱<input name="email" type="text" id="addemail" placeholder="新用户的邮箱" required="required"><br>
            性  别<input name="sex" type="text" id="addsex" placeholder="新用户的性别" required="required"><br>
            电  话<input name="tel" type="text" id="addtel" placeholder="新用户的电话" required="required"><br>
            <button type="submit">添加</button>
        </form>
    </div>
</body>
</html>

<script type="text/javascript">
    function updateclick(a){
        var table = document.getElementById("listtable");
        var row = table.getElementsByTagName("tr")[parseInt(a.id) + 1];
        var col = row.getElementsByTagName("td");

        document.getElementById("editid").value = col[0].innerHTML;
        document.getElementById("editname").value = col[1].innerHTML;
        document.getElementById("editemail").value = col[2].innerHTML;
        document.getElementById("editsex").value = col[3].innerHTML;
        document.getElementById("edittel").value = col[4].innerHTML;

        var obj = document.getElementById("edit");
        document.getElementById("h3").innerHTML = "当前更改的用户ID: "+col[0].innerHTML;
        obj.style.display = "";
    }
    function deleteclick(a) {
        var table = document.getElementById("listtable");
        var row = table.getElementsByTagName("tr")[parseInt(a.id) + 1];
        var col = row.getElementsByTagName("td");

        var input = document.createElement("input");
        input.type = "hidden";
        input.name = "id";
        input.value = col[0].innerHTML;
        var deleteform = document.createElement("form");
        document.body.appendChild(deleteform);
        deleteform.appendChild(input);
        deleteform.method = "post";
        deleteform.action = "deleteuser";
        deleteform.submit();
    }
    function addclick() {
        var obj = document.getElementById("adduser");
        obj.style.display = "";
    }
</script>