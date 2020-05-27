package database_utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CountingDataHandler {

	private static String tableName = "counting_data";
	
	public static String getTableName() {
		return tableName;
	}
	
	/** Sets name of table for counting data. Then use createCountingDataTable() to create table.
	 * @param tableName String
	 */
	public static void setTableName(String tableName) {
		String tbnt = tableName.trim();
		if(tbnt == "" || tbnt == null) {
			System.err.println("Table name cannot be empty.");
			return;
		}
		CountingDataHandler.tableName = tbnt;
	}
	
	/** Generates an empty table for counting data. Default table name: "counting_data".
	 * @return Boolean. True if succeeded.
	 */
	public static boolean createCountingDataTable() {
		
		boolean res = false;
		
		String SQ = "CREATE TABLE IF NOT EXISTS " + CountingDataHandler.getTableName()
        	+ "(title              text,"
        	+ " price               int,"
        	+ " travel_code         int,"
        	+ " start_date         text,"
        	+ " end_date           text,"
        	+ " people_count         int)";
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = DB_Connection.getConnection();
			
			stmt = con.prepareStatement(SQ);
			stmt.executeUpdate();
			System.out.println("Table " + CountingDataHandler.getTableName() + " has been created.");
			
			if(stmt != null) stmt.close();
			if(con != null) con.close();
		}
		catch(Exception e) {
			System.err.print(e);
		}
		
		res = true;
		return res;
	}
	
	/** Deletes table of counting data.
	 * @return Boolean. True if succeeded.
	 */
	public static boolean deleteCountingDataTable() {
		
		boolean res = false;
		
		String SQ = "DROP TABLE " + CountingDataHandler.getTableName();
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = DB_Connection.getConnection();
			
			stmt = con.prepareStatement(SQ);
			stmt.executeUpdate();
			System.out.println("Table " + CountingDataHandler.getTableName() + " has been deleted.");
			
			if(stmt != null) stmt.close();
			if(con != null) con.close();
		}
		catch(Exception e) {
			System.err.print(e);
		}
		
		res = true;
		return res;
	}
	
	/** Deletes all of the records in counting data table.
	 * @return Boolean. True if succeeded.
	 */
	public static boolean deleteAllCountingData() {
		
		boolean res = false;
		
		String SQ = "TRUNCATE TABLE " + CountingDataHandler.getTableName();
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = DB_Connection.getConnection();
			
			stmt = con.prepareStatement(SQ);
			stmt.executeUpdate();
			
			if(stmt != null) stmt.close();
			if(con != null) con.close();
		}
		catch(Exception e) {
			System.err.print(e);
		}
		
		res = true;
		return res;
	}
	
	
	/** Adds a record of counting data to database according to an CountingData.
	 * @param od CountingData instance
	 * @return Boolean. True if succeeded.
	 */
	public static boolean addCountingData(CountingData cd) {
		
		boolean res = false;
		String tbName = CountingDataHandler.getTableName();
		
		String SQ = "INSERT INTO " + tbName
			+ " (title, price, travel_code, start_date, end_date, people_count)"
			+ "  SELECT * FROM (SELECT ? as c1, ? as c2, ? as c3, ? as c4, ? as c5, ? as c6) AS tmp"
			+ " WHERE NOT EXISTS (SELECT travel_code FROM " + tbName + " WHERE travel_code = ?) LIMIT 1";
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = DB_Connection.getConnection();
			
			stmt = con.prepareStatement(SQ);
			stmt.setString(1, cd.getTitle());
			stmt.setInt(2, cd.getPrice());
			stmt.setInt(3, cd.getTravelCode());
			stmt.setString(4, cd.getStartDate().toString());
			stmt.setString(5, cd.getEndDate().toString());
			stmt.setInt(6, cd.getPeopleCount());
			stmt.setInt(7, cd.getTravelCode());
			stmt.executeUpdate();
			
			if(stmt != null) stmt.close();
			if(con != null) con.close();
		}
		catch(Exception e) {
			System.err.print(e);
		}
		
		res = true;
		return res;
	}
	
	
	/** Gets data from ResultSet.
	 * @param rs ResultSet
	 * @return CountingData
	 */
	public static CountingData getCountingFromResultSet(ResultSet rs) throws SQLException {
		
		CountingData cdt = new CountingData();
		
		rs.beforeFirst();
		while(rs.next()) {
			cdt.setTitle(rs.getString("title"));
			cdt.setPrice(rs.getInt("price"));
			cdt.setTravelCode(rs.getInt("travel_code"));
			cdt.setStartDate(rs.getDate("start_date").toLocalDate());
			cdt.setEndDate(rs.getDate("end_date").toLocalDate());
			cdt.setPeopleCount(rs.getInt("people_count"));
		}
		
		return cdt;
	}
	
	
	/** Gets CountingData from database according to travelCode.
	 * @param travelCode Integer
	 * @return CountingData, null if not found.
	 */
	public static CountingData getCountingData(int travelCode) {
		
		CountingData cd = null;
		String tbName = CountingDataHandler.getTableName();
		
		String SQ = "SELECT * FROM " + tbName + " WHERE travel_code = ?";
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			con = DB_Connection.getConnection();
			
			stmt = con.prepareStatement(SQ, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			stmt.setInt(1, travelCode);
			rs = stmt.executeQuery();
			
			if (!rs.isBeforeFirst()) {  // check if any data exists
				cd = null;
				return cd;
			}
			
			cd = getCountingFromResultSet(rs);
			
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(con != null) con.close();
			
		}
		catch(Exception e) {
			System.err.print(e);
		}
		
		return cd;
	}
	
	
	/** Change counting data in database according to an CountingData.
	 * @param cd CountingData
	 * @return Boolean. True if succeeded.
	 */
	public static boolean changeCountingData(CountingData cd) {
		
		boolean res = false;
		String tbName = CountingDataHandler.getTableName();
		
		String SQ = "UPDATE " + tbName + " SET title = ?, price = ?,"
				+ " start_date = ?, end_date = ?, people_count = ?"
				+ " WHERE travel_code = ?";
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = DB_Connection.getConnection();
			
			stmt = con.prepareStatement(SQ, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			stmt.setString(1, cd.getTitle());
			stmt.setInt(2, cd.getPrice());
			stmt.setString(3, cd.getStartDate().toString());
			stmt.setString(4, cd.getEndDate().toString());
			stmt.setInt(5, cd.getPeopleCount());
			
			stmt.setInt(6, cd.getTravelCode());
			
			stmt.executeUpdate();
			
			if(stmt != null) stmt.close();
			if(con != null) con.close();
		}
		catch(Exception e) {
			System.err.print(e);
		}
		
		res = true;
		return res;
	}
	
	/** Deletes an counting data from database according to travelCode.
	 * @param travelCode Integer
	 * @return Boolean. True if succeeded.
	 */
	public static boolean deleteCountingData(int travelCode) {
		
		boolean res = false;
		String tbName = CountingDataHandler.getTableName();
		
		String SQ = "DELETE FROM " + tbName + " WHERE travel_code = ?";
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = DB_Connection.getConnection();
			
			stmt = con.prepareStatement(SQ, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			stmt.setInt(1, travelCode);
			
			stmt.executeUpdate();
			
			if(stmt != null) stmt.close();
			if(con != null) con.close();
		}
		catch(Exception e) {
			System.err.print(e);
		}
		
		res = true;
		return res;
	}
	
}
