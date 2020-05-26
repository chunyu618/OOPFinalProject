package database_utils;

import java.io.*;

/**
 * The JsonToSql class is used to convert json file (.json) into sql file (.sql)
 */
public class JsonToSql {
	/**
	 * This method is used to convert file (.json) into file (.sql)
	 * @param json_file: the path of the json input file
	 * @param sql_file: the path of the sql output file
	 */
	public static void convert (String json_file, String sql_file) {
		System.out.printf("start converting json_file to sql_file ...\n");
		try {
			File in_file = new File(json_file);
			InputStreamReader isr = new InputStreamReader(new FileInputStream(in_file), "UTF8");
			BufferedReader input = new BufferedReader(isr);
			
			File out_file = new File(sql_file);
			OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(out_file), "UTF8");
			BufferedWriter output = new BufferedWriter(osw);
			
			
			output.write("CREATE TABLE IF NOT EXISTS traval_code(\n" + 
					"   travel_code int\n" + 
					"  ,travel_code_name text\n" + 
					");\n\n");
			
			String line = null;
			line = input.readLine();
			
			int idx = 0, end = 0;
			while (line != null) {
				idx = line.indexOf("\"travel_code\"");
				if (idx != -1) {
					output.write("INSERT INTO traval_code(travel_code,travel_code_name) VALUES (");
					end = line.indexOf("\",");
					output.write(line.substring(idx + 16, end));
				}
				
				idx = line.indexOf("\"travel_code_name\"");
				if (idx != -1) {
					end = line.lastIndexOf("\"");
					output.write(",'" + line.substring(idx + 21, end).replaceAll("^[ \t]+|[ \t]+$", "") + "');\n");
				}
				line = input.readLine();
			}
			
			input.close();
			output.close();
			
		} catch (IOException e) {
			System.out.println("IOException occors");
		}
	}

	/**
	 * This method is used to check whether the given file exists
	 * @param filen: the path of the file to be checked
	 * @return true if the given file exists, false else
	 */
	public static boolean exist (String filen) {
		File file = new File(filen);
		return file.exists();
	}
	
	/**
	 * This method displays the usage of JsonToSql class
	 * @param args: command line arguments
	 */
	public static void main (String[] args) {
		String json_file = System.getProperty("user.dir") + "\\src\\travel_code.json";
		String json_sql = System.getProperty("user.dir") + "\\src\\travel_code.sql";
		
		if (JsonToSql.exist(json_file)) {
			System.out.println("json_file exists");
			JsonToSql.convert(json_file, json_sql);
		}
	}
}