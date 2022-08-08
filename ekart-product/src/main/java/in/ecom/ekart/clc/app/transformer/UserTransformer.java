package in.ecom.ekart.clc.app.transformer;

import in.ecom.ekart.clc.app.dto.CustomerDto;
import in.ecom.ekart.clc.app.model.User;

public class UserTransformer {

	public static User tranformDtoToEntity(CustomerDto customerDto) {
		User user = new User();
		user.setUsername(customerDto.getUsername());
		user.setPassword(customerDto.getPassword());
		return user;
	}

}
