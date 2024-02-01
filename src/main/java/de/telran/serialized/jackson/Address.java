package de.telran.serialized.jackson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {
    private  int countryCode;
    private  String city;
    private  String street;

    public Address(int countryCode, String city, String street) {
        this.countryCode = countryCode;
        this.city = city;
        this.street = street;
    }

    public Address() {
    }

    @Override
    public String toString() {
        return "Address{" +
                "countryCode=" + countryCode +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }

    public int getCountryCode() {
        return countryCode;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }
}
