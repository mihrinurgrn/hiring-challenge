package com.mng.demo.controller;

import com.mng.demo.model.Address;
import com.mng.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = { "http://localhost:3000"})
@RestController
public class AddressController {
    @Autowired
    AddressService addressService;

    @RequestMapping(value = {"/address"}, method = RequestMethod.POST)
    public Address saveAddress(@Valid @RequestBody Address address) {
        return addressService.save(address);
    }

    @RequestMapping(value = {"/address"}, method = RequestMethod.GET)
    public List<Address> getAllAddresses() {
        return addressService.getAllAddresses();
    }
}
