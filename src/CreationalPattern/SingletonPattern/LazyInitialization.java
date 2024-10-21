package CreationalPattern.SingletonPattern;

public class LazyInitialization {
	private static LazyInitialization instance; // Lưu trữ đối tượng duy nhất của LazyInitialization

	// Constructor để ngăn không cho lớp khác khởi tạo đối tượng
	private LazyInitialization() {}

	// Phương thức tĩnh trả về đối tượng duy nhất
	public static LazyInitialization getInstance() {
		if (instance == null) {
			instance = new LazyInitialization();
		}
		return instance;
	}
}
