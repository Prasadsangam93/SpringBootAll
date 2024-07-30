package com.eidiko.userservice;

import com.eidiko.entity.Address;
import com.eidiko.exception.AddressNotFoundException;

import java.util.List;

public interface AddressService {
        public Address saveAddress (Address address);
        public List<Address> fetchAllAddress ();
        public Address fetchAddress(Integer id) throws AddressNotFoundException;

    }
