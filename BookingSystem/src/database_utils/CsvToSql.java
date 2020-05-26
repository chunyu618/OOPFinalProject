package database;

import java.io.*;
import java.util.*;

/**
 * The CsvToSql class is used to convert csv file (.csv) into sql file (.sql)
 */
public class CsvToSql {
	/**
	 * This method is used to convert file (.csv) into file (.sql)
	 * @param csv_file: the path of the csv input file
	 * @param sql_file: the path of the sql output file
	 */
	public static void convert (String csv_file, String sql_file) {
		System.out.printf("start converting csv_file to sql_file ...\n");
		try {
			File in_file = new File(csv_file);
			InputStreamReader isr = new InputStreamReader(new FileInputStream(in_file), "UTF8");
			BufferedReader input = new BufferedReader(isr);
			
			File out_file = new File(sql_file);
			OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(out_file), "UTF8");
			BufferedWriter output = new BufferedWriter(osw);
			
			output.write("drop table if exists trip_data;\n" + 
					"CREATE TABLE trip_data (\n" + 
					"	title text,\n" + 
					"	travel_code int,\n" + 
					"	product_key text,\n" + 
					"	price int,\n" + 
					"	start_date text,\n" + 
					"	end_date text,\n" + 
					"	lower_bound int,\n" + 
					"	upper_bound int\n" + 
					");\n\n");
			
			String line = null;
			String[] element = null;
			
			line = input.readLine();
			line = input.readLine();
			
			while (line != null) {
				element = line.split(",");
				List<String> list = Arrays.<String>asList(element);
				ArrayList<String> data = new ArrayList<String>(list);
				
				if (line.contains("3,000")) {
					String tmp = data.get(0) + "," + data.get(1);
					data.remove(0);
					data.remove(0);
					data.add(0, tmp.replaceAll("^\"+|\"+$", ""));
				}
				
				while (data.size() < 8)
					data.add("NULL");
				
				output.write("INSERT INTO trip_data VALUES ('" + data.get(0) + "'");
				for (int i = 1; i < data.size(); i++) {
					if (data.get(i).matches("\\d+") || data.get(i).equals("NULL"))
						output.write("," + data.get(i));
					else output.write(",'" + data.get(i) + "'");
				}
				
				output.write(");\n");
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
	 * This method displays the usage of CsvToSql class
	 * @param args: command line arguments
	 */
	public static void main (String[] args) {
		String csv_file = System.getProperty("user.dir") + "\\src\\trip_data_all.csv";
		String csv_sql = System.getProperty("user.dir") + "\\src\\trip_data.sql";
		
		if (CsvToSql.exist(csv_file)) {
			System.out.println("csv_file exists");
			CsvToSql.convert(csv_file, csv_sql);
		}
	}
}