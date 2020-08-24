package com.wellsfargo.fsd.cpk.service;

import java.util.ArrayList;
import java.util.List;

import com.wellsfargo.fsd.cpk.exception.ProductException;
import com.wellsfargo.fsd.cpk.dao.ProductDao;
import com.wellsfargo.fsd.cpk.dao.ProductDaoJdbcImpl;
import com.wellsfargo.fsd.cpk.entity.Product;

public class ProductServiceImpl implements ProductService {
	
	ProductDao prodDao;
	
	public ProductServiceImpl() {
		prodDao=new ProductDaoJdbcImpl();
	}

	private boolean isValidProdId(Integer proadId) {
		return proadId!=null && proadId>0;
	}
	
	private boolean isValidProdName(String prodName) {
		return prodName!=null && (prodName.length()>=3 && prodName.length()<=20);
	}
	
	private boolean isValidProdCost(Double proadCost) {
		return proadCost!=null && proadCost>0;
	}
	
	private boolean isValidProduct(Product prod) throws ProductException{
		boolean isValid=true;
		
		List<String> errMsgs = new ArrayList<>();
		
		if(prod!=null) {
			if(!isValidProdId(prod.getId())) {
				isValid=false;
				errMsgs.add("Product Id must be a positive non-repetative number");
			}
			if(!isValidProdName(prod.getProductName())) {
				isValid=false;
				errMsgs.add("Product Name must be of 3 to 20 chars in length");
			}
			if(!isValidProdCost(prod.getProductCost())) {
				isValid=false;
				errMsgs.add("Product Cost must be a postive non-zero number");
			}
			if(!errMsgs.isEmpty()) {
				throw new ProductException(errMsgs.toString());
			}
		}else {
			isValid=false;
		}
		
		return isValid;
	}
	
	@Override
	public Product validateAndAdd(Product prod) throws ProductException {
		if(isValidProduct(prod)) {
			prodDao.add(prod);
		}
		return prod;
	}

	@Override
	public Product validateAndSave(Product prod) throws ProductException {
		if(isValidProduct(prod)) {
			prodDao.save(prod);
		}
		return prod;
	}

	@Override
	public boolean deleteProducts(int prodId) throws ProductException {
		return prodDao.deleteById(prodId);
	}

	@Override
	public Product getProducts(int prodId) throws ProductException {
		return prodDao.getById(prodId);
	}

	@Override
	public List<Product> getAllProducts() throws ProductException {
		return prodDao.getAll();
	}

}
