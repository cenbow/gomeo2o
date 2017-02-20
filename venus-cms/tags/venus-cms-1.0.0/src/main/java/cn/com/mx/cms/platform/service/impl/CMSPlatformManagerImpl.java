package cn.com.mx.cms.platform.service.impl;

import io.terminus.ecp.item.dto.FullItem;
import io.terminus.ecp.item.dto.ItemFullDetail;
import io.terminus.ecp.item.model.Item;
import io.terminus.ecp.item.model.ItemDetail;
import io.terminus.ecp.item.model.ItemTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.gome.rebate.constants.RebateType;
import cn.com.gome.rebate.model.plan.RebatePlanDto;
import cn.com.gome.rebate.model.plan.RebateRuleDto;
import cn.com.gome.user.model.MemberExpertInfo;
import cn.com.mx.cms.cache.IRecommendCache;
import cn.com.mx.cms.client.ExpertClient;
import cn.com.mx.cms.client.FavoriteClient;
import cn.com.mx.cms.client.GroupClient;
import cn.com.mx.cms.client.IMClient;
import cn.com.mx.cms.client.ItemClient;
import cn.com.mx.cms.client.LifeClient;
import cn.com.mx.cms.client.RebateClient;
import cn.com.mx.cms.client.ShopClient;
import cn.com.mx.cms.client.TopicClient;
import cn.com.mx.cms.constants.BaseConstants;
import cn.com.mx.cms.dto.platform.ItemDto;
import cn.com.mx.cms.dto.platform.RecommendDto;
import cn.com.mx.cms.entity.RecommendEntity;
import cn.com.mx.cms.enums.RebateEnums;
import cn.com.mx.cms.enums.RecommendType;
import cn.com.mx.cms.exception.CmsException;
import cn.com.mx.cms.platform.dao.RecommendDao;
import cn.com.mx.cms.platform.dao.RecommendTitleDao;
import cn.com.mx.cms.platform.service.ICMSPlatformManager;
import cn.com.mx.cms.utils.CMSCodeUtil;
import cn.com.mx.cms.utils.ChangePriceUtil;
import cn.com.mx.cms.utils.DateUtil;
import cn.com.mx.cms.utils.EmojiFilterUtils;
import cn.com.mx.cms.utils.JsonUtil;
import cn.com.mx.cms.vo.GroupVo;
import cn.com.mx.cms.vo.ProductVo;
import cn.com.mx.cms.vo.RebateVo;
import cn.com.mx.cms.vo.ShopVo;
import cn.com.mx.cms.vo.TalentDynVo;
import cn.com.mx.cms.vo.TalentVo;
import cn.com.mx.cms.vo.TopicVo;
import cn.com.mx.social.dto.group.vo.GroupInfoVo;
import cn.com.mx.social.dto.topic.SocialTopicNewDto;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.gomeo2o.common.entity.CommonResultEntity;
import com.gomeo2o.common.exceptions.BizException;
import com.gomeo2o.common.utils.Img;
import com.gomeo2o.facade.im.utils.StringUtils;
import com.gomeo2o.facade.shb.entity.SNSImageEntity;
import com.gomeo2o.facade.shb.entity.SNSPostEntity;
import com.gomeo2o.facade.vshop.entity.VshopInfo;
import com.gomeo2o.facade.vshop.service.VshopFacade;
import com.google.common.collect.Lists;

/**
 * Description: 推荐位Dubbo服务接口实现
 * 
 * @author duwei
 * @date 2015年11月28日 下午4:58:52
 * @version V1.0
 */
@SuppressWarnings("all")
@Slf4j
@Service("cmsPlatformManager")
public class CMSPlatformManagerImpl implements ICMSPlatformManager {

	@Autowired
	private RecommendDao recommendDao;
	@Autowired
	private RecommendTitleDao recommendTitleDao;
	@Autowired
	private IRecommendCache recCache;
	@Autowired
	public VshopFacade vshopFacade;
	@Autowired
	private ItemClient itemClient;
	@Autowired
	private ShopClient shopClient;
	@Autowired
	private GroupClient groupClient;
	@Autowired
	private FavoriteClient favoriteClient;
	@Autowired
	private TopicClient topicClient;
	@Autowired
	private LifeClient lifeClient;
	@Autowired
	private ExpertClient expertClient;
	@Autowired
	private RebateClient rebateClient;
	@Autowired
	private IMClient imClient;

	/**
	 * @Description 添加推荐位
	 * @author duwei
	 * @date 2015年11月28日 下午16:59:25
	 */
	@Override
	public CommonResultEntity<Map> addRecommend(List<RecommendDto> dtos, Integer recommendType) {
		try {
			if (dtos == null) {
				return new CommonResultEntity(CMSCodeUtil.PAMAS_ERROR, CMSCodeUtil.PAMAS_ERROR_MSG, "");
			}

			// 1.删除推荐位
			if(recommendType == null){
				return new CommonResultEntity(CMSCodeUtil.INSERT_RECOMMEND_EXCEPTION_CODE,
						CMSCodeUtil.INSERT_RECOMMEND_EXCEPTION_MSG, "");
			}
			recommendDao.deleteByRecType(recommendType);
			recCache.writeRecommendDto(String.valueOf(recommendType), dtos);
			
			for (RecommendDto dto : dtos) {
				dto.setExtendData(EmojiFilterUtils.filterEmoji(dto.getExtendData()));
			}
			if(dtos.size() == 0){
				return new CommonResultEntity(CMSCodeUtil.SUCCESS, "删除推荐位成功", null);
			}
			List<RecommendEntity> entityList = getRecommendEntitys(dtos);
			
			// 2.新增推荐位
			for (RecommendEntity entity : entityList) {
				recommendDao.insertSelective(entity);
			}

		} catch (Exception e) {
			log.error("新增推荐位失败,失败原因:", e);
			return new CommonResultEntity(CMSCodeUtil.INSERT_RECOMMEND_EXCEPTION_CODE,
					CMSCodeUtil.INSERT_RECOMMEND_EXCEPTION_MSG, "");

		}
		return new CommonResultEntity(CMSCodeUtil.SUCCESS, CMSCodeUtil.SUCCESS_MSG, null);
	}

	private List<RecommendEntity> getRecommendEntitys(List<RecommendDto> dtos) {
		List<RecommendEntity> entityList = Lists.newArrayList();
		for (RecommendDto dto : dtos) {
			entityList.add(convertDto2Po(dto));
		}
		return entityList;
	}

	@Override
	public CommonResultEntity<String> deleteRecommend(RecommendDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommonResultEntity<List<RecommendDto>> findRecommends(RecommendDto dto) {

		return null;
	}

	public CommonResultEntity<HashMap<String, Object>> findRecommendsByRecommendType(Integer recommendType) {
		if (recommendType != null) {
			List<RecommendEntity> recommendList = recommendDao.selectByRecommendType(recommendType);
			String title = recommendTitleDao.selectByType(recommendType);
			List<RecommendDto> recommendDtos = new ArrayList<RecommendDto>();
			for (RecommendEntity recommendEntity : recommendList) {
				RecommendDto dto2 = new RecommendDto();
				BeanUtils.copyProperties(recommendEntity, dto2);
				recommendDtos.add(dto2);
			}
			HashMap<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("title", title);
			resultMap.put("list", recommendDtos);
			return new CommonResultEntity<HashMap<String, Object>>(0, "成功", resultMap);
		}
		return new CommonResultEntity<HashMap<String, Object>>(1, "推荐位类型为空", new HashMap<String, Object>());
	}

	/**
	 * 对象间拷贝属性值
	 * 
	 * @param dto
	 * @return
	 */
	private RecommendEntity convertDto2Po(RecommendDto dto) {
		RecommendEntity entity = new RecommendEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * @Description: 查询第三方接口信息
	 * @author duwei
	 * @param dto
	 *            {推荐位大类型}
	 * @return CommonResultEntity<String> 返回JSON
	 */
	@Override
	public CommonResultEntity<String> findThirdAgentById(RecommendDto dto) {
		log.info(">>>>>>>>>>推荐位调用第三方接口参数：【" + JsonUtil.toJson(dto) + "】");
		String json = "";
		try {
			int recType = dto.getRecommendType();
			int type = dto.getType();
			long id = dto.getRecommendId() == null ? 0 : dto.getRecommendId();
			String groupid = dto.getGroupid();
			// 超级返--生活普通推荐位--商品
			if ((RecommendType.commonRec.getCode() == recType || RecommendType.superRebateRec.getCode() == recType)
					&& type == BaseConstants.REC_COMMON_ITEM_TYPE) {
				if (RecommendType.superRebateRec.getCode() == recType) {
					boolean f = rebateClient.gethasRebate(dto.getItemid());
					if (f == false) {
						throw CmsException.ITEM_REBATE_WARN;
					}
				}
				Item item = itemClient.findItemById(dto);
				RebateVo vo = new RebateVo();
				vo.setShopId(item.getShopId());
				// vo.setImage();//上传专用
				vo.setType(RebateEnums.product.getCode());
				vo.setTypeName(RebateEnums.product.getLabel());
				// ----page
				vo.setDataId(item.getId() + "");
				vo.setPictureUrl(Img.getImgPath(item.getMainImage()));
				vo.setProductId(item.getId());

				json = JsonUtil.toJson(vo);
				// 超级返--生活普通推荐位--商铺
			} else if ((RecommendType.commonRec.getCode() == recType || RecommendType.superRebateRec.getCode() == recType)
					&& type == BaseConstants.REC_COMMON_SHOP_TYPE) {
				// 校验商铺是返利类型
				if (RecommendType.superRebateRec.getCode() == recType) {
					boolean f = hasRebateShop(dto);
					if (f == false) {
						throw CmsException.SHOP_REBATE_WARN;
					}
				}
				VshopInfo shop = shopClient.queryVshopById(dto);
				RebateVo vo = new RebateVo();
				vo.setShopId(shop.getVshopId());
				vo.setImage(Img.getImgPath(shop.getVshopIcon()));
				vo.setType(RebateEnums.shop.getCode());
				vo.setTypeName(RebateEnums.shop.getLabel());
				// ----page
				vo.setDataId(shop.getVshopId() + "");
				vo.setPictureUrl(shop.getVshopIcon());
				json = JsonUtil.toJson(vo);
				// 最热群组6--群组--通过000000
			} else if (RecommendType.groupRec.getCode() == recType) {
				GroupInfoVo groupInfoVo = groupClient.getSerachGroupId(dto);
				GroupVo vo = new GroupVo();
				vo.setGroupLogo(groupInfoVo.getGroupIcon());
				vo.setGroupMembers(groupInfoVo.getGroupNum());// 合成一个串
				vo.setMessageNum(groupInfoVo.getTopicNum());// 合成一个串
				vo.setGroupInfo("群人数: " + groupInfoVo.getGroupNum() + "<br> 话题数: " + groupInfoVo.getTopicNum());
				vo.setGroupId(groupInfoVo.getGroupId());
				vo.setGroupTypeId(groupInfoVo.getCategoryId());
				vo.setGroupName(groupInfoVo.getGroupName());
				json = JsonUtil.toJson(vo);
				// 达人推荐
			} else if (RecommendType.expertRec.getCode() == recType) {
				MemberExpertInfo expertInfo = expertClient.queryExpertInfoByMemberId(dto);// 达人查询
				TalentVo vo = new TalentVo();
				vo.setTalentIcon(Img.getImgPath(expertInfo.getPicturePath()));// 达人头像URL
//				vo.setShowUrl(Img.getImgPath(expertInfo.getPicturePath()));// 个人秀来自发表的帖子中的图片
				vo.setTalentType(expertInfo.getExpertType() == null ? "" : expertInfo.getExpertType());
				vo.setTalentName(expertInfo.getNickName());
				vo.setUserId(dto.getRecommendId());

				// 查询分享商品主图
				List<Long> sharaGoodsIds = expertInfo.getSharaGoodsIds();

				List<String> picUrlList = Lists.newArrayList();
				if (CollectionUtils.isNotEmpty(sharaGoodsIds)) {
					if (sharaGoodsIds.size() < 2) {
						throw CmsException.EXPERT_SHAREPIC_WARN;
					}
					for (long sid : sharaGoodsIds) {
						Item item = itemClient.findItemById(new RecommendDto(sid));
						picUrlList.add(Img.getImgPath(item.getMainImage()));
					}
				} else {
					throw CmsException.EXPERT_SHAREPIC_WARN;
				}
				vo.setProduct(picUrlList);

				long fansNum = imClient.getImFansNum(dto);
				vo.setFocusNum(Integer.valueOf(fansNum + ""));
				int attention = imClient.isNeedAttention(dto);
				vo.setIsFocus(attention);// 与当前登录用户关系

				// 爱生活图片列表
				// 拿postId
				long postId = 0;
				List<SNSPostEntity> postEntityList2 = lifeClient.getPostIdByUserId(dto);
				if (CollectionUtils.isNotEmpty(postEntityList2)) {
					SNSPostEntity pe = postEntityList2.get(0);
					if (pe != null) {
						postId = pe.getId() == null ? 0 : pe.getId();
					}
				}
				SNSPostEntity postEntity = lifeClient.findPostInfoById(postId);
				if (postEntity != null) {
					List<SNSImageEntity> images = postEntity.getsNSImageEntityList();
					if (CollectionUtils.isNotEmpty(images)) {
						SNSImageEntity imageEntity = images.get(0);
						vo.setShowUrl(imageEntity.getImagePath());
					}
				}
				json = JsonUtil.toJson(vo);
				// 精品
			} else if (RecommendType.boutiqueRec.getCode() == recType) {
				ItemFullDetail fulldetail = itemClient.findItemFullDetailById(dto);
				FullItem fi = fulldetail.getFullItem();
				Item item = fi.getItem();
				ItemDto itemDto = new ItemDto();
				BeanUtils.copyProperties(item, itemDto);

				itemDto = favoriteClient.countByProductId(dto, item, itemDto);

				ProductVo vo = new ProductVo();
				vo.setProductName(item.getName());
				vo.setProductId(item.getId());
				vo.setProductPrice(String.valueOf(ChangePriceUtil.formatDiv(
						Double.parseDouble(String.valueOf(item.getPrice())), 100d)));

				vo.setSellNum(item.getSaleQuantity());// 销量数
				
				FullItem fullItem = fulldetail.getFullItem();
				ItemDetail itemDetail = fullItem.getItemDetail();

				String mainImage = fullItem.getItem().getMainImage();//主图
				String img1=itemDetail.getImage1();
				String img2=itemDetail.getImage2();
				String img3=itemDetail.getImage3();
				String img4=itemDetail.getImage4();
				
				List<String> images = Lists.newArrayList();
				
				if(!StringUtils.isBlank(mainImage)){
					images.add(Img.getImgPath(mainImage));
				}
				if(!StringUtils.isBlank(img1)){
					images.add(Img.getImgPath(img1));
				}
				if(!StringUtils.isBlank(img2)){
					images.add(Img.getImgPath(img2));
				}
				if(!StringUtils.isBlank(img3)){
					images.add(Img.getImgPath(img3));
				}
				
				vo.setImage(images);
				vo.setShopId(item.getShopId());
				vo.setShopName(item.getShopName());
				vo.setCollectionNum(Integer.parseInt(itemDto.getCollectNum() + ""));
				vo.setShareNum(item.getSaleQuantity());
				// 返利金额
				String rebatePrice = rebateClient.getItemRebateAmount(RebateType.buyShare.getCode(), item.getId(),
						item.getPrice(), cn.com.gome.rebate.constants.BaseConstants.DIST_SALE_ROLE_COMMONUSER1);
				vo.setRebatePrice(rebatePrice);
				json = JsonUtil.toJson(vo);
				// 话题--群组5--通过
			} else if (RecommendType.topicRec.getCode() == recType) {
				Object obj = topicClient.getGroupTopicInfo(dto);
				SocialTopicNewDto socialTopicNewDto = new SocialTopicNewDto();
				if (obj instanceof SocialTopicNewDto) {
					socialTopicNewDto = (SocialTopicNewDto) obj;
				}
				TopicVo vo = new TopicVo();
				vo.setGroupId(socialTopicNewDto.getGroupId() == null ? "" : socialTopicNewDto.getGroupId());
				vo.setGroupName(socialTopicNewDto.getGroupName() == null ? "" : socialTopicNewDto.getGroupName());
				vo.setTopicId(dto.getGroupid() == null ? "" : dto.getGroupid());// 话题ID
				vo.setTopicName(socialTopicNewDto.getTopicName() == null ? "" : socialTopicNewDto.getTopicName());
				vo.setTopicContent(socialTopicNewDto.getContent() == null ? "" : socialTopicNewDto.getContent());
				// vo.setLookedNum(socialTopicNewDto);//TODO 第三方无法提供
				vo.setCommentNum(socialTopicNewDto.getRepNum());
				List<String> images = Lists.newArrayList();
				String picstr = socialTopicNewDto.getTopicPic();
				if (picstr != null) {
					String[] pics = picstr.split(",");
					int i = 0;
					for (String pic : pics) {
						if (i++ == 4) {
							break;
						}
						images.add(Img.getImgPath(pic));
					}
				}
				vo.setImage(images);
				json = JsonUtil.toJson(vo);
				// 达人动态
			} else if (RecommendType.expertDynRec.getCode() == recType) {
				TalentDynVo vo = new TalentDynVo();
				// 达人查询
				MemberExpertInfo expertInfo = expertClient.queryExpertInfoByMemberId(dto);
				vo.setUserId(dto.getRecommendId());
				vo.setTalentIcon(Img.getImgPath(expertInfo.getPicturePath()));// 头像
				vo.setTalentType(expertInfo.getExpertType() == null ? "" : expertInfo.getExpertType());
				vo.setTalentName(expertInfo.getNickName() == null ? "" : expertInfo.getNickName());

				// 拿postId---找爱生活下面的信息就有,取用户ID
				long postId = 0;
				long postId2 = 0;
				List<SNSPostEntity> postEntityList2 = lifeClient.getPostIdByUserId(dto);
				if (CollectionUtils.isNotEmpty(postEntityList2)) {
					SNSPostEntity pe = postEntityList2.get(0);
					if (pe != null) {
						postId = pe.getId();
					}
					if (postEntityList2.size() > 1) {
						SNSPostEntity pe2 = postEntityList2.get(1);
						postId2 = pe2.getId();
					}
				}

				// 达人爱生活动态内容,图片url信息（分别从不同话题取两张）
				SNSPostEntity postEntity = lifeClient.findPostInfoById(postId);
				List imagesTemp1 = Lists.newArrayList();
				String content1 = "";
				if (postEntity != null) {
					List<SNSImageEntity> imageList = postEntity.getsNSImageEntityList();
					if (CollectionUtils.isNotEmpty(imageList)) {
//						List images = vo.getImage();
						int i = 0;
						for (SNSImageEntity entity : imageList) {
//							images.add(entity.getImagePath());
							imagesTemp1.add(entity.getImagePath());
							if (++i == 3) {
								break;
							}
						}
//						vo.setImage(images);
					}
					content1 = postEntity.getContent();
					vo.setContent(postEntity.getContent());
				}
				List imagesTemp2 = Lists.newArrayList();
				String content2 = "";
				if (postId2 != 0) {
					SNSPostEntity postEntity2 = lifeClient.findPostInfoById(postId2);
					if (postEntity2 != null) {
						List<SNSImageEntity> imageList = postEntity2.getsNSImageEntityList();
						if (CollectionUtils.isNotEmpty(imageList)) {
//							List images = vo.getImage();
							int i = 0;
							for (SNSImageEntity entity : imageList) {
//								images.add(entity.getImagePath());
								imagesTemp2.add(entity.getImagePath());
								if (++i == 3) {
									break;
								}
							}
//							vo.setImage(images);
						}
						content2 = postEntity.getContent();
						vo.setContent(postEntity2.getContent());
					}
				}
				if (CollectionUtils.isNotEmpty(imagesTemp1) && CollectionUtils.isNotEmpty(imagesTemp2)) {
					List imagesTemp3 = Lists.newArrayList();
					//其中只要有一个话题有三张就取该话题的其中两张
					if(imagesTemp1.size() >=3){
						imagesTemp3.add(imagesTemp1.get(0));
						imagesTemp3.add(imagesTemp1.get(1));
						vo.setContent(content1);
					}else if(imagesTemp2.size() >=3){
						imagesTemp3.add(imagesTemp2.get(0));
						imagesTemp3.add(imagesTemp2.get(1));
						vo.setContent(content2);
					}else{
						imagesTemp3.add(imagesTemp1.get(0));
						imagesTemp3.add(imagesTemp2.get(0));
						vo.setContent(content1+";"+content2);
					}
					vo.setImage(imagesTemp3);
				} else {
					//第一个有三张图
					if (CollectionUtils.isNotEmpty(imagesTemp1) && imagesTemp1.size() >=3) {
						List imagesTemp3 = Lists.newArrayList();
						imagesTemp3.add(imagesTemp1.get(0));
						imagesTemp3.add(imagesTemp1.get(1));
						vo.setContent(content1);
						vo.setImage(imagesTemp3);
					}else{
						if(CollectionUtils.isNotEmpty(imagesTemp1)){
							vo.setContent(content1);
							vo.setImage(imagesTemp1);
						}
					}
					//第二个有三张图
					if (CollectionUtils.isNotEmpty(imagesTemp2) && imagesTemp2.size() >=3) {
						List imagesTemp3 = Lists.newArrayList();
						imagesTemp3.add(imagesTemp2.get(0));
						imagesTemp3.add(imagesTemp2.get(1));
						vo.setContent(content2);
						vo.setImage(imagesTemp3);
					} else {
						if (CollectionUtils.isNotEmpty(imagesTemp2)) {
							vo.setContent(content2);
							vo.setImage(imagesTemp2);
						}
					}
				}

				// 帖子动态列表 只取第一条记录
				List<SNSPostEntity> postEntityList = lifeClient.findPostInfoList(postId);
				if (CollectionUtils.isNotEmpty(postEntityList)) {
					SNSPostEntity pe = postEntityList.get(0);
					vo.setBeginTime(DateUtil.dateToString(pe.getCheckTime()));
					vo.setThumbNum(pe.getLikeCount());
					vo.setCommentNum(pe.getsNsCommentCount());
				}
				json = JsonUtil.toJson(vo);
				// 优店
			} else if (RecommendType.shopRec.getCode() == recType) {
				// 商铺信息
				VshopInfo shop = shopClient.queryVshopById(dto);
				// 上架商品数
				long itemNum = itemClient.countOnShelfItemByShopId(dto);
				// 收藏数
				long favnum = favoriteClient.countByShopId(dto);

				ShopVo vo = new ShopVo();
				vo.setShopId(dto.getRecommendId());
				vo.setShopLogo(shop.getVshopIcon());
				vo.setShopName(shop.getVshopName());
				vo.setProductNum(Integer.valueOf(itemNum + ""));
				vo.setCollectionNum(Integer.valueOf(favnum + ""));
				vo.setSellCount(0);// 12月10日暂不提供
				List<String> label = Lists.newArrayList();
				StringBuilder keywords = new StringBuilder();
				// 是否直降，是否优惠(两个当前为同一下)
				Map<String, Boolean> shopPrivilegeMap = shopClient.getShopPrivilege(dto);

				boolean isHaveCheap = shopPrivilegeMap.get("isHaveCheap");// 是否设优惠--优惠
				boolean isHaveRedBag = shopPrivilegeMap.get("isHaveRedBag");// 是否设有红包
																			// --直降
				vo.setPrivilegeStatus(false);
				if (isHaveCheap == true) {
					label.add("直降");
					keywords.append("直降,");
					vo.setPrivilegeStatus(true);
				}
				if (isHaveRedBag == true) {
					label.add("优惠");
					keywords.append("优惠,");
					vo.setPrivilegeStatus(true);
				}
				// TODO 是否返利  判断计划
				RebateRuleDto rd = rebateClient.getRuleDetailList(dto);
				RebatePlanDto planDto = rebateClient.getPlanDetail(dto);
				if ((rd.getStatus() != null
						&& cn.com.gome.rebate.constants.BaseConstants.RULE_STATUS_VALID == rd.getStatus()) || planDto !=null) {
					vo.setRebateStatus(true);
					label.add("返利");
					keywords.append("返利");
				} else {
					vo.setRebateStatus(false);
				}
				vo.setLabel(label);
				String keywordStr = keywords.toString();
				if (!StringUtils.isEmpty(keywordStr)) {
					if (keywordStr.lastIndexOf(",") > 0) {
						keywordStr = keywordStr.substring(0, keywordStr.lastIndexOf(","));
					}
				}
				vo.setKeywords(keywordStr);
				json = JsonUtil.toJson(vo);
			}
			log.info("<<<<<<<<<推荐位获得第三方接口信息：【" + json + "】");
		} catch (BizException ce) {
			log.error("第三方接口详情错误:json={}", JsonUtil.toJson(dto), ce);
			return new CommonResultEntity<String>(ce.getCode(), ce.getMessage(), "");
		} catch (Exception e) {
			log.error("查询第三方接口失败,失败原因:json={}", JsonUtil.toJson(dto), e);
			return new CommonResultEntity<String>(CMSCodeUtil.SERVICE_FAIL, CMSCodeUtil.SERVICE_FAIL_MSG, "");
		}
		return new CommonResultEntity<String>(CMSCodeUtil.SUCCESS, CMSCodeUtil.SUCCESS_MSG, json);
	}
	
	/**
	 * @Description: 校验店铺是否返利店铺
	 * @param dto
	 *            推荐位Dto
	 * 
	 * @throws Exception
	 */
	private boolean hasRebateShop(RecommendDto dto) throws Exception {
		// 查计划
		RebatePlanDto planDto = rebateClient.getPlanDetail(dto);
		if (planDto != null) {
			return true;
		}

		// 查规则
		RebateRuleDto rd = rebateClient.getRuleDetailList(dto);
		if (rd.getStatus() != null && cn.com.gome.rebate.constants.BaseConstants.RULE_STATUS_VALID == rd.getStatus()) {
			return true;
		}

		return false;
	}
	
}
