package org.softserve.edu;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.softserve.edu.controllers.RequestURI;
import org.softserve.edu.models.StatusCodes;
import org.softserve.edu.models.UserDataDTO;
import org.testng.annotations.*;

import java.lang.reflect.Method;

import java.io.IOException;
import java.util.LinkedHashMap;

import static io.restassured.RestAssured.*;
import static org.assertj.core.api.Assertions.assertThat;

public class UpdateUserDataDTO {

    private static final Logger LOG = LogManager.getLogger(GetUserDataDTO.class.getName());

    @BeforeMethod
    public void beforeRequest(Method method){
        String testName = method.getName();
        LOG.info("Running method "+ testName);
    }

    @Test (groups = "PUT requests", testName = "successful PUT /users/user_id")
    public void successfulUserUpdate() {

        try {

            ObjectMapper mapper = new ObjectMapper();
            UserDataDTO updatedUserData = updateUserData();

            String jsonInString = mapper.writeValueAsString(updatedUserData);
/*
    PUT /users/user_id -> update user with test data and log response
 */
            ValidatableResponse updateUser =
                    given().
                            contentType("application/json").
                            body(jsonInString).
                    when().
                            put(RequestURI.BASE_URI + "/users/9").
                    then().
                            statusCode(StatusCodes.OK);
/*
    Extract the response body
 */
            Response updateUserResponse = updateUser.
                    extract().
                    response();
/*
    'name' field from the response body to string
    Verify 'name' field from the response body and one from the User object
 */
            String responseName = updateUserResponse.
                    path("name");
            assertThat(responseName).
                    isEqualTo(updatedUserData.getName());
/*
    'username' field from the response body to string
    Verify 'username' field from the response body and one from the User object
 */
            String responseUsername = updateUserResponse.
                    path("username");
            assertThat(responseUsername).
                    isEqualTo(updatedUserData.getUsername());
/*
    'email' field from the response body to string
    Verify 'email' field from the response body and one from the User object
 */
            String responseEmail = updateUserResponse.
                    path("email");
            assertThat(responseEmail).
                    isEqualTo(updatedUserData.getEmail());
/*
    'phone' field from the response body to string
    Verify 'phone' field from the response body and one from the User object
 */
            String responsePhone = updateUserResponse.
                    path("phone");
            assertThat(responsePhone).
                    isEqualTo(updatedUserData.getPhone());
/*
    'website' field from the response body to string
    Verify 'website' field from the response body and one from the User object
 */
            String responseWebsite = updateUserResponse.
                    path("website");
            assertThat(responseWebsite).
                    isEqualTo(updatedUserData.getWebsite());
/*
    'address' field from the response body to string
    Verify 'address' field from the response body and map from the User object
 */
            LinkedHashMap<String,Object> responseAddress = updateUserResponse.
                    path("address");
            assertThat(responseAddress).
                    isEqualTo(updatedUserData.getAddress());
/*
    'company' field from the response body to string
    Verify 'address' field from the response body and map from the User object
 */
            LinkedHashMap<String,Object> responseCompany = updateUserResponse.
                    path("company");
            assertThat(responseCompany).
                    isEqualTo(updatedUserData.getCompany());

        } catch (IOException e) {
            LOG.error(e);
            e.printStackTrace();
        }
    }

    @Test (groups = "PUT requests", testName = "sent PUT /users/invalid_user_id")
    public void updateUserWithInvalidID(){
        try {

            ObjectMapper mapper = new ObjectMapper();
            UserDataDTO updatedUserData = updateUserData();

            String jsonInString = mapper.writeValueAsString(updatedUserData);
/*
    PUT /users/invalid_user_id -> update user with invalid id and verify Status Code
 */

                    given().
                            contentType("application/json").
                            body(jsonInString).
                    when().
                            put(RequestURI.BASE_URI + "/users/18").
                    then().
                            statusCode(StatusCodes.NOT_FOUND).
                    log().all();

        }catch (IOException e) {
            LOG.error(e);
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void afterRequest(Method method){
        String testName = method.getName();
        LOG.info("Finishing method "+ testName);
    }

    @AfterClass
    public void cleanUp(){
        LOG.info("All PUT requests sent");
    }

/*
    Create test User object with params
 */
    private static UserDataDTO updateUserData() {

        UserDataDTO updatedUserData = new UserDataDTO();

        updatedUserData.setName("Mary");
        updatedUserData.setUsername("maryleen");
        updatedUserData.setEmail("mary-16@gmail.com");

        LinkedHashMap<String, Object> userAddress = new LinkedHashMap<>();
        userAddress.put("street", "Baseline");
        userAddress.put("suite", "90");
        userAddress.put("city", "Ottawa");
        userAddress.put("zipcode", "CO3 KJ7");
        updatedUserData.setAddress(userAddress);

        updatedUserData.setPhone("123-639-091");
        updatedUserData.setWebsite("maryleen.com");

        LinkedHashMap<String, Object> userCompany = new LinkedHashMap<>();
        userCompany.put("companyName", "Apple");
        userCompany.put("catchPhrase", "catch phrase");
        userCompany.put("bs", "don't even know");
        updatedUserData.setCompany(userCompany);

        return updatedUserData;
    }
}
