package com.mng.demo.controller;

import com.mng.demo.model.Address;
import com.mng.demo.service.AddressService;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AddressControllerTest extends AbstractTest {

    @MockBean
    AddressService adressServiceMock;

    @Autowired
    private MockMvc mockMvc;

    @Override
    public void setUp() {
        super.setUp();
    }
    @Test
    public void saveAddress() throws Exception {
        String uri = "/address";
        Address address = new Address();
        address.setCity("istanbul");
        address.setDistrict("levent");

        Mockito.when(adressServiceMock.save(Mockito.any(Address.class))).thenReturn(address);


        String inputJson = super.mapToJson(address);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, inputJson);
    }

    @Test
    public void listAllAddresses() throws Exception {
        String uri = "/address";


        List<Address> addresses = new ArrayList<>();
        Address address = new Address();
        address.setCity("istanbul");
        address.setDistrict("beykoz");

        Address address1 = new Address();
        address1.setCity("istanbul");
        address1.setDistrict("levent");

        addresses.add(address);
        addresses.add(address1);

        Mockito.when(adressServiceMock.getAllAddresses()).thenReturn(addresses);

        String returningJson = super.mapToJson(addresses);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(returningJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, returningJson);
    }


}
