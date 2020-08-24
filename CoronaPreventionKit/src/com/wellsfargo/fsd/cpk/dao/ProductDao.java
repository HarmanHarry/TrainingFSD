package com.wellsfargo.fsd.cpk.dao;

import java.util.List;

import com.wellsfargo.fsd.cpk.entity.Product;
import com.wellsfargo.fsd.cpk.exception.ProductException;

public interface ProductDao {

	Product add(Product loan) throws ProductException;
	Product save(Product loan) throws ProductException;
	boolean deleteById(int loandId) throws ProductException;
	
	List<Product> getAll() throws ProductException;
	Product getById(int loanId) throws ProductException;
}
