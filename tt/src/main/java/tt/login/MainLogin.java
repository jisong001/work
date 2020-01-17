package tt.login;

import java.io.File;

import javax.imageio.ImageIO;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainLogin {
	private String host = "kq.neusoft.com";
	private String accept = "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8";
	private String connection = "Keep-Alive";
	private String useragent = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.75 Safari/537.36";
	private String cookie = null;
	private String fname = null;
	private String fpass = null;
	private String fpic = null;
	private String fpicpass = null;
	private String fkey = null;
	private Boolean login = false;
	private String ffkey = null;
	
	public String getPostReq() {
		StringBuffer sb = new StringBuffer();
		sb.append("login=true&neusoft_attendance_online=&").append(ffkey).append("=&neusoft_key=");
		sb.append(reStr(fkey)).append("&");
		sb.append(reStr(fname)).append("=").append("li-sht").append("&");
		sb.append(reStr(fpass)).append("=").append("1q2w3e4r%21Q%40W%23E%24R").append("&");
		sb.append(reStr(fpic)).append("=").append(fpicpass);		
		return sb.toString();
	}
	private String reStr(String str) {
		return str.replace("!", "%21");
	}

 
    /**
     * 向指定 URL 发送POST方法的请求
     * @param url 发送请求的 URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public String sendPost(String url, String param) {
    	PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
            conn.setRequestProperty("connection", "keep-alive");
            conn.setRequestProperty("user-agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.75 Safari/537.36");
            conn.setRequestProperty("Host", "kq.neusoft.com");
            conn.setRequestProperty("Origin", "http://kq.neusoft.com");
            conn.setRequestProperty("Referer", "http://kq.neusoft.com/");
            conn.setRequestProperty("Cookie", cookie);
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Accept-Encoding", "gzip, deflate");//Accept-Encoding: gzip, deflate
            conn.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8");//Accept-Language: zh-CN,zh;q=0.9,en;q=0.8
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            //1.获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            //2.中文有乱码的需要将PrintWriter改为如下
//            out=new OutputStreamWriter(conn.getOutputStream(),"UTF-8");
            // 发送请求参数
            out.write(param);//.print(param);
            // flush输出流的缓冲
            out.flush();
            Map<String, List<String>> map = conn.getHeaderFields();
            if(map.containsKey("Location")) {
            	List<String> listStr = map.get("Location");
            	ll(listStr);    
            	if(listStr.get(0).indexOf("attendance.jsp")>1) {
            		login = true;
            	}else {
            		login = false;
            	}
            }
            for (String key : map.keySet()) {
                System.out.println(key + "---p--->" + map.get(key));
            }
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        System.out.println("post推送结果："+result);
        return result;
    }
    


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainLogin ml = new MainLogin();
		ml.dowhile();
//		if(ml.isNumeric0("6026")) {
//			ml.ll("is ");
//		}else {
//			ml.ll("no ");
//		}
	}
	
	public void dowhile() {
//		String imgurl = "D:\\imageRandeCode.jpg";
//		String code = executeTess4J(imgurl);
//		System.out.println("--- "+code);
		
		String s1 = sendGet("http://kq.neusoft.com/", null,null);
		ll("s1 = " + s1);
		if (null != cookie) {
			ll("cookie = " + cookie);
			String ss = getImg();
			if(isNumeric0(ss)) {
				fpicpass = ss;
				ll("fpicpass = " + fpicpass);
				String postbody = getPostReq();
				ll("postbody = " + postbody);
				if (null != fname && null != fpass && null != fpic && null != fpicpass && null != fkey) {
					String ps = sendPost("http://kq.neusoft.com/login.jsp", postbody);
					ll("ps = " + ps);
					ll("login => " + login);
					if (login) {
						ll(" login in --> .");
						// String s2 = sendGet("http://kq.neusoft.com/attendance.jsp", null,cookie);
						// ll("s2 = "+ s2);
						// String ps2 = sendPost("http://kq.neusoft.com/record.jsp" , null);
						// ll("ps2 = "+ ps2);
					}
				}else {
					ll(" error has null .");
				}
			}else {
				ll(" error fpicpass not number . = "+fpicpass );
			}
		}else {
			ll(" error cookie is null");
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
            conn.setRequestProperty("accept", accept);
            conn.setRequestProperty("connection", connection);
            conn.setRequestProperty("user-agent", useragent);
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
            		ll("Get fname is === "+fname);
            	}
            	if(line.indexOf("<input type=\"password\" class=\"textfield\" name=\"")>0) {
            		String s = line.substring(line.indexOf("<input type=\"password\" class=\"textfield\" name=\"")+47);
            		String s2 = s.substring(0,s.indexOf("\" />"));
            		fpass = s2 ;
            		ll("Get fpass is === "+fpass);
            	}
            	if(line.indexOf("type=\"hidden\" name=\"neusoft_key\" value=\"")>0) {
            		String s = line.substring(line.indexOf("type=\"hidden\" name=\"neusoft_key\" value=\"")+40);
            		String s2 = s.substring(0,s.indexOf("\" />"));
            		fkey = s2 ;
            		ll("Get fkey is === "+fkey);
            	}
            	if(line.indexOf("#707070;\"   name=\"")>0) {
            		String s = line.substring(line.indexOf("#707070;\"   name=\"")+18);
            		String s2 = s.substring(0,s.indexOf("\" />"));
            		fpic = s2 ;
            		ll("Get fpic is === "+fpic);
            	}
            	if(line.indexOf("<input type=\"text\" name=\"KEY")>0) {
            		String s = line.substring(line.indexOf("<input type=\"text\" name=\"KEY")+25);
            		String s2 = s.substring(0,s.indexOf("\" />"));
            		ffkey = s2 ;
            		ll("Get fpic is === "+fpic);
            	}
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
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
            e.printStackTrace();
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
	public static String executeTess4J(String imgUrl){
		//https://github.com/tesseract-ocr/tessdata
        String ocrResult = "";
        try{
            ImageIO.scanForPlugins();
            ITesseract instance = new Tesseract();
            instance.setLanguage("eng");
            File imgDir = new File(imgUrl);
            ocrResult = instance.doOCR(imgDir);
        }catch (TesseractException e){
            e.printStackTrace();
        }
        return ocrResult;
    }
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
