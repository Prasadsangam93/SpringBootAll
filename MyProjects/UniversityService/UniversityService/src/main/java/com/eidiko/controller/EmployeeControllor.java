package com.eidiko.controller;

import com.eidiko.entity.Employee;
import com.eidiko.userservice.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/insert")
@RestController
@CrossOrigin
public class EmployeeControllor {

    @Autowired
    private EmployeeService empservice;

    @PostMapping("/employee")
    public ResponseEntity<String> addNewUser(@RequestBody Employee employee){
    	String pwd = employee.getPassword();
        System.out.println(pwd);
        String role = employee.getRole();
        System.out.println(role);
        String name = employee.getUsername();
        System.out.println(name);
        String email = employee.getEmail();
        System.out.println(email);
        return new ResponseEntity<String>(empservice.addUser(employee), HttpStatus.CREATED);
    }



}






