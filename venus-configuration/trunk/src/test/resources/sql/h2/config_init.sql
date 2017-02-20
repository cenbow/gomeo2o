
-- 支付各种配置

INSERT INTO `ecp_configs` (`key`, `value`,  `description`, `created_at`, `updated_at`)
VALUES ('alipay.pid', '2088901984370000', '支付宝合作伙伴id', now(), now());
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('alipay.key', 'todo', '支付宝密钥', now(), now());
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('alipay.account', 'todo', '支付宝账户（邮箱）', now(), now());
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('alipay.gateway', 'http://www.estate.com/api/mock/gateway', '支付宝网关', now(), now());
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('pay.notify.url', 'http://www.estate.com/api/alipay/notify', '支付后台通知地址', now(), now());
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('pay.return.url', 'http://www.estate.com/buyer/trade-success', '支付前台宝通知地址', now(), now());
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('alipay.refund.notify.url', 'http://www.estate.com/api/alipay/refund/notify', '支付退款后台宝通知地址', now(), now());

-- 短信相关配置
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('emay.account', '0SDK-EAA-6688-JEQST', '亿美短信网关账户', now(), now());
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('emay.password', '545642', '亿美短信网关密码', now(), now());
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('emay.register.url', 'http://sdk4report.eucp.b2m.cn:8080/sdkproxy/regist.action', '亿美短信网关注册地址', now(), now());
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('emay.send.url', 'http://sdk4report.eucp.b2m.cn:8080/sdkproxy/sendsms.action', '亿美短信网关发送地址', now(), now());
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('emay.query.url', 'http://sdk4report.eucp.b2m.cn:8080/sdkproxy/querybalance.action', '亿美短信网关查询地址', now(), now());

INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('cns.account', 'daqihui', '企信通短信网关账户', now(), now());
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('cns.password', 'daqihui2015', '企信通短信网关密码', now(), now());
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('cns.send.url', 'http://116.255.193.72:88/WebAPI/SmsAPI.asmx/SendSmsExt', '企信通短信网关发送地址', now(), now());
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('cns.query.url', 'http://116.255.193.72:88/WebAPI/SmsAPI.asmx/GetBalance', '企信通短信网关余额查询地址', now(), now());

-- 微信支付配置
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('wechat.public.name', '电商平台', '公众号名称', now(), now());
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('wechat.token', 'terminus', '公众号凭证', now(), now());
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('wechat.app.id', 'todo', '公众号id', now(), now());
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('wechat.mch.id', '12345', '公众号商户id', now(), now());
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('wechat.secret', 'todo', '公众号密钥', now(), now());
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('wechat.paterner.key', 'todo', '公众号合作伙伴密钥', now(), now());
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('wechat.image.base.url', 'todo', '微信二维码图片地址', now(), now());


INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('fuli.affixcode', 'todo', '海尔福利短信网关code', now(), now());
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('fuli.gateway', 'todo', '海尔福利短信网关地址', now(), now());


INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('sms.sign.prefix', '【端点科技】', '短信请求签名', now(), now());

INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('mode', 'dev', '模式', now(), now());

-- 邮件相关配置
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('email.bind.url', '/api/user/ebv', '邮箱绑定', now(), now());
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('email.verify.url', '/verify', '验证绑定', now(), now());
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('email.found.url', '/api/user/to_reset_password', '找回密码', now(), now());
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('email.verify.expire', '3600', '验证链接过期时间', now(), now());

INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('email.port', '465', '邮件发送网关端口', now(), now());
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('email.host', 'smtp.exmail.qq.com', '邮件发送地址', now(), now());
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('email.account', 'no-reply@terminus.io', '邮箱账号', now(), now());
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('email.password', 'hello1234', '邮箱密码', now(), now());
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('email.protocol', '1', '协议', now(), now());

-- 快捷通各种配置
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('kjtpay.pid', '200000055212', '快捷通商户号', now(), now());
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('kjtpay.pfx.path', '/Users/songrenfei/Downloads/test8.pfx', '快捷通pfx证书路径', now(), now());
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('kjtpay.password', '123456', '快捷通账户密码', now(), now());
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('kjtpay.gateway', 'http://www.estate.com/api/kjtpay/mock/gateway', '快捷通网关', now(), now());
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('kjtpay.cvm.path', '/Users/songrenfei/Downloads/CVM/cvm.xml', '快捷通cvm文件路径', now(), now());
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('kjtpay.cer.path', '/Users/songrenfei/Downloads/lst.cer', '快捷通cer文件路径', now(), now());
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('kjtpay.pay.notify', 'http://www.estate.com/api/estate/kjtpay/notify', '快捷通支付异步通知', now(), now());
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('kjtpay.pay.return.url', 'http://www.estate.com/buyer/trade-success', '快捷通支付同步通知', now(), now());
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('kjtpay.account', 'test8@kjtpay.com.cn', '快捷通账户', now(), now());
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('kjtpay.refund.notify', 'http://www.estate.com/api/estate/kjtpay/refund/notify', '快捷通退款异步通知', now(), now());
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('kjtpay.trans.notify', 'http://www.estate.com/api/estate/kjtpay/transfer/notify', '快捷通转账异步通知', now(), now());

-- 海尔key
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('haier.key', 'bUo8rvGoPDcetkBRXwJCQsQLqnZ2GKnf', '海尔key', now(), now());


-- Email
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('email.bind.url', '/api/user/ebv', '邮箱绑定', now(), now());
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('email.verify.url', '/verify', '验证绑定', now(), now());
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('email.found.url', '/api/user/to_reset_password', '找回密码', now(), now());
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('email.verify.expire', '3600', '验证链接过期时间', now(), now());
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('email.port', '465', '邮件发送网关端口', now(), now());
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('email.account', 'no-reply@terminus.io', '邮箱账号', now(), now());
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('email.password', 'hello1234', '邮箱密码', now(), now());
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('email.protocol', '1', '协议', now(), now());


-- 第三方佣金最高手续费
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('the.max.commission.rate', '0.025', '最高佣金费率', now(), now());


-- 增加图片服务配置
-- UPYUN
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('image.cur.server', 'upyun', '协议', now(), now());
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('image.base.url', 'http://showcase.b0.upaiyun.com', '图片链接主体', now(), now());
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('image.max.size', '1048578', '图片链接主体', now(), now());
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('image.upyun.folder', 'showcase', 'UpYun空间名称', now(), now());
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('image.upyun.user', 'showcase', 'UpYun操作员名称', now(), now());
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('image.upyun.password', 'showcase', 'UpYun密码', now(), now());

-- LOCAL
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('image.local.folder', '/var/data/image', '本地存储路径', now(), now());


-- 增加结算业务场景
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('settle.business.type', '1', '业务场景1 代理商抽佣从平台抽佣中进行二次抽佣，平台抽佣参与商家收入，代理商抽佣不参与商家收入 业务场景2 代理商抽佣从订单金额中进行抽佣，代理商抽佣参与商家收入（平台抽佣是否存在要根据实际业务需求）', now(), now());


-- 敏感词过滤
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('bad.word.main', 'dic/main.dic', '词语', now(), now());
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('bad.word.suffix', 'dic/suffix.dic', '单词', now(), now());
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('bad.word.dic', 'dic/badword.dic', '敏感词', now(), now());


-- 增加结算模块是否是测试开关
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('settle.environment.type', '0', '1代表正式环境，0代表测试环境', now(), now());

-- 售后
INSERT INTO `ecp_configs` (`key`, `value`, `description`, `created_at`, `updated_at`)
VALUES ('trade.after.sale.days', '15', '售后多少天', now(), now());





