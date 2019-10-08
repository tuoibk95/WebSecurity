/**
 * Copyright(C) [2019]  [Luvina Software Company]
 * [WebSecurity.java], [2019-10-02] [HungHM]
 */
package WebSecutrity;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;

import com.mysql.jdbc.ResultSetMetaData;

import Bai2.CommonDB;

/**
 * lớp security để bảo mật
 * @author TuoiLV
 */
public class WebSecurity extends CommonDB{

	/**
	 * encode một string để có thể hiển thị đúng trong HTML
	 * @param1 String: string muốn encode
	 * @return String sau khi đã encode
	 */
	public String encode(String str) {
		StringBuilder newString = new StringBuilder(str);
		for (int i = 0; i < str.length(); i++) {
			switch (str.charAt(i)) {
				case '"':
					newString.replace(i, i, "&qout;");
					break;
				case '&':
					newString.replace(i, i, "&amp;");
					break;
				case '\'':
					newString.replace(i, i, "&#x27;");
					break;
				case '<':
					newString.replace(i, i, "&lt;");
					break;
				case '>':
					newString.replace(i, i, "&gt;");
					break;
			}
		}
		return newString.toString();
	}
	
	/**
	 * hàm trả về một chuỗi bất kì
	 * @return trả về mảng byte bất kì
	 */
	public byte[] getSalt() {
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[1];
		random.nextBytes(salt);
		return salt;
	}
	
	/**
	 * hàm thay thế các kí tự wildcard
	 * @param1 text: String cấn được thay thế
	 * @return trả về String đã được thay thế
	 */
	public String replaceWildCard(String text) {
		// thay thế kí tự wildcard % thành \%
		text = text.replaceAll("%", "\\\\%");
		// thay thế kí tự wildcard _ thành \_
		text = text.replaceAll("_", "\\\\_");
		return text;
	}
	
	/**
	 * hàm trả về mảng tên của các trường trong bảng
	 * @param1 pass: String cần được mã hóa
	 * @return trả về String pass đã được mã hóa
	 */
	public String encrypt(String pass) {
		byte[] hashBytes = new byte[pass.length()];
		try {
			// Sử dụng cách mã hóa SHA-1
			MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
			hashBytes = sha1.digest(pass.getBytes());
		} catch ( NoSuchAlgorithmException ex) {
			System.out.println(ex.getMessage());
		}
		// chuyển byte thành String theo Base64
		return Base64.getEncoder().encodeToString(getSalt()) + Base64.getEncoder().encodeToString(hashBytes);
	}
	
	/**
	 * hàm trả về mảng tên của các trường trong bảng
	 * @return trả về mảng tên các trường trong bảng
	 */
	public ArrayList<String> getAllColumn() throws SQLException {
		// biến lưu tên các trường của bảng
		ArrayList<String> columnNames = new ArrayList<String>();
		try {
			// mở kết nối tới database
			openConnection();
			// tạo statement
			Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM CDs");
	        ResultSetMetaData metadata = (ResultSetMetaData) rs.getMetaData();
	        // biến lưu số trường của bảng
            int columnCount = metadata.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
            	// lấy tên column
                String columnName = metadata.getColumnName(i);
                columnNames.add(columnName);
            }
		} catch (SQLException ex) {
			throw ex;
		} finally {
			// Đóng kết nối
			closeConnection();
		}
		return columnNames;
	}
}
