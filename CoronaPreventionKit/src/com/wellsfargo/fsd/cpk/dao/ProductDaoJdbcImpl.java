package com.wellsfargo.fsd.cpk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wellsfargo.fsd.cpk.entity.Product;
import com.wellsfargo.fsd.cpk.exception.ProductException;

public class ProductDaoJdbcImpl implements ProductDao {

	public static final String INS_LN_QRY = "INSERT INTO products(prodId,prodName,prodDesc,prodCost) VALUES(?,?,?,?)";
	public static final String UPD_LN_QRY = "UPDATE products SET prodName=?,prodDesc=?,prodCost=? WHERE prodId=?";
	public static final String DEL_LN_QRY = "DELETE FROM products WHERE prodId=?";
	public static final String GET_BY_ID_LN_QRY = "SELECT prodId,prodName,prodDesc,prodCost FROM products WHERE prodId=?";
	public static final String GET_ALL_LNS_QRY = "SELECT prodId,prodName,prodDesc,prodCost FROM products";

	public Product add(Product prod) throws ProductException {
		if (prod != null) {
			try (Connection con = ConnectionFactory.getConnection();
					PreparedStatement pst = con.prepareStatement(INS_LN_QRY);) {

				pst.setInt(1, prod.getId());
				pst.setString(2, prod.getProductName());
				pst.setString(3, prod.getProductDescription());
				pst.setDouble(4, prod.getProductCost());

				pst.executeUpdate();

			} catch (SQLException exp) {
				throw new ProductException("An error occured, Could not add the product details!");
			}
		}
		return prod;
	}

	public Product save(Product prod) throws ProductException {
		if (prod != null) {
			try (Connection con = ConnectionFactory.getConnection();
					PreparedStatement pst = con.prepareStatement(UPD_LN_QRY);) {
				
				pst.setString(1, prod.getProductName());
				pst.setString(2, prod.getProductDescription());
				pst.setDouble(3, prod.getProductCost());
				pst.setInt(4, prod.getId());

				pst.executeUpdate();

			} catch (SQLException exp) {
				throw new ProductException("An error occured, Could not save the product details!");
			}
		}
		return prod;
	}

	public boolean deleteById(int proddId) throws ProductException {
		boolean isDeleted = false;

		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement pst = con.prepareStatement(DEL_LN_QRY);) {

			pst.setInt(1, proddId);

			int rowsCount = pst.executeUpdate();
			
			isDeleted= rowsCount>0 ;

		} catch (SQLException exp) {
			throw new ProductException("An error occured, Could not delete the product details!");
		}

		return isDeleted;
	}

	public List<Product> getAll() throws ProductException {
		List<Product> prods = new ArrayList<>();
		
		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement pst = con.prepareStatement(GET_ALL_LNS_QRY);) {		

			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Product prod = new Product();
				prod.setId(rs.getInt(1));
				prod.setProductName(rs.getString(2));
				prod.setProductDescription(rs.getString(3));
				prod.setProductCost(rs.getDouble(4));
				
				prods.add(prod);
			}
			
			if(prods.isEmpty()) {
				prods=null;
			}
		} catch (SQLException exp) {
			throw new ProductException("An error occured, Could not retrive the product details!");
		}
				
		return prods;
	}

	public Product getById(int prodId) throws ProductException {
		Product prod=null;
		
		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement pst = con.prepareStatement(GET_BY_ID_LN_QRY);) {		

			pst.setInt(1, prodId);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				prod = new Product();
				prod.setId(rs.getInt(1));
				prod.setProductName(rs.getString(2));
				prod.setProductDescription(rs.getString(3));
				prod.setProductCost(rs.getDouble(4));
			}
			
		} catch (SQLException exp) {
			throw new ProductException("An error occured, Could not retrive the product details!");
		}
		
		return prod;
	}

}
