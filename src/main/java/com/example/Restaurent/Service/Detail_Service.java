package com.example.Restaurent.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Restaurent.Reporsitory.Details_Reporsitory;
import com.example.Restaurent.entity.Details;

@Service
public class Detail_Service {
	
	@Autowired
	private Details_Reporsitory dRep;
	
	public void save(Details d)
	{
		dRep.save(d);
	}
	
	public Details getUserByEmail(String email) {
        return dRep.findByEmail(email); // Fetch user by email
    }
	public Details getUserBy(long id) {
        return dRep.findById(id); // Fetch user by email
    }

}
