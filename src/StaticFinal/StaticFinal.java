package StaticFinal;

public class StaticFinal {
	public static void main(String[] args) {
		// Truy cập phương thức static mà không cần tạo đối tượng
		Demo.increment();

		// Truy cập biến static trực tiếp thông qua tên lớp
		System.out.println("Final count value: " + Demo.count);
	}
}