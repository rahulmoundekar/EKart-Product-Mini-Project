package in.ecom.ekart.clc.app.transformer;

import in.ecom.ekart.clc.app.dto.CustomerDto;
import in.ecom.ekart.clc.app.model.Customer;

public class CustomerTransformer {

	public static Customer transformDtoToEntity(CustomerDto customerDto) {
		Customer customer = new Customer();
		customer.setName(customerDto.getName());
		customer.setMobile(customerDto.getMobile());
		customer.setAddress(customerDto.getAddress());
		return customer;
	}

}
