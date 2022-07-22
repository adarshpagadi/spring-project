package com.example.demo.model;


import java.io.Serializable;

import javax.persistence.*;
import lombok.AllArgsConstructor;
//import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Student implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	//NotBlank(message = "Student name cannot be blank")
	private String name;
	private String address;
	public Integer getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
