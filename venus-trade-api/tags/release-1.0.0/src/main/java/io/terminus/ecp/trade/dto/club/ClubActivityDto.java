package io.terminus.ecp.trade.dto.club;

import io.terminus.ecp.trade.model.club.ClubActivity;
import io.terminus.ecp.trade.model.club.ClubActivityOwner;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Author:Guo Chaopeng
 * Created on 12/23/14.
 */
public class ClubActivityDto implements Serializable {

    private static final long serialVersionUID = -596579871406013419L;

    @Setter
    @Getter
    private ClubActivity clubActivity;             //活动信息

    @Setter
    @Getter
    private ClubActivityOwner clubActivityOwner;  //活动所有者

}
