package Assignment.config;

public interface Constant {
	static final String FILE_PATH = "D:/assignment/src/data-customer1.txt";
	static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
	static final String PHONE_REGEX = "^\\d+$";
	static final byte PHONE_LENGTH = 10;

	static final String SAVE_FILE_SUCCESS = "Lưu file thành công";
	static final String LOAD_FILE_SUCCESS = "Tải file thành công";
	static final String ADD_SUCCESS = "Thêm thành công";
	static final String UPDATE_SUCCESS = "Cập nhật thành công";
	static final String DELETE_SUCCESS = "Xóa thành công";

	static final String FILE_NOT_FOUND = "Không tìm thấy file";
	static final String NOT_FOUND_CUSTOMER = "Không tìm thấy khách hàng";
	static final String FILE_EMPTY = "File trống";
	static final String LIST_EMPTY = "Danh sách trống";

	static final String ADD_ERROR = "Thêm thất bại";
	static final String UPDATE_ERROR = "Cập nhật thất bại";
	static final String DELETE_ERROR = "Xóa thất bại";
	static final String SAVE_FILE_ERROR = "Lưu file thất bại";
	static final String LOAD_FILE_ERROR = "Tải file thất bại";

	static final String VALID_PHONE_NUMBER = "Số điện thoại không hợp lệ hoặc bị trùng";
	static final String VALID_EMAIL = "Email không hợp lệ";
	static final String VALID_NAME = "Email không hợp lệ";
	static final String RE_INPUT = "Vui lòng nhập lại";
	static final String ADD_MORE_CUSTOMER = "Bạn có muốn nhập thêm khách hàng không? (Y/N): ";
	static final String INFO_CUSTOMER = "Thông tin hiện tại: ";

	static final String NEW_INPUT_CUSTOMER_NAME = "Nhập tên mới (bỏ qua nếu không sửa): ";
	static final String NEW_INPUT_CUSTOMER_EMAIL = "Nhập email mới (bỏ qua nếu không sửa): ";
	static final String NEW_INPUT_CUSTOMER_PHONE = "Nhập số điện thoại mới (bỏ qua nếu không sửa): ";
	static final String INPUT_CUSTOMER_NAME = "Nhập tên khách hàng: ";
	static final String INPUT_CUSTOMER_EMAIL = "Nhập email khách hàng: ";
	static final String INPUT_CUSTOMER_PHONE = "Nhập số điện thoại khách hàng: ";
	static final String INPUT_CUSTOMER_PHONE_SEARCH = "Nhập số điện thoại khách hàng cần tìm: ";
}
