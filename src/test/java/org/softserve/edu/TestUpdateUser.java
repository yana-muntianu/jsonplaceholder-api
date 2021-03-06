package org.softserve.edu;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.softserve.edu.controllers.RequestURI;

import org.softserve.edu.models.StatusCodes;
import org.softserve.edu.testdata.placeholder.UserTestData;
import org.softserve.edu.utils.ConverterDTO;
import org.testng.annotations.*;

import java.lang.reflect.Method;

import java.util.LinkedHashMap;

import static io.restassured.RestAssured.*;
import static org.assertj.core.api.Assertions.assertThat;

public class TestUpdateUser {

    private static final Logger LOG = LogManager.getLogger(TestGetUser.class.getName());

    @BeforeMethod
    public void beforeRequest(Method method){
        String testName = method.getName();
        LOG.info("Running method "+ testName);
    }

    @Test (groups = "PUT requests", testName = "REST: PUT: Verify update user with valid data by valid ID")
    public void testUpdateUserWithValidData() {

            UserTestData updatedUserData = new UserTestData();

            String jsonInString = ConverterDTO.dtoToJsonString(updatedUserData);

            ValidatableResponse updateUser =
                    given().
                            contentType("application/json").
                            body(jsonInString).
                    when().
                            put(RequestURI.BASE_URI + "/users/9").
                    then().
                            statusCode(StatusCodes.OK);

            Response updateUserResponse = updateUser.
                    extract().
                    response();

//    'name' field from the response body to string Verify 'name' field from the response body and one from the User object

            String responseName = updateUserResponse.
                    path("name");
            assertThat(responseName).
                    isEqualTo(updatedUserData.getName());

//    'username' field from the response body to string  Verify 'username' field from the response body and one from the User object

            String responseUsername = updateUserResponse.
                    path("username");
            assertThat(responseUsername).
                    isEqualTo(updatedUserData.getUsername());

//    'email' field from the response body to string Verify 'email' field from the response body and one from the User object

            String responseEmail = updateUserResponse.
                    path("email");
            assertThat(responseEmail).
                    isEqualTo(updatedUserData.getEmail());

//    'phone' field from the response body to string Verify 'phone' field from the response body and one from the User object

            String responsePhone = updateUserResponse.
                    path("phone");
            assertThat(responsePhone).
                    isEqualTo(updatedUserData.getPhone());

//    'website' field from the response body to string Verify 'website' field from the response body and one from the User object

            String responseWebsite = updateUserResponse.
                    path("website");
            assertThat(responseWebsite).
                    isEqualTo(updatedUserData.getWebsite());

//    'address' field from the response body to string Verify 'address' field from the response body and map from the User object

            LinkedHashMap<String,Object> responseAddress = updateUserResponse.
                    path("address");
            assertThat(responseAddress).
                    isEqualTo(updatedUserData.getAddress());

//    'company' field from the response body to string Verify 'address' field from the response body and map from the User object

            LinkedHashMap<String,Object> responseCompany = updateUserResponse.
                    path("company");
            assertThat(responseCompany).
                    isEqualTo(updatedUserData.getCompany());

    }

    @Test (groups = "PUT requests", testName = "REST: PUT: Verify update user with valid data by invalid ID")
    public void testUpdateUserWithInvalidId(){

            UserTestData updatedUserData = new UserTestData();

            String jsonInString = ConverterDTO.dtoToJsonString(updatedUserData);

                    given().
                            contentType("application/json").
                            body(jsonInString).
                    when().
                            put(RequestURI.BASE_URI + "/users/18").
                    then().
                            statusCode(StatusCodes.NOT_FOUND).
                    log().all();

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
}
