package com.mng.demo.service;

import com.mng.demo.controller.AbstractTest;
import com.mng.demo.model.Address;
import com.mng.demo.repository.AddressRepository;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

public class AddressServiceTest extends AbstractTest {
    @MockBean
    private AddressRepository addressRepository;

    @Autowired
    private AddressService addressService;

    @Test
    public void saveAddress() {
        Address address = new Address();
        address.setCity("istanbul");
        address.setDistrict("beykoz");

        Mockito.when(addressRepository.save(address)).thenReturn(address);
        Assert.assertEquals(address,addressService.save(address));


    }

    @Test
    public void findAllAddresses() {
        List<Address> addresses = new ArrayList<>();
        Address address = new Address();
        address.setCity("İstanbul");
        address.setDistrict("beykoz");

        Address address1 = new Address();
        address.setCity("istanbul");
        address.setDistrict("levent");

        addresses.add(address);
        addresses.add(address1);

        Mockito.when(addressRepository.findAll()).thenReturn(addresses);
        Assert.assertEquals(addresses,addressService.getAllAddresses());


    }


}
