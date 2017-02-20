package cn.com.mx.count.demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

import org.bson.Document;

import redis.clients.jedis.JedisCommands;
import cn.com.mx.count.factory.MongoClientFactory;
import cn.com.mx.count.template.SimpleJedisTemplate;
import cn.com.mx.count.template.SimpleJedisTemplate.RedisCallback;
import cn.com.mx.count.template.SimpleSqlTemplate;
import cn.com.mx.count.template.SimpleSqlTemplate.SqlCallback;

import com.mongodb.Block;
import com.mongodb.client.FindIterable;

/**
 * @Description demo 
 * @author wanggang-ds6
 * @date 2016年1月6日 下午1:09:41
 */

@Slf4j
@WebServlet("/demo/*")
public class DemoServlet extends HttpServlet {

	private static final long serialVersionUID = 3685750393284916127L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getRequestURI().replace(request.getContextPath() + request.getServletPath(), "");
		System.out.println(type);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//response.getWriter().println(getResult());
		response.getWriter().println(getResultForTemp() + "|" + getResultForRedis() + "|" + getResultForMongo());
	}
		
	/**
	 * @Description 获取数据 
	 * @author wanggang-ds6
	 * @date 2016年1月6日 下午2:08:24
	 * @return
	 */
	private String getResultForTemp() {
		SimpleSqlTemplate sst = new SimpleSqlTemplate();      	
        	long rtnValue = sst.execute(new SqlCallback<Long>() {     		
				@Override
				public Long done(Connection conn) {					
					PreparedStatement pstm = null;
			        ResultSet rs = null;
			        long postId = 0;
					try {					
						String sql = "select * from sns_post limit 1";
			            pstm = conn.prepareStatement(sql);
			            rs = pstm.executeQuery();
			            if (rs.next()) {
			            	postId = rs.getLong("post_id");
			            }
					} catch (Exception e) {
						log.error("查询出错！", e);
					} finally {
			            if (rs != null) {
			                try {
			                    rs.close();
			                } catch (Exception e) {
			                	log.error("关闭ResultSet出错", e);
			                }
			            }
			            if (pstm != null) {
			                try {
			                    pstm.close();
			                } catch (Exception e) {
			                	log.error("关闭PreparedStatement出错", e);
			                }
			            }
					}
					return postId;
				}  		
			});
        	
		return "结果是：" + rtnValue + "|" + UUID.randomUUID();
	}
	
	private String getResultForRedis() {
		SimpleJedisTemplate sst = new SimpleJedisTemplate();
		return sst.execute(new RedisCallback<String>() {

			@Override
			public String doInRedis(JedisCommands commands) {
				return commands.get("test");
			}
			
		});
	}
	
	private String getResultForMongo() {
		final List<String> list = new ArrayList<String>();
		Document where = new Document();
		where.append("_id", "1449127636842228");
		FindIterable<Document> fi = MongoClientFactory.getMongoClient()
				.getDatabase("social").getCollection("socialGroup").find(where);
		fi.forEach(new Block<Document>() {
			@Override
			public void apply(Document doc) {
				list.add((String) doc.get("groupName"));				
			}						
		});		
		return list.toString();
	}

}
