package com.example.Restaurent.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Restaurent.Service.Cart_Service;
import com.example.Restaurent.Service.Detail_Service;
import com.example.Restaurent.Service.Table_service;
import com.example.Restaurent.entity.Book_table;
import com.example.Restaurent.entity.Cart;
import com.example.Restaurent.entity.Details;
import com.example.Restaurent.entity.Signin;

import jakarta.servlet.http.HttpSession;

import org.springframework.ui.Model;

@Controller
public class Table_Controller {
	@Autowired
	private Table_service table_service;
	
	@Autowired
	private Cart_Service cServ;
	

	
//	 @PostMapping("/table")
//    public String change(@RequestParam String email,@RequestParam LocalDate dob,HttpSession session, Model model,@ModelAttribute Book_table book_table)
//    {
//		 if (table_service.isTableBooked(dob)) {
//	            model.addAttribute("errorMessage", "Table already booked on this date!");
//	            return "home";  // ✅ Return to the same page with an error message
//	        }
//        
//        table_service.save(book_table);
//	    List<Book_table> users = table_service.getAllUsers();
//	    model.addAttribute("users", users);
//	    
//		return "account1";
//    }
	 @GetMapping("/delete/{id}")  
	 public String deleteBook(@PathVariable long id,Model model,@ModelAttribute Book_table book_table) {  
	     table_service.deleteById(id);  
	     List<Book_table> users = table_service.getAllUsers();
		    model.addAttribute("users", users);
		    List<Cart> users1 = cServ.getAllUsers();
		    model.addAttribute("users1", users1);
	     return "account1";  
	 }


	

}
