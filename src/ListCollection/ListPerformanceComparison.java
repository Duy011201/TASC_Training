package ListCollection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListPerformanceComparison {
	public static void main(String[] args) {
		// Số lượng phần tử
		int n = 100000;

		// Thời gian thêm phần tử
		System.out.println("Thời gian thêm phần tử:");
		measureAddTime(new ArrayList<>(), n, "ArrayList");
		measureAddTime(new LinkedList<>(), n, "LinkedList");

		// Thời gian tìm kiếm phần tử
		System.out.println("\nThời gian tìm kiếm phần tử:");
		measureSearchTime(new ArrayList<>(), n, "ArrayList");
		measureSearchTime(new LinkedList<>(), n, "LinkedList");

		// Thời gian xóa phần tử
		System.out.println("\nThời gian xóa phần tử:");
		measureRemoveTime(new ArrayList<>(), n, "ArrayList");
		measureRemoveTime(new LinkedList<>(), n, "LinkedList");
	}

	// Phương thức đo thời gian thêm phần tử
	private static void measureAddTime(List<Integer> list, int n, String listType) {
		long startTime = System.nanoTime(); // Thời gian bắt đầu

		for (int i = 0; i < n; i++) {
			list.add(i);
		}

		long endTime = System.nanoTime(); // Thời gian kết thúc
		double duration = (endTime - startTime) / 1e9; // Chuyển đổi sang giây
		System.out.printf("%s: %.6f giây\n", listType, duration);
	}

	// Phương thức đo thời gian tìm kiếm phần tử
	private static void measureSearchTime(List<Integer> list, int n, String listType) {
		// Thêm n phần tử vào danh sách
		for (int i = 0; i < n; i++) {
			list.add(i);
		}

		long startTime = System.nanoTime(); // Thời gian bắt đầu

		// Tìm kiếm phần tử
		for (int i = 0; i < n; i++) {
			list.contains(i);
		}

		long endTime = System.nanoTime(); // Thời gian kết thúc
		double duration = (endTime - startTime) / 1e9; // Chuyển đổi sang giây
		System.out.printf("%s: %.6f giây\n", listType, duration);
	}

	// Phương thức đo thời gian xóa phần tử
	private static void measureRemoveTime(List<Integer> list, int n, String listType) {
		// Thêm n phần tử vào danh sách
		for (int i = 0; i < n; i++) {
			list.add(i);
		}

		long startTime = System.nanoTime(); // Thời gian bắt đầu

		// Xóa phần tử
		for (int i = 0; i < n; i++) {
			list.remove(0); // Xóa phần tử đầu tiên
		}

		long endTime = System.nanoTime(); // Thời gian kết thúc
		double duration = (endTime - startTime) / 1e9; // Chuyển đổi sang giây
		System.out.printf("%s: %.6f giây\n", listType, duration);
	}
}
