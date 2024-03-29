package Bai2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import WebSecutrity.WebSecurity;

public class CDDatabase extends CommonDB {
	public void insertCD(CD cd) throws SQLException {
		String sql = "INSERT INTO CDs (artist,title) VALUES (?,?)";
		try {
			// Mở kết nối
			openConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cd.getArtist());
			ps.setString(2, cd.getTitle());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(getClass().getName() + "" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			closeConnection();
		}
	}
	
	public void removeCD(String artist) throws SQLException {
		String sql = "DELETE FROM CDs WHERE artist=?";
		try {
			openConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, artist);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(getClass().getName() + "" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			closeConnection();
		}
	}
	
	public ArrayList<CD> findByArtist(String artist) throws SQLException {
		ArrayList<CD> CDs = new ArrayList<CD>();
		String sql = "SELECT * FROM CDs WHERE artist=?";
		try {
			openConnection();
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setString(1, "%" + artist + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CD cd = new CD(rs.getString("artist"),rs.getString("title"));
				CDs.add(cd);
			}
		} catch (SQLException e) {
			System.out.println(getClass().getName() + "" + e.getMessage());
			throw e;
		} finally {
			closeConnection();
			return CDs;
		} 
	}
	
	public ArrayList<CD> findByTitle(String title, String column) throws SQLException {
		ArrayList<CD> CDs = new ArrayList<CD>();
		WebSecurity ws = new WebSecurity();
		ArrayList<String> columnNames = ws.getAllColumn();
		String sql = "SELECT * FROM CDs WHERE title=?";
		try {
			openConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, title);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CD cd = new CD(rs.getString("artist"),rs.getString("title"));
				CDs.add(cd);
			}
		} catch (Exception e) {
			System.out.println(getClass().getName() + "" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			closeConnection();
			return CDs;
		} 
	}
}
