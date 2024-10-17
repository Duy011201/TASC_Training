package Memory;

public class Main {
	public static void main(String[] args) {
		int x = 5;  // x được cấp phát trên stack
		int y = calculate(x);  // x và y là các biến cục bộ được lưu trên stack

		Person person = new Person("Alice");  // person được cấp phát trên heap
	}

	public static int calculate(int n) {
		int result = n * n;  // result và n được lưu trên stack khi hàm được gọi
		return result;
	}
}
