package com.tiagodeveloper.model.input;

import javax.validation.constraints.NotBlank;

public class RecipientInput {

    @NotBlank
    private String name;

    @NotBlank
    private String address;

    @NotBlank
    private String number;

    @NotBlank
    private String complement;

    @NotBlank
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
