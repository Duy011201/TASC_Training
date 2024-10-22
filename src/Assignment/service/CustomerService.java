package Assignment.service;

import Assignment.exception.HandleServiceException;

public interface CustomerService {
	public void saveFileCustomer() throws HandleServiceException;
	public void addCustomer() throws HandleServiceException;
	public void updateCustomer() throws HandleServiceException;
	public void deleteCustomer() throws HandleServiceException;
	public void displayCustomer() throws HandleServiceException;
	public void loadFileCustomer() throws HandleServiceException;
	public void searchCustomerByPhoneNumber() throws HandleServiceException;
}
