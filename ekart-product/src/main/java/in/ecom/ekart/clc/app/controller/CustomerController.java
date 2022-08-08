package in.ecom.ekart.clc.app.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ecom.ekart.clc.app.dto.CustomerDto;
import in.ecom.ekart.clc.app.model.Customer;
import in.ecom.ekart.clc.app.model.Role;
import in.ecom.ekart.clc.app.model.User;
import in.ecom.ekart.clc.app.model.UserRole;
import in.ecom.ekart.clc.app.repository.CustomerRepository;
import in.ecom.ekart.clc.app.repository.RoleRepository;
import in.ecom.ekart.clc.app.repository.UserRoleRepository;
import in.ecom.ekart.clc.app.transformer.CustomerTransformer;
import in.ecom.ekart.clc.app.transformer.UserTransformer;

@RestController
public class CustomerController {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	UserRoleRepository userRoleRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@PostMapping(value = "customer/customerRegistration")
	public ResponseEntity<String> registration(@RequestBody CustomerDto customerDto) {
		System.out.println(customerDto);
		Customer customer = CustomerTransformer.transformDtoToEntity(customerDto);
		User user = UserTransformer.tranformDtoToEntity(customerDto);
		Role role = roleRepository.findRoleByRoleName("Customer");
		System.out.println("user data : " + user);
		UserRole userRole = new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);

		user.setUserRoleList(Arrays.asList(userRole));
		role.setUserRoleList(Arrays.asList(userRole));

		userRole.setCustomerList(Arrays.asList(customer));

		customer.setUserRole(userRole);

		Customer c = customerRepository.save(customer);
		if (c != null)
			return new ResponseEntity<String>("success", HttpStatus.CREATED);
		else
			return new ResponseEntity<String>("error", HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
