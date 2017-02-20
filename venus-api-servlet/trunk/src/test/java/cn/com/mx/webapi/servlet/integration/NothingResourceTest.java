package cn.com.mx.webapi.servlet.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.URLEncoder;

import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.DeleteMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @author zhaoqing Puzzle: TheThing is Nothing. Only Nothing theThing can be.
 */

public class NothingResourceTest extends BaseResourceTestCase {
	
	public NothingResourceTest () {
		resourceUrl = urlPrefix + "/demo/nothing";
	}

	@Test
	public void testGet() throws HttpException, IOException {
		GetMethod method = gettingMethod();
		int code = client.executeMethod(method);

		assertDefaultResponse(method, code);

		String body = method.getResponseBodyAsString();
		JSONObject bodyObject = (JSONObject) JSON.parse(body);
		assertEquals("Nothing",
				bodyObject.getJSONObject("data").getString("theThing"));
	}

	@Test
	public void testPut() throws HttpException, IOException {
		JSONObject json = new JSONObject();
		json.put("theThing", "Nothing");
		PutMethod method = puttingMethod(json.toJSONString());
		int code = client.executeMethod(method);

		assertDefaultResponse(method, code);
		String body = method.getResponseBodyAsString();
		JSONObject bodyObject = (JSONObject) JSON.parse(body);
		assertEquals("Nothing",
				bodyObject.getJSONObject("data").getString("theThing"));
	}

	@Test
	public void testPutWithBadJson() throws HttpException, IOException {
		PutMethod method = puttingMethod("{x");
		int code = client.executeMethod(method);
		assertEquals(400, code);
	}

	@Test
	public void testPutWithUnprocessableContent() throws HttpException,
			IOException {
		JSONObject json = new JSONObject();
		json.put("theThing", "Something");
		PutMethod method = puttingMethod(json.toJSONString());
		int code = client.executeMethod(method);
		assertEquals(422, code);

		String body = method.getResponseBodyAsString();
		JSONObject bodyObject = (JSONObject) JSON.parse(body);
		assertEquals("Only Nothing theThing can be.",
				bodyObject.getString("message"));
	}
	
	@Test
	public void testPutWithUnsupportedMediaType() throws Exception {
		PutMethod method = new PutMethod(this.resourceUrl);
		String xmlString = "<?xml vertion=1.0 encoding=\"UTF-8\"><theThing>Nothing</theTing>";
		method.setRequestEntity(new StringRequestEntity(xmlString,
				CONTENT_TYPE_XML, CHARSET_UTF8));
		method.setRequestHeader("Accept", CONTENT_TYPE_JSON);
		method.addRequestHeader("x-gomeplus-device", DEFAULT_DEVICE);
		method.addRequestHeader("x-gomeplus-app", DEFAULT_APP);
		
		int code = client.executeMethod(method);
		assertEquals(415, code);
		assertEquals(DEFAULT_CONTENT_TYPE, method.getResponseHeader("Content-Type").getValue());
		String body = method.getResponseBodyAsString();
		JSONObject bodyObject = (JSONObject) JSON.parse(body);
		assertEquals("", bodyObject.getString("message"));
		JSONObject data = bodyObject.getJSONObject("data");
		assertFalse(data.entrySet().iterator().hasNext());
	}
	
	@Test
	public void testGetWithQueryParameters() throws Exception {
		GetMethod method = new GetMethod(this.resourceUrl);
		method.setQueryString("accept=" + URLEncoder.encode(CONTENT_TYPE_JSON, "UTF-8"));
		int code = client.executeMethod(method);		
		assertEquals(200, code);
	}
	
	@Test
	public void testGetWithUnacceptableContent() throws Exception {
		GetMethod method = new GetMethod(this.resourceUrl);
		method.setRequestHeader("Accept", CONTENT_TYPE_XML);
		method.setRequestHeader("x-gomeplus-device", DEFAULT_DEVICE);
		method.setRequestHeader("x-gomeplus-app", DEFAULT_APP);
		method.setRequestHeader("Content-Type", DEFAULT_CONTENT_TYPE);
		int code = client.executeMethod(method);		
		assertEquals(406, code);
	}
	
	@Test
	public void testPost() throws HttpException, IOException {
		JSONObject json = new JSONObject();
		json.put("theThing", "Nothing");
		PostMethod method = postingMethod(json.toJSONString());
		
		int code = client.executeMethod(method);
		assertTrue((code == 200 || code == 201));
	}
	
	@Test
	public void testDelete() throws Exception {
		DeleteMethod method = deletingMethod();
		int code = client.executeMethod(method);
		assertEquals(405, code);
	}
}
