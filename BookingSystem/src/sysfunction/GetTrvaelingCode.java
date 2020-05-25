package sysfunction;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;



public class GetTrvaelingCode {
	public static Map<String, Integer> convert() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("src/json/travel_code.json"));
			
			// A JSON object. Key value pairs are unordered. JSONObject supports java.util.Map interface.
			//JSONObject jsonObject = (JSONObject) obj;
 
			// A JSON array. JSONObject supports java.util.List interface.
			JSONArray companyList = (JSONArray) obj;
 
			// An iterator over a collection. Iterator takes the place of Enumeration in the Java Collections Framework.
			// Iterators differ from enumerations in two ways:
			// 1. Iterators allow the caller to remove elements from the underlying collection during the iteration with well-defined semantics.
			// 2. Method names have been improved.
			Iterator<JSONObject> iterator = companyList.iterator();
			while (iterator.hasNext()) {
				JSONObject JObj = iterator.next();
				int travel_code = Integer.parseInt(JObj.get("travel_code").toString());
				String name = JObj.get("travel_code_name").toString();
				String[] place = name.split("．");
				for(String w : place){
					map.put(w, travel_code);
				}
			}
			/*
			Set<Integer> set = map.keySet();
			for(int i : set){
				System.out.println("travel code : " + i);
				Iterator<String> iter = map.get(i).iterator();
				while(iter.hasNext()){
					System.out.println(iter.next());
				}
			}
			*/
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}