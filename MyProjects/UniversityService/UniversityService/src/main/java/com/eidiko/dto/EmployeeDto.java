package com.eidiko.dto;

import java.util.List;

import com.eidiko.entity.Address;
import com.eidiko.entity.Role;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="empTable")
public class EmployeeDto {

	
	  private Integer id;
	    
	    private String username;
	    private String password;
	    private String email;
	    
	    @Enumerated(EnumType.STRING)
	    private Role role;
	    
	    @JsonManagedReference
	    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private List<Address> addresses;
}
