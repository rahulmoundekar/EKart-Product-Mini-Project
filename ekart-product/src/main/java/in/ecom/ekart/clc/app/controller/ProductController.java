package in.ecom.ekart.clc.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ecom.ekart.clc.app.model.Product;
import in.ecom.ekart.clc.app.repository.ProductRepo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "Product Rest Controller", description = "Restful api's of Product")
public class ProductController {

	@Autowired
	private ProductRepo productRepo;

	@GetMapping(value = "product/list", produces = "application/json")
	@ApiOperation(value = "Get product list from database", response = Iterable.class, tags = "Ekart-Product-1.0")
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "Successfully fetched"),
			@ApiResponse(code = 404,message = "Product not Found!!")
	})
	public ResponseEntity<List<Product>> getProductList() {
		List<Product> list = productRepo.findAll();
		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
	}

	@PostMapping(value = "product/save", consumes = { "application/json" }, produces = "application/json")
	@ApiOperation(value = "Create Product", response = String.class, tags = "Ekart-Product-1.0")
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "Successfully Created"),
			@ApiResponse(code = 404,message = "Product not Found!!"),
			@ApiResponse(code = 500,message = "Internal Server Error!!")
	})
	public ResponseEntity<String> saveProduct(@RequestBody Product product) {
		System.out.println(product);
		Product p = productRepo.save(product);
		if (p != null) {
			return new ResponseEntity<String>("{'success':'Product saved successfully'}", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("{\"error\":\"Product is not saved!!!\"}",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "product/{id}", produces = "application/json")
	@ApiOperation(value = "Get Product By Id", response = Product.class, tags = "Ekart-Product-1.0")
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "Successfully Get Product"),
			@ApiResponse(code = 404,message = "Product not Found!!"),
			@ApiResponse(code = 500,message = "Internal Server Error!!")
	})
	public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
		Product p = productRepo.getById(id);
		return new ResponseEntity<Product>(p, HttpStatus.OK);
	}

	@DeleteMapping(value = "product/{id}", produces = "application/json")
	@ApiOperation(value = "Delete Product By Id", response = String.class, tags = "Ekart-Product-1.0")
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "Successfully Product Deleted"),
			@ApiResponse(code = 500,message = "Internal Server Error!!")
	})
	public ResponseEntity<String> deleteProductById(@PathVariable Integer id) {
		boolean flag = false;
		productRepo.deleteById(id);
		flag = true;
		if (flag) {
			return new ResponseEntity<String>("{'success':'Product Deleted successfully'}", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("{\"error\":\"Product is not Deleted!!!\"}",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
