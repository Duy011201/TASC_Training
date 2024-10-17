package Queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) {
// Tạo một PriorityQueue với Comparator để sắp xếp theo mức độ ưu tiên
		PriorityQueue<Task> taskQueue = new PriorityQueue<>(Comparator.comparingInt(t -> t.priority));

		// Thêm các tác vụ vào hàng đợi
		taskQueue.offer(new Task("Clean the house", 2));
		taskQueue.offer(new Task("Do the laundry", 1));
		taskQueue.offer(new Task("Prepare presentation", 3));
		taskQueue.offer(new Task("Cook dinner", 1));

		// Xử lý các tác vụ theo mức độ ưu tiên
		System.out.println("Processing tasks in order of priority:");
		while (!taskQueue.isEmpty()) {
			Task task = taskQueue.poll(); // Lấy và loại bỏ tác vụ có độ ưu tiên cao nhất
			System.out.println(task);
		}
	}
}
