package trip_function;
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


/**
 * GetTrvaelingCode class will convert json file to a mapping from String to Integer, 
 * which record the travel code of destination.
 * @author lijunyu
 *
 */
public class GetTrvaelingCode {
	public static Map<String, Integer> map = convert();
	
	
	private static Map<String, Integer> convert() {
		//System.out.println("start convert!!");
		Map<String, Integer> map = new HashMap<String, Integer>();
		JSONParser parser = new JSONParser();
		try {
			// open json file from rul by a parser.
			Object obj = parser.parse(new FileReader("src/json/travel_code.json"));
			
			// change type from to JSONArray.
			JSONArray companyList = (JSONArray) obj;
 
			// Iterator of every pair of destination and travel code.
			Iterator<JSONObject> iterator = companyList.iterator();
			while (iterator.hasNext()) {
				JSONObject JObj = iterator.next();
				// parse travel_code.
				int travel_code = Integer.parseInt(JObj.get("travel_code").toString());
				// parse travel_code_name.
				String name = JObj.get("travel_code_name").toString();
				// split by .
				String[] place = name.split("．");
				// aput every pair of destination and travel code to map.
				for(String w : place){
					map.put(w, travel_code);
				}
			}
			
			/*
			// try to print out
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
			System.out.println(e.getMessage());
		}
		return map;
	}
}