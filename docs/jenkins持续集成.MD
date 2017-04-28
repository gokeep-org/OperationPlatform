#Jenkin持续集成Docker发布微服务
######作者：徐宁
###第一步：安装jenkins
	[jenkins官网](https://jenkins.io/download/)下载相应版本的jenkins版本安装程序，建议脱离tomcat容器能够持久化运行。
###第二步：运行Jenkins程序和安装插件
	这里以一般的微服务举例，按需下载插件
    1：git plugins
    2：maven plugins
    3：默认