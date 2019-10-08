package Bai1;

public class Main {
	public static void main(String[] args) {
		DivideClass Divide = new DivideClass();
		// Lấy giá trị A nhập từ bàn phím
		Double A = Divide.getNumbet("A");
		// Lấy giá trị B nhập từ bàn phím
		Double B = Divide.getNumbet("B");
		//Tính kết quả giữa 2 phép chia và in ra kết quả 
		Double result = Divide.Divide(A, B);
		System.out.println("Thương của phép chia 2 số A cho B là : " + result);
	}
}
