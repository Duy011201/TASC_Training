package SetCollection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;

public class SetPerformanceTest {
	public static void main(String[] args) {
		// Số lượng phần tử để thêm vào tập hợp
		int numberOfElements = 10_000_000;

		// Khởi tạo HashSet và LinkedHashSet
		HashSet<Integer> hashSet = new HashSet<>();
		LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();

		// Tạo đối tượng Random để sinh số ngẫu nhiên
		Random random = new Random();

		// Thời gian thêm phần tử vào HashSet
		long startTime = System.nanoTime();
		for (int i = 0; i < numberOfElements; i++) {
			hashSet.add(random.nextInt());
		}
		long hashSetAddTime = System.nanoTime() - startTime;

		// Thời gian thêm phần tử vào LinkedHashSet
		startTime = System.nanoTime();
		for (int i = 0; i < numberOfElements; i++) {
			linkedHashSet.add(random.nextInt());
		}
		long linkedHashSetAddTime = System.nanoTime() - startTime;

		// Thời gian truy cập phần tử trong HashSet
		startTime = System.nanoTime();
		for (Integer number : hashSet) {
			// Chỉ cần truy cập để đo thời gian
			Integer value = number; // Tạo một biến tạm
		}
		long hashSetAccessTime = System.nanoTime() - startTime;

		// Thời gian truy cập phần tử trong LinkedHashSet
		startTime = System.nanoTime();
		for (Integer number : linkedHashSet) {
			// Chỉ cần truy cập để đo thời gian
			Integer value = number; // Tạo một biến tạm
		}
		long linkedHashSetAccessTime = System.nanoTime() - startTime;

		// Hiển thị kết quả
		System.out.println("Thời gian thêm vào HashSet: " + hashSetAddTime / 1_000_000 + " ms");
		System.out.println("Thời gian thêm vào LinkedHashSet: " + linkedHashSetAddTime / 1_000_000 + " ms");
		System.out.println("Thời gian truy cập HashSet: " + hashSetAccessTime / 1_000_000 + " ms");
		System.out.println("Thời gian truy cập LinkedHashSet: " + linkedHashSetAccessTime / 1_000_000 + " ms");
	}
}
