package tt.make.tool;


import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Random;

public class DateUtil {
	/** 
	 * ��ȡ����ʱ��,������� 
	 *  
	 * @return���س�ʱ���ʽ yyyy-MM-dd HH:mm:ss 
	 */  
	public static Date getSqlDate() {  
	    Date sqlDate = new java.sql.Date(System.currentTimeMillis());  
	    return sqlDate;  
	}  
	  
	/** 
	 * ��ȡ����ʱ�� 
	 *  
	 * @return���س�ʱ���ʽ yyyy-MM-dd HH:mm:ss 
	 */  
	public static Date getNowDate() {  
	    Date currentTime = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    String dateString = formatter.format(currentTime);  
	    ParsePosition pos = new ParsePosition(8);  
	    Date currentTime2 = formatter.parse(dateString, pos);  
	    return currentTime2;  
	}  
	
	/** 
	 * ��ȡ���տ�ʼʱ�� 
	 *  
	 * @return���س�ʱ���ʽ yyyy-MM-dd HH:mm:ss 
	 */  
	public static Date getTodayStartTime() {
		Calendar todayStart = Calendar.getInstance();
		todayStart.set(Calendar.HOUR_OF_DAY, 0);
		todayStart.set(Calendar.MINUTE, 0);
		todayStart.set(Calendar.SECOND, 0);
		todayStart.set(Calendar.MILLISECOND, 0);
		return todayStart.getTime();
	}
	
	/** 
	 * ��ȡ���ս���ʱ�� 
	 *  
	 * @return���س�ʱ���ʽ yyyy-MM-dd HH:mm:ss 
	 */  
	public static Date getTodayEndTime() {
		Calendar todayEnd = Calendar.getInstance();
		todayEnd.set(Calendar.HOUR_OF_DAY, 23);
		todayEnd.set(Calendar.MINUTE, 59);
		todayEnd.set(Calendar.SECOND, 59);
		todayEnd.set(Calendar.MILLISECOND, 999);
		return todayEnd.getTime();
	}
	  
	/** 
	 * ��ȡ����ʱ�� 
	 *  
	 * @return���ض�ʱ���ʽ yyyy-MM-dd 
	 */  
	public static Date getNowDateShort() {  
	    Date currentTime = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
	    String dateString = formatter.format(currentTime);  
	    Date currentTime2 = null;
		try {
			currentTime2 = formatter.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}  
	    return currentTime2;  
	}  
	  
	/** 
	 * ��ȡ����ʱ�� 
	 *  
	 * @return�����ַ�����ʽ yyyy-MM-dd HH:mm:ss 
	 */  
	public static String getStringDate() {  
	    Date currentTime = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    String dateString = formatter.format(currentTime);  
	    return dateString;  
	}  
	
	/** 
	 * ��ȡ����ʱ�� 
	 *  
	 * @return�����ַ�����ʽ yyyy-MM-dd HH:mm:ss 
	 */  
	public static String getStringDateYYYYMMDD() {  
		Date currentTime = new Date();  
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");  
		String dateString = formatter.format(currentTime);  
		return dateString;  
	}  
	  
	/** 
	 * ��ȡ����ʱ�� 
	 *  
	 * @return ���ض�ʱ���ַ�����ʽyyyy-MM-dd 
	 */  
	public static String getStringDateShort() {  
	    Date currentTime = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
	    String dateString = formatter.format(currentTime);  
	    return dateString;  
	}  
	  
	/** 
	 * ��ȡʱ�� Сʱ:��;�� HH:mm:ss 
	 *  
	 * @return 
	 */  
	public static String getTimeShort() {  
	    SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");  
	    Date currentTime = new Date();  
	    String dateString = formatter.format(currentTime);  
	    return dateString;  
	}

	
	
	/** 
	 * ����ʱ���ʽ�ַ���ת��Ϊʱ�� yyyy-MM-dd HH:mm:ss 
	 *  
	 * @param strDate 
	 * @return 
	 */  
	public static Date strToDateLong(String strDate) {
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    formatter.setLenient(false);
	    ParsePosition pos = new ParsePosition(0);  
	    Date strtodate = formatter.parse(strDate, pos);  
	    return strtodate;  
	}
	
	public static Date strToDatetime(String strDate) throws Exception {
		Date strtodate = null;
			if(strDate.length() == 10) {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
			    formatter.setLenient(false);
				ParsePosition pos = new ParsePosition(0);  
				strtodate = formatter.parse(strDate, pos);  
			}else if(strDate.length() == 19) {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
			    formatter.setLenient(false);
				ParsePosition pos = new ParsePosition(0);  
				strtodate = formatter.parse(strDate, pos);  
			}else if(strDate.length() == 16) {
				strDate = strDate + ":00";
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
			    formatter.setLenient(false);
				ParsePosition pos = new ParsePosition(0);  
				strtodate = formatter.parse(strDate, pos);  
			}else if(isValidLong(strDate)) {
				long timel = Long.parseLong(strDate);
				strtodate = new Date(timel);  
			}else {
				return null;
			}
	    return strtodate;  
	}
	public static boolean isValidLong(String str){
		   try{
		       Long.parseLong(str);
		       return true;
		   }catch(NumberFormatException e){
		     return false;
		   }
		}
	  
	/** 
	 * ����ʱ���ʽʱ��ת��Ϊ�ַ��� yyyy-MM-dd HH:mm:ss 
	 *  
	 * @param dateDate 
	 * @return 
	 */  
	public static String dateToStrLong(java.util.Date dateDate) {  
		if(null == dateDate) {
			return "";
		}
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    String dateString = formatter.format(dateDate);  
	    return dateString;  
	}  
	  
	/** 
	 * ����ʱ���ʽʱ��ת��Ϊ�ַ��� yyyy-MM-dd 
	 *  
	 * @param dateDate 
	 * @param k 
	 * @return 
	 */  
	public static String dateToStrShort(java.util.Date dateDate) { 
		if(null == dateDate) {
			return "";
		}
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
	    String dateString = formatter.format(dateDate);  
	    return dateString;  
	}
	public static String dateToStrShortTime(java.util.Date dateDate) {  
		if(null == dateDate) {
			return "";
		}
	    SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");  
	    String dateString = formatter.format(dateDate);  
	    return dateString;  
	}
	
	public static Date dateToDate(java.util.Date dateDate) {
		if(null == dateDate) {
			return null;
		}
	    String strDateShot = dateToStrShort(dateDate);
	    strDateShot += " 00:00:00";
	    Date date;
		try {
			date = strToDatetime(strDateShot);
			return date;
		} catch (Exception e) {
			return null;
		}
	}
	
	/** 
	 * ����ʱ���ʽ�ַ���ת��Ϊʱ�� yyyy-MM-dd 
	 *  
	 * @param strDate 
	 * @return 
	 */  
	public static Date strToDate(String strDate) {  
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
	    formatter.setLenient(false);
	    ParsePosition pos = new ParsePosition(0);  
	    Date strtodate = formatter.parse(strDate, pos);  
	    return strtodate;  
	}  
	  
	/** 
	 * �õ�����ʱ�� 
	 *  
	 * @return 
	 */  
	public static Date getNow() {  
	    Date currentTime = new Date();  
	    return currentTime;  
	}  
	  
	/** 
	 * ��ȡһ�����е����һ�� 
	 *  
	 * @param day 
	 * @return 
	 */  
	public static Date getLastDate(long day) {  
	    Date date = new Date();  
	    long date3hm = date.getTime() - 3600000 * 34 * day;  
	    Date date3hmDate = new Date(date3hm);  
	    return date3hmDate;  
	}  
	  
	/** 
	 * �õ�����ʱ�� 
	 *  
	 * @return �ַ��� yyyyMMdd HHmmss 
	 */  
	public static String getStringToday() {  
	    Date currentTime = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd HHmmss");  
	    String dateString = formatter.format(currentTime);  
	    return dateString;  
	}  
	  
	/** 
	 * �õ�����Сʱ 
	 */  
	public static String getHour() {  
	    Date currentTime = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    String dateString = formatter.format(currentTime);  
	    String hour;  
	    hour = dateString.substring(11, 13);  
	    return hour;  
	}  
	  
	/** 
	 * �õ����ڷ��� 
	 *  
	 * @return 
	 */  
	public static String getTime() {  
	    Date currentTime = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    String dateString = formatter.format(currentTime);  
	    String min;  
	    min = dateString.substring(14, 16);  
	    return min;  
	}  
	  
	/** 
	 * �����û������ʱ���ʾ��ʽ�����ص�ǰʱ��ĸ�ʽ �����yyyyMMdd��ע����ĸy���ܴ�д�� 
	 *  
	 * @param sformat 
	 *            yyyyMMddhhmmss 
	 * @return 
	 */  
	public static String getUserDate(String sformat) {  
	    Date currentTime = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat(sformat);  
	    String dateString = formatter.format(currentTime);  
	    return dateString;  
	}  
	  
	/** 
	 * ����Сʱʱ���Ĳ�ֵ,���뱣֤����ʱ�䶼��"HH:MM"�ĸ�ʽ�������ַ��͵ķ��� 
	 */  
	public static String getTwoHour(String st1, String st2) {  
	    String[] kk = null;  
	    String[] jj = null;  
	    kk = st1.split(":");  
	    jj = st2.split(":");  
	    if (Integer.parseInt(kk[0]) < Integer.parseInt(jj[0]))  
	        return "0";  
	    else {  
	        double y = Double.parseDouble(kk[0]) + Double.parseDouble(kk[1])  
	                / 60;  
	        double u = Double.parseDouble(jj[0]) + Double.parseDouble(jj[1])  
	                / 60;  
	        if ((y - u) > 0) { 
	            return y - u + "";  
	        }else { 
	            return "0";  
	        }    
	    }  
	}  
	
	/** 
	 * �õ��������ڼ�ļ������ 
	 */  
	public static String getTwoDay(Date beginTime, Date endTime) {  
	    long day = 0;  
	    try {    
	        day = (endTime.getTime() - beginTime.getTime()) / (24 * 60 * 60 * 1000);  
	    } catch (Exception e) {  
	        return "";  
	    }  
	    return day + "";  
	}
	  
	/** 
	 * �õ��������ڼ�ļ������ 
	 */  
	public static String getTwoDay(String sj1, String sj2) {  
	    SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");  
	    myFormatter.setLenient(false);
	    long day = 0;  
	    try {  
	        java.util.Date date = myFormatter.parse(sj1);  
	        java.util.Date mydate = myFormatter.parse(sj2);  
	        day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);  
	    } catch (Exception e) {  
	        return "";  
	    }  
	    return day + "";  
	}
	
	/** 
	 * �õ��������ڼ�ļ������ 
	 */  
	public static String getTwoDayTime(String beijianshu, String jianshu) {  
	    SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    myFormatter.setLenient(false);
	    long day = 0;  
	    try {  
	        java.util.Date date = myFormatter.parse(beijianshu);  
	        java.util.Date mydate = myFormatter.parse(jianshu);  
	        day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);  
	    } catch (Exception e) {  
	        return "";  
	    }  
	    return day + "";  
	}
	  
	/** 
	 * ʱ��ǰ�ƻ���Ʒ���,����JJ��ʾ����. 
	 */  
	public static String getPreTime(String sj1, String jj) {  
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    format.setLenient(false);
	    String mydate1 = "";  
	    try {  
	        Date date1 = format.parse(sj1);  
	        long time = (date1.getTime() / 1000) + Integer.parseInt(jj) * 60;  
	        date1.setTime(time * 1000);  
	        mydate1 = format.format(date1);  
	    } catch (Exception e) {  
	    }  
	    return mydate1;  
	}  
	  
	/** 
	 * �õ�һ��ʱ���Ӻ��ǰ�Ƽ����ʱ��,nowdateΪʱ��,delayΪǰ�ƻ���ӵ����� 
	 */  
	public static String getNextDay(String nowdate, String delay) {  
	    try {  
	        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
		    format.setLenient(false);
	        String mdate = "";  
	        Date d = strToDate(nowdate);  
	        long myTime = (d.getTime() / 1000) + Integer.parseInt(delay) * 24  
	                * 60 * 60;  
	        d.setTime(myTime * 1000);  
	        mdate = format.format(d);  
	        return mdate;  
	    } catch (Exception e) {  
	        return "";  
	    }  
	}  
	
	/** 
	 * �õ�һ��ʱ��ǰ�Ƽ����ʱ���,nowdateΪʱ��,delayΪǰ�ƻ���ӵ����� 
	 */  
	public static String getPreviousDay(Date nowdate, String delay) {  
		
	    try {  
	        String previousTime = "";   
	        long myTime = (nowdate.getTime() / 1000) - Integer.parseInt(delay) * 24  
	                * 60 * 60;  
	        nowdate.setTime(myTime * 1000);  
	        previousTime = Long.toString(nowdate.getTime());  
	        return previousTime;  
	    } catch (Exception e) {  
	        return "";  
	    }  
	} 
	  
	/** 
	 * �õ�һ��ʱ��ǰ�Ƽ����ʱ�䣨Date��,nowdateΪʱ��,delayΪǰ�ƻ���ӵ����� 
	 */  
	public static Date getPreviousDate(Date nowdate, String delay) {  
		
	    try {  
	    	SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");    
	        long myTime = (nowdate.getTime() / 1000) - Integer.parseInt(delay) * 24  
	                * 60 * 60;     
	        String d = format.format(myTime*1000);  
	        Date preDate=format.parse(d);  
	        return preDate;  
	    } catch (Exception e) {  
	        return null;  
	    }  
	} 
	
	/** 
	 * �õ�һ��ʱ����Ƽ����ʱ�䣨Date��,nowdateΪʱ��,delayΪǰ�ƻ���ӵ����� 
	 */  
	public static Date getNextDate(Date nowdate, String delay) {  
		
	    try {  
	    	SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");    
	        long myTime = (nowdate.getTime() / 1000) + Integer.parseInt(delay) * 24  
	                * 60 * 60;     
	        String d = format.format(myTime*1000);  
	        Date preDate=format.parse(d);  
	        return preDate;  
	    } catch (Exception e) {  
	        return null;  
	    }  
	} 
	/** 
	 * �ж��Ƿ����� 
	 *  
	 * @param ddate 
	 * @return 
	 */  
	public static boolean isLeapYear(String ddate) {  
	    /** 
	     * ��ϸ��ƣ� 1.��400���������꣬���� 2.���ܱ�4������������ 3.�ܱ�4����ͬʱ���ܱ�100������������ 
	     * 3.�ܱ�4����ͬʱ�ܱ�100������������ 
	     */  
	    Date d = strToDate(ddate);  
	    GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();  
	    gc.setTime(d);  
	    int year = gc.get(Calendar.YEAR);  
	    if ((year % 400) == 0) { 
	        return true;  
	    }else if ((year % 4) == 0) {  
	        if ((year % 100) == 0) { 
	            return false;  
	        }else  {
	            return true; 
	        }
	    } else { 
	        return false; 
	    }
	}  
	  
	/** 
	 * ��������ʱ���ʽ 26 Apr 2006 
	 *  
	 * @param str 
	 * @return 
	 */  
	public static String getEDate(String str) {  
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
	    formatter.setLenient(false);
	    ParsePosition pos = new ParsePosition(0);  
	    Date strtodate = formatter.parse(str, pos);  
	    String j = strtodate.toString();  
	    String[] k = j.split(" ");  
	    return k[2] + k[1].toUpperCase() + k[5].substring(2, 4);  
	}  
	  
	/** 
	 * ��ȡһ���µ����һ�� 
	 *  
	 * @param dat 
	 * @return 
	 */  
	public static String getEndDateOfMonth(String dat) {// yyyy-MM-dd  
	    String str = dat.substring(0, 8);  
	    String month = dat.substring(5, 7);  
	    int mon = Integer.parseInt(month);  
	    if (mon == 1 || mon == 3 || mon == 5 || mon == 7 || mon == 8  
	            || mon == 10 || mon == 12) {  
	        str += "31";  
	    } else if (mon == 4 || mon == 6 || mon == 9 || mon == 11) {  
	        str += "30";  
	    } else {  
	        if (isLeapYear(dat)) {  
	            str += "29";  
	        } else {  
	            str += "28";  
	        }  
	    }  
	    return str;  
	}  
	  
	/** 
	 * �ж϶���ʱ���Ƿ���ͬһ���� 
	 *  
	 * @param date1 
	 * @param date2 
	 * @return 
	 */  
	public static boolean isSameWeekDates(Date date1, Date date2) {  
	    Calendar cal1 = Calendar.getInstance();  
	    Calendar cal2 = Calendar.getInstance();  
	    cal1.setTime(date1);  
	    cal2.setTime(date2);  
	    int subYear = cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);  
	    if (0 == subYear) {  
	        if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2  
	                .get(Calendar.WEEK_OF_YEAR)) { 
	            return true;  
	        }
	    } else if (1 == subYear && 11 == cal2.get(Calendar.MONTH)) {  
	        // ���12�µ����һ�ܺ�������һ�ܵĻ������һ�ܼ���������ĵ�һ��  
	        if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2  
	                .get(Calendar.WEEK_OF_YEAR)) { 
	            return true;  
	        }
	    } else if (-1 == subYear && 11 == cal1.get(Calendar.MONTH)) {  
	        if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2  
	                .get(Calendar.WEEK_OF_YEAR)) { 
	            return true;  
	        }
	    }  
	    return false;  
	}  
	  
	/** 
	 * ����������,���õ���ǰʱ�����ڵ�����ǵڼ��� 
	 *  
	 * @return 
	 */  
	public static String getSeqWeek() {  
	    Calendar c = Calendar.getInstance(Locale.CHINA);  
	    String week = Integer.toString(c.get(Calendar.WEEK_OF_YEAR));  
	    if (week.length() == 1) { 
	        week = "0" + week; 
	    }
	    String year = Integer.toString(c.get(Calendar.YEAR));  
	    return year + week;  
	}  
	  
	/** 
	 * ���һ���������ڵ��ܵ����ڼ������ڣ���Ҫ�ҳ�2002��2��3�������ܵ�����һ�Ǽ��� 
	 *  
	 * @param sdate 
	 * @param num 
	 * @return 
	 */  
	public static String getWeek(String sdate, String num) {  
	    // ��ת��Ϊʱ��  
	    Date dd = strToDate(sdate);  
	    Calendar c = Calendar.getInstance();  
	    c.setTime(dd);  
	    if ("1".equals(num)) {
	    	// ��������һ���ڵ�����  
	        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);  
	    }else if ("2".equals(num)) {
	    	// �������ڶ����ڵ�����  	    
	        c.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);  
	    }else if ("3".equals(num)) {
	    	// �������������ڵ�����  
	        c.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);  
	    }else if ("4".equals(num)) {
	    	// �������������ڵ�����  
	        c.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);  
	    }else if ("5".equals(num)) {
	    	// �������������ڵ�����  
	        c.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);  
	    }else if ("6".equals(num)) {
	    	// �������������ڵ�����  
	        c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);  
	    }else if ("0".equals(num)) {
	    	// �������������ڵ�����  
	        c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);  
	    }
	    return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());  
	}  
	  
	/** 
	 * ����һ�����ڣ����������ڼ����ַ��� 
	 *  
	 * @param sdate 
	 * @return 
	 */  
	public static String getWeek(String sdate) {  
	    // ��ת��Ϊʱ��  
	    Date date = strToDate(sdate);  
	    Calendar c = Calendar.getInstance();  
	    c.setTime(date);  
	    // int hour=c.get(Calendar.DAY_OF_WEEK);  
	    // hour�д�ľ������ڼ��ˣ��䷶Χ 1~7  
	    // 1=������ 7=����������������  
	    return new SimpleDateFormat("EEEE").format(c.getTime());  
	}  
	  
	public static String getWeekStr(String sdate) {  
	    String str = "";  
	    str = getWeek(sdate);  
	    if ("1".equals(str)) {  
	        str = "������";  
	    } else if ("2".equals(str)) {  
	        str = "����һ";  
	    } else if ("3".equals(str)) {  
	        str = "���ڶ�";  
	    } else if ("4".equals(str)) {  
	        str = "������";  
	    } else if ("5".equals(str)) {  
	        str = "������";  
	    } else if ("6".equals(str)) {  
	        str = "������";  
	    } else if ("7".equals(str)) {  
	        str = "������";  
	    }  
	    return str;  
	}  
	  
	/** 
	 * ����ʱ��֮������� 
	 *  
	 * @param date1 
	 * @param date2 
	 * @return 
	 */  
	public static long getDays(String date1, String date2) {  
	    if (date1 == null || date1.equals("")) {  
	        return 0; 
	    } 
	    if (date2 == null || date2.equals("")) { 
	        return 0;  
	    }
	    // ת��Ϊ��׼ʱ��  
	    SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");  
	    myFormatter.setLenient(false);
	    java.util.Date date = null;  
	    java.util.Date mydate = null;  
	    try {  
	        date = myFormatter.parse(date1);  
	        mydate = myFormatter.parse(date2);  
	    } catch (Exception e) {  
	    }  
	    long day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);  
	    return day;  
	}  
	  
	/** 
	 * �γ����µ����� �� ���ݴ����һ��ʱ�䷵��һ���ṹ ������ ����һ ���ڶ� ������ ������ ������ ������ �����ǵ��µĸ���ʱ�� 
	 * �˺������ظ�������һ�����������ڵ����� 
	 *  
	 * @param sdate 
	 * @return 
	 */  
	public static String getNowMonth(String sdate) {  
	    // ȡ��ʱ�������µ�һ��  
	    sdate = sdate.substring(0, 8) + "01";  
	    // �õ�����µ�1�������ڼ�  
	    Date date = strToDate(sdate);  
	    Calendar c = Calendar.getInstance();  
	    c.setTime(date);  
	    int u = c.get(Calendar.DAY_OF_WEEK);  
	    String newday = getNextDay(sdate, (1 - u) + "");  
	    return newday;  
	}  
	  
	/** 
	 * ȡ�����ݿ����� ���ɸ�ʽΪyyyymmddhhmmss+kλ����� 
	 *  
	 * @param k 
	 *            ��ʾ��ȡ��λ������������Լ��� 
	 */  
	public static String getNo(int k) {  
	    return getUserDate("yyyyMMddhhmmss") + getRandom(k);  
	}  
	  
	/** 
	 * ����һ������� 
	 *  
	 * @param i 
	 * @return 
	 */  
	public static String getRandom(int i) {  
	    Random jjj = new Random();  
	    // int suiJiShu = jjj.nextInt(9);  
	    if (i == 0) {  
	        return "";  
	    }
	    String jj = "";  
	    for (int k = 0; k < i; k++) {  
	        jj = jj + jjj.nextInt(9);  
	    }  
	    return jj;  
	}  
	  
	/** 
	 * @param args 
	 */  
	public static boolean rightDate(String date) {  
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    sdf.setLenient(false);
	    ;  
	    if (date == null) { 
	        return false; 
	    }
	    if (date.length() > 10) {  
	        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    } else {  
	        sdf = new SimpleDateFormat("yyyy-MM-dd");  
	    }  
	    try {  
	        sdf.parse(date);  
	    } catch (ParseException pe) {  
	        return false;  
	    }  
	    return true;  
	}  
}
