package tt.make.tool;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author administrator
 * 处理类的工具类
 * */
public class ClassTool {
	/**
	 * 添加非空字段校验
	 * 对Object 对象 obj,进行所传入的字段名字列表的值,进行空校验,
	 * @param obj 需要进行空校验的对象
	 * @param names 需要进行空校验的字段的名字列表数组
	 */
	public static String checkClassNull(Object obj, String[] names ,Logger log) {
		if (names.length == 0) {
			return "";
		}
		StringBuffer sb = new StringBuffer();
		// SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			for (String name : names) {
				Object value = invokeGetMethod(obj, name);
				if (value == null) {
					sb.append(name).append(" is null ; ");
				}
			}
		} catch (Exception e) {
			log.error("called checkClassNull() ERR:" + e);
			System.out.println("called checkClassNull() ERR:" + e);
			return "called checkClassNull() ERR:" + e.getMessage();
		}
		if (sb.length() != 0) {
			return "Not allow null:" + sb.toString();
		} else {
			return "";
		}
	}
	/**
	 * @author list 
	 * 
	 * 将class1 class2的相同名称的属性的值 由class1 赋值给 class2 注意 :
	 *         id,serialVersionUID 不赋值
	 *         仅仅 拷贝 基本属性,不拷贝 List,Map,Set(拷贝了对象则可能多对象引用同一地址引起错误)
	 * 目前去掉try catch机制,出现异常都反馈给外层,由外层负责赋值失败后的处理
	 *  目前支持特殊转换处理的有: 
	 *  String     --> int
	 *  String     --> BigDecimal 
	 *  String     --> Boolean 
	 *  String(yyyy-MM-dd|yyyy-MM-dd HH:mm| yyyy-MM-dd HH:mm:ss|Long ) --> java.util.Date 
	 *  BigDecimal --> String 
	 *  BigDecimal --> Int
	 *  int --> BigDecimal
	 *  Long --> java.util.Date	 *  
	 *  sql.Date   --> util.Date 
	 *  util.Date  --> sql.Date
	 *  Boolean    --> String
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("unused")
	public static void reflectionAttr(Object class1, Object class2 ) throws Exception{
		Class<?> clazz1 = Class.forName(class1.getClass().getName());
		Class<?> clazz2 = Class.forName(class2.getClass().getName());
		Field[] fields1 = clazz1.getDeclaredFields();
		Field[] fields2 = clazz2.getDeclaredFields();
		
		for (Field f1 : fields1) {
			if ("id".equals(f1.getName()) || "serialVersionUID".equals(f1.getName())|| "logger".equals(f1.getName())) {
				continue;
			}
			if(isnotBaseClass(f1.getType())) {
				//不是处理的基本类型 不拷贝,  Integer,Long,String,sql.Date,util.Date,BigDecimal
				continue;
			}
			Object oval = invokeGetMethod(class1,f1.getName());
			if (null == oval) {
				continue;
			}
			Field f2 = null;
			for (Field ft : fields2) {
				if(f1.getName().equals(ft.getName())) {
					setMe(f1,oval,class2,ft);
					break;
				}
			}						
		}
	}
	@SuppressWarnings("unused")
	public static void reflectionAttr(Object class1, Object class2 ,List<String> strList) throws Exception{
		Class<?> clazz1 = Class.forName(class1.getClass().getName());
		Class<?> clazz2 = Class.forName(class2.getClass().getName());
		Field[] fields1 = clazz1.getDeclaredFields();
		Field[] fields2 = clazz2.getDeclaredFields();
		
		for (Field f1 : fields1) {
			if ("id".equals(f1.getName()) 
					|| "serialVersionUID".equals(f1.getName())
					|| "logger".equals(f1.getName())
					|| strList.contains(f1.getName())) {
				continue;
			}
			if(isnotBaseClass(f1.getType())) {
				//不是处理的基本类型 不拷贝,  Integer,Long,String,sql.Date,util.Date,BigDecimal
				continue;
			}
			Object oval = invokeGetMethod(class1,f1.getName());
			if (null == oval) {
				continue;
			}
			Field f2 = null;
			for (Field ft : fields2) {
				if(f1.getName().equals(ft.getName())) {
					setMe(f1,oval,class2,ft);
					break;
				}
			}						
		}
	}

	private static void setMe(Field f1,Object oval,Object class2,Field f2) throws Exception {
		if(f2.getType() == f1.getType()) {
			invokeSetMethod(class2,f2.getName(),f2.getType(), oval);
		}else if(f2.getType() == String.class ) {
			// Object to String
			invokeSetMethod(class2,f2.getName(),f2.getType(), oval.toString());
		}else if(f2.getType() == Boolean.class && f1.getType() == String.class) {
			// String to Boolean
			invokeSetMethod(class2,f2.getName(),f2.getType(), Boolean.valueOf((String)oval) );				
		}else if(f2.getType() == Integer.class && f1.getType() == String.class) {
			// String to Int
			invokeSetMethod(class2,f2.getName(),f2.getType(), Integer.parseInt((String)oval) );
		}else if(f2.getType() == Integer.class && f1.getType() == BigDecimal.class) {
			// BigDecimal to Int
			invokeSetMethod(class2,f2.getName(),f2.getType(), ((BigDecimal)oval).intValue() );
		}else if(f2.getType() == BigDecimal.class && f1.getType() == Integer.class) {
			// int to BigDecimal
			invokeSetMethod(class2,f2.getName(),f2.getType(), new BigDecimal((Integer)oval) );
		}else if(f2.getType() == BigDecimal.class && f1.getType() == String.class) {
			// String to BigDecimal
			invokeSetMethod(class2,f2.getName(),f2.getType(), new BigDecimal((String)oval) );
		}else if(f2.getType() == java.util.Date.class && f1.getType() == Long.class) {
			// Long to java.util.Date
			invokeSetMethod(class2,f2.getName(),f2.getType(), new java.util.Date((Long)oval) );
		}else if(f2.getType() == java.util.Date.class && f1.getType() == String.class) {
			// String to java.util.Date
			invokeSetMethod(class2,f2.getName(),f2.getType(), strToDatetime((String)oval) );
		}else if(f2.getType() == java.util.Date.class && f1.getType() == java.sql.Date.class) {
			// java.sql.Date to java.util.Date
			invokeSetMethod(class2,f2.getName(),f2.getType(), 
					new java.util.Date(((java.sql.Date)oval ).getTime()) );
		}else if(f2.getType() == Long.class && f1.getType() == java.util.Date.class) {
			// java.util.Date to Long 
			invokeSetMethod(class2,f2.getName(),f2.getType(), ((Date)oval).getTime() );
			
		}else if(f2.getType() == java.sql.Date.class && f1.getType() == java.util.Date.class) {
			// java.util.Date to java.sql.Date 
			invokeSetMethod(class2,f2.getName(),f2.getType(), 
					new java.sql.Date(((java.util.Date)oval ).getTime()) );
		}
	}
		
	public static String toJson(Object obj) {
		ObjectMapper mapper = new ObjectMapper(); 
	    String jsonStr = null;
	    try {
	       jsonStr = mapper.writeValueAsString(obj);
	    } catch (IOException e) {
	      System.out.println(e.getMessage());
	    }
	    return jsonStr ; 
	}
	
	public static String toJson(Object obj,Logger log) {
		ObjectMapper mapper = new ObjectMapper(); 
	    String jsonStr = null;
	    try {
	       jsonStr = mapper.writeValueAsString(obj);
	    } catch (IOException e) {
	    	log.error("called toJson ERROR . err="+e.getMessage());
	    }
	    return jsonStr ; 
	}
	public static String toStr(Object obj) {
		return toStr(obj,null);
	}
	
	public static String toStr(Object obj,Logger log) {
		if(null == obj) {
			return "";
		}
		
		Class<?> clazz1;
		StringBuffer sb = new StringBuffer();
		if(obj instanceof List) {
			sb.append(" List[");
			for(Object lt :(List<?>)obj) {
				sb.append(toStr(lt,log)).append(",");
			}
			sb.deleteCharAt(sb.length()-1);
			sb.append("] ");
			return sb.toString();
		}
		if(obj instanceof Map) {
			sb.append(" Map[");
			for(Object key :((Map<?, ?>)obj).keySet()) {
				sb.append("key:").append(toStr(key,log))
				.append("val=").append(toStr(((Map<?, ?>)obj).get(key),log)).append(",");
			}
			sb.deleteCharAt(sb.length()-1);
			sb.append("] ");
			return sb.toString();
		}
		if(obj instanceof Set) {
			sb.append(" Set[");
			Iterator<?> it = ((Set<?>)obj).iterator();
			while(it.hasNext()) {
				sb.append(toStr(it.next(),log)).append(",");
			}
			sb.deleteCharAt(sb.length()-1);
			sb.append("] ");
			return sb.toString();
		}
		if(!isnotBaseClass(obj.getClass())) {
			sb.append(obj).append(" ");
			return sb.toString();
		}
		try {
			clazz1 = Class.forName(obj.getClass().getName());
			Field[] fields1 = clazz1.getDeclaredFields();
			for (Field f1 : fields1) {
				if ("serialVersionUID".equals(f1.getName()) ||"logger".equals(f1.getName())) {
					continue;
				}
//				f1.setAccessible(true);
				Object obtt = invokeGetMethod(obj,f1.getName());
				if(null == obtt) {
					sb.append(f1.getName()).append("=").append(obtt).append(",");
				}else if(isnotBaseClass(obtt.getClass())) {
					sb.append(" ").append(f1.getName()).append("=[").append(toStr(obtt,log)).append("],");
				}else {
					sb.append(f1.getName()).append("=").append(obtt).append(",");
				}				
			}	
			sb.deleteCharAt(sb.length()-1);
		}catch(Exception e) {
			if(null != log) {
				log.error("called toStr() ERROR__ , err="+e.getMessage());
			}else {
				System.out.println("called toStr() ERROR__ , err="+e.getMessage());
			}
			return "err";
		}
		return sb.toString();
	}
	/**
	 * 调用 Get方法,获取value值
	 * @param fieldName 需要Get方法的字段名称
	 * */
	private static Object invokeGetMethod(Object clazz, String fieldName) {
		Object obj = null;
		try {
			StringBuffer methodName = new StringBuffer().append("get").append(fieldName.substring(0, 1).toUpperCase())
					.append(fieldName.substring(1));
			Method method = null;
			method = Class.forName(clazz.getClass().getName()).getDeclaredMethod(methodName.toString());
			obj = method.invoke(clazz);
			return obj;
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * 调用 Set方法,映射value值
	 * @param fieldName 需要Get方法的字段名称
	 * @param args[1] 需要射入的值
	 * 可以进行简单的类型转换
	 *   String --> BigDecimal
	 *   
	 * */
	private static void invokeSetMethod(Object clazz, String fieldName,Class<?> fieldType, Object val) throws Exception {
		StringBuffer methodName =new StringBuffer().append("set").append(fieldName.substring(0, 1).toUpperCase()).append(fieldName.substring(1));
		Method method = null;
		Class<?> c = Class.forName(clazz.getClass().getName());
		method = c.getDeclaredMethod(methodName.toString(), fieldType);		
		method.invoke(clazz, val);
	}
	//
	public static String dateToStrLong(java.util.Date dateDate) {  
		if(null == dateDate) {
			return "";
		}
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    String dateString = formatter.format(dateDate);  
	    return dateString;  
	}  
	//String to Date
	public static java.util.Date strToDatetime(String strDate) throws Exception {
		Date strtodate = null;
		if (null == strDate || "".equals(strDate)) {
			return null;
		}
		if (strDate.length() == 10) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			ParsePosition pos = new ParsePosition(0);
			strtodate = formatter.parse(strDate, pos);
		} else if (strDate.length() == 19) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ParsePosition pos = new ParsePosition(0);
			strtodate = formatter.parse(strDate, pos);
		} else if (strDate.length() == 16) {
			strDate = strDate + ":00";
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ParsePosition pos = new ParsePosition(0);
			strtodate = formatter.parse(strDate, pos);
		} else if (isValidLong(strDate)) {
			long timel = Long.parseLong(strDate);
			strtodate = new Date(timel);
		} else {
			return null;
		}
		return strtodate;
	}
	//判断字符串是否可以转换成 long 转换为 date
	private static boolean isValidLong(String str) {
		try {
			Long.parseLong(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	//判断不是处理的类型 Integer,Long,String,sql.Date,util.Date,BigDecimal
	private static boolean isnotBaseClass(Class<?> c) {
		if(c == java.lang.Integer.class 
				|| c == java.lang.Long.class
				|| c == java.lang.String.class
				|| c == java.sql.Date.class
				|| c == java.util.Date.class
				|| c == java.math.BigDecimal.class
				|| c == java.lang.Boolean.class
				|| c == java.lang.Double.class
				|| c == java.lang.Float.class
				|| c == java.lang.Character.class
				) {
			return false;
		}else {
			return true;
		}		
	}
//	public static void pp(Object o) {
//		System.out.println(o);
//	}
	
//	public static class test1 {
//		private String s1 = "s1";
//		private String s2 = "2";
//		private String s3 = "2017-02-21";
//		private java.util.Date date = new Date();
//		private int i1= 1;
//		private BigDecimal b1 = new BigDecimal("22");
//		private Boolean bo = true;
//		public String getS1() {
//			return s1;
//		}
//		public void setS1(String s1) {
//			this.s1 = s1;
//		}
//		public String getS2() {
//			return s2;
//		}
//		public void setS2(String s2) {
//			this.s2 = s2;
//		}
//		public String getS3() {
//			return s3;
//		}
//		public void setS3(String s3) {
//			this.s3 = s3;
//		}
//		public java.util.Date getDate() {
//			return date;
//		}
//		public void setDate(java.util.Date date) {
//			this.date = date;
//		}
//		public int getI1() {
//			return i1;
//		}
//		public void setI1(int i1) {
//			this.i1 = i1;
//		}
//		public BigDecimal getB1() {
//			return b1;
//		}
//		public void setB1(BigDecimal b1) {
//			this.b1 = b1;
//		}
//		public Boolean getBo() {
//			return bo;
//		}
//		public void setBo(Boolean bo) {
//			this.bo = bo;
//		}
//		
//	}
//	public static class test2 {
//		private String s1 ;
//		private BigDecimal s2 ;
//		private java.util.Date s3 ;
//		private java.sql.Date date ;
//		private String i1;
//		private String b1 ;
//		private String bo ;
//		public String getS1() {
//			return s1;
//		}
//		public void setS1(String s1) {
//			this.s1 = s1;
//		}
//		public BigDecimal getS2() {
//			return s2;
//		}
//		public void setS2(BigDecimal s2) {
//			this.s2 = s2;
//		}
//		public java.util.Date getS3() {
//			return s3;
//		}
//		public void setS3(java.util.Date s3) {
//			this.s3 = s3;
//		}
//		public java.sql.Date getDate() {
//			return date;
//		}
//		public void setDate(java.sql.Date date) {
//			this.date = date;
//		}
//		public String getI1() {
//			return i1;
//		}
//		public void setI1(String i1) {
//			this.i1 = i1;
//		}
//		public String getB1() {
//			return b1;
//		}
//		public void setB1(String b1) {
//			this.b1 = b1;
//		}
//		public String getBo() {
//			return bo;
//		}
//		public void setBo(String bo) {
//			this.bo = bo;
//		}
//		
//		
//	}

}
