package com.eidiko.controller;

import com.eidiko.authReq.AuthRequest;
import com.eidiko.entity.Address;
import com.eidiko.exception.AddressNotFoundException;
import com.eidiko.userservice.AddressService;
import com.eidiko.userservice.JwtService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empAddress")

public class AddressController {
    @Autowired
    private AddressService addService;



   // @Autowired

    @PostMapping("/save")
    public ResponseEntity<Address> saveAddress(@Valid @RequestBody Address address) {
        return new ResponseEntity<Address>(addService.saveAddress(address), HttpStatus.CREATED);
    }

    @GetMapping("/fetchAll")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<Address>> getAllAddress() {

        return new ResponseEntity<List<Address>>(addService.fetchAllAddress(), HttpStatus.CREATED);
    }

    @GetMapping("/fetch/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public Address getAddress(@PathVariable Integer id) throws AddressNotFoundException {
        return addService.fetchAddress(id);
    }
}

