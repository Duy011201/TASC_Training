package Assignment.service;

import Assignment.config.Constant;
import Assignment.entity.Customer;
import Assignment.exception.HandleServiceException;
import Assignment.util.Common;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class CustomerServiceImpl extends Common implements Constant, CustomerService {
	private Set<Customer> listCustomer = new HashSet<>();
	private final Scanner scanner = new Scanner(System.in);

	@Override
	public void saveFileCustomer() throws HandleServiceException {
		File file = new File(FILE_PATH);

		if (!file.exists()) {
			throw new HandleServiceException(FILE_NOT_FOUND);
		}

		try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
			writer.println("Name,Email,Phone");
			for (Customer customer : listCustomer) {
				writer.println(customer.getName() + "," + customer.getEmail() + "," + customer.getPhoneNumber());
			}
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

	public void loadFileCustomer() throws HandleServiceException {
		File file = new File(FILE_PATH);

		if (!file.exists()) {
			throw new HandleServiceException(FILE_NOT_FOUND);
		}

		if (file.length() == 0) {
			throw new HandleServiceException(FILE_EMPTY);
		}

		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
			String line = reader.readLine();
			while ((line = reader.readLine()) != null) {
				String[] data = line.split(",");
				Customer customer = new Customer(data[0], data[1], data[2]);
				listCustomer.add(customer);
			}
		} catch (IOException e) {
			throw new HandleServiceException(LOAD_FILE_ERROR, e);
		}
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
