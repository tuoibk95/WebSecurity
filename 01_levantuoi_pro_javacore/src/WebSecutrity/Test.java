/**
 * Copyright(C) [2019]  [Luvina Software Company]
 * [Test.java], [2019-10-02] [HungHM]
 */
package WebSecutrity;

import java.sql.SQLException;

/**
 * Description 
 * @author TuoiLV
 */
public class Test {

	public static void main(String[] args) {
		try {
			WebSecurity ws = new WebSecurity();
			System.out.println(ws.encode("\"abc"));
			System.out.println(ws.replaceWildCard("%abc%"));
			System.out.println(ws.getSalt());
			System.out.println(ws.encrypt("123456789"));
			System.out.println(ws.getAllColumn());
		} catch (SQLException ex) {
			System.out.println("Lỗi SQL");
		}
	}
}
