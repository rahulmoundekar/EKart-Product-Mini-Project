package in.ecom.ekart.clc.app.service;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.ecom.ekart.clc.app.beans.Customer;
import in.ecom.ekart.clc.app.utility.WebAPI;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Override
	public boolean customerRegistration(Customer customer) {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Customer> request = new HttpEntity<Customer>(customer);
		String response = restTemplate.postForObject(WebAPI.CUSTOMER_SIGN_UP, request, String.class);
		if (response.equalsIgnoreCase("success"))
			return true;
		else
			return false;
	}

}
