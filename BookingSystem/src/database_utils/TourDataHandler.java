package database_utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database_utils.DB_Connection;
import database_utils.TourData;


public class TourDataHandler {
	
	private static String SQ = "SELECT * FROM trip_data WHERE travel_code = ? AND start_date = ?";
	private static String SQ_ITV = "SELECT * FROM trip_data WHERE travel_code = ? AND start_date >= ? AND start_date <= ?";
	
	
	/** Gets tours from ResultSet.
	 * @param rs
	 * @return ArrayList of TourData
	 * @throws SQLException
	 */
	private static ArrayList<TourData> getTours(ResultSet rs) {
		
		ArrayList<TourData> tours = new ArrayList<TourData>();
		
		try {
			tours = new ArrayList<TourData>();
			
			rs.beforeFirst();
			while(rs.next()) {
				TourData td = new TourData();
				td.setTitle(rs.getString("title"));
				td.setPrice(rs.getInt("price"));
				td.setTravelCode(rs.getInt("travel_code"));
				td.setStartDate(rs.getDate("start_date").toLocalDate());
				td.setEndDate(rs.getDate("end_date").toLocalDate());
				td.setLowerBound(rs.getInt("lower_bound"));
				td.setUpperBound(rs.getInt("upper_bound"));
				td.setPeopleCount(rs.getInt("people_count"));
				tours.add(td);
			}
			
		}
		catch(Exception e) {
			System.err.print(e);
		}
		
		return tours;
	}
	
	
	/** Gets result from database according to travelCode and date.
	 * @param travelCode Integer
	 * @param year Integer
	 * @param month Integer
	 * @param day Integer
	 * @return ArrayList of TourData
	 */
	public static ArrayList<TourData> getResultFromDatabase(int travelCode, int year, int month, int day) {
		
		String d = String.format("%04d-%02d-%02d", year, month, day);
		
		ArrayList<TourData> tourDataList = null;
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			con = DB_Connection.getConnection();
			
			stmt = con.prepareStatement(SQ, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			stmt.setInt(1, travelCode);
			stmt.setString(2, d);
			rs = stmt.executeQuery();
			
			if (!rs.isBeforeFirst()) {  // check if any data exists
				tourDataList = null;
				return tourDataList;
			}
			
			tourDataList = getTours(rs);
			
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(con != null) con.close();
			
		}
		catch(Exception e) {
			System.err.print(e);
		}
		
		return tourDataList;
	}
	
	
	/** getResultFromDatabase interval version, with day1 <= day2
	 * @return ArrayList of TourData
	 */
	public static ArrayList<TourData> getResultFromDatabaseWithInterval(int travelCode,
			int year1, int month1, int day1, int year2, int month2, int day2) {
		
		String d1 = String.format("%04d-%02d-%02d", year1, month1, day1);
		String d2 = String.format("%04d-%02d-%02d", year2, month2, day2);
		
		ArrayList<TourData> tourDataList = null;
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			con = DB_Connection.getConnection();
			
			stmt = con.prepareStatement(SQ_ITV, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			stmt.setInt(1, travelCode);
			stmt.setString(2, d1);
			stmt.setString(3, d2);
			rs = stmt.executeQuery();
			
			if (!rs.isBeforeFirst()) {  // check if any data exists
				tourDataList = null;
				return tourDataList;
			}
			
			tourDataList = getTours(rs);
			
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(con != null) con.close();
			
		}
		catch(Exception e) {
			System.err.print(e);
		}
		
		return tourDataList;
	}
	
	
	/** Change peopleCount in database according to travelCode and date info.
	 * @param travelCode Integer
	 * @param year Integer
	 * @param month Integer
	 * @param day Integer
	 * @param peopleCount Integer
	 * @return Boolean. True if succeeded.
	 */
	public static boolean changePeopleCount(int travelCode, int year, int month, int day, int peopleCount) {
		
		boolean res = false;
		
		String d = String.format("%04d-%02d-%02d", year, month, day);
		
		String SQ = "UPDATE trip_data SET people_count = ? "
				+ " WHERE travel_code = ? AND start_date = ?";
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = DB_Connection.getConnection();
			
			stmt = con.prepareStatement(SQ, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			stmt.setInt(1, peopleCount);
			stmt.setInt(2, travelCode);
			stmt.setString(3, d);
			
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
	
	
	/** Set all peopleCount to zero in database.
	 * @return Boolean. True if succeeded.
	 */
	public static boolean setAllPeopleCountToZero() {
		
		boolean res = false;
		String SQ = "UPDATE trip_data SET people_count = 0";
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = DB_Connection.getConnection();
			stmt = con.prepareStatement(SQ, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
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
