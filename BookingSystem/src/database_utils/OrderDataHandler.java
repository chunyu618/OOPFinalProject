package database_utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class OrderDataHandler {
	
	private static String tableName = "order_data";
	
	public static String getTableName() {
		return tableName;
	}
	
	/** Sets name of table for order data. Then use createOrderDataTable() to create table.
	 * @param tableName String
	 */
	public static void setTableName(String tableName) {
		String tbnt = tableName.trim();
		if(tbnt == "" || tbnt == null) {
			System.err.println("Table name cannot be empty.");
			return;
		}
		OrderDataHandler.tableName = tbnt;
	}
	
	
	/** Generates an empty table for order data. Default table name: "order_data".
	 * @return Boolean. True if succeeded.
	 */
	public static boolean createOrderDataTable() {
		
		boolean res = false;
		
		String SQ = "CREATE TABLE IF NOT EXISTS " + OrderDataHandler.getTableName()
        	+ "(order_number       int,"
        	+ " user_ID            int,"
        	+ " travel_code        int,"
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
			
			if(stmt != null) stmt.close();
			if(con != null) con.close();
		}
		catch(Exception e) {
			System.err.print(e);
		}
		
		res = true;
		return res;
	}
	
	
	/** Deletes table of order data.
	 * @return Boolean. True if succeeded.
	 */
	public static boolean deleteOrderDataTable() {
		
		boolean res = false;
		
		String SQ = "DROP TABLE " + OrderDataHandler.getTableName();
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = DB_Connection.getConnection();
			
			stmt = con.prepareStatement(SQ);
			stmt.executeUpdate();
			System.out.println("Table " + OrderDataHandler.getTableName() + " has been deleted.");
			
			if(stmt != null) stmt.close();
			if(con != null) con.close();
		}
		catch(Exception e) {
			System.err.print(e);
		}
		
		res = true;
		return res;
	}
	
	
	/** Deletes all of the records in order data table.
	 * @return Boolean. True if succeeded.
	 */
	public static boolean deleteAllOrderData() {
		
		boolean res = false;
		
		String SQ = "TRUNCATE TABLE " + OrderDataHandler.getTableName();
		
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
	
	
	/** Adds a record of order data to database according to an OrderData.
	 * @param od OrderData instance
	 * @return Boolean. True if succeeded.
	 */
	public static boolean addOrderData(OrderData od) {
		
		boolean res = false;
		String tbName = OrderDataHandler.getTableName();
		
		String SQ = "INSERT INTO " + tbName
			+ " (order_number, user_ID, travel_code, start_date, end_date, total_price, num_adults, num_children, num_babies)"
			+ "  SELECT * FROM (SELECT ? as c1, ? as c2, ? as c3, ? as c4, ? as c5, ? as c6, ? as c7, ? as c8, ? as c9) AS tmp"
			+ " WHERE NOT EXISTS (SELECT order_number FROM " + tbName + " WHERE order_number = ?) LIMIT 1";
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = DB_Connection.getConnection();
			
			stmt = con.prepareStatement(SQ);
			stmt.setInt(1, od.getOrderNumber());
			stmt.setInt(2, od.getUserID());
			stmt.setInt(3, od.getTravelCode());
			stmt.setString(4, od.getStartDate().toString());
			stmt.setString(5, od.getEndDate().toString());
			stmt.setInt(6, od.getTotalPrice());
			stmt.setInt(7, od.getNumberOfAdults());
			stmt.setInt(8, od.getNumberOfChildren());
			stmt.setInt(9, od.getNumberOfBabies());
			stmt.setInt(10, od.getOrderNumber());
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
	 * @return OrderData
	 */
	public static OrderData getOrderFromResultSet(ResultSet rs) throws SQLException {
		
		OrderData odt = new OrderData();

		rs.beforeFirst();
		while(rs.next()) {
			odt.setOrderNumber(rs.getInt("order_number"));
			odt.setUserID(rs.getInt("user_ID"));
			odt.setTravelCode(rs.getInt("travel_code"));
			odt.setStartDate(rs.getDate("start_date").toLocalDate());
			odt.setEndDate(rs.getDate("end_date").toLocalDate());
			odt.setTotalPrice(rs.getInt("total_price"));
			odt.setNumberOfAdults(rs.getInt("num_adults"));
			odt.setNumberOfChildren(rs.getInt("num_children"));
			odt.setNumberOfAdults(rs.getInt("num_babies"));
		}		
		
		return odt;
	}
	
	
	/** Gets OrderData from database according userID and orderNumber.
	 * @param userID Integer
	 * @param orderNumber Integer
	 * @return OrderData, null if not found.
	 */
	public static OrderData getOrderData(int userID, int orderNumber) {
		
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
			
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(con != null) con.close();
			
		}
		catch(Exception e) {
			System.err.print(e);
		}
		
		return od;
	}
	
	/** Change order data in database according to an OrderData.
	 * @param od OrderData
	 * @return Boolean. True if succeeded.
	 */
	public static boolean changeOrderData(OrderData od) {
		
		boolean res = false;
		String tbName = OrderDataHandler.getTableName();
		
		String SQ = "UPDATE " + tbName + " SET travel_code = ?, start_date = ?, end_date = ?, total_price = ?,"
				+ " num_adults = ?, num_children = ?, num_babies = ?"
				+ " WHERE user_ID = ? AND order_number = ?";
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = DB_Connection.getConnection();
			
			stmt = con.prepareStatement(SQ, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			stmt.setInt(1, od.getTravelCode());
			stmt.setString(2, od.getStartDate().toString());
			stmt.setString(3, od.getEndDate().toString());
			stmt.setInt(4, od.getTotalPrice());
			stmt.setInt(5, od.getNumberOfAdults());
			stmt.setInt(6, od.getNumberOfChildren());
			stmt.setInt(7, od.getNumberOfBabies());
			
			stmt.setInt(8, od.getUserID());
			stmt.setInt(9, od.getOrderNumber());
			
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
	
	
	/** Deletes an order data from database according userID and orderNUmber.
	 * @param userID Integer
	 * @param orderNumber Integer
	 * @return Boolean. True if succeeded.
	 */
	public static boolean deleteOrderData(int userID, int orderNumber) {
		
		boolean res = false;
		String tbName = OrderDataHandler.getTableName();
		
		String SQ = "DELETE FROM " + tbName + " WHERE user_ID = ? AND order_number = ?";
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = DB_Connection.getConnection();
			
			stmt = con.prepareStatement(SQ, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			stmt.setInt(1, userID);
			stmt.setInt(2, orderNumber);
			
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
