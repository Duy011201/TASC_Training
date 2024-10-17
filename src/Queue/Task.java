package Queue;

public class Task {
	String name;
	int priority; // Mức độ ưu tiên, số nhỏ hơn có độ ưu tiên cao hơn

	public Task(String name, int priority) {
		this.name = name;
		this.priority = priority;
	}

	@Override
	public String toString() {
		return "Task{" +
						"name='" + name + '\'' +
						", priority=" + priority +
						'}';
	}
}
