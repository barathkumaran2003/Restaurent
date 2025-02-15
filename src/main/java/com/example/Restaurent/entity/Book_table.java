package com.example.Restaurent.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="booktable")
public class Book_table {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
		private String name;
	    private String email;
	    private int person;
	    private LocalDate dob;
	    private String address;
	    
	    public Book_table() {};
		public Book_table(Long id, String name, String email, int person, LocalDate dob, String address) {
			super();
			this.id = id;
			this.name = name;
			this.email = email;
			this.person = person;
			this.dob = dob;
			this.address = address;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public int getPerson() {
			return person;
		}
		public void setPerson(int person) {
			this.person = person;
		}
		public LocalDate getDob() {
			return dob;
		}
		public void setDob(LocalDate dob) {
			this.dob = dob;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
	    
}
