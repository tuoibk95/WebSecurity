package Bai2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CommonDB {
	// Khai báo url của localhost
	private static final String url = "jdbc:mysql://localhost/cds";
	// Khai báo user của localhost
	private static final String user = "root";
	// Khai báo password của local host
	private static final String pass = "LVTsinhvienit1";
	// Khai báo kết nối
	protected static Connection conn;
	
	
	// Mở kết nối đến Server
	public void openConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,pass);
			System.out.println("Get connection " + conn);
		} catch (NullPointerException ex) {
			// TODO: handle exception
			System.out.println(ex.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Đóng kết nối Server
	public void closeConnection() {
		try {
			if (!conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Đóng kết nối thất bại");
			System.out.println(e.getMessage());
		} catch (NullPointerException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
}
