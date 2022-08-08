package in.ecom.ekart.clc.app.service;

import java.util.List;

import in.ecom.ekart.clc.app.beans.Product;

public interface ProductService {

	public List<Product> getProductList();

	public Product getProductDetailsById(Integer id);
}
