package database_utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.ResultSet;
import java.sql.SQLException;


public class OrderDataHandler {
	
	private static String tableName = "order_data";
	
	public static String getTableName() {
		return tableName;
	}
	
	public static void setTableName(String tableName) {
		String tbnt = tableName.trim();
		if(tbnt == "" || tbnt == null) {
			System.err.println("Table name cannot be empty.");
			return;
		}
		OrderDataHandler.tableName = tbnt;
	}
	
	
	public static boolean createOrderDataTable() throws SQLException {
		
		boolean res = false;
		
		String SQ = "CREATE TABLE IF NOT EXISTS " + OrderDataHandler.getTableName()
        	+ "(order_number       int,"
        	+ " user_ID            int,"
        	+ " start_date        text,"
        	+ " end_date          text,"
        	+ " total_price        int,"
        	+ " num_adults         int,"
        	+ " num_children       int,"
        	+ " num_babies         int)";
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = DB_Connection.getConnection();
			
			stmt = con.prepareStatement(SQ);
			stmt.executeUpdate();
			System.out.println("Table " + OrderDataHandler.getTableName() + " has been created.");
		}
		catch(Exception e) {
			System.err.print(e);
		}
		finally {
			if(stmt != null) stmt.close();
			if(con != null) con.close();
		}
		
		res = true;
		return res;
	}
	
	
	public static boolean addOrderData(OrderData od) throws SQLException {
		
		boolean res = false;
		String tbName = OrderDataHandler.getTableName();
		
		String SQ = "INSERT INTO " + tbName
			+ " (order_number, user_ID, start_date, end_date, total_price, num_adults, num_children, num_babies)"
			+ "  SELECT * FROM (SELECT ? as c1, ? as c2, ? as c3, ? as c4, ? as c5, ? as c6, ? as c7, ? as c8) AS tmp"
			+ " WHERE NOT EXISTS (SELECT order_number FROM " + tbName + " WHERE order_number = ?) LIMIT 1";
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = DB_Connection.getConnection();
			
			stmt = con.prepareStatement(SQ);
			stmt.setInt(1, od.getOrderNumber());
			stmt.setInt(2, od.getUserID());
			stmt.setString(3, od.getStartDate().toString());
			stmt.setString(4, od.getEndDate().toString());
			stmt.setInt(5, od.getTotalPrice());
			stmt.setInt(6, od.getNumberOfAdults());
			stmt.setInt(7, od.getNumberOfChildren());
			stmt.setInt(8, od.getNumberOfBabies());
			stmt.setInt(9, od.getOrderNumber());
			stmt.executeUpdate();
			
			System.out.println("One record of data added.");
		}
		catch(Exception e) {
			System.err.print(e);
		}
		finally {
			if(stmt != null) stmt.close();
			if(con != null) con.close();
		}
		
		res = true;
		return res;
	}
	
	
	public static OrderData getOrderFromResultSet(ResultSet rs) throws SQLException {
		
		OrderData odt = new OrderData();
		
		rs.beforeFirst();
		while(rs.next()) {
			odt.setUserID(rs.getInt("user_ID"));
			odt.setOrderNumber(rs.getInt("order_number"));
			odt.setStartDate(rs.getDate("start_date").toLocalDate());
			odt.setEndDate(rs.getDate("end_date").toLocalDate());
			odt.setNumberOfAdults(rs.getInt("num_adults"));
			odt.setNumberOfChildren(rs.getInt("num_children"));
			odt.setNumberOfAdults(rs.getInt("num_babies"));
		}		
		
		return odt;
	}
	
	
	public static OrderData getOrderData(int userID, int orderNumber) throws SQLException {
		
		OrderData od = null;
		String tbName = OrderDataHandler.getTableName();
		
		String SQ = "SELECT * FROM " + tbName + " WHERE user_ID = ? AND order_number = ?";
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			con = DB_Connection.getConnection();
			
			stmt = con.prepareStatement(SQ, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			stmt.setInt(1, userID);
			stmt.setInt(2, orderNumber);
			rs = stmt.executeQuery();
			
			if (!rs.isBeforeFirst()) {  // check if any data exists
				od = null;
				return od;
			}
			
			od = getOrderFromResultSet(rs);
			
		}
		catch(Exception e) {
			System.err.print(e);
		}
		finally {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(con != null) con.close();
		}
		
		return od;
	}
	
	public static boolean changeOrderData(OrderData od) throws SQLException {
		
		boolean res = false;
		String tbName = OrderDataHandler.getTableName();
		
		String SQ = "UPDATE " + tbName + " SET start_date = ?, end_date = ?, total_price = ?,"
				+ " num_adults = ?, num_children = ?, num_babies = ?"
				+ " WHERE user_ID = ? AND order_number = ?";
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			con = DB_Connection.getConnection();
			
			stmt = con.prepareStatement(SQ, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			stmt.setString(1, od.getStartDate().toString());
			stmt.setString(2, od.getEndDate().toString());
			stmt.setInt(3, od.getTotalPrice());
			stmt.setInt(4, od.getNumberOfAdults());
			stmt.setInt(5, od.getNumberOfChildren());
			stmt.setInt(6, od.getNumberOfBabies());
			
			stmt.setInt(7, od.getUserID());
			stmt.setInt(8, od.getOrderNumber());
			
			stmt.executeUpdate();
		}
		catch(Exception e) {
			System.err.print(e);
		}
		finally {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(con != null) con.close();
		}
		
		res = true;
		return res;
	}
	
	
	public static boolean deleteOrderData(int userID, int orderNumber) throws SQLException {
		
		boolean res = false;
		String tbName = OrderDataHandler.getTableName();
		
		String SQ = "DELETE FROM " + tbName + " WHERE user_ID = ? AND order_number = ?";
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			con = DB_Connection.getConnection();
			
			stmt = con.prepareStatement(SQ, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			stmt.setInt(1, userID);
			stmt.setInt(2, orderNumber);
			
			stmt.executeUpdate();
			System.out.println("One record deleted.");
		}
		catch(Exception e) {
			System.err.print(e);
		}
		finally {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(con != null) con.close();
		}
		
		res = true;
		return res;
	}
	
	
	
	public static void main(String[] args) throws SQLException {
		
		
		// test create table
		// createOrderDataTable();
		
		
		// test add data
//		OrderData od1 = new OrderData();
//		od1.setOrderNumber(1);
//		od1.setUserID(2);
//		od1.setStartDate(2020, 1, 3);
//		od1.setEndDate(2020, 2, 5);
//		od1.setTotalPrice(2000);
//		od1.setNumberOfAdults(4);
//		od1.setNumberOfChildren(2);
//		od1.setNumberOfBabies(1);
		
//		addOrderData(od1);		
		
//		od1.setEndDate(2020, 2, 6);
//		changeOrderData(od1);
//		
//		OrderData tmp = getOrderData(od1.getUserID(), od1.getOrderNumber());
//		System.out.println(tmp.getEndDateDay());
		
		
		OrderData od2 = new OrderData();
		od2.setOrderNumber(2);
		od2.setUserID(3);
		od2.setStartDate(2020, 3, 15);
		od2.setEndDate(2020, 4, 1);
		od2.setTotalPrice(3000);
		od2.setNumberOfAdults(3);
		od2.setNumberOfChildren(3);
		od2.setNumberOfBabies(0);
		
//		addOrderData(od2);
		deleteOrderData(od2.getUserID(), od2.getOrderNumber());
		
		
	}

}
