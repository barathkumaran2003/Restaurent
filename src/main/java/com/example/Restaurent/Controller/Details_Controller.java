package com.example.Restaurent.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Restaurent.Service.Cart_Service;
import com.example.Restaurent.Service.Detail_Service;
import com.example.Restaurent.Service.Table_service;
import com.example.Restaurent.entity.Book_table;
import com.example.Restaurent.entity.Cart;
import com.example.Restaurent.entity.Details;

@Controller
public class Details_Controller 
{
	@Autowired
	private Detail_Service dServ;
	@Autowired
	private Cart_Service cServ;
	
	@Autowired
	private Table_service table_service;
	 @PostMapping("/details")
	 public String addBook(@RequestParam String email,@ModelAttribute Details b,Model model) {
			dServ.save(b);
			Details user = dServ.getUserByEmail(email); // Get user by email
            model.addAttribute("success", "Hii"+user.getFirstname());  
            model.addAttribute("successe", user.getFirstname());
            model.addAttribute("acname", user.getFirstname());
            model.addAttribute("lasten", user.getLastname());            
            model.addAttribute("acemail", user.getEmail());
            model.addAttribute("number", user.getNumber());
            model.addAttribute("typ", user.getType());
            model.addAttribute("fav", user.getFav());
            model.addAttribute("address", user.getAddress());
            model.addAttribute("about", user.getAbout());
            model.addAttribute("message", user.getMessage());
            
            List<Book_table> users = table_service.getAllUsers();
		    model.addAttribute("users", users);
		    List<Cart> users1 = cServ.getAllUsers();
		    model.addAttribute("users1", users1);
            return "accountd";
		}
	

}
