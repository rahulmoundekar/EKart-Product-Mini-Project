package in.ecom.ekart.clc.app.beans;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	private int id;

	private String name;
	private String address;
	private String mobile;
	
	private UserRole userRole;

	private List<Cart> cartList;
	
	private String username;
	private String password;
}
