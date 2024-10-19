package Thread;

public class Synchronized {
	public synchronized void synchronizedMethod() {
		// Chỉ một thread có thể truy cập phương thức này tại một thời điểm
		System.out.println("Phương thức được đồng bộ hóa");
	}

	public void methodWithSyncBlock() {
		System.out.println("Phần mã không cần đồng bộ hóa");

		synchronized (this) {
			// Chỉ một thread có thể thực thi đoạn mã này tại một thời điểm
			System.out.println("Đoạn mã được đồng bộ hóa");
		}

		System.out.println("Phần mã khác không cần đồng bộ hóa");
	}
}
