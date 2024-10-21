package CreationalPattern.SingletonPattern;

public class ThreadSafe {
	private static ThreadSafe instance;

	private ThreadSafe() {}

	// Phương thức thread-safe sử dụng synchronized
	public static synchronized ThreadSafe getInstance() {
		if (instance == null) {
			instance = new ThreadSafe();
		}
		return instance;
	}
}
