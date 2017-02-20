package io.terminus.ecp.trade.service;

import io.terminus.pampas.common.Response;
import java.util.List;

/**
 * Desc:敏感词过滤
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-05-26.
 */
public interface BadWordService {

    /**
     * 过滤敏感词
     * @param inputStr  输入的字符串
     * @return  List
     * 返回过滤的敏感词
     */
    public Response<List<String>> filterBadWords(String inputStr);
}
