package Bai2;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	
	static Scanner sc = new Scanner(System.in);
	static CDDatabase db = new CDDatabase();
	
	public static void main(String[] args) {
		outloop:
			do {
				System.out.print("Hãy nhập hàm cần test là từ 1 đến 4: ");
				int number = Integer.parseInt(sc.nextLine());
				switch (number) {
					case 1:
						testInsert();
						break outloop;
					case 2:
						testRemove();
						break outloop;
					case 3:
						testFindByTitle();
						break outloop;
					case 4:
						testFindByArtist();
						break outloop;
				}
			} while (true);
		
	}

	private static void testInsert() {
		try {
			String artist;
			String title;
			System.out.println("Test hàm insert, nhập thông tin về CD");
			System.out.print("Aritst:");
			artist = sc.nextLine();
			System.out.print("Title:");
			title = sc.nextLine();
			db.insertCD(new CD(artist, title));
		} catch (Exception e) {
			System.out.println("Thêm không thành công");
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("Thêm thành công");
	}
	
	private static void testRemove() {
		try {
			String artist;
			System.out.println("Test hàm remove, nhập thông tin về CD");
			System.out.print("Aritst:");
			artist = sc.nextLine();
			db.removeCD(artist);
		} catch (Exception e) {
			System.out.println("Xóa không thành công");
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("Xóa thành công");
	}
	
	private static void testFindByArtist() {
		ArrayList<CD> CDs = new ArrayList<CD>();
		try {
			String artist;
			System.out.println("Test hàm find artist, nhập vào artist");
			System.out.print("Aritst:");
			artist = sc.nextLine();
			db.findByArtist(artist);
		} catch (Exception e) {
			System.out.println("Tìm không thành công");
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("Tìm thành công artist");
		infoCD(CDs);
	}
	
	private static void testFindByTitle() {
		ArrayList<CD> CDs = new ArrayList<CD>();
		try {
			String title;
			String columnName;
			System.out.println("Nhập vào title: ");
			title = sc.nextLine();
			System.out.println("Nhập tên column muốn sắp xếp theo");
			columnName =sc.nextLine();
			// Tìm kiếm CD trong database và gán vào biến CDs
			CDs = db.findByTitle(title, columnName);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		} 
		System.out.println("Tìm thành công theo title");
		infoCD(CDs);
	}

	private static void infoCD(ArrayList<CD> CDs) {
		if (CDs.size() == 0) {
			System.out.println("Không có bản ghi nào");
			return;
		}
		//Nếu tìm được bản ghi
		System.out.println("Các CD tìm thấy là: ");
		for (CD cd : CDs) {
			System.out.println(cd);
		}
	}
}
