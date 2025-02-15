package com.example.Restaurent.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.Restaurent.entity.Book_table;
import com.example.Restaurent.entity.Cart;
import com.example.Restaurent.entity.Details;
import com.example.Restaurent.entity.Signin;

import jakarta.servlet.http.HttpSession;

import com.example.Restaurent.Service.Cart_Service;
import com.example.Restaurent.Service.Detail_Service;
import com.example.Restaurent.Service.Signin_Service;
import com.example.Restaurent.Service.Table_service;

@Controller
public class Signin_Controller 
{
	@Autowired
	private Signin_Service sServ;
	@Autowired
	private Cart_Service cServ;
	@Autowired
	private Table_service table_service;
	
	
	@GetMapping("/")
	public String home()
	{
		return "page";
	}
	  
	 @PostMapping("/singin")
	    public String addUser(@ModelAttribute Signin s, Model model) {
	        // Check if email already exists
	        if (sServ.getUserByEmail(s.getEmail()) != null) {
	            model.addAttribute("error", "Email already registered!");
	            return "page"; // Reloads the page with an error
	        }
	        sServ.save(s);
	        model.addAttribute("success", "Signup successful! You can now log in.");
	        return "page"; // Reload with 	a success message
	    }

	    // Handle Login
	    @PostMapping("/login")
	    public String loginUser(@RequestParam String email, @RequestParam String password,@ModelAttribute Signin s, Model model,HttpSession session) {
	        if (sServ.authenticateUser(email, password)) {
	        	Signin user = sServ.getUserByEmail(email); // Get user by email
	            model.addAttribute("success", "Hii "+user.getFirstname());  
	            model.addAttribute("successe", user.getFirstname());
	            model.addAttribute("acname", user.getFirstname());
	            model.addAttribute("acemail", user.getEmail());
	            session.setAttribute("name", user);
	            model.addAttribute("account", user.getFirstname());
	            return "home"; 
	        }
	        model.addAttribute("error", "Invalid Email or Password!");
	        return "page";
	    }
	    
	    
	    @GetMapping("/account")
		public String account(HttpSession session, Model model)
		{
	    	Signin user = (Signin) session.getAttribute("name");
	    	if (user == null) {
	            return "redirect:/login"; // Redirect to login if not authenticated
	        }
            model.addAttribute("successe", user.getFirstname());
	    	model.addAttribute("acname", user.getFirstname());
	        model.addAttribute("acemail", user.getEmail());
	        model.addAttribute("lasten", user.getLastname());
			return "account";
		}
	    
	    @GetMapping("/order")
		public String order(HttpSession session, Model model)
		{
	    	Signin user1 = (Signin) session.getAttribute("name");
	    	if (user1 == null) {
	            return "redirect:/login"; // Redirect to login if not authenticated
	        }
            model.addAttribute("successe", user1.getFirstname());
	    	model.addAttribute("acname", user1.getFirstname());
	        model.addAttribute("acemail", user1.getEmail());
	        model.addAttribute("lasten", user1.getLastname());
			return "account1";
		}
	    @PostMapping("/add")
	    public String add(HttpSession session, Model model,@ModelAttribute Cart b)
		{
	    	Signin user1 = (Signin) session.getAttribute("name");
	    	if (user1 == null) {
	            return "redirect:/login"; // Redirect to login if not authenticated
	        }
            model.addAttribute("successe", user1.getFirstname());
	    	model.addAttribute("acname", user1.getFirstname());
	        model.addAttribute("acemail", user1.getEmail());
	        model.addAttribute("lasten", user1.getLastname());
	        
	        cServ.save(b);
			 List<Cart> users1 = cServ.getAllUsers();
			    model.addAttribute("users1", users1);
			    List<Book_table> users = table_service.getAllUsers();
			    model.addAttribute("users", users);
			return "accountc";
		}
	    
	    @PostMapping("/table")
	    public String change(@RequestParam String email,@RequestParam LocalDate dob,HttpSession session, Model model,@ModelAttribute Book_table book_table)
	    {
	    	Signin user1 = (Signin) session.getAttribute("name");
	    	if (user1 == null) {
	            return "redirect:/login"; // Redirect to login if not authenticated
	        }
            model.addAttribute("successe", user1.getFirstname());
	    	model.addAttribute("acname", user1.getFirstname());
	        model.addAttribute("acemail", user1.getEmail());
	        model.addAttribute("lasten", user1.getLastname());
	        
			 if (table_service.isTableBooked(dob)) {
		            model.addAttribute("errorMessage", "Table already booked on this date!");
		            return "home";  // ✅ Return to the same page with an error message
		        }
	        
	        table_service.save(book_table);
		    List<Book_table> users = table_service.getAllUsers();
		    model.addAttribute("users", users);
		    List<Cart> users1 = cServ.getAllUsers();
		    model.addAttribute("users1", users1);
		    
			return "account1";
	    }
//	    @GetMapping("/details")
//		public String account1(HttpSession session, Model model)
//		{
//	    	
//	    	Details user1 = (Details) session.getAttribute("name");
//	    	if (user1 == null) {
//	            return "redirect:/login"; // Redirect to login if not authenticated
//	        }
//	    	model.addAttribute("acname", user1.getFirstname());
//	        model.addAttribute("acemail", user1.getEmail());
//	        model.addAttribute("lasten", user1.getLastname());
//            model.addAttribute("num", user1.getNumber());
//	    	model.addAttribute("typ", user1.getType());
//	        model.addAttribute("fav", user1.getFav());
//	        model.addAttribute("about", user1.getAbout());
//	        model.addAttribute("address", user1.getAddress());
//	        model.addAttribute("message", user1.getMessage());
//			return "account1";
//		}
//	    @GetMapping("/login")
//	    public String getName(@PathVariable("email") String email, Model model)
//	    {
//	    	Signin s=sServ.getUserByEmail(email);
//	    	model.addAttribute("details","barath");
//			return "home";
//	    	
//	    }
//	    @GetMapping("/login")
//	    public String loginUser1(@RequestParam String email, @RequestParam String password,@ModelAttribute Signin s, Model model) {
//	        if (sServ.authenticateUser(email, password)) {
//	        	Signin user = sServ.getUserByEmail(email); // Get user by email
//	            model.addAttribute("success", "Hii"+user.getFirstname());  
//	            model.addAttribute("successe", user.getFirstname());
//	            model.addAttribute("proname", user.getFirstname());
//	            model.addAttribute("proemail", user.getEmail());
//	            return "account"; 
//	        }
//	        model.addAttribute("error", "Invalid Email or Password!");
//	        return "page";
//	    }
}
//	    public String loginUser1(@RequestParam String email, @RequestParam String password,@ModelAttribute Signin s, Model model) {
//	        if (sServ.authenticateUser(email, password)) {
//	        	Signin user = sServ.getUserByEmail(email); // Get user by email
//	            model.addAttribute("success", "Hii"+user.getFirstname());  
//	            model.addAttribute("successe", user.getFirstname());
//	            model.addAttribute("proname", user.getFirstname());
//	            model.addAttribute("proemail", user.getEmail());
//	            return "account"; 
//	        }
//	        model.addAttribute("error", "Invalid Email or Password!");
//	        return "page";
//	    }

		  

