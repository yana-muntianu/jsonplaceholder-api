package org.softserve.edu.models;

import java.util.Arrays;
import java.util.Objects;

public class NewUser {

    private String name;
    private String username;
    private String email;
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private String[] address = {street,suite,city,zipcode};
    private String phone;
    private String website;
    private String companyName;
    private String catchPhrase;
    private String bs;
    private String[] company = {companyName,catchPhrase,bs};

    public NewUser(){
    }

    public NewUser(String name, String username, String email,
                   String[] address, String phone, String website,
                   String[] company){
        this.name = name;
        this.username = username;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.company = company;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String[] getAddress() {
        return address;
    }

    public void setAddress(String[] address) {
        this.address = address;
    }

    public String[] getCompany() {
        return company;
    }

    public void setCompany(String[] company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "NewUser{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", street='" + street + '\'' +
                ", suite='" + suite + '\'' +
                ", city='" + city + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", address=" + Arrays.toString(address) +
                ", phone='" + phone + '\'' +
                ", website='" + website + '\'' +
                ", companyName='" + companyName + '\'' +
                ", catchPhrase='" + catchPhrase + '\'' +
                ", bs='" + bs + '\'' +
                ", company=" + Arrays.toString(company) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewUser newUser = (NewUser) o;
        return name.equals(newUser.name) &&
                Objects.equals(username, newUser.username) &&
                Objects.equals(email, newUser.email) &&
                Objects.equals(street, newUser.street) &&
                Objects.equals(suite, newUser.suite) &&
                Objects.equals(city, newUser.city) &&
                Objects.equals(zipcode, newUser.zipcode) &&
                Arrays.equals(address, newUser.address) &&
                Objects.equals(phone, newUser.phone) &&
                Objects.equals(website, newUser.website) &&
                Objects.equals(companyName, newUser.companyName) &&
                Objects.equals(catchPhrase, newUser.catchPhrase) &&
                Objects.equals(bs, newUser.bs) &&
                Arrays.equals(company, newUser.company);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, username, email, street, suite, city,
                zipcode, phone, website, companyName, catchPhrase, bs);
        result = 31 * result + Arrays.hashCode(address);
        result = 31 * result + Arrays.hashCode(company);
        return result;
    }
}
