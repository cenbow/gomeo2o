package cn.com.gome.trade.dto.userdto;


import com.google.common.base.Objects;
import com.google.common.base.Strings;

import io.terminus.common.utils.Splitters;
import io.terminus.pampas.common.BaseUser;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

import static io.terminus.common.utils.Arguments.notEmpty;

/**
* 用户类
* Author: haolin
* On: 8/26/14
*/
@ToString
@EqualsAndHashCode
public class User implements BaseUser {

   private static final long serialVersionUID = -7156141639881746299L;

   @Setter
   private Long id;

   @Getter @Setter
   private String nickname;    // 昵称，唯一

   @Getter @Setter
   private String displayName; //显示名

   @Getter @Setter
   private String mobile;      // 手机


   @Getter @Setter
   private String email;       // 邮箱

   @Setter
   private Integer type;       // 类型

   @Getter @Setter
   private String passwd;      // 32位加密密码

   @Getter @Setter
   private Integer status;     // 状态


   @Getter @Setter
   private String outerUserId; //外部用户ID

   /**
    * 用户来源, 0 或 NULL 表示用户自己注册
    *
    * @see UserOrigin#getId()
    * @deprecated 用户这里不需要冗余
    */
   @Getter @Setter
   @Deprecated
   private Long originId;

   @Getter @Setter
   private String roleStr;

   @Getter @Setter
   private Date createdAt;     // 创建时间

   @Getter @Setter
   private Date updatedAt;     // 更新时间

   private Integer isSaleSpreader;  //是否商家推广者
	private Integer isUserSpreader;  //是否会员推广者
	
   @Override
   public Long getId() {
       return id;
   }

   @Override
   public Integer getType() {
       return type;
   }

   @Override
   public String getTypeName() {
       // 没法静态得到类型名, 依赖 ecp 的系统可能会重新定义 Type 类
       return null;
   }

   public static enum TYPE implements UserType {
       ADMIN(0, "管理员"),
       BUYER(1, "买家"),
       SELLER(2, "卖家"),
       SITE_OWNER(3, "站点拥有者"),
       AGENT(4, "代理商"),
       OPERATOR(5, "后台运营"),
       LOGIN(-98, "登陆用户"),       // 指代所有登陆的用户, 不是真实 TYPE
       ALL(-99, "全部");             // 用于权限校验，不是真实TYPE

       private final int value;

       private final String display;

       private TYPE(int number, String display) {
           this.value = number;
           this.display = display;
       }

       public static TYPE fromName(String name) {
           for (TYPE type : TYPE.values()) {
               if (type.name().equalsIgnoreCase(name)) {
                   return type;
               }
           }
           return null;
       }

       public static TYPE fromNumber(Integer number) {
           if (number == null) {
               return null;
           }
           for (TYPE type : TYPE.values()) {
               if (type.value == number) {
                   return type;
               }
           }
           return null;
       }

       public int toNumber() {
           return value;
       }

       public String toName() {
           return display;
       }

       @Override
       public int id() {
           return value;
       }

       @Override
       public String toString() {
           return String.valueOf(value);
       }
   }

   /**
    * 状态枚举
    */
   public static enum Status {
       FROZEN(-2, "已冻结"),
       LOCKED(-1, "已锁定"),
       NOT_ACTIVATE(0, "未激活"),
       NORMAL(1, "正常");

       private final int value;

       private final String desc;

       private Status(int number, String desc) {
           this.value = number;
           this.desc = desc;
       }

       /**
        * 根据数值返回状态枚举
        * @param value 数值
        * @return 状态枚举
        */
       public static Status from(int value) {
           for (Status status : Status.values()) {
               if (Objects.equal(status.value, value)) {
                   return status;
               }
           }
           return null;
       }

       public int value() {
           return value;
       }

       @Override
       public String toString() {
           return desc;
       }
   }

   public String getName() {
       if (notEmpty(nickname)) {
           return nickname;
       }
       if (notEmpty(mobile)) {
           return mobile;
       }
       return email;
   }

   /**
    * 判断用户是否是某个状态
    * @param user 用户
    * @param s 状态
    * @return 是返回true, 反之false
    */
   public static boolean isStatus(User user, Status s){
       return user.getStatus() == s.value();
   }


   @Override
   public List<String> getRoles() {
       return Splitters.COMMA.splitToList(Strings.nullToEmpty(roleStr));
   }

   public static User fromBaseUser(BaseUser baseUser) {
       User user = new User();
       user.setId(baseUser.getId());
       user.setNickname(baseUser.getName());
       user.setType(baseUser.getType());
       return user;
   }
   
   /**
    * @Description:强制设置本地密码为空串
    * @author  yangyanyan-ds
    * @version 1.0
    */
   public void setBlankPassword(){
   	this.passwd="";
   }

	public Integer getIsSaleSpreader() {
		return isSaleSpreader;
	}

	public void setIsSaleSpreader(Integer isSaleSpreader) {
		this.isSaleSpreader = isSaleSpreader;
	}

	public Integer getIsUserSpreader() {
		return isUserSpreader;
	}

	public void setIsUserSpreader(Integer isUserSpreader) {
		this.isUserSpreader = isUserSpreader;
	}
}

