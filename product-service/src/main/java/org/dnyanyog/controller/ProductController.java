package org.dnyanyog.controller;

import org.dnyanyog.dto.ProductRequest;
import org.dnyanyog.dto.ProductResponse;
import org.dnyanyog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	@Autowired
	ProductService service;

	@PostMapping(path = "/auth/product", 
			consumes = { "application/json", "application/xml" }, 
			produces = {"application/json", "application/xml" })
	public ProductResponse addproductDetails(@RequestBody ProductRequest request) {
		return service.addProduct(request);
	}
	
	@PostMapping(path = "/auth/product/update/{productId}", 
			consumes = { "application/json", "application/xml" }, 
			produces = {"application/json", "application/xml" })
	public ProductResponse UpdateProduct(@RequestBody ProductRequest request,@PathVariable Long productId) {
		return service.UpdateProduct(productId ,request);
	}
	
}


