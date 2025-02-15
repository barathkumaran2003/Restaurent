package com.example.Restaurent.Reporsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Restaurent.entity.Details;

@Repository
public interface Details_Reporsitory extends JpaRepository<Details, Long>{
	
	Details findByEmail(String email);
	Details findById(long id);
}
