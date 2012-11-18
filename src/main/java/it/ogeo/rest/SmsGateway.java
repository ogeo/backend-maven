/**
 * 
 */
package it.ogeo.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParamBean;
import org.apache.http.util.EntityUtils;

/**
 * @author micheleorsi
 *
 */
@Path("/sms")
public class SmsGateway {
	
	
	public static String sendSms(String number, String problem, String name) throws IOException {
//		Invio singolo
		String [] recipients = new String[]{number};
//		Invio multiplo
//		String [] recipients = new String[]{"393471234567","393477654321"};

		String username = "hackathon-whymca";
		String password = "whymca";

		// Invio SMS Classic con mittente personalizzato di tipo alfanumerico
		String result = skebbyGatewaySendSMS(username, password, recipients, "Salve, c'e' questo tipo di problema a casa/ufficio: "+problem, "send_sms_classic", null, name);
		
		// Invio SMS Basic
		// String result = skebbyGatewaySendSMS(username, password, recipients, "Hi Mike, how are you?", "send_sms_basic", null, null);
		 
		// Invio SMS Classic con mittente personalizzato di tipo numerico
		// String result = skebbyGatewaySendSMS(username, password, recipients, "Hi Mike, how are you?", "send_sms_classic", "393471234567", null);
		 
		// Invio SMS Classic con notifica(report) con mittente personalizzato di tipo alfanumerico - Invio SMS Classic Plus
		// String result = skebbyGatewaySendSMS(username, password, recipients, "Hi Mike, how are you?", "send_sms_classic_report", null, "John");

		// Invio SMS Classic con notifica(report) con mittente personalizzato di tipo numerico - Invio SMS Classic Plus
		// String result = skebbyGatewaySendSMS(username, password, recipients, "Hi Mike, how are you?", "send_sms_classic_report", "393471234567", null);

		return "result: "+result;
	}

	protected static String skebbyGatewaySendSMS(String username, String password, String [] recipients, String text, String smsType, String senderNumber, String senderString) throws IOException{
		return skebbyGatewaySendSMS(username, password, recipients, text, smsType,  senderNumber,  senderString, "UTF-8");
	}
	
	protected static String skebbyGatewaySendSMS(String username, String password, String [] recipients, String text, String smsType, String senderNumber, String senderString, String charset) throws IOException{
		String endpoint = "http://gateway.skebby.it/api/send/smseasy/advanced/http.php";
		HttpParams params = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(params, 10*1000);
		DefaultHttpClient httpclient = new DefaultHttpClient(params);
		HttpProtocolParamBean paramsBean = new HttpProtocolParamBean(params);
		paramsBean.setVersion(HttpVersion.HTTP_1_1);
		paramsBean.setContentCharset(charset);
		paramsBean.setHttpElementCharset(charset);
		
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("method", smsType));
		formparams.add(new BasicNameValuePair("username", username));
		formparams.add(new BasicNameValuePair("password", password));
		if(null != senderNumber)
			formparams.add(new BasicNameValuePair("sender_number", senderNumber));
		if(null != senderString)
			formparams.add(new BasicNameValuePair("sender_string", senderString));
		
		for (String recipient : recipients) {
			formparams.add(new BasicNameValuePair("recipients[]", recipient));
		}
		formparams.add(new BasicNameValuePair("text", text));
		
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, charset);
		HttpPost post = new HttpPost(endpoint);
		post.setEntity(entity);
		
		HttpResponse response = httpclient.execute(post);
		HttpEntity resultEntity = response.getEntity();
		if(null != resultEntity){
			return EntityUtils.toString(resultEntity);
		}
		return null;
	}
}
