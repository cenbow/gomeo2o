package cn.com.mx.utils;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;

/**
 * @Description 统一获取 
 * @author yuanchangjun
 * @date 2016年2月22日 下午3:48:34
 */
@Slf4j
public class JsoupUtils {
	
	/**
	 * @Description 统一获取关键词 
	 * @author yuanchangjun
	 * @date 2016年2月22日 下午3:49:48
	 * @param text
	 * @return
	 */
	public static String getJsonp(String text,String ip){
		try {
			org.jsoup.nodes.Document document = Jsoup.connect(ip).userAgent("Mozilla").data("sensitive", text).get();
			String mgc = document.body().html();
			if(!StringUtils.isBlank(mgc)){
				return mgc.replaceAll("\n", "");
			}
		} catch (Exception e) {
			log.error("查询群组审核日志圈子简介  ",e);
		}
	  return text;
	}
	
	public static void main(String[] args) {
		try {
			/*org.jsoup.nodes.Document document = Jsoup.connect("http://web.qun.qq.com/cgi-bin/notice/get_data_new?qid=193524068&fnum=1000&bkn=752571847")
					.userAgent("Mozilla")
					.header("Cookie", "skey=ZEaagPp2cE; uin=o0455255111;").get();
			String mgc = document.body().text();
			System.out.println(mgc);*/
			
			/*//群何人
			org.jsoup.nodes.Document document = Jsoup.connect("http://cgi.qqweb.qq.com/tempchatforgroup/api/get_single_info?tuin=455255111&gcode=193524068&t=1456383011810")
					.userAgent("Mozilla")
					.ignoreContentType(true)
					.header("Cookie", "skey=ZEaagPp2cE; uin=o0455255111;")
			.header("Referer", "http://qqweb.qq.com/tempchatforgroup/index.html")
			.timeout(3000000).get();
			String mgc = document.body().text();
			System.out.println(mgc);*/
			/* 个人空间最近上传图片 
			org.jsoup.nodes.Document document = Jsoup.connect("http://cgi.qqweb.qq.com/tempchatforgroup/qzone/get_feeds?tuin=455255111&t=1456383011810")
					.userAgent("Mozilla")
					.ignoreContentType(true)
					.header("Cookie", "skey=ZEaagPp2cE; uin=o0455255111;")
			.header("Referer", "http://qqweb.qq.com/tempchatforgroup/index.html")
			.timeout(3000000).get();
			String mgc = document.body().text();
			System.out.println(mgc);*/
			
			//http://p.qlogo.cn/gh/530788464/530788464/100
			//腾讯美女直播
			/*org.jsoup.nodes.Document document = Jsoup.connect("http://cgi.tiantian.qq.com/tiantian/find_live")
					.userAgent("Mozilla")
					.ignoreContentType(true)
					.header("Cookie", "skey=ZEaagPp2cE; uin=o0455255111;")
					.header("Referer", "http://qqweb.qq.com/tempchatforgroup/index.html")
					.timeout(3000000).get();
			String mgc = document.body().text();
			System.out.println(mgc);*/
			/*//群组管理员
			org.jsoup.nodes.Document document = Jsoup.connect("http://qinfo.clt.qq.com/cgi-bin/qun_info/get_group_info_all?gc=39589851&bkn=422221980&src=qinfo_v3")
					.userAgent("Mozilla")
					.ignoreContentType(true)
					.header("Cookie", "RK=nBtag2VXVU; pgv_flv=11.2 r999; pgv_info=pgvReferrer=http://client.show.qq.com/#page&ssid=s7117484539; pgv_pvid=5409091296; o_cookie=455255111; ptisp=ctc; ptcz=88c870aaaffaa97af0895d58ec9ff95ad3902ab85d68f6080507d6609fbb02f5; pt2gguin=o0455255111; uin=o455255111; skey=ZDUn5NWMAN")
					.header("Referer", "http://qinfo.clt.qq.com/qinfo_v3/member.html")
					.timeout(3000000).get();
			String mgc = document.body().text();
			System.out.println(mgc);*/
			//群内人
			/*org.jsoup.nodes.Document document = Jsoup.connect("http://qinfo.clt.qq.com/cgi-bin/qun_info/get_group_members_new?gc=34565806&bkn=422221980&src=qinfo_v3")
					.userAgent("Mozilla")
					.ignoreContentType(true)
					.header("Cookie", "RK=nBtag2VXVU; pgv_flv=11.2 r999; pgv_info=pgvReferrer=http://client.show.qq.com/#page&ssid=s7117484539; pgv_pvid=5409091296; o_cookie=455255111; ptisp=ctc; ptcz=88c870aaaffaa97af0895d58ec9ff95ad3902ab85d68f6080507d6609fbb02f5; pt2gguin=o0455255111; uin=o455255111; skey=ZDUn5NWMAN")
					.header("Referer", "http://qinfo.clt.qq.com/qinfo_v3/member.html")
					.timeout(3000000).get();
			String mgc = document.body().text();
			System.out.println(mgc);*/
			//喜欢的房间图片
			//http://tiantian.qq.com/cgi-bin/qiqi/loveroom
			//获取最关心好友
			/* 加入所有的QQ群
			org.jsoup.nodes.Document document = Jsoup.connect("http://qun.qq.com/cgi-bin/qun_mgr/get_group_list")
					.userAgent("Mozilla")
					.ignoreContentType(true)
					.data("bkn", "871086521")
					.header("Cookie", "3g_guest_id=-9065345203497304064; popup_question_close=1; pgv_pvi=699109376; RK=nAtag2VXUU; _ga=GA1.2.2090998572.1451888936; pgv_flv=20.0 r0; o_cookie=455255111; ptisp=ctc; ptcz=e3ffa7d479b18b711fce23e361aa0a12cd8add5166e8be8acade071e9ac7e5c2; pt2gguin=o0455255111; uin=o0455255111; skey=@SW542naN2; p_uin=o0455255111; p_skey=JdN0lAcOUzgWJ2X6AsxgHw6P72HG3ttBvlC0c4OQmes_; pt4_token=XyThm76i7yxMP1s0JtLkf6juCp-cgA3kUQanTLS8HhQ_; ts_refer=ui.ptlogin2.qq.com/cgi-bin/login; pgv_info=ssid=s7310128105; ts_last=qun.qq.com/member.html; pgv_pvid=6602247946; ts_uid=7022896400")
					.header("Referer", "http://qun.qq.com/member.html")
					.timeout(3000000).get();
			String mgc = document.body().text();
			System.out.println(mgc);
			*/
			
			/*获取群成员
			org.jsoup.nodes.Document document = Jsoup.connect("http://cgi.find.qq.com/qqfind/myinfo?ldw=871086521&_=145648367931")
					.userAgent("Mozilla")
					.ignoreContentType(true)
					.header("Cookie", "3g_guest_id=-9065345203497304064; popup_question_close=1; pgv_pvi=699109376; RK=nAtag2VXUU; _ga=GA1.2.2090998572.1451888936; pgv_flv=20.0 r0; o_cookie=455255111; ptisp=ctc; ptcz=e3ffa7d479b18b711fce23e361aa0a12cd8add5166e8be8acade071e9ac7e5c2; pt2gguin=o0455255111; uin=o0455255111; skey=@SW542naN2; pgv_info=ssid=s7310128105; pgv_pvid=6602247946")
					.header("Referer", "http://qun.qq.com/member.html")
					.timeout(3000000).get();
			String mgc = document.body().text();
			System.out.println(mgc);*/
			
			/*获取群成员*/
			//http://d1.weather.com.cn/dingzhi/101010100.html?_=1456715085788
			//http://d1.weather.com.cn/zs_index/101010100.html?_=1456715085888
			//http://d1.weather.com.cn/weixinfc/101010100.html?_=1456715085987
			//http://wx.weather.com.cn/citylist/city3jdata/provshi/10101.html
			//http://wx.weather.com.cn/citylist/china.html
			/*
			org.jsoup.nodes.Document document = Jsoup.connect("http://d1.weather.com.cn/sk_2d/101030100.html?_=1456715085388 ")
					.userAgent("Mozilla")
					.ignoreContentType(true)
					.header("Cookie", "vjuids=-1051d8d76.1532af5f323.0.4928b7cc; BIGipServerd1src_pool=713304185.20480.0000; vjlast=1456714675.1456714675.30")
					.header("Referer", "http://wx.weather.com.cn/mweather/101030100.shtml")
					.timeout(3000000).get();
			String mgc = document.body().text();
			System.out.println(mgc);*/
			
			/*org.jsoup.nodes.Document document = Jsoup.connect("https://api.bs.dev.gomeplus.com/api/socialTopic/audit.json")
					.userAgent("Mozilla")
					.ignoreContentType(true)
					.timeout(3000000).post();
			String mgc = document.body().text();
			System.out.println(mgc);*/
		} catch (Exception e) {
			log.error("查询群组审核日志圈子简介  ",e);
		}
	}
}