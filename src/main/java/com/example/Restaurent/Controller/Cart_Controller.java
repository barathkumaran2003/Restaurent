package com.example.Restaurent.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Restaurent.Service.Cart_Service;
import com.example.Restaurent.Service.Table_service;
import com.example.Restaurent.entity.Book_table;
import com.example.Restaurent.entity.Cart;

@Controller
public class Cart_Controller 
{
	@Autowired
	private Cart_Service cServ;
	
	@Autowired
	private Table_service table_service;
//	 @PostMapping("/add")
//	 public String addBook(@ModelAttribute Cart b, Model model) {
//			cServ.save(b);
//			 List<Cart> users1 = cServ.getAllUsers();
//			    model.addAttribute("users1", users1);
//			    List<Book_table> users = table_service.getAllUsers();
//			    model.addAttribute("users", users);
//			return "accountc";
//		}
	 @GetMapping("/deletea/{id}")  
	 public String deleteBook(@PathVariable long id,Model model,@ModelAttribute Book_table book_table) {  
	     cServ.deleteById(id);  
	     List<Cart> users1 = cServ.getAllUsers();
		    model.addAttribute("users1", users1);
		    List<Book_table> users = table_service.getAllUsers();
		    model.addAttribute("users", users);
	     return "accountc";  
	 }
	

}
