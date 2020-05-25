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
	
	
	private static ArrayList<TourData> getTours(ResultSet rs) throws SQLException {
		
		ArrayList<TourData> tours = new ArrayList<TourData>();
		
		rs.beforeFirst();
		while(rs.next()) {
			TourData td = new TourData();
			td.setTitle(rs.getString("title"));
			td.setPrice(rs.getInt("price"));
			td.setStartDate(rs.getDate("start_date").toLocalDate());
			td.setLowerBound(rs.getInt("lower_bound"));
			td.setUpperBound(rs.getInt("upper_bound"));
			tours.add(td);
		}
		
		return tours;
	}
	
	
	public static ArrayList<TourData> getResultFromDatabase(int travelCode, int year, int month, int day) throws SQLException {
		
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
			
		}
		catch(Exception e) {
			System.err.print(e);
		}
		finally {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(con != null) con.close();
		}
		
		return tourDataList;
	}
	
	
	public static void main(String[] args) throws SQLException {
		
		ArrayList<TourData> a = getResultFromDatabase(100, 2020, 3, 26);
		
		for (TourData td : a) {
			System.out.println(td.getTitle());
			System.out.println(td.getStartDateYear() +" " + td.getStartDateMonthValue() + " " + td.getStartDateDay());
		}
		
	}
	
}
