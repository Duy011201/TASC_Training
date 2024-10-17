package HandleException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {

		// Try-Catch
		try {
			// Có thể gây ra ngoại lệ
			int result = 10 / 0; // Gây ra ArithmeticException
		} catch (ArithmeticException e) {
			// Xử lý ngoại lệ
			System.out.println("Cannot divide by zero: " + e.getMessage());
		}

		// Try-With-Resources
		try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			// Xử lý ngoại lệ
			System.out.println("An error occurred: " + e.getMessage());
		}
	}
}
