/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description TODO 
 * @author kl_chaizhilei
 * @date 2016年1月21日 下午1:58:11
 */
package cn.com.mx.count.social.im.Template;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

import org.bson.Document;

import cn.com.mx.count.social.im.comm.ImConstant;
import cn.com.mx.count.social.im.dto.ReqGroup;
import cn.com.mx.count.social.im.service.ImService;
import cn.com.mx.count.social.im.service.impl.ImServiceImpl;
import cn.com.mx.count.template.MongoDbTemplate;
import cn.com.mx.count.utils.ConfigUtil;
import cn.com.mx.count.utils.UUIDUtils;

import com.mongodb.BasicDBObject;

/**
 * @Description IM同步会员数据数据 模板
 * @author kl_chaizhilei
 * @date 2016年1月21日 下午1:58:11
 */
@Slf4j
@SuppressWarnings("all")
public class IMSyncTemplate {

	private static String mongodbName = ConfigUtil.get("mongodbName");

	public static String syncGroupTemplate() {
		String result = "";
		List<String> properties = new ArrayList<String>();
		properties.add("_id");
		properties.add("createOperator");
		properties.add("groupName");
		List<Map<String, Object>> list = MongoDbTemplate.getResultForMongo(properties,
				new Document().append("state", 0), mongodbName, "socialGroup");
		if (list != null && list.size() > 0) {
			result = "同步群成功，共" + list.size() + "个群";
			ImService imService = null;
			for (Map<String, Object> map : list) {
				String groupId = (String) map.get("_id");
				String uid = (String) map.get("createOperator");
				String groupName = (String) map.get("groupName");
				ReqGroup reqGroup = new ReqGroup();
				reqGroup.setAppServerName(ImConstant.APP_SERVER_NAME);
				reqGroup.setGroupId(groupId);
				reqGroup.setGroupName(groupName);
				reqGroup.setUid(Long.parseLong(uid));
				reqGroup.setRequestId(UUIDUtils.creatUUID());
				imService = new ImServiceImpl();
				// 发送创建群组的消息
				imService.addGroup(uid, "", groupId, groupName, "", "");
			}
		} else {
			log.error("获取所有群组失败,未能拿到所有的socialGroup数据 {}", list);
		}
		return result + "执行完毕";
	}

	public static String syncPersonTemplate() {
		String result = "同步群成员成功";
		List<String> properties = new ArrayList<String>();
		properties.add("_id");
		properties.add("createOperator");
		properties.add("groupName");
		List<Map<String, Object>> list = MongoDbTemplate.getResultForMongo(properties,
				new Document().append("state", 0), mongodbName, "socialGroup");
		if (list != null && list.size() > 0) {
			ImService imService = null;
			for (Map<String, Object> map : list) {
				String groupId = (String) map.get("_id");
				List<String> personPerties = new ArrayList<String>();
				personPerties.add("createOperator");
				List<Map<String, Object>> personlist = MongoDbTemplate.getResultForMongo(personPerties,
						new Document().append("states", 2).append("isTrue", new BasicDBObject("$lte", 2)), mongodbName,
						"socialGroupPersons");
				if (null != personlist && personlist.size() > 0) {
					for (Map<String, Object> personMap : personlist) {
						String uid = (String) personMap.get("createOperator");
						imService = new ImServiceImpl();
						// 发送创建群组的消息
						imService.joinGroup(groupId, uid, "", "");
					}
				}
			}
		} else {
			log.error("获取所有群组失败,未能拿到所有的socialGroup数据 {}", list);
		}
		return result + "执行完毕";
	}

}
