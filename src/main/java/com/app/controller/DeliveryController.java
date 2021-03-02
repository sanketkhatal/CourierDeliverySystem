package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Customer;
import com.app.pojos.DeliveryPartner;
import com.app.service.IPartnerService;

@Controller
@RequestMapping("/delivery")
public class DeliveryController {
	
	@Autowired
	private JavaMailSender sender;
	
	@Autowired
	private IPartnerService service;
	
	public DeliveryController() {
		// TODO Auto-generated constructor stub
		System.out.println("in contructor of delivery controller");
	}
	
	@GetMapping("/login")
	public String showDeliveryPage() {
		return "/delivery/deliverylogin";
	}
	
	
	@GetMapping("/reg")
	public String showRegistrationPage() {
		System.out.println("In show Registration page");
		return "/delivery/deliveryreg";
	}
	
	
	@PostMapping("/reg")
	public String processRegisterForm(@RequestParam String name,@RequestParam String email,@RequestParam String pass,
			@RequestParam String mobile,@RequestParam String area,@RequestParam String license,  Model map) {
		try {
		System.out.println("in process registration form");
		DeliveryPartner d = new DeliveryPartner(name,email,pass,mobile,area,license );

		map.addAttribute("success", "**Delivery Partner registration successful");
		String messgae= service.registerPartner(d);
		System.out.println(messgae);
		return "/delivery/deliverylogin";
		
		}
		catch (Exception e) {
			map.addAttribute("error" ,"**Details are already used , please enter valid details");
			return "/delivery/deliveryreg";
		}
	}
	
	@PostMapping("/login")
	public String processLoginForm(@RequestParam String email , @RequestParam String pass , RedirectAttributes
			flashmap,Model map,HttpSession session ) {
		System.out.println("In delivery process login form");
		try {
		
		 DeliveryPartner partner = service.authenticatePartner(email, pass);
		 session.setAttribute("delivery_details", partner);
		
		flashmap.addFlashAttribute("message","Login Successful");
		System.out.println("login successful");
		return "/delivery/deliveryhome";
		}
		catch(RuntimeException e){
			System.out.println("Login unsuccessful");
			map.addAttribute("error","**Invalid Email or password");
			return "/delivery/deliverylogin";
		}
	}
	
	@GetMapping("/deliveryhome")
	public String showDeliveryHome() {
		System.out.println("In show Delivery Home");
		return "/delivery/deliveryhome";
	}
	
	@GetMapping("/deliveryprofile")
	public String showDeliveryProfile() {
		System.out.println("In show deliveryProfile");
		return "/delivery/deliveryprofile";
	}
	
	@GetMapping("/deliveryorders") 
	public String showOrders(HttpSession session, Model map ) {
		DeliveryPartner d = (DeliveryPartner)session.getAttribute("delivery_details");
		
		map.addAttribute("order_list",service.getorders(d.getDid()));
		//System.out.println(service.getorders(d.getDid()));
		return "/delivery/deliveryorders";
	}
	
	@GetMapping("/pendingorders")
	public String getPendingOrders(HttpSession session, Model map) {
		DeliveryPartner d = (DeliveryPartner)session.getAttribute("delivery_details");
		
		map.addAttribute("pending_orders",service.getPendingOrders(d.getDid()));
		return "/delivery/pendingorders";
	}
	
	@GetMapping("/updateorderstatus")
	public String updateOrderStatus(@RequestParam int orderId , HttpSession session) {
		System.out.println("In update Order status");
		Customer c = service.getCustomerDetails(orderId);
		
		//System.out.println(service.getCustomerDetails(orderId));
		service.updateOrderStatus(orderId);
		DeliveryPartner d = (DeliveryPartner)session.getAttribute("delivery_details");
		System.out.println("In sending mail process");
		session.setAttribute("delivery_details", service.updateEarning(d.getDid()));
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(c.getCemail());
		message.setSubject("Order delivered Successfully");
		String text = "Hello, "+c.getCname() + " your order has been delivered successfully by our Delivery partner : " +d.getDname() + " thank you ";
		message.setText(text);
		sender.send(message);
		return "/delivery/pendingorders";
	}
	
	@GetMapping("/delete/{did}")
	public String deleteDeliveryPartner(@PathVariable int did) {
		System.out.println("in delete deliery partner ");
		service.deletePartner(did); 
		return "/index";
	}
	
	@GetMapping("/update")
	public String showUpdateForm() {
		
		return  "/delivery/update";
	}
	
	@PostMapping("/update/{did}")
	public String processUpdateForm(@RequestParam String name , @RequestParam String email , @RequestParam String mobile , 
			@RequestParam String area , @RequestParam String licenceno ,HttpSession session) {
		System.out.println("In process Update form");
		
		DeliveryPartner partner = (DeliveryPartner) session.getAttribute("delivery_details");
		DeliveryPartner d = new DeliveryPartner(partner.getDid() , name , email , mobile , area , licenceno);
		session.setAttribute("delivery_details", service.updatePartner(d));
		
		return "/delivery/deliveryprofile";
		
	}
	

	
	@GetMapping("/logout") 
	public String deliveryLogout(HttpSession session, Model map, HttpServletRequest request, 
			HttpServletResponse response) {
		System.out.println("in delivery's logout");
		// get user dtls from session scope n add it under model attribute
		map.addAttribute("user_details", session.getAttribute("delivery_details"));
		// invalidate HttpSession
		session.invalidate();
		//set refresh header of HTTP resp
		response.setHeader("refresh", "5;url="+"http://localhost:8080/");
		return "/delivery/deliverylogout";// forward view name : /WEB-INF/view/user/logout.jsp
	}
	

}
