# Java Web学习项目(SSM)
## 概况：
以用户管理为基本需求，实现SSM开发框架的各方面内容，包括：
* [Maven在IDEA上的设置](#Maven在IDEA上的设置)
* [利用Maven管理工具，创建项目的基本目录以及管理所用到的依赖包](#3)
* [Tomcat在IDEA上的设置](#Tomcat在IDEA上的设置)
* [SSM开发框架的基本配置](#SSM开发框架的基本配置)
* [持久层mapper(一对多，多对一，多对多 例子)，业务层service，控制层controller的编写](#持久层mapper，业务层service，控制层controller的编写)
* [使用HTML5，JavaScript，CSS编写前端页面，编写jsp页面](#使用HTML5，JavaScript，CSS编写前端页面，编写jsp页面)
* [运用jQuery-AJAX实现数据的提交和获取(前后端分离)](#运用jQuery-AJAX实现数据的提交和获取(前后端分离))
## 开发环境
* windows10 操作系统，JDK1.8
* IDEA + Tomcat + maven
* Spring+SpringMVC+Mybatis
* MySQL5.7
## 基本功能
在页面上能够对用户的数据进行快速的CRUD
## Maven在IDEA上的设置
Maven简介：Maven是一个项目管理和综合工具，它能够快速而系统地帮助开发者构建项目。<br>
在本项目中，Maven的主要的功能是：
* 创建Web项目目录(由Maven创建能实现项目目录结构的统一性)
* 管理项目所依赖的jar包<br><br>
安装好Maven以及配置完相关环境变量和仓库下载路径后<br>
在IDEA File | Settings | Build, Execution, Deployment | Build Tools | Maven 中<br>
设置好 Maven home directory 和 User settings file
## <h2 id="3">利用Maven管理工具，创建项目的基本目录以及管理所用到的依赖包</h2>
在IDEA的New Project中，选择左侧菜单的Maven。然后选中Create from archetype<br>
找到org.apache.maven.archetypes:maven-archetype-webapp<br>
然后按照设置提示进行创建，创建结束后在main目录下新建一个名称为java目录，并将此目录设置为源代码目录<br>
### 目录以及文件简介
java目录:源代码目录，包含着持久层mapper，业务层service，控制层controller的内容<br>
resources目录：存放Spring的配置<br>
static目录：存放CSS和js文件，以及一些图片<br>
WEB-INF目录：存放HTML页面和jsp页面<br>
#### pom.xml
此文件为Maven的配置文件，当我们需要添加jar包或者为项目添加其他因素的时候，就会在此文件进行配置<br>
添加项目依赖的jar包：在 dependencies 中添加 dependency <br>
依赖包的相关属性可以通过搜索引擎获取；添加后，它们将会从仓库中自动下载<br>
#### web.xml
此文件为web应用配置文件(Web应用发布描述符文件)，作用：<br>
配置Servlet映射，配置过滤器，指向contextConfigLocation配置文件的文件名，配合Spring的初始化<br>
## Tomcat在IDEA上的设置
点击Run-Edit Configurations，点击左侧“+”，选择Tomcat Server - Local。在Tomcat Server -> Unnamed -> Server -> Application server项目下，点击 Configuration ，找到本地 Tomcat 服务器，再点击 OK按钮。
## SSM开发框架的基本配置
### web.xml(部分内容)
```xml
  <!-- spring的配置文件-->
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath:applicationContext.xml</param-value>
    </context-param>
    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>
     
   <!-- spring mvc核心：分发servlet -->
    <servlet>
        <servlet-name>mvc-dispatcher</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
   <!-- spring mvc的配置文件 -->
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:spring-mvc.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
        <servlet-name>mvc-dispatcher</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
```
### applicationContext.xml(部分内容)
```xml
  <context:annotation-config />
	<context:component-scan base-package="com.xifdf.service" />

	<!--连接池-->
	<bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource" init-method="init" destroy-method="close">
		<!-- 基本属性 url、user、password -->
		<property name="url" value="jdbc:mysql://localhost:3306/mydatabase?characterEncoding=UTF-8" />
		<property name="username" value="root" />
		<property name="password" value="1234" />
		<property name="driverClassName" value="com.mysql.jdbc.Driver" />

		<!-- 配置初始化大小、最小、最大 -->
		<property name="initialSize" value="3" />
		<property name="minIdle" value="3" />
		<property name="maxActive" value="20" />

		<!-- 配置获取连接等待超时的时间 -->
		<property name="maxWait" value="60000" />

		<!-- 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒 -->
		<property name="timeBetweenEvictionRunsMillis" value="60000" />

		<!-- 配置一个连接在池中最小生存的时间，单位是毫秒 -->
		<property name="minEvictableIdleTimeMillis" value="300000" />

		<property name="validationQuery" value="SELECT 1" />
		<property name="testWhileIdle" value="true" />
		<property name="testOnBorrow" value="false" />
		<property name="testOnReturn" value="false" />

		<!-- 打开PSCache，并且指定每个连接上PSCache的大小 -->
		<property name="poolPreparedStatements" value="true" />
		<property name="maxPoolPreparedStatementPerConnectionSize" value="20" />
	</bean>
	
  <!--扫描存放SQL语句的User.xml-->
	<bean id="sqlSession" class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="typeAliasesPackage" value="com.xifdf.pojo" />
		<property name="dataSource" ref="dataSource"/>
		<property name="mapperLocations" value="classpath:com/xifdf/mapper/*.xml"/>
		<property name="plugins">
		    <array>
		      <bean class="com.github.pagehelper.PageInterceptor">
		        <property name="properties">
		          <!--使用下面的方式配置参数，一行配置一个 -->
		          <value>
		          </value>
		        </property>
		      </bean>
		    </array>
		  </property>		
	</bean>

  <!--扫描Mapper，并将其生命周期纳入Spring的管理-->
	<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
		<property name="basePackage" value="com.xifdf.mapper"/>
	</bean>

	<tx:annotation-driven transaction-manager="transactionManager"/>
	<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
		<property name="dataSource" ref="dataSource" />
	</bean>
```
注意，在连接池配置中，应该包含了目标数据库的路径和相关配置信息。
## 持久层mapper，业务层service，控制层controller的编写
### 持久层mapper

## 使用HTML5，JavaScript，CSS编写前端页面，编写jsp页面
listUser.jsp  用户管理页面，包含了对用户的增删改查的功能 <br>
以编辑功能为例，以下为编辑按钮点击的js函数
```html
<script type="text/javascript">
    function updateclick(a){
        //选中点击的行的元素
        var table = document.getElementById("listtable");
        var row = table.getElementsByTagName("tr")[parseInt(a.id) + 1];
        var col = row.getElementsByTagName("td");
        //将改行的数据填充到编辑页面中，方便编辑数据
        document.getElementById("editid").value = col[0].innerHTML;
        document.getElementById("editname").value = col[1].innerHTML;
        document.getElementById("editemail").value = col[2].innerHTML;
        document.getElementById("editsex").value = col[3].innerHTML;
        document.getElementById("edittel").value = col[4].innerHTML;
        //提示当前编辑的用户ID，并显示编辑界面
        var obj = document.getElementById("edit");
        document.getElementById("h3").innerHTML = "当前更改的用户ID: "+col[0].innerHTML;
        obj.style.display = "";
    }
</script>
```
编辑按钮点击后显示的部分，主要为提交数据更新的表单
```html
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
```
## 运用jQuery-AJAX实现数据的提交和获取(前后端分离)
首先我们需要利用jQuery来提高我们编写AJAX的效率
```html
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js">
```
### 提交
添加HTML5代码供用户输入
```html
<div>
    id:<input type="number" id="id"/><br>
    姓名:<input type="text" id="name" value="testName"/><br>
    邮箱:<input type="text" id="email" value="testEmail"/><br>
    性别:<input type="text" id="sex" value="testSex"/><br>
    电话:<input type="text" id="tel" value="testTel"/><br>
    <input type="button" id="sender" value="提交">
</div>
```
用JavaScript获取用户输入，然后用$.ajax方法实现AJAX提交数据
```html
<script>
    $("#sender").click(function () {
    //从文本输入框中获取数据并转换为一个 JSON字符串
        var id = Number(document.getElementById('id').value);
        var name = document.getElementById('name').value;
        var email = document.getElementById('email').value;
        var sex = document.getElementById('sex').value;
        var tel = document.getElementById('tel').value;
        var user = {"id":id, "name":name, "email":email, "sex":sex, "tel":tel};
        var jsonData = JSON.stringify(user);
        var url="submitUser";   //此处submitUser字符串对应controller中@RequestMapping("/submitUser")
    //调用函数
        $.ajax({
            type : "POST",
            url : url,
            data : jsonData,
            dataType : "json",
            contentType : "application/json;charset=UTF-8",
            success: function(result){
            }
        });
        alert("提交成功，请在Tomcat控制台查看服务端接收到的数据");
    });
</script>
```
在controller中处理接受到的数据并显示到控制台上(UserController.java)
```java
@ResponseBody
@RequestMapping("/submitUser")
    public String submitUser(@RequestBody User user) {
        System.out.println("SSM接受到浏览器提交的json，并转换为User对象:" + user);
        return "ok";
    }
```
### 获取
```html
<script>
    $('#getuser').click(function(){
        var url="getManyUser";
        $.post(
            url,
            function(data) {
                console.log(data);
                var users = $.parseJSON(data);
                console.log(users.length);

                for(i in users){
                    var old = $("#messageDiv").html();
                    var user = users[i];
                    $("#messageDiv").html(old
                        + "<br>"+user.id+"-----"+user.name
                        +"---" + user.email + "---" + user.sex
                        +"---" + user.tel);
                }
            });
    });
</script>
```
	
