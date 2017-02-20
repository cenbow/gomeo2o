
CREATE TABLE `act_account_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `user_name` varchar(32) DEFAULT NULL COMMENT '用户昵称',
  `user_phone` varchar(32) DEFAULT NULL COMMENT '用户手机号',
  `pay_password` varbinary(32) DEFAULT NULL COMMENT '支付密码',
  `account_total` decimal(16,4) DEFAULT '0.0000' COMMENT '账户总额',
  `score_ba` decimal(16,4) DEFAULT '0.0000' COMMENT '账户可用余额',
  `score_fr` decimal(16,4) DEFAULT '0.0000' COMMENT '积分账户冻结',
  `rebate_ba` decimal(16,4) DEFAULT '0.0000' COMMENT '返利总额',
  `rebate_fr` decimal(16,4) DEFAULT '0.0000' COMMENT '返利冻结余额',
  `money_ba` decimal(16,4) DEFAULT '0.0000' COMMENT '现金总额',
  `money_fr` decimal(16,4) DEFAULT '0.0000' COMMENT '现金冻结余额',
  `state` int(11) DEFAULT NULL COMMENT '账户状态 1：启用，0：冻结',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改日期',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账户信息';

CREATE TABLE `act_advance_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `detail_no` varchar(32) DEFAULT NULL COMMENT '流水号',
  `apply_time` timestamp NULL DEFAULT NULL COMMENT '提现申请时间',
  `audit_time` timestamp NULL DEFAULT NULL COMMENT '审核通过时间',
  `accept_time` timestamp NULL DEFAULT NULL COMMENT '提现受理时间',
  `success_time` timestamp NULL DEFAULT NULL COMMENT '提现成功时间',
  `cash_cardnumber` varchar(19) DEFAULT NULL COMMENT '提现帐号（银行卡号）',
  `bank_name` varchar(32) DEFAULT NULL COMMENT '银行名称和支行名称',
  `advance_name` varchar(32) DEFAULT NULL COMMENT '提现人姓名',
  `identity_num` varchar(32) DEFAULT NULL COMMENT '提现人身份证号',
  `advance_value` decimal(16,4) DEFAULT NULL COMMENT '提现金额（单位分）',
  `record_value` decimal(16,4) DEFAULT NULL COMMENT '到账金额（单位分）',
  `cash_fee` decimal(16,4) DEFAULT NULL COMMENT '手续费（单位分）',
  `advance_remark` varchar(500) DEFAULT NULL COMMENT '提现摘要',
  `verify_type` int(11) DEFAULT NULL COMMENT '审核人 1：系统，2：人工',
  `payoff_no` varchar(32) DEFAULT NULL COMMENT '打款凭证号',
  `payoff_time` timestamp NULL DEFAULT NULL COMMENT '打款凭证日期',
  `state` int(11) DEFAULT NULL COMMENT '提现状态 4：提现成功，3：审核成功，2：审核失败，1：待审核，0：提现失败',
  `creator` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改日期',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  `user_op_no` varchar(32) DEFAULT NULL COMMENT '用户操作流水号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账户提现明细';

CREATE TABLE `act_binding_bank_card` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `user_name` varchar(32) DEFAULT NULL COMMENT '用户名称',
  `support_bank_id` bigint(20) DEFAULT NULL COMMENT '支持银行ID',
  `card_no` varchar(32) DEFAULT NULL COMMENT '银行卡号',
  `last_four` varchar(10) DEFAULT NULL COMMENT '银行卡后四位',
  `certificate` varchar(50) DEFAULT NULL COMMENT '身份证号',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改日期',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='绑定银行卡';

CREATE TABLE `act_budget_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `detail_no` varchar(32) DEFAULT NULL COMMENT '流水号',
  `order_no` varchar(32) DEFAULT NULL COMMENT '订单号',
  `budget_no` varchar(32) DEFAULT NULL COMMENT '预算号',
  `card_id` varchar(32) DEFAULT NULL COMMENT '优惠券或返利规则id',
  `budget_time` timestamp NULL DEFAULT NULL COMMENT '预算产生时间',
  `budget_type` int(11) DEFAULT NULL COMMENT '预算类型 1：返利预算，2：优惠券预算',
  `record_value` decimal(16,4) DEFAULT NULL COMMENT '预算入账值',
  `state` int(11) DEFAULT NULL COMMENT '状态 2：已撤销  1：已入账，0：冻结中 ',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改日期',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='预算流水';

CREATE TABLE `act_budget_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `budget_no` varchar(32) DEFAULT NULL COMMENT '预算编号',
  `budget_value` decimal(16,4) DEFAULT NULL COMMENT '预算总额，返利预算总额或优惠券预算总额 ',
  `budget_type` int(11) DEFAULT NULL COMMENT '预算类型 1：返利预算，2：优惠券预算',
  `start_time` timestamp NULL DEFAULT NULL COMMENT '预算开始时间',
  `end_time` timestamp NULL DEFAULT NULL COMMENT '预算有效期截止时间',
  `market_limit` varchar(500) DEFAULT NULL COMMENT '二级品类品牌限制',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `state` int(11) DEFAULT NULL COMMENT '状态 1：可用，2：禁用',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改日期',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='预算信息';

CREATE TABLE `act_budget_total` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `budget_no` varchar(32) DEFAULT NULL COMMENT '预算号',
  `market_limit` varchar(32) DEFAULT NULL COMMENT '二级品类类目限制',
  `budget_total` decimal(16,4) DEFAULT '0.0000' COMMENT '预算总额度',
  `budget_ba` decimal(16,4) DEFAULT '0.0000' COMMENT '预算可用额度',
  `budget_fr` decimal(16,4) DEFAULT '0.0000' COMMENT '预算冻结额度',
  `budget_year` varchar(32) DEFAULT NULL,
  `start_time` timestamp NULL DEFAULT NULL COMMENT '预算开始时间',
  `end_time` timestamp NULL DEFAULT NULL COMMENT '预算结束时间',
  `budget_type` int(11) DEFAULT NULL COMMENT '预算类型 1：返利预算，2：优惠券预算',
  `isexcessed` int(11) DEFAULT NULL COMMENT '是否超出预算，1：是，0：否（超出预算90%发出预警？）',
  `state` int(11) DEFAULT NULL COMMENT '状态 1：可用，2：禁用',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改日期',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  `remark` varchar(500) DEFAULT NULL COMMENT '预算备注',
  `vouc_code` varchar(32) DEFAULT NULL COMMENT '预算凭证号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='预算总额';

CREATE TABLE `act_coupon_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `coupon_ecp_id` bigint(20) DEFAULT NULL COMMENT '红包编号',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户编号',
  `detail_no` varchar(32) DEFAULT NULL COMMENT '流水号',
  `order_no` varchar(32) DEFAULT NULL COMMENT '订单号',
  `deal_time` timestamp NULL DEFAULT NULL COMMENT '交易时间',
  `record_time` timestamp NULL DEFAULT NULL COMMENT '红包使用时间',
  `record_value` decimal(16,4) DEFAULT NULL COMMENT '红包金额',
  `state` int(11) DEFAULT NULL COMMENT '交易状态 1：已完成，0：冻结中',
  `remark` varchar(500) DEFAULT NULL COMMENT '红包交易备注',
  `creator` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改日期',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  `coupon_type` int(11) DEFAULT NULL,
  `send_time` timestamp NULL DEFAULT NULL COMMENT '领取时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账户优惠券明细';

CREATE TABLE `act_coupon_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '红包编号',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `shop_id` bigint(20) DEFAULT NULL,
  `coupon_ecp_id` bigint(20) DEFAULT NULL,
  `coupon_type` int(11) DEFAULT NULL COMMENT '红包类型 1：店铺券，2：平台劵',
  `coupon_value` decimal(16,4) DEFAULT NULL COMMENT '红包金额',
  `base_money` decimal(16,4) DEFAULT NULL,
  `send_time` timestamp NULL DEFAULT NULL COMMENT '红包发送时间',
  `end_time` timestamp NULL DEFAULT NULL COMMENT '红包截止时间',
  `state` int(11) DEFAULT NULL COMMENT '红包状态 3：已用 2：可用， 1：冻结，0：已期',
  `remark` varchar(500) DEFAULT NULL COMMENT '红包备注',
  `resource` int(11) DEFAULT NULL COMMENT '红包来源：1:商家店铺，2:平台优惠券',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改日期',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账户优惠券信息';

CREATE TABLE `act_money_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `detail_no` varchar(32) DEFAULT NULL COMMENT '流水号',
  `order_no` varchar(32) DEFAULT NULL COMMENT '订单号',
  `deal_time` timestamp NULL DEFAULT NULL COMMENT '交易日期',
  `record_time` timestamp NULL DEFAULT NULL COMMENT '现金余额到账日期',
  `record_rule` int(11) DEFAULT NULL COMMENT '1：增加，2：减少',
  `record_value` decimal(16,4) DEFAULT NULL COMMENT '具体数值',
  `deal_remark` varchar(500) DEFAULT NULL COMMENT '交易摘要',
  `deal_type` int(11) DEFAULT NULL COMMENT '交易类型，充值，消费，退款，等',
  `state` int(11) DEFAULT NULL COMMENT '现金余额是否已经入账 1：已经入账，0：没有入账',
  `creator` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改日期',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE `act_rebate_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户编号',
  `detail_no` varchar(32) DEFAULT NULL COMMENT '流水号',
  `product_id` bigint(20) DEFAULT NULL COMMENT '商品id',
  `shop_id` bigint(20) DEFAULT NULL COMMENT '商户id',
  `order_no` varchar(32) DEFAULT NULL COMMENT '订单号',
  `deal_time` timestamp NULL DEFAULT NULL COMMENT '交易日期',
  `expect_time` timestamp NULL DEFAULT NULL COMMENT '预计返利时间(订单生成)',
  `record_time` timestamp NULL DEFAULT NULL COMMENT '返利发放时间(妥投+7)',
  `rebate_state` int(11) DEFAULT NULL COMMENT '返利类型：1：平台返利 2：商家返利',
  `merchant_rebate` decimal(16,4) DEFAULT NULL COMMENT '商家返利金额',
  `platform_rebate` decimal(16,4) DEFAULT NULL COMMENT '平台返利金额',
  `record_value` decimal(16,4) DEFAULT NULL COMMENT '出/入账值',
  `record_rule` int(11) DEFAULT NULL COMMENT '1：增加，2：减少',
  `deal_remark` varchar(500) DEFAULT NULL COMMENT '交易摘要',
  `deal_type` int(11) DEFAULT NULL COMMENT '交易类型  1:返利 2:消费 3:退款退还 4:冻结  5：解冻 ',
  `state` int(11) DEFAULT NULL COMMENT '返利金额是否已经入账 1：已经入账，0：没有入账',
  `creator` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改日期',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账户返利明细';

CREATE TABLE `act_score_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `config_name` varchar(32) DEFAULT NULL,
  `state` int(11) DEFAULT NULL COMMENT '是否已经执行  1：已经执行  0：未执行',
  `reset_time` timestamp NULL DEFAULT NULL COMMENT '积分清零时间',
  `reset_rule` int(11) DEFAULT NULL COMMENT '减掉固定值或者减掉百分百',
  `reset_value` double DEFAULT NULL COMMENT '具体的值',
  `is_mail` int(11) DEFAULT NULL COMMENT '是否邮件通知 1:是 0:否',
  `is_sms` int(11) DEFAULT NULL COMMENT '是否短信通知 1:是 0:否',
  `is_system` int(11) DEFAULT NULL COMMENT '是否系统消息通知 1:是 0:否',
  `notice_one` timestamp NULL DEFAULT NULL COMMENT '第一次通知时间',
  `notice_two` timestamp NULL DEFAULT NULL COMMENT '第二次通知时间',
  `is_enable` int(11) DEFAULT NULL COMMENT '是否启用 1：启用 0 未启用',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改日期',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='积分配置';

CREATE TABLE `act_score_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `detail_no` varchar(32) DEFAULT NULL COMMENT '流水号',
  `order_no` varchar(32) DEFAULT NULL COMMENT '订单号',
  `product_id` bigint(20) DEFAULT NULL COMMENT '商品编号',
  `deal_time` timestamp NULL DEFAULT NULL COMMENT '交易日期',
  `record_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '账户积分到账日期',
  `deal_remark` varchar(500) DEFAULT NULL COMMENT '积分交易备注',
  `deal_type` int(11) DEFAULT NULL COMMENT '交易类型 5：分享返积分，4：邀请注册返积分，3：订单成功返积分，2：评价晒单返积分，1：意见反馈返积分，0：积分兑换',
  `record_value` int(11) DEFAULT NULL COMMENT '交易积分的具体数值',
  `state` int(11) DEFAULT NULL COMMENT '账户积分是否已经入账 1：已经入账，0：没有入账',
  `creator` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改日期',
  `point_id` bigint(20) DEFAULT NULL COMMENT '积分埋点ID',
  `rule_id` bigint(20) DEFAULT NULL COMMENT '积分规则ID',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账户积分明细';

CREATE TABLE `act_score_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '积分i信息ID',
  `count` int(11) DEFAULT NULL COMMENT '可用积分',
  `fr_count` int(11) DEFAULT NULL COMMENT '冻结积分',
  `deal_time` timestamp NULL DEFAULT NULL COMMENT '交易日期',
  `state` int(11) DEFAULT NULL COMMENT '积分状态：1：可用，0，冻结',
  `user_id` bigint(20) DEFAULT NULL COMMENT '积分用户id',
  `total_count` int(11) DEFAULT NULL COMMENT '累计积分',
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='积分信息';

CREATE TABLE `act_score_point` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(32) DEFAULT NULL COMMENT '积分埋点编号',
  `name` varchar(100) DEFAULT NULL COMMENT '积分埋点名称',
  `rule_id` int(11) DEFAULT NULL COMMENT '积分埋点所对应的积分规则id',
  `is_enable` int(11) DEFAULT NULL COMMENT '是否启用积分埋点',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `creator` varchar(32) DEFAULT NULL COMMENT '创建人',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='积分埋点';

CREATE TABLE `act_score_re_day` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `record_date` varchar(12) DEFAULT NULL COMMENT '年月日  yyyy-MM-dd',
  `rule_id` bigint(20) DEFAULT NULL COMMENT '规格ID',
  `day_top` int(11) DEFAULT NULL COMMENT '日积分上限余额',
  `version` int(11) DEFAULT NULL COMMENT '版本',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='日积分上限余额';

CREATE TABLE `act_score_re_single` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `record_date` varchar(12) DEFAULT NULL COMMENT '日期',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `rule_id` bigint(20) DEFAULT NULL COMMENT '规格id',
  `single_top` int(11) DEFAULT NULL COMMENT '人/日积分上限余额',
  `version` int(11) DEFAULT NULL COMMENT '版本',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `act_score_re_total` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `rule_id` bigint(20) DEFAULT NULL COMMENT '规格ID',
  `total_top` int(11) DEFAULT NULL COMMENT '积分总上限余额',
  `version` int(11) DEFAULT NULL COMMENT '版本',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='总积分上限余额';

CREATE TABLE `act_score_rule` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `rule_name` varchar(32) DEFAULT NULL COMMENT '积分规则名称',
  `rule_state` int(11) DEFAULT NULL COMMENT '1：按次分享返积分， 2：按比例返积分 ，3：阶梯式满返积分',
  `record_value` varchar(32) DEFAULT NULL COMMENT '返积分数值',
  `record_time_str` int(11) DEFAULT NULL COMMENT '多少天之后返积分',
  `record_time` timestamp  DEFAULT NULL COMMENT '返积分时间点',
  `start_time` timestamp  DEFAULT NULL COMMENT '预算开始时间',
  `end_time` timestamp  DEFAULT NULL COMMENT '预算结束时间',
  `day_top` int(11) DEFAULT NULL COMMENT '每天获取积分上限',
  `total_top` int(11) DEFAULT NULL COMMENT '总获取积分上限',
  `single_top` int(11) DEFAULT NULL COMMENT '每人每天获取积分上限',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='积分规则';

CREATE TABLE `act_support_bank` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `bank_no` varchar(32) DEFAULT NULL COMMENT '银行编码',
  `bank_name` varchar(32) DEFAULT NULL COMMENT '银行名',
  `bank_logo` varchar(100) DEFAULT NULL COMMENT '银行logo',
  `card_type` int(11) DEFAULT NULL COMMENT '银行卡类型',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改日期',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='支持银行';

