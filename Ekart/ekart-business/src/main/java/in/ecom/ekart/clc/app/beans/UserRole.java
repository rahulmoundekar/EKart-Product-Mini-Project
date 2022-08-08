package in.ecom.ekart.clc.app.beans;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRole {
	private int id;

	private User user;

	private Role role;

	private List<Customer> customerList;

}
