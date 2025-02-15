package com.example.Restaurent.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Restaurent.Reporsitory.Cart_Reporsitory;
import com.example.Restaurent.entity.Book_table;
import com.example.Restaurent.entity.Cart;
import com.example.Restaurent.entity.Signin;

@Service
public class Cart_Service {
	
	@Autowired
	private Cart_Reporsitory cRep;
	
	public void save(Cart c) {
        cRep.save(c);
    }
	 public List<Cart> getAllUsers() {
	        return cRep.findAll();
	    }

	    public void deleteById(long id) {
	        cRep.deleteById(id);
	    }
}
