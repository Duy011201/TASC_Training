package Thread;

public class Main {
	public static void main(String[] args) {
		MyThread thread1 = new MyThread();
		thread1.start();  // start() sẽ gọi phương thức run()

		Thread thread2 = new Thread(new MyRunnable());
		thread2.start();  // start() sẽ gọi phương thức run()
	}
}
