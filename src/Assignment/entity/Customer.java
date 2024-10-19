package Assignment.entity;

import java.util.Objects;

public class Customer {

	private static final long serialVersionUID = 1L;

	private String name;
	private String email;
	private String phoneNumber;

	public Customer(String name, String email, String phoneNumber) {
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, phoneNumber);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Customer c = (Customer) o;
		return Objects.equals(email, c.email) && Objects.equals(phoneNumber, c.phoneNumber);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "entity.Customer{" +
						"name='" + name + '\'' +
						", email='" + email + '\'' +
						", phone='" + phoneNumber + '\'' +
						'}';
	}
}
