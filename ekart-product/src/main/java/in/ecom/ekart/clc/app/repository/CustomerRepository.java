package in.ecom.ekart.clc.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ecom.ekart.clc.app.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
