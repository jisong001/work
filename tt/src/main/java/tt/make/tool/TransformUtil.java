package tt.make.tool;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransformUtil {

	public static <T> Map<String, List<T>> ListToMapGroup(String key, List<T> list) {
		Map<String, List<T>> map = new HashMap<String, List<T>>();
		if (list != null && list.size() != 0) {
			try {
				for (int i = 0; i < list.size(); i++) {
					T item = list.get(i);
					Class<?> listItemClass = item.getClass();
					String getMethodName = getMethodName(key);
					Method getMethod;

					getMethod = listItemClass.getMethod(getMethodName);
					Object objValue = getMethod.invoke(item);
					if (objValue == null) {
						continue;
					}
					String value = String.valueOf(getMethod.invoke(item));
					if (map.containsKey(value)) {
						map.get(value).add(item);
					} else {
						List<T> subList = new ArrayList<T>();
						subList.add(item);
						map.put(value, subList);
					}
				}

			} catch (Exception ex) {
			}
		}

		return map;
	}

	public static String getMethodName(String fieldName) {
		String firstLetter = fieldName.substring(0, 1);
		String fieldNameUpperCase = firstLetter.toUpperCase() + fieldName.substring(1);
		return "get" + fieldNameUpperCase;
	}
	
	/**
	 * 
	 * 把符号分隔的字符串转为List
	 * 
	 * @param str
	 * @param splitChar
	 * @return
	 * 
	 * @author wu-hp
	 */
	public static List<String> stringSplitToListString(String str, String splitChar) {
		if (null == str || "".equals(str)) {
			return new ArrayList<String>();
		}
		
		String[] strs = str.split(splitChar);
		
		List<String> ret = new ArrayList<String>();
		
		for (String s : strs) {
			ret.add(s);
		}
		
		return ret;
	}
	
	public static String listStringToString(List<String> str, String split) {
		StringBuffer sb = new StringBuffer();
		str.forEach(e -> sb.append(e + split));
		return sb.toString();
	}
	
	public static String logToString(StackTraceElement[] trace) {
        String sOut = "";
        for (StackTraceElement s : trace) {
            sOut += "\tat " + s + "\r\n";
        }
        return sOut;
	}

}
