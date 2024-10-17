package OOP;

public class Encapsulation {
	private String name;  // Biến private, không thể truy cập trực tiếp từ bên ngoài

	// Phương thức công khai (public) để truy cập vào dữ liệu
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
