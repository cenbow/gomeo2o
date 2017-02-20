package cn.com.mx.webapi.servlet.integration;

import static org.junit.Assert.*;

import java.io.IOException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.DeleteMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.PutMethod;

import org.junit.Test;

/**
 * @author zhaoqing
 * 
 * The entity looks like {"timestamp":<int>}
 * Only GET method is allowed 
 */
public class TimeResourceTest extends BaseResourceTestCase {
	
	public TimeResourceTest() {
		resourceUrl = urlPrefix + "/demo/time";
	}
	
	@Test
	public void testGet() throws Exception {
		GetMethod method = gettingMethod();
		int code = client.executeMethod(method);
		
		assertEquals(200, code);
		assertEquals(DEFAULT_CONTENT_TYPE, method.getResponseHeader("Content-Type").getValue());
		
		String body = method.getResponseBodyAsString();
		JSONObject bodyObject = (JSONObject)JSON.parse(body);
		long timestamp = bodyObject.getJSONObject("data").getLong("timestamp");
		long now = System.currentTimeMillis();
		assertTrue(10000 > Math.abs(now - timestamp));
	}
	
	@Test
	public void testGetWithAccpetAnyContentType() throws HttpException, IOException {
		GetMethod method = new GetMethod(resourceUrl);
		method.setRequestHeader("Accept", "*/*");
		int code = client.executeMethod(method);
		assertDefaultResponse(method, code);
		
		String body = method.getResponseBodyAsString();
		JSONObject bodyObject = (JSONObject)JSON.parse(body);
		long timestamp = bodyObject.getJSONObject("data").getLong("timestamp");
		assert(timestamp > 0);
	}
	
	@Test
	public void testPut() throws IOException {
		PutMethod method = puttingMethod("{}");
		int code = client.executeMethod(method);
		assertEquals(405, code);
	}

	@Test
	public void testPost() throws IOException {
		PostMethod method = postingMethod("{}");
		int code = client.executeMethod(method);
		assertEquals(405, code);
	}

	@Test
	public void testDelete() throws IOException {	
		DeleteMethod method = deletingMethod();
		int code = client.executeMethod(method);
		assertEquals(405, code);
	}
}