package in.ecom.ekart.clc.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.ecom.ekart.clc.app.beans.Product;
import in.ecom.ekart.clc.app.utility.WebAPI;

@Service
public class ProductServiceImpl implements ProductService {

	@Override
	public List<Product> getProductList() {
		RestTemplate restTemplate = new RestTemplate();
		String productsJson = restTemplate.getForObject(WebAPI.PRODUCT_LIST, String.class);

		ObjectMapper objectMapper = new ObjectMapper();
		List<Product> products = null;
		try {
			products = objectMapper.readValue(productsJson, new TypeReference<List<Product>>() {
			});
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public Product getProductDetailsById(Integer id) {
		RestTemplate restTemplate = new RestTemplate();

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("id", id);

		String productJson = restTemplate.getForObject(WebAPI.PRODUCT_BY_ID, String.class, map);

		ObjectMapper objectMapper = new ObjectMapper();
		Product product = null;
		try {
			product = objectMapper.readValue(productJson, new TypeReference<Product>() {
			});
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return product;
	}

}
