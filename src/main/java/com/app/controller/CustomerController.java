package com.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.pojos.Customer;
import com.app.pojos.DeliveryPartner;
import com.app.pojos.Orders;
import com.app.service.ICustomerService;

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

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private JavaMailSender sender;
	
	@Autowired
	private ICustomerService service;
	
	public CustomerController() {
		// TODO Auto-generated constructor stub
		System.out.println("in constructor of CustomerController ");
	}
	
	
	
	
	
	@GetMapping("/reg")
	public String showRegistrationPage() {
		System.out.println("in showRegistration page");
		return "/customer/customerreg";
	}
	
	@PostMapping("/reg")
	public String processRegisterForm(HttpServletRequest request,Model map) {
		System.out.println("in process registration form");
		try {
		Customer customer = new Customer();
		customer.setCname(request.getParameter("name").trim());
		customer.setCemail(request.getParameter("email").trim());
		customer.setCpassword(request.getParameter("conpass").trim());
		customer.setCmobile(request.getParameter("mobile").trim());
		customer.setCaddress(request.getParameter("address").trim());
		map.addAttribute("success", "**Customer registration successful");
		service.registerCustomer(customer);
		return "/customer/customerlogin";
		}
		catch (Exception e) {
			map.addAttribute("message" ,"**Details are already used , please enter valid details");
			return "/customer/customerreg";
		}
	}
	
	@GetMapping("/login")
	public String showCustomerPage() {
		return "/customer/customerlogin";
	}
	
	@PostMapping("/login")
	public String processLoginForm(@RequestParam String email , @RequestParam String pass , RedirectAttributes
			flashmap,Model map,HttpSession session ) {
		System.out.println("In process login form");
		try {
		
		 Customer customer = service.authenticateCustomer(email, pass);
		 session.setAttribute("customer_details", customer);
		
		flashmap.addFlashAttribute("message","Login Successful");
		System.out.println("login successful");
	
		return "/customer/customerhome";
		}
		catch(RuntimeException e){
			System.out.println("Login unsuccessful");
			map.addAttribute("error","**Invalid Email or password");
			return "/customer/customerlogin";
		}
	}
	
	@GetMapping("/placeorders")
	public String showPlaceOrders(Model map) {
		System.out.println("In Show place Orders");
		map.addAttribute("area", service.placeOrderArea());
		return "/customer/placeorders";
	}
	
	@PostMapping("/placeorders")
	public String processPlaceOrder(@RequestParam String pickup , @RequestParam String drop,
			@RequestParam String sender , @RequestParam String receiver,
			@RequestParam String area , @RequestParam String date , HttpSession session) throws ParseException {
		
		System.out.println("In process Place Order");
		Orders order = new Orders(pickup, drop, area, sender, receiver,new SimpleDateFormat("yyyy-MM-dd").parse(date));
		session.setAttribute("orderform", order);
		Customer c = (Customer)session.getAttribute("customer_details");
		
		System.out.println("Pickup "+ pickup+": drop :"+ drop +" area :" +area+" sender :" +sender+" receiver : area :  date "+date);
		
		Random r=new Random();
		String randomnumber=String.format("%04d", Integer.valueOf(r.nextInt(1001)));
		System.out.println(randomnumber);
		
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo(c.getCemail());//Destination Email
		message.setSubject("One Time Password");//Subject
		message.setText("Hello "+c.getCname()+", Your One Time Password For Placing Your Order is "+randomnumber);
		session.setAttribute("otp", randomnumber);
		this.sender.send(message);
		
		return "/customer/enterotp";
	}
	
	@PostMapping("/enterotp")
	public String processOTP(@RequestParam String otp,Integer cid,RedirectAttributes flashmap ,HttpSession session,Model map  	)throws Exception {
		System.out.println("In process OTP ");
		
		System.out.println(session.getAttribute("otp"));
		if(otp.equals(session.getAttribute("otp"))) {
			Orders order = (Orders)session.getAttribute("orderform");
			Customer customer = (Customer)session.getAttribute("customer_details");
			service.placeOrder(order,customer);
			DeliveryPartner d = service.getDeliveryPartner(order);
			map.addAttribute("dp_details",d);
			map.addAttribute("order_details",order);
			map.addAttribute("customer_details",customer);
			
			System.out.println("In sending mail...");
			
			System.out.println("Hello "+customer.getCname()+" , You have placed your order successfully  "
					+ "Your Order will be delivered by Our Partner " + d.getDname() + " Contact NO: "+ d.getDmobileno()
					+" Total Amount is to be paid is 200 RS");
			
			
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(customer.getCemail());
			message.setSubject("Successfully placed Order");
			message.setText("Hello "+customer.getCname()+" , You have placed your order successfully  "
					+ "Your Order will be delivered by Our Partner " + d.getDname() + " Contact NO: "+ d.getDmobileno()
					+" Total Amount is to be paid is 200 RS");
			sender.send(message);
			return "/customer/receipt";
		}
		return "/customer/enterotp";
	}
	
	
	
	@GetMapping("/customerprofile")
	public String showCustomerProfile() {
		System.out.println("In show Customer Profile");
		return "/customer/customerprofile";
	}
	
	@GetMapping("/customerhome")
	public String showCustomerProfile(Model map) {
		System.out.println("In place order form");
		map.addAttribute("area", service.placeOrderArea());
		return "/customer/customerhome";
	}
	
	@GetMapping("/myorders")
	public String showMyOrders(Model map) {
		
		map.addAttribute("orders",service.getMyOrders());
		System.out.println(service.getMyOrders());
		return "/customer/myorders";
	}
	
	@GetMapping("/update")
	public String showUpdateForm(HttpSession session) {
		Customer c  = (Customer)session.getAttribute("customer_details");
		System.out.println(c);
		
		return "/customer/update";
		
	}
	
	@PostMapping("/update/{cid}")
	public String processUpdateForm( @RequestParam String name ,@RequestParam String email , @RequestParam String mobile , @RequestParam String address , 
			HttpSession session) {
		
		System.out.println("In process update form ");
		Customer customer = (Customer)session.getAttribute("customer_details");
		
		Customer c = new Customer(customer.getCid(),name,email,mobile,address,customer.getCpassword() );
		System.out.println(c);
		session.setAttribute("customer_details", service.updateCustomer(c));
		
		
		return "/customer/customerprofile";
	}
	
	@GetMapping("/delete/{cid}")
	public String  deleteCustomer(@PathVariable int cid) {
		System.out.println("in delete customer ");
		service.deleteCustomer(cid); 
		return "/index";
	}
	
	@GetMapping("/logout") 
	public String customerLogout(HttpSession session, Model map, HttpServletRequest request, 
			HttpServletResponse response) {
		System.out.println("in customer's logout");
		// get user dtls from session scope n add it under model attribute
		map.addAttribute("user_details", session.getAttribute("customer_details"));
		// invalidate HttpSession
		session.invalidate();
		//set refresh header of HTTP resp
		response.setHeader("refresh", "5;url="+"http://localhost:8080/");
		return "/customer/customerlogout";// forward view name : /WEB-INF/view/user/logout.jsp
	}
	
	

}
