package CreationalPattern.SingletonPattern;

public class SingletonPattern {
//	Tạo một kết nối duy nhất đến cơ sở dữ liệu

//	public class DatabaseConnection {
//		private static DatabaseConnection instance;
//		private Connection connection;
//
//		// Private constructor để ngăn việc khởi tạo từ bên ngoài
//		private DatabaseConnection() {
//			try {
//				// Giả định driver JDBC
//				Class.forName("com.mysql.jdbc.Driver");
//				// Thiết lập kết nối cơ sở dữ liệu
//				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", "password");
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//
//		// Phương thức trả về instance duy nhất
//		public static DatabaseConnection getInstance() {
//			if (instance == null) {
//				instance = new DatabaseConnection();
//			}
//			return instance;
//		}
//
//		public Connection getConnection() {
//			return connection;
//		}
//	}
}
