package tt.login;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.imageio.ImageIO;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainLogin {
	private String user = null;
	private String pass = null;	
	private int retryNumber = 7;
	private String host = "kq.neusoft.com";
	private String accept = "text/html, application/xhtml+xml, image/jxr, */*";
	private String connection = "Keep-Alive";
	private String useragent = "Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko";
	private String cookie = null;
	private String fname = null;
	private String fpass = null;
	private String fpic = null;
	private String fpicpass = null;
	private String fkey = null;
	private Boolean login = false;
	private String ffkey = null;
	private String currentempoid = null;
	
	public static void main(String[] args) throws Exception  {
		// TODO Auto-generated method stub
		MainLogin ml = new MainLogin();
		if(ml.getUP()) {
			System.out.println("------ next start... ");
			ml.dowhile();
		}
//		
		
//		if(ml.isNumeric0("6026")) {
//			ml.ll("is ");
//		}else {
//			ml.ll("no ");
//		}
	}
	public Boolean getUP() throws Exception {
		Properties properties = new Properties();
//        InputStream inputStream = Object.class.getResourceAsStream("At.properties");
        InputStream inputStream = new FileInputStream("At.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        user = (String) properties.get("User");
        pass = (String) properties.get("Pass");
        if(null == user || null == pass || user.length()<=1 || pass.length()<=1) {
        	ll(" ERROR: ---> get User|Pass error . user="+user+";pass="+pass);
        	return false;
        }else {
        	ll(" login user = "+user+" ; pass = "+pass);
        	return true;
        }
	}
	
	public String getPostReq() throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("login=true&neusoft_attendance_online=&")
		.append(ffkey).append("=&neusoft_key=").append(reStr(fkey)).append("&")
		.append(reStr(fname)).append("=").append(reStr(user)).append("&")
		.append(reStr(fpass)).append("=").append(reStr(pass)).append("&")
		.append(reStr(fpic)).append("=").append(fpicpass);		
		return sb.toString();
	}
	public Map<String, String> getPostReqM() {
		Map<String, String> pm = new HashMap<String, String>();
		pm.put("login", "true");
		pm.put("neusoft_attendance_online", "");
		pm.put(ffkey, "");
		pm.put("neusoft_key", fkey);
		pm.put(fname, user);
		pm.put(fpass, pass);
		pm.put(fpic, fpicpass);
		return pm;
	}
	private String reStr(String str) throws Exception {
//		return str.replace("!", "%21");
		return URLEncoder.encode(str, "utf-8");
	}

	public String requestOCRForHttp(String url, Map<String, String> requestParams) throws Exception {
		String result = null;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		/** HttpPost */
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Cookie", cookie);
		ll(" post set Cookie = "+cookie);
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		Iterator<Entry<String, String>> it = requestParams.entrySet().iterator();
//		System.out.println(params.toString());
		while (it.hasNext()) {
			Entry<String, String> en = it.next();
			String key = en.getKey();
			String value = en.getValue();
			if (value != null) {
				params.add(new BasicNameValuePair(key, value));
			}
		}
		httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
		/** HttpResponse */
		CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
		try {
			HttpEntity httpEntity = httpResponse.getEntity();
			result = EntityUtils.toString(httpEntity, "utf-8");
			EntityUtils.consume(httpEntity);
			if (result.indexOf("attendance.jsp") > 1) {
				login = true;
				ll(".........login result is ok");
			}
		} finally {
			try {
				if (httpResponse != null) {
					httpResponse.close();
				}
			} catch (IOException e) {
				ll("## release resouce error ##" + e);
			}
		}
//		ll(" post result = "+result);
		return result;
	}

	public void dowhile() throws Exception {
		// String imgurl = "D:\\imageRandeCode.jpg";
		// String code = executeTess4J(imgurl);
		// System.out.println("--- "+code);

		String s1 = sendGet("http://kq.neusoft.com/", null, null);
//		ll("s1 = " + s1);
		try {
			if (null != cookie) {
				ll("cookie = " + cookie);
				String ss = getImg();
				if (isNumeric0(ss)) {
					fpicpass = ss;
					ll("fpicpass = " + fpicpass);
					String postbody = getPostReq();
					ll("postbody = " + postbody);
					if (null != fname && null != fpass && null != fpic && null != fpicpass && null != fkey) {
						// String ps = sendPost("http://kq.neusoft.com/login.jsp", postbody);
						String ps = requestOCRForHttp("http://kq.neusoft.com/login.jsp", getPostReqM());
//						ll("ps = " + ps);
						ll("login => " + login);
						if (login) {							
							ll(" login in --> .");
							currentempoid = null;
							 String s2 = sendGet("http://kq.neusoft.com/attendance.jsp", null,cookie);
//							 ll("s2 = "+ s2);
							if (null != currentempoid) {
								Thread.sleep(1000 * 3);
								Map<String, String> bod = new HashMap<String, String>();
								bod.put("currentempoid", currentempoid);
								bod.put("browser", "Chrome");
								String ps2 = requestOCRForHttp("http://kq.neusoft.com/record.jsp",bod);
								ll("++++++++++++++++++++++++++++++++++++++++++++++ ok end ." );
							}
						}
					} else {
						ll(" error has null .");
					}
				} else {
					ll(" error fpicpass not number . = " + fpicpass);
				}
			} else {
				ll(" error cookie is null");
			}
		} catch (Exception e) {
			ll("====== Exception : " + e.getMessage());
		}
		if (!login) {
			Thread.sleep(1000 * 20);
			ll("-----------------------------------------------------------");
			ll("--------    retry   (" + retryNumber + ")       --------------------------------");
			ll("-----------------------------------------------------------");
			if (retryNumber > 0) {
				retryNumber--;
				dowhile();
			}
		}
	}

	public static void ll(Object o) {
		System.out.println(o);
	}
	public static void ll(List<Object> lio) {
		for(Object obj :lio) {
			ll(obj);
		}
	}
	
    public String sendGet(String url, String param,String cook) {
        String result = "";
        BufferedReader in = null;
        try {
        	String urlNameString = url;
        	if(null != param) {
        		urlNameString = url + "?" + param;
        	}
            URL realUrl = new URL(urlNameString);
            URLConnection conn = realUrl.openConnection();
            conn.setRequestProperty("Accept", accept);
            conn.setRequestProperty("Connection", connection);
            conn.setRequestProperty("User-agent", useragent);
            conn.setRequestProperty("Host", host);
            if(null != cook) {
            	conn.setRequestProperty("Cookie", cook);
            }
            conn.connect();
            Map<String, List<String>> map = conn.getHeaderFields();
            if(map.containsKey("Set-Cookie")) {
            	List<String> listStr = map.get("Set-Cookie");
            	ll(listStr);    
            	cookie = listStr.get(0).substring(0, listStr.get(0).indexOf(";"));
            	ll("Get cookie is === "+cookie);
            }
//            for (String key : map.keySet()) {
//                System.out.println(key + "--->" + map.get(key));
//            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
            	if(line.indexOf("<input type=\"text\" class=\"textfield\" name=\"")>0) {
            		String s = line.substring(line.indexOf("<input type=\"text\" class=\"textfield\" name=\"")+43);
            		String s2 = s.substring(0,s.indexOf("\" id=\""));
            		fname = s2 ;
//            		ll("Get fname is === "+fname);
            	}
            	if(line.indexOf("<input type=\"password\" class=\"textfield\" name=\"")>0) {
            		String s = line.substring(line.indexOf("<input type=\"password\" class=\"textfield\" name=\"")+47);
            		String s2 = s.substring(0,s.indexOf("\" />"));
            		fpass = s2 ;
//            		ll("Get fpass is === "+fpass);
            	}
            	if(line.indexOf("type=\"hidden\" name=\"neusoft_key\" value=\"")>0) {
            		String s = line.substring(line.indexOf("type=\"hidden\" name=\"neusoft_key\" value=\"")+40);
            		String s2 = s.substring(0,s.indexOf("\" />"));
            		fkey = s2 ;
//            		ll("Get fkey is === "+fkey);
            	}
            	if(line.indexOf("#707070;\"   name=\"")>0) {
            		String s = line.substring(line.indexOf("#707070;\"   name=\"")+18);
            		String s2 = s.substring(0,s.indexOf("\" />"));
            		fpic = s2 ;
//            		ll("Get fpic is === "+fpic);
            	}
            	if(line.indexOf("<input type=\"text\" name=\"KEY")>0) {
            		String s = line.substring(line.indexOf("<input type=\"text\" name=\"KEY")+25);
            		String s2 = s.substring(0,s.indexOf("\" />"));
            		ffkey = s2 ;
//            		ll("Get fpic is === "+fpic);
            	}
            	if(line.indexOf("put type=\"hidden\" name=\"currentempoid\" value=\"")>0) {
            		String s = line.substring(line.indexOf("put type=\"hidden\" name=\"currentempoid\" value=\"")+46);
            		String s2 = s.substring(0,s.indexOf("\">"));
            		currentempoid = s2 ;
//            		ll("Get currentempoid is === "+currentempoid);
            	}
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
//            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
    	
    public String getImg() {
        String result = "";
        BufferedReader in = null;
        try {
        	String urlNameString = "http://kq.neusoft.com/imageRandeCode";
            URL realUrl = new URL(urlNameString);
            URLConnection conn = realUrl.openConnection();
            conn.setRequestProperty("accept", accept);
            conn.setRequestProperty("connection", connection);
            conn.setRequestProperty("user-agent", useragent);
            conn.setRequestProperty("Host", host);
            conn.setRequestProperty("Cookie", cookie);
            
            conn.connect();  
//            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            BufferedImage image = ImageIO.read(conn.getInputStream());
            String imagepas = this.executeTess4J(image);
            ll("Get imagepas is === "+imagepas);
            fpicpass = imagepas.replaceAll("\r|\n", "");;
            return fpicpass;
        } catch (Exception e) {
            System.out.println(" getImg 请求出现异常！" + e);
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }	
//	public static String executeTess4J(String imgUrl){
//		//https://github.com/tesseract-ocr/tessdata
//        String ocrResult = "";
//        try{
//            ImageIO.scanForPlugins();
//            ITesseract instance = new Tesseract();
//            instance.setLanguage("eng");
//            File imgDir = new File(imgUrl);
//            ocrResult = instance.doOCR(imgDir);
//        }catch (TesseractException e){
//            e.printStackTrace();
//        }
//        return ocrResult;
//    }
	public static String executeTess4J(BufferedImage image){
		//https://github.com/tesseract-ocr/tessdata
        String ocrResult = "";
        try{
            ImageIO.scanForPlugins();
            ITesseract instance = new Tesseract();
            instance.setLanguage("eng");
            ocrResult = instance.doOCR(image);
        }catch (TesseractException e){
            e.printStackTrace();
        }
        return ocrResult;
    }
//	public boolean isNumeric(String str)
//	{
//		for (int i = 0; i < str.length(); i++)
//		{
//			if (!Character.isDigit(str.charAt(i))){
//				return false;
//			}
//		}
//		return true;
//	}
	public boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
 }

	public boolean isNumeric0(String str) {
		for (int i = str.length(); --i >= 0;) {
			int chr = str.charAt(i);
			if (chr < 48 || chr > 57)
				return false;
		}
		return true;
	}
}
