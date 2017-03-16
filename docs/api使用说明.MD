#API文档
#。。。。
####服务启动顺序
--->Eureka--->Proxy---->Es---->OAuth
--->CoreServer---->User--->Customer
--->Message
介绍：
    Eureka： 负责服务注册发现，所有的服务都注册到这里被发现
    Proxy： 相关微服务由代理服务请求转发，转发前由认证授权过程
    Es： 核心数据存储和索引服务
    Oauth： 认证授权服务，这里使用密码模式
    Core： 负责任务调度等底层服务
    User： 用户相关服务
    Customer： 客户相关服务
    Message： 消息服务，邮件，队列推送等
