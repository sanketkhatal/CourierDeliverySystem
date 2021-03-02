package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Admin;

import com.app.service.IAdminService;


@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private IAdminService service;
	
	public AdminController() {
		// TODO Auto-generated constructor stub
		System.out.println("In constructor of AdminController");
	}
	
	@GetMapping("/login")
	public String showDeliveryPage() {
		System.out.println("In show delivery page");
		return "/admin/adminlogin";
	}
	
	@PostMapping("/login")
	public String processLoginForm(@RequestParam String email , @RequestParam String pass , RedirectAttributes
			flashmap,Model map,HttpSession session ) {
		System.out.println("In Admin process login form");
		try {
		
		 Admin admin = service.authenticateAdmin(email, pass);
		 session.setAttribute("admin_details", admin);
		
		flashmap.addFlashAttribute("message","Login Successful");
		System.out.println("login successful");
		return "/admin/adminhome";
		}
		catch(RuntimeException e){
			System.out.println("Login unsuccessful");
			map.addAttribute("error","**Invalid Email or password");
			return "/admin/adminlogin";
		}
	}
	
	
	@GetMapping("/allcustomer")
	public String getAllCustomers(Model map ) {
		map.addAttribute("all_customers" , service.getAllCustomers());
		
		return "/admin/getallcustomer";
	}
	
	@GetMapping("/allpartners")
	public String getAllPartners(Model map ) {
		map.addAttribute("all_partners" , service.getAllPartners());
		
		return "/admin/getallpartners";
	}
	
	@GetMapping("/allorders")
	public String getAllOrders(Model map) {
		map.addAttribute("all_orders",service.getAllOrders());
		
		
		return "/admin/getallorders";
	}
	
	@GetMapping("/deletecustomer/{cid}") 
	public String deleteCustomer(@PathVariable int cid) {
		
		System.out.println("In delete customer ");
		service.deleteCustomer(cid);
		return "/admin/getallcustomer";
	}
	
	@GetMapping("/deletepartner/{did}") 
	public String deletePartner(@PathVariable int did) {
		
		System.out.println("In delete customer ");
		service.deletePartner(did);
		return "/admin/getallpartners";
	}
	
	
	
	
	
	

	@GetMapping("/logout") 
	public String adminLogout(HttpSession session, Model map, HttpServletRequest request, 
			HttpServletResponse response) {
		System.out.println("in admin logout");
		// get user dtls from session scope n add it under model attribute
		map.addAttribute("user_details", session.getAttribute("admin_details"));
		// invalidate HttpSession
		session.invalidate();
		//set refresh header of HTTP resp
		response.setHeader("refresh", "5;url="+"http://localhost:8080/");
		return "/admin/adminlogout";// forward view name : /WEB-INF/view/user/logout.jsp
	}
	
	

}
