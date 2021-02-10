package com.mng.demo.service.Impl;

import com.mng.demo.model.Address;
import com.mng.demo.repository.AddressRepository;
import com.mng.demo.service.AddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address save(Address address) {
        address.setCity(address.getCity().toUpperCase());
        if(AddressisDefined(address))
        {
            return address;
        }
        return addressRepository.save(address);
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public boolean AddressisDefined(Address address) {
        List<Address> addressList=new ArrayList<>();
        addressList=addressRepository.findAll();
        for(int i=0;i<addressList.size();i++)
        {
            if(address.getCity().equals(addressList.get(i).getCity()) && address.getDistrict().equals(addressList.get(i).getDistrict()))
            {
                return true;
            }
        }
        return false;
    }
}
