package com.example.Restaurent.Reporsitory;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Restaurent.entity.Book_table;
import com.example.Restaurent.entity.Details;

import jakarta.persistence.Column;

@Repository
public interface Table_Reporsitory extends JpaRepository<Book_table,Long>{
	List<Book_table> findByDob(LocalDate dob);

}
