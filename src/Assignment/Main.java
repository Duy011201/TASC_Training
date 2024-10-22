package Assignment;

import Assignment.exception.HandleServiceException;
import Assignment.service.CustomerServiceImpl;
import Assignment.service.CustomerService;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws HandleServiceException {
		CustomerService customerService = new CustomerServiceImpl();
		customerService.loadFileCustomer();

		Scanner scanner = new Scanner(System.in);
		byte choice;
		do {
			System.out.println("\nQuản lý thông tin khách hàng");
			System.out.println("1. Xem danh sách khách hàng");
			System.out.println("2. Thêm khách hàng mới");
			System.out.println("3. Tìm kiếm khách hàng theo số điện thoại");
			System.out.println("4. Chỉnh sửa thông tin khách hàng");
			System.out.println("5. Xóa khách hàng");
			System.out.println("0. Thoát");
			System.out.print("Lựa chọn: ");
			choice = scanner.nextByte();
			scanner.nextLine();

			switch (choice) {
				case 1 -> customerService.displayCustomer();
				case 2 -> customerService.addCustomer();
				case 3 -> customerService.searchCustomerByPhoneNumber();
				case 4 -> customerService.updateCustomer();
				case 5 -> customerService.deleteCustomer();
				case 0 -> System.out.println("Thoát chương trình.");
				default -> System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
			}
		} while (choice != 0);
	}
}