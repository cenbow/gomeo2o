package cn.com.mx.count.social.im.http;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;

import javax.net.ssl.SSLException;

import lombok.extern.slf4j.Slf4j;

import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import cn.com.mx.count.social.im.comm.ImConstant;


/**
 * 
 * @Description: im请求http工具类 
 * @author: xuguoqi
 * @date: 2016年1月18日 上午10:46:35
 */
@Slf4j
public class HttpClientUtils {

	private static  HttpClientUtils httpClientUtil =  new HttpClientUtils();
	 
    private HttpClientBuilder httpClientBuilder ;//httpClient 4.0 新特性
    
    
    //异常重发机智
  	private HttpRequestRetryHandler httpRequestRetryHandler = new HttpRequestRetryHandler() {
  		
  		@Override
  		public boolean retryRequest(IOException exception, int executionCount,HttpContext context) {
  			if (executionCount > ImConstant.RETRY_COUNT) {  
  	            // Do not retry if over max retry count  
  				log.error("http client retry send again send executionCount={}",executionCount); 
  	            return false;  
  	        }  
  	        if (exception instanceof InterruptedIOException) {  
  	            // Timeout
  	        	log.error("timeout exception:{}",exception);
  	            return false;  
  	        }  
  	        if (exception instanceof UnknownHostException) { 
  	        	// Unknown host  
  	        	log.error("Unknown host exception:{}",exception);
  	            return false;  
  	        }  
  	        if (exception instanceof ConnectTimeoutException) {  
  	            // Connection refused  
  	        	log.error("conn refuse retry: e={}",exception);
  	            return false;  
  	        }  
  	        if (exception instanceof SSLException) {  
  	            // SSL handshake exception  
  	        	log.error("SSL handshake exception={}",exception);
  	            return false;  
  	        }  
  	        HttpClientContext clientContext = HttpClientContext.adapt(context);  
  	        HttpRequest request = clientContext.getRequest();  
  	        boolean idempotent = !(request instanceof HttpEntityEnclosingRequest);  
  	        // Retry if the request is considered idempotent  
  	        if (idempotent) {  
  	            return true;  
  	        } 
  			return false;
  		}
  	};
    
    
    public static HttpClientUtils getInstance(){
		return httpClientUtil;
	}
    
    /**
     * 初始化http工具类
     */
	private HttpClientUtils(){
		httpClientBuilder =  HttpClientBuilder.create();
        //单个请求最大连接数
        httpClientBuilder.setMaxConnPerRoute(ImConstant.MAX_CONN_PER_ROUTE);
        //允许的最大链接数
        httpClientBuilder.setMaxConnTotal(ImConstant.MAX_CONN_TOTAL);
        RequestConfig defaultRequestConfig = RequestConfig.custom()
        		//最大响应超时时间
        	    .setSocketTimeout(ImConstant.SOCKET_TIME_OUT)
        	    //最大请求超时时间
        	    .setConnectTimeout(ImConstant.CONNECT_TIME_OUT)
        	    .build();
        httpClientBuilder.setDefaultRequestConfig(defaultRequestConfig);
        //异常重试机制
        httpClientBuilder.setRetryHandler(httpRequestRetryHandler);
	}
	
	/**
	 * 
		 * @Description: get请求 
	     * @author: xuguoqi
	     * @date: 2016年1月15日 下午4:59:15
	     * @param url
	     * @param dataBody
	     * @return
	 */
	public String get(String url,Object dataBody){
		
		String result = null;
        
		CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
	   
	    
	    HttpGet httpGet = new HttpGet(url);
	    
	    //请求格式为json 编码集为utf-8
	    httpGet.addHeader("Content-Type", "application/json; charset=" + ImConstant.CHARSET);
	    CloseableHttpResponse response = null;  
        try {
        	response = closeableHttpClient.execute(httpGet);  
	        int status = response.getStatusLine().getStatusCode();  
	        if (status >= 200 && status < 300) {  
	        	result = EntityUtils.toString(response.getEntity());
	        }  
        } catch (Exception e) {
        	log.error("send im server error url={} and exception={}", url,e);
            return result;
        } finally {
        	httpGet.releaseConnection();
        	if(response != null) {
        		try {
					EntityUtils.consume(response.getEntity());
				} catch (IOException e) {
					log.error("close response exception url={},e={} ", url,e);
				} 
    	    }
        }
        return result;
	}
	
	/**
	 * 
	 * @Description: post 请求 
     * @author: xuguoqi
     * @date: 2016年1月15日 下午4:59:38
     * @param url  全路径
     * @param dataBody 数据实体类
     * @return
	 */
    public String post(String url,Object dataBody){
		
    	String result = null;
        
        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
	    HttpPost httpPost = new HttpPost(url);
	    //请求格式为json 编码集为utf-8
        httpPost.addHeader("Content-Type", "application/json; charset=" + ImConstant.CHARSET);
        
	    CloseableHttpResponse response = null;  
        try {
        	if(null != dataBody){
				httpPost.setEntity(new StringEntity(dataBody.toString(), ImConstant.CHARSET));
			}
        	response = closeableHttpClient.execute(httpPost);  
	        int status = response.getStatusLine().getStatusCode();  
	        if (status >= 200 && status < 300) {  
	        	result = EntityUtils.toString(response.getEntity());
	        }  
        } catch (Exception e) {
        	log.error("send im server error url={} and exception={}", url,e);
            return result;
        } finally {
        	httpPost.releaseConnection();
        	if(response != null) {
        		try {
					EntityUtils.consume(response.getEntity());
				} catch (IOException e) {
					log.error(String.format("request.post.response.closed.is.wrong:%s", url),e);
				} 
    	    }
        }
        return result;
	}
    

}
