
【2016-03-30】

【2016-03-29】
【规范说明】
HTTP API规范 v2 ——开发指引
http://redmine.gomeo2omx.cn/projects/craftsmen/wiki/HTTP_API%E8%A7%84%E8%8C%83_v2_%E2%80%94%E2%80%94%E5%BC%80%E5%8F%91%E6%8C%87%E5%BC%95

HTTP API规范 v2
http://redmine.gomeo2omx.cn/projects/meixin/wiki/HTTP_API%E8%A7%84%E8%8C%83_v2

提交代码前的Code Review建议
http://redmine.gomeo2omx.cn/projects/craftsmen/wiki/%E6%8F%90%E4%BA%A4%E4%BB%A3%E7%A0%81%E5%89%8D%E7%9A%84Code_Review%E5%BB%BA%E8%AE%AE


【包说明】
└─cn
    └─com
        └─mx
            └─webapi
                └─common
                    ├─annotation  定义注解，在需要登录的方法上加载@LoggedIn
                    ├─constant  定义常量
                    ├─dubbo 扩展实现dubbo标签，当有beanName一样，type一样，替换，当有beanName一样，type不一样，抛异常
                    ├─exceptions    定义异常类
                    │  └─code
                    ├─filter    PublicParamFilter公参过滤器，在web.xml添加配置
                    ├─model 定义分页参数、公共参数、返回实体
                    ├─service   监测是否登录，request、response处理器类
                    ├─servlet   BaseResource、NotFoundResource,基础资源、无资源定义
                    └─utils 定义常用工具类


