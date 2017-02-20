package cn.com.mx.count.template;

import java.lang.reflect.Method;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import cn.com.mx.count.factory.MysqlConnectionFactory;

/**
 * @Description: sql查询 
 * @author: shanjie
 * @date: 2016年1月13日 上午11:16:08
 */
@Slf4j
public class BaseSqlTemplate {
	
	public static final String SELECT_ALLCOLUNMS_SQL ="select * from ";
	public static final String SELECT_COUNT_SQL = "select count(1) count from ";

	/**
	   * @Description: TODO 
	   * @author: shanjie
	   * @date: 2016年1月13日 上午11:53:35
	   * @param tableName 数据库表名
	   * @param limit 第几页，从1开始
	   * @param pageSize 每页条数
	   * @param map 查询条件
	   * @param clazz 返回的实体类
	   * @return
	 */
	public static List pagingObjects(String tableName, Integer limit, Integer pageSize, Map<String, Object> map, Class clazz) {
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Object> lst = null;
		try {
			conn = MysqlConnectionFactory.getConnection();
			pstm = conn.prepareStatement(SELECT_ALLCOLUNMS_SQL + getConditionSql(tableName, limit, pageSize, map));
			rs = pstm.executeQuery();
			lst = new ArrayList<Object>();
			resultSetToList(rs, clazz, lst);
		} catch (Exception e) {
			log.error("查询出错！", e);
		} finally {
			close(conn, pstm, rs);
		}
		return lst;
	}
	
	/**
	   * @Description: TODO 
	   * @author: shanjie
	   * @date: 2016年1月14日 下午6:27:05
	   * @param Sql 完整查询语句
	   * @param limit 第几页，从1开始
	   * @param pageSize 每页条数
	   * @param map 查询条件
	   * @param clazz 返回的实体类
	   * @return
	 */
	public static List pagingObjectsBySql(String Sql, Class clazz) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Object> lst = null;
		try {
			conn = MysqlConnectionFactory.getConnection();
			pstm = conn.prepareStatement(Sql);
			rs = pstm.executeQuery();
			lst = new ArrayList<Object>();
			resultSetToList(rs, clazz, lst);
		} catch (Exception e) {
			log.error("查询出错！", e);
		} finally {
			close(conn, pstm, rs);
		}
		return lst;
	}
	
	/**
	   * @Description: 获取总条数 
	   * @author: shanjie
	   * @date: 2016年1月13日 上午10:55:46
	   * @param tableName
	   * @param map
	   * @return
	 */
	public static long getCount(String tableName, Map<String, Object> map) {
		long count = 0l;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Object> lst = null;
		try {
			conn = MysqlConnectionFactory.getConnection();
			pstm = conn.prepareStatement(SELECT_COUNT_SQL + getConditionSql(tableName, null, null, map));
			rs = pstm.executeQuery();
			if(rs.next()) {
				count = rs.getLong("count");
			}
		} catch (Exception e) {
			log.error("查询出错！", e);
		} finally {
			close(conn, pstm, rs);
		}
		
		return count;
	}

	/**
	   * @Description: 封装结果集 
	   * @author: shanjie
	   * @date: 2016年1月12日 下午6:14:23
	   * @param rs
	   * @param clazz
	   * @param lst
	   * @return
	   * @throws Exception
	 */
	public static List<Object> resultSetToList(ResultSet rs, Class clazz, List<Object> lst)
			throws Exception {

		// 取得Method
		Method[] methods = clazz.getDeclaredMethods();
		// 用于获取列数、或者列类型
		ResultSetMetaData meta = rs.getMetaData();
		Object obj = null;
		Class cls = null;
		
		while (rs.next()) {
			// 获取formbean实例对象
			obj = clazz.newInstance(); // 用Class.forName方法实例化对象和new创建实例化对象是有很大区别的，它要求JVM首先从类加载器中查找类，然后再实例化，并且能执行类中的静态方法。而new仅仅是新建一个对象实例
			// 循环获取指定行的每一列的信息
			for (int i = 1; i <= meta.getColumnCount(); i++) {
				// 当前列名
				String colName = meta.getColumnName(i);

				// 设置方法名
				String setMethodName = "set" + colName;
				
				// 遍历Method
				for (int j = 0; j < methods.length; j++) {
					if (methods[j].getName().replaceAll("_", "").equalsIgnoreCase(setMethodName.replaceAll("_", ""))) {
						setMethodName = methods[j].getName();
						
						// 获取当前位置的值，返回Object类型
						Object value = rs.getObject(colName);
						
						if (value == null) {
							continue;
						}
						/*gome_user_extras表的expert_audit_status列的定义是tinyint(1)类型。
						 *这种定义用rs.getObject(colName)方法按照列名取值时，得到的结果是boolean类型。
						 *值是0时，得到false，0以外（1,2,3...）都得到true。这样无法得到对应的状态值（1,2,3...）。
						 *所以需要判断set方法的参数，如果是Integer，就用rs.getInt(colName)方法，得到0,1,2,3...的状态值。
						 */
						if (methods[j].getParameterTypes()[0].getName().toString().equals("java.lang.Integer")) {
							try{
								value = rs.getInt(colName);
							}catch(Exception e) {
								log.error("数据库转换异常", e);
							}
						}
						if(value instanceof BigInteger) {
							value = ((BigInteger) value).longValue();
							cls = Long.class;
						} else if(value instanceof Boolean) {
							continue;
						} else {
//							cls = value.getClass();
							cls = methods[j].getParameterTypes()[0];
						}
						
						// 实行Set方法
						try {
							// // 利用反射获取对象
							// JavaBean内部属性和ResultSet中一致时候
							Method setMethod = obj.getClass().getMethod(
									setMethodName, cls);
							setMethod.invoke(obj, value);
						} catch (Exception e) {
							// JavaBean内部属性和ResultSet中不一致时候，使用String来输入值。
							e.printStackTrace();
						}
					}
				}
			}
			lst.add(obj);
		}
		return lst;
	}
	
	/**
	   * @Description: 封装sql获取 
	   * @author: shanjie
	   * @date: 2016年1月12日 下午6:16:31
	   * @param tableName
	   * @param limit
	   * @param pageSize
	   * @param map
	   * @return
	 */
	public static String getConditionSql(String tableName, Integer limit, Integer pageSize, Map<String, Object> map) {
		StringBuffer conditionSql = new StringBuffer();
		
		conditionSql.append(tableName).append(" where 1=1 ");
		
		List l;
		
		try{
			for(String key: map.keySet()) {
				if(map.get(key) != null) {
					
					if(map.get(key) instanceof List) {
						conditionSql.append(" and ").append(key).append(" in (");
						
						l = (List) map.get(key);
						for(int i=0; i<l.size(); i++) {
							conditionSql.append("'").append(l.get(i)).append("'");
							if(i < l.size() -1) {
								conditionSql.append(",");
							}
						}
						conditionSql.append(")");
					}
					else {
						conditionSql.append(" and ").append(key).append("='").append(map.get(key)).append("'");
					}
				}
			}
			
			if(limit != null && pageSize != null) {
				conditionSql.append(" limit ").append((limit - 1)*pageSize).append(", ").append(pageSize);
			}
		}
		catch(Exception e) {
			log.error("getConditionSql error.", e);
		}
		
		return conditionSql.toString();
	}

    /**
     * @Description: 获取总条数
     * @author: liyan
     * @date: 2016年1月13日 上午10:55:46
     * @param sql
     * @param conn
     * @return
     */
    public static Long getCount(String sql, Connection conn) {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Long num = null;
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            if (rs.next()) {
                num = rs.getLong("count");
            }
        } catch (Exception e) {
            log.error("查询出错！", e);
        } finally {
            close(conn, pstm, rs);
        }

        return num;
    }

    /**
     * @Description: 获取id集合
     * @author: liyan
     * @date: 2016年1月13日 上午10:55:46
     * @param 
     * @param 
     * @return
     */
public static List<Long> pagingIds(String tableName,String idName, Integer limit, Integer pageSize, Map<String, Object> map) {
        
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Long> ids = null;
        try {
            conn = MysqlConnectionFactory.getConnection();
            pstm = conn.prepareStatement("select "+idName+ " from " + getConditionSql(tableName, limit, pageSize, map));
            rs = pstm.executeQuery();
            ids = new ArrayList<Long>();
            if(rs.next()){
                ids.add(rs.getLong(idName)); 
            }
        } catch (Exception e) {
            log.error("查询出错！", e);
        } finally {
            close(conn, pstm, rs);
        }
        return ids;
    }
	/**
	   * @Description: 关闭连接 
	   * @author: shanjie
	   * @date: 2016年1月13日 上午10:00:24
	   * @param conn
	   * @param pstm
	   * @param rs
	 */
	public static void close(Connection conn, PreparedStatement pstm, ResultSet rs) {
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
		if (conn != null) {
            try {
            	conn.close();
            } catch (Exception e) {
            	log.error("关闭Connection出错", e);
            }
        }
	}
}
