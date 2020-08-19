package org.softserve.edu.apitests;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.softserve.edu.controllers.RequestURI;
import org.softserve.edu.models.StatusCodes;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.assertj.core.api.Assertions.assertThat;

public class TestGetUser {

    private static final Logger LOG = LogManager.getLogger(TestGetUser.class.getName());

    // TODO implement before/after methods as a separate class with extension

    @BeforeMethod
    public void beforeRequest(Method method){
        String testName = method.getName();
        LOG.info("Running method "+ testName);
    }

    @Test(groups = "GET requests", testName = "REST: GET: Verify get user by valid ID")
    public void testGetUserByValidId() {

        ValidatableResponse getUser =
                given().
                        get(RequestURI.BASE_URI + "/users/1").
                then().
                        statusCode(StatusCodes.OK);

        Response getUserResponse = getUser.
                extract().
                response();

//    'name' field from the response body to string Verify 'name' field from the response body and test street given

        String responseName = getUserResponse.
                path("name");
        assertThat(responseName).
                isEqualTo("Leanne Graham");

//    'username' field from the response body to string Verify 'username' field from the response body and test street given

        String responseUsername = getUserResponse.
                path("username");
        assertThat(responseUsername).
                isEqualTo("Bret");

//    'city' field from the response body to string Verify 'city' field from the response body and test street given


        String responseCity = getUserResponse.
                path("address.city");
        assertThat(responseCity).
                isEqualTo("Gwenborough");

    }

    @Test(groups = "GET requests", testName = "REST: GET: Verify list of users in response and count its length")
    public void testCountUsersInResponseList(){

        ValidatableResponse getUserList =
                given().
                        get(RequestURI.BASE_URI + "/users").
                then().
                        statusCode(StatusCodes.OK);

        Response getUsersListResponse = getUserList.
                extract().
                response();

//Get all users ids as a list and assert list is bigger than 5

        List<Integer> ids = getUsersListResponse.jsonPath().getList("id");
        assertThat(ids.size()).isGreaterThan(5);
    }

    @AfterMethod
    public void afterRequest(Method method){
        String testName = method.getName();
        LOG.info("Finishing method "+ testName);
    }

    @AfterClass
    public void cleanUp(){
        LOG.info("All GET requests sent");
    }
}
