package io.terminus.ecp.marketing.service;

import io.terminus.ecp.marketing.service.Condition;
import io.terminus.ecp.marketing.service.Way;

import java.util.List;

/**
 * Desc: 工具接口类
 * Mail: houly@terminus.io
 * author: Hou Luyao
 * Date: 3/16/15.
 */
public interface Tool {

    /**
     * 获取可以被选择的条件
     * @return
     */
    public List<Condition> getConditionsCanBeChoose();

    /**
     * 获取可以被选择的方法
     * @return
     */
    public List<Way> getWaysCanBeChoose();


}
