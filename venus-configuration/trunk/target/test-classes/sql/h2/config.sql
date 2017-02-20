DROP TABLE IF EXISTS `ecp_configs`;

CREATE TABLE IF NOT EXISTS `ecp_configs` (
  `id`                 BIGINT        NOT NULL   AUTO_INCREMENT COMMENT '自增主键',
  `key`                VARCHAR(32)   NULL       COMMENT '键',
  `value`              VARCHAR(1024) NULL       COMMENT '值',
  `description`        VARCHAR(128 ) NULL       COMMENT '描述',
  `scope`              VARCHAR(32)   NULL       COMMENT '适用范围',
  `created_at`         DATETIME      NULL       COMMENT '创建时间',
  `updated_at`         DATETIME      NULL       COMMENT '更新时间',
  PRIMARY KEY (`id`)
);
