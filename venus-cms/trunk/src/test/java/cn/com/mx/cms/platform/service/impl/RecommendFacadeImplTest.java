package cn.com.mx.cms.platform.service.impl;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.com.mx.cms.dto.platform.RecommendDto;
import cn.com.mx.cms.entity.RecommendEntity;
import cn.com.mx.cms.enums.RecommendEnums;
import cn.com.mx.cms.enums.RecommendType;
import cn.com.mx.cms.platform.dao.RecommendDao;

/**
 * 
 * @Description
 * @author zhangxianpeng
 * @date 2015年11月30日 上午11:27:18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/venus-cms-dubbo-provider.xml", "classpath:/spring/venus-cms-dubbo-consumer.xml" })
public class RecommendFacadeImplTest {

	@Autowired
	public RecommendDao recommendDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass...................");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass...................");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("setUp...................");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown...................");
	}

	@Test
	public void testFindRecommendList() {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("isDisabled", RecommendEnums.AVAILABLE.getValue());
		paramMap.put("recommendType", RecommendType.superRebateRec.getCode());// 超级返类型
		List<RecommendEntity> list = recommendDao.findRecommendList(paramMap);

		assertTrue("list为空",list!= null);

		List<RecommendDto> recommendDtos = new ArrayList<RecommendDto>();
		if (list != null && list.size() > 0) {
			for (RecommendEntity recommendEntity : list) {
				RecommendDto dto = new RecommendDto();
				BeanUtils.copyProperties(recommendEntity, dto);
				recommendDtos.add(dto);
			}
		}
		for (RecommendDto dto : recommendDtos) {
			System.out.println(dto.getRecommendType());
			System.out.println(dto.getSn());
			System.out.println(dto.getPictureUrl());
			System.out.println(dto.getExtendData());
		}
	}

	@Test
	public void testFindSuperRebateList() {

		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("isDisabled", RecommendEnums.AVAILABLE.getValue());
		paramMap.put("recommendType", RecommendType.superRebateRec.getCode());// 超级返类型
		List<RecommendEntity> list = recommendDao.findSuperRebateList(paramMap);

		assertTrue("list为空",list!= null);

		List<RecommendDto> recommendDtos = new ArrayList<RecommendDto>();
		if (list != null && list.size() > 0) {
			for (RecommendEntity recommendEntity : list) {
				RecommendDto dto = new RecommendDto();
				BeanUtils.copyProperties(recommendEntity, dto);
				recommendDtos.add(dto);
			}
		}
		for (RecommendDto dto : recommendDtos) {
			System.out.println(dto.getRecommendType());
			System.out.println(dto.getSn());
			System.out.println(dto.getPictureUrl());
			System.out.println(dto.getExtendData());
		}
	}

	@Test
	public void testFindRecommendListByType() {

		List<RecommendEntity> list = recommendDao.selectByRecommendType(RecommendType.boutiqueRec.getCode());

		assertTrue("list为空",list!= null);

		List<RecommendDto> recommendDtos = new ArrayList<RecommendDto>();
		if (list != null && list.size() > 0) {
			for (RecommendEntity recommendEntity : list) {
				RecommendDto dto = new RecommendDto();
				BeanUtils.copyProperties(recommendEntity, dto);
				recommendDtos.add(dto);
			}
		}

		for (RecommendDto dto : recommendDtos) {
			System.out.println(dto.getRecommendType());
			System.out.println(dto.getSn());
			System.out.println(dto.getPictureUrl());
			System.out.println(dto.getExtendData());
		}
	}

}
