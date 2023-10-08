package com.products.crud.Product;

 
import java.util.List;
import java.util.Optional;  

public interface IProductService {

	List<Product> getAllProducts();

	Optional<Product> findProductById(Long id);
	
	Product findProductByName(String name);

	void addProduct(Product product);

	void updateProduct(Long id, Product product);
	
	void deleteProduct(Long id);
    
}