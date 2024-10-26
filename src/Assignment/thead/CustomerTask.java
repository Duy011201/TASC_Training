package Assignment.thead;

import Assignment.entity.Customer;

import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.Callable;

public class CustomerTask implements Callable<List<Customer>> {
	private final String[] customers;
	private final int start;
	private final int end;

	public CustomerTask(String[] customers, int start, int end) {
		this.customers = customers;
		this.start = start;
		this.end = end;
	}

	@Override
	public List<Customer> call() {
		List<Customer> result = new ArrayList<>();

		for (int i = start; i < end; i++) {
			result.add(parseCustomer(customers[i]));
		}

		return result;
	}

	private Customer parseCustomer(String customerStr) {
		customerStr = customerStr.replaceAll("[{}\"]", "");

		String name = "", email = "", phone = "";

		// Tách và xử lý từng thuộc tính của Customer
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
	}
}
