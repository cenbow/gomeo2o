package io.terminus.ecp.trade.model.club;

import com.google.common.base.Objects;
import lombok.Data;
import org.joda.time.DateTime;

import java.io.Serializable;
import java.util.Date;

/**
 * Author:Guo Chaopeng
 * Created on 12/23/14.
 */
@Data
public class ClubActivity implements Serializable {

    private static final long serialVersionUID = -4852518701002013042L;

    private Long id;
    private Long ownerId;               //活动所有者id
    private Long sellerId;              //发布活动商家id(冗余)
    private Long copartnerInfoId;       //可参与活动的企业id(冗余)
    private String activityName;        //活动名称
    private String activityBanner;      //活动banner
    private String enterImage;          //入口图
    private Integer status;             //状态，0->未开始,1->进行中,-1->已结束
    private Date startAt;               //活动开始时间
    private Date endAt;                 //活动结束时间
    private Date createdAt;             //创建时间
    private Date updatedAt;             //更新时间

    public static enum Status {
        INIT(0, "未开始"),
        ACTIVE(1, "进行中"),
        EXPIRE(-1, "已结束");

        private final Integer value;

        private final String display;

        private Status(Integer value, String display) {
            this.value = value;
            this.display = display;
        }

        public static Status fromNumber(Integer value) {
            for (Status t : Status.values()) {
                if (Objects.equal(t.value, value)) {
                    return t;
                }
            }
            return null;
        }

        public Integer toNumber() {
            return this.value;
        }

        @Override
        public String toString() {
            return this.display;
        }
    }

    /**
     * 判断活动现在是否在有效时间范围内
     */
    public Boolean isCurrentActive() {
        DateTime now = DateTime.now();
        return now.isAfter(new DateTime(this.startAt))
                && now.isBefore(new DateTime(this.endAt));
    }

    /**
     * 判断活动是否处于某种状态
     */
    public Boolean isStatus(Status s) {
        return Objects.equal(this.status, s.toNumber());
    }

}
