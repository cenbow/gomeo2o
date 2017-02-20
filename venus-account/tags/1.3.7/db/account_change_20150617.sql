ALTER TABLE `act_coupon_info` ADD COLUMN `base_money`  decimal(16,4) NULL DEFAULT NULL COMMENT '红包使用订单最低金额' AFTER `coupon_value`;
