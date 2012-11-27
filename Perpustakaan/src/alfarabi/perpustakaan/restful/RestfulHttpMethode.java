package alfarabi.perpustakaan.restful;

import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;

import alfarabi.perpustakaan.utility.Constant;

public class RestfulHttpMethode {

	public static String connect(String url, int methodType)throws Exception{
		String result = "{\"errorCode\":\"IB-0000\"}" ;
		
		/*
		 * Set parameter Untuk Http Yang Diperlukan
		 */
		HttpParams httpParams = new BasicHttpParams();
		//=============================================
		//
		
		/*
		 * Set Connection Timeout
		 */
		int timeOut = 600000;
		HttpConnectionParams.setConnectionTimeout(httpParams, timeOut);
		HttpConnectionParams.setSoTimeout(httpParams, timeOut);
		//=======================================================
		//
		
		/*
		 * Set Protocol 
		 */

		HttpProtocolParams.setVersion(httpParams, HttpVersion.HTTP_1_1);
		HttpProtocolParams.setContentCharset(httpParams, HTTP.UTF_8);
		//====================================================
		
		SchemeRegistry schema = new SchemeRegistry();
		schema.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
		
		ClientConnectionManager clientConnectionManager = new ThreadSafeClientConnManager(httpParams, schema);
		
		HttpClient httpClient = new DefaultHttpClient(clientConnectionManager, httpParams);
		ResponseHandler<String> handler = new BasicResponseHandler();
		
		
		HttpUriRequest request ;
		switch (methodType) {
		
		case Constant.RestTechnic.REST_GET:
			request = new HttpGet(url);
			break;
		case Constant.RestTechnic.REST_PUT:
			request = new HttpPut();
			break;
		case Constant.RestTechnic.REST_POST:
			request = new HttpPost();
			break;
		case Constant.RestTechnic.REST_DELETE:
			request = new HttpDelete();
			break;

		default:
			request = new HttpGet();
			break;
		}
		
		return result = httpClient.execute(request, handler);
	}
}
