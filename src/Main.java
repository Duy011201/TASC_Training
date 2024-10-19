import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
// Tạo một HashMap để lưu trữ các sinh viên với mã số sinh viên (ID) là khóa
		HashMap<Integer, String> students = new HashMap<>();

		// Thêm các sinh viên vào HashMap
		students.put(101, "Nguyen Van A");
		students.put(102, "Le Thi B");
		students.put(103, "Tran Van C");

		// In HashMap ra để thấy rằng thứ tự các phần tử không được duy trì
		System.out.println("Danh sách sinh viên: " + students);

		// Truy cập phần tử qua khóa (tốc độ nhanh do sử dụng hashing)
		String student = students.get(101);
		System.out.println("Sinh viên với ID 101: " + student);

		// Cập nhật sinh viên với cùng một ID (chỉ lưu giá trị mới nhất)
		students.put(101, "Nguyen Van D");
		System.out.println("Sau khi cập nhật sinh viên với ID 101: " + students.get(101));

		// Kiểm tra xem một ID có tồn tại trong HashMap không
		if (students.containsKey(102)) {
			System.out.println("Sinh viên với ID 102 tồn tại.");
		}

		// Xóa một phần tử bằng ID
		students.remove(103);
		System.out.println("Sau khi xóa sinh viên với ID 103: " + students);

		// Duyệt qua các phần tử của HashMap (thứ tự không đảm bảo)
		for (Integer id : students.keySet()) {
			System.out.println("ID: " + id + ", Tên: " + students.get(id));
		}
	}
}
