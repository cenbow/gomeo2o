/*
 * Copyright (c) 2014 杭州端点网络科技有限公司
 */

package io.terminus.ecp.common.util;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 图片抓取
 * <p/>
 * Mail: xiao@terminus.io <br>
 * Date: 2014-11-12 3:53 PM  <br>
 * Author: xiao
 */
public class ImageCapture {

    private static final String IMG_REG = "https?://?(.*?)(\"|>|\\s+)*.(jpg|png|gif)";

    public static List<String> catching(String source) {
        List<String> res = Lists.newArrayList();
        Pattern p = Pattern.compile(IMG_REG);
        Matcher m = p.matcher(source);
        while (m.find()) {
            res.add(m.group());
        }
        return res;
    }
}
