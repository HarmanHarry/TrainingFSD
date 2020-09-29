package com.eval.coronakit.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eval.coronakit.entity.CoronaKit;
import com.eval.coronakit.entity.KitDetail;
import com.eval.coronakit.entity.ProductMaster;
import com.eval.coronakit.exception.ProductException;
import com.eval.coronakit.service.CoronaKitService;
import com.eval.coronakit.service.KitDetailService;
import com.eval.coronakit.service.ProductService;



@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CoronaKitService coronaKitService;
	
	@Autowired
	KitDetailService kitDetailService;
	
	@RequestMapping("/home")
	public String home() {
		
		return "user-home";
	}
	
	@RequestMapping("/show-list")
	public String showList(Model model,HttpSession session) {
		model.addAttribute("allProducts", productService.getAllProducts());
		return "show-all-item-user";
	}
	
	@RequestMapping("/add-to-cart")
	public String showKit(@RequestParam(name="prods",required=false) String[] prods,@RequestParam(name="quantity", required=false) String[] productsQty,HttpSession session) {
		List<KitDetail> kitDetailList;
		kitDetailList=(List<KitDetail>)session.getAttribute("KitDetails");
		
		if(kitDetailList==null)
			 kitDetailList=new ArrayList<KitDetail>();
		
		List<String> prodsQty=new ArrayList<String>(Arrays.asList(productsQty));
		prodsQty.removeAll(Arrays.asList("0"));			
		
		if(prods!=null && prodsQty!=null) {
			for (int i = 0; i < prodsQty.size(); i++) {
				if(!prodsQty.get(i).equals("")) {
					ProductMaster prod = productService.getProductById(Integer.parseInt(prods[i]));
					int prodId=Integer.parseInt(prods[i]);
					KitDetail kit=null;
					boolean isProductPresnt=false;
					if(kitDetailList!=null) {
						for(int j=0;j<kitDetailList.size();j++) {
							if(kitDetailList.get(j).getProductId()==prodId) {
								kit=kitDetailList.get(j);
								kitDetailList.remove(j);
								isProductPresnt=true;
								break;
							}
						}
					}
					
					if(isProductPresnt) {
						kit.setQuantity(kit.getQuantity()+Integer.parseInt(prodsQty.get(i)));
					}					
					else {
						kit=new KitDetail();
						kit.setProductId(prod.getId());
						kit.setProductName(prod.getProductName());
						kit.setQuantity(Integer.parseInt(prodsQty.get(i)));
					}
					kit.setAmount(prod.getCost()*kit.getQuantity());
					kitDetailList.add(kit);
				}
			} 
			session.setAttribute("KitDetails", kitDetailList);
			}
		return "/show-cart";
	}
	
	@RequestMapping("/delete")
	public String deleteItem(@RequestParam("productId") int itemId,HttpSession session) {
		List<KitDetail> kitDetailList=(List<KitDetail>)session.getAttribute("KitDetails");

		for(KitDetail kit:kitDetailList) {
			if(kit.getProductId()==itemId) {
				kitDetailList.remove(kit);
				break;
			}		
		}
		session.setAttribute("KitDetails", kitDetailList);		
		return "show-cart";
	}
	
	@RequestMapping("/show-cart")
	public String showKit(HttpSession session,Model model) {	
		return "show-cart";
	}
	
	@RequestMapping("/checkout")
	public String Checkout(Model model) throws ProductException {
		model.addAttribute("coronaKit", new CoronaKit());
		return "checkout-address";
		
	}

	@PostMapping("/finalize")
	public String finalizeOrder(@ModelAttribute("coronataKit") @Valid CoronaKit coronaKit,BindingResult rs,Model model,HttpSession session) throws ProductException {
		String view=null;
		if (!rs.hasErrors()){		

		int totalAmount=0;
		KitDetail k;
		List<KitDetail> kitDetails=(List<KitDetail>)session.getAttribute("KitDetails");
		for(KitDetail kit:kitDetails) {
			totalAmount=totalAmount+kit.getAmount();
		}

		coronaKit.setOrderDate(LocalDate.now().toString());
		coronaKit.setTotalAmount(totalAmount);
		coronaKitService.saveKit(coronaKit);

		for(KitDetail kit:kitDetails) {			
			k= new KitDetail(coronaKit.getId(),kit.getProductId(),kit.getProductName(),kit.getQuantity(),kit.getAmount());
			kitDetailService.addKitItem(k);
		}
		
		kitDetails=kitDetailService.getAllKitItemsOfAKit(coronaKit.getId());
		model.addAttribute("KitDetails", kitDetails);
		session.setAttribute("TotalAmount", totalAmount);
		session.setAttribute("OrderID", coronaKit.getId());
		session.setAttribute("deliveryAddress", coronaKit.getDeliveryAddress());
		view= "show-summary";
		}
		else
		{
			view="checkout-address";
		}
		return view;
	}
	
	
}
