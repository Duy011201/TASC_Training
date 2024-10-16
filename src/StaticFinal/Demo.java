package StaticFinal;

public class Demo {
	static int count; // Biến static

	// Khối static: được chạy khi lớp được nạp vào bộ nhớ
	static {
		count = 10;
		System.out.println("Static block executed.");
	}

	// Phương thức static: có thể được gọi mà không cần tạo đối tượng
	static void increment() {
		count++; // Tăng giá trị biến static
		System.out.println("Count after increment: " + count);
	}
}
