package cn.com.mx.webapi.servlet.integration;

import static org.junit.Assert.assertEquals;

import java.io.UnsupportedEncodingException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.DeleteMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;

public abstract class BaseResourceTestCase {
	public static final String CONTENT_TYPE_JSON = "application/json";
	public static final String CONTENT_TYPE_XML = "application/xml";
	public static final String CHARSET_UTF8 = "UTF-8";
	public static final String DEFAULT_CONTENT_TYPE = CONTENT_TYPE_JSON + ";charset=" + CHARSET_UTF8;
	public static final String DEFAULT_ACCEPT = CONTENT_TYPE_JSON;
	public static final String DEFAULT_DEVICE = "Android/5.1.1/Mi-4c/1234";
	public static final String DEFAULT_APP = "1.0.1/from";

	protected static final String urlPrefix = "http://localhost:8080/venus-api-servlet/";
	
	protected String resourceUrl;
	
	protected HttpClient client = new HttpClient();

	protected PutMethod puttingMethod() {
		return doCreateMethod(PutMethod.class);
	}

	protected PutMethod puttingMethod(String jsonEntityString) {
		PutMethod m = puttingMethod();
		try {
			m.setRequestEntity(new StringRequestEntity(jsonEntityString,
					CONTENT_TYPE_JSON, CHARSET_UTF8));
		} catch (UnsupportedEncodingException e) {
			return null;
		}
		return m;
	}

	protected GetMethod gettingMethod() {
		return doCreateMethod(GetMethod.class);
	}

	protected PostMethod postingMethod() {
		return doCreateMethod(PostMethod.class);
	}

	protected PostMethod postingMethod(String jsonEntityString) {
		PostMethod m = postingMethod();
		try {
			m.setRequestEntity(new StringRequestEntity(jsonEntityString,
					CONTENT_TYPE_JSON, CHARSET_UTF8));
		} catch (UnsupportedEncodingException e) {
			return null;
		}
		return m;
	}

	protected DeleteMethod deletingMethod() {
		return doCreateMethod(DeleteMethod.class);
	}

	private <T extends HttpMethod> T doCreateMethod(Class<T> clazz) {
		try {
			T m = clazz.getConstructor(String.class).newInstance(resourceUrl);
			m.addRequestHeader("Accept", DEFAULT_ACCEPT);
			m.addRequestHeader("Content-Type", DEFAULT_CONTENT_TYPE);
			m.addRequestHeader("x-gomeplus-device", DEFAULT_DEVICE);
			m.addRequestHeader("x-gomeplus-app", DEFAULT_APP);
			return m;
		} catch (Exception e) {
			return null;
		}
	}

	protected static void assertDefaultResponse(HttpMethod method, int code) {
		assertEquals(200, code);
		assertEquals(DEFAULT_CONTENT_TYPE, method.getResponseHeader("Content-Type").getValue().toString());
	}

}
