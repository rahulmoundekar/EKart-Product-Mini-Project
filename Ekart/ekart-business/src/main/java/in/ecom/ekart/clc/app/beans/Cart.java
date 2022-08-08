package in.ecom.ekart.clc.app.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
	private int id;

	private Product product;

	private Customer customer;

}
