# Java Web学习项目(SSM)
## 概况：
以用户管理为基本需求，实现SSM开发框架的各方面内容，包括：
* Maven在IDEA上的设置
* 利用Maven管理工具，创建项目的基本目录以及管理所用到的依赖包
* Tomcat在IDEA上的设置
* SSM开发框架的基本配置
* 持久层mapper，业务层service，控制层controller的编写
* 使用HTML5，JavaScript，CSS编写前端页面，编写jsp页面
* 运用jQuery-AJAX实现数据的提交和获取(前后端分离)
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
## 利用Maven管理工具，创建项目的基本目录以及管理所用到的依赖包
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
添加项目依赖的jar包：在"<dependencies></dependencies>"中添加"<dependency></dependency>"<br>
依赖包的相关属性可以通过搜索引擎获取；添加后，它们将会从仓库中自动下载<br>
#### web.xml
此文件为web应用配置文件(Web应用发布描述符文件)，作用：<br>
配置Servlet映射，配置过滤器，指向contextConfigLocation配置文件的文件名，配合Spring的初始化<br>
