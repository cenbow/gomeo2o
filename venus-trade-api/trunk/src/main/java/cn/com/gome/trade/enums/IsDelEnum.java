package cn.com.gome.trade.enums;


/**
 * 是否删除
 * @author songrongbin
 * 对应数据库is_del字段
 */
public enum IsDelEnum {
	
	DEL("已删除", true),
    NO_DEL("未删除", false);

    // 成员变量
    private String message;
    private boolean code;

    // 构造方法
    private IsDelEnum(String message, boolean code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean getCode() {
        return code;
    }

    public void setCode(boolean code) {
        this.code = code;
    }
}
