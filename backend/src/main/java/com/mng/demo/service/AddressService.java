package com.mng.demo.service;

import com.mng.demo.model.Address;

import java.util.List;

public interface AddressService {
    Address save(Address user);
    List<Address> getAllAddresses();
}
