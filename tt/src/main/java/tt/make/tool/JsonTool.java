package tt.make.tool;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
/**
 * @类说明：json转换工具
 */
public class JsonTool {

	/**
	 * map转json
	 * 
	 * @param map
	 * @return
	 */
	public static JSONObject mapToJSONObject(Map<String, Object> map) {
		JSONObject jsonObject = (JSONObject) JSONObject.toJSON(map);
		return jsonObject;
	}

	/**
	 * json转map
	 * @param <T>
	 * @param json
	 * @return
	 */
	public static <T> Map JSONObjectToMap(JSONObject json,Class<T> clazz) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = (Map<String, Object>) JSON.parseObject(JSONObject.toJSONString(json),clazz,Feature.OrderedField);
		return map;
	}
	/**
	 * map转bean
	 * @param <T>
	 * @param map 
	 * @param clazz
	 * @return
	 */
	public static <T> Object mapToBean(Map<String, Object> map,Class<T> clazz) {
		JSONObject jsonObj= mapToJSONObject(map);
		Object obj= (Object)JSONObjectToObj(jsonObj,clazz);
		return obj;
	}
	/**
	 * list转json
	 * @param <T>
	 * @param list
	 * @return
	 */
	public static <T> JSONArray listToJSONArray(List<T> list) {
		JSONArray array= (JSONArray) JSONArray.toJSON(list);
		return array;
	}
	
	/**
	 * JSONArray转list,转成特定类型的list
	 * 
	 * @param <T>
	 * @param json
	 * @param clazz
	 * @return
	 */
	public static <T> List JSONArrayToList(JSONArray json, Class<T> clazz) {
		List<T> list = (List<T>) JSONArray.parseArray(json.toJSONString(), clazz);
		return list;
	}
	/**
	 * JSONArray 转 object
	 * @param <T>
	 * @param json
	 * @param clazz
	 * @return
	 */
	public static <T> Object JSONArrayToObj(JSONArray json, Class<T> clazz) {
		Object obj =  JSONArray.parseObject(json.toJSONString(), clazz);
		return obj;
	}
	
	/***
     * object转JSONArray
     *
     * @param object
     * @return
     */
	public static JSONArray objToJSONArray(Object object) {
        return (JSONArray) JSONArray.toJSON(object);
    }
	
	/**
	 * Object转JSONObject
	 * @param o
	 * @return
	 */
	public static JSONObject objToJSONObject(Object obj) {
		JSONObject objJson=(JSONObject) JSONObject.toJSON(obj);
		return objJson;
	}
	
	/**
	 * JSONObject转object
	 * @param <T>
	 * @param json
	 * @return
	 */
	public static <T> Object JSONObjectToObj(JSONObject json,Class<T> clazz) {
		Object obj=JSONObject.parseObject(json.toJSONString(), clazz);
		return obj;
	}
	 /***
     * 将对象转换为Collection对象
     *
     * @param object
     * @return
     */
    public static Collection toCollection(JSONArray json) {
        return JSONArray.parseObject(json.toJSONString(), Collection.class);
    }
    
	/**
	 * 根据key获取值
	 * @param json
	 * @param key
	 * @return
	 */
	public static Object getValueByKey(JSONObject json, String key) {
		Map map=JSONObjectToMap(json,LinkedHashMap.class);
		Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			if(key.equals(entry.getKey())) {
				return json.getString(key); 
			}
		}
		return "";
	}
}
