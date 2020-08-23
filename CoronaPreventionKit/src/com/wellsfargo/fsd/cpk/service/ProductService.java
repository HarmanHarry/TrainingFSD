package com.wellsfargo.fsd.cpk.service;

import java.util.List;

import com.wellsfargo.fsd.cpk.exception.ProductException;
import com.wellsfargo.fsd.cpk.model.Product;

public interface ProductService {

	Product validateAndAdd(Product prod) throws ProductException;
	Product validateAndSave(Product prod) throws ProductException;
	
	boolean deleteProducts(int prod) throws ProductException;
	
	Product getProducts(int prod) throws ProductException;
	List<Product> getAllProducts() throws ProductException;
}
