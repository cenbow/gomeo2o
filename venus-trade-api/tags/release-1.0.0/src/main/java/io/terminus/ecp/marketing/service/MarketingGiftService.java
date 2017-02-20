package io.terminus.ecp.marketing.service;

import io.terminus.pampas.common.Response;

/**
 * Desc: 赠送礼品
 * Mail: houly@terminus.io
 * author: Hou Luyao
 * Date: 3/18/15.
 */
public interface MarketingGiftService {

    /**
     * 赠送礼品
     * @param userId 用户ID
     * @param itemId 礼品ID
     * @param num 数量
     * @return
     */
    public Response<Boolean> autoSendGift(Long userId, Long itemId, Integer num);
}
