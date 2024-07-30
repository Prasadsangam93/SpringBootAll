package com.eidiko.userservice;

import com.eidiko.config.EmployeeUserDetails;
import com.eidiko.entity.Employee;
import com.eidiko.userrepository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class EmployeeUserDetailsService implements UserDetailsService {
    @Autowired
    private EmployeeRepo emprepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Employee> employee = emprepository.findByUsername(username);
        return employee.map(EmployeeUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));

    }
}


