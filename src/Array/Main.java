package Array;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
//		1. Mảng là gì trong Java?
		int[] arr = new int[5]; // Mảng chứa 5 phần tử kiểu int

//		2. Cách truy cập phần tử trong mảng
		int[] numbers = {1, 2, 3, 4, 5};
		System.out.println(numbers[0]); // In ra phần tử đầu tiên: 1
		System.out.println(numbers[4]); // In ra phần tử cuối cùng: 5

//		3. Mảng đa chiều là gì?
		int[][] matrix = {
						{1, 2, 3},
						{4, 5, 6},
						{7, 8, 9}
		};
		System.out.println(matrix[0][0]); // In ra phần tử tại hàng 0, cột 0: 1
		System.out.println(matrix[1][2]); // In ra phần tử tại hàng 1, cột 2: 6

//		4. Cách sao chép mảng trong Java
		int[] original = {1, 2, 3};
		int[] copy = new int[3];
		System.arraycopy(original, 0, copy, 0, original.length);

//		5. Sự khác biệt giữa mảng và ArrayList trong Java
		int[] fixedArray = new int[5]; // Kích thước cố định
		ArrayList<Integer> dynamicList = new ArrayList<>();
		dynamicList.add(10);
		dynamicList.add(20);
		System.out.println(dynamicList); // In ra: [10, 20]
	}
}
