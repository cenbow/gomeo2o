package cn.com.gome.trade.dto.userdto;


/**
 * 
 * @Description TODO 
 * @author wangjiatian
 * @date 2016年6月22日 下午4:11:23
 */
public interface UserType {

    /**
     * 类型数字
     */
    int id();

    /**
     * 类型名, {@code java.lang.Enum#name}
     */
    String name();
}

