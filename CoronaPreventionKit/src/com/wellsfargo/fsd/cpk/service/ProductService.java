package com.wellsfargo.fsd.cpk.service;

import java.util.List;

import com.wellsfargo.fsd.cpk.entity.Product;
import com.wellsfargo.fsd.cpk.exception.ProductException;

public interface ProductService {

	Product validateAndAdd(Product prod) throws ProductException;
	Product validateAndSave(Product prod) throws ProductException;
	
	boolean deleteProducts(int prod) throws ProductException;
	
	Product getProducts(int prod) throws ProductException;
	List<Product> getAllProducts() throws ProductException;
}
