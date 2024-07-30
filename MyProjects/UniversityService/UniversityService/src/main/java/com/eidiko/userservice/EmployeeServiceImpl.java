package com.eidiko.userservice;

import com.eidiko.entity.Employee;
import com.eidiko.userrepository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class EmployeeServiceImpl  implements  EmployeeService{
    @Autowired
    private EmployeeRepo emprepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    boolean flag;
    @Override
    public String addUser(Employee employee) {

        List<Employee> userList = emprepository.findAll();

        if(null != userList) {
            for(Employee user : userList) {
                if(user.getUsername().equals(employee.getUsername()))
                    flag = true;
                else
                    flag = false;
            }
        }

        if(flag) {
            return "User already exists";
        } else {
            employee.setPassword(passwordEncoder.encode(employee.getPassword()));
            emprepository.save(employee);
            return "User saved";
        }
    }


}


