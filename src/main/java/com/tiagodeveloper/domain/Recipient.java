package com.tiagodeveloper.domain;

import javax.persistence.*;

@Embeddable
public class Recipient {

    @Column(name = "recipient_name")
    private String name;

    @Column(name = "address_name")
    private String address;

    @Column(name = "recipient_number")
    private String number;

    @Column(name = "recipient_complement")
    private String complement;

    @Column(name = "recipient_district")
    private String district;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
