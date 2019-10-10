
package WebSecutrity;

import java.sql.SQLException;

/**
 * Description 
 * @author TuoiLV
 */
public class Test {

	public static void main(String[] args) throws SQLException {
		try {
			WebSecurity ws = new WebSecurity();
			System.out.println(ws.endcode("\"abc"));
			System.out.println(ws.replaceWildCard("%abc%"));
			System.out.println(ws.getSalt());
			System.out.println(ws.encrypt("aksjflsflj"));
			System.out.println(ws.getAllColumn());
		} catch (SQLException ex) {
			System.out.println("Lỗi SQL");
			throw ex;
		}
	}
}
