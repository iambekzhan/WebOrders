package utilities;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DataStorage {
	
	private static Map<String, String> data = new HashMap<>();
	
	public static void addData(String key, String value) {
		data.put(key, value);
	}
	
	public static String getData(String key) {
		return data.get(key);
	}
	
}
