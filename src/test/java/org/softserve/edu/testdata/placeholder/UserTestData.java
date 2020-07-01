package org.softserve.edu.testdata.placeholder;

import org.softserve.edu.models.UserDataDTO;

import java.util.LinkedHashMap;

public class UserTestData extends UserDataDTO {

    public UserTestData testUser(){

        setName("Mary");
        setUsername("maryleen");
        setEmail("mary-16@gmail.com");

        LinkedHashMap<String, Object> userAddress = new LinkedHashMap<>();
        userAddress.put("street", "Baseline");
        userAddress.put("suite", "90");
        userAddress.put("city", "Ottawa");
        userAddress.put("zipcode", "CO3 KJ7");
        setAddress(userAddress);

        setPhone("123-639-091");
        setWebsite("maryleen.com");

        LinkedHashMap<String, Object> userCompany = new LinkedHashMap<>();
        userCompany.put("companyName", "Apple");
        userCompany.put("catchPhrase", "catch phrase");
        userCompany.put("bs", "don't even know");
        setCompany(userCompany);

        return new UserTestData();
    }
}
