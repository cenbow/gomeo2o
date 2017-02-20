package cn.com.mx.utils.mongo;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;

/**
 * @author yuanchangjun
 */
public interface BaseMongoDao<T> {
	
	/**
	 * 
	 * @Description 通过条件查询实体(集合)
	 * @author yuanchangjun
	 * @date 2015年11月10日 上午11:59:25
	 * @return
	 */
	public List<T> findAllObjects();
	/**
	 * @Description 查询所有实体
	 * @author yuanchangjun
	 * @date 2015年11月10日 上午11:59:32
	 * @param query
	 * @return
	 */
	public List<T> findAll(Query query);
	/**
	 * 
	 * @Description 通过一定的条件查询一个实体  
	 * @author yuanchangjun
	 * @date 2015年11月10日 上午11:59:47
	 * @param query
	 * @return
	 */
	public T findOne(Query query);  
	/**
	 * @Description 通过条件查询更新数据 
	 * @author yuanchangjun
	 * @date 2015年11月10日 上午11:59:54
	 * @param query
	 * @param update
	 * @return 实体
	 */
	public T update(Query query, Update update); 
	/**
	 * @Description 通过条件查询更新数据(更新多个)
	 * @author yuanchangjun
	 * @date 2015年11月10日 上午11:59:54
	 * @param query
	 * @param update
	 * @return true?false
	 */
	public boolean updateMulti(Query query, Update update);
	/**
	 * @Description 保存一个对象到mongodb  
	 * @author yuanchangjun
	 * @date 2015年11月10日 下午12:04:05
	 * @param entity
	 * @return
	 */
    public T save(T entity) ; 
    /**
     * @Description 通过ID获取记录 
     * @author yuanchangjun
     * @date 2015年11月10日 下午12:04:14
     * @param id
     * @return
     */
    public T findById(String id);  
    
    /**
     * @Description 查找并且删除
     * @author yuanchangjun
     * @date 2015年11月10日 下午12:04:23
     */
    public T findAndRemove(Query query);
    /**
     * @Description 通过ID获取记录,并且指定了集合名(表的意思) 
     * @author yuanchangjun
     * @date 2015年11月10日 下午12:04:33
     * @param id
     * @param collectionName
     * @return
     */
    public T findById(String id, String collectionName); 
    /**
     * @Description 分页查询 
     * @author yuanchangjun
     * @date 2015年11月10日 下午12:04:47
     * @param page
     * @param query
     * @return
     */
    public List<T> findPage(PageParam page,Query query);
    /**
     * @Description 分页查询 
     * @author mojianli
     * @date 2015年11月10日 下午12:04:47
     * @param page 分页参数
     * @param query 查询条件
     * @return
     */
    public PageBean findPageForPageBean(PageParam page,Query query);  
    /**
     * @Description 创建映射
     * @author yuanchangjun
     * @date 2015年11月10日 下午12:04:57
     */
    public void createCollection();
    /**
     * @Description 删除映射
     * @author yuanchangjun
     * @date 2015年11月10日 下午12:05:09
     */
    public void dropCollection();
    /**
     * 
     * @Description 求数据总和  
     * @author yuanchangjun
     * @date 2015年11月10日 下午12:05:21
     * @param query
     * @return
     */
    public int count(Query query);  
    
    
    /**
     * @Description 获取新的id 
     * @author wanggang-ds6
     * @date 2015年11月12日 下午12:01:21
     * @param collectionName 集合名称
     * @return 新id
     */
    public long getNewId(String collectionName);
    
}
