package org.dnyanyog.service;

import java.util.Optional;

import org.dnyanyog.dto.ProductRequest;
import org.dnyanyog.dto.ProductRequest;
import org.dnyanyog.dto.ProductResponse;
import org.dnyanyog.entity.Products;
import org.dnyanyog.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository repo;
	
	public ProductResponse addProduct(ProductRequest request) {
		ProductResponse response = new ProductResponse();
		
		Products productTable = new Products();
		
		productTable.setProductName(request.getProductName());
		productTable.setPrice(request.getPrice());
		productTable.setQuantity(request.getQuantity());
		
		productTable = repo.save(productTable);
		
		response.setStatus("Success");
		response.setMessage("Product added successfully!!");
		
		response.setProductname(request.getProductName());
		response.setPrice(request.getPrice());
		response.setProductId(productTable.getProductId());
		return response;
		
	}
	
	public ProductResponse UpdateProduct(Long productId, ProductRequest request) {

		ProductResponse response = new ProductResponse();
		Optional<Products> receiveData = repo.findById(productId);
		if (receiveData.isPresent()) {

			Products productTable = new Products();

			productTable.setProductName(request.getProductName());
			productTable.setProductId(request.getProductId());
			productTable.setPrice(request.getPrice());
			productTable.setQuantity(request.getQuantity());
			productTable = repo.save(productTable);
			
			response.setStatus("Updated");
			response.setMessage("Product Updated");

			response.setProductId(productTable.getProductId());
			response.setProductname(productTable.getProductName());
			response.setPrice(productTable.getPrice());

		}
		return response;
	}
	


}
