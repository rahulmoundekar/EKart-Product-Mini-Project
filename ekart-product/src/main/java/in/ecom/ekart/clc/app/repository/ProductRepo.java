package in.ecom.ekart.clc.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ecom.ekart.clc.app.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
