package cn.com.mx.count.user.bean;

import java.io.Serializable;
import java.util.Date;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * @Description gome_user_extras 表对应的实体
 * @author jiale
 * @date 2016年3月3日 下午4:55:14
 * @return
 */
@ToString
@EqualsAndHashCode
public class UserExtras implements Serializable{
	
	private static final long serialVersionUID = -5169117890274768716L;
	
	@Getter
    @Setter
    private Long memberId;//会员id
	
	@Getter
    @Setter
    private String verifyCode;//验证码
	
	@Getter
    @Setter
    private Date verifyCodeTime;//验证码生成时间
	
	@Getter
    @Setter
    private Integer verifyCodeCount;//验证码错误次数
	
	@Getter
    @Setter
    private Integer pswErrorCount;//密码错误次数
	
	@Getter
    @Setter
    private String refereeId;//推荐人ID(国美在线会员Id)
	
	@Getter
    @Setter
    private Date recommend_time;//更新推荐人的时间
	
	@Getter
    @Setter
    private String docuCode;//证件编号
	
	@Getter
    @Setter
	private Integer docuType;//证件类型
	
	@Getter
    @Setter
    private String idcardFront;//身份证正面路径
	
	@Getter
    @Setter
    private String idcardBack;//身份证反面路径
	
	@Getter
    @Setter
    private String idcardState;//未审核：0;审核中：1；审核成功：2；审核失败
	
	@Getter
    @Setter
    private String idcardFailReason;//身份审核失败原因
	
	@Getter
    @Setter
    private String auditorId;//审核者ID
	
	@Getter
    @Setter
    private Date auditTime;//审核时间
	
	@Getter
    @Setter
    private Integer wherefrom;//账号属性：1:自己创建账号、2:平台商家账号、3:后台创建账号4:虚账号

	@Getter
    @Setter
    private Integer sex;//性别 未知：0；女：1;男：2
	
	@Getter
    @Setter
    private Date birthday;//出生日期
	
	@Getter
    @Setter
    private Date updateTime;//更新时间
	
	@Getter
    @Setter
    private String picturePath;//会员头像
	
	@Getter
    @Setter
    private String userName;//用户姓名
	
	@Getter
    @Setter
    private Long teamId;//所属组队
	
	@Getter
    @Setter
    private String phoneActiveState;//手机绑定状态;激活：Y;未激活：N
	
	@Getter
    @Setter
    private String emailActiveState;//邮箱激活状态;激活：Y;未激活：N
	
	@Getter
    @Setter
    private Integer isCaptain;//队长:1;队员：0
	
	@Getter
    @Setter
    private String captain_id;//队长id
	
	@Getter
    @Setter
    private Date createTime;//创建时间
	
	@Getter
    @Setter
    private String imBuyerId;//买家im账号
	
	@Getter
    @Setter
    private String imSellerId;//卖家im账号
	
	@Getter
    @Setter
    private String loveLifeBg;//爱生活背景图
	
	@Getter
    @Setter
    private Integer loveLifeAuth;//爱生活权限
	
	@Getter
    @Setter
    private String saleRefereeId;//商家推荐人ID
	
	@Getter
    @Setter
    private Date saleRecommendTime;//商家更新推荐人的时间
	
	@Getter
    @Setter
    private String userSign;//用户签名
	
	@Getter
    @Setter
    private String idcardPersonImg;//手持身份证图片
	
	@Getter
    @Setter
    private Integer expertAuditStatus;//达人审核状态
	
	@Getter
    @Setter
    private String expertAuditor;//达人审核者账号
	
	@Getter
    @Setter
    private Date expertAuditTime;//达人审核时间
	
	@Getter
    @Setter
    private String expertAuditFailReason;//达人审核失败原因
	
	@Getter
    @Setter
    private Long expertLabelId;//达人标签id
	
	@Getter
    @Setter
    private Date expertApplyTime;//达人申请时间
	
}
