package com.example.Restaurent.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Restaurent.Reporsitory.Table_Reporsitory;
import com.example.Restaurent.entity.Book_table;
import com.example.Restaurent.entity.Details;

@Service
public class Table_service {
	
	@Autowired
	private Table_Reporsitory table_repository;
	
	public void save(Book_table book_table)
	{
		table_repository.save(book_table);
	}
	public List<Book_table> getAllUsers() {
	    return table_repository.findAll(); // Ensure JPA Repository is used
	}
	public boolean isTableBooked(LocalDate dob) {
	    List<Book_table> existingBookings = table_repository.findByDob(dob);
	    return !existingBookings.isEmpty(); // ✅ Return true if booking exists
	}
	 public void deleteById(long id) {
			table_repository.deleteById(id);
		}
	
}
