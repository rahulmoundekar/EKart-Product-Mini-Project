package in.ecom.ekart.clc.app.service;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.ecom.ekart.clc.app.beans.Customer;
import in.ecom.ekart.clc.app.beans.Product;
import in.ecom.ekart.clc.app.beans.User;
import in.ecom.ekart.clc.app.utility.WebAPI;

@Service
public class LoginServiceImpl implements LoginService {

	@Override
	public User loginService(User user) {
		RestTemplate restTemplate = new RestTemplate();

		HttpEntity<User> request = new HttpEntity<User>(user);

		String response = restTemplate.postForObject(WebAPI.USER_SIGN_IN, request, String.class);

		ObjectMapper objectMapper = new ObjectMapper();
		User loginUser = null;
		try {
			loginUser = objectMapper.readValue(response, new TypeReference<User>() {});
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return loginUser;
	}

}
