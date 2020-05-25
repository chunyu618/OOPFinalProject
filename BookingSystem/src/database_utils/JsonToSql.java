package database;

import java.io.*;

public class JsonToSql {
	public static void convert (String json_file, String sql_file) {
		System.out.printf("start converting %s to %s ...\n", json_file, sql_file);
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
}
