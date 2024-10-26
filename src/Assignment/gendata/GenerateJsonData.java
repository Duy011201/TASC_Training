package Assignment.gendata;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateJsonData {
	public static void main(String[] args) {
		int numberOfRecords = 1_000_000;
		String filePath = "data.json";

		Random random = new Random();

		try (FileWriter writer = new FileWriter(filePath)) {
			writer.write("[\n"); // Mở mảng JSON

			for (int i = 0; i < numberOfRecords; i++) {
				// Tạo tên ngẫu nhiên dưới 10 ký tự
				String name = generateRandomName(random, 20);
				String email = name.toLowerCase() + i + "@gmail.com";
				String phoneNumber = String.format("%010d", 2500000000L + i); // Tạo số điện thoại duy nhất

				String record = String.format(
								"  {\"name\": \"%s\", \"email\": \"%s\", \"phoneNumber\": \"%s\"}",
								name, email, phoneNumber
				);

				writer.write(record);

				// Thêm dấu phẩy giữa các bản ghi, không thêm sau bản ghi cuối cùng
				if (i < numberOfRecords - 1) {
					writer.write(",\n");
				}
			}

			writer.write("\n]"); // Đóng mảng JSON
			System.out.println("Đã tạo thành công 1 triệu bản ghi JSON tại " + filePath);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Phương thức tạo tên ngẫu nhiên với độ dài tối đa là maxLength ký tự
	private static String generateRandomName(Random random, int maxLength) {
		StringBuilder name = new StringBuilder();
		int length = random.nextInt(maxLength) + 1; // Đảm bảo ít nhất 1 ký tự

		for (int j = 0; j < length; j++) {
			// Tạo ký tự ngẫu nhiên từ a đến z
			char randomChar = (char) ('a' + random.nextInt(26));
			name.append(randomChar);
		}

		return name.toString();
	}
}
