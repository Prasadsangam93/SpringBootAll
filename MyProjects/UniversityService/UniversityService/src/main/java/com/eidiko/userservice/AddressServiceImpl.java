package com.eidiko.userservice;

import com.eidiko.entity.Address;
import com.eidiko.exception.AddressNotFoundException;
import com.eidiko.userrepository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Primary

public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepo addRepository;


    boolean flag;
    @Override
    public Address saveAddress(Address address) {
        return addRepository.save(address);
    }

    @Override
    public List<Address> fetchAllAddress() {
        List<Address> data=null;
        data= addRepository.findAll();
        System.out.println("fetchdata"+data);
        return data;
    }

    @Override
    public Address fetchAddress(Integer id) throws  AddressNotFoundException {

      Address address = null;
        if(id != null && id != 0) {
            flag = addRepository.existsById(id);
        }
        if(flag)
            address = addRepository.findById(id).get();
        else
            throw new AddressNotFoundException("Address Not Found");
        return address;
    }


}