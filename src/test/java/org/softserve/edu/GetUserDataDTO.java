package org.softserve.edu;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.softserve.edu.controllers.RequestURI;
import org.softserve.edu.models.StatusCodes;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class GetUserDataDTO {

    @BeforeClass
    public void setup() {
        baseURI = RequestURI.BASE_URI;
        System.out.println("Run tests for UpdateUserDataDTO.class");
    }

    @BeforeMethod
    public void beforeRequest(Method method){
        String testName = method.getName();
        System.out.println("Running method "+ testName);
    }

    @Test(groups = "GET requests", testName = "successful GET /users/user_id")
    public void getUserDataById() {

        ValidatableResponse getUser =
                given().
                        get("/users/1").
                then().
                        statusCode(StatusCodes.OK).
                log().all();

        Response getUserResponse = getUser.
                extract().
                response();
/*
    'name' field from the response body to string
    Verify 'name' field from the response body and test street given
 */
        String responseName = getUserResponse.
                path("name");
        assertThat(responseName).
                isEqualTo("Leanne Graham");
/*
    'username' field from the response body to string
    Verify 'username' field from the response body and test street given
 */
        String responseUsername = getUserResponse.
                path("username");
        assertThat(responseUsername).
                isEqualTo("Bret");
/*
    'city' field from the response body to string
    Verify 'city' field from the response body and test street given
 */
        String responseCity = getUserResponse.
                path("address.city");
        assertThat(responseCity).
                isEqualTo("Gwenborough");

    }

    @Test(groups = "GET requests", testName = "count users in the response list GET /users")
    public void countUsersInResponseList(){

        ValidatableResponse getUserList =
                given().
                        get("/users").
                then().
                        statusCode(StatusCodes.OK);
/*
get /users response
 */
        Response getUsersListResponse = getUserList.
                extract().
                response();
/*
Get all users ids as a list and assert list is bigger than 5
 */
        List<Integer> ids = getUsersListResponse.jsonPath().getList("id");
        assertThat(ids.size()).isGreaterThan(5);
    }

    @AfterMethod
    public void afterRequest(Method method){
        String testName = method.getName();
        System.out.println("Finishing method "+ testName);
    }

    @AfterClass
    public void cleanUp(){
        System.out.println("All GET requests sent");
    }
}
