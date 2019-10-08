package Bai1;

import java.util.Scanner;

public class DivideClass {

	public Double getNumbet(String Number) {
		Scanner sc = new Scanner(System.in);
		double number;
		String str;
		do {
			System.out.println("Giá trị [" + Number + "]: ");
			//Nhập String từ bàn phím và lưu vào biến str
			str = sc.nextLine();
			
			// Kiểm tra số vừa nhập có đúng yêu cầu của đề bài không?
			if (CheckNumber(str, Number)) {
				number = Double.parseDouble(str);
				// Nếu nhập đúng thì thoát khỏi vòng lặp
				break;
			}
		} while (true);
		return number;
	}

	private boolean CheckNumber(String str, String Number) {
		boolean check = true;
		try {
			double number;
			if ("".equals(str)) {
				System.out.println("Hãy nhập giá trị cho ["+ Number +"]");
				check = false;
			}
			// Nếu người dùng đã nhập kí tự
			number = Integer.parseInt(str);
			if (number <= 0) {
				throw new NumberFormatException();
			} else if (number >= 100000) {
				System.out.println("Giá trị ["+ Number +"] Không được lớn hơn 5 số. Hãy nhập lại");
				// Trả về false yêu cầu người dùng nhập lại
				check = false;
			}
		} catch (NumberFormatException ex) {
			System.out.println("Giá trị của [" + Number + "]số phải > 0. Hãy nhập lại" );
			check = false;
		} finally {
//			 Nếu như không có lỗi gì thì trả về true
			return check;
		}
	}

	public Double Divide(Double A, Double B) {
		double divide = 0;
		try {
			// Thương của A cho B
			divide = A / B;
		} catch (ArithmeticException ex) {
			System.out.println(ex.getMessage());
		}
		return divide;
	}
}
