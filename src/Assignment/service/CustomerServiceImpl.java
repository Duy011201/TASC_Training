package Assignment.service;

import Assignment.config.Constant;
import Assignment.entity.Customer;
import Assignment.exception.HandleServiceException;
import Assignment.util.Common;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CustomerServiceImpl extends Common implements Constant, CustomerService {
	private Set<Customer> listCustomer = new HashSet<>();
	private final Scanner scanner = new Scanner(System.in);

	@Override
	public void saveFileCustomer() throws HandleServiceException {
		File file = new File(FILE_PATH);

		if (!file.exists()) {
			throw new HandleServiceException(FILE_NOT_FOUND);
		}

		try (Writer writer = new FileWriter(file)) {
			writer.write("[\n");
			int count = 0;
			for (Customer customer : listCustomer) {
				writer.write("  {\n");
				writer.write("    \"name\": \"" + customer.getName() + "\",\n");
				writer.write("    \"email\": \"" + customer.getEmail() + "\",\n");
				writer.write("    \"phoneNumber\": \"" + customer.getPhoneNumber() + "\"\n");
				writer.write("  }" + (++count < listCustomer.size() ? ",\n" : "\n"));
			}
			writer.write("]");
			System.out.println(SAVE_FILE_SUCCESS);
		} catch (IOException e) {
			throw new HandleServiceException(SAVE_FILE_ERROR, e);
		}
	}

	private boolean isPhoneDuplicate(String phoneNumber) {
		for (Customer customer : listCustomer) {
			if (customer.getPhoneNumber().equals(phoneNumber)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void addCustomer() throws HandleServiceException {
		String name, email, phoneNumber;
		String choice;

		do {
			while (true) {
				System.out.print(INPUT_CUSTOMER_NAME);
				name = scanner.nextLine();
				if (!Common.isNullOrEmpty(name)) break;
				else System.out.println(VALID_NAME + "." + RE_INPUT);
			}

			while (true) {
				System.out.print(INPUT_CUSTOMER_EMAIL);
				email = scanner.nextLine();
				if (Common.isValidEmail(email)) break;
				else System.out.println(VALID_EMAIL + "." + RE_INPUT);
			}

			while (true) {
				System.out.print(INPUT_CUSTOMER_PHONE);
				phoneNumber = scanner.nextLine();
				if (Common.isValidPhoneNumber(phoneNumber) && !isPhoneDuplicate(phoneNumber)) break;
				else System.out.println(VALID_PHONE_NUMBER + "." + RE_INPUT);
			}

			listCustomer.add(new Customer(name, email, phoneNumber));
			try {
				saveFileCustomer();
			} catch (HandleServiceException e) {
				throw new HandleServiceException(ADD_ERROR, e);
			}
			System.out.println(ADD_SUCCESS);
			System.out.print(ADD_MORE_CUSTOMER);
			choice = scanner.nextLine();
		} while (choice.equalsIgnoreCase("Y"));
	}

	@Override
	public void updateCustomer() throws HandleServiceException {
		String choice, phoneNumber;
		boolean customerFound = false;

		do {
			while (true) {
				System.out.print(INPUT_CUSTOMER_PHONE);
				phoneNumber = scanner.nextLine();
				if (Common.isValidPhoneNumber(phoneNumber)) break;
				else System.out.println(VALID_PHONE_NUMBER + "." + RE_INPUT);
			}

			for (Customer customer : listCustomer) {
				if (customer.getPhoneNumber().equals(phoneNumber)) {
					customerFound = true;
					System.out.println(INFO_CUSTOMER + customer);

					System.out.print(NEW_INPUT_CUSTOMER_NAME);
					String newName = scanner.nextLine();
					if (!isNullOrEmpty(newName)) customer.setName(newName);
					else System.out.println(VALID_NAME + "." + RE_INPUT);

					System.out.print(NEW_INPUT_CUSTOMER_EMAIL);
					String newEmail = scanner.nextLine();
					if (Common.isValidEmail(newEmail)) customer.setEmail(newEmail);
					else System.out.println(VALID_EMAIL + "." + RE_INPUT);

					System.out.print(NEW_INPUT_CUSTOMER_PHONE);
					String newPhone = scanner.nextLine();
					if (Common.isValidPhoneNumber(newPhone)) customer.setPhoneNumber(newPhone);
					else System.out.println(VALID_PHONE_NUMBER + "." + RE_INPUT);

					try {
						saveFileCustomer();
					} catch (HandleServiceException e) {
						throw new HandleServiceException(UPDATE_ERROR, e);
					}

					System.out.println(UPDATE_SUCCESS);
					return;
				}
			}

			if (!customerFound) {
				System.out.println(NOT_FOUND_CUSTOMER);
			}

			System.out.print(ADD_MORE_CUSTOMER);
			choice = scanner.nextLine();
		} while (choice.equalsIgnoreCase("Y"));
	}

	@Override
	public void deleteCustomer() throws HandleServiceException {
		String phoneNumber;

		while (true) {
			System.out.print(INPUT_CUSTOMER_PHONE);
			phoneNumber = scanner.nextLine();
			if (Common.isValidPhoneNumber(phoneNumber)) break;
			else System.out.println(VALID_PHONE_NUMBER + "." + RE_INPUT);
		}

		Iterator<Customer> iterator = listCustomer.iterator();
		while (iterator.hasNext()) {
			Customer customer = iterator.next();
			if (customer.getPhoneNumber().equals(phoneNumber)) {
				iterator.remove();
				try {
					saveFileCustomer();
				} catch (HandleServiceException e) {
					throw new HandleServiceException(DELETE_ERROR, e);
				}
				System.out.println(DELETE_SUCCESS);
				return;
			}
		}
		System.out.println(NOT_FOUND_CUSTOMER);
	}

	public void searchCustomerByPhoneNumber() {
		String phoneNumber;
		while (true) {
			System.out.print(INPUT_CUSTOMER_PHONE_SEARCH);
			phoneNumber = scanner.nextLine();
			if (!isNullOrEmpty(phoneNumber)) break;
			else System.out.println(VALID_PHONE_NUMBER + "." + RE_INPUT);
		}

		for (Customer customer : listCustomer) {
			if (customer.getPhoneNumber().contains(phoneNumber)) {
				System.out.println("Tìm thấy: " + customer);
				return;
			}
		}
		System.out.println(NOT_FOUND_CUSTOMER);
	}

	public void loadFileCustomerSingle() throws HandleServiceException {
		File file = new File(FILE_PATH);

		if (!file.exists()) {
			throw new HandleServiceException(FILE_NOT_FOUND);
		}

		if (file.length() == 0) {
			throw new HandleServiceException(FILE_EMPTY);
		}

		long startTimeMillis = System.currentTimeMillis();
		try {
			// Đọc toàn bộ nội dung file một lần thay vì đọc từng dòng
			String jsonString = new String(Files.readAllBytes(Paths.get(FILE_PATH))).trim();

			// Loại bỏ dấu ngoặc đầu cuối nếu cần
			if (jsonString.startsWith("[") && jsonString.endsWith("]")) {
				jsonString = jsonString.substring(1, jsonString.length() - 1);
			}

			// Chia JSON thành các phần tử của khách hàng
			String[] customers = jsonString.split("\\},\\{");

			// Dùng Stream API để chuyển đổi thành danh sách các Customer
			listCustomer.clear();
			listCustomer.addAll(Arrays.stream(customers).map(customerStr -> {
				// Đảm bảo loại bỏ ký tự không cần thiết một lần
				customerStr = customerStr.replaceAll("[{}\"]", "");

				String name = "", email = "", phone = "";

				// Xử lý từng thuộc tính của Customer
				String[] fields = customerStr.split(",");
				for (String field : fields) {
					String[] keyValue = field.split(":");
					if (keyValue.length == 2) {
						String key = keyValue[0].trim();
						String value = keyValue[1].trim();
						switch (key) {
							case "name":
								name = value;
								break;
							case "email":
								email = value;
								break;
							case "phoneNumber":
								phone = value;
								break;
						}
					}
				}
				return new Customer(name, email, phone);
			}).toList());

			long endTimeMillis = System.currentTimeMillis();
			System.out.println("Thời gian chạy (ms): " + (endTimeMillis - startTimeMillis) + " ms");

		} catch (IOException e) {
			throw new HandleServiceException(LOAD_FILE_ERROR, e);
		}
	}

	public void loadFileCustomerMulti() throws HandleServiceException {
		File file = new File(FILE_PATH);

		// Kiểm tra tệp có tồn tại và không rỗng
		if (!file.exists()) {
			throw new HandleServiceException(FILE_NOT_FOUND);
		}

		if (file.length() == 0) {
			throw new HandleServiceException(FILE_EMPTY);
		}

		long startTimeMillis = System.currentTimeMillis();

		List<Customer> customers;

		try {
			// Đọc toàn bộ nội dung tệp
			String jsonString = new String(Files.readAllBytes(Paths.get(FILE_PATH))).trim();

			// Xử lý chuỗi JSON chỉ một lần
			if (jsonString.startsWith("[") && jsonString.endsWith("]")) {
				jsonString = jsonString.substring(1, jsonString.length() - 1);
			}

			// Chia JSON thành các phần tử của khách hàng
			String[] customerArray = jsonString.split("\\},\\{");

			// Khởi tạo danh sách khách hàng
			listCustomer.clear();

			// Sử dụng CompletableFuture để xử lý đồng thời
			List<CompletableFuture<Customer>> futures = new ArrayList<>();

			for (String customerStr : customerArray) {
				// Chuyển đổi customerStr để loại bỏ các ký tự không cần thiết trước khi xử lý
				futures.add(CompletableFuture.supplyAsync(() -> processCustomer(customerStr.replaceAll("[{}\"]", "").trim())));
			}

			// Thu thập kết quả từ các tác vụ, xử lý các ngoại lệ
			customers = futures.stream()
							.map(future -> {
								try {
									return future.join();
								} catch (Exception e) {
									// Xử lý lỗi nếu cần thiết
									System.err.println("Error processing customer: " + e.getMessage());
									return null;
								}
							})
							.filter(Objects::nonNull) // Loại bỏ giá trị null do lỗi
							.collect(Collectors.toList());

			listCustomer.addAll(customers);

			long endTimeMillis = System.currentTimeMillis();
			System.out.println("Thời gian chạy (ms): " + (endTimeMillis - startTimeMillis) + " ms");

		} catch (IOException e) {
			throw new HandleServiceException(LOAD_FILE_ERROR, e);
		}
	}

	private Customer processCustomer(String customerStr) {
		String[] fields = customerStr.split(",");

		String name = null, email = null, phone = null;

		// Phân tích các trường khách hàng
		for (String field : fields) {
			String[] keyValue = field.split(":");
			if (keyValue.length == 2) {
				String key = keyValue[0].trim();
				String value = keyValue[1].trim();
				switch (key) {
					case "name":
						name = value;
						break;
					case "email":
						email = value;
						break;
					case "phoneNumber":
						phone = value;
						break;
				}
			}
		}
		return new Customer(name, email, phone);
	}

	public void displayCustomer() {
		if (!listCustomer.isEmpty()) {
			int index = 1;
			for (Customer customer : listCustomer) {
				System.out.println(index + ": " + customer.toString());
				index++;
			}
		} else {
			System.out.println(LIST_EMPTY);
		}
	}
}


