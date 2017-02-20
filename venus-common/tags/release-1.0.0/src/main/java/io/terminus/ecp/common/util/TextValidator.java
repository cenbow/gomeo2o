/*
 * Copyright (c) 2015 杭州端点网络科技有限公司
 */

package io.terminus.ecp.common.util;

import javax.annotation.Nullable;
import java.util.regex.Pattern;

import static com.google.common.base.Preconditions.checkState;

/**
 * @author Effet
 */
public enum TextValidator {

    /**
     * 用户名长度 5~25
     */
    USERNAME() {
        // TODO(Effet): 应更复杂
        private Pattern pattern = Pattern.compile("^[\\d_a-zA-Z\\u4E00-\\u9FA5]{5,25}$");

        @Override
        public boolean boolCheck(String text) {
            return text != null && pattern.matcher(text).matches();
        }
    },

    /**
     * 密码长度限制 6~16
     */
    PASSWORD() {
        private Pattern pattern = Pattern.compile("[\\s\\S]{6,16}");

        @Override
        public boolean boolCheck(String text) {
            return text != null && pattern.matcher(text).matches();
        }
    },

    REAL_NAME() {
        private Pattern pattern = Pattern.compile("^[\\u4E00-\\u9FA5]{2,10}$");

        @Override
        public boolean boolCheck(String text) {
            return text != null && pattern.matcher(text).matches();
        }
    },

    SUB_SELLER() {
        private Pattern pattern = Pattern.compile("^[a-zA-z][\\d_a-zA-Z\\u4E00-\\u9FA5]{4,24}$");

        @Override
        public boolean boolCheck(String text) {
            return text != null && pattern.matcher(text).matches();
        }
    },

    OPERATOR() {
        private Pattern pattern = Pattern.compile("^[\\d_a-zA-Z\\u4E00-\\u9FA5]{1,5}$");

        @Override
        public boolean boolCheck(String text) {
            return text != null && pattern.matcher(text).matches();
        }
    },

    /**
     * 商品标题限制 1~200
     */
    ITEM_TITLE() {
        private Pattern pattern = Pattern.compile("^.{1,200}$");

        @Override
        public boolean boolCheck(String text) {
            return text != null && pattern.matcher(text).matches();
        }
    },

    /**
     * 资源角色名 1~20
     */
    RES_ROLE() {
        private Pattern pattern = Pattern.compile("^[\\d_a-zA-Z\\u4E00-\\u9FA5]{1,20}$");

        @Override
        public boolean boolCheck(String text) {
            return text != null && pattern.matcher(text).matches();
        }
    };

    abstract public boolean boolCheck(String text);

    public final String check(String text, @Nullable String error) throws IllegalStateException {
        checkState(boolCheck(text), error);
        return text;
    }

    public final String check(String text) throws IllegalStateException {
        return check(text, null);
    }
}
