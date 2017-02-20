ALTER TABLE act_account_info ADD UNIQUE udx_user_id (user_id);
ALTER TABLE act_binding_bank_card ADD INDEX idx_user_id (user_id);
ALTER TABLE act_rebate_detail ADD INDEX idx_user_id (user_id);
ALTER TABLE act_score_detail ADD INDEX idx_user_id (user_id);
ALTER TABLE act_score_point ADD INDEX idx_code (code);