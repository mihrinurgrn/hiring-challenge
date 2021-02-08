package com.mng.demo.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;

    @NotBlank(message = "Please provide a name")
    private String district;

    @NotBlank(message = "City is mandatory")
    private String city;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer adressId) {
        this.addressId = adressId;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
