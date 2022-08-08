package in.ecom.ekart.clc.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import in.ecom.ekart.clc.app.beans.Product;
import in.ecom.ekart.clc.app.service.ProductService;

@Controller
public class ProductViewController {

	@Autowired
	ProductService productService;

	@GetMapping(value = "/")
	public String landingPage(Model model) {
		List<Product> list = productService.getProductList();
		model.addAttribute("list", list);
		return "index";
	}

	@GetMapping(value = "productDetails/{id}")
	public String productDetails(Model model, @PathVariable Integer id) {
		Product product=productService.getProductDetailsById(id);
		model.addAttribute("product", product);
		return "product-detail";
	}

}
