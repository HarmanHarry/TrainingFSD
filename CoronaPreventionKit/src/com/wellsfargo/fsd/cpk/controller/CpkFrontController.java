package com.wellsfargo.fsd.cpk.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wellsfargo.fsd.cpk.exception.ProductException;
import com.wellsfargo.fsd.cpk.service.ProductService;
import com.wellsfargo.fsd.cpk.service.ProductServiceImpl;
import com.wellsfargo.fsd.cpk.model.Product;


@WebServlet({ "/adminListProduct", "/adminDeleteProduct", "/adminNewProduct", "/adminAddProduct", "/adminEditProduct", "/adminSaveProduct","/login","/logout" })
public class CpkFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductService prodService;

	@Override
	public void init() throws ServletException {
		prodService = new ProductServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getServletPath();

		String view = "";

		switch (url) {
		case "/login":
			view = Login(request, response);
			break;
		//case "/logout":
			//view = Logout(request, response);
			//break;
		case "/adminListProduct":
			view = ListProducts(request, response);
			break;
		case "/adminDeleteProduct":
			view = DeleteProducts(request, response);
			break;
		case "/adminNewProduct":
			view = AddProducts(request, response);
			break;
		case "/adminAddProduct":
			view = CreateorSaveProducts(request, response);
			break;
		case "/adminEditProduct":
			view = EditProducts(request, response);
			break;
		case "/adminSaveProduct":
			view = CreateorSaveProducts(request, response);
			break;
		}

		request.getRequestDispatcher(view).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	private String Login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "";
		
		String uname="";
		String pwd="";
		
		uname=request.getParameter("uname");
		pwd=request.getParameter("password");	
		
		if(uname==null && pwd==null){
			view = "index.jsp";
		}
		else if(uname.equals("admin") && pwd.equals("admin")) {
				HttpSession session=request.getSession();
				session.setAttribute("user", "Admin");
				view = "adminListProduct";
			}
			else {
				request.setAttribute("errMsg", "invalid username or password");
				view = "index.jsp";
			}
				

		return view;
	}
	
//	private String Logout(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String view = "";
//		
//		HttpSession session=request.getSession();
//		session.invalidate();
//		
//		view = "index.jsp";
//		return view;
//	}



	private String ListProducts(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "";

		try {
			List<Product> prods = prodService.getAllProducts();
			request.setAttribute("prods", prods);
			view = "admin-listproducts.jsp";
		} catch (ProductException e) {
			request.setAttribute("errMsg", e.getMessage());
			view = "errorPage.jsp";
		}

		return view;
	}

	private String AddProducts(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "";

		Product prod = new Product();
		request.setAttribute("prod", prod);
		view = "prodFormPage.jsp";

		return view;
	}

	private String EditProducts(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "";

		int prodId = Integer.parseInt(request.getParameter("id"));
		try {
			Product prod = prodService.getProducts(prodId);
			request.setAttribute("prod", prod);
			view = "admin-editproduct.jsp";
		} catch (ProductException e) {
			request.setAttribute("errMsg", e.getMessage());
			view = "errorPage.jsp";
		}

		return view;
	}

	private String CreateorSaveProducts(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Product prod = new Product();
		
		prod.setId(Integer.parseInt(request.getParameter("id")));
		prod.setProductName(request.getParameter("pname"));
		prod.setProductDescription(request.getParameter("pdesc"));
		prod.setProductCost(Double.parseDouble(request.getParameter("pcost")));
		
		String view = "";
		
		try {
			
			if(request.getServletPath().equals("/adminAddProduct")) {
				prodService.validateAndAdd(prod);
				request.setAttribute("msg", "New Product Added Successfully!");
			}else {
				prodService.validateAndSave(prod);
				request.setAttribute("msg", "Product Details Modified Successfully!");
			}
						
			view="adminListProduct";
		} catch (ProductException e) {
			request.setAttribute("errMsg", e.getMessage());
			if(request.getServletPath().equals("/adminAddProduct"))
			view = "admin-newproduct.jsp";
			else
				view="admin-editproduct.jsp";
		}

		return view;
	}

	private String DeleteProducts(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "";
		int prodId = Integer.parseInt(request.getParameter("id"));
		try {
			prodService.deleteProducts(prodId);
			request.setAttribute("msg", "Product Deleted Successfully!");
			view = "adminListProduct";
		} catch (ProductException e) {
			request.setAttribute("errMsg", e.getMessage());
			view = "errorPage.jsp";
		}

		return view;
	}
}
